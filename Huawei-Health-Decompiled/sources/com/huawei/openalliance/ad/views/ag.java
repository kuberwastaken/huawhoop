package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes11.dex */
public class ag extends AutoScaleSizeRelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f8313a;

    public ImageView getCloseBtn() {
        return this.f8313a;
    }

    private void a(Context context) {
        ((RelativeLayout) LayoutInflater.from(context).inflate(R.layout.hiad_splash_icon_close_view, this)).setBackgroundColor(0);
        this.f8313a = (ImageView) findViewById(R.id.icon_close);
    }

    public ag(Context context) {
        super(context);
        a(context);
    }
}
