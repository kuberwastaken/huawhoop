package defpackage;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ghy {
    private Map<Integer, List<ShareDataInfo>> c = new HashMap();

    public ghy() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.c.put(2, arrayList);
        this.c.put(4, arrayList2);
    }

    public List<ShareDataInfo> a() {
        return this.c.get(2);
    }

    public void d(List<ShareDataInfo> list) {
        this.c.put(2, list);
    }

    public List<ShareDataInfo> c() {
        return this.c.get(4);
    }

    public void b(List<ShareDataInfo> list) {
        this.c.put(4, list);
    }

    public List<ShareDataInfo> a(int i) {
        return this.c.get(Integer.valueOf(i)) == null ? Collections.emptyList() : this.c.get(Integer.valueOf(i));
    }

    public void e(int i, List<ShareDataInfo> list) {
        this.c.put(Integer.valueOf(i), list);
    }

    public List<ShareDataInfo> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a());
        arrayList.addAll(c());
        return arrayList;
    }

    public void c(List<ghz> list) {
        List<ShareDataInfo> listA;
        if (list == null || (listA = a()) == null) {
            return;
        }
        listA.clear();
        listA.addAll(list);
    }

    public void e(List<gic> list) {
        List<ShareDataInfo> listC;
        if (list == null || (listC = c()) == null) {
            return;
        }
        listC.clear();
        listC.addAll(list);
    }
}
