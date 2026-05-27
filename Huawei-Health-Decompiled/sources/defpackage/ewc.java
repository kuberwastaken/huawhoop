package defpackage;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class ewc {
    public static void a(LinkedList linkedList) {
        if (linkedList == null) {
            return;
        }
        int size = linkedList.size();
        for (int i = 0; i < size - 15; i++) {
            linkedList.removeFirst();
        }
    }

    public static float a(evz evzVar, evz evzVar2) {
        if (evzVar == null || evzVar2 == null) {
            return 0.0f;
        }
        float fB = b(evzVar, evzVar2);
        if (evzVar.d() == 0.0f || evzVar2.d() == 0.0f) {
            return fB;
        }
        return (float) Math.sqrt(Math.pow(fB, 2.0d) + Math.pow(Math.abs(evzVar.d() - evzVar2.d()), 2.0d));
    }

    public static float c(evz evzVar, evz evzVar2) {
        if (evzVar == null || evzVar2 == null) {
            return 0.0f;
        }
        float fB = b(evzVar, evzVar2);
        long jG = evzVar2.g() - evzVar.g();
        if (jG <= 0) {
            return 0.0f;
        }
        return (fB * 1000.0f) / jG;
    }

    public static float b(evz evzVar, evz evzVar2) {
        if (evzVar == null || evzVar2 == null) {
            return 0.0f;
        }
        if (Math.abs(evzVar.i() - evzVar2.i()) < 1.0E-9d && Math.abs(evzVar.j() - evzVar2.j()) < 1.0E-9d) {
            return 0.0f;
        }
        double dI = evzVar.i() * 0.017453292519943295d;
        double dI2 = evzVar2.i() * 0.017453292519943295d;
        double dSin = (Math.sin(dI) * Math.sin(dI2)) + (Math.cos(dI) * Math.cos(dI2) * Math.cos((evzVar2.j() * 0.017453292519943295d) - (evzVar.j() * 0.017453292519943295d)));
        if (dSin > 1.0d) {
            dSin = 1.0d;
        }
        if (dSin < -1.0d) {
            dSin = -1.0d;
        }
        return ((float) (Math.acos(dSin) * 6371.0d)) * 1000.0f;
    }
}
