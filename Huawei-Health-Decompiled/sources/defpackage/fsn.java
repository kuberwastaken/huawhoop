package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsn implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("actualDistance")
    private Integer f13139a;

    @SerializedName("completionRate")
    private Float b;

    @SerializedName("duration")
    private Long c;

    @SerializedName("dateTime")
    private Long d;

    @SerializedName("actualCalorie")
    private Float e;

    @SerializedName("planId")
    private String f;

    private fsn(d dVar) {
        this.f = dVar.i;
        this.b = dVar.e;
        this.f13139a = dVar.b;
        this.c = dVar.f13140a;
        this.e = dVar.d;
        this.d = dVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.r();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f13140a;
        private Integer b;
        private Long c;
        private Float d;
        private Float e;
        private String i;

        public d c(String str) {
            this.i = str;
            return this;
        }

        public d a(Float f) {
            this.e = f;
            return this;
        }

        public d c(Integer num) {
            this.b = num;
            return this;
        }

        public d e(Float f) {
            this.d = f;
            return this;
        }

        public d e(Long l) {
            this.f13140a = l;
            return this;
        }

        public d d(Long l) {
            this.c = l;
            return this;
        }

        public fsn d() {
            return new fsn(this);
        }
    }
}
