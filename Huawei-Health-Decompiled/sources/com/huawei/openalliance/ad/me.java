package com.huawei.openalliance.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.huawei.openalliance.ad.constant.Constants;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class me {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f7456a;
    private a b;
    private Context c;
    private AudioManager d;
    private boolean e = false;

    public interface b {
        void a();
    }

    public void a(b bVar) {
        this.f7456a = bVar;
    }

    public void a() {
        if (this.e) {
            try {
                this.c.unregisterReceiver(this.b);
            } catch (Exception e) {
                hq.b("VolumeChangeObserver", "unregisterReceiver, " + e.getClass().getSimpleName());
            }
            this.f7456a = null;
            this.e = false;
        }
    }

    public float a(boolean z) {
        AudioManager audioManager = this.d;
        if (audioManager != null) {
            return mf.a(audioManager, z);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b b() {
        return this.f7456a;
    }

    static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<me> f7457a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            me meVar;
            b bVarB;
            try {
                if (!((Constants.VOLUME_CHANGED_ACTION.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0) == 3) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0) == 1) || (meVar = this.f7457a.get()) == null || (bVarB = meVar.b()) == null) {
                    return;
                }
                bVarB.a();
            } catch (Throwable th) {
                hq.c("VolumeChangeObserver", "onReceive error:" + th.getClass().getSimpleName());
            }
        }
    }

    public me(Context context) {
        this.c = context;
        this.d = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }
}
