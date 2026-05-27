package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class pq {
    public int b;
    public ArrayList<pj> e;

    public int b() {
        int i;
        try {
            int i2 = 0;
            for (pj pjVar : this.e) {
                if (pjVar.d.d.equals("continuous")) {
                    pl plVar = pjVar.d;
                    i = plVar.b + plVar.f16753a;
                } else {
                    i = pjVar.d.b + 48;
                }
                if (i > i2) {
                    i2 = i;
                }
            }
            return i2;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
