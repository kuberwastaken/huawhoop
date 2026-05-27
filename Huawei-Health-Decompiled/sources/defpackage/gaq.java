package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class gaq {
    private static final double[] e = {648000.0d, 324000.0d, 162000.0d, 81000.0d, 40500.0d, 20250.0d, 10125.0d, 5062.5d, 2531.25d, 1265.625d, 632.8125d, 316.40625d, 158.203125d, 79.1015625d, 39.55078125d, 19.775390625d, 9.8876953125d, 4.94384765625d, 2.471923828125d, 1.2359619140625d, 0.61798095703125d, 0.308990478515625d};

    public static String e(double d, double d2, int i) {
        if (i < 0 || i > 21) {
            return null;
        }
        double[] dArr = e;
        return ((int) Math.floor(((d2 + 180.0d) * 3600.0d) / dArr[i])) + "_" + ((int) Math.floor(((90.0d - d) * 3600.0d) / dArr[i]));
    }

    private static double[] a(double d, double d2, double d3) {
        double d4 = (d * 3.141592653589793d) / 180.0d;
        double d5 = (d2 * 3.141592653589793d) / 180.0d;
        double d6 = d3 / 6371.0d;
        double dAsin = Math.asin(Math.sin(d6) / Math.cos(d4));
        return new double[]{((d4 - d6) * 180.0d) / 3.141592653589793d, ((d5 - dAsin) * 180.0d) / 3.141592653589793d, ((d4 + d6) * 180.0d) / 3.141592653589793d, ((d5 + dAsin) * 180.0d) / 3.141592653589793d};
    }

    public static List<String> e(double d, double d2, int i, double d3) {
        double[] dArrA = a(d, d2, d3);
        double d4 = dArrA[0];
        double d5 = dArrA[1];
        double d6 = dArrA[2];
        double d7 = dArrA[3];
        String strE = e(d6, d5, i);
        String strE2 = e(d4, d7, i);
        if (strE == null || strE2 == null) {
            return new ArrayList();
        }
        String[] strArrSplit = strE.split("_");
        int i2 = Integer.parseInt(strArrSplit[1]);
        String[] strArrSplit2 = strE2.split("_");
        int i3 = Integer.parseInt(strArrSplit2[0]);
        int i4 = Integer.parseInt(strArrSplit2[1]);
        ArrayList arrayList = new ArrayList();
        for (int i5 = Integer.parseInt(strArrSplit[0]); i5 <= i3; i5++) {
            for (int i6 = i2; i6 <= i4; i6++) {
                arrayList.add(i5 + "_" + i6);
            }
        }
        return arrayList;
    }
}
