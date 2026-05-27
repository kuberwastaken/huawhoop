#extension GL_OES_EGL_image_external : require
precision mediump float;
varying vec2 uv;
uniform samplerExternalOES videoTexture;
void main() {
    gl_FragColor=texture2D(videoTexture, uv);
}