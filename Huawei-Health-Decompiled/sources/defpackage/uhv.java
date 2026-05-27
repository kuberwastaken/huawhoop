package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes11.dex */
public class uhv implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("deviceId")
    private String f18306a;

    @SerializedName("petalOaid")
    private String d;

    @SerializedName("phoneType")
    private String e;

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return null;
    }

    protected uhv(e eVar) {
        this.e = eVar.f18307a;
        this.d = eVar.e;
        this.f18306a = eVar.b;
    }

    public static class e<T extends e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f18307a;
        private String b;
        private String e;

        public T c(String str) {
            this.e = str;
            return this;
        }

        public T e(String str) {
            this.b = str;
            return this;
        }

        public T d(String str) {
            this.f18307a = str;
            return this;
        }
    }
}
