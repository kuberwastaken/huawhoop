package defpackage;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;

/* JADX INFO: loaded from: classes.dex */
public class bmh {
    public static Context c() {
        return BaseApplication.getContext();
    }

    public static String b() {
        return c().getResources().getConfiguration().locale.getLanguage();
    }
}
