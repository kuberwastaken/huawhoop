package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hihealthservice.db.table.DBSessionCommon;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.operation.utils.CloudParamKeys;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pmo extends CloudCommonReponse {

    @SerializedName("globalConfig")
    private a b;

    public a d() {
        return this.b;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "OneClickGrayBean{, mGlobalConfig=" + this.b + '}';
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("grayingConfig")
        private b f16777a;

        public b a() {
            return this.f16777a;
        }

        public String toString() {
            return "GlobalConfig{mGrayConfig=" + this.f16777a + '}';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(CloudParamKeys.CLIENT_TYPE)
        private int f16778a;

        @SerializedName("startTime")
        private long b;

        @SerializedName("pageTypes")
        private List<Integer> c;

        @SerializedName("endTime")
        private long d;

        @SerializedName("eventSubject")
        private String e;

        @SerializedName(DBSessionCommon.COLUMN_TIME_ZONE)
        private String i;

        public long a() {
            return this.b;
        }

        public long e() {
            return this.d;
        }

        public int d() {
            return this.f16778a;
        }

        public List<Integer> b() {
            return this.c;
        }

        public String toString() {
            return "GrayingConfig{mStartTime=" + this.b + ", mEndTime=" + this.d + ", mClientType=" + this.f16778a + ", mPagesTypeList=" + this.c + ", mEventSubject='" + this.e + "', mTimezone='" + this.i + "'}";
        }
    }
}
