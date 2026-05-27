precision highp float;
uniform float processBar;
uniform sampler2D inputTexture;
uniform vec4 tintColor;

varying vec2 uv;

vec4 blur(vec2 p, float process);
void main()
{
    gl_FragColor = blur(uv, processBar);
    gl_FragColor.a = gl_FragColor.a * processBar;
}

vec4 blur(vec2 p, float process)
{
    vec2 resolution = vec2(20.0, 20.0);
    float blurRadius = 5.0 * ( 1.0 - process);
    float sampleNum = 6.0;
    if (blurRadius > 0.0 && sampleNum > 1.0)
    {
        vec4 col = vec4(0);
        vec2 unit = 1.0 / resolution.xy;

        float r = blurRadius;
        float sampleStep = r / sampleNum;

        float count = 0.0;
        for(float x = -r; x < r; x += sampleStep)
        {
            for(float y = -r; y < r; y += sampleStep)
            {
                float weight = 1.0;//(r - abs(x)) * (r - abs(y));
                vec4 c = texture2D(inputTexture, p + vec2(x * unit.x, y * unit.y)) * weight;
                c.rgb = tintColor.rgb;
                col += c;
                count += weight;
            }
        }
        return col / count;
    }

    return texture2D(inputTexture, p);
}