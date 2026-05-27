package com.huawei.hms.kit.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.kit.awareness.a.a.f;

/* JADX INFO: loaded from: classes5.dex */
public interface b extends IInterface {
    public static final String c = "com.huawei.hms.kit.awareness.IRemoteWakeup";

    /* JADX INFO: renamed from: com.huawei.hms.kit.awareness.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes10.dex */
    public static class C0141b implements b {
        @Override // com.huawei.hms.kit.awareness.b
        public void a(f fVar) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void a(f fVar);

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f4998a = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(b.c);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(b.c);
            a(parcel.readInt() != 0 ? f.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.huawei.hms.kit.awareness.b$a$a, reason: collision with other inner class name */
        static class C0140a implements b {
            public static b b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f4999a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4999a;
            }

            @Override // com.huawei.hms.kit.awareness.b
            public void a(f fVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.c);
                    if (fVar != null) {
                        parcelObtain.writeInt(1);
                        fVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f4999a.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().a(fVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String a() {
                return b.c;
            }

            C0140a(IBinder iBinder) {
                this.f4999a = iBinder;
            }
        }

        public static boolean a(b bVar) {
            if (C0140a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            C0140a.b = bVar;
            return true;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b.c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0140a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b a() {
            return C0140a.b;
        }

        public a() {
            attachInterface(this, b.c);
        }
    }
}
