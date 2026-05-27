package com.huawei.hms.iapfull;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes5.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Toast f4890a;

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e1 f4891a = new e1();
    }

    public void a(Context context, int i) {
        Toast toastMakeText = Toast.makeText(context.getApplicationContext(), context.getResources().getString(i), 0);
        this.f4890a = toastMakeText;
        toastMakeText.show();
    }

    public void a(Context context, String str) {
        Toast toastMakeText = Toast.makeText(context.getApplicationContext(), str, 0);
        this.f4890a = toastMakeText;
        toastMakeText.show();
    }

    public static e1 a() {
        return b.f4891a;
    }

    private e1() {
    }
}
