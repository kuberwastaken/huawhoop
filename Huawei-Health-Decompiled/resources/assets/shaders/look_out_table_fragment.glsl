precision mediump float; // 精度 为float
varying vec2 uv; // 纹理位置  接收于vertex_shader
uniform float processBar;
uniform sampler2D inputTexture;
uniform sampler2D lutTexture;
uniform float filterStrength;
vec4 lut(vec2 p, sampler2D lutTexture);

void main() {
    gl_FragColor = lut(uv, lutTexture);
}

vec4 lut(vec2 p, sampler2D lutTexture)
{
    vec4 textureColor = texture2D(inputTexture, p);
    float redColor = textureColor.r * 63.0;
    float greenColor = textureColor.g * 63.0;
    float blueColor = textureColor.b * 63.0;

    float block1 = floor(blueColor);
    float block2 = ceil(blueColor);

    vec2 quad1;
    quad1.y = floor(block1 / 8.0);
    quad1.x = block1 - (quad1.y * 8.0);

    vec2 quad2;
    quad2.y = floor(block2 / 8.0);
    quad2.x = block2 - (quad2.y * 8.0);

    vec2 texPos1;
    texPos1.x = (quad1.x * 0.125) + (1.0/512.0 * floor(redColor)) + 1.0 / 1024.0;
    texPos1.y = (quad1.y * 0.125) + (1.0/512.0 * floor(greenColor)) + 1.0 / 1024.0;

    vec2 texPos2;
    texPos2.x = (quad2.x * 0.125) + (1.0/512.0 * ceil(redColor)) + 1.0 / 1024.0;
    texPos2.y = (quad2.y * 0.125) + (1.0/512.0 * ceil(greenColor)) + 1.0 / 1024.0;

    vec4 newColor1 = texture2D(lutTexture, texPos1);
    vec4 newColor2 = texture2D(lutTexture, texPos2);
    float newR = mix(newColor1.r, newColor2.r, fract(redColor));
    float newG = mix(newColor1.g, newColor2.g, fract(greenColor));
    float newB = mix(newColor1.b, newColor2.b, fract(blueColor));
    float R = mix(textureColor.r, newR, filterStrength);
    float G = mix(textureColor.g, newG, filterStrength);
    float B = mix(textureColor.b, newB, filterStrength);
    vec4 lutColor = vec4(R, G, B, textureColor.w);
    //lutColor.a = processBar;
    return lutColor;
}