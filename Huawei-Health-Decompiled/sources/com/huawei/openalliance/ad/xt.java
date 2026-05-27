package com.huawei.openalliance.ad;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes6.dex */
public interface xt extends IInterface {
    String a(String str, String str2, String str3);

    public static abstract class a extends Binder implements xt {

        /* JADX INFO: renamed from: com.huawei.openalliance.ad.xt$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes11.dex */
        static class C0241a implements xt {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static xt f8502a;
            private IBinder b;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.openalliance.ad.xt
            public String a(String str, String str2, String str3) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.a().a(str, str2, str3);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0241a(IBinder iBinder) {
                this.b = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String strA = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }

        public static xt a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof xt)) ? new C0241a(iBinder) : (xt) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                hq.c("IOpenID", "IOpenID err: " + th.getClass().getSimpleName());
                return null;
            }
        }

        public static xt a() {
            return C0241a.f8502a;
        }

        public a() {
            attachInterface(this, "com.heytap.openid.IOpenID");
        }
    }
}
