package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fud implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pageNum")
    private Integer f13183a;

    @SerializedName("startTime")
    private Long c;

    @SerializedName("endTime")
    private Long d;

    @SerializedName("smartScreenLogsFlag")
    private Integer e;

    private fud(d dVar) {
        this.c = dVar.c;
        this.d = dVar.f13184a;
        this.f13183a = dVar.d;
        this.e = dVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bw();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f13184a;
        private Long c;
        private Integer d;
        private Integer e;

        public d c(Long l) {
            this.c = l;
            return this;
        }

        public d d(Long l) {
            this.f13184a = l;
            return this;
        }

        public d a(Integer num) {
            this.d = num;
            return this;
        }

        public d c(Integer num) {
            this.e = num;
            return this;
        }

        public fud b() {
            return new fud(this);
        }
    }
}
