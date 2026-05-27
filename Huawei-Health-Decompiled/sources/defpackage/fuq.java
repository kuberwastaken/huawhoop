package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fuq implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("reportUpdateTime")
    private long f13202a;

    @SerializedName("report")
    private String b;

    @SerializedName("planId")
    private String c;

    @SerializedName("planType")
    private int d;

    @SerializedName("reportType")
    private int e;

    private fuq(a aVar) {
        this.e = aVar.c;
        this.c = aVar.d;
        this.d = aVar.b;
        this.f13202a = aVar.e;
        this.b = aVar.f13203a;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bg();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13203a;
        private int b;
        private int c;
        private String d;
        private long e;

        public a d(int i) {
            this.c = i;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a e(long j) {
            this.e = j;
            return this;
        }

        public a a(String str) {
            this.f13203a = str;
            return this;
        }

        public fuq e() {
            return new fuq(this);
        }
    }
}
