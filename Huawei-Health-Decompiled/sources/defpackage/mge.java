package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class mge implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("dis")
    private int f15620a;

    @SerializedName("pace")
    private float c;

    @SerializedName("points")
    private int d;

    public mge() {
    }

    public mge(int i, int i2, float f) {
        this.f15620a = i;
        this.d = i2;
        this.c = f;
    }

    public mge(mge mgeVar) {
        this.f15620a = mgeVar.f15620a;
        this.d = mgeVar.d;
        this.c = mgeVar.c;
    }

    public int d() {
        return this.f15620a;
    }

    public void e(int i) {
        this.f15620a = i;
    }

    public int c() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public float a() {
        return this.c;
    }

    public void e(float f) {
        this.c = f;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            mge mgeVar = (mge) obj;
            if (this.f15620a == mgeVar.f15620a && this.d == mgeVar.d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f15620a), Integer.valueOf(this.d));
    }

    public String toString() {
        return "{distance=" + this.f15620a + ", pointsNums=" + this.d + ", pace=" + this.c + '}';
    }
}
