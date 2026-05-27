package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class eqw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("doctorLevel")
    private String f12745a;

    @SerializedName("doctorId")
    private String b;

    @SerializedName("doctorHospital")
    private String c;

    @SerializedName("doctorHeadIcon")
    private String d;

    @SerializedName("doctorDepartment")
    private String e;

    @SerializedName("resultCode")
    private int h;

    @SerializedName("doctorName")
    private String i;

    @SerializedName("resultDesc")
    private String j;

    public int f() {
        return this.h;
    }

    public String b() {
        return this.b;
    }

    public String a() {
        return this.i;
    }

    public String e() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f12745a;
    }

    public String toString() {
        return "DoctorBasicInfoResponse{mResultCode=" + this.h + ", mResultDescription=" + this.j + ", mDoctorId=" + this.b + ", mDoctorName=" + this.i + ", mDoctorHeadIcon=" + this.d + ", mDoctorDepartment=" + this.e + ", mDoctorLevel=" + this.f12745a + ", mDoctorHospital=" + this.c + "}";
    }
}
