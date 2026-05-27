precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform vec2 dir;
uniform sampler2D inputTexture;

void main() {
    vec4 sum = vec4(0.0);
    float step = 1.0 / 1024.0;

    sum += texture2D(inputTexture, uv - 4.0*step*dir) * 0.0162162162;
    sum += texture2D(inputTexture, uv - 3.0*step*dir) * 0.0540540541;
    sum += texture2D(inputTexture, uv - 2.0*step*dir) * 0.1216216216;
    sum += texture2D(inputTexture, uv - 1.0*step*dir) * 0.1945945946;
    sum += texture2D(inputTexture, uv) * 0.2270270270;
    sum += texture2D(inputTexture, uv + 1.0*step*dir) * 0.1945945946;
    sum += texture2D(inputTexture, uv + 2.0*step*dir) * 0.1216216216;
    sum += texture2D(inputTexture, uv + 3.0*step*dir) * 0.0540540541;
    sum += texture2D(inputTexture, uv + 4.0*step*dir) * 0.0162162162;

    gl_FragColor = vec4(sum.rgb, 1.0);
}