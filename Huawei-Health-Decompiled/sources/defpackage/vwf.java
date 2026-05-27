package defpackage;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public final class vwf {
    private volatile String j;
    private static final Object c = new Object();
    private static vwf b = new vwf();
    private int h = -1;
    private int d = -1;
    private boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BlockingQueue<vwe> f18813a = new ArrayBlockingQueue(256);
    private e i = new e();
    private boolean f = false;
    private boolean e = false;

    private vwf() {
        Log.i("AppLogManager", "AppLogManager onCreate");
    }

    public static vwf e() {
        return b;
    }

    public boolean b(vwe vweVar) {
        return this.f18813a.offer(vweVar);
    }

    class e extends Thread {
        public e() {
            super.setName("PrintWorker");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            vwf vwfVar = vwf.this;
            synchronized (vwf.c) {
                try {
                    vwi.b(vwfVar.h, vwfVar.j, vwfVar.d, true);
                } catch (IOException unused) {
                    Log.i("AppLogManager", "LogWrite init IOException");
                }
                b(vwfVar);
            }
            Log.i("AppLogManager", "PrintWoker end.");
            vwi.a("I", "AppLogManager", "PrintWoker end.", null);
            vwi.a();
            vwf.this.f = false;
        }

        private void b(vwf vwfVar) {
            while (vwfVar.f) {
                try {
                    if (vwf.this.g) {
                        vwe vweVar = (vwe) vwfVar.f18813a.poll();
                        if (vweVar != null) {
                            vwi.a(vweVar.b(), vweVar.d(), vweVar.c(), null);
                            vwi.a();
                        } else {
                            Log.i("AppLogManager", "PrintWoker poll timeout , shutdown");
                            vwi.a();
                            vwe vweVar2 = (vwe) vwfVar.f18813a.take();
                            vwi.a(vweVar2.b(), vweVar2.d(), vweVar2.c(), null);
                            vwi.a();
                        }
                    } else {
                        vwe vweVar3 = (vwe) vwfVar.f18813a.poll(60L, TimeUnit.SECONDS);
                        if (vweVar3 != null) {
                            vwi.a(vweVar3.b(), vweVar3.d(), vweVar3.c(), null);
                        } else {
                            Log.i("AppLogManager", "PrintWoker poll timeout , shutdown");
                            vwi.a("I", "AppLogManager", "PrintWoker poll timeout , shutdown", null);
                            vwi.a();
                            vwe vweVar4 = (vwe) vwfVar.f18813a.take();
                            vwi.a(vweVar4.b(), vweVar4.d(), vweVar4.c(), null);
                        }
                    }
                } catch (Error unused) {
                    Log.i("AppLogManager", "PrintWoker Error");
                    return;
                } catch (InterruptedException unused2) {
                    Log.i("AppLogManager", "PrintWoker InterruptedException");
                    return;
                } catch (Exception unused3) {
                    Log.i("AppLogManager", "PrintWoker IllegalMonitorStateException");
                    return;
                }
            }
        }
    }
}
