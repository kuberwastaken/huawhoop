package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.b;

/* JADX INFO: loaded from: classes5.dex */
public interface IGlobalUtil extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IGlobalUtil";

    Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback);

    String getFilePathDirect(String str);

    String getFilePathDirectByCacheType(String str, int i);

    b getMultiMediaPlayingManager();

    boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper);

    void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);

    void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);

    public static abstract class a extends Binder implements IGlobalUtil {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.IGlobalUtil$a$a, reason: collision with other inner class name */
        static class C0098a implements IGlobalUtil {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IGlobalUtil f4531a;
            private IBinder b;

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.b.transact(3, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().unregisterActivityStartCallBack(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.b.transact(2, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().registerActivityStartCallBack(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.b.transact(7, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().isFreedomWindowMode(iObjectWrapper);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public b getMultiMediaPlayingManager() {
                b bVarA;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    if (this.b.transact(6, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                        bVarA = b.a.a(parcelObtain2.readStrongBinder());
                    } else {
                        bVarA = a.a().getMultiMediaPlayingManager();
                    }
                    return bVarA;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirectByCacheType(String str, int i) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.b.transact(5, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.a().getFilePathDirectByCacheType(str, i);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirect(String str) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.b.transact(4, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.a().getFilePathDirect(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().getFilePath(str, iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.b.transact(8, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().callMethod(str, iObjectWrapper, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            C0098a(IBinder iBinder) {
                this.b = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        getFilePath(parcel.readString(), IPPSUiEngineCallback.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        registerActivityStartCallBack(IPPSUiEngineCallback.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        unregisterActivityStartCallBack(IPPSUiEngineCallback.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        String filePathDirect = getFilePathDirect(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(filePathDirect);
                        return true;
                    case 5:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        String filePathDirectByCacheType = getFilePathDirectByCacheType(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(filePathDirectByCacheType);
                        return true;
                    case 6:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        b multiMediaPlayingManager = getMultiMediaPlayingManager();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(multiMediaPlayingManager != null ? multiMediaPlayingManager.asBinder() : null);
                        return true;
                    case 7:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        boolean zIsFreedomWindowMode = isFreedomWindowMode(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(zIsFreedomWindowMode ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                        Bundle bundleCallMethod = callMethod(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        if (bundleCallMethod != null) {
                            parcel2.writeInt(1);
                            bundleCallMethod.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(IGlobalUtil.DESCRIPTOR);
            return true;
        }

        public static IGlobalUtil a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IGlobalUtil.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGlobalUtil)) ? new C0098a(iBinder) : (IGlobalUtil) iInterfaceQueryLocalInterface;
        }

        public static IGlobalUtil a() {
            return C0098a.f4531a;
        }

        public a() {
            attachInterface(this, IGlobalUtil.DESCRIPTOR);
        }
    }
}
