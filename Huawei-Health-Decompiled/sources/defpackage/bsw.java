package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class bsw {

    @SerializedName("alarmInfoList")
    private final List<b> b;

    @SerializedName("enabled")
    private final boolean e;

    public bsw(boolean z, List<b> list) {
        this.e = z;
        this.b = list;
    }

    public boolean b() {
        return this.e;
    }

    public List<b> d() {
        return this.b;
    }

    public String toString() {
        return "HealthModeReminderCloudBean{mIsEnabled=" + this.e + ", mCloudReminderBeanList=" + this.b + '}';
    }

    public static class b {

        @SerializedName("minute")
        private final int c;

        @SerializedName("hour")
        private final int d;

        public b(int i, int i2) {
            this.c = i2;
            this.d = i;
        }

        public int a() {
            return this.c;
        }

        public int e() {
            return this.d;
        }

        public String toString() {
            return "CloudReminderBean{mMinute=" + this.c + ", mHour=" + this.d + '}';
        }
    }
}
