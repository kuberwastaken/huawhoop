package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserManager;
import android.util.Log;
import com.huawei.android.powerkit.PowerKitConnection;
import com.huawei.android.powerkit.Sink;
import com.huawei.android.powerkit.adapter.IPowerKitApi;
import com.huawei.android.powerkit.adapter.IStateSink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class avs implements IBinder.DeathRecipient {
    private PowerKitConnection c;
    private Context d;
    private avs h;
    private final HashSet<Sink> i = new HashSet<>();
    private final ArrayList<Integer> e = new ArrayList<>();
    private final HashMap<Sink, ArrayList<Integer>> g = new HashMap<>();
    private final a j = new a();
    private final Object b = new Object();
    private IPowerKitApi f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceConnection f361a = new ServiceConnection() { // from class: avs.4
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.v("PowerKitApi", "Power kit service disconnected");
            avs.this.c.onServiceDisconnected();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (avs.this.b) {
                avs.this.f = IPowerKitApi.Stub.asInterface(iBinder);
                try {
                    avs.this.f.asBinder().linkToDeath(avs.this.h, 0);
                } catch (Exception unused) {
                    Log.w("PowerKitApi", "power kit linkToDeath failed ! calling pid: " + Binder.getCallingPid());
                }
            }
            Log.v("PowerKitApi", "Power kit service connected");
            avs.this.c.onServiceConnected();
        }
    };

    public avs(Context context, PowerKitConnection powerKitConnection) {
        this.d = null;
        this.h = null;
        this.c = null;
        this.h = this;
        this.c = powerKitConnection;
        this.d = context;
        e();
    }

    private boolean e() {
        boolean zBindService = false;
        if (!((UserManager) this.d.getSystemService("user")).isSystemUser()) {
            Log.v("PowerKitApi", "not owner, power kit service not support");
            return false;
        }
        try {
            zBindService = this.d.getApplicationContext().bindService(gP_(this.d, new Intent("com.huawei.android.powerkit.PowerKitService")), this.f361a, 1);
            Log.v("PowerKitApi", "bind power kit service, state: " + zBindService);
            return zBindService;
        } catch (Exception unused) {
            Log.w("PowerKitApi", "bind power kit service exception!");
            return zBindService;
        }
    }

    private Intent gP_(Context context, Intent intent) {
        context.getPackageManager().queryIntentServices(intent, 0);
        ComponentName componentName = new ComponentName("com.huawei.powergenie", "com.huawei.android.powerkit.PowerKitService");
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public String c(Context context) throws RemoteException {
        String powerKitVersion;
        synchronized (this.b) {
            IPowerKitApi iPowerKitApi = this.f;
            if (iPowerKitApi == null) {
                throw new RemoteException("PowerKit server is not found");
            }
            powerKitVersion = iPowerKitApi.getPowerKitVersion(context.getPackageName());
        }
        return powerKitVersion;
    }

    public boolean b(Context context, boolean z, String str, int i, long j, String str2) throws RemoteException {
        boolean zApplyForResourceUse;
        synchronized (this.b) {
            IPowerKitApi iPowerKitApi = this.f;
            if (iPowerKitApi == null) {
                throw new RemoteException("PowerKit server is not found");
            }
            zApplyForResourceUse = iPowerKitApi.applyForResourceUse(context.getPackageName(), z, str, i, j, str2);
        }
        return zApplyForResourceUse;
    }

    public boolean b(Sink sink, int i) throws RemoteException {
        synchronized (this.b) {
            IPowerKitApi iPowerKitApi = this.f;
            if (iPowerKitApi == null) {
                throw new RemoteException("PowerKit server is not found");
            }
            if (d(iPowerKitApi.getPowerKitVersion(this.d.getPackageName()), "10.0.0.305") && i == 51) {
                Log.i("PowerKitApi", "System PowerKit version is low, don't support application using baseline remaining");
                return false;
            }
            if (!c(sink)) {
                return false;
            }
            Log.i("PowerKitApi", "registerSink return true");
            ArrayList<Integer> arrayList = this.g.get(sink);
            if (arrayList == null) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                arrayList2.add(Integer.valueOf(i));
                this.g.put(sink, arrayList2);
            } else {
                arrayList.add(Integer.valueOf(i));
            }
            this.e.add(Integer.valueOf(i));
            return this.f.enableStateEvent(i);
        }
    }

    private boolean c(Sink sink) {
        if (sink == null) {
            Log.e("PowerKitApi", "registerSink a null sink fail.");
            return false;
        }
        if (!this.i.contains(sink)) {
            this.i.add(sink);
            if (this.i.size() == 1) {
                b();
            }
        }
        return true;
    }

    private void b() {
        try {
            this.f.registerSink(this.j);
        } catch (RemoteException unused) {
            Log.e("PowerKitApi", "register sink transport fail.");
        }
    }

    public boolean e(Sink sink, int i) throws RemoteException {
        boolean zDisableStateEvent;
        synchronized (this.b) {
            if (this.f == null) {
                throw new RemoteException("PowerKit server is not found");
            }
            ArrayList<Integer> arrayList = this.g.get(sink);
            if (arrayList != null) {
                arrayList.remove(Integer.valueOf(i));
                if (arrayList.size() == 0) {
                    this.g.remove(sink);
                    e(sink);
                }
            }
            this.e.remove(Integer.valueOf(i));
            Log.i("PowerKitApi", "Disable state event, stateType: " + i);
            zDisableStateEvent = this.f.disableStateEvent(i);
        }
        return zDisableStateEvent;
    }

    private void e(Sink sink) {
        this.i.remove(sink);
        if (this.i.size() == 0) {
            a();
        }
    }

    private void a() {
        try {
            this.f.unregisterSink(this.j);
        } catch (RemoteException unused) {
            Log.e("PowerKitApi", "unregister sink transport fail.");
        }
    }

    private boolean d(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i = 0; i < strArrSplit2.length; i++) {
            if (Integer.parseInt(strArrSplit[i]) > Integer.parseInt(strArrSplit2[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Context context) throws RemoteException {
        boolean zIsUserSleeping;
        synchronized (this.b) {
            if (this.f == null) {
                throw new RemoteException("PowerKit server is not found");
            }
            Log.i("PowerKitApi", "isUserSleeping ! pkg: " + context.getPackageName());
            zIsUserSleeping = this.f.isUserSleeping(context.getPackageName());
        }
        return zIsUserSleeping;
    }

    public boolean e(Context context, List<String> list, boolean z) throws RemoteException {
        boolean zApplyForAlarmExemption;
        synchronized (this.b) {
            if (this.f == null) {
                throw new RemoteException("PowerKit server is not found");
            }
            Log.i("PowerKitApi", "Caller: " + context.getPackageName() + " actions:" + list + " apply:" + z);
            zApplyForAlarmExemption = this.f.applyForAlarmExemption(context.getPackageName(), list, z);
        }
        return zApplyForAlarmExemption;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Log.e("PowerKitApi", "powerkit process binder was died and connecting ...");
        synchronized (this.b) {
            this.f = null;
        }
        int i = 5;
        while (i > 0) {
            i--;
            SystemClock.sleep(new Random().nextInt(2001) + 1000);
            if (e()) {
                return;
            }
        }
    }

    final class a extends IStateSink.Stub {
        private a() {
        }

        @Override // com.huawei.android.powerkit.adapter.IStateSink
        public void onStateChanged(int i, int i2, int i3, String str, int i4) {
            Log.i("PowerKitApi", "stateType:" + i + " eventType:" + i2 + " pid:" + i3 + " pkg:" + str + " uid:" + i4);
            synchronized (avs.this.b) {
                if (avs.this.i.isEmpty()) {
                    return;
                }
                for (Sink sink : avs.this.i) {
                    ArrayList arrayList = (ArrayList) avs.this.g.get(sink);
                    if (arrayList != null && arrayList.contains(Integer.valueOf(i))) {
                        sink.onStateChanged(i, i2, i3, str, i4);
                    }
                }
            }
        }

        @Override // com.huawei.android.powerkit.adapter.IStateSink
        public void onPowerOverUsing(String str, int i, long j, long j2, String str2) {
            Log.i("PowerKitApi", "onPowerOverUsing moudle:" + str + " resource:" + i + " duration:" + j + " time:" + j2 + " extend:" + str2);
            synchronized (avs.this.b) {
                if (avs.this.i.isEmpty()) {
                    return;
                }
                for (Sink sink : avs.this.i) {
                    ArrayList arrayList = (ArrayList) avs.this.g.get(sink);
                    if (arrayList != null && arrayList.contains(50)) {
                        sink.onPowerOverUsing(str, i, j, j2, str2);
                    }
                }
            }
        }

        @Override // com.huawei.android.powerkit.adapter.IStateSink
        public void onPowerBaseLineUsing(String str, String str2, long j, int i, String str3) {
            Log.i("PowerKitApi", "onPowerBaseLineUsing callingPkg:" + str + " appAndGroup:" + str2 + " usage duration:" + j + " usage Count:" + i + " extend:" + str3);
            synchronized (avs.this.b) {
                if (avs.this.i.isEmpty()) {
                    return;
                }
                for (Sink sink : avs.this.i) {
                    ArrayList arrayList = (ArrayList) avs.this.g.get(sink);
                    if (arrayList != null && arrayList.contains(51)) {
                        sink.onPowerBaseLineUsing(str, str2, j, i, str3);
                    }
                }
            }
        }
    }
}
