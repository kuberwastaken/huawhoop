package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes10.dex */
public class ftg implements IRequest {

    @SerializedName("courseCategory")
    private Integer b;

    private ftg(c cVar) {
        this.b = cVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ai();
    }

    public static final class c {
        private Integer c;

        public c e(Integer num) {
            this.c = num;
            return this;
        }

        public ftg d() {
            return new ftg(this);
        }
    }
}
