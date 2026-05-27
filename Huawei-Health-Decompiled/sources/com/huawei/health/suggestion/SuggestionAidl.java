package com.huawei.health.suggestion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface SuggestionAidl extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.health.suggestion.SuggestionAidl";

    boolean postFitnessRecord(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements SuggestionAidl {
        static final int TRANSACTION_postFitnessRecord = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, SuggestionAidl.DESCRIPTOR);
        }

        public static SuggestionAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(SuggestionAidl.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof SuggestionAidl)) {
                return (SuggestionAidl) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(SuggestionAidl.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(SuggestionAidl.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                boolean zPostFitnessRecord = postFitnessRecord(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zPostFitnessRecord ? 1 : 0);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        static class c implements SuggestionAidl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f3085a;

            c(IBinder iBinder) {
                this.f3085a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3085a;
            }

            @Override // com.huawei.health.suggestion.SuggestionAidl
            public boolean postFitnessRecord(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(SuggestionAidl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.f3085a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
