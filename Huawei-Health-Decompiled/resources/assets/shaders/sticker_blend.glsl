precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;
uniform sampler2D nextTexture;

void main() {
    lowp vec4 basicPixel = texture2D(inputTexture, uv);
    lowp vec4 blendPixel = texture2D(nextTexture, uv);
    lowp vec4 result = mix(basicPixel, blendPixel, processBar);
    gl_FragColor = vec4(result.rgb, 1.0);
}



