package com.huawei.dnurse.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import com.amap.api.services.core.AMapException;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.health.device.open.data.model.HealthData;
import com.huawei.wisecloud.drmclient.license.HwDrmConstant;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;

/* JADX INFO: loaded from: classes3.dex */
public class DnurseDeviceTest {
    private static SimpleDateFormat M;
    private static DnurseDeviceTest e;
    private byte D;
    private byte E;
    private byte F;
    private b G;
    private a H;
    private Context I;
    private IMeasureDataResultCallback J;
    private Timer L;
    private float g;
    private byte j;
    private int k;
    private int l;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean t;
    private boolean u;
    private byte v;
    private byte x;
    private byte y;
    private int z;
    private int f = 0;
    private int[][] h = {new int[]{4, 7, 11, 16, 11, 20, 1}, new int[]{7, 12, 17, 22, 19, 20, 2}, new int[]{10, 16, 23, 30, 19, 20, 3}};
    private int i = 0;
    private int m = 10;
    private boolean s = false;
    private boolean w = true;
    private String A = "";
    private boolean B = false;
    private boolean C = false;
    private Handler K = new Handler(Looper.getMainLooper());
    private float N = 0.0f;
    private float O = 0.0f;
    private BroadcastReceiver P = new com.huawei.dnurse.sdk.a(this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f1993a = new com.huawei.dnurse.sdk.b(this);
    Runnable b = new c(this);
    Runnable c = new d(this);
    Runnable d = new e(this);

    public void wakeupDevice() {
        if (!this.B || DnurseConstant.isWorking(this.f)) {
            return;
        }
        this.K.postDelayed(this.f1993a, this.o);
    }

    public void stopTest() {
        try {
            this.I.unregisterReceiver(this.P);
        } catch (IllegalArgumentException unused) {
        }
        this.f = 0;
        c();
        a aVar = this.H;
        if (aVar != null) {
            aVar.e();
            this.H = null;
        }
    }

    public void startTest(IMeasureDataResultCallback iMeasureDataResultCallback) {
        this.J = iMeasureDataResultCallback;
        if (this.H == null) {
            this.H = new a();
        }
        if (this.G == null) {
            this.G = new b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        this.I.registerReceiver(this.P, intentFilter);
        this.J.onMeasuring(this.f, 0);
    }

    public String getDeviceSn() {
        return this.A;
    }

    public static String newIdWithTag(String str) {
        String str2 = d().format(Calendar.getInstance().getTime());
        String str3 = String.format(Locale.US, "%06d", Integer.valueOf(new Random().nextInt(1000000)));
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    static /* synthetic */ byte k(DnurseDeviceTest dnurseDeviceTest) {
        byte b2 = dnurseDeviceTest.D;
        dnurseDeviceTest.D = (byte) (b2 - 1);
        return b2;
    }

    public static DnurseDeviceTest getInstance(Context context) {
        Log.d("HWHealthSDK", "DnurseDeviceTest: 333");
        if (e == null) {
            synchronized (DnurseDeviceTest.class) {
                if (e == null) {
                    e = new DnurseDeviceTest(context);
                }
            }
        }
        return e;
    }

    private static SimpleDateFormat d() {
        if (M == null) {
            synchronized (DnurseDeviceTest.class) {
                if (M == null) {
                    M = new SimpleDateFormat(HwDrmConstant.TIME_FORMAT, Locale.US);
                }
            }
        }
        return M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar;
        this.K.removeCallbacks(this.f1993a);
        this.K.removeCallbacks(this.c);
        this.K.removeCallbacks(this.d);
        a aVar2 = this.H;
        if (aVar2 != null) {
            aVar2.e();
        }
        if (this.B && (aVar = this.H) != null) {
            aVar.b();
        }
        b bVar = this.G;
        if (bVar != null) {
            bVar.d();
        }
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void b(int i) {
        if (i == this.f) {
            return;
        }
        Log.i("HWHealthSDK", "notifyChange,state=" + i);
        if (i != 0) {
            switch (i) {
                case 2:
                    if (this.f == 1) {
                        if (this.i <= 1) {
                            this.H.a(true);
                        } else {
                            this.H.a(false);
                        }
                        a(this.n);
                        this.E = (byte) -1;
                        break;
                    }
                    break;
                case 3:
                    this.C = true;
                    a(195000);
                    break;
                case 4:
                case 5:
                case 6:
                    a(195000);
                    break;
                case 7:
                    a();
                    break;
                case 8:
                    a(195000);
                    this.H.d();
                    if (this.x == -1 || this.E != this.F) {
                        this.E = this.F;
                        Calendar calendar = Calendar.getInstance();
                        SparseArray sparseArray = new SparseArray();
                        sparseArray.put(1, Float.valueOf(this.g));
                        sparseArray.put(2, calendar);
                        sparseArray.put(3, this.A);
                        this.J.onSuccess(sparseArray);
                    }
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    c();
                    break;
            }
            return;
        }
        this.x = (byte) -1;
        this.y = (byte) -1;
        this.z = 0;
        this.A = "";
        this.f = i;
        if (i == 7) {
            this.J.onMeasuring(i, this.D);
        } else {
            this.J.onMeasuring(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i;
        b(1);
        if (!this.H.a()) {
            Log.i("HWHealthSDK", "AudPly: start failed!");
            i = 14;
        } else if (this.G.c().booleanValue()) {
            a(this.n);
            this.K.postDelayed(this.c, this.p);
            return;
        } else {
            Log.i("HWHealthSDK", "AudRec: start failed!");
            i = 15;
        }
        b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.K.removeCallbacks(this.d);
        Timer timer = this.L;
        if (timer != null) {
            timer.cancel();
        }
        this.K.postDelayed(this.d, i);
    }

    private void a() {
        Date date = new Date(System.currentTimeMillis() + 1000);
        this.D = (byte) 10;
        this.K.removeCallbacks(this.d);
        Timer timer = this.L;
        if (timer != null) {
            timer.cancel();
            this.L.purge();
        }
        Timer timer2 = new Timer(true);
        this.L = timer2;
        timer2.scheduleAtFixedRate(new f(this), date, 1000L);
    }

    class b {
        private AudioRecord b;
        private int c;
        private short d = 0;

        class a implements Runnable {
            private short[] b;
            private byte[] c;
            private int d;
            private byte e;
            private final byte[] f = {UnsignedBytes.MAX_POWER_OF_TWO, 8, -120, 0};
            private final byte[] g = {UnsignedBytes.MAX_POWER_OF_TWO, 8, -86, 85};
            private final byte[] h = {-61, 60, -52, 51};
            private final byte[] i = {-61, 60, -91, 90};
            private byte j = 8;
            private byte[] k = new byte[255];
            private byte l = 0;
            private byte m = 0;
            private byte n = 0;
            private byte o = 0;
            private byte p = 0;
            private byte q = 0;
            private short r = 0;
            private boolean s = false;
            private boolean t = false;
            private int[] u = new int[9];
            private int v = 0;
            private int w = 0;
            private int x = 0;
            private int y = 0;

            @Override // java.lang.Runnable
            public void run() {
                Log.d("HWHealthSDK", "AudRec: thread started!");
                if (b.this.b != null && b.this.b.getRecordingState() != 3) {
                    Log.i("HWHealthSDK", "AudRec: can't record, released");
                    b.this.b.release();
                    b.this.b = null;
                    DnurseDeviceTest.this.b(15);
                }
                while (b.this.b != null && b.this.b.getRecordingState() == 3) {
                    int i = b.this.b.read(this.b, 0, this.d);
                    if (-3 != i) {
                        b(i);
                    }
                }
                if (b.this.b != null) {
                    Log.i("HWHealthSDK", "AudRec: released");
                    b.this.b.release();
                    b.this.b = null;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:109:0x034a, code lost:
            
                if (r19.f1996a.f1995a.f == 2) goto L122;
             */
            /* JADX WARN: Code restructure failed: missing block: B:121:0x0495, code lost:
            
                if (r19.f1996a.f1995a.f == 2) goto L122;
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x0497, code lost:
            
                r1 = r19.f1996a.f1995a;
                r12 = 3;
             */
            /* JADX WARN: Removed duplicated region for block: B:105:0x033b  */
            /* JADX WARN: Removed duplicated region for block: B:119:0x0482  */
            /* JADX WARN: Removed duplicated region for block: B:93:0x02d7  */
            /* JADX WARN: Removed duplicated region for block: B:98:0x0303  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void f() {
                /*
                    Method dump skipped, instruction units count: 1210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.dnurse.sdk.DnurseDeviceTest.b.a.f():void");
            }

            private void e() {
                int i;
                boolean z;
                if (DnurseDeviceTest.this.v == 0) {
                    int i2 = DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][0];
                    int i3 = DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][2];
                    for (int i4 = 0; i4 < 9; i4++) {
                        if (this.u[i4] > DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][1]) {
                            int i5 = this.u[i4];
                            if (i5 < i3) {
                                i3 = i5;
                            }
                        } else {
                            int i6 = this.u[i4];
                            if (i6 > i2) {
                                i2 = i6;
                            }
                        }
                    }
                    byte b = this.e;
                    if (i3 - i2 < b / 4) {
                        this.e = (byte) (b - 1);
                        Log.i("HWHealthSDK", "RECV Diff: changed to " + ((int) this.e));
                        return;
                    }
                }
                byte[] bArr = this.k;
                byte b2 = this.p;
                byte b3 = (byte) (b2 + 1);
                this.p = b3;
                bArr[b2] = (byte) (this.r & 255);
                if (b3 == 4) {
                    int i7 = 0;
                    while (i7 < 4 && this.k[i7] == this.f[i7]) {
                        i7++;
                    }
                    if (i7 == 4) {
                        Log.i("HWHealthSDK", "R: Wave HIGH first");
                        if (DnurseDeviceTest.this.v == 0) {
                            DnurseDeviceTest.this.w = true;
                        }
                        i = 0;
                        z = true;
                    } else {
                        i = 0;
                        while (i < 4 && this.k[i] == this.g[i]) {
                            i++;
                        }
                        z = false;
                    }
                    if (i == 4) {
                        Log.i("HWHealthSDK", "R: Wave HIGH(2) first");
                        if (DnurseDeviceTest.this.v == 0) {
                            DnurseDeviceTest.this.w = true;
                        }
                        i = 0;
                        z = true;
                    } else if (DnurseDeviceTest.this.v == 0) {
                        i = 0;
                        while (i < 4 && this.k[i] == this.h[i]) {
                            i++;
                        }
                    }
                    if (i != 4) {
                        if (DnurseDeviceTest.this.v == 0) {
                            i = 0;
                            while (i < 4 && this.k[i] == this.i[i]) {
                                i++;
                            }
                        }
                    } else {
                        Log.i("HWHealthSDK", "R: Wave LOW first");
                        DnurseDeviceTest.this.w = false;
                        i = 0;
                        z = true;
                    }
                    if (i == 4) {
                        Log.i("HWHealthSDK", "R: Wave LOW(2) first");
                        DnurseDeviceTest.this.w = false;
                        z = true;
                    }
                    if (!z) {
                        a();
                    }
                    if (z) {
                        DnurseDeviceTest.this.b(2);
                        c();
                    }
                }
            }

            private void d() {
                this.t = false;
                this.l = (byte) 0;
            }

            private void c() {
                this.p = (byte) 0;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void b(int r6) {
                /*
                    r5 = this;
                    r0 = 0
                L1:
                    if (r0 >= r6) goto L64
                    short[] r1 = r5.b
                    short r2 = r1[r0]
                    int r3 = r0 + 1
                    short r1 = r1[r3]
                    int r2 = r2 + r1
                    int r2 = r2 / 2
                    short r1 = (short) r2
                    com.huawei.dnurse.sdk.DnurseDeviceTest$b r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.b.this
                    short r4 = com.huawei.dnurse.sdk.DnurseDeviceTest.b.c(r2)
                    r4 = r4 | r1
                    short r4 = (short) r4
                    com.huawei.dnurse.sdk.DnurseDeviceTest.b.a(r2, r4)
                    byte[] r2 = r5.c
                    r4 = r1 & 255(0xff, float:3.57E-43)
                    byte r4 = (byte) r4
                    r2[r0] = r4
                    int r4 = r1 >> 8
                    byte r4 = (byte) r4
                    r2[r3] = r4
                    com.huawei.dnurse.sdk.DnurseDeviceTest$b r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.b.this
                    com.huawei.dnurse.sdk.DnurseDeviceTest r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.this
                    boolean r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.G(r2)
                    if (r2 == 0) goto L37
                    r2 = -2000(0xfffffffffffff830, float:NaN)
                    if (r1 < r2) goto L37
                    int r1 = r1 + (-2000)
                    goto L47
                L37:
                    com.huawei.dnurse.sdk.DnurseDeviceTest$b r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.b.this
                    com.huawei.dnurse.sdk.DnurseDeviceTest r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.this
                    boolean r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.H(r2)
                    if (r2 == 0) goto L48
                    r2 = 2000(0x7d0, float:2.803E-42)
                    if (r1 > r2) goto L48
                    int r1 = r1 + 2000
                L47:
                    short r1 = (short) r1
                L48:
                    com.huawei.dnurse.sdk.DnurseDeviceTest$b r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.b.this
                    com.huawei.dnurse.sdk.DnurseDeviceTest r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.this
                    boolean r2 = com.huawei.dnurse.sdk.DnurseDeviceTest.I(r2)
                    if (r2 != 0) goto L55
                    int r1 = r1 / (-4)
                    goto L57
                L55:
                    int r1 = r1 / 4
                L57:
                    short r1 = (short) r1
                    int r1 = r5.a(r1)
                    if (r1 == 0) goto L61
                    r5.a(r1)
                L61:
                    int r0 = r0 + 2
                    goto L1
                L64:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.dnurse.sdk.DnurseDeviceTest.b.a.b(int):void");
            }

            private void b() {
                int i = 1;
                while (i < this.p && this.k[i] != -1) {
                    i++;
                }
                int i2 = 0;
                while (i < this.p) {
                    byte[] bArr = this.k;
                    bArr[i2] = bArr[i];
                    i++;
                    i2++;
                }
                this.p = (byte) i2;
            }

            private void a(int i) {
                byte b;
                byte b2;
                String str;
                if (this.t) {
                    this.u[this.l] = i;
                    this.r = (short) (this.r >> 1);
                    if (i > DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][1] && i <= DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][2]) {
                        this.r = (short) (this.r | 256);
                        this.q = (byte) (this.q ^ 1);
                    } else if (i < DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][0] || i > DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][2]) {
                        Log.i("HWHealthSDK", "R: EN:" + i);
                        d();
                        this.n = (byte) 0;
                        this.m = (byte) 0;
                        this.o = (byte) 0;
                        this.s = false;
                        return;
                    }
                    Log.i("HWHealthSDK", "RN:" + i);
                    b2 = this.l;
                    if (b2 >= 8) {
                        d();
                        if (this.q != 0) {
                            Log.i("HWHealthSDK", "R: Bit Check error!");
                            c();
                            return;
                        }
                        this.r = (short) (this.r & 255);
                        Log.i("HWHealthSDK", "R: D=" + String.format("%02X", Short.valueOf(this.r)));
                        if (DnurseDeviceTest.this.f == 1) {
                            e();
                            return;
                        } else {
                            f();
                            return;
                        }
                    }
                } else if (DnurseDeviceTest.this.f != 1 || DnurseDeviceTest.this.j != 0 || this.s) {
                    if (i < DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][0] || i > DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][1]) {
                        if (i > DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][1] && i <= DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][2] && (b = this.l) >= 1 && b <= 5) {
                            Log.i("HWHealthSDK", "RS:" + i);
                            this.t = true;
                            this.l = (byte) 0;
                            this.r = (short) 0;
                            this.q = (byte) 0;
                            return;
                        }
                        this.l = (byte) 0;
                        if (i < DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][0] || i > DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][3]) {
                            this.n = (byte) 0;
                            this.m = (byte) 0;
                            this.o = (byte) 0;
                            this.s = false;
                            return;
                        }
                        return;
                    }
                    b2 = this.l;
                } else {
                    if (i > DnurseDeviceTest.this.h[1][1] && i <= DnurseDeviceTest.this.h[1][2]) {
                        Log.i("HWHealthSDK", "RB:" + i);
                        byte b3 = (byte) (this.n + 1);
                        this.n = b3;
                        this.m = (byte) 0;
                        this.o = (byte) 0;
                        if (b3 >= 10) {
                            str = "RB X";
                            Log.i("HWHealthSDK", str);
                            this.s = true;
                            DnurseDeviceTest.this.i = 1;
                        }
                    } else if (i > DnurseDeviceTest.this.h[1][2] && i <= DnurseDeviceTest.this.h[1][3]) {
                        Log.i("HWHealthSDK", "RB:" + i);
                        byte b4 = (byte) (this.m + 1);
                        this.m = b4;
                        this.n = (byte) 0;
                        this.o = (byte) 0;
                        if (b4 >= 4) {
                            str = "RB M";
                            Log.i("HWHealthSDK", str);
                            this.s = true;
                            DnurseDeviceTest.this.i = 1;
                        }
                    } else if (i <= DnurseDeviceTest.this.h[2][2] || i > DnurseDeviceTest.this.h[2][3]) {
                        this.n = (byte) 0;
                        this.m = (byte) 0;
                        this.o = (byte) 0;
                    } else {
                        Log.i("HWHealthSDK", "RB:" + i);
                        byte b5 = (byte) (this.o + 1);
                        this.o = b5;
                        this.n = (byte) 0;
                        this.m = (byte) 0;
                        if (b5 >= 4) {
                            Log.i("HWHealthSDK", "RB S");
                            this.s = true;
                            DnurseDeviceTest.this.i = 2;
                        }
                    }
                    if (this.s) {
                        this.l = (byte) 0;
                        return;
                    }
                    return;
                }
                this.l = (byte) (b2 + 1);
            }

            private void a() {
                int i = 0;
                while (true) {
                    int i2 = this.p - 1;
                    if (i >= i2) {
                        this.p = (byte) i2;
                        return;
                    }
                    byte[] bArr = this.k;
                    int i3 = i + 1;
                    bArr[i] = bArr[i3];
                    i = i3;
                }
            }

            private int a(short s) {
                int i;
                int i2 = 0;
                if ((s <= 0 || this.v <= 0) && (!(s == 0 && this.v == 0) && (s >= 0 || this.v >= 0))) {
                    if (this.v == 0 || this.w <= DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][6]) {
                        this.y += this.w;
                    } else {
                        int i3 = this.v;
                        if ((i3 <= 0 || this.x <= 0) && i3 >= 0) {
                            i2 = this.y;
                            i = this.w;
                        } else {
                            i = this.y + this.w;
                        }
                        this.y = i;
                        this.x = i3;
                    }
                    this.v = s;
                    this.w = 1;
                } else {
                    this.w++;
                }
                return i2;
            }

            public a(int i) {
                this.e = (byte) 0;
                if (DnurseDeviceTest.this.j != 1) {
                    if (DnurseDeviceTest.this.j != 2 && DnurseDeviceTest.this.j == 3) {
                        DnurseDeviceTest.this.i = 2;
                    } else {
                        DnurseDeviceTest.this.i = 1;
                    }
                } else {
                    DnurseDeviceTest.this.i = 0;
                }
                this.e = (byte) DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][4];
                if (DnurseDeviceTest.this.v == 0 || DnurseDeviceTest.this.v == 1) {
                    DnurseDeviceTest.this.w = true;
                } else {
                    DnurseDeviceTest.this.w = false;
                }
                int i2 = i / 2;
                this.d = i2;
                this.b = new short[i2];
                this.c = new byte[i2 * 2];
                if (b.this.b == null || b.this.b.getRecordingState() != 3) {
                    return;
                }
                b.this.b.read(this.b, 0, this.d);
            }
        }

        public Boolean c() {
            if (this.c <= 0) {
                return false;
            }
            AudioRecord audioRecord = new AudioRecord(1, 44100, 16, 2, this.c);
            this.b = audioRecord;
            if (audioRecord.getState() == 1) {
                this.b.startRecording();
                new Thread(new a(this.c / 2)).start();
                Log.i("HWHealthSDK", "AudRec: Recording started!");
                return true;
            }
            Log.i("HWHealthSDK", "AudRec: Create failed!");
            if (this.b != null) {
                Log.i("HWHealthSDK", "AudRec: released");
                this.b.release();
                this.b = null;
            }
            return false;
        }

        public boolean b() {
            return this.d == 0;
        }

        public Boolean a() {
            return Boolean.valueOf(this.b == null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            AudioRecord audioRecord = this.b;
            if (audioRecord == null || audioRecord.getRecordingState() != 3) {
                return;
            }
            Log.i("HWHealthSDK", "AudRec: stopped");
            this.b.stop();
        }

        public b() {
            int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
            Log.i("HWHealthSDK", "AudRec: min buffer=" + minBufferSize);
            if (minBufferSize < 0) {
                Log.i("HWHealthSDK", "AudRec: Error to get min buffer!");
                this.c = 0;
            } else {
                this.c = 16384;
                if (16384 < minBufferSize) {
                    this.c = ((minBufferSize * 8) + 7) / 8;
                }
            }
        }
    }

    public static String MD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (str == null || "".equals(str)) {
                return "";
            }
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                int i2 = b2 & UnsignedBytes.MAX_VALUE;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1994a;
        private int d;
        private AudioManager e;
        private AudioTrack f;
        private int c = -1;
        private final short[] g = {0, 0, 16384, -16384, 26624, -26624, 31744, -31744, Short.MAX_VALUE, HealthData.INVALID_VALUES_SHORT, 31744, -31744, 26624, -26624, 16384, -16384, 0, 0, -16384, 16384, -26624, 26624, -31744, 31744, HealthData.INVALID_VALUES_SHORT, Short.MAX_VALUE, -31744, 31744, -26624, 26624, -16384, 16384};
        private final short[] h = {0, 0, 31744, -31744, Short.MAX_VALUE, HealthData.INVALID_VALUES_SHORT, 31744, -31744, 0, 0, -31744, 31744, HealthData.INVALID_VALUES_SHORT, Short.MAX_VALUE, -31744, 31744, 0, 0, 31744, -31744, Short.MAX_VALUE, HealthData.INVALID_VALUES_SHORT, 31744, -31744, 0, 0, -31744, 31744, HealthData.INVALID_VALUES_SHORT, Short.MAX_VALUE, -31744, 31744};
        private final short[] i = {0, 0, 0, 0, 0, 0, 0, 0};

        public void e() {
            AudioTrack audioTrack = this.f;
            if (audioTrack != null) {
                audioTrack.flush();
                this.f.stop();
                Log.i("HWHealthSDK", "AudPly: Stop playing!");
            }
        }

        public void d() {
            a(this.g, DnurseDeviceTest.this.l, DnurseDeviceTest.this.m);
        }

        public void c() {
            int i = DnurseDeviceTest.this.m + 4;
            if (DnurseDeviceTest.this.j == 1) {
                a(this.h, DnurseDeviceTest.this.l, i);
            } else {
                a(this.g, DnurseDeviceTest.this.l, i);
            }
        }

        public void b() {
            int i = this.c;
            if (i != -1) {
                this.e.setStreamVolume(3, i, 0);
                Log.i("HWHealthSDK", "AudPly: Vol change to " + this.c);
                this.c = -1;
            }
        }

        public boolean a() {
            int i;
            int streamVolume = this.e.getStreamVolume(3);
            Log.i("HWHealthSDK", "AudPly: setMaxVolume Old=" + streamVolume);
            if (this.c == -1) {
                this.c = streamVolume;
            }
            int streamMaxVolume = this.e.getStreamMaxVolume(3);
            this.e.setStreamVolume(3, streamMaxVolume, 0);
            if (DnurseDeviceTest.this.t) {
                if (streamMaxVolume != this.e.getStreamVolume(3)) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i = streamMaxVolume;
                while (i > (streamMaxVolume * 2) / 3 && i != this.e.getStreamVolume(3)) {
                    i--;
                    this.e.setStreamVolume(3, i, 0);
                }
                if (Build.VERSION.RELEASE.compareTo("4.3") >= 0 && i < streamMaxVolume) {
                    this.e.setStreamVolume(3, streamMaxVolume, 9);
                }
                if (i != this.e.getStreamVolume(3)) {
                    return false;
                }
            } else {
                i = streamMaxVolume;
            }
            Log.i("HWHealthSDK", "AudPly: Vol change from " + streamVolume + " to " + i);
            this.f1994a = i == streamMaxVolume;
            return a(this.g, DnurseDeviceTest.this.k, 0);
        }

        public void a(boolean z) {
            int i = DnurseDeviceTest.this.m + DnurseDeviceTest.this.h[DnurseDeviceTest.this.i][5];
            if (z) {
                a(this.h, DnurseDeviceTest.this.l, i);
            } else {
                a(this.g, DnurseDeviceTest.this.l, i);
            }
        }

        private boolean a(short[] sArr, int i, int i2) {
            AudioTrack audioTrack = this.f;
            if (audioTrack == null) {
                return false;
            }
            int i3 = this.d;
            short[] sArr2 = this.i;
            int length = ((i3 / sArr2.length) / 2) + 2;
            if (audioTrack == null) {
                return true;
            }
            int length2 = (sArr.length * i2) + (sArr2.length * i) + (sArr2.length * length);
            short[] sArr3 = new short[length2];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = 0;
                while (true) {
                    short[] sArr4 = this.i;
                    if (i6 < sArr4.length) {
                        sArr3[i4] = sArr4[i6];
                        i6++;
                        i4++;
                    }
                }
            }
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = 0;
                while (i8 < sArr.length) {
                    sArr3[i4] = sArr[i8];
                    i8++;
                    i4++;
                }
            }
            for (int i9 = 0; i9 < length; i9++) {
                int i10 = 0;
                while (true) {
                    short[] sArr5 = this.i;
                    if (i10 < sArr5.length) {
                        sArr3[i4] = sArr5[i10];
                        i10++;
                        i4++;
                    }
                }
            }
            this.f.flush();
            this.f.play();
            this.f.write(sArr3, 0, length2);
            if (!DnurseDeviceTest.this.u) {
                this.f.stop();
            }
            Log.i("HWHealthSDK", "AudPly: Play F:" + i + " B:" + length + " T:" + i2 + " finished!");
            return true;
        }

        a() {
            this.d = 0;
            this.e = (AudioManager) DnurseDeviceTest.this.I.getSystemService("audio");
            this.d = AudioTrack.getMinBufferSize(4000, 12, 2);
            Log.i("HWHealthSDK", "AudPly: min buffer=" + this.d);
            AudioTrack audioTrack = new AudioTrack(3, 4000, 12, 2, this.d, 1);
            this.f = audioTrack;
            if (audioTrack.getState() == 1) {
                this.f.setStereoVolume(AudioTrack.getMaxVolume(), AudioTrack.getMaxVolume());
            } else {
                this.f.release();
                this.f = null;
            }
        }
    }

    private DnurseDeviceTest(Context context) {
        int i;
        int i2;
        this.j = (byte) 0;
        this.k = 20;
        this.l = 0;
        this.n = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        this.o = 20;
        this.p = 10;
        this.q = 10;
        this.r = false;
        this.t = true;
        this.u = true;
        this.v = (byte) 0;
        Log.d("HWHealthSDK", "DnurseDeviceTest: bbb");
        this.I = context;
        if (Build.MODEL.equalsIgnoreCase("K-Touch T91") || Build.MODEL.equalsIgnoreCase("K-Touch C980t") || Build.MODEL.equalsIgnoreCase("K-Touch T789") || Build.MODEL.equalsIgnoreCase("K-Touch S5t") || Build.MODEL.equalsIgnoreCase("Lenovo A658t") || Build.MODEL.equalsIgnoreCase("Lenovo S868t") || Build.MODEL.equalsIgnoreCase("8295") || Build.MODEL.equalsIgnoreCase("ZTE U930HD") || Build.MODEL.equalsIgnoreCase("HUAWEI G606-T00") || Build.MODEL.equalsIgnoreCase("K-Touch T6")) {
            this.r = true;
        } else {
            if (Build.MODEL.equalsIgnoreCase("8085") || Build.MODEL.equalsIgnoreCase("8085N") || Build.MODEL.equalsIgnoreCase("8190") || Build.MODEL.equalsIgnoreCase("8720")) {
                this.k = 200;
            } else {
                if (Build.MODEL.equalsIgnoreCase("Coolpad 8703")) {
                    i = 800;
                } else {
                    if (Build.MODEL.equalsIgnoreCase("Lenovo A330t")) {
                        this.l = 500;
                        i2 = 3000;
                    } else if (Build.MODEL.equalsIgnoreCase("GT-I9200") || Build.MODEL.equalsIgnoreCase("SM-G3508I")) {
                        this.p = 300;
                    } else if (Build.MODEL.equalsIgnoreCase("MX4 Pro")) {
                        this.p = 500;
                        i2 = 2000;
                    } else if (Build.MODEL.equalsIgnoreCase("R801")) {
                        i = 50;
                    } else if (Build.MODEL.equalsIgnoreCase("HTC One X") || Build.MODEL.equalsIgnoreCase("HUAWEI U8825-1")) {
                        this.k = 200;
                    } else if (Build.MODEL.equalsIgnoreCase("8150")) {
                        this.t = false;
                    } else if (Build.MODEL.equalsIgnoreCase("C1505")) {
                        this.q = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
                    } else if (Build.MODEL.equalsIgnoreCase("GT-I9103")) {
                        this.q = 200;
                    } else if (Build.MODEL.equalsIgnoreCase("M040")) {
                        int[][] iArr = this.h;
                        iArr[0][6] = 0;
                        iArr[1][6] = 0;
                    } else if (Build.MODEL.startsWith("HTC T528") || Build.MODEL.equalsIgnoreCase("Coolpad8750")) {
                        this.j = (byte) 1;
                    } else {
                        if (Build.MODEL.equalsIgnoreCase("SCH-P709")) {
                            this.j = (byte) 2;
                        } else if (Build.MODEL.equalsIgnoreCase("GT-S6352") || Build.MODEL.equalsIgnoreCase("GT-I9070")) {
                            this.o = 500;
                        } else if (Build.MODEL.equalsIgnoreCase("N5207")) {
                            this.o = 1500;
                            this.u = false;
                        } else if (Build.MODEL.equalsIgnoreCase("8195") || Build.MODEL.equalsIgnoreCase("8150D")) {
                            this.p = 300;
                        } else if (Build.MODEL.endsWith("Lenovo A780e") || Build.MODEL.endsWith("Lenovo A385e") || Build.MODEL.endsWith("HTC T320e")) {
                            this.o = 100;
                        } else if (Build.MODEL.equalsIgnoreCase("ST25i") || Build.MODEL.equalsIgnoreCase("LT22i") || Build.MODEL.equalsIgnoreCase("HTC T329t")) {
                        }
                        this.v = (byte) 1;
                    }
                    this.n = i2;
                }
                this.l = i;
            }
            this.r = true;
        }
        Log.d("HWHealthSDK", "DnurseDeviceTest: end");
    }
}
