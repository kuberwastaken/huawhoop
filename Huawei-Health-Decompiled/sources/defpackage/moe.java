package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwonesdk.datastructure.request.DataType;

/* JADX INFO: loaded from: classes6.dex */
public class moe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("startLocalDate")
    private String f15755a;

    @SerializedName("dataType")
    private DataType b;

    @SerializedName("endLocalDate")
    private String c;

    @SerializedName("endTime")
    private long d;

    @SerializedName("modifiedTime")
    private long e;

    @SerializedName("startTime")
    private long g;

    @SerializedName("subUser")
    private String h;

    @SerializedName("timeZone")
    private String j;

    public DataType d() {
        return this.b;
    }

    public long b() {
        return this.g;
    }

    public String toString() {
        return "SampleDataBase{dataType=" + this.b + ", startLocalDate='" + this.f15755a + "', endLocalDate='" + this.c + "', startTime=" + this.g + ", endTime=" + this.d + ", timeZone='" + this.j + "', modifiedTime=" + this.e + ", subUser='" + this.h + "'}";
    }
}
