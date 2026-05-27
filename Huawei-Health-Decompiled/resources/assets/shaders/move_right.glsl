precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;
uniform sampler2D nextTexture;

float easeInOutQuint(float t)
{
    return t<0.5 ? 16.0*t*t*t*t*t : 1.0+16.0*(--t)*t*t*t*t;
}

void main() {
    float process = easeInOutQuint(processBar);
    if(uv.x < process) {
        gl_FragColor = texture2D(nextTexture, uv + vec2(1.0 - process, 0.0));
    } else {
        gl_FragColor = texture2D(inputTexture, uv - vec2(process, 0.0));
    }
}