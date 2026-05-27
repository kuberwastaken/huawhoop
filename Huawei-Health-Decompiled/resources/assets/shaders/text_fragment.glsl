precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;

void main() {
    gl_FragColor = texture2D(inputTexture, uv);
    gl_FragColor.a = gl_FragColor.a * processBar;
}

