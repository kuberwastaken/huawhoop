package com.huawei.ui.homehealth.runcard.trackfragments.models;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$styleable;
import defpackage.rkv;
import health.compact.a.UnitUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class SportNounChildData {
    private Context b;
    private Resources c;
    private String[] e;
    private int[] h = {R.string._2130844432_res_0x7f021b10, R.string._2130844433_res_0x7f021b11, R.string._2130844434_res_0x7f021b12, R.string._2130844435_res_0x7f021b13, R.string._2130844436_res_0x7f021b14};
    private int[] f = {R.string._2130844437_res_0x7f021b15, R.string._2130844438_res_0x7f021b16, R.string._2130844439_res_0x7f021b17, R.string._2130844440_res_0x7f021b18, R.string._2130844436_res_0x7f021b14};
    private int[] d = {R.string._2130843287_res_0x7f021697, R.string._2130843288_res_0x7f021698, R.string._2130843289_res_0x7f021699, R.string._2130843290_res_0x7f02169a, R.string._2130843291_res_0x7f02169b};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f9975a = {R.string._2130843292_res_0x7f02169c, R.string._2130843293_res_0x7f02169d, R.string._2130843294_res_0x7f02169e, R.string._2130843295_res_0x7f02169f, R.string._2130843291_res_0x7f02169b};

    public SportNounChildData() {
    }

    public SportNounChildData(Context context) {
        this.b = context;
        this.c = context.getResources();
    }

    public List<rkv> d() {
        String[] strArr = {this.c.getString(R.string._2130842234_res_0x7f02127a), this.c.getString(R.string._2130843168_res_0x7f021620), this.c.getString(R.string._2130840054_res_0x7f0209f6)};
        String[] strArr2 = {String.format(this.c.getString(R.string._2130846965_res_0x7f0224f5), 60, 100, 60), this.c.getString(R.string._2130843103_res_0x7f0215df), this.c.getString(R.string._2130840055_res_0x7f0209f7)};
        ArrayList arrayList = new ArrayList(3);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> j() {
        String[] strArr = {this.c.getString(R.string._2130844415_res_0x7f021aff), this.c.getString(R.string._2130839884_res_0x7f02094c)};
        String[] strArr2 = {String.format(this.c.getString(R.string._2130843089_res_0x7f0215d1), 180), this.c.getString(R.string._2130843090_res_0x7f0215d2)};
        ArrayList arrayList = new ArrayList(2);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> h() {
        String[] strArr = {this.c.getString(R.string._2130843051_res_0x7f0215ab), this.c.getString(R.string._2130843489_res_0x7f021761), this.c.getString(R.string._2130844064_res_0x7f0219a0), this.c.getString(R.string._2130843053_res_0x7f0215ad), this.c.getString(R.string._2130843101_res_0x7f0215dd), this.c.getString(R.string._2130843099_res_0x7f0215db), this.c.getString(R.string._2130843065_res_0x7f0215b9)};
        String[] strArr2 = {String.format(this.c.getString(R.string._2130843091_res_0x7f0215d3), 200), String.format(this.c.getString(R.string._2130844073_res_0x7f0219a9), Integer.valueOf(R$styleable.AppCompatTheme_windowMinWidthMinor)), String.format(this.c.getString(R.string._2130844078_res_0x7f0219ae), Float.valueOf(1.5f)), String.format(this.c.getString(R.string._2130843093_res_0x7f0215d5), 6, 20), String.format(this.c.getString(R.string._2130843102_res_0x7f0215de), 5, 25), String.format(this.c.getString(R.string._2130843100_res_0x7f0215dc), 70, 140), this.c.getString(R.string._2130843095_res_0x7f0215d7)};
        ArrayList arrayList = new ArrayList(7);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> b(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            e(arrayList);
        } else {
            b(arrayList);
        }
        a(arrayList);
        a(arrayList, i);
        return arrayList;
    }

    public List<rkv> k() {
        ArrayList arrayList = new ArrayList();
        e(arrayList);
        b(arrayList);
        a(arrayList);
        a(arrayList, 1);
        return arrayList;
    }

    private List<rkv> e(List<rkv> list) {
        String[] strArrB = b(this.d);
        String[] strArrB2 = b(this.f9975a);
        a(list, new String[]{this.c.getString(R.string._2130843105_res_0x7f0215e1), this.c.getString(R.string._2130843072_res_0x7f0215c0)}, c(strArrB, this.c.getString(R.string._2130843106_res_0x7f0215e2)), c(strArrB2, this.c.getString(R.string._2130843104_res_0x7f0215e0)));
        return list;
    }

    private List<rkv> b(List<rkv> list) {
        String[] strArrB = b(this.h);
        String[] strArrB2 = b(this.f);
        a(list, new String[]{this.c.getString(R.string._2130844428_res_0x7f021b0c), this.c.getString(R.string._2130844429_res_0x7f021b0d)}, c(strArrB, this.c.getString(R.string._2130844430_res_0x7f021b0e)), c(strArrB2, this.c.getString(R.string._2130844431_res_0x7f021b0f)));
        return list;
    }

    private String[] b(int[] iArr) {
        String[] strArrO = o();
        String[] strArr = new String[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            if (i == iArr.length - 1) {
                strArr[i] = String.format(this.b.getString(iArr[i]), strArrO[i * 2]);
            } else {
                int i2 = i * 2;
                strArr[i] = String.format(this.b.getString(iArr[i]), strArrO[i2], strArrO[i2 + 1]);
            }
        }
        return strArr;
    }

    private List<rkv> a(List<rkv> list) {
        rkv rkvVar = new rkv();
        rkvVar.b(this.c.getString(R.string._2130842437_res_0x7f021345));
        rkvVar.d(this.c.getString(R.string._2130842445_res_0x7f02134d));
        list.add(rkvVar);
        return list;
    }

    private List<rkv> a(List<rkv> list, int i) {
        rkv rkvVar = new rkv();
        rkvVar.b(this.c.getString(R.string._2130839902_res_0x7f02095e));
        if (i == 0) {
            rkvVar.d(this.c.getString(R.string._2130843107_res_0x7f0215e3));
        } else {
            rkvVar.d(this.c.getString(R.string._2130844427_res_0x7f021b0b));
        }
        list.add(rkvVar);
        return list;
    }

    private String[] o() {
        String[] strArr = this.e;
        if (strArr != null) {
            return strArr;
        }
        String[] strArr2 = new String[9];
        this.e = strArr2;
        strArr2[0] = UnitUtil.e(1.0d, 1, 1);
        this.e[1] = UnitUtil.e(1.9d, 1, 1);
        this.e[2] = UnitUtil.e(2.0d, 1, 1);
        this.e[3] = UnitUtil.e(2.9d, 1, 1);
        this.e[4] = UnitUtil.e(3.0d, 1, 1);
        this.e[5] = UnitUtil.e(3.9d, 1, 1);
        this.e[6] = UnitUtil.e(4.0d, 1, 1);
        this.e[7] = UnitUtil.e(4.9d, 1, 1);
        this.e[8] = UnitUtil.e(5.0d, 1, 1);
        return this.e;
    }

    private void a(List<rkv> list, String[] strArr, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        e(list, strArr, new String[]{stringBuffer.toString(), stringBuffer2.toString()});
    }

    private StringBuffer c(String[] strArr, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (String str2 : strArr) {
            stringBuffer.append("\\n");
            stringBuffer.append(str2);
        }
        return stringBuffer;
    }

    public List<rkv> g() {
        String str;
        String[] strArr = {this.c.getString(R.string._2130839934_res_0x7f02097e), this.c.getString(R.string._2130844420_res_0x7f021b04), this.c.getString(R.string._2130844417_res_0x7f021b01)};
        String string = this.c.getString(R.string._2130840039_res_0x7f0209e7);
        String string2 = this.c.getString(R.string._2130840040_res_0x7f0209e8);
        if (UnitUtil.j()) {
            str = String.format(this.c.getString(R.string._2130839956_res_0x7f020994), 50, this.c.getQuantityString(R.plurals.IDS_hwh_motiontrack_unit_yd, 50));
        } else {
            str = String.format(this.c.getString(R.string._2130839956_res_0x7f020994), 50, this.c.getString(R.string.IDS_fitness_data_list_activity_meter_unit));
        }
        String[] strArr2 = {string, string2, str};
        ArrayList arrayList = new ArrayList(3);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> c() {
        String[] strArr = {this.c.getString(R.string._2130843486_res_0x7f02175e), this.c.getString(R.string._2130843489_res_0x7f021761)};
        String[] strArr2 = {a(new String[]{this.c.getString(R.string._2130843544_res_0x7f021798), this.c.getString(R.string._2130843545_res_0x7f021799), String.format(this.c.getString(R.string._2130843546_res_0x7f02179a), 90)}), a(new String[]{this.c.getString(R.string._2130843547_res_0x7f02179b), this.c.getString(R.string._2130843548_res_0x7f02179c), String.format(this.c.getString(R.string._2130843549_res_0x7f02179d), 900)})};
        ArrayList arrayList = new ArrayList(2);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> i() {
        String[] strArr = {this.c.getString(R.string._2130840035_res_0x7f0209e3)};
        String[] strArr2 = {this.c.getString(R.string._2130840036_res_0x7f0209e4)};
        ArrayList arrayList = new ArrayList(1);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> a() {
        String[] strArr = {this.c.getString(R.string._2130844415_res_0x7f021aff), this.c.getString(R.string._2130840035_res_0x7f0209e3)};
        String[] strArr2 = {this.c.getString(R.string._2130840037_res_0x7f0209e5), this.c.getString(R.string._2130840038_res_0x7f0209e6)};
        ArrayList arrayList = new ArrayList(2);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> b() {
        String[] strArr = {this.c.getString(R.string._2130843635_res_0x7f0217f3), this.c.getString(R.string._2130843637_res_0x7f0217f5), this.c.getString(R.string._2130843633_res_0x7f0217f1), this.c.getString(R.string._2130843631_res_0x7f0217ef), this.c.getString(R.string._2130843639_res_0x7f0217f7), this.c.getString(R.string._2130843641_res_0x7f0217f9)};
        String[] strArr2 = {this.c.getString(R.string._2130843636_res_0x7f0217f4), this.c.getString(R.string._2130843638_res_0x7f0217f6), this.c.getString(R.string._2130843634_res_0x7f0217f2), this.c.getString(R.string._2130843632_res_0x7f0217f0), this.c.getString(R.string._2130843640_res_0x7f0217f8), this.c.getString(R.string._2130843642_res_0x7f0217fa)};
        ArrayList arrayList = new ArrayList(6);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> e() {
        String[] strArr = {this.c.getString(R.string._2130844018_res_0x7f021972), this.c.getString(R.string._2130844020_res_0x7f021974), this.c.getString(R.string._2130844021_res_0x7f021975), this.c.getString(R.string._2130844019_res_0x7f021973)};
        String[] strArr2 = {this.c.getString(R.string._2130844022_res_0x7f021976, 3, 1), this.c.getString(R.string._2130844024_res_0x7f021978), this.c.getString(R.string._2130844025_res_0x7f021979), this.c.getString(R.string._2130844023_res_0x7f021977)};
        ArrayList arrayList = new ArrayList(4);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    public List<rkv> f() {
        String[] strArr = {this.c.getString(R.string._2130848795_res_0x7f022c1b), this.c.getString(R.string._2130848797_res_0x7f022c1d), this.c.getString(R.string._2130844052_res_0x7f021994), this.c.getString(R.string._2130848800_res_0x7f022c20), this.c.getString(R.string._2130848802_res_0x7f022c22)};
        String[] strArr2 = {this.c.getString(R.string._2130848796_res_0x7f022c1c), this.c.getString(R.string._2130848798_res_0x7f022c1e), this.c.getString(R.string._2130848799_res_0x7f022c1f), this.c.getString(R.string._2130848801_res_0x7f022c21), this.c.getString(R.string._2130848803_res_0x7f022c23)};
        ArrayList arrayList = new ArrayList(5);
        e(arrayList, strArr, strArr2);
        return arrayList;
    }

    private String a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int length = strArr.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (i < i2) {
                sb.append(strArr[i]);
                sb.append(System.lineSeparator());
                i++;
            } else {
                sb.append(strArr[i2]);
                return sb.toString();
            }
        }
    }

    private void e(List<rkv> list, String[] strArr, String[] strArr2) {
        for (int i = 0; i < strArr.length; i++) {
            rkv rkvVar = new rkv();
            rkvVar.b(strArr[i]);
            rkvVar.d(strArr2[i]);
            list.add(rkvVar);
        }
    }
}
