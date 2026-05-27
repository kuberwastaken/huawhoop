package defpackage;

import com.huawei.ui.main.stories.privacy.template.model.bean.PrivacyDataModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class uqm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile uqm f18437a;
    private static final Object e = new Object();
    private Map<String, List<PrivacyDataModel>> b = new LinkedHashMap(10);

    public static uqm e() {
        if (f18437a == null) {
            synchronized (e) {
                if (f18437a == null) {
                    f18437a = new uqm();
                }
            }
        }
        return f18437a;
    }

    public List<PrivacyDataModel> d(String str) {
        return this.b.get(str);
    }

    public Map<String, List<PrivacyDataModel>> c() {
        return this.b;
    }

    public void e(String str, PrivacyDataModel privacyDataModel) {
        if (this.b.containsKey(str)) {
            this.b.get(str).add(privacyDataModel);
            return;
        }
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(privacyDataModel);
        this.b.put(str, arrayList);
    }

    public void d() {
        this.b.clear();
    }
}
