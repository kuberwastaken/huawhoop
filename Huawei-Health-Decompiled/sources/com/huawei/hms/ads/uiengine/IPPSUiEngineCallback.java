package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface IPPSUiEngineCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IPPSUiEngineCallback";

    void onCallResult(String str, Bundle bundle);

    public static abstract class a extends Binder implements IPPSUiEngineCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(IPPSUiEngineCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(IPPSUiEngineCallback.DESCRIPTOR);
            onCallResult(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.IPPSUiEngineCallback$a$a, reason: collision with other inner class name */
        static class C0099a implements IPPSUiEngineCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IPPSUiEngineCallback f4532a;
            private IBinder b;

            @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
            public void onCallResult(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPPSUiEngineCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().onCallResult(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            C0099a(IBinder iBinder) {
                this.b = iBinder;
            }
        }

        public static IPPSUiEngineCallback a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPPSUiEngineCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPPSUiEngineCallback)) ? new C0099a(iBinder) : (IPPSUiEngineCallback) iInterfaceQueryLocalInterface;
        }

        public static IPPSUiEngineCallback a() {
            return C0099a.f4532a;
        }

        public a() {
            attachInterface(this, IPPSUiEngineCallback.DESCRIPTOR);
        }
    }
}
