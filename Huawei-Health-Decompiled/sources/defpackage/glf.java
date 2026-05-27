package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class glf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("description")
    private String f13513a;

    @SerializedName("langId")
    private String b;

    @SerializedName("langName")
    private String c;

    @SerializedName("fileSize")
    private int d;

    @SerializedName("jsonUrl")
    private String e;

    @SerializedName("timbre")
    private String f;

    @SerializedName("version")
    private String g;

    @SerializedName("language")
    private String h;

    @SerializedName("langUrl")
    private String i;

    @SerializedName("moduleName")
    private String j;

    public int c() {
        return this.d;
    }

    public String d() {
        return this.j;
    }

    public String b() {
        return this.e;
    }

    public String a() {
        return this.i;
    }

    public String j() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public String g() {
        return this.f;
    }

    public String toString() {
        return "VoiceBroadcastInfo{mLangName='" + this.c + "', mDescription='" + this.f13513a + "', mLangId='" + this.b + "', mVersion='" + this.g + "', mLanguage='" + this.h + "', mTimbre='" + this.f + "', mModuleName='" + this.j + "', mJsonUrl='" + this.e + "', mFileSize=" + this.d + '}';
    }
}
