package defpackage;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.text.Collator;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public class kxi {
    private String c;
    private Drawable b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14983a = null;
    private String i = null;
    private String d = null;
    private int e = 0;
    private int f = -1;

    public void e(String str) {
        this.c = str;
    }

    public void bNy_(Drawable drawable) {
        this.b = drawable;
    }

    public Drawable bNx_() {
        return this.b;
    }

    public void d(String str) {
        this.f14983a = str;
    }

    public String a() {
        return this.f14983a;
    }

    public void a(String str) {
        this.i = str;
    }

    public String g() {
        return this.i;
    }

    public void c(int i) {
        this.e = i;
    }

    public int c() {
        return this.e;
    }

    public void a(int i) {
        this.f = i;
    }

    public int b() {
        return this.f;
    }

    public String e() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public static class c implements Comparator<kxi> {
        private final Collator d;

        public c() {
            Collator collator = Collator.getInstance();
            this.d = collator;
            collator.setStrength(0);
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(kxi kxiVar, kxi kxiVar2) {
            if (TextUtils.isEmpty(kxiVar.a())) {
                return 1;
            }
            if (TextUtils.isEmpty(kxiVar2.a())) {
                return -1;
            }
            return this.d.compare(kxiVar.a(), kxiVar2.a());
        }
    }
}
