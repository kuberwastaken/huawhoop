package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface aabi extends IInterface {
    String aab(String str, com.huawei.hms.hihealth.options.aaba aabaVar) throws RemoteException;

    String aabb(String str) throws RemoteException;

    public static abstract class aab extends Binder implements aabi {

        /* JADX INFO: renamed from: com.huawei.hms.hihealth.aabi$aab$aab, reason: collision with other inner class name */
        static class C0120aab implements aabi {
            private IBinder aab;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }

            @Override // com.huawei.hms.hihealth.aabi
            public String aabb(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.hihealth.ICommonApiCall");
                    parcelObtain.writeString(str);
                    this.aab.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.hihealth.aabi
            public String aab(String str, com.huawei.hms.hihealth.options.aaba aabaVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.hihealth.ICommonApiCall");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(aabaVar);
                    this.aab.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0120aab(IBinder iBinder) {
                this.aab = iBinder;
            }
        }

        public static aabi aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.ICommonApiCall");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof aabi)) ? new C0120aab(iBinder) : (aabi) iInterfaceQueryLocalInterface;
        }
    }
}
