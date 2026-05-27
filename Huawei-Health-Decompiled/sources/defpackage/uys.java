package defpackage;

import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.ui.main.stories.template.data.PageDataObserver;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class uys {
    private static final uys b = new uys();
    private final Object c = new Object();
    private boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, Vector<PageDataObserver>> f18520a = new ConcurrentHashMap<>();

    private uys() {
    }

    public static uys d() {
        return b;
    }

    public void b(int i, PageDataObserver pageDataObserver) {
        synchronized (this) {
            if (pageDataObserver == null) {
                LogUtil.a("PageDataObservable", "addObserver : observer is null");
                return;
            }
            Vector<PageDataObserver> vector = this.f18520a.get(Integer.valueOf(i));
            if (vector == null) {
                vector = new Vector<>();
                this.f18520a.putIfAbsent(Integer.valueOf(i), vector);
            }
            if (!vector.contains(pageDataObserver)) {
                vector.addElement(pageDataObserver);
            }
        }
    }

    public void d(PageDataObserver pageDataObserver) {
        synchronized (this) {
            Iterator<Map.Entry<Integer, Vector<PageDataObserver>>> it = this.f18520a.entrySet().iterator();
            while (it.hasNext()) {
                Vector<PageDataObserver> value = it.next().getValue();
                if (value != null) {
                    value.removeElement(pageDataObserver);
                }
                if (mgx.d(value)) {
                    it.remove();
                }
            }
        }
    }

    public void c(int i, List<dam> list) {
        synchronized (this.c) {
            if (a()) {
                Vector<PageDataObserver> vector = this.f18520a.get(Integer.valueOf(i));
                if (vector == null) {
                    return;
                }
                List listAsList = Arrays.asList(vector.toArray());
                b();
                for (int size = listAsList.size() - 1; size >= 0; size--) {
                    if (listAsList.get(size) instanceof PageDataObserver) {
                        ((PageDataObserver) listAsList.get(size)).update(this, list);
                    }
                }
            }
        }
    }

    protected void c() {
        synchronized (this) {
            this.d = true;
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }

    protected void b() {
        synchronized (this) {
            this.d = false;
        }
    }
}
