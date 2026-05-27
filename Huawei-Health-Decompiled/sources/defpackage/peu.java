package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.huawei.health.R;
import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes7.dex */
public class peu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f16662a;
    private boolean b = true;
    private final View c;
    private final WindowManager d;
    private WindowManager.LayoutParams e;

    public peu(Activity activity, int i) {
        this.f16662a = activity;
        this.d = (WindowManager) activity.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        this.c = LayoutInflater.from(activity).inflate(i, (ViewGroup) null);
        a();
    }

    private void a() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 1000, 8, -3);
        this.e = layoutParams;
        layoutParams.gravity = 8388691;
        this.e.x = (int) this.f16662a.getResources().getDimension(R.dimen._2131362576_res_0x7f0a0310);
        this.e.y = (int) this.f16662a.getResources().getDimension(R.dimen._2131362910_res_0x7f0a045e);
        this.e.token = this.f16662a.getWindow().getDecorView().getWindowToken();
    }

    public void a(int i, int i2, int i3) {
        this.e.gravity = i;
        this.e.x = i2;
        this.e.y = i3;
    }

    public WindowManager.LayoutParams cKD_() {
        return this.e;
    }

    public View cKC_() {
        return this.c;
    }
}
