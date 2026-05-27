package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes5.dex */
public interface aabl extends IInterface {

    public static abstract class aab extends Binder implements aabl {

        /* JADX INFO: renamed from: com.huawei.hms.hihealth.aabl$aab$aab, reason: collision with other inner class name */
        static class C0122aab implements aabl {
            private IBinder aab;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }

            C0122aab(IBinder iBinder) {
                this.aab = iBinder;
            }
        }

        public static aabl aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IDataControllerManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof aabl)) ? new C0122aab(iBinder) : (aabl) iInterfaceQueryLocalInterface;
        }
    }
}
