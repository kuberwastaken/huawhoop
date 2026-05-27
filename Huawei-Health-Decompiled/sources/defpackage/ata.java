package defpackage;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.huawei.haf.common.security.SecurityConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
final class ata {
    private final Context e;
    private final SparseArray<asy> d = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f308a = new Object();

    ata(Context context) {
        this.e = context;
    }

    void b(int i, asy asyVar) {
        if (i != 0) {
            synchronized (this.f308a) {
                if (this.d.get(i) == null) {
                    this.d.put(i, asyVar);
                }
            }
        }
    }

    void c(int i, int i2) {
        synchronized (this.f308a) {
            asy asyVar = this.d.get(i);
            if (asyVar != null) {
                asyVar.c(i2);
                if (i2 == 7 || i2 == 6 || i2 == 10) {
                    this.d.remove(i);
                }
            }
        }
    }

    boolean b() {
        synchronized (this.f308a) {
            for (int size = this.d.size() - 1; size >= 0; size--) {
                int iB = this.d.valueAt(size).b();
                if (iB != 2 && iB != 1) {
                }
                return true;
            }
            return false;
        }
    }

    asy e(int i) {
        asy asyVar;
        synchronized (this.f308a) {
            asyVar = this.d.get(i);
        }
        return asyVar;
    }

    List<asy> d() {
        List<asy> listFC_;
        synchronized (this.f308a) {
            listFC_ = fC_(this.d);
        }
        return listFC_;
    }

    boolean c(List<String> list) {
        synchronized (this.f308a) {
            for (int size = this.d.size() - 1; size >= 0; size--) {
                List<String> listD = this.d.valueAt(size).d();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (listD.contains(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    void c(asy asyVar) {
        Intent intent = new Intent();
        intent.setPackage(this.e.getPackageName());
        intent.putExtra("session_state", asy.fA_(asyVar));
        intent.setAction("com.huawei.android.appbundle.splitinstall.receiver.SplitInstallUpdateIntentService");
        intent.addFlags(1073741824);
        intent.addFlags(2097152);
        this.e.sendBroadcast(intent, SecurityConstant.f2141a);
    }

    private static <C> List<C> fC_(SparseArray<C> sparseArray) {
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.valueAt(i));
        }
        return arrayList;
    }
}
