package defpackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fuv implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planId")
    private String f13206a;

    @SerializedName("status")
    @Expose
    private int c;

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.b(this.f13206a);
    }

    public void b(String str) {
        this.f13206a = str;
    }

    public void c(int i) {
        this.c = i;
    }
}
