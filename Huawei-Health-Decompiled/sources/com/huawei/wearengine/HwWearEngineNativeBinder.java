package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.p2p.IdentityInfo;

/* JADX INFO: loaded from: classes8.dex */
public interface HwWearEngineNativeBinder extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.HwWearEngineNativeBinder";

    /* JADX INFO: loaded from: classes11.dex */
    public static class Default implements HwWearEngineNativeBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.wearengine.HwWearEngineNativeBinder
        public boolean isP2pReceiverExist(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2) throws RemoteException {
            return false;
        }

        @Override // com.huawei.wearengine.HwWearEngineNativeBinder
        public void setBinder(String str, IBinder iBinder) throws RemoteException {
        }
    }

    boolean isP2pReceiverExist(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2) throws RemoteException;

    void setBinder(String str, IBinder iBinder) throws RemoteException;

    public static abstract class Stub extends Binder implements HwWearEngineNativeBinder {
        static final int TRANSACTION_isP2pReceiverExist = 2;
        static final int TRANSACTION_setBinder = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, HwWearEngineNativeBinder.DESCRIPTOR);
        }

        public static HwWearEngineNativeBinder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(HwWearEngineNativeBinder.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof HwWearEngineNativeBinder)) {
                return (HwWearEngineNativeBinder) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(HwWearEngineNativeBinder.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(HwWearEngineNativeBinder.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                setBinder(parcel.readString(), parcel.readStrongBinder());
                parcel2.writeNoException();
            } else if (i == 2) {
                boolean zIsP2pReceiverExist = isP2pReceiverExist((Device) d.fAW_(parcel, Device.CREATOR), (IdentityInfo) d.fAW_(parcel, IdentityInfo.CREATOR), (IdentityInfo) d.fAW_(parcel, IdentityInfo.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zIsP2pReceiverExist ? 1 : 0);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class Proxy implements HwWearEngineNativeBinder {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.wearengine.HwWearEngineNativeBinder
            public void setBinder(String str, IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(HwWearEngineNativeBinder.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.HwWearEngineNativeBinder
            public boolean isP2pReceiverExist(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(HwWearEngineNativeBinder.DESCRIPTOR);
                    d.fAX_(parcelObtain, device, 0);
                    d.fAX_(parcelObtain, identityInfo, 0);
                    d.fAX_(parcelObtain, identityInfo2, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return HwWearEngineNativeBinder.DESCRIPTOR;
            }
        }
    }

    public static class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fAW_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fAX_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
