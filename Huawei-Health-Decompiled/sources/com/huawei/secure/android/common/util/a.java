package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes11.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8995a;
    private Character b;
    private Character c;
    private int d = 0;
    private int e = 0;

    public a(String str) {
        this.f8995a = str;
    }

    public boolean a() {
        if (this.b != null) {
            return true;
        }
        String str = this.f8995a;
        return (str == null || str.length() == 0 || this.d >= this.f8995a.length()) ? false : true;
    }

    public int b() {
        return this.d;
    }

    public void c(Character ch) {
        this.b = ch;
    }

    public Character d() {
        Character ch = this.b;
        if (ch != null) {
            this.b = null;
            return ch;
        }
        String str = this.f8995a;
        if (str == null || str.length() == 0 || this.d >= this.f8995a.length()) {
            return null;
        }
        String str2 = this.f8995a;
        int i = this.d;
        this.d = i + 1;
        return Character.valueOf(str2.charAt(i));
    }

    public Character e() {
        Character chD = d();
        if (chD != null && a(chD)) {
            return chD;
        }
        return null;
    }

    public Character f() {
        Character chD = d();
        if (chD != null && b(chD)) {
            return chD;
        }
        return null;
    }

    public Character g() {
        Character ch = this.b;
        if (ch != null) {
            return ch;
        }
        String str = this.f8995a;
        if (str == null || str.length() == 0 || this.d >= this.f8995a.length()) {
            return null;
        }
        return Character.valueOf(this.f8995a.charAt(this.d));
    }

    protected String h() {
        String strSubstring = this.f8995a.substring(this.d);
        if (this.b == null) {
            return strSubstring;
        }
        return this.b + strSubstring;
    }

    public void i() {
        this.b = this.c;
        this.d = this.e;
    }

    public static boolean b(Character ch) {
        char cCharValue;
        return ch != null && (cCharValue = ch.charValue()) >= '0' && cCharValue <= '7';
    }

    public void c() {
        this.c = this.b;
        this.e = this.d;
    }

    public static boolean a(Character ch) {
        if (ch == null) {
            return false;
        }
        char cCharValue = ch.charValue();
        return (cCharValue >= '0' && cCharValue <= '9') || (cCharValue >= 'a' && cCharValue <= 'f') || (cCharValue >= 'A' && cCharValue <= 'F');
    }

    public boolean a(char c) {
        Character ch = this.b;
        if (ch != null && ch.charValue() == c) {
            return true;
        }
        String str = this.f8995a;
        return str != null && str.length() != 0 && this.d < this.f8995a.length() && this.f8995a.charAt(this.d) == c;
    }
}
