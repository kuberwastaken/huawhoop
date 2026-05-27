package com.huawei.mockhealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.mockhealth.IMockStepReport;

/* JADX INFO: loaded from: classes.dex */
public interface IMockStepService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.mockhealth.IMockStepService";

    int getCapacity() throws RemoteException;

    void registerMockStepReport(IMockStepReport iMockStepReport) throws RemoteException;

    void unregisterMockStepReport(IMockStepReport iMockStepReport) throws RemoteException;

    public static abstract class Stub extends Binder implements IMockStepService {
        static final int TRANSACTION_getCapacity = 3;
        static final int TRANSACTION_registerMockStepReport = 1;
        static final int TRANSACTION_unregisterMockStepReport = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IMockStepService.DESCRIPTOR);
        }

        public static IMockStepService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMockStepService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMockStepService)) {
                return (IMockStepService) iInterfaceQueryLocalInterface;
            }
            return new b(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMockStepService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMockStepService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                registerMockStepReport(IMockStepReport.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i == 2) {
                unregisterMockStepReport(IMockStepReport.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i == 3) {
                int capacity = getCapacity();
                parcel2.writeNoException();
                parcel2.writeInt(capacity);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* JADX INFO: loaded from: classes6.dex */
        static class b implements IMockStepService {
            private IBinder c;

            b(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.huawei.mockhealth.IMockStepService
            public void registerMockStepReport(IMockStepReport iMockStepReport) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMockStepService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMockStepReport);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.mockhealth.IMockStepService
            public void unregisterMockStepReport(IMockStepReport iMockStepReport) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMockStepService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMockStepReport);
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.mockhealth.IMockStepService
            public int getCapacity() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMockStepService.DESCRIPTOR);
                    this.c.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
