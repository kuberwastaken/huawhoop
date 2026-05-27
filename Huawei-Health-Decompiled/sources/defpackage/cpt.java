package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cpt extends CloudCommonReponse {

    @SerializedName("familyCareRelations")
    private List<b> b;

    @SerializedName("followUsers")
    private List<Long> d;

    public List<Long> d() {
        return this.d;
    }

    public List<b> e() {
        return this.b;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("emergencyName")
        private String f11979a;

        @SerializedName("createTime")
        private long b;

        @SerializedName("emergencyPhoneNum")
        private String c;

        @SerializedName("followUser")
        private long d;

        @SerializedName("devId")
        private String e;

        @SerializedName("status")
        private int f;

        @SerializedName("locationTime")
        private long g;

        @SerializedName("followedUser")
        private long h;

        @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
        private long j;

        public long b() {
            return this.d;
        }

        public String a() {
            return this.f11979a;
        }

        public String e() {
            return this.c;
        }
    }
}
