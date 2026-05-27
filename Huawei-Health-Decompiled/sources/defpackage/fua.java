package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fua implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("ids")
    private String f13182a;

    private fua(d dVar) {
        this.f13182a = dVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bi();
    }

    public static final class d {
        private String c;

        public d a(String str) {
            this.c = str;
            return this;
        }

        public fua e() {
            return new fua(this);
        }
    }
}
