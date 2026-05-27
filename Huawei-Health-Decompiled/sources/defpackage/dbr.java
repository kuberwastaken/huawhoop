package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dbr<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f12149a;
    private String b;
    private T d;

    public T d() {
        return this.d;
    }

    public Integer a() {
        return this.f12149a;
    }

    public dbr(int i, String str, T t) {
        this.f12149a = Integer.valueOf(i);
        this.b = str;
        this.d = t;
    }

    public static <T> dbr<T> d(T t) {
        return new dbr<>(0, "", t);
    }

    public static <T> dbr<T> e(int i, String str) {
        return new dbr<>(i, str, null);
    }
}
