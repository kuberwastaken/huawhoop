package com.huawei.openalliance.ad.hsf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.openalliance.ad.hq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface b extends IInterface {
    int a();

    int a(String str, List<PPSHsfService> list);

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.huawei.openalliance.ad.hsf.b$a$a, reason: collision with other inner class name */
        static class C0204a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7173a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7173a;
            }

            @Override // com.huawei.openalliance.ad.hsf.b
            public int a(String str, List<PPSHsfService> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.internal.ICoreService");
                    parcelObtain.writeString(str);
                    this.f7173a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i = parcelObtain2.readInt();
                    parcelObtain2.readTypedList(list, PPSHsfService.CREATOR);
                    return i;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.openalliance.ad.hsf.b
            public int a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.internal.ICoreService");
                    this.f7173a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0204a(IBinder iBinder) {
                this.f7173a = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.hsf.internal.ICoreService");
                int iA = a();
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.huawei.hsf.internal.ICoreService");
                return true;
            }
            parcel.enforceInterface("com.huawei.hsf.internal.ICoreService");
            String string = parcel.readString();
            ArrayList arrayList = new ArrayList();
            int iA2 = a(string, arrayList);
            parcel2.writeNoException();
            parcel2.writeInt(iA2);
            parcel2.writeTypedList(arrayList);
            return true;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hsf.internal.ICoreService");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0204a(iBinder) : (b) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                hq.c("ICoreService", "ICoreService err: " + th.getClass().getSimpleName());
                return null;
            }
        }
    }
}
