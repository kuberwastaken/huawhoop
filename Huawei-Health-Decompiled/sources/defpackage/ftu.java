package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftu implements IRequest {

    @SerializedName("planId")
    private String b;

    @SerializedName("remindTime")
    private Integer c;

    private ftu(c cVar) {
        this.b = cVar.b;
        this.c = cVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bh();
    }

    public static final class c {
        private String b;
        private Integer e;

        public c c(String str) {
            this.b = str;
            return this;
        }

        public c b(Integer num) {
            this.e = num;
            return this;
        }

        public ftu a() {
            return new ftu(this);
        }
    }
}
