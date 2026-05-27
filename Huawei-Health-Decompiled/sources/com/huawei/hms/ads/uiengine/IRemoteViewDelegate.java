package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* JADX INFO: loaded from: classes5.dex */
public interface IRemoteViewDelegate extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IRemoteViewDelegate";

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    Bundle sendCommand(String str, Bundle bundle);

    void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback);

    public static abstract class a extends Binder implements IRemoteViewDelegate {

        /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.IRemoteViewDelegate$a$a, reason: collision with other inner class name */
        static class C0101a implements IRemoteViewDelegate {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IRemoteViewDelegate f4534a;
            private IBinder b;

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.b.transact(9, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().setCallback(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public Bundle sendCommand(String str, Bundle bundle) {
                Bundle bundleSendCommand;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(10, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                        bundleSendCommand = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleSendCommand = a.a().sendCommand(str, bundle);
                    }
                    return bundleSendCommand;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStop() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.b.transact(7, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onStop();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.b.transact(6, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onResume() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.b.transact(5, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onResume();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onRestart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.b.transact(8, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onRestart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onPause() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.b.transact(4, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onPause();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onDestroy() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.b.transact(3, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onDestroy();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onCreate(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(2, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onCreate(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public IObjectWrapper getView() {
                IObjectWrapper iObjectWrapperAsInterface;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                        iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                    } else {
                        iObjectWrapperAsInterface = a.a().getView();
                    }
                    return iObjectWrapperAsInterface;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            C0101a(IBinder iBinder) {
                this.b = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        IObjectWrapper view = getView();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(view != null ? view.asBinder() : null);
                        return true;
                    case 2:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        onCreate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        break;
                    case 3:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        onDestroy();
                        break;
                    case 4:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        onPause();
                        break;
                    case 5:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        onResume();
                        break;
                    case 6:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        onStart();
                        break;
                    case 7:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        onStop();
                        break;
                    case 8:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        onRestart();
                        break;
                    case 9:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        setCallback(IPPSUiEngineCallback.a.a(parcel.readStrongBinder()));
                        break;
                    case 10:
                        parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                        Bundle bundleSendCommand = sendCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        if (bundleSendCommand != null) {
                            parcel2.writeInt(1);
                            bundleSendCommand.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(IRemoteViewDelegate.DESCRIPTOR);
            return true;
        }

        public static IRemoteViewDelegate a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteViewDelegate.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteViewDelegate)) ? new C0101a(iBinder) : (IRemoteViewDelegate) iInterfaceQueryLocalInterface;
        }

        public static IRemoteViewDelegate a() {
            return C0101a.f4534a;
        }
    }
}
