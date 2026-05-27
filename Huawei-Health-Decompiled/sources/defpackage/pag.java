package defpackage;

import android.content.Context;
import com.huawei.taboo.TabooReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes7.dex */
public class pag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile pag f16585a;
    private Context e;
    private b d = null;
    private WeakHashMap<String, HashMap<String, String>> b = null;
    private List<String> c = null;

    public class b {
        private HashMap<String, String> c;
        private List<String> b = new ArrayList();
        private List<String> d = new ArrayList();
        private List<String> e = new ArrayList();

        public b(HashMap<String, String> map) {
            this.c = new HashMap<>();
            if (map.isEmpty()) {
                return;
            }
            this.c = map;
            e(map.get(TabooReader.ParamType.CITY_NAME.getScopeName()), map.get(TabooReader.ParamType.LANGUAGE_NAME.getScopeName()), map.get(TabooReader.ParamType.REGION_NAME.getScopeName()));
        }

        private void e(String str, String str2, String str3) {
            if (str != null && !str.isEmpty()) {
                this.b = Arrays.asList(str.split(","));
            }
            if (str2 != null && !str2.isEmpty()) {
                this.d = Arrays.asList(str2.split(","));
            }
            if (str3 == null || str3.isEmpty()) {
                return;
            }
            this.e = Arrays.asList(str3.split(","));
        }

        public List<String> e() {
            return this.b;
        }

        public List<String> c() {
            return this.d;
        }

        public List<String> a() {
            return this.e;
        }

        public String d(String str) {
            HashMap<String, String> map = this.c;
            return map != null ? map.get(str) : "";
        }
    }

    private pag(Context context) {
        this.e = context;
    }

    public static pag d(Context context) {
        if (f16585a == null) {
            synchronized (pag.class) {
                if (f16585a == null) {
                    f16585a = new pag(context);
                    f16585a.c = paf.e(context);
                    pag pagVar = f16585a;
                    pag pagVar2 = f16585a;
                    pagVar2.getClass();
                    pagVar.d = pagVar2.new b(paf.b(context));
                    if (f16585a.d.c == null || f16585a.d.c.isEmpty()) {
                        f16585a = null;
                    }
                }
            }
        }
        return f16585a;
    }

    public String b(String str, String str2) {
        HashMap<String, String> map;
        if (this.b == null) {
            this.b = new WeakHashMap<>();
        }
        if (this.b.containsKey(str) && (map = this.b.get(str)) != null && map.containsKey(str2)) {
            return map.get(str2);
        }
        HashMap<String, String> mapC = new paf().c(str, this.e);
        if (mapC.isEmpty()) {
            return "";
        }
        this.b.put(str, mapC);
        return mapC.get(str2);
    }

    public b c() {
        return this.d;
    }

    public List<String> a() {
        return this.c;
    }

    public Context e() {
        return this.e;
    }
}
