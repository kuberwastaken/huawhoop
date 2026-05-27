package com.huawei.openalliance.ad.views;

import android.content.Context;
import com.huawei.health.R;
import com.huawei.openalliance.ad.utils.Cdo;

/* JADX INFO: loaded from: classes11.dex */
public class LandingAppDownloadButtonStyle extends AppDownloadButtonStyle {
    public LandingAppDownloadButtonStyle(Context context) {
        super(context);
        this.normalStyle.setBackground(context.getResources().getDrawable(R.drawable._2131428733_res_0x7f0b057d));
        this.normalStyle.setTextColor(context.getResources().getColor(R.color._2131298034_res_0x7f0906f2));
        this.processingStyle.setBackground(Cdo.b(context, R.drawable._2131428664_res_0x7f0b0538));
        this.processingStyle.setTextColor(context.getResources().getColor(R.color._2131297991_res_0x7f0906c7));
    }
}
