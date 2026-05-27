package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class bbm {
    public String c(List<bbk> list) {
        List<bbk> listD = d(b(a(e(list))));
        String strC = "";
        if (listD.size() > 0) {
            int iH = 0;
            for (bbk bbkVar : listD) {
                if (bbkVar.h() >= iH) {
                    iH = bbkVar.h();
                    strC = bbkVar.c();
                }
            }
        }
        return strC;
    }

    private List<bbk> e(List<bbk> list) {
        ArrayList arrayList = new ArrayList();
        for (bbk bbkVar : list) {
            if (bbkVar.b() > -1) {
                arrayList.add(bbkVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    private List<bbk> a(List<bbk> list) {
        ArrayList arrayList = new ArrayList();
        for (bbk bbkVar : list) {
            if (bbkVar.a() == 1) {
                arrayList.add(bbkVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    private List<bbk> b(List<bbk> list) {
        ArrayList arrayList = new ArrayList();
        for (bbk bbkVar : list) {
            if (bbkVar.e() == 0) {
                arrayList.add(bbkVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    private List<bbk> d(List<bbk> list) {
        ArrayList arrayList = new ArrayList();
        int iD = 0;
        for (bbk bbkVar : list) {
            if (bbkVar.d() > iD) {
                arrayList.clear();
                iD = bbkVar.d();
            } else if (bbkVar.d() != iD) {
                bbr.b.e("OptimizationCenter", "condition Low level");
            }
            arrayList.add(bbkVar);
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }
}
