package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class daq implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("timeZone")
    private String f12128a;

    @SerializedName("queryType")
    private String b;

    @SerializedName("queryDate")
    private int e;

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        if ("weekEncourage".equals(this.b) || "monthEncourage".equals(this.b)) {
            return dat.d();
        }
        return dat.c();
    }

    private daq(a aVar) {
        this.b = aVar.c;
        this.e = aVar.b;
        this.f12128a = hnb.c();
    }

    public static final class a {
        private int b;
        private String c;

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a e(int i) {
            this.b = i;
            return this;
        }

        public daq b() {
            return new daq(this);
        }
    }
}
