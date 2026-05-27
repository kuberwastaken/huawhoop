package defpackage;

import android.text.TextUtils;
import com.huawei.haf.common.utils.AbiUtil;
import com.huawei.hms.network.embedded.g4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f299a;
    private List<String> b;
    private final String c;
    private boolean d;
    private boolean e;
    private String f;
    private String g;
    private int h;
    private b i;
    private final String j;
    private long k;
    private int l;
    private String m;
    private long n;
    private List<String> o;

    private ask(String str, String str2) {
        this.j = str;
        this.c = str2;
    }

    public String j() {
        return this.j;
    }

    public String i() {
        return this.m;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public long h() {
        return this.k;
    }

    public long m() {
        return this.n;
    }

    public int b() {
        return this.l;
    }

    public boolean n() {
        return this.d;
    }

    public boolean p() {
        return this.e;
    }

    public b a() {
        return this.i;
    }

    public List<String> c() {
        return this.b;
    }

    public boolean l() {
        return this.f299a > 0;
    }

    public boolean k() {
        b bVar = this.i;
        return (bVar == null || bVar.b().isEmpty()) ? false : true;
    }

    public List<String> o() {
        return this.o;
    }

    public int d() {
        return this.h;
    }

    boolean q() {
        return (TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.f) || this.k <= 0) ? false : true;
    }

    public String e() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("{");
        sb.append(this.j);
        sb.append('_');
        sb.append(this.g);
        sb.append(", builtIn:");
        sb.append(this.d);
        sb.append(", isolated:");
        sb.append(this.e);
        sb.append(", size:");
        sb.append(this.k);
        if (!this.d) {
            sb.append(", zip(");
            sb.append(this.l);
            sb.append(", ");
            sb.append(this.n);
            sb.append(g4.l);
        }
        if (!this.b.isEmpty()) {
            sb.append(", dependencies:");
            sb.append(this.b);
        }
        if (!this.o.isEmpty()) {
            sb.append(", workProcesses:");
            sb.append(this.o);
        }
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(sb);
        }
        sb.append('}');
        return sb.toString();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<a> f300a;
        private final String d;

        private b(String str, List<a> list) {
            this.d = str;
            this.f300a = list;
        }

        public String c() {
            return this.d;
        }

        public List<a> b() {
            return this.f300a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public StringBuilder a(StringBuilder sb) {
            sb.append(", lib(");
            sb.append(this.d);
            sb.append(", ");
            sb.append(this.f300a.size());
            sb.append(g4.l);
            return sb;
        }

        public static class a {
            private final String c;
            private final String d;
            private final long e;

            private a(String str, String str2, long j) {
                this.c = str;
                this.d = str2;
                this.e = j;
            }

            public String b() {
                return this.c;
            }

            public String a() {
                return this.d;
            }

            public long d() {
                return this.e;
            }
        }
    }

    static ask e(String str, String str2, List<String> list, JSONObject jSONObject) {
        ask askVar = new ask(str2, str);
        askVar.d = jSONObject.optBoolean("builtIn");
        askVar.e = jSONObject.optBoolean("isolated");
        askVar.g = jSONObject.optString("version");
        askVar.m = jSONObject.optString("url");
        askVar.f = jSONObject.optString("sha256");
        askVar.n = jSONObject.optLong("zipSize");
        askVar.l = jSONObject.optInt("zipFileNum");
        askVar.k = jSONObject.optLong("size");
        askVar.h = jSONObject.optInt("minSdkVersion");
        askVar.f299a = jSONObject.optInt("dexNumber");
        askVar.o = b(jSONObject);
        askVar.b = c(jSONObject);
        askVar.i = a(jSONObject).get(AbiUtil.e(list));
        return askVar;
    }

    private static List<String> b(JSONObject jSONObject) {
        List<String> listEmptyList = Collections.emptyList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("workProcesses");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return listEmptyList;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            String strOptString = jSONArrayOptJSONArray.optString(i);
            if (strOptString != null) {
                arrayList.add(strOptString);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static List<String> c(JSONObject jSONObject) {
        List<String> listEmptyList = Collections.emptyList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dependencies");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return listEmptyList;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            String strOptString = jSONArrayOptJSONArray.optString(i);
            if (!TextUtils.isEmpty(strOptString)) {
                arrayList.add(strOptString);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static Map<String, b> a(JSONObject jSONObject) {
        Map<String, b> mapEmptyMap = Collections.emptyMap();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("nativeLibraries");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            mapEmptyMap = new HashMap<>(jSONArrayOptJSONArray.length());
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("abi");
                    if (!TextUtils.isEmpty(strOptString)) {
                        mapEmptyMap.put(strOptString, a(strOptString, jSONObjectOptJSONObject));
                    }
                }
            }
        }
        return mapEmptyMap;
    }

    private static b a(String str, JSONObject jSONObject) {
        List listEmptyList = Collections.emptyList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("jniLibs");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString("name");
                String strOptString2 = jSONObjectOptJSONObject.optString("sha256");
                long jOptLong = jSONObjectOptJSONObject.optLong("size");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && jOptLong != 0 && (strOptString.startsWith("lib") || strOptString.endsWith(".so"))) {
                    arrayList.add(new b.a(strOptString, strOptString2, jOptLong));
                }
            }
            listEmptyList = Collections.unmodifiableList(arrayList);
        }
        return new b(str, listEmptyList);
    }
}
