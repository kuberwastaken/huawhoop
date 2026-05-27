precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform sampler2D inputTexture;

void main() {
    gl_FragColor = texture2D(inputTexture, uv);
}

