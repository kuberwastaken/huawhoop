package defpackage;

import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.harmonyos.interwork.a;
import com.huawei.harmonyos.interwork.base.ability.IAbilityConnection;
import com.huawei.harmonyos.interwork.base.bundle.ElementName;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class csd extends a.AbstractBinderC0067a {
    private static final Set<csd> c = new HashSet();
    private static Handler e;
    private final IAbilityConnection b;

    public static void BI_(Handler handler) {
        e = handler;
    }

    @Override // com.huawei.harmonyos.interwork.a.AbstractBinderC0067a, android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface("harmonyos.abilityshell.DistributedConnection");
            a(parcel.readInt() != 0 ? ElementName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder(), parcel.readInt());
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface("harmonyos.abilityshell.DistributedConnection");
            a(parcel.readInt() != 0 ? ElementName.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            return true;
        }
        if (i == 1598968902) {
            parcel2.writeString("harmonyos.abilityshell.DistributedConnection");
            return true;
        }
        return super.onTransact(i, parcel, parcel2, i2);
    }

    @Override // com.huawei.harmonyos.interwork.a
    public final void a(final ElementName elementName, final IBinder iBinder, final int i) throws RemoteException {
        Handler handler = e;
        if (handler == null) {
            Log.e("DefKitLib_Connection", "invalid handler when connect done.");
        } else {
            handler.post(new Runnable() { // from class: csg
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.BJ_(elementName, iBinder, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void BJ_(ElementName elementName, IBinder iBinder, int i) {
        this.b.onAbilityConnectDone(elementName, iBinder, i);
    }

    @Override // com.huawei.harmonyos.interwork.a
    public final void a(final ElementName elementName, final int i) throws RemoteException {
        Handler handler = e;
        if (handler == null) {
            Log.e("DefKitLib_Connection", "invalid handler when disconnect.");
        } else {
            handler.post(new Runnable() { // from class: csj
                @Override // java.lang.Runnable
                public final void run() {
                    this.e.c(elementName, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(ElementName elementName, int i) {
        this.b.onAbilityDisconnectDone(elementName, i);
    }
}
