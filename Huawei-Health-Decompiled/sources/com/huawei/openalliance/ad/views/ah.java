package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.huawei.health.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes11.dex */
public class ah extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CornerImageView f8314a;
    private CornerImageView b;

    public CornerImageView getSplash() {
        return this.f8314a;
    }

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<Context> f8315a;
        private WeakReference<CornerImageView> b;

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f8315a.get();
            CornerImageView cornerImageView = this.b.get();
            if (context == null || cornerImageView == null) {
                return;
            }
            cornerImageView.setRectCornerRadius((context.getResources().getDisplayMetrics().widthPixels / 64) * 6);
        }

        public a(Context context, CornerImageView cornerImageView) {
            this.f8315a = new WeakReference<>(context);
            this.b = new WeakReference<>(cornerImageView);
        }
    }

    public CornerImageView getIcon() {
        return this.b;
    }

    private void a(Context context) {
        ((RelativeLayout) LayoutInflater.from(context).inflate(R.layout.hiad_splash_icon_view, this)).setBackgroundColor(0);
        this.f8314a = (CornerImageView) findViewById(R.id.hiad_splash_snapshot);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        this.b = (CornerImageView) findViewById(R.id.hiad_splash_icon_view);
        this.f8314a.setRectCornerRadius((context.getResources().getDisplayMetrics().widthPixels / 64) * 8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.b.setLayoutParams(layoutParams);
        CornerImageView cornerImageView = this.b;
        cornerImageView.post(new a(context, cornerImageView));
    }

    public ah(Context context) {
        super(context);
        a(context);
    }
}
