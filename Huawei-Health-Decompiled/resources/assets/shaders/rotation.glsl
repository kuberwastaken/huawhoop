precision highp float;
varying vec2 uv;
uniform int inputWidth;
uniform int inputHeight;

uniform float processBar;
uniform sampler2D inputTexture;

#define PI 3.14159265
#define ANGLE -0.5 * PI // 角度取反实现顺时针旋转

vec2 rotate(vec2 uv,vec2 center,float angle)
{
    float cos=cos(angle);
    float sin=sin(angle);
    mat3 rotateMat=mat3(cos,-sin,0.0,
                        sin,cos,0.0,
                        0.0,0.0,1.0);
    vec3 deltaOffset;
    deltaOffset = rotateMat*vec3(uv.x- center.x,uv.y- center.y,1.0);
	vec2 resule;
    resule.x = deltaOffset.x+center.x;
    resule.y = deltaOffset.y+center.y;
    return resule;
}

vec2 zoomNear(vec2 uv, float process){
	vec2 UV = vec2(0.0);
	if(process < 0.5){
		UV = 0.5 + ((uv - 0.5)*(1.0 - process)); // 1->0.5 前一个素材从正常放大到两倍
	}else{
		UV = 0.5 + ((uv - 0.5)*(2.0 - process)); // 1.5->1 后一个素材从小放大到正常
	}
	return UV;
}
vec3 blur(sampler2D texture, vec2 uv, float process, float pixelStep){
	vec2 dir = uv - 0.5; // 方向
	vec3 color = vec3(0.0);
	const int len = 10;
	for(int i= -len; i <= len; i++){
		vec2 blurCoord = uv + pixelStep*float(i)*dir*2.0*process;
		blurCoord = abs(blurCoord);
		if(blurCoord.x > 1.0){
			blurCoord.x = 2.0 - blurCoord.x; // 取镜像效果，下同
		}
		if(blurCoord.y > 1.0){
			blurCoord.y = 2.0 - blurCoord.y;
		}
		color += texture2D(texture, blurCoord).rgb;
	}
	color /= float(2*len+1);
	return color;
}

float easeInOutCubic(float x)
{
	return x < 0.5 ? 2.0 * x * x : 1.0 - pow( -2.0 * x + 2.0, 3.0 ) / 2.0;
}

void main()
{
	vec2 resolution = vec2(inputWidth,inputHeight);
	vec2 center = resolution * 0.5;
	float pixelStep = 10.0/float(inputWidth);
	float process = easeInOutCubic(processBar);

	vec2 uv1 = zoomNear(uv, process); // 放大

	vec2 realCoord = uv1 * resolution;

	vec3 resultColor = vec3(0.0);
	if(process < 0.5) {
	    realCoord = rotate(realCoord,center,2.0*process * ANGLE); // 旋转 0->1
		resultColor = blur(inputTexture, realCoord / resolution, process, pixelStep).rgb; // 模糊
	} else {
        realCoord = rotate(realCoord,center,2.0*(process-1.0) * ANGLE); // -1->0
		resultColor = blur(inputTexture, realCoord / resolution, 1.0 - process, pixelStep).rgb;
	}
	gl_FragColor = vec4(resultColor,1.0);
}
