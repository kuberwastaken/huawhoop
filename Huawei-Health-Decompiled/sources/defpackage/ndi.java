package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class ndi {
    public static IBinder cgw_() {
        IBinder iBinderCgx_ = cgx_("SamgrService");
        if (iBinderCgx_ == null) {
            Log.e("ConnectUtils", "samgr is null");
            return iBinderCgx_;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInt(403);
        try {
            try {
                iBinderCgx_.transact(2, parcelObtain, parcelObtain2, 0);
                return parcelObtain2.readStrongBinder();
            } catch (RemoteException e) {
                Log.e("ConnectUtils", "get system ability occurs exception" + e.getMessage());
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return null;
            }
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    private static IBinder cgx_(String str) {
        try {
            Object objInvoke = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, str);
            if (objInvoke instanceof IBinder) {
                return (IBinder) objInvoke;
            }
            return null;
        } catch (ReflectiveOperationException e) {
            Log.e("ConnectUtils", "getService exception" + e.getMessage());
            return null;
        }
    }
}
