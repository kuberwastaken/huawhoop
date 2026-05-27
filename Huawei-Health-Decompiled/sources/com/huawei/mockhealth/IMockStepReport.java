package com.huawei.mockhealth;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IMockStepReport extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.mockhealth.IMockStepReport";

    void onExtendStepChanged(Bundle bundle) throws RemoteException;

    void onStandStepChanged(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IMockStepReport {
        static final int TRANSACTION_onExtendStepChanged = 2;
        static final int TRANSACTION_onStandStepChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IMockStepReport.DESCRIPTOR);
        }

        public static IMockStepReport asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMockStepReport.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMockStepReport)) {
                return (IMockStepReport) iInterfaceQueryLocalInterface;
            }
            return new c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMockStepReport.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMockStepReport.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onStandStepChanged(parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 2) {
                onExtendStepChanged((Bundle) e.cdD_(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* JADX INFO: loaded from: classes6.dex */
        static class c implements IMockStepReport {
            private IBinder e;

            c(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.huawei.mockhealth.IMockStepReport
            public void onStandStepChanged(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMockStepReport.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.mockhealth.IMockStepReport
            public void onExtendStepChanged(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMockStepReport.DESCRIPTOR);
                    e.cdE_(parcelObtain, bundle, 0);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T cdD_(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void cdE_(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
