precision highp float;
varying vec2 uv;
uniform int inputWidth;

uniform float processBar;
uniform sampler2D inputTexture;

vec2 zoomFar(vec2 uv, float process){
    vec2 UV = vec2(0.0);
    if(process < 0.5){
        UV = 0.5 + ((uv - 0.5)*(process + 1.0)); // 1->1.5 前一个素材从正常缩小
    }else{
        UV = 0.5 + ((uv - 0.5)*process); // 0.5->1 后一个素材从两倍缩小到正常
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

float easeInOutQuint(float t)
{
    return t<0.5 ? 16.0*t*t*t*t*t : 1.0+16.0*(--t)*t*t*t*t;
}

void main() {
    float pixelStep = 10.0/float(inputWidth);
    float process = easeInOutQuint(processBar);

    vec2 uv1 = zoomFar(uv, process);
    vec3 color;
    if(processBar < 0.5){
        color = blur(inputTexture, uv1, process, pixelStep).rgb;
    }else{
        color = blur(inputTexture, uv1, 1.0 - process, pixelStep).rgb;
    }
    gl_FragColor = vec4(color, 1.0);
}

