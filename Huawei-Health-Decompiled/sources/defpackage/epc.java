package defpackage;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class epc {

    @SerializedName("type")
    protected String b;

    @SerializedName("thresholdList")
    protected List<d> c;

    public String c() {
        return this.b;
    }

    public List<d> d() {
        return this.c;
    }

    public String toString() {
        return "DynamicBloodPressureFeatureInfo{type='" + this.b + "', thresholdList=" + this.c + '}';
    }

    public static class d {

        @SerializedName(NotificationCompat.CATEGORY_SYSTEM)
        protected List<Integer> b;

        @SerializedName("dia")
        protected List<Integer> c;

        public List<Integer> b() {
            return this.b;
        }

        public List<Integer> e() {
            return this.c;
        }

        public String toString() {
            return "DynamicBloodPressureTypeCategorization{sys=" + this.b + ", dia=" + this.c + '}';
        }
    }
}
