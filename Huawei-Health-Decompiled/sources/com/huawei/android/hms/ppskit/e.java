package com.huawei.android.hms.ppskit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.android.hms.ppskit.d;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends IInterface {
    void a();

    void a(String str, String str2, d dVar);

    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: com.huawei.android.hms.ppskit.e$a$e, reason: collision with other inner class name */
        static class C0061e implements e {
            public static e d;
            private IBinder b;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.android.hms.ppskit.e
            public void a(String str, String str2, d dVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSServiceApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (this.b.transact(2, parcelObtain, parcelObtain2, 0) || a.b() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.b().a(str, str2, dVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hms.ppskit.e
            public void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSServiceApi");
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || a.b() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.b().a();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0061e(IBinder iBinder) {
                this.b = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.huawei.android.hms.ppskit.IPPSServiceApi");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.huawei.android.hms.ppskit.IPPSServiceApi");
                a();
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel.enforceInterface("com.huawei.android.hms.ppskit.IPPSServiceApi");
                a(parcel.readString(), parcel.readString(), d.a.a(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            return true;
        }

        public static e b() {
            return C0061e.d;
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSServiceApi");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0061e(iBinder) : (e) iInterfaceQueryLocalInterface;
        }
    }
}
