package defpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes9.dex */
public class lr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15413a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public String toString() {
        StringBuilder sb;
        String strSubstring;
        StringBuilder sb2;
        String strSubstring2;
        StringBuilder sb3;
        String strSubstring3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.b);
        stringBuffer.append("," + this.c);
        stringBuffer.append("," + this.e);
        stringBuffer.append("," + this.f15413a);
        if (kn.a(this.d) || this.d.length() < 20) {
            sb = new StringBuilder(",");
            strSubstring = this.d;
        } else {
            sb = new StringBuilder(",");
            strSubstring = this.d.substring(0, 20);
        }
        sb.append(strSubstring);
        stringBuffer.append(sb.toString());
        if (kn.a(this.f) || this.f.length() < 20) {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f;
        } else {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f.substring(0, 20);
        }
        sb2.append(strSubstring2);
        stringBuffer.append(sb2.toString());
        if (kn.a(this.g) || this.g.length() < 20) {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.g;
        } else {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.g.substring(0, 20);
        }
        sb3.append(strSubstring3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }

    public lr(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.b = str;
        this.c = str2;
        this.e = str3;
        this.f15413a = str4;
        this.d = str5;
        this.f = str6;
        this.g = str7;
    }
}
