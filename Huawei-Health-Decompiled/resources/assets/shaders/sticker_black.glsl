precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;

void main() {
    vec4 blackColor = vec4(0.0, 0.0, 0.0, 1.0);
    float process;
    if (processBar < 0.5) {
        process = processBar * 2.0;
    } else {
        process = 2.0 - 2.0 * processBar;
    }
    gl_FragColor = mix(texture2D(inputTexture, uv), blackColor, process);
}