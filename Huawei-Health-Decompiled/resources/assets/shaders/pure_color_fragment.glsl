precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform vec4 tintColor;

void main() {
    gl_FragColor = tintColor;
    gl_FragColor.a = gl_FragColor.a * processBar;
}

