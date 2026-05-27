package androidx.work.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
public class RemoteWorkerService extends Service {
    static final String TAG = Logger.tagWithPrefix("RemoteWorkerService");
    private IBinder mBinder;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBinder = new ListenableWorkerImpl(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.get().info(TAG, "Binding to RemoteWorkerService");
        return this.mBinder;
    }
}
