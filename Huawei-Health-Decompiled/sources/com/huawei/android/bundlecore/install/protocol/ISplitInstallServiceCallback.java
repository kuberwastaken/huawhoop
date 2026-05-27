package com.huawei.android.bundlecore.install.protocol;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface ISplitInstallServiceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback";

    void onCancelInstall(int i, Bundle bundle) throws RemoteException;

    void onCompleteInstall(int i) throws RemoteException;

    void onDeferredInstall(Bundle bundle) throws RemoteException;

    void onDeferredUninstall(Bundle bundle) throws RemoteException;

    void onError(Bundle bundle) throws RemoteException;

    void onGetSession(int i, Bundle bundle) throws RemoteException;

    void onGetSessionStates(List<Bundle> list) throws RemoteException;

    void onStartInstall(int i, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ISplitInstallServiceCallback {
        static final int TRANSACTION_onCancelInstall = 3;
        static final int TRANSACTION_onCompleteInstall = 2;
        static final int TRANSACTION_onDeferredInstall = 6;
        static final int TRANSACTION_onDeferredUninstall = 5;
        static final int TRANSACTION_onError = 8;
        static final int TRANSACTION_onGetSession = 4;
        static final int TRANSACTION_onGetSessionStates = 7;
        static final int TRANSACTION_onStartInstall = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISplitInstallServiceCallback.DESCRIPTOR);
        }

        public static ISplitInstallServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISplitInstallServiceCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISplitInstallServiceCallback)) {
                return (ISplitInstallServiceCallback) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISplitInstallServiceCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISplitInstallServiceCallback.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    onStartInstall(parcel.readInt(), (Bundle) a.fM_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    onCompleteInstall(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    onCancelInstall(parcel.readInt(), (Bundle) a.fM_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    onGetSession(parcel.readInt(), (Bundle) a.fM_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    onDeferredUninstall((Bundle) a.fM_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onDeferredInstall((Bundle) a.fM_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    onGetSessionStates(parcel.createTypedArrayList(Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    onError((Bundle) a.fM_(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        static class b implements ISplitInstallServiceCallback {
            private IBinder e;

            b(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onStartInstall(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    a.fO_(parcelObtain, bundle, 0);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onCompleteInstall(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onCancelInstall(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    a.fO_(parcelObtain, bundle, 0);
                    this.e.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onGetSession(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    a.fO_(parcelObtain, bundle, 0);
                    this.e.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onDeferredUninstall(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    a.fO_(parcelObtain, bundle, 0);
                    this.e.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onDeferredInstall(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    a.fO_(parcelObtain, bundle, 0);
                    this.e.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onGetSessionStates(List<Bundle> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    a.fN_(parcelObtain, list, 0);
                    this.e.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.bundlecore.install.protocol.ISplitInstallServiceCallback
            public void onError(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplitInstallServiceCallback.DESCRIPTOR);
                    a.fO_(parcelObtain, bundle, 0);
                    this.e.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fM_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fO_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fN_(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                fO_(parcel, list.get(i2), i);
            }
        }
    }
}
