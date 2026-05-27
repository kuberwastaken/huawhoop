package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;
import com.huawei.ui.main.stories.recommendcloud.constants.RecommendConstants;

/* JADX INFO: loaded from: classes4.dex */
public class eqf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(BleConstants.KEY_PATH)
    private String f12730a;

    @SerializedName(RecommendConstants.DOWNLOAD_URL)
    private String b;

    @SerializedName(RecommendConstants.FILE_ID)
    private String c;

    @SerializedName(RecommendConstants.VER)
    private int d;
    private int e;

    public String a() {
        return this.c;
    }

    public eqf a(String str) {
        this.c = str;
        return this;
    }

    public int d() {
        return this.d;
    }

    public eqf b(int i) {
        this.d = i;
        return this;
    }

    public eqf b(String str) {
        this.b = str;
        return this;
    }

    public int e() {
        return this.e;
    }

    public eqf e(int i) {
        this.e = i;
        return this;
    }

    public String b() {
        return this.f12730a;
    }

    public eqf e(String str) {
        this.f12730a = str;
        return this;
    }

    public String toString() {
        return "VoiceConfigData{mFileName='" + this.c + "', mVersion=" + this.d + ", mDownloadUrl='" + this.b + "', mFileSize=" + this.e + ", mFilePath='" + this.f12730a + "'}";
    }
}
