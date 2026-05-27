package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class dqk implements Serializable {
    private static final long serialVersionUID = -2788623292434891852L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12363a = -1;

    public int b() {
        return this.f12363a;
    }

    public void e(int i) {
        this.f12363a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BaseEntityModel{errorCode =");
        stringBuffer.append(this.f12363a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
