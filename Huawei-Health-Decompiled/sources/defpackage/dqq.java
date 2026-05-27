package defpackage;

import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class dqq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12369a;
    private Integer b;
    private Integer c;
    private Integer d;
    private String e;
    private String f;
    private Long g;
    private String h;
    private String i;
    private String j;
    private String n;

    public String i() {
        return this.f;
    }

    public void d(String str) {
        this.f = str;
    }

    public String h() {
        return this.i;
    }

    public void c(String str) {
        this.i = str;
    }

    public String d() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public String j() {
        return this.n;
    }

    public void j(String str) {
        this.n = str;
    }

    public String e() {
        return this.j;
    }

    public void b(String str) {
        this.j = str;
    }

    public String f() {
        return this.h;
    }

    public void e(String str) {
        this.h = str;
    }

    public Long g() {
        return this.g;
    }

    public void b(Long l) {
        this.g = l;
    }

    public int b() {
        return this.f12369a;
    }

    public void d(int i) {
        this.f12369a = i;
    }

    public Integer c() {
        return this.b;
    }

    public void b(Integer num) {
        this.b = num;
    }

    public Integer a() {
        return this.c;
    }

    public void e(Integer num) {
        this.c = num;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("VerifyCode2CoapSessionInfo{snAppRandom ='");
        String str = this.f;
        Object obj = Constants.NULL;
        if (str == null) {
            str = Constants.NULL;
        }
        stringBuffer.append(str).append("', snDeviceRandom ='");
        String str2 = this.i;
        if (str2 == null) {
            str2 = Constants.NULL;
        }
        stringBuffer.append(str2).append("', deviceId ='");
        String str3 = this.e;
        if (str3 == null) {
            str3 = Constants.NULL;
        }
        stringBuffer.append(str3).append("', verifyCode ='");
        String str4 = this.n;
        if (str4 == null) {
            str4 = Constants.NULL;
        }
        stringBuffer.append(str4).append("', psk ='");
        String str5 = this.j;
        if (str5 == null) {
            str5 = Constants.NULL;
        }
        stringBuffer.append(str5).append("', modeSupport ='");
        Object obj2 = this.d;
        if (obj2 == null) {
            obj2 = Constants.NULL;
        }
        stringBuffer.append(obj2).append("', sessId ='");
        String str6 = this.h;
        if (str6 == null) {
            str6 = Constants.NULL;
        }
        stringBuffer.append(str6).append("', seq ='");
        Long l = this.g;
        if (l != null) {
            obj = l;
        }
        stringBuffer.append(obj).append("', optSeq =");
        stringBuffer.append(this.f12369a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
