package defpackage;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ghv {
    private Map<Integer, List<ShareDataInfo>> b = new HashMap();

    public ghv() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.b.put(1, arrayList2);
        this.b.put(2, arrayList);
        this.b.put(3, arrayList3);
        this.b.put(4, arrayList4);
    }

    public List<ShareDataInfo> c() {
        return this.b.get(2);
    }

    public void c(List<ShareDataInfo> list) {
        this.b.put(2, list);
    }

    public List<ShareDataInfo> a() {
        return this.b.get(1);
    }

    public void f(List<ShareDataInfo> list) {
        this.b.put(1, list);
    }

    public List<ShareDataInfo> d() {
        return this.b.get(3);
    }

    public void j(List<ShareDataInfo> list) {
        this.b.put(3, list);
    }

    public List<ShareDataInfo> b() {
        return this.b.get(4);
    }

    public void g(List<ShareDataInfo> list) {
        this.b.put(4, list);
    }

    public List<ShareDataInfo> d(int i) {
        return this.b.get(Integer.valueOf(i)) == null ? Collections.emptyList() : this.b.get(Integer.valueOf(i));
    }

    public void b(int i, List<ShareDataInfo> list) {
        this.b.put(Integer.valueOf(i), list);
    }

    public List<ShareDataInfo> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d());
        arrayList.addAll(c());
        arrayList.addAll(b());
        arrayList.addAll(a());
        return arrayList;
    }

    public void e(List<ghx> list) {
        if (list != null) {
            c().clear();
            c().addAll(list);
        }
    }

    public void d(List<ghw> list) {
        if (list != null) {
            a().clear();
            a().addAll(list);
        }
    }

    public void b(List<gig> list) {
        if (list != null) {
            d().clear();
            d().addAll(list);
        }
    }

    public void a(List<gid> list) {
        if (list != null) {
            b().clear();
            b().addAll(list);
        }
    }
}
