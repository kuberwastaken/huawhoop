package defpackage;

import com.huawei.devicesdk.callback.FrameReceiver;
import com.huawei.devicesdk.callback.StatusCallback;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public class cfu {
    private CopyOnWriteArraySet<FrameReceiver> b;
    private CopyOnWriteArraySet<StatusCallback> c;

    public CopyOnWriteArraySet<StatusCallback> e() {
        return this.c;
    }

    public CopyOnWriteArraySet<FrameReceiver> a() {
        return this.b;
    }

    private cfu() {
        this.c = new CopyOnWriteArraySet<>();
        this.b = new CopyOnWriteArraySet<>();
    }

    public static cfu d() {
        return b.f636a;
    }

    public void b(StatusCallback statusCallback) {
        this.c.add(statusCallback);
    }

    public void d(StatusCallback statusCallback) {
        this.c.remove(statusCallback);
    }

    public void e(FrameReceiver frameReceiver) {
        this.b.add(frameReceiver);
    }

    public void a(FrameReceiver frameReceiver) {
        this.b.remove(frameReceiver);
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static cfu f636a = new cfu();
    }
}
