package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;

/* JADX INFO: loaded from: classes4.dex */
public class fsm implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("userDefinedType")
    private Integer f13137a;

    @SerializedName("fuzzyKeyWords")
    private String b;

    @SerializedName("trainingPoints")
    private Integer c;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private Integer d;

    @SerializedName("pageStart")
    private Integer e;

    private fsm(e eVar) {
        this.e = eVar.c;
        this.d = eVar.f13138a;
        this.c = eVar.e;
        this.b = eVar.d;
        this.f13137a = eVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.s();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13138a;
        private Integer b;
        private Integer c;
        private String d;
        private Integer e;

        public e a(Integer num) {
            this.c = num;
            return this;
        }

        public e e(Integer num) {
            this.f13138a = num;
            return this;
        }

        public e b(Integer num) {
            this.e = num;
            return this;
        }

        public e b(String str) {
            this.d = str;
            return this;
        }

        public e d(Integer num) {
            this.b = num;
            return this;
        }

        public fsm b() {
            return new fsm(this);
        }
    }
}
