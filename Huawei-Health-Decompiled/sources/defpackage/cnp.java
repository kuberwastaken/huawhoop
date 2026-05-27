package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;

/* JADX INFO: loaded from: classes.dex */
public class cnp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("examinationId")
    private int f707a;

    @SerializedName("isUpdateHealthReport")
    private boolean b;

    @SerializedName("recordName")
    private String c;

    @SerializedName("examinationDate")
    private long d;

    @SerializedName("examinationInstitution")
    private String e;

    @SerializedName("remarks")
    private String f;

    @SerializedName("reminderTime")
    private long h;

    @SerializedName(JsbMapKeyNames.H5_USER_ID)
    private String i;

    public long b() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public long g() {
        return this.h;
    }

    public String c() {
        return this.f;
    }

    public int a() {
        return this.f707a;
    }

    public String j() {
        return this.i;
    }

    public boolean i() {
        return this.b;
    }
}
