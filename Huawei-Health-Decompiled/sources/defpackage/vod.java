package defpackage;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.huawei.health.R;
import com.huawei.uikit.hwlunar.utils.HwLunarCalendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class vod {
    private static vod b;
    private HwLunarCalendar r;
    private Context t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f18690a = new String[205];
    private String[] d = new String[205];
    private SparseArray<Integer> c = new SparseArray<>();
    private SparseArray<String> e = new SparseArray<>();
    private SparseArray<String> h = new SparseArray<>();
    private Map<String, Integer> j = new HashMap(10);
    private Map<String, Integer> f = new HashMap(10);
    private Map<Integer, List<String>> i = new HashMap(10);
    private Map<Integer, String> g = new HashMap(10);
    private Map<String, Integer> k = new HashMap(10);
    private Map<String, String> m = new HashMap(10);
    private Map<String, List<String>> l = new HashMap(10);
    private List<Object> o = new ArrayList(10);
    private List<Object> n = new ArrayList(10);
    private List<Object> q = new ArrayList(10);
    private Map<String, List<String>> p = new HashMap(10);
    private String s = null;
    private String y = null;
    private String w = null;
    private final Object u = new Object();
    private List<String> x = new ArrayList(10);
    private Map<String, Integer> v = new HashMap(10);

    protected vod(Context context) throws Throwable {
        this.t = context.getApplicationContext();
        this.r = new HwLunarCalendar(this.t);
        l();
    }

    public static GregorianCalendar b() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(2101, 0, 27);
        return gregorianCalendar;
    }

    public static vod d(Context context) {
        vod vodVarN;
        synchronized (vod.class) {
            if (b == null) {
                a(new vod(context));
            }
            vodVarN = n();
        }
        return vodVarN;
    }

    public static GregorianCalendar e() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1900, 0, 31);
        return gregorianCalendar;
    }

    private void k() throws Throwable {
        Throwable th;
        InputStream inputStreamOpenRawResource;
        BufferedReader bufferedReader;
        Throwable th2;
        BufferedReader bufferedReader2 = null;
        String str = null;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader3 = null;
        try {
            inputStreamOpenRawResource = this.t.getResources().openRawResource(R.raw._2131886080_res_0x7f120000);
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, "UTF-8"));
                } catch (IOException unused) {
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamOpenRawResource = inputStreamOpenRawResource;
                bufferedReader2 = bufferedReader3;
                Throwable th4 = th;
                bufferedReader = bufferedReader2;
                th2 = th4;
                voa.d(inputStreamOpenRawResource);
                voa.b(bufferedReader);
                throw th2;
            }
            try {
                ArrayList arrayList = new ArrayList(10);
                int i = 0;
                String str2 = null;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        voa.d(inputStreamOpenRawResource);
                        voa.b(bufferedReader);
                        return;
                    }
                    if (b(line, i)) {
                        voa.d(inputStreamOpenRawResource);
                        voa.b(bufferedReader);
                        return;
                    }
                    String[] strArrB = b(a(b(line)));
                    b(i, strArrB);
                    if (str == null) {
                        str = strArrB[0];
                        str2 = strArrB[1];
                        arrayList.add(strArrB[2]);
                    } else if (str.equals(strArrB[0])) {
                        arrayList.add(strArrB[2]);
                    } else {
                        a(str, arrayList);
                        this.l.put(str2, arrayList);
                        ArrayList arrayList2 = new ArrayList(10);
                        String str3 = strArrB[0];
                        String str4 = strArrB[1];
                        arrayList2.add(strArrB[2]);
                        arrayList = arrayList2;
                        str = str3;
                        str2 = str4;
                    }
                    i++;
                }
            } catch (IOException unused2) {
                bufferedReader3 = bufferedReader;
                Log.e("HwLunarDataOperate", "loadAllMonth has an Exception.");
                voa.d(inputStreamOpenRawResource);
                voa.b(bufferedReader3);
            } catch (Throwable th5) {
                th2 = th5;
                voa.d(inputStreamOpenRawResource);
                voa.b(bufferedReader);
                throw th2;
            }
        } catch (IOException unused3) {
            inputStreamOpenRawResource = null;
        } catch (Throwable th6) {
            th = th6;
            inputStreamOpenRawResource = null;
            Throwable th42 = th;
            bufferedReader = bufferedReader2;
            th2 = th42;
            voa.d(inputStreamOpenRawResource);
            voa.b(bufferedReader);
            throw th2;
        }
    }

    private void l() throws Throwable {
        Log.w("HwLunarDataOperate", "init ");
        int i = 0;
        for (int i2 = 1898; i2 < 2103; i2++) {
            this.r.e(i2, 8, 8);
            String strE = this.r.e();
            this.f18690a[i] = strE;
            this.d[i] = String.valueOf(i2);
            this.c.put(i2, Integer.valueOf(i));
            this.e.put(i2, strE);
            this.h.put(i, strE);
            this.j.put(strE, Integer.valueOf(i2));
            this.f.put(strE, Integer.valueOf(i));
            i++;
        }
        k();
        this.v.put(this.t.getString(R.string._2130851890_res_0x7f023832) + this.t.getString(R.string._2130851946_res_0x7f02386a), 1);
        this.v.put(this.t.getString(R.string._2130851890_res_0x7f023832) + this.t.getString(R.string._2130852665_res_0x7f023b39), 2);
        this.v.put(this.t.getString(R.string._2130851888_res_0x7f023830), 3);
        this.v.put(this.t.getString(R.string._2130851888_res_0x7f023830) + this.t.getString(R.string._2130852680_res_0x7f023b48), 3);
    }

    private static vod n() {
        return b;
    }

    public String[] a() {
        return this.d;
    }

    public GregorianCalendar c(String str, String str2, String str3, boolean z) {
        GregorianCalendar gregorianCalendarC;
        synchronized (this.u) {
            int iIntValue = this.j.get(str).intValue();
            String str4 = str + str2 + str3;
            gregorianCalendarC = !this.o.isEmpty() ? c(this.o, str4) : null;
            if (gregorianCalendarC == null && !this.q.isEmpty()) {
                gregorianCalendarC = c(this.q, str4);
            }
            if (gregorianCalendarC == null && !this.n.isEmpty()) {
                gregorianCalendarC = c(this.n, str4);
            }
            if (gregorianCalendarC == null) {
                d(iIntValue);
                if (!this.o.isEmpty()) {
                    gregorianCalendarC = c(this.o, str4);
                }
                if (gregorianCalendarC == null && !this.q.isEmpty()) {
                    gregorianCalendarC = c(this.q, str4);
                }
                gregorianCalendarC = e(z, gregorianCalendarC);
            }
        }
        return gregorianCalendarC;
    }

    public Map<Integer, String> c() {
        return this.g;
    }

    public Map<String, Integer> d() {
        return this.f;
    }

    public void d(int i) {
        synchronized (this.u) {
            this.s = null;
            this.y = null;
            this.w = null;
            if (!this.p.isEmpty()) {
                this.p = new HashMap(10);
            }
            this.n = c(i - (-2131884399));
            this.o = c(i - (-2131884400));
            this.q = c(i - (-2131884401));
        }
    }

    public SparseArray<String> eBA_() {
        return this.e;
    }

    public Map<String, Integer> f() {
        return this.k;
    }

    public Map<String, Integer> g() {
        return this.j;
    }

    public Map<String, List<String>> h() {
        return this.l;
    }

    public String[] j() {
        return this.f18690a;
    }

    public Map<String, List<String>> o() {
        return this.p;
    }

    private static void a(vod vodVar) {
        b = vodVar;
    }

    private void a(String str, List<String> list) {
        try {
            this.i.put(Integer.valueOf(str), list);
        } catch (NumberFormatException unused) {
            Log.e("HwLunarDataOperate", "parse string to int error, westernYear = " + str);
        }
    }

    private boolean b(String str, int i) {
        if (i > 10000) {
            Log.e("HwLunarDataOperate", "loadAllMonth: too many lines in all month config file!");
            return true;
        }
        if (str.length() <= 6) {
            return false;
        }
        Log.e("HwLunarDataOperate", "hex month string length is illegal");
        return true;
    }

    private void b(int i, String[] strArr) {
        if (strArr != null && strArr.length == 4) {
            this.g.put(Integer.valueOf(i), strArr[1] + "_" + strArr[2]);
            this.k.put(strArr[1] + "_" + strArr[2], Integer.valueOf(i));
            this.m.put(strArr[1] + strArr[2], strArr[3]);
            return;
        }
        Log.e("HwLunarDataOperate", "decode month table error");
    }

    private int b(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str, 16);
        } catch (NumberFormatException | IllegalFormatException unused) {
            Log.e("HwLunarDataOperate", "parse string to hex error, hexStr = " + str);
            return 0;
        }
    }

    private GregorianCalendar e(String str) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (str.length() == 8) {
            String strSubstring = str.substring(0, 4);
            String strSubstring2 = str.substring(4, 6);
            String strSubstring3 = str.substring(6, 8);
            if (strSubstring2.indexOf("0") != -1 && strSubstring2.indexOf("0") != 1) {
                strSubstring2 = strSubstring2.substring(1, 2);
            }
            try {
                gregorianCalendar.set(Integer.parseInt(strSubstring), Integer.parseInt(strSubstring2) - 1, Integer.parseInt(strSubstring3));
            } catch (NumberFormatException unused) {
                Log.e("HwLunarDataOperate", "parse string to int error.");
            }
        }
        return gregorianCalendar;
    }

    public GregorianCalendar e(String str, String str2, String str3, int i, boolean z) {
        GregorianCalendar gregorianCalendarC;
        synchronized (this.u) {
            int iIntValue = this.j.get(str).intValue();
            String str4 = str + str2 + str3;
            gregorianCalendarC = !this.o.isEmpty() ? c(this.o, str4) : null;
            if (gregorianCalendarC == null && !this.q.isEmpty()) {
                gregorianCalendarC = c(this.q, str4);
            }
            if (gregorianCalendarC == null && !this.n.isEmpty()) {
                gregorianCalendarC = c(this.n, str4);
            }
            if (gregorianCalendarC == null) {
                d(iIntValue);
                if (!this.o.isEmpty()) {
                    gregorianCalendarC = c(this.o, str4);
                }
                if (gregorianCalendarC == null && !this.q.isEmpty()) {
                    gregorianCalendarC = c(this.q, str4);
                }
                if (gregorianCalendarC == null) {
                    d(str, str2, str3, i, z);
                }
            }
        }
        return gregorianCalendarC;
    }

    private String[] b(int[] iArr) {
        if (iArr.length != 6) {
            Log.e("HwLunarDataOperate", "decode year month table error");
            return new String[0];
        }
        String[] strArr = new String[4];
        strArr[0] = iArr[0] + "";
        StringBuilder sb = new StringBuilder();
        String[] strArr2 = voa.d;
        sb.append(strArr2[iArr[1] % strArr2.length]);
        String[] strArr3 = voa.f18688a;
        sb.append(strArr3[iArr[2] % strArr3.length]);
        String[] strArr4 = voa.g;
        sb.append(strArr4[iArr[2] % strArr4.length]);
        sb.append("年");
        sb.append(iArr[0]);
        strArr[1] = sb.toString();
        if (iArr[3] == 0) {
            String[] strArr5 = voa.c;
            strArr[2] = strArr5[iArr[4] % strArr5.length];
        } else {
            StringBuilder sb2 = new StringBuilder("闰");
            String[] strArr6 = voa.c;
            sb2.append(strArr6[iArr[4] % strArr6.length]);
            strArr[2] = sb2.toString();
        }
        String[] strArr7 = voa.b;
        strArr[3] = strArr7[(iArr[5] + 28) % strArr7.length];
        return strArr;
    }

    private GregorianCalendar e(boolean z, GregorianCalendar gregorianCalendar) {
        return (gregorianCalendar == null && z) ? new GregorianCalendar() : gregorianCalendar;
    }

    private GregorianCalendar d(String str, String str2, String str3, int i, boolean z) {
        if (i == 1) {
            String str4 = this.m.get(str + str2);
            if (str4 != null) {
                if (this.v.get(str3).intValue() > this.v.get(str4).intValue()) {
                    return c(str, str2, str4, false);
                }
                return null;
            }
            return e(z, (GregorianCalendar) null);
        }
        if (i == 0) {
            if (str2.indexOf(this.t.getString(R.string._2130852722_res_0x7f023b72)) != -1) {
                GregorianCalendar gregorianCalendarE = e(str, str2, str3, 1, false);
                if (gregorianCalendarE != null) {
                    return gregorianCalendarE;
                }
                String strReplace = str2.replace(this.t.getString(R.string._2130852722_res_0x7f023b72), "");
                GregorianCalendar gregorianCalendarC = c(str, strReplace, str3, false);
                return gregorianCalendarC != null ? gregorianCalendarC : e(z, e(str, strReplace, str3, 1, false));
            }
            GregorianCalendar gregorianCalendarE2 = e(str, str2, str3, 1, false);
            return (gregorianCalendarE2 == null && z) ? new GregorianCalendar() : gregorianCalendarE2;
        }
        return e(z, (GregorianCalendar) null);
    }

    private void d(String[] strArr) {
        if (strArr == null || strArr.length != 4) {
            return;
        }
        this.p.put(this.s + this.y, this.x);
        ArrayList arrayList = new ArrayList(10);
        this.x = arrayList;
        this.y = strArr[2];
        this.s = strArr[1];
        String str = strArr[3];
        this.w = str;
        arrayList.add(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [vod] */
    /* JADX WARN: Type inference failed for: r12v0, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private List<Object> c(int i) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        ?? OpenRawResource;
        BufferedReader bufferedReader2;
        String line;
        ArrayList arrayList = new ArrayList(10);
        BufferedReader bufferedReader3 = null;
        bufferedReader3 = null;
        bufferedReader3 = null;
        ?? r2 = 0;
        try {
            try {
                OpenRawResource = this.t.getResources().openRawResource(i);
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader((InputStream) OpenRawResource, "UTF-8"));
                } catch (IOException unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                BufferedReader bufferedReader4 = bufferedReader3;
                r2 = i;
                bufferedReader = bufferedReader4;
                bufferedReader2 = bufferedReader;
                OpenRawResource = r2;
                voa.d(OpenRawResource);
                voa.b(bufferedReader2);
                throw th;
            }
            try {
                line = bufferedReader2.readLine();
            } catch (IOException unused2) {
                bufferedReader3 = bufferedReader2;
                Log.e("HwLunarDataOperate", "readOneYearData has an Exception.");
                bufferedReader2 = bufferedReader3;
                i = OpenRawResource;
            } catch (Throwable th3) {
                th = th3;
                voa.d(OpenRawResource);
                voa.b(bufferedReader2);
                throw th;
            }
        } catch (IOException unused3) {
            OpenRawResource = 0;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader2 = bufferedReader;
            OpenRawResource = r2;
            voa.d(OpenRawResource);
            voa.b(bufferedReader2);
            throw th;
        }
        if (line != null && line.length() <= 7) {
            try {
                int i2 = Integer.parseInt(line, 16);
                HashMap map = new HashMap(10);
                bufferedReader3 = bufferedReader2;
                List<Object> listB = b(bufferedReader3, arrayList, i2, map, 1);
                if (listB != null) {
                    voa.d(OpenRawResource);
                    voa.b(bufferedReader2);
                    return listB;
                }
                arrayList.add(map);
                i = OpenRawResource;
                voa.d(i);
                voa.b(bufferedReader2);
                return arrayList;
            } catch (NumberFormatException unused4) {
                Log.e("HwLunarDataOperate", "readOneYearData: parse string to hex error, line = " + line);
                voa.d(OpenRawResource);
                voa.b(bufferedReader2);
                return arrayList;
            }
        }
        Log.e("HwLunarDataOperate", "readOneYearData: year index length is illegal, line = " + line);
        voa.d(OpenRawResource);
        voa.b(bufferedReader2);
        return arrayList;
    }

    private GregorianCalendar c(List<Object> list, String str) {
        int i;
        Map map = (Map) list.get(0);
        if (map.get(str) == null) {
            return null;
        }
        int iB = b((String) map.get(str));
        int[] iArr = {iB & 15, (iB >> 4) & 31, (iB >> 17) & 1};
        String strSubstring = str.substring(4, 8);
        try {
            i = Integer.parseInt(strSubstring) + iArr[2];
        } catch (NumberFormatException unused) {
            Log.e("HwLunarDataOperate", "parse string to int error, lunarYear = " + strSubstring);
            i = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String[] strArr = voa.h;
        sb.append(strArr[iArr[0] % strArr.length]);
        String[] strArr2 = voa.e;
        sb.append(strArr2[iArr[1] % strArr2.length]);
        return e(sb.toString());
    }

    private List<Object> b(BufferedReader bufferedReader, List<Object> list, int i, Map<String, String> map, int i2) throws IOException {
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            if (i2 > 1000) {
                Log.e("HwLunarDataOperate", "readOneYearData: Too many lines in one year data file");
                return list;
            }
            if (line.length() > 7) {
                Log.e("HwLunarDataOperate", "readOneYearData: yearData length is illegal, line = " + line);
                return list;
            }
            String[] strArrE = e(b(b(line)), i);
            if (strArrE == null || strArrE.length != 4) {
                break;
            }
            map.put(strArrE[1] + strArrE[2] + strArrE[3], line);
            b(strArrE);
            i2++;
        }
        Log.e("HwLunarDataOperate", "readOneYearData: decode error");
        return list;
    }

    private void b(String[] strArr) {
        String str = this.t.getString(R.string._2130851885_res_0x7f02382d) + this.t.getString(R.string._2130852680_res_0x7f023b48);
        if (this.y == null && str.equals(strArr[3])) {
            this.y = strArr[2];
            this.s = strArr[1];
            String str2 = strArr[3];
            this.w = str2;
            this.x.add(str2);
            return;
        }
        String str3 = this.y;
        if (str3 != null && strArr[2].equals(str3)) {
            String str4 = strArr[3];
            this.w = str4;
            this.x.add(str4);
        } else if (this.y != null) {
            d(strArr);
        } else {
            Log.e("HwLunarDataOperate", "readOneYearData: load data error");
        }
    }

    private String[] e(int[] iArr, int i) {
        if (iArr != null && iArr.length == 8) {
            String[] strArr = new String[4];
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            String[] strArr2 = voa.h;
            sb.append(strArr2[iArr[0] % strArr2.length]);
            String[] strArr3 = voa.e;
            sb.append(strArr3[iArr[1] % strArr3.length]);
            strArr[0] = sb.toString();
            int i2 = iArr[4];
            StringBuilder sb2 = new StringBuilder();
            String[] strArr4 = voa.d;
            sb2.append(strArr4[iArr[2] % strArr4.length]);
            String[] strArr5 = voa.f18688a;
            sb2.append(strArr5[iArr[3] % strArr5.length]);
            String[] strArr6 = voa.g;
            sb2.append(strArr6[iArr[3] % strArr6.length]);
            sb2.append("年");
            sb2.append(i - i2);
            strArr[1] = sb2.toString();
            if (iArr[5] == 0) {
                String[] strArr7 = voa.c;
                strArr[2] = strArr7[iArr[6] % strArr7.length];
            } else {
                StringBuilder sb3 = new StringBuilder("闰");
                String[] strArr8 = voa.c;
                sb3.append(strArr8[iArr[6] % strArr8.length]);
                strArr[2] = sb3.toString();
            }
            String[] strArr9 = voa.b;
            strArr[3] = strArr9[iArr[7] % strArr9.length];
            return strArr;
        }
        Log.e("HwLunarDataOperate", "decode year index error");
        return new String[0];
    }

    private int[] b(int i) {
        return new int[]{i & 15, (i >> 4) & 31, (i >> 9) & 15, (i >> 13) & 15, (i >> 17) & 1, (i >> 18) & 1, (i >> 19) & 15, (i >> 23) & 31};
    }

    private int[] a(int i) {
        return new int[]{(i & 255) + 1890, (i >> 8) & 15, (i >> 12) & 15, (i >> 16) & 1, (i >> 17) & 15, (i >> 21) & 1};
    }
}
