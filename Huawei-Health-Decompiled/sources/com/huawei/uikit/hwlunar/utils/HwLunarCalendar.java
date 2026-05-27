package com.huawei.uikit.hwlunar.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.huawei.health.R;
import com.huawei.wearengine.sensor.DataResult;
import com.tencent.connect.common.Constants;
import defpackage.voa;
import defpackage.voc;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes8.dex */
public class HwLunarCalendar {
    private boolean f;
    private GregorianCalendar k;
    private Context l;
    private int m;
    private boolean n;
    private Calendar o;
    private final Object p;
    private boolean q;
    private int s;
    private int t;
    private static final int[] e = {27296, 47779, 43856, 19416, 19168, 42352, 21717, 53856, 55632, 21844, 22191, 39632, 21970, 19168, 42422, 42192, 53840, 53909, 46415, 54944, 44450, 38320, 18807, 18815, 42160, 46261, 27216, 27968, 43860, 11119, 38256, 21234, 18800, 25958, 54432, 59984, 27285, 23263, Constants.REQUEST_OLD_QZSHARE, 34531, 37615, 51415, 51551, 54432, 55462, 46431, 22176, 42420, 9695, 37584, 53938, 43344, 46423, 27808, 46416, 21333, 19887, 42416, 17779, 21183, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 38310, 38335, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 20854, 21183, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 53430, 53855, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 45653, 27951, 44448, 19299, 37759, 18936, 18800, 25776, 26790, 59999, 27424, 42692, 43759, 37600, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 19285, 19311, 42352, 21732, 53856, 59752, 54560, 55968, 27302, 22239, 19168, 43476, 42192, 53584, 62034, 54560, 56645, 46496, 22224};
    private static final int[] c = {R.string._2130852136_res_0x7f023928, R.string._2130852140_res_0x7f02392c, R.string._2130852131_res_0x7f023923, R.string._2130852132_res_0x7f023924, R.string._2130852138_res_0x7f02392a, R.string._2130852135_res_0x7f023927, R.string._2130852133_res_0x7f023925, R.string._2130852139_res_0x7f02392b, R.string._2130852137_res_0x7f023929, R.string._2130852134_res_0x7f023926};
    private static final int[] b = {R.string._2130852531_res_0x7f023ab3, R.string._2130852521_res_0x7f023aa9, R.string._2130852529_res_0x7f023ab1, R.string._2130852523_res_0x7f023aab, R.string._2130852520_res_0x7f023aa8, R.string._2130852525_res_0x7f023aad, R.string._2130852527_res_0x7f023aaf, R.string._2130852526_res_0x7f023aae, R.string._2130852524_res_0x7f023aac, R.string._2130852530_res_0x7f023ab2, R.string._2130852528_res_0x7f023ab0, R.string._2130852522_res_0x7f023aaa};
    private static final int[] d = {R.string._2130852507_res_0x7f023a9b, R.string._2130852498_res_0x7f023a92, R.string._2130852518_res_0x7f023aa6, R.string._2130852511_res_0x7f023a9f, R.string._2130852501_res_0x7f023a95, R.string._2130852515_res_0x7f023aa3, R.string._2130852505_res_0x7f023a99, R.string._2130852513_res_0x7f023aa1, R.string._2130852506_res_0x7f023a9a, R.string._2130852499_res_0x7f023a93, R.string._2130852500_res_0x7f023a94, R.string._2130852510_res_0x7f023a9e};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f11169a = {R.string._2130852617_res_0x7f023b09, R.string._2130851879_res_0x7f023827, R.string._2130852836_res_0x7f023be4, R.string._2130852713_res_0x7f023b69, R.string._2130851942_res_0x7f023866, R.string._2130852760_res_0x7f023b98, R.string._2130852402_res_0x7f023a32, R.string._2130852756_res_0x7f023b94, R.string._2130852615_res_0x7f023b07, R.string._2130851883_res_0x7f02382b, R.string._2130851938_res_0x7f023862, R.string._2130852709_res_0x7f023b65};
    private static final int[] i = {R.string._2130852916_res_0x7f023c34, R.string._2130852680_res_0x7f023b48, R.string._2130852848_res_0x7f023bf0, R.string._2130852835_res_0x7f023be3, R.string._2130852130_res_0x7f023922, R.string._2130852129_res_0x7f023921, R.string._2130852758_res_0x7f023b96, R.string._2130852755_res_0x7f023b93, R.string._2130851946_res_0x7f02386a, R.string._2130852665_res_0x7f023b39, R.string._2130852832_res_0x7f023be0};
    private static final int[] g = {R.string._2130852509_res_0x7f023a9d, R.string._2130852519_res_0x7f023aa7, R.string._2130852517_res_0x7f023aa5, R.string._2130852504_res_0x7f023a98, R.string._2130852503_res_0x7f023a97, R.string._2130852514_res_0x7f023aa2, R.string._2130852512_res_0x7f023aa0, R.string._2130852502_res_0x7f023a96, R.string._2130852508_res_0x7f023a9c, R.string._2130852516_res_0x7f023aa4};
    private static final int[] h = {1, 3, 5, 7, 8, 10, 12};
    private static final int[] j = {4, 6, 9, 11};

