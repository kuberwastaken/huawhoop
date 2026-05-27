package com.huawei.profile.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.profile.profile.DeviceProfile;
import com.huawei.profile.profile.Result;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface GetDeviceInfoListener extends IInterface {

    public static class Default implements GetDeviceInfoListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.profile.service.GetDeviceInfoListener
        public void onComplete(Result result, List<DeviceProfile> list) throws RemoteException {
        }
    }

    void onComplete(Result result, List<DeviceProfile> list) throws RemoteException;

    public static abstract class Stub extends Binder implements GetDeviceInfoListener {
        private static final String DESCRIPTOR = "com.huawei.profile.service.GetDeviceInfoListener";
        static final int TRANSACTION_onComplete = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static GetDeviceInfoListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof GetDeviceInfoListener)) {
                return (GetDeviceInfoListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onComplete(parcel.readInt() != 0 ? Result.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(DeviceProfile.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        static class Proxy implements GetDeviceInfoListener {
            public static GetDeviceInfoListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.profile.service.GetDeviceInfoListener
            public void onComplete(Result result, List<DeviceProfile> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (result != null) {
                        parcelObtain.writeInt(1);
                        result.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeTypedList(list);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onComplete(result, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public static boolean setDefaultImpl(GetDeviceInfoListener getDeviceInfoListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (getDeviceInfoListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = getDeviceInfoListener;
            return true;
        }

        public static GetDeviceInfoListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
