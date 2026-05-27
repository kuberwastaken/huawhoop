package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.maps.model.Tile;

/* JADX INFO: loaded from: classes10.dex */
public interface ITileProviderDelegate extends IInterface {
    Tile getTile(int i, int i2, int i3);

    public static abstract class Stub extends Binder implements ITileProviderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        static class Proxy implements ITileProviderDelegate {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5217a;

            @Override // com.huawei.hms.maps.model.internal.ITileProviderDelegate
            public Tile getTile(int i, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f5217a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Tile.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.ITileProviderDelegate";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5217a;
            }

            Proxy(IBinder iBinder) {
                this.f5217a = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
                return true;
            }
            parcel.enforceInterface("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
            Tile tile = getTile(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            if (tile != null) {
                parcel2.writeInt(1);
                tile.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        public static ITileProviderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.ITileProviderDelegate");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITileProviderDelegate)) ? new Proxy(iBinder) : (ITileProviderDelegate) iInterfaceQueryLocalInterface;
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.ITileProviderDelegate");
        }
    }
}
