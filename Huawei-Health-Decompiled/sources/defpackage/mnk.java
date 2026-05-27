package defpackage;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.health.messagecenter.model.CommonUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mnk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("extraProcessTypes")
    private List<b> f15734a;

    @SerializedName("dictTypes")
    private List<e> b;

    @SerializedName("version")
    private int d;

    public List<e> d() {
        return this.b;
    }

    public List<b> c() {
        return this.f15734a;
    }

    public class b {

        @SerializedName("typeId")
        private int d;

        @SerializedName("processUrl")
        private String e;

        public int e() {
            return this.d;
        }

        public String c() {
            return this.e;
        }

        public String toString() {
            return "ExtraProcessType{typeId=" + this.d + ", processUrl='" + this.e + "'}";
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("typeId")
        private int f15735a;

        @SerializedName("fields")
        private List<c> c;

        @SerializedName("syncType")
        private int d;

        @SerializedName("name")
        private String e;

        public int a() {
            return this.d;
        }

        public int g() {
            return this.f15735a;
        }

        public String d() {
            return this.e;
        }

        public List<c> b() {
            return this.c;
        }

        public List<Integer> e() {
            HashSet hashSet = new HashSet();
            for (c cVar : b()) {
                if (cVar.a() != 0) {
                    hashSet.add(Integer.valueOf(cVar.a()));
                } else {
                    hashSet.add(Integer.valueOf(cVar.e()));
                }
            }
            return new ArrayList(hashSet);
        }

        public List<Integer> c() {
            HashSet hashSet = new HashSet();
            for (c cVar : b()) {
                if (!TextUtils.isEmpty(cVar.b())) {
                    Iterator<c.b> it = cVar.j().iterator();
                    while (it.hasNext()) {
                        hashSet.add(Integer.valueOf(it.next().e()));
                    }
                }
            }
            return new ArrayList(hashSet);
        }

        public int d(String str) {
            for (c cVar : b()) {
                if (!TextUtils.isEmpty(cVar.b()) && cVar.b().equals(str)) {
                    return TextUtils.isEmpty(cVar.c()) ? cVar.e() : cVar.a();
                }
            }
            return -1;
        }

        public class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @SerializedName("isMetaData")
            boolean f15736a;

            @SerializedName(CommonUtil.PARAM_HEALTH_TYPE)
            int b;

            @SerializedName("format")
            String c;

            @SerializedName("mappingName")
            String d;

            @SerializedName("mappingId")
            int e;

            @SerializedName("statMappings")
            List<b> g;

            @SerializedName("metaName")
            String i;

            @SerializedName("name")
            String j;

            public String d() {
                return this.i;
            }

            public boolean f() {
                return this.f15736a;
            }

            public List<b> j() {
                return this.g;
            }

            public int a() {
                return this.e;
            }

            public String c() {
                return this.d;
            }

            public int e() {
                return this.b;
            }

            public String b() {
                return this.j;
            }

            public String toString() {
                return "Field{healthType=" + this.b + ", name='" + this.j + "', format='" + this.c + "', isMetaData=" + this.f15736a + ", mappingId=" + this.e + ", mappingName='" + this.d + "', statMappings=" + this.g + ", metaName='" + this.i + "'}";
            }

            public class b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                @SerializedName("statPolicy")
                String f15737a;

                @SerializedName("statName")
                String b;

                @SerializedName("statType")
                int e;

                public String b() {
                    return this.f15737a;
                }

                public int e() {
                    return this.e;
                }

                public String a() {
                    return this.b;
                }

                public String toString() {
                    return "StatMapping{statType=" + this.e + ", statName='" + this.b + "', statPolicies='" + this.f15737a + "'}";
                }
            }
        }

        public String toString() {
            return "DictConfig{typeId=" + this.f15735a + ", name='" + this.e + "', fields=" + this.c + '}';
        }
    }

    public String toString() {
        return "DictConfig{mVersion=" + this.d + ", mExtraProcessTypes=" + this.f15734a + ", mDictTypes=" + this.b + '}';
    }
}
