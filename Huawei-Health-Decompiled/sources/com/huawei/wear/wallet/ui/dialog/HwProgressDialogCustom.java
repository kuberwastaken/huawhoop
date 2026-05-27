package com.huawei.wear.wallet.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.health.R;
import defpackage.woh;
import defpackage.wol;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes11.dex */
public class HwProgressDialogCustom extends Dialog implements HwProgressDialogInterface, ConfigChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11741a;
    private boolean b;
    private int c;
    private LinearLayout d;
    private boolean e;
    private Drawable f;
    private boolean g;
    private int h;
    private int i;
    private Context j;
    private int k;
    private ProgressBar l;
    private LayoutInflater m;
    private CharSequence n;
    private TextView o;
    private NumberFormat p;
    private int q;
    private int r;
    private Drawable s;
    private String t;
    private Handler u;
    private int x;
    private LinearLayout y;

    public HwProgressDialogCustom(Context context) {
        super(context);
        this.b = false;
        this.e = false;
        this.r = 0;
        this.j = context;
        b();
    }

    public HwProgressDialogCustom(Context context, int i) {
        super(context, i);
        this.b = false;
        this.e = false;
        this.r = 0;
        this.j = context;
        b();
    }

    private void b() {
        Log.i("HwProgressDialog", "init: ");
        this.m = (LayoutInflater) this.j.getSystemService("layout_inflater");
        requestWindowFeature(1);
        d();
        c();
    }

    private void d() {
        try {
            setContentView(R.layout.oversea_custom_dialog_layout);
            this.y = (LinearLayout) findViewById(R.id.dialog_layout);
            this.d = (LinearLayout) findViewById(R.id.content);
        } catch (RuntimeException unused) {
            Log.e("HwProgressDialog", "initView NumberFormatException");
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.ConfigChangeListener
    public void onConfigurationChanged(Configuration configuration) {
        if (this.c == configuration.screenWidthDp && this.f11741a == configuration.screenHeightDp) {
            return;
        }
        this.c = configuration.screenWidthDp;
        this.f11741a = configuration.screenHeightDp;
        woh.fzD_(this, getContext().getResources().getDimensionPixelSize(R.dimen._2131362027_res_0x7f0a00eb), 0.98d);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("HwProgressDialog", "onCreate ");
        e();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.g = true;
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.g = false;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        woh.fzD_(this, getContext().getResources().getDimensionPixelSize(R.dimen._2131362027_res_0x7f0a00eb), 0.98d);
    }

    private void e() {
        View viewInflate = this.m.inflate(R.layout.oversea_custom_progress_dlg, (ViewGroup) null);
        this.l = (ProgressBar) viewInflate.findViewById(R.id.progress);
        this.o = (TextView) viewInflate.findViewById(R.id.message);
        setView(viewInflate);
        wol.e(this, this.k, this.q, this.x, this.h);
        wol.fzL_(this, this.i, this.s, this.f, this.n);
        wol.fzK_(this.r, this.u);
    }

    private void c() {
        this.t = "%1d/%2d";
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        this.p = percentInstance;
        percentInstance.setMaximumFractionDigits(0);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        setTitle(this.j.getResources().getString(i));
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setMessage(CharSequence charSequence) {
        if (this.l != null) {
            wol.fzG_(this.o, charSequence);
        } else {
            this.n = charSequence;
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setProgressStyle(int i) {
        Log.i("HwProgressDialog", "setProgressStyle ");
        this.r = i;
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setProgressNumberFormat(String str) {
        Log.i("HwProgressDialog", "setProgressNumberFormat ");
        this.t = str;
        wol.fzK_(this.r, this.u);
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setProgressPercentFormat(NumberFormat numberFormat) {
        this.p = numberFormat;
        wol.fzK_(this.r, this.u);
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public int getProgress() {
        return wol.fzI_(this.l, this.q);
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setProgress(int i) {
        if (this.g) {
            Log.i("HwProgressDialog", "setProgress ");
            this.l.setProgress(i);
            wol.fzK_(this.r, this.u);
            return;
        }
        this.q = i;
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public int getSecondaryProgress() {
        return wol.fzJ_(this.l, this.x);
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setSecondaryProgress(int i) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.setSecondaryProgress(i);
            wol.fzK_(this.r, this.u);
        } else {
            this.x = i;
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public int getMax() {
        return wol.fzH_(this.l, this.k);
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setMax(int i) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.setMax(i);
            wol.fzK_(this.r, this.u);
        } else {
            this.k = i;
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void incrementProgressBy(int i) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.incrementProgressBy(i);
            wol.fzK_(this.r, this.u);
        } else {
            this.h += i;
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void incrementSecondaryProgressBy(int i) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.incrementSecondaryProgressBy(i);
            wol.fzK_(this.r, this.u);
        } else {
            this.i += i;
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setProgressDrawable(Drawable drawable) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.setProgressDrawable(drawable);
        } else {
            this.s = drawable;
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setIndeterminateDrawable(Drawable drawable) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(drawable);
        } else {
            this.f = drawable;
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setView(View view) {
        wol.fzM_(this.y, this.d, view);
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
            Log.e("HwProgressDialog", "dismiss failed Exception");
        }
    }

    @Override // android.app.Dialog, com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void show() {
        try {
            super.show();
        } catch (Exception unused) {
            Log.e("HwProgressDialog", "showDialog failed Exception");
        }
    }

    @Override // android.app.Dialog, com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public Window getWindow() {
        return super.getWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback, com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public boolean onSearchRequested() {
        if (this.b) {
            return this.e;
        }
        return super.onSearchRequested();
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void cancel() {
        try {
            super.cancel();
        } catch (Exception unused) {
            Log.e("HwProgressDialog", "cancel failed Exception");
        }
    }

    @Override // com.huawei.wear.wallet.ui.dialog.HwProgressDialogInterface
    public void setSearchRequestedReturn(boolean z) {
        this.b = true;
        this.e = z;
    }
}
