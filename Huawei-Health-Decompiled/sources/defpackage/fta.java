package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fta implements IRequest {

    @SerializedName("planType")
    private int b;

    @SerializedName("reportType")
    private int c;

    @SerializedName("planId")
    private String e;

    private fta(a aVar) {
        this.c = aVar.b;
        this.e = aVar.f13154a;
        this.b = aVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ac();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13154a;
        private int b;
        private int d;

        public a d(int i) {
            this.b = i;
            return this;
        }

        public a b(String str) {
            this.f13154a = str;
            return this;
        }

        public a c(int i) {
            this.d = i;
            return this;
        }

        public fta b() {
            return new fta(this);
        }
    }
}
