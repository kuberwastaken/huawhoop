package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwonesdk.datastructure.request.DataType;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mno {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("deviceUniqueId")
    private String f15740a;

    @SerializedName("dataSourceId")
    private String b;

    @SerializedName("dataSourceFilter")
    private a c;

    @SerializedName("appId")
    private String d;

    @SerializedName("appBundleName")
    private String e;

    public String e() {
        return this.b;
    }

    public String c() {
        return this.f15740a;
    }

    public String b() {
        return this.e;
    }

    public a a() {
        return this.c;
    }

    public static class a {

        @SerializedName("startTime")
        private long c;

        @SerializedName("dataType")
        private List<DataType> d;

        @SerializedName("endTime")
        private long e;

        public long a() {
            return this.c;
        }

        public long c() {
            return this.e;
        }

        public List<DataType> e() {
            return this.d;
        }
    }

    public String toString() {
        return "DataSourceOptions{mDataSourceId='" + this.b + "', mDeviceUniqueId='" + this.f15740a + "', mAppBundleName='" + this.e + "', mAppId='" + this.d + "'}";
    }
}
