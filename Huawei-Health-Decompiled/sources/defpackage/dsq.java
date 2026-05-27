package defpackage;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dsq implements Serializable {
    private static final long serialVersionUID = 1557041249539848525L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12405a;
    private String b;
    private String c;
    private List<String> d;
    private String e;
    private List<String> g;

    public List<String> h() {
        return this.g;
    }

    public void e(List<String> list) {
        this.g = list;
    }

    public String b() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public String d() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public List<String> a() {
        return this.d;
    }

    public void a(List<String> list) {
        this.d = list;
    }

    public String e() {
        return this.f12405a;
    }

    public void d(String str) {
        this.f12405a = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append("SecondResourceBean{mUuid='");
        stringBuffer.append(String.valueOf(this.g.toString()));
        stringBuffer.append("mDeviceName='");
        stringBuffer.append(this.e);
        stringBuffer.append("mDeviceDescription='");
        stringBuffer.append(this.c);
        stringBuffer.append("mSecondIcon='");
        stringBuffer.append(this.b);
        stringBuffer.append("mBluetoothNameList='");
        stringBuffer.append(String.valueOf(this.d.toString()));
        stringBuffer.append("mBluetoothMatch='");
        stringBuffer.append(this.f12405a);
        return stringBuffer.toString();
    }
}
