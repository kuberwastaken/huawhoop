package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class sec extends sdy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("taskId")
    private String f17677a;

    @SerializedName("taskPoints")
    private long e;

    public void d(long j) {
        this.e = j;
    }

    public void e(String str) {
        this.f17677a = str;
    }
}
