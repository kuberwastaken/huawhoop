package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftc implements IRequest {

    @SerializedName("planId")
    private String e;

    private ftc(d dVar) {
        this.e = dVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ag();
    }

    public static final class d {
        private String c;

        public d b(String str) {
            this.c = str;
            return this;
        }

        public ftc a() {
            return new ftc(this);
        }
    }
}
