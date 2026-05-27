package com.huawei.hms.network.file.a.j.a;

import com.huawei.hms.network.file.core.util.FLogger;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0159a f5793a = null;
    public ArrayList<Double> b;

    /* JADX INFO: renamed from: com.huawei.hms.network.file.a.j.a.a$a, reason: collision with other inner class name */
    static class C0159a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5794a;
        public boolean b;
        public C0159a c;
        public C0159a d;
        public int e;
        public double f;
        public double g;
    }

    public ArrayList<Double> a(ArrayList<double[]> arrayList) {
        ArrayList<Double> arrayList2 = new ArrayList<>();
        for (double[] dArr : arrayList) {
            double dA = a(dArr);
            if (dA == -1.0d || dA == -100.0d) {
                FLogger.e("DecisionTree", "predict error,  error for:" + Arrays.toString(dArr) + ",name:" + this.f5793a.f5794a);
            }
            arrayList2.add(Double.valueOf(dA));
        }
        this.b = arrayList2;
        return arrayList2;
    }

    private double a(double[] dArr) {
        C0159a c0159a = this.f5793a;
        C0159a c0159a2 = c0159a;
        while (c0159a2 != null) {
            if (c0159a2.b) {
                return c0159a2.f;
            }
            C0159a c0159a3 = c0159a2.c;
            c0159a2 = (c0159a3 == null || dArr[c0159a2.e] >= c0159a2.g) ? c0159a2.d : c0159a3;
        }
        FLogger.e("DecisionTree", "predict error, parent:" + c0159a.f5794a);
        return -1.0d;
    }
}
