package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class oep {
    private String c;
    private String e;

    public String a() {
        return (String) kqt.e(this.c);
    }

    public void a(String str) {
        this.c = (String) kqt.e(str);
    }

    public String c() {
        return (String) kqt.e(this.e);
    }

    public void c(String str) {
        this.e = (String) kqt.e(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("EzPluginFileApplyRule{minAppVersion='");
        stringBuffer.append(this.c);
        stringBuffer.append("', minIndexVersion='").append(this.e).append("'}");
        return stringBuffer.toString();
    }
}
