package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes10.dex */
public class TrackShareBottomLayout extends RelativeLayout {
    public TrackShareBottomLayout(Context context) {
        super(context);
        b(context);
    }

    public TrackShareBottomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    private void b(Context context) {
        if (context == null) {
            return;
        }
        View.inflate(context, R.layout.track_share_bottom_layout, this);
    }
}
