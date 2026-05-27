package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dsm {
    private String b;
    private String c;

    public String c() {
        return (String) kqt.e(this.c);
    }

    public void b(String str) {
        this.c = (String) kqt.e(str);
    }

    public String a() {
        return (String) kqt.e(this.b);
    }

    public void c(String str) {
        this.b = (String) kqt.e(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("EzPluginFileApplyRule{minAppVersion='");
        stringBuffer.append(this.c);
        stringBuffer.append("', minIndexVersion='").append(this.b).append("'}");
        return stringBuffer.toString();
    }
}
