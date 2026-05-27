package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.android.hicloud.sync.service.aidl.ISyncServiceCallback;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface IRequireDownService extends IInterface {

    public static abstract class Stub extends Binder implements IRequireDownService {
        private static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.IRequireDownService";
        static final int TRANSACTION_cancelDownloadFile = 6;
        static final int TRANSACTION_cancelDownloadFileForTransTooLarge = 10;
        static final int TRANSACTION_downLoadFile = 3;
        static final int TRANSACTION_downLoadFileForTransTooLarge = 7;
        static final int TRANSACTION_pauseDownloadFile = 5;
        static final int TRANSACTION_pauseDownloadFileForTransTooLarge = 9;
        static final int TRANSACTION_registerSingleCallback = 1;
        static final int TRANSACTION_startDownloadFile = 4;
        static final int TRANSACTION_startDownloadFileForTransTooLarge = 8;
        static final int TRANSACTION_unregisterSingleCallback = 2;

        static class c implements IRequireDownService {
            public static IRequireDownService d;
            private IBinder c;

            c(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void cancelDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (this.c.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelDownloadFile(str, str2, list, str3, str4);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void cancelDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str4);
                    try {
                        if (this.c.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().cancelDownloadFileForTransTooLarge(str, str2, str3, bArr, z, str4);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void downLoadFile(String str, String str2, List<UnstructData> list, boolean z, boolean z2, String str3, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    try {
                        if (this.c.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().downLoadFile(str, str2, list, z, z2, str3, str4);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void downLoadFileForTransTooLarge(String str, String str2, boolean z, boolean z2, String str3, byte[] bArr, boolean z3, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z3 ? 1 : 0);
                    parcelObtain.writeString(str4);
                    try {
                        if (this.c.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().downLoadFileForTransTooLarge(str, str2, z, z2, str3, bArr, z3, str4);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void pauseDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (this.c.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseDownloadFile(str, str2, list, str3, str4);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void pauseDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str4);
                    try {
                        if (this.c.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().pauseDownloadFileForTransTooLarge(str, str2, str3, bArr, z, str4);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public boolean registerSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iSyncServiceCallback != null ? iSyncServiceCallback.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.c.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerSingleCallback(iSyncServiceCallback, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void startDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (this.c.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().startDownloadFile(str, str2, list, str3, str4);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void startDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str4);
                    try {
                        if (this.c.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().startDownloadFileForTransTooLarge(str, str2, str3, bArr, z, str4);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void unregisterSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iSyncServiceCallback != null ? iSyncServiceCallback.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.c.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterSingleCallback(iSyncServiceCallback, str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRequireDownService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRequireDownService)) ? new c(iBinder) : (IRequireDownService) iInterfaceQueryLocalInterface;
        }

        public static IRequireDownService getDefaultImpl() {
            return c.d;
        }

        public static boolean setDefaultImpl(IRequireDownService iRequireDownService) {
            if (c.d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRequireDownService == null) {
                return false;
            }
            c.d = iRequireDownService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
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
                    boolean zRegisterSingleCallback = registerSingleCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterSingleCallback ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterSingleCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    downLoadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    startDownloadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseDownloadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelDownloadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    downLoadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    startDownloadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseDownloadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelDownloadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void cancelDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException;

    void cancelDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z, String str4) throws RemoteException;

    void downLoadFile(String str, String str2, List<UnstructData> list, boolean z, boolean z2, String str3, String str4) throws RemoteException;

    void downLoadFileForTransTooLarge(String str, String str2, boolean z, boolean z2, String str3, byte[] bArr, boolean z3, String str4) throws RemoteException;

    void pauseDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException;

    void pauseDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z, String str4) throws RemoteException;

    boolean registerSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException;

    void startDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException;

    void startDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z, String str4) throws RemoteException;

    void unregisterSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException;
}
