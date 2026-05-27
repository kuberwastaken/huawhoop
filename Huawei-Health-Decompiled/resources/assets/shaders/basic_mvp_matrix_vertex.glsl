attribute vec4 vPosition; // 顶点位置
attribute vec2 fPosition; // 纹理位置
uniform mat4 vMVPMatrix;
varying vec2 uv; // 纹理位置  与fragment_shader交互
void main() {
    uv = fPosition;
    gl_Position = vMVPMatrix * vPosition;
}