package defpackage;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class obz {

    @SerializedName("huid")
    private long c;

    @SerializedName("userAccount")
    private String f;

    @SerializedName("nickName")
    private String j;
    private List<String> d = new ArrayList(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<ock> f16277a = new SparseArray<>(10);
    private SparseArray<ock> h = new SparseArray<>(10);
    private SparseIntArray i = new SparseIntArray(10);
    private int b = 0;
    private int e = 0;

    public void e(long j) {
        this.c = j;
    }

    public long e() {
        return this.c;
    }

    public void b(String str) {
        this.j = str;
    }

    public String f() {
        return this.j;
    }

    public String j() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public void d(List<String> list) {
        this.d = list;
    }

    public List<String> b() {
        return new ArrayList(this.d);
    }

    public void ctM_(SparseArray<ock> sparseArray) {
        this.f16277a = sparseArray;
    }

    public SparseArray<ock> ctJ_() {
        SparseArray<ock> sparseArray = this.f16277a;
        if (sparseArray != null) {
            return sparseArray.clone();
        }
        return null;
    }

    public void ctN_(SparseArray<ock> sparseArray) {
        this.h = sparseArray;
    }

    public SparseArray<ock> ctK_() {
        SparseArray<ock> sparseArray = this.h;
        if (sparseArray != null) {
            return sparseArray.clone();
        }
        return null;
    }

    public void ctO_(SparseIntArray sparseIntArray) {
        this.i = sparseIntArray;
    }

    public SparseIntArray ctL_() {
        SparseIntArray sparseIntArray = this.i;
        if (sparseIntArray != null) {
            return sparseIntArray.clone();
        }
        return null;
    }

    public void d(int i) {
        this.b = i;
    }

    public int d() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
    }

    public int c() {
        return this.e;
    }
}
