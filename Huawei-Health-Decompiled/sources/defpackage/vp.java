package defpackage;

import com.careforeyou.library.enums.Protocal_Type;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class vp implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18707a;
    private Protocal_Type b;
    private String c;
    private int d = -1;
    private String e;
    private int f;

    public Protocal_Type d() {
        return this.b;
    }

    public void b(Protocal_Type protocal_Type) {
        this.b = protocal_Type;
    }

    public int j() {
        return this.f;
    }

    public void e(int i) {
        this.f = i;
    }

    public String e() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public String b() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public int a() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.f18707a;
    }

    public void d(int i) {
        this.f18707a = i;
    }
}
