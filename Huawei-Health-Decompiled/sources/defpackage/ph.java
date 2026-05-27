package defpackage;

import android.content.Context;
import android.os.Vibrator;
import com.apprichtap.haptic.sync.SyncCallback;
import defpackage.pw;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class ph extends po {
    private static ph c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pi f16694a;
    private Context e;
    private qa h;
    private Vibrator i;
    private int g = -1;
    private int f = -1;
    private ExecutorService j = Executors.newSingleThreadExecutor();

    public void a() {
        try {
            pw.d.a("RichTapUtils", "quit()");
            ExecutorService executorService = this.j;
            if (executorService != null) {
                executorService.shutdown();
            }
            Vibrator vibrator = this.i;
            if (vibrator != null) {
                vibrator.cancel();
            }
            pi piVar = this.f16694a;
            if (piVar != null) {
                piVar.stop();
                this.f16694a.release();
            }
            qa qaVar = this.h;
            if (qaVar != null) {
                qaVar.c();
            }
            c = null;
            this.e = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(String str, int i, int i2, int i3, int i4, SyncCallback syncCallback) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Wrong parameter {string: " + str + "} is null!");
        }
        StringBuilder sb = new StringBuilder("playHaptic: loop:");
        sb.append(i);
        sb.append(",interval:");
        sb.append(i2);
        sb.append(",amplitude:");
        sb.append(i3);
        sb.append(",freq:");
        sb.append(i4);
        sb.append(",callback is null:");
        sb.append(syncCallback == null);
        pw.d.a("RichTapUtils", sb.toString());
        this.j.execute(new d(str, i, i2, i3, i4, syncCallback));
    }

    public void e(String str, int i, int i2, int i3, int i4) {
        b(str, i, i2, i3, i4, null);
    }

    public void d(String str, int i, int i2) {
        e(str, i, 0, i2, 0);
    }

    public void b(String str, int i) {
        d(str, i, 255);
    }

    public boolean e() {
        return pi.d(2) || pi.d(1);
    }

    public ph c(Context context) {
        int i;
        pi piVarE;
        if (context == null) {
            throw new IllegalArgumentException("context shouldn't be null");
        }
        try {
            pi piVar = this.f16694a;
            if (piVar != null) {
                piVar.release();
                this.f16694a = null;
            }
            qa qaVar = this.h;
            if (qaVar != null) {
                qaVar.c();
            }
            Context applicationContext = context.getApplicationContext();
            this.e = applicationContext;
            if (applicationContext == null) {
                pw.d.c("RichTapUtils", "fail to get application context!");
                this.e = context;
            }
            this.i = (Vibrator) this.e.getSystemService("vibrator");
            this.f = d();
            i = 2;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (pi.d(2)) {
            int i2 = this.f;
            if (32 <= i2) {
                this.h = new qa(this.e, i2);
                this.g = i;
                pw.d.b("RichTapUtils", "init , sdk version:" + po.d + " versionCode:" + po.b + ", RichTap Core Major Version:" + this.f);
                return c;
            }
            piVarE = pi.e(this.e, 2);
        } else {
            i = 1;
            if (!pi.d(1)) {
                this.f16694a = pi.e(this.e, 0);
                this.g = 0;
                pw.d.b("RichTapUtils", "init , sdk version:" + po.d + " versionCode:" + po.b + ", RichTap Core Major Version:" + this.f);
                return c;
            }
            piVarE = pi.e(this.e, 1);
        }
        this.f16694a = piVarE;
        this.g = i;
        pw.d.b("RichTapUtils", "init , sdk version:" + po.d + " versionCode:" + po.b + ", RichTap Core Major Version:" + this.f);
        return c;
    }

    @Deprecated
    public int d() {
        return pi.a(this.e);
    }

    public static ph b() {
        if (c == null) {
            synchronized (ph.class) {
                if (c == null) {
                    c = new ph();
                }
            }
        }
        return c;
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f16695a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ SyncCallback i;

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (32 > ph.this.f || 2 != ph.this.g) {
                    ph.this.f16694a.reset();
                    ph.this.f16694a.setDataSource(this.b, this.c, this.f16695a, this.d, this.e, this.i);
                    ph.this.f16694a.prepare();
                    ph.this.f16694a.start();
                } else {
                    ph.this.h.c(this.b, this.d, this.e, this.c, this.f16695a, this.i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        d(String str, int i, int i2, int i3, int i4, SyncCallback syncCallback) {
            this.b = str;
            this.d = i;
            this.e = i2;
            this.c = i3;
            this.f16695a = i4;
            this.i = syncCallback;
        }
    }

    private ph() {
    }
}
