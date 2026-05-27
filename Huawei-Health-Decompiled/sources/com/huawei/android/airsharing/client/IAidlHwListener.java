package com.huawei.android.airsharing.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.android.airsharing.api.Event;
import com.huawei.android.airsharing.api.ProjectionDevice;

/* JADX INFO: loaded from: classes3.dex */
public interface IAidlHwListener extends IInterface {
    int getId() throws RemoteException;

    void onDisplayUpdate(int i, String str, String str2, int i2) throws RemoteException;

    boolean onEvent(int i, String str) throws RemoteException;

    void onEventHandle(Event event) throws RemoteException;

    void onMirrorUpdate(int i, String str, String str2, int i2, boolean z) throws RemoteException;

    void onProjectionDeviceUpdate(int i, ProjectionDevice projectionDevice) throws RemoteException;

    public static abstract class Stub extends Binder implements IAidlHwListener {
        private static final String DESCRIPTOR = "com.huawei.android.airsharing.client.IAidlHwListener";
        static final int TRANSACTION_getId = 4;
        static final int TRANSACTION_onDisplayUpdate = 2;
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onEventHandle = 6;
        static final int TRANSACTION_onMirrorUpdate = 3;
        static final int TRANSACTION_onProjectionDeviceUpdate = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAidlHwListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IAidlHwListener)) {
                return (IAidlHwListener) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zOnEvent = onEvent(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zOnEvent ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDisplayUpdate(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMirrorUpdate(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onProjectionDeviceUpdate(parcel.readInt(), parcel.readInt() != 0 ? ProjectionDevice.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onEventHandle(parcel.readInt() != 0 ? Event.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        static class b implements IAidlHwListener {
            public static IAidlHwListener e;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f1853a;

            b(IBinder iBinder) {
                this.f1853a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1853a;
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwListener
            public boolean onEvent(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.f1853a.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onEvent(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwListener
            public void onDisplayUpdate(int i, String str, String str2, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i2);
                    if (!this.f1853a.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDisplayUpdate(i, str, str2, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwListener
            public void onMirrorUpdate(int i, String str, String str2, int i2, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f1853a.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMirrorUpdate(i, str, str2, i2, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwListener
            public int getId() throws RemoteException {
                int id;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.f1853a.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        id = Stub.getDefaultImpl().getId();
                    } else {
                        parcelObtain2.readException();
                        id = parcelObtain2.readInt();
                    }
                    return id;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwListener
            public void onProjectionDeviceUpdate(int i, ProjectionDevice projectionDevice) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (projectionDevice != null) {
                        parcelObtain.writeInt(1);
                        projectionDevice.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f1853a.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onProjectionDeviceUpdate(i, projectionDevice);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.airsharing.client.IAidlHwListener
            public void onEventHandle(Event event) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (event != null) {
                        parcelObtain.writeInt(1);
                        event.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f1853a.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEventHandle(event);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAidlHwListener iAidlHwListener) {
            if (b.e != null || iAidlHwListener == null) {
                return false;
            }
            b.e = iAidlHwListener;
            return true;
        }

        public static IAidlHwListener getDefaultImpl() {
            return b.e;
        }
    }
}
