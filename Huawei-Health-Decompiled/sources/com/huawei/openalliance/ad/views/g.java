package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.huawei.openalliance.ad.ed;
import com.huawei.openalliance.ad.eh;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.utils.ao;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes11.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ao f8355a;
    private ed b;
    private MediaPlayerAgent c;
    private eh d;
    private SurfaceTexture e;
    private int f;
    private Surface g;
    private final Set<WeakReference<com.huawei.openalliance.ad.views.interfaces.u>> h;
    private SurfaceTexture.OnFrameAvailableListener i;

    public void i() {
        eh ehVar = this.d;
        if (ehVar != null) {
            ehVar.a();
            this.d = null;
        }
        ed edVar = this.b;
        if (edVar != null) {
            edVar.b();
            this.b.a();
            this.b = null;
        }
        SurfaceTexture surfaceTexture = this.e;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public MediaPlayerAgent h() {
        MediaPlayerAgent mediaPlayerAgent;
        synchronized (this) {
            mediaPlayerAgent = this.c;
        }
        return mediaPlayerAgent;
    }

    ed g() {
        ed edVar;
        synchronized (this) {
            edVar = this.b;
        }
        return edVar;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.f8355a.b();
    }

    eh f() {
        eh ehVar;
        synchronized (this) {
            ehVar = this.d;
        }
        return ehVar;
    }

    SurfaceTexture e() {
        SurfaceTexture surfaceTexture;
        synchronized (this) {
            surfaceTexture = this.e;
        }
        return surfaceTexture;
    }

    int d() {
        int i;
        synchronized (this) {
            i = this.f;
        }
        return i;
    }

    Surface c() {
        Surface surface;
        synchronized (this) {
            surface = this.g;
        }
        return surface;
    }

    public void b(com.huawei.openalliance.ad.views.interfaces.u uVar) {
        WeakReference<com.huawei.openalliance.ad.views.interfaces.u> weakReference = null;
        for (WeakReference<com.huawei.openalliance.ad.views.interfaces.u> weakReference2 : this.h) {
            if (weakReference2.get() == uVar) {
                weakReference = weakReference2;
            }
        }
        if (weakReference != null) {
            this.h.remove(weakReference);
        }
    }

    void b() {
        synchronized (this) {
            if (this.b != null) {
                return;
            }
            this.b = new ed();
        }
    }

    void a(Runnable runnable) {
        this.f8355a.a(runnable);
    }

    public void a(com.huawei.openalliance.ad.views.interfaces.u uVar) {
        uVar.a(this);
        this.h.add(new WeakReference<>(uVar));
    }

    void a() {
        synchronized (this) {
            try {
                if (this.d != null) {
                    return;
                }
                eh ehVar = new eh();
                this.d = ehVar;
                this.f = ehVar.b();
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.f);
                this.e = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this.i);
                Surface surface = new Surface(this.e);
                this.g = surface;
                this.c.setSurface(surface);
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Iterator<WeakReference<com.huawei.openalliance.ad.views.interfaces.u>> it = this.h.iterator();
        while (it.hasNext()) {
            com.huawei.openalliance.ad.views.interfaces.u uVar = it.next().get();
            if (uVar != null) {
                uVar.b();
                uVar.c();
            }
        }
    }

    public g(Context context) {
        ao aoVar = new ao("video_render");
        this.f8355a = aoVar;
        this.h = new CopyOnWriteArraySet();
        this.i = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.huawei.openalliance.ad.views.g.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                g.this.j();
            }
        };
        this.c = new MediaPlayerAgent(context);
        aoVar.a();
    }
}
