package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ieb {
    public static irt e(irs irsVar) {
        return new irt(irsVar.j(), irsVar.i());
    }

    public static irt a(irt irtVar) {
        irt irtVarE = e(irtVar);
        return new irt(irtVar.d + irtVarE.d, irtVar.c + irtVarE.c);
    }

    public static List<irt> d(List<irt> list) {
        if (mgx.d(list)) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<irt> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public static irt c(irt irtVar) {
        irt irtVarE = e(irtVar);
        return new irt(irtVar.d - irtVarE.d, irtVar.c - irtVarE.c);
    }

    private static irt e(irt irtVar) {
        double dA = a(irtVar.c - 105.0d, irtVar.d - 35.0d);
        double dC = c(irtVar.c - 105.0d, irtVar.d - 35.0d);
        double d = (irtVar.d / 180.0d) * 3.141592653589793d;
        double dSin = Math.sin(d);
        double d2 = 1.0d - ((0.006693421622965943d * dSin) * dSin);
        double dSqrt = Math.sqrt(d2);
        return new irt((dA * 180.0d) / ((6335552.717000426d / (d2 * dSqrt)) * 3.141592653589793d), (dC * 180.0d) / (((6378245.0d / dSqrt) * Math.cos(d)) * 3.141592653589793d));
    }

    private static double a(double d, double d2) {
        double d3 = d * 2.0d;
        double dSqrt = Math.sqrt(Math.abs(d));
        double d4 = d2 * 3.141592653589793d;
        return (d3 - 100.0d) + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (dSqrt * 0.2d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin(d3 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d4) * 20.0d) + (Math.sin((d2 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d4 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double c(double d, double d2) {
        double d3 = d * 0.1d;
        double dSqrt = Math.sqrt(Math.abs(d));
        double dSin = (((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin((d * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (dSqrt * 0.1d) + dSin + ((((Math.sin(d * 3.141592653589793d) * 20.0d) + (Math.sin((d / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }
}
