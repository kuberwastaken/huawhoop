package defpackage;

import android.text.TextUtils;
import com.huawei.operation.utils.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class dpg implements Serializable {
    private static final long serialVersionUID = -1815768583998220679L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12326a;
    private String b;
    private String c;
    private String d;
    private String e;

    public String d() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    public String b() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public String a() {
        return this.b;
    }

    public String c() {
        return this.f12326a;
    }

    public void b(String str) {
        this.f12326a = str;
    }

    public String e() {
        return this.e;
    }

    public void a(String str) {
        this.e = dqv.a(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SubUser{mHuid ='");
        String str = this.d;
        String str2 = Constants.NULL;
        stringBuffer.append(str == null ? Constants.NULL : dna.b(str)).append("'mNickName ='");
        String str3 = this.c;
        stringBuffer.append(str3 == null ? Constants.NULL : dna.b(str3)).append("'mSid ='");
        String str4 = this.f12326a;
        if (str4 == null) {
            str4 = Constants.NULL;
        }
        stringBuffer.append(str4).append("'mUserAccount ='");
        String str5 = this.e;
        if (str5 == null) {
            str5 = Constants.NULL;
        }
        stringBuffer.append(str5).append("'mIconPath ='");
        String str6 = this.b;
        if (str6 != null) {
            str2 = str6;
        }
        stringBuffer.append(str2);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public boolean f() {
        return TextUtils.isEmpty(this.d);
    }
}
