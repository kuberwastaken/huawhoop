package com.huawei.android.appbundle.binder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public class BinderWrapper extends Binder implements IInterface {
    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    protected boolean dispatchTransact(int i, Parcel parcel) {
        return false;
    }

    public BinderWrapper(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.Binder
    protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i > 16777215) {
            if (!super.onTransact(i, parcel, parcel2, i2)) {
            }
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return dispatchTransact(i, parcel);
    }
}
