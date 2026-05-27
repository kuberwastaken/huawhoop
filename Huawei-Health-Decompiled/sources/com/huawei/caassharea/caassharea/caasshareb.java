package com.huawei.caassharea.caassharea;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.caassharea.caassharea.caassharea;

/* JADX INFO: loaded from: classes10.dex */
public interface caasshareb extends IInterface {
    boolean caassharea();

    boolean caassharea(int i);

    boolean caassharea(Bundle bundle);

    boolean caassharea(com.huawei.caassharea.caassharea.caassharea caasshareaVar);

    boolean caasshareb(Bundle bundle);

    public static abstract class caassharea extends Binder implements caasshareb {

        static final class b implements caasshareb {
            public static caasshareb c;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f1970a;

            @Override // com.huawei.caassharea.caassharea.caasshareb
            public final boolean caasshareb(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.caasservice.share.IHwCaasShareService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f1970a.transact(4, parcelObtain, parcelObtain2, 0) && caassharea.caasshareb() != null) {
                        return caassharea.caasshareb().caasshareb(bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.caassharea.caassharea.caasshareb
            public final boolean caassharea(com.huawei.caassharea.caassharea.caassharea caasshareaVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.caasservice.share.IHwCaasShareService");
                    parcelObtain.writeStrongBinder(caasshareaVar != null ? caasshareaVar.asBinder() : null);
                    if (!this.f1970a.transact(1, parcelObtain, parcelObtain2, 0) && caassharea.caasshareb() != null) {
                        return caassharea.caasshareb().caassharea(caasshareaVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.caassharea.caassharea.caasshareb
            public final boolean caassharea(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.caasservice.share.IHwCaasShareService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f1970a.transact(3, parcelObtain, parcelObtain2, 0) && caassharea.caasshareb() != null) {
                        return caassharea.caasshareb().caassharea(bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.caassharea.caassharea.caasshareb
            public final boolean caassharea(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.caasservice.share.IHwCaasShareService");
                    parcelObtain.writeInt(i);
                    if (!this.f1970a.transact(5, parcelObtain, parcelObtain2, 0) && caassharea.caasshareb() != null) {
                        return caassharea.caasshareb().caassharea(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.caassharea.caassharea.caasshareb
            public final boolean caassharea() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.caasservice.share.IHwCaasShareService");
                    if (!this.f1970a.transact(2, parcelObtain, parcelObtain2, 0) && caassharea.caasshareb() != null) {
                        return caassharea.caasshareb().caassharea();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f1970a;
            }

            b(IBinder iBinder) {
                this.f1970a = iBinder;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int iCaassharea;
            com.huawei.caassharea.caassharea.caassharea eVar = null;
            if (i == 1) {
                parcel.enforceInterface("com.huawei.caasservice.share.IHwCaasShareService");
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.huawei.caasservice.share.IHwCaasShareCallback");
                    eVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.huawei.caassharea.caassharea.caassharea)) ? new caassharea.AbstractBinderC0065caassharea.e(strongBinder) : (com.huawei.caassharea.caassharea.caassharea) iInterfaceQueryLocalInterface;
                }
                iCaassharea = caassharea(eVar);
            } else if (i == 2) {
                parcel.enforceInterface("com.huawei.caasservice.share.IHwCaasShareService");
                iCaassharea = caassharea();
            } else if (i == 3) {
                parcel.enforceInterface("com.huawei.caasservice.share.IHwCaasShareService");
                iCaassharea = caassharea(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            } else if (i == 4) {
                parcel.enforceInterface("com.huawei.caasservice.share.IHwCaasShareService");
                iCaassharea = caasshareb(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            } else {
                if (i != 5) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.huawei.caasservice.share.IHwCaasShareService");
                    return true;
                }
                parcel.enforceInterface("com.huawei.caasservice.share.IHwCaasShareService");
                iCaassharea = caassharea(parcel.readInt());
            }
            parcel2.writeNoException();
            parcel2.writeInt(iCaassharea);
            return true;
        }

        public static caasshareb caasshareb() {
            return b.c;
        }

        public static caasshareb caassharea(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.caasservice.share.IHwCaasShareService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof caasshareb)) ? new b(iBinder) : (caasshareb) iInterfaceQueryLocalInterface;
        }
    }
}
