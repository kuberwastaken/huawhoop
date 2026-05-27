package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.model.MedalConstants;

/* JADX INFO: loaded from: classes4.dex */
public class fuk implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(MedalConstants.EVENT_KEYTYPE)
    private String f13191a;

    @SerializedName("value")
    private d b;

    @SerializedName(MedalConstants.EVENT_KEY)
    private String d;

    @SerializedName("timestamp")
    private Long e;

    private fuk(a aVar) {
        this.d = aVar.b;
        this.f13191a = aVar.c;
        this.e = aVar.f13192a;
        this.b = aVar.d;
    }

    public static class d {

        @SerializedName("duration")
        private Integer c;

        @SerializedName("calorie")
        private Float e;

        private d(b bVar) {
            this.e = bVar.e;
            this.c = bVar.f13193a;
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Integer f13193a;
            private Float e;

            public b a(Float f) {
                this.e = f;
                return this;
            }

            public b a(Integer num) {
                this.f13193a = num;
                return this;
            }

            public d d() {
                return new d(this);
            }
        }
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bs();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f13192a;
        private String b;
        private String c;
        private d d;

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a b(Long l) {
            this.f13192a = l;
            return this;
        }

        public a a(d dVar) {
            this.d = dVar;
            return this;
        }

        public fuk d() {
            return new fuk(this);
        }
    }
}
