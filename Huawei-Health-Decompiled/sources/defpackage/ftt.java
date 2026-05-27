package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ftt implements IRequest {

    @SerializedName(ParsedFieldTag.TASK_COMPLETE_TIME)
    private Long c;

    @SerializedName("id")
    private String d;

    @SerializedName("bestRecords")
    private Map<String, String> e;

    private ftt(c cVar) {
        this.e = cVar.f13171a;
        this.d = cVar.d;
        this.c = cVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.be();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, String> f13171a;
        private String d;
        private Long e;

        public c c(Map<String, String> map) {
            this.f13171a = map;
            return this;
        }

        public c d(String str) {
            this.d = str;
            return this;
        }

        public c a(Long l) {
            this.e = l;
            return this;
        }

        public ftt e() {
            return new ftt(this);
        }
    }
}
