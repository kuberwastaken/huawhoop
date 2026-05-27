package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes9.dex */
public class ftl implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pageNum")
    private Integer f13164a;

    @SerializedName("lang")
    private String c;

    @SerializedName("topicId")
    private Integer d;

    private ftl(e eVar) {
        this.f13164a = eVar.d;
        this.d = eVar.f13165a;
        this.c = eVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ar();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13165a;
        private String b;
        private Integer d;

        public e a(Integer num) {
            this.d = num;
            return this;
        }

        public e d(Integer num) {
            this.f13165a = num;
            return this;
        }

        public e b(String str) {
            this.b = str;
            return this;
        }

        public ftl b() {
            return new ftl(this);
        }
    }
}
