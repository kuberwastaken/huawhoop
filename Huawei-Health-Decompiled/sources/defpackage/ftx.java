package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.messagecenter.model.CommonUtil;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes10.dex */
public class ftx implements IRequest {

    @SerializedName(CommonUtil.PAGE_TYPE)
    private Integer c;

    private ftx(a aVar) {
        this.c = aVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bq();
    }

    public static final class a {
        private Integer d;

        public a c(Integer num) {
            this.d = num;
            return this;
        }

        public ftx b() {
            return new ftx(this);
        }
    }
}
