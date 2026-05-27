package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class sra {
    public static long e(List<srm> list) {
        Iterator<srm> it = list.iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += it.next().b();
        }
        return jB;
    }

    public static srm d(List<srm> list) {
        for (srm srmVar : list) {
            if (!srmVar.e()) {
                return srmVar;
            }
        }
        return null;
    }
}
