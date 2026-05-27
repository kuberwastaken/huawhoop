precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform vec2 dir;
uniform float processBar;
uniform sampler2D inputTexture;

float easeInOutCubic(float x)
{
    return x < 0.5 ? 2.0 * x * x : 1.0 - pow( -2.0 * x + 2.0, 3.0 ) / 2.0;
}

void main() {
    float process = easeInOutCubic(processBar);
    float blurProcess = 2.0*process;
    if (process > 0.5) {
        blurProcess = 2.0*(1.0 - process);
    }
    vec4 sum = vec4(0.0);
    float step = 1.0 / 512.0;
    vec2 processStep = step*dir*blurProcess;

    sum += texture2D(inputTexture, uv - 4.0*processStep) * 0.0162162162;
    sum += texture2D(inputTexture, uv - 3.0*processStep) * 0.0540540541;
    sum += texture2D(inputTexture, uv - 2.0*processStep) * 0.1216216216;
    sum += texture2D(inputTexture, uv - 1.0*processStep) * 0.1945945946;
    sum += texture2D(inputTexture, uv) * 0.2270270270;
    sum += texture2D(inputTexture, uv + 1.0*processStep) * 0.1945945946;
    sum += texture2D(inputTexture, uv + 2.0*processStep) * 0.1216216216;
    sum += texture2D(inputTexture, uv + 3.0*processStep) * 0.0540540541;
    sum += texture2D(inputTexture, uv + 4.0*processStep) * 0.0162162162;

    gl_FragColor = vec4(sum.rgb, 1.0);
}



