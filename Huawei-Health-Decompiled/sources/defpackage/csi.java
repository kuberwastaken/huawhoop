package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import com.huawei.harmonyos.interwork.b;
import com.huawei.harmonyos.interwork.base.ability.IAbilityStartCallback;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes3.dex */
final class csi extends b.a {
    private static Handler c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAbilityStartCallback f12020a;
    private Context b;
    private Runnable d;
    private final Object e = new Object();

    public csi(Context context, IAbilityStartCallback iAbilityStartCallback) {
        if (context == null || iAbilityStartCallback == null) {
            throw new NullPointerException("No callback specified");
        }
        this.f12020a = iAbilityStartCallback;
        this.b = context;
    }

    public static void BK_(Handler handler) {
        c = handler;
    }

    public final void e() {
        if (c == null) {
            Log.e("DefKitLib_AbilityStartCallback", "startCallbackTimeoutDetection: sHandler is null");
            return;
        }
        Runnable runnable = new Runnable() { // from class: csh
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c();
            }
        };
        this.d = runnable;
        c.postDelayed(runnable, this.f12020a, 40000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        synchronized (this.e) {
            if (this.f12020a == null) {
                Log.e("DefKitLib_AbilityStartCallback", "startCallbackTimeoutDetection: mCallback may has released");
                return;
            }
            Log.e("DefKitLib_AbilityStartCallback", "start ability callback time out, callback: " + this.f12020a);
            this.f12020a.onStartResult(3);
            b();
        }
    }

    private void b() {
        synchronized (this.e) {
            if (this.f12020a != null) {
                Log.i("DefKitLib_AbilityStartCallback", "release callback: " + this.f12020a);
                this.f12020a = null;
            }
            if (this.b != null) {
                Log.i("DefKitLib_AbilityStartCallback", "release context: " + this.b);
                this.b = null;
            }
        }
    }

    @Override // com.huawei.harmonyos.interwork.b.a, android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (parcel == null || parcel2 == null) {
            Log.e("DefKitLib_AbilityStartCallback", "AbilityStartCallback: onTransact param invalid");
        }
        Log.d("DefKitLib_AbilityStartCallback", "AbilityStartCallback::onRemoteRequest code:".concat(String.valueOf(i)));
        if (i == 1) {
            parcel.enforceInterface("ohos.abilityshell.AbilityStartCallback");
            a(parcel.readInt());
            parcel2.writeInt(0);
            return true;
        }
        return super.onTransact(i, parcel, parcel2, i2);
    }

    @Override // com.huawei.harmonyos.interwork.b
    public final void a(final int i) throws RemoteException {
        Runnable runnable;
        Handler handler = c;
        if (handler != null && (runnable = this.d) != null) {
            handler.removeCallbacks(runnable, this.f12020a);
        }
        synchronized (this.e) {
            IAbilityStartCallback iAbilityStartCallback = this.f12020a;
            if (iAbilityStartCallback == null) {
                Log.e("DefKitLib_AbilityStartCallback", "OnResult called, mCallback may has released");
                return;
            }
            iAbilityStartCallback.onStartResult(i);
            if (i != 0) {
                Log.i("DefKitLib_AbilityStartCallback", "AbilityStartCallback::OnResult errorCode:".concat(String.valueOf(i)));
                c.post(new Runnable() { // from class: csk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.b.d(i);
                    }
                });
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i) {
        int i2;
        switch (i) {
            case 1:
                i2 = R.string._2130852719_res_0x7f023b6f;
                break;
            case 2:
                i2 = R.string._2130852718_res_0x7f023b6e;
                break;
            case 3:
                i2 = R.string._2130852720_res_0x7f023b70;
                break;
            case 4:
                i2 = R.string._2130852717_res_0x7f023b6d;
                break;
            case 5:
                i2 = R.string._2130852716_res_0x7f023b6c;
                break;
            case 6:
                i2 = R.string._2130852715_res_0x7f023b6b;
                break;
            case 7:
                i2 = R.string._2130852754_res_0x7f023b92;
                break;
            default:
                i2 = -1;
                break;
        }
        Log.i("DefKitLib_AbilityStartCallback", "getRestId restId:".concat(String.valueOf(i2)));
        Context context = this.b;
        if (context == null || i2 == -1) {
            return;
        }
        Toast.makeText(context, i2, 0).show();
    }
}
