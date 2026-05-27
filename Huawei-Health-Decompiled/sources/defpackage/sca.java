package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes11.dex */
public class sca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17650a;
    private String b;
    private String c;
    private boolean d;
    private Context e;

    public sca(Context context, String str, boolean z) {
        this.f17650a = str;
        this.d = z;
        this.e = context;
    }

    public String e() {
        return this.f17650a;
    }

    public boolean d() {
        return this.d;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public String b(String str, boolean z) {
        String strC = scc.c(this.e, this.f17650a, str, z);
        this.c = strC;
        return strC;
    }

    public String e(boolean z) {
        String strA = scc.a(this.e, this.f17650a, z);
        this.b = strA;
        return strA;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AuthCapabilityBean{authType=");
        stringBuffer.append(this.f17650a);
        stringBuffer.append(", authName='").append(this.b).append("', authSubName='");
        stringBuffer.append(this.c).append("', isOpen=");
        stringBuffer.append(this.d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
