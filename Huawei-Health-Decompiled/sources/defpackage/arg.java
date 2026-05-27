package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public class arg implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f280a;
    private final IBinder c;

    protected arg(IBinder iBinder, String str) {
        this.c = iBinder;
        this.f280a = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.c;
    }

    protected final Parcel fh_() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f280a);
        return parcelObtain;
    }

    protected final void fi_(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.c.transact(i, parcel, parcelObtain, 1);
            parcelObtain.readException();
        } finally {
            parcelObtain.recycle();
            parcel.recycle();
        }
    }
}
