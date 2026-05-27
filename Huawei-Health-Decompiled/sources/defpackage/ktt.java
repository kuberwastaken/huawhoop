package defpackage;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* JADX INFO: loaded from: classes5.dex */
public class ktt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBaseResponseCallback f14893a;
    private Object e;

    public IBaseResponseCallback e() {
        return (IBaseResponseCallback) kqt.e(this.f14893a);
    }

    public void c(IBaseResponseCallback iBaseResponseCallback) {
        this.f14893a = (IBaseResponseCallback) kqt.e(iBaseResponseCallback);
    }

    public Object a() {
        return kqt.e(this.e);
    }

    public void e(Object obj) {
        this.e = kqt.e(obj);
    }
}
