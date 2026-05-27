package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class eqj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("doctorId")
    private String f12734a;

    @SerializedName("doctorHospital")
    private String b;

    @SerializedName("doctorLevel")
    private String c;

    @SerializedName("doctorHeadIcon")
    private String d;

    @SerializedName("doctorDepartment")
    private String e;

    @SerializedName("doctorName")
    private String g;

    public String toString() {
        return "DoctorBasicInfoMap{mDoctorId=" + this.f12734a + ", mDoctorName=" + this.g + ", mDoctorHeadIcon=" + this.d + ", mDoctorDepartment=" + this.e + ", mDoctorLevel=" + this.c + ", mDoctorHospital=" + this.b + "}";
    }
}
