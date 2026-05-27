package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fuj implements IRequest {

    @SerializedName("planType")
    private int b;

    @SerializedName("planId")
    private String c;

    private fuj(a aVar) {
        this.c = aVar.e;
        this.b = aVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.cb();
    }

    public static final class a {
        private int c;
        private String e;

        public a e(String str) {
            this.e = str;
            return this;
        }

        public a c(int i) {
            this.c = i;
            return this;
        }

        public fuj a() {
            return new fuj(this);
        }
    }

    public int b() {
        return this.b;
    }

    public String e() {
        return this.c;
    }
}
