package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftd implements IRequest {

    @SerializedName("planId")
    private String c;

    @SerializedName("lang")
    private String e;

    private ftd(c cVar) {
        this.c = cVar.e;
        this.e = cVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ah();
    }

    public static final class c {
        private String b;
        private String e;

        public c b(String str) {
            this.e = str;
            return this;
        }

        public c a(String str) {
            this.b = str;
            return this;
        }

        public ftd a() {
            return new ftd(this);
        }
    }
}
