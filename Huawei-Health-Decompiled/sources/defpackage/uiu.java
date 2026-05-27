package defpackage;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes8.dex */
public class uiu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18323a;
    private ContentValues b;
    private int c;
    private String[] d;
    private int e;
    private int f;
    private int[] g;
    private String h;
    private long i;
    private int j;
    private int k;
    private long l;
    private boolean m;
    private boolean n;
    private String o;
    private int[] s;

    public uiu() {
        this(0L, 0L, 0, "", "");
    }

    public uiu(long j, long j2, int i, String str, String str2) {
        this.b = new ContentValues();
        this.l = j;
        this.i = j2;
        this.k = i;
        this.h = str;
        this.o = str2;
    }

    public uiu(int i, String str, String str2) {
        this.b = new ContentValues();
        this.f = i;
        this.h = str;
        this.o = str2;
    }

    public int b() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public long l() {
        return this.l;
    }

    public void b(long j) {
        this.l = j;
    }

    public long j() {
        return this.i;
    }

    public void d(long j) {
        this.i = j;
    }

    public String[] a() {
        String[] strArr = this.d;
        return strArr == null ? new String[0] : (String[]) strArr.clone();
    }

    public void b(String[] strArr) {
        if (strArr == null) {
            this.d = null;
        } else {
            this.d = (String[]) strArr.clone();
        }
    }

    public int d() {
        return this.f18323a;
    }

    public void d(int i) {
        this.f18323a = i;
    }

    public int[] n() {
        int[] iArr = this.s;
        return iArr == null ? new int[0] : (int[]) iArr.clone();
    }

    public void e(int[] iArr) {
        if (iArr == null) {
            this.s = null;
        } else {
            this.s = (int[]) iArr.clone();
        }
    }

    public int i() {
        return this.j;
    }

    public void e(int i) {
        this.j = i;
    }

    public int o() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public int c() {
        return this.f;
    }

    public int e() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public String f() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public boolean k() {
        return this.m;
    }

    public void e(boolean z) {
        this.m = z;
    }

    public int[] h() {
        int[] iArr = this.g;
        return iArr == null ? new int[0] : (int[]) iArr.clone();
    }

    public void d(int[] iArr) {
        if (iArr == null) {
            this.g = null;
        } else {
            this.g = (int[]) iArr.clone();
        }
    }

    public String g() {
        return this.o;
    }

    public void c(String str) {
        this.o = str;
    }

    public boolean m() {
        return this.n;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public void e(String str, int i) {
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
        this.b.put(str, Integer.valueOf(i));
    }

    public int a(String str) {
        Integer asInteger = this.b.getAsInteger(str);
        if (asInteger == null) {
            return Integer.MIN_VALUE;
        }
        return asInteger.intValue();
    }
}
