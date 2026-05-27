package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.sport.model.WorkoutRecord;

/* JADX INFO: loaded from: classes11.dex */
public class nzi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("operType")
    private int f16243a;

    @SerializedName("id")
    private String b;

    @SerializedName("sleepAudioUploadInfo")
    private nzn c;

    @SerializedName(WorkoutRecord.Extend.FIT_EXTEND_COURSE_TYPE)
    private int d;

    @SerializedName("seriesId")
    private String e;

    public void d(String str) {
        this.b = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void a(int i) {
        this.f16243a = i;
    }

    public void c(int i) {
        this.d = i;
    }
}
