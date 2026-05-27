package defpackage;

import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class dqm extends dqk {
    private static final long serialVersionUID = -1074804273256729256L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12365a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Long e;
    private String f;

    public String i() {
        return this.f12365a;
    }

    public void e(String str) {
        this.f12365a = str;
    }

    public Integer c() {
        return this.c;
    }

    public void c(Integer num) {
        this.c = num;
    }

    public String g() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public Long d() {
        return this.e;
    }

    public void b(Long l) {
        this.e = l;
    }

    public Integer e() {
        return this.b;
    }

    public void b(Integer num) {
        this.b = num;
    }

    public Integer a() {
        return this.d;
    }

    public void d(Integer num) {
        this.d = num;
    }

    @Override // defpackage.dqk
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CoapSessionResponseOEntityModel{errcode =");
        Object obj = this.b;
        Object obj2 = Constants.NULL;
        if (obj == null) {
            obj = Constants.NULL;
        }
        stringBuffer.append(obj).append("', modeResp =");
        Integer num = this.c;
        if (num != null) {
            obj2 = num;
        }
        stringBuffer.append(obj2).append("'}");
        return stringBuffer.toString();
    }
}
