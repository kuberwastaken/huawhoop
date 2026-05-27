package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;
import com.huawei.operation.h5pro.jsmodules.complaint.ComplaintConstants;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class fxa {

    @SerializedName("competitions")
    private List<b> b;

    @SerializedName("resultDesc")
    private String c;

    @SerializedName("total")
    private int d;

    @SerializedName("resultCode")
    private int e;

    public List<b> c() {
        return this.b;
    }

    public List<b> a() {
        ArrayList arrayList = new ArrayList();
        if (mgx.d(this.b)) {
            return arrayList;
        }
        for (b bVar : this.b) {
            if (!kql.z(bVar.a())) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "MyCompetitionsBean{resultCode=" + this.e + ", resultDesc='" + this.c + "', total=" + this.d + ", competitions=" + this.b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fxa)) {
            return false;
        }
        fxa fxaVar = (fxa) obj;
        return this.e == fxaVar.e && this.d == fxaVar.d && Objects.equals(this.c, fxaVar.c) && Objects.equals(this.b, fxaVar.b);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.e), this.c, Integer.valueOf(this.d), this.b);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("createTime")
        private long f13325a;

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        private String b;

        @SerializedName("country")
        private String c;

        @SerializedName("competitionId")
        private String d;

        @SerializedName(DistrictSearchQuery.KEYWORDS_CITY)
        private String e;

        @SerializedName("id")
        private String f;

        @SerializedName("groups")
        private List<e> g;

        @SerializedName("name")
        private String h;

        @SerializedName("eventTime")
        private long i;

        @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
        private long j;

        @SerializedName("subType")
        private int k;

        @SerializedName("timeZone")
        private String l;

        @SerializedName(BleConstants.TOTAL_DISTANCE)
        private String m;

        @SerializedName("source")
        private String n;

        @SerializedName("primary")
        private int o;

        @SerializedName("type")
        private int p;

        @SerializedName("unit")
        private String t;

        public String b() {
            return this.f;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.h;
        }

        public long a() {
            return this.i;
        }

        public String i() {
            return this.l;
        }

        public int f() {
            return this.o;
        }

        public List<e> e() {
            return this.g;
        }

        public String toString() {
            return "Competition{id='" + this.f + "', competitionId='" + this.d + "', type=" + this.p + ", subType=" + this.k + ", name='" + this.h + "', source='" + this.n + "', eventTime=" + this.i + ", timeZone='" + this.l + "', totalDistance='" + this.m + "', unit='" + this.t + "', desc='" + this.b + "', country='" + this.c + "', city='" + this.e + "', primary=" + this.o + ", createTime=" + this.f13325a + ", modifyTime=" + this.j + ", groups=" + this.g + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.p == bVar.p && this.k == bVar.k && this.i == bVar.i && this.o == bVar.o && this.f13325a == bVar.f13325a && this.j == bVar.j && Objects.equals(this.f, bVar.f) && Objects.equals(this.d, bVar.d) && Objects.equals(this.h, bVar.h) && Objects.equals(this.n, bVar.n) && Objects.equals(this.l, bVar.l) && Objects.equals(this.m, bVar.m) && Objects.equals(this.t, bVar.t) && Objects.equals(this.b, bVar.b) && Objects.equals(this.c, bVar.c) && Objects.equals(this.e, bVar.e) && Objects.equals(this.g, bVar.g);
        }

        public int hashCode() {
            return Objects.hash(this.f, this.d, Integer.valueOf(this.p), Integer.valueOf(this.k), this.h, this.n, Long.valueOf(this.i), this.l, this.m, this.t, this.b, this.c, this.e, Integer.valueOf(this.o), Long.valueOf(this.f13325a), Long.valueOf(this.j), this.g);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(ComplaintConstants.GROUP_NAME_PARAM_KEY)
        private String f13327a;

        @SerializedName(TypedValues.Custom.S_DIMENSION)
        private String b;

        @SerializedName("groupType")
        private int c;

        @SerializedName("groupId")
        private String d;

        @SerializedName("id")
        private String e;

        @SerializedName("unit")
        private String f;

        @SerializedName("value")
        private String h;

        @SerializedName(ParsedFieldTag.KAKA_VALUE_TYPE)
        private String i;

        @SerializedName("objectiveInfos")
        private List<d> j;

        public String e() {
            return this.h;
        }

        public List<d> c() {
            return this.j;
        }

        public String toString() {
            return "Group{id='" + this.e + "', groupId='" + this.d + "', groupType=" + this.c + ", groupName='" + this.f13327a + "', dimension='" + this.b + "', valueType='" + this.i + "', value='" + this.h + "', unit='" + this.f + "', objectiveInfos=" + this.j + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.c == eVar.c && Objects.equals(this.e, eVar.e) && Objects.equals(this.d, eVar.d) && Objects.equals(this.f13327a, eVar.f13327a) && Objects.equals(this.b, eVar.b) && Objects.equals(this.i, eVar.i) && Objects.equals(this.h, eVar.h) && Objects.equals(this.f, eVar.f) && Objects.equals(this.j, eVar.j);
        }

        public int hashCode() {
            return Objects.hash(this.e, this.d, Integer.valueOf(this.c), this.f13327a, this.b, this.i, this.h, this.f, this.j);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("objectiveType")
        private int f13326a;

        @SerializedName("index")
        private int c;

        @SerializedName("goalValue")
        private String d;

        @SerializedName("goalValueType")
        private String e;

        public String d() {
            return this.d;
        }

        public String toString() {
            return "ObjectiveInfo{index=" + this.c + ", objectiveType=" + this.f13326a + ", goalValue='" + this.d + "', goalValueType='" + this.e + "'}";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.c == dVar.c && this.f13326a == dVar.f13326a && Objects.equals(this.d, dVar.d) && Objects.equals(this.e, dVar.e);
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.c), Integer.valueOf(this.f13326a), this.d, this.e);
        }
    }
}
