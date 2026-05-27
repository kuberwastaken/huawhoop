precision mediump float;
uniform vec4 tintColor;
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;
void main()
{
    vec4 color = texture2D(inputTexture, uv);
    gl_FragColor = color * tintColor;
    gl_FragColor.a = gl_FragColor.a * processBar;
}