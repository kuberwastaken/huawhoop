package com.huawei.android.bundlecore.install.protocol;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface ISplitInstallService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.bundlecore.install.protocol.ISplitInstallService";

    void cancelInstall(String str, int i, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException;

    void deferredInstall(String str, List<Bundle> list, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException;

    void deferredUninstall(String str, List<Bundle> list, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException;

    void getSessionState(String str, int i, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException;

    void getSessionStates(String str, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException;

    void startInstall(String str, List<Bundle> list, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements ISplitInstallService {
        static final int TRANSACTION_cancelInstall = 2;
        static final int TRANSACTION_deferredInstall = 5;
        static final int TRANSACTION_deferredUninstall = 6;
        static final int TRANSACTION_getSessionState = 3;
        static final int TRANSACTION_getSessionStates = 4;
        static final int TRANSACTION_startInstall = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISplitInstallService.DESCRIPTOR);
        }

        public static ISplitInstallService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISplitInstallService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISplitInstallService)) {
                return (ISplitInstallService) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISplitInstallService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISplitInstallService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    startInstall(parcel.readString(), parcel.createTypedArrayList(Bundle.CREATOR), (Bundle) c.fG_(parcel, Bundle.CREATOR), ISplitInstallServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    cancelInstall(parcel.readString(), parcel.readInt(), (Bundle) c.fG_(parcel, Bundle.CREATOR), ISplitInstallServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    getSessionState(parcel.readString(), parcel.readInt(), ISplitInstallServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    getSessionStates(parcel.readString(), ISplitInstallServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    deferredInstall(parcel.readString(), parcel.createTypedArrayList(Bundle.CREATOR), (Bundle) c.fG_(parcel, Bundle.CREATOR), ISplitInstallServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    deferredUninstall(parcel.readString(), parcel.createTypedArrayList(Bundle.CREATOR), (Bundle) c.fG_(parcel, Bundle.CREATOR), ISplitInstallServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        static class b implements ISplitInstallService {
            private IBinder d;

            b(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallService
            public void startInstall(String str, List<Bundle> list, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    c.fH_(parcelObtain, list, 0);
                    c.fI_(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iSplitInstallServiceCallback);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallService
            public void cancelInstall(String str, int i, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    c.fI_(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iSplitInstallServiceCallback);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallService
            public void getSessionState(String str, int i, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iSplitInstallServiceCallback);
                    this.d.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallService
            public void getSessionStates(String str, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iSplitInstallServiceCallback);
                    this.d.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallService
            public void deferredInstall(String str, List<Bundle> list, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    c.fH_(parcelObtain, list, 0);
                    c.fI_(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iSplitInstallServiceCallback);
                    this.d.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallService
            public void deferredUninstall(String str, List<Bundle> list, Bundle bundle, ISplitInstallServiceCallback iSplitInstallServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    c.fH_(parcelObtain, list, 0);
                    c.fI_(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iSplitInstallServiceCallback);
                    this.d.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fG_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fI_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fH_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                fI_(parcel, list.get(i2), i);
            }
        }
    }
}
