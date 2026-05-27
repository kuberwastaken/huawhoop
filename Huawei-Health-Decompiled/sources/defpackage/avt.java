package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.huawei.android.powerkit.PowerKitConnection;
import com.huawei.android.powerkit.Sink;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class avt {
    private static volatile avt b;
    private avs d;
    private Context e;

    private avt(Context context, PowerKitConnection powerKitConnection) {
        this.d = null;
        this.e = context;
        this.d = new avs(context, powerKitConnection);
    }

    public static avt a(Context context, PowerKitConnection powerKitConnection) {
        if (b == null) {
            synchronized (avt.class) {
                if (b == null) {
                    b = new avt(context, powerKitConnection);
                }
            }
        }
        return b;
    }

    public String d() throws RemoteException {
        return this.d.c(this.e);
    }

    public boolean d(String str, int i, long j, String str2) throws RemoteException {
        return this.d.b(this.e, true, str, i, j, str2);
    }

    public boolean e(String str, int i) throws RemoteException {
        return this.d.b(this.e, false, str, i, -1L, null);
    }

    public boolean e(String str, int i, String str2) throws RemoteException {
        return this.d.b(this.e, false, str, i, -1L, str2);
    }

    public boolean c(Sink sink, int i) throws RemoteException {
        return this.d.b(sink, i);
    }

    public boolean b(Sink sink, int i) throws RemoteException {
        return this.d.e(sink, i);
    }

    public boolean a() throws RemoteException {
        return this.d.a(this.e);
    }

    public boolean d(List<String> list) throws RemoteException {
        return this.d.e(this.e, list, true);
    }

    public boolean b(List<String> list) throws RemoteException {
        return this.d.e(this.e, list, false);
    }
}
