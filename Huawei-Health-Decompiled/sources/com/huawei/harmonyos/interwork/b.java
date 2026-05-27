package com.huawei.harmonyos.interwork;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {
    void a(int i) throws RemoteException;

    public static abstract class a extends Binder implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.huawei.harmonyos.interwork.IAbilityStartCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.harmonyos.interwork.IAbilityStartCallback");
                a(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("com.huawei.harmonyos.interwork.IAbilityStartCallback");
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: renamed from: com.huawei.harmonyos.interwork.b$a$a, reason: collision with other inner class name */
        public static final class C0068a implements b {
            public static b b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f2205a;

            public C0068a(IBinder iBinder) {
                this.f2205a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f2205a;
            }

            @Override // com.huawei.harmonyos.interwork.b
            public final void a(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.harmonyos.interwork.IAbilityStartCallback");
                    parcelObtain.writeInt(i);
                    if (this.f2205a.transact(1, parcelObtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(i);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static b a() {
            return C0068a.b;
        }
    }
}
