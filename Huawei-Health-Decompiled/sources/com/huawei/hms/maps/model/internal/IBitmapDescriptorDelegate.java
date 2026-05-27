package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes5.dex */
public interface IBitmapDescriptorDelegate extends IInterface {
    IObjectWrapper defaultMarker();

    IObjectWrapper defaultMarkerWithHue(float f);

    public static abstract class Stub extends Binder implements IBitmapDescriptorDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        static class Proxy implements IBitmapDescriptorDelegate {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5206a;

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate";
            }

            @Override // com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate
            public IObjectWrapper defaultMarkerWithHue(float f) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate");
                    parcelObtain.writeFloat(f);
                    this.f5206a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate
            public IObjectWrapper defaultMarker() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f5206a, "com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate", 1));
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5206a;
            }

            Proxy(IBinder iBinder) {
                this.f5206a = iBinder;
            }
        }

        public static IBitmapDescriptorDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IBitmapDescriptorDelegate");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBitmapDescriptorDelegate)) ? new Proxy(iBinder) : (IBitmapDescriptorDelegate) iInterfaceQueryLocalInterface;
        }
    }
}
