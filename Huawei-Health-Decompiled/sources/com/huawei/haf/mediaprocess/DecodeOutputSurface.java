package com.huawei.haf.mediaprocess;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import health.compact.a.LogUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DecodeOutputSurface implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Surface f2165a;
    private boolean b;
    private TextureRenderer d;
    private SurfaceTexture e;
    private final Object c = new Object();
    private int i = 0;

    public DecodeOutputSurface() throws IOException {
        e();
    }

    private void e() throws IOException {
        TextureRenderer textureRenderer = new TextureRenderer(this.i);
        this.d = textureRenderer;
        textureRenderer.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.d.a());
        this.e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f2165a = new Surface(this.e);
    }

    public void b() {
        this.f2165a.release();
        this.d = null;
        this.f2165a = null;
        this.e = null;
    }

    public Surface AH_() {
        return this.f2165a;
    }

    public void c() throws IOException {
        synchronized (this.c) {
            while (!this.b) {
                try {
                    this.c.wait(5000L);
                    if (!this.b) {
                        LogUtil.d("DecodeOutputSurface", "Surface frame wait timed out");
                        throw new IOException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    LogUtil.d("DecodeOutputSurface", " awaitNewImage interrupt");
                    throw new IOException(e);
                }
            }
            this.b = false;
        }
        this.d.e("before updateTextImage");
        this.e.updateTexImage();
    }

    public void a() throws IOException {
        this.d.AJ_(this.e, false);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.c) {
            if (this.b) {
                LogUtil.d("DecodeOutputSurface", "mIsFrameAvailable already set, frame could be dropped");
            }
            this.b = true;
            this.c.notifyAll();
        }
    }
}
