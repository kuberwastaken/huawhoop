package com.huawei.hms.maps;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes10.dex */
public interface maf extends IInterface {

    public static abstract class maa extends Binder implements maf {

        /* JADX INFO: renamed from: com.huawei.hms.maps.maf$maa$maa, reason: collision with other inner class name */
        static class C0149maa implements maf {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5165a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5165a;
            }

            C0149maa(IBinder iBinder) {
                this.f5165a = iBinder;
            }
        }

        public static maf a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.search.api.IPlaceDelegate");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof maf)) ? new C0149maa(iBinder) : (maf) iInterfaceQueryLocalInterface;
        }
    }
}
