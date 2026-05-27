package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.IWorkManagerImplCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteCallback extends IWorkManagerImplCallback.Stub {
    private IBinder mBinder = null;
    private final SettableFuture<byte[]> mFuture = SettableFuture.create();
    private final IBinder.DeathRecipient mRecipient = new DeathRecipient(this);

    protected void onRequestCompleted() {
    }

    public ListenableFuture<byte[]> getFuture() {
        return this.mFuture;
    }

    public void setBinder(IBinder iBinder) {
        this.mBinder = iBinder;
        try {
            iBinder.linkToDeath(this.mRecipient, 0);
        } catch (RemoteException e) {
            onFailure(e);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImplCallback
    public void onSuccess(byte[] bArr) throws RemoteException {
        this.mFuture.set(bArr);
        unlinkToDeath();
        onRequestCompleted();
    }

    @Override // androidx.work.multiprocess.IWorkManagerImplCallback
    public void onFailure(String str) {
        onFailure(new RuntimeException(str));
    }

    private void onFailure(Throwable th) {
        this.mFuture.setException(th);
        unlinkToDeath();
        onRequestCompleted();
    }

    private void unlinkToDeath() {
        IBinder iBinder = this.mBinder;
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this.mRecipient, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    public static class DeathRecipient implements IBinder.DeathRecipient {
        private final RemoteCallback mCallback;

        public DeathRecipient(RemoteCallback remoteCallback) {
            this.mCallback = remoteCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mCallback.onFailure("Binder died");
        }
    }
}
