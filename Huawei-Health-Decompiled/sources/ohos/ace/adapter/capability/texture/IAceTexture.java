package ohos.ace.adapter.capability.texture;

/* JADX INFO: loaded from: classes8.dex */
public interface IAceTexture {
    void markTextureFrameAvailable(long j);

    void registerSurface(long j, Object obj);

    void registerTexture(long j, Object obj);

    void unregisterSurface(long j);

    void unregisterTexture(long j);
}
