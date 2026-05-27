package defpackage;

import android.os.Process;
import com.huawei.openplatform.abl.log.LogLevel;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class nef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16021a;
    private int b;
    private String c;
    private String e;
    private int h;
    private long d = 0;
    private final StringBuilder j = new StringBuilder();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        c(sb);
        b(sb);
        return sb.toString();
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        c(sb);
        return sb.toString();
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public <T> nef c(T t) {
        this.j.append(t);
        return this;
    }

    private StringBuilder c(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.d)));
        String strPriorityToString = LogLevel.priorityToString(this.b);
        sb.append(' ');
        sb.append(strPriorityToString);
        sb.append('/');
        sb.append(this.c);
        sb.append('/');
        sb.append(this.e);
        sb.append(' ');
        sb.append(this.h);
        sb.append(':');
        sb.append(this.f16021a);
        sb.append(']');
        return sb;
    }

    private nef d() {
        this.d = System.currentTimeMillis();
        this.f16021a = Thread.currentThread().getName();
        this.h = Process.myPid();
        return this;
    }

    private StringBuilder b(StringBuilder sb) {
        sb.append(' ');
        sb.append((CharSequence) this.j);
        return sb;
    }

    nef(String str, int i, String str2) {
        this.c = null;
        this.e = "HA";
        this.b = 0;
        this.c = str;
        this.b = i;
        if (str2 != null) {
            this.e = str2;
        }
        d();
    }
}
