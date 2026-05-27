package defpackage;

import androidx.core.view.GravityCompat;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class eei implements Serializable {
    private static final long serialVersionUID = -479718036212547170L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12563a = GravityCompat.START;
    private CharSequence b;
    private ArrayList<String> c;
    private ArrayList<String> d;
    private ArrayList<Object> e;
    private boolean i;
    private boolean j;

    public ArrayList<String> c() {
        return this.d;
    }

    public void a(ArrayList<String> arrayList) {
        this.d = arrayList;
    }

    public ArrayList<Object> d() {
        return this.e;
    }

    public ArrayList<String> e() {
        return this.c;
    }

    public void c(ArrayList<Object> arrayList) {
        this.e = arrayList;
    }

    public void b(ArrayList<String> arrayList) {
        this.c = arrayList;
    }

    public CharSequence b() {
        return this.b;
    }

    public void e(CharSequence charSequence) {
        this.b = charSequence;
    }

    public void a(int i) {
        this.f12563a = i;
    }

    public boolean a() {
        return this.i;
    }

    public void e(boolean z) {
        this.i = z;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public String toString() {
        return "DeviceMeasureOperateModel [measureModelImgList=" + this.e + ", measureModelGuidePrompt=" + ((Object) this.b) + ", measureModelGuideGravity=" + this.f12563a + ", measureModelShowButton=" + this.i + ", measureModelShowReselcet=" + this.j + "]";
    }
}
