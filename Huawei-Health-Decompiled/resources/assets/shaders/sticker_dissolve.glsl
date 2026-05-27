precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;
uniform sampler2D nextTexture;

void main() {
    vec4 prev = texture2D(inputTexture, uv);
    vec4 next = texture2D(nextTexture, uv);

    float diff = abs((next.r + next.g + next.b)/3.0- (prev.r + prev.g + prev.b)/3.0);
    float alpha = clamp((diff-processBar)/(processBar + 0.00000001), 0.0, 1.0);

    vec4 finalColor = mix(prev, next, 1.0 - alpha);
    gl_FragColor = vec4(finalColor.rgb, 1.0);
}



