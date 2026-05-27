package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftq implements IRequest {

    @SerializedName("planId")
    private String b;

    @SerializedName("name")
    private String d;

    private ftq(c cVar) {
        this.b = cVar.b;
        this.d = cVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ax();
    }

    public static final class c {
        private String b;
        private String e;

        public c e(String str) {
            this.b = str;
            return this;
        }

        public c d(String str) {
            this.e = str;
            return this;
        }

        public ftq a() {
            return new ftq(this);
        }
    }
}
