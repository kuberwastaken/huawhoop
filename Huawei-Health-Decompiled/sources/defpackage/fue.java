package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fue implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pageNum")
    private Integer f13185a;

    @SerializedName("courseCategory")
    private Integer d;

    @SerializedName("lang")
    private String e;

    private fue(a aVar) {
        this.d = aVar.b;
        this.f13185a = aVar.f13186a;
        this.e = aVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bp();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13186a;
        private Integer b;
        private String c;

        public a e(Integer num) {
            this.b = num;
            return this;
        }

        public a d(Integer num) {
            this.f13186a = num;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public fue b() {
            return new fue(this);
        }
    }
}