    private HwLunarCalendar() {
        this.p = new Object();
    }

    private void a(int i2, int i3, int i4) {
        this.n = true;
        boolean z = this.f;
        int i5 = z ? 1897 : 1900;
        int i6 = z ? 2102 : 2100;
        if (i2 == i5 && i3 < 1 && i4 < 31) {
            this.n = false;
            return;
        }
        if (i2 == i6 + 1 && i3 < 1 && i4 <= 28) {
            this.n = true;
            return;
        }
        if (i2 < i5 || i2 > i6) {
            this.n = false;
            return;
        }
        if (i3 < 0 || i3 > 12) {
            this.n = false;
            return;
        }
        int i7 = i3 + 1;
        if (i7 == 2) {
            if (new GregorianCalendar().isLeapYear(i2)) {
                this.n = d(i4, 1, 29);
                return;
            } else {
                this.n = d(i4, 1, 28);
                return;
            }
        }
        if (c(i7, h)) {
            this.n = d(i4, 1, 31);
        } else if (c(i7, j)) {
            this.n = d(i4, 1, 30);
        } else {
            Log.e("HwLunarCalendar", "wrong month index");
        }
    }

    private boolean c(int i2, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    private boolean d(int i2, int i3, int i4) {
        return i2 >= i3 && i2 <= i4;
    }

    private int e(int i2) {
        int iC = c(i2) + 348;
        if (i2 < 1897 || i2 > 2102) {
            Log.e("HwLunarCalendar", "getLunarYearDays: lunarYear index out of boundry, lunarYear = " + i2);
            return 0;
        }
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            iC += (e[i2 + (-1897)] & i3) != 0 ? 1 : 0;
        }
        return iC;
    }

    public int a() {
        return this.t;
    }

    public String b() {
        return b(false, true);
    }

    public int c() {
        return this.s;
    }

    public String d() {
        String str = "";
        if (!this.n) {
            return "";
        }
        if (this.t <= 10) {
            str = "" + this.l.getString(R.string._2130851885_res_0x7f02382d);
        }
        return str + e(this.t, false);
    }

    public String e() {
        if (!this.n) {
            return "";
        }
        return f() + e(true) + this.l.getString(R.string._2130851893_res_0x7f023835) + this.m;
    }

    public void e(int i2, int i3, int i4) {
        synchronized (this.p) {
            Calendar calendar = Calendar.getInstance();
            int i5 = i3 - 1;
            calendar.set(i2, i5, i4);
            c(i2 == 0 ? System.currentTimeMillis() : calendar.getTimeInMillis());
            a(i2, i5, i4);
        }
    }

    public int j() {
        return this.m;
    }

