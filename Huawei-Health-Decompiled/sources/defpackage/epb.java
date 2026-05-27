package defpackage;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class epb {

    @SerializedName("gradeList")
    protected List<a> b;

    @SerializedName("descriptionid")
    protected int c;

    @SerializedName("type")
    protected int e;

    public int d() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public List<a> b() {
        return this.b;
    }

    public void c(List<a> list) {
        this.b = list;
    }

    public String toString() {
        return "BloodPressureFeatureInfo{type=" + this.e + ", gradeList=" + this.b + '}';
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(NotificationCompat.CATEGORY_SYSTEM)
        protected List<Integer> f12708a;

        @SerializedName("titleId")
        protected int b;

        @SerializedName("grade")
        protected int c;

        @SerializedName("dia")
        protected List<Integer> d;

        @SerializedName("orAnd")
        protected int e;

        public int a() {
            return this.c;
        }

        public void b(int i) {
            this.c = i;
        }

        public int c() {
            return this.b;
        }

        public void e(int i) {
            this.b = i;
        }

        public int d() {
            return this.e;
        }

        public void a(int i) {
            this.e = i;
        }

        public List<Integer> b() {
            return this.f12708a;
        }

        public void b(List<Integer> list) {
            this.f12708a = list;
        }

        public List<Integer> e() {
            return this.d;
        }

        public void a(List<Integer> list) {
            this.d = list;
        }

        public String toString() {
            return "Categorization{grade=" + this.c + ", titleId=" + this.b + ", orAnd=" + this.e + ", sys=" + this.f12708a + ", dia=" + this.d + '}';
        }
    }
}
