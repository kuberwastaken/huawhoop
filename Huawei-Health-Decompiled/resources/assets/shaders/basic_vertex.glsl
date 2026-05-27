attribute vec4 vPosition; // 顶点位置
attribute vec2 fPosition; // 纹理位置
varying vec2 uv; // 纹理位置  与fragment_shader交互
void main() {
    uv = fPosition; //vec2(fPosition.x, 1.0 - fPosition.y);
    gl_Position = vPosition;
}