package defpackage;

import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class dqo extends dqk {
    private static final long serialVersionUID = 8809056063570514076L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f12367a;
    private Integer b;
    private String d;
    private Integer e;

    public Integer a() {
        return this.e;
    }

    public void e(Integer num) {
        this.e = num;
    }

    public Integer d() {
        return this.b;
    }

    public void b(Integer num) {
        this.b = num;
    }

    public String e() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public Integer c() {
        return this.f12367a;
    }

    public void d(Integer num) {
        this.f12367a = num;
    }

    @Override // defpackage.dqk
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CoapSessionInterfaceOEntityModel{errorCode =");
        stringBuffer.append(b());
        StringBuffer stringBufferAppend = stringBuffer.append(", type =");
        Object obj = this.e;
        Object obj2 = Constants.NULL;
        if (obj == null) {
            obj = Constants.NULL;
        }
        stringBufferAppend.append(obj);
        StringBuffer stringBufferAppend2 = stringBuffer.append(", modeSupport =");
        Integer num = this.b;
        if (num != null) {
            obj2 = num;
        }
        stringBufferAppend2.append(obj2);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
