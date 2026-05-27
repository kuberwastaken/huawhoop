package com.huawei.openalliance.ad;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes6.dex */
public interface cr extends IInterface {
    String a();

    boolean b();

    public static abstract class a {

        /* JADX INFO: renamed from: com.huawei.openalliance.ad.cr$a$a, reason: collision with other inner class name */
        static class C0190a implements cr {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6927a;

            public String c() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }

            @Override // com.huawei.openalliance.ad.cr
            public boolean b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c());
                    this.f6927a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6927a;
            }

            @Override // com.huawei.openalliance.ad.cr
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c());
                    this.f6927a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0190a(IBinder iBinder) {
                this.f6927a = iBinder;
            }
        }

        public static cr a(IBinder iBinder) {
            return new C0190a(iBinder);
        }
    }
}
