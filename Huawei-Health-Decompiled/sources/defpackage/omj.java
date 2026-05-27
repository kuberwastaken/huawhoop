package defpackage;

import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class omj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16453a;
    private final String b;
    private final Locale c;
    private final String e;

    private omj(String str, String str2, String str3, Locale locale) {
        this.b = str;
        this.e = str2;
        this.f16453a = str3;
        this.c = locale;
    }

    public static omj c(String str, String str2, String str3, Locale locale) {
        return new omj(str, str2, str3, locale);
    }

    public String b() {
        return this.b;
    }

    public String a() {
        return this.e;
    }

    public String e() {
        return this.f16453a;
    }

    public Locale c() {
        return this.c;
    }
}
