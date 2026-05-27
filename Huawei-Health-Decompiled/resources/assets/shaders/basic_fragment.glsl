precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;

void main() {
    gl_FragColor = texture2D(inputTexture, uv);
    gl_FragColor.a = 1.0; // 保证alpha为1，解决在悬浮窗模式下画面内容会透出下面的桌面背景。后续不再使用alpha动画
}