    private void c(long j2) {
        this.o.setTimeInMillis(j2);
        this.m = 1897;
        voc vocVar = new voc(Calendar.getInstance().getTimeZone());
        vocVar.d(j2);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(vocVar.d(), vocVar.e(), vocVar.b());
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone(DataResult.UTC));
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(1897, 1, 2);
        gregorianCalendar2.setTimeZone(TimeZone.getTimeZone(DataResult.UTC));
        e(gregorianCalendar, gregorianCalendar2);
    }

    public HwLunarCalendar(Context context) {
        this.p = new Object();
        this.l = context;
        this.n = true;
        this.k = new GregorianCalendar(TimeZone.getTimeZone(DataResult.UTC));
        this.o = Calendar.getInstance();
        this.f = true;
    }

    private void e(Calendar calendar, Calendar calendar2) {
        long jE = e((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 86400000, e(this.m));
        int iA = a(this.m);
        boolean z = false;
        boolean z2 = false;
        int i2 = 1;
        loop0: while (true) {
            boolean z3 = z2;
            while (i2 < 13 && jE > 0) {
                long jB = b(i2, z3, z2);
                if (jE < jB) {
                    break loop0;
                }
                jE -= jB;
                if (z2) {
                    i2++;
                    z3 = false;
                } else if (iA == i2) {
                    break;
                } else {
                    i2++;
                }
            }
            z2 = true;
        }
        this.s = i2;
        if (i2 == iA && z2) {
            z = true;
        }
        this.q = z;
        this.t = ((int) jE) + 1;
    }

    private int a(int i2) {
        if (i2 >= 1897 && i2 <= 2102) {
            int i3 = e[i2 - 1897] & 15;
            if (i3 == 15) {
                return 0;
            }
            return i3;
        }
        Log.e("HwLunarCalendar", "getLunarLeapMonth: lunarYear index out of boundry, lunarYear = " + i2);
        return 0;
    }

    private int b(int i2, boolean z, boolean z2) {
        if (z2 && z) {
            return c(this.m);
        }
        return e(this.m, i2);
    }

    private long e(long j2, int i2) {
        while (true) {
            int i3 = this.m;
            if (i3 >= 2102) {
                break;
            }
            long j3 = i2;
            if (j2 < j3) {
                break;
            }
            j2 -= j3;
            int i4 = i3 + 1;
            this.m = i4;
            i2 = e(i4);
        }
        return j2;
    }

    private int c(int i2) {
        if (i2 >= 1896 && i2 < 2103) {
            int i3 = e[i2 - 1896];
            if (a(i2) > 0) {
                return (i3 & 15) == 15 ? 30 : 29;
            }
            return 0;
        }
        Log.e("HwLunarCalendar", "getLunarLeapDays: lunarYear index out of boundry, lunarYear = " + i2);
        return 0;
    }

    private int e(int i2, int i3) {
        if (i2 >= 1897 && i2 <= 2102) {
            return (e[i2 - 1897] & (65536 >> i3)) != 0 ? 30 : 29;
        }
        Log.e("HwLunarCalendar", "getLunarMonthDays: lunarYear index out of boundry, lunarYear = " + i2);
        return 0;
    }

    private String e(boolean z) {
        if (z) {
            return this.l.getString(d[(this.m - 4) % 12]);
        }
        return this.l.getString(f11169a[(this.m - 4) % 12]);
    }

    private String f() {
        if (!this.n) {
            return "";
        }
        int i2 = this.m - 1864;
        try {
            return this.l.getString(c[i2 % 10]) + this.l.getString(b[i2 % 12]);
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    private String b(boolean z, boolean z2) {
        String str;
        String str2 = "";
        if (!this.n) {
            return "";
        }
        if (this.q) {
            if (z2) {
                str2 = "" + this.l.getString(R.string._2130852723_res_0x7f023b73);
            } else {
                str2 = "" + this.l.getString(R.string._2130852722_res_0x7f023b72);
            }
        }
        if (z2) {
            str = e(this.s, z2) + this.l.getString(R.string._2130851887_res_0x7f02382f);
        } else {
            str = e(this.s, z2) + this.l.getString(R.string._2130851886_res_0x7f02382e);
        }
        int i2 = this.s;
        if (i2 == 1) {
            return str2 + b(z, this.l.getString(R.string._2130852917_res_0x7f023c35), str);
        }
        if (i2 == 11) {
            if (z2) {
                return str2 + b(z, this.l.getString(R.string._2130851941_res_0x7f023865), str);
            }
            return str2 + b(z, this.l.getString(R.string._2130851940_res_0x7f023864), str);
        }
        if (i2 != 12) {
            return str2 + str;
        }
        if (z2) {
            return str2 + b(z, this.l.getString(R.string._2130852550_res_0x7f023ac6), str);
        }
        return str2 + b(z, this.l.getString(R.string._2130852549_res_0x7f023ac5), str);
    }

    private String e(int i2, boolean z) {
        String string = "";
        if (i2 < 0) {
            return "";
        }
        int i3 = i2 / 10;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (z) {
                        string = this.l.getString(R.string._2130851889_res_0x7f023831);
                    } else {
                        string = this.l.getString(R.string._2130851888_res_0x7f023830);
                    }
                }
            } else if (z) {
                string = this.l.getString(R.string._2130851891_res_0x7f023833);
            } else {
                string = this.l.getString(R.string._2130851890_res_0x7f023832);
            }
        } else if (z) {
            string = this.l.getString(g[9]);
        } else {
            string = this.l.getString(R.string._2130852832_res_0x7f023be0);
        }
        int i4 = i2 % 10;
        if (i4 != 0) {
            string = string + this.l.getString(i[i4]);
        }
        return i2 == 20 ? voa.b[i2 - 1] : string;
    }

    private String b(boolean z, String str, String str2) {
        if (!z) {
            return str;
        }
        return str2 + String.format(Locale.ROOT, this.l.getString(R.string._2130852557_res_0x7f023acd), str);
    }
}
