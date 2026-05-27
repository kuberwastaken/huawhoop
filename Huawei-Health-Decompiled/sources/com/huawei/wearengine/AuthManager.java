package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.wearengine.auth.AuthListener;
import com.huawei.wearengine.auth.Permission;

/* JADX INFO: loaded from: classes11.dex */
public interface AuthManager extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.wearengine.AuthManager";

    boolean checkPermission(Permission permission) throws RemoteException;

    boolean[] checkPermissions(Permission[] permissionArr) throws RemoteException;

    String preStartAuth(AuthListener authListener) throws RemoteException;

    int requestPermission(AuthListener authListener, Permission[] permissionArr) throws RemoteException;

    public static abstract class Stub extends Binder implements AuthManager {
        static final int TRANSACTION_checkPermission = 2;
        static final int TRANSACTION_checkPermissions = 3;
        static final int TRANSACTION_preStartAuth = 4;
        static final int TRANSACTION_requestPermission = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, AuthManager.DESCRIPTOR);
        }

        public static AuthManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(AuthManager.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof AuthManager)) {
                return (AuthManager) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(AuthManager.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(AuthManager.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int iRequestPermission = requestPermission(AuthListener.Stub.asInterface(parcel.readStrongBinder()), (Permission[]) parcel.createTypedArray(Permission.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(iRequestPermission);
            } else if (i == 2) {
                boolean zCheckPermission = checkPermission((Permission) d.fAF_(parcel, Permission.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zCheckPermission ? 1 : 0);
            } else if (i == 3) {
                boolean[] zArrCheckPermissions = checkPermissions((Permission[]) parcel.createTypedArray(Permission.CREATOR));
                parcel2.writeNoException();
                parcel2.writeBooleanArray(zArrCheckPermissions);
            } else if (i == 4) {
                String strPreStartAuth = preStartAuth(AuthListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(strPreStartAuth);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        static class c implements AuthManager {
            private IBinder d;

            c(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.huawei.wearengine.AuthManager
            public int requestPermission(AuthListener authListener, Permission[] permissionArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AuthManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(authListener);
                    parcelObtain.writeTypedArray(permissionArr, 0);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.AuthManager
            public boolean checkPermission(Permission permission) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AuthManager.DESCRIPTOR);
                    d.fAG_(parcelObtain, permission, 0);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.AuthManager
            public boolean[] checkPermissions(Permission[] permissionArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AuthManager.DESCRIPTOR);
                    parcelObtain.writeTypedArray(permissionArr, 0);
                    this.d.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createBooleanArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.AuthManager
            public String preStartAuth(AuthListener authListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AuthManager.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(authListener);
                    this.d.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T fAF_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void fAG_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
