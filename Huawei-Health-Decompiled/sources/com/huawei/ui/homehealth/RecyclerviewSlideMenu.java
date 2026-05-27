package com.huawei.ui.homehealth;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes7.dex */
public class RecyclerviewSlideMenu extends LinearLayout {
    private Context d;

    public RecyclerviewSlideMenu(Context context) {
        super(context);
        this.d = context;
        b();
    }

    private void b() {
        Object systemService = this.d.getSystemService("layout_inflater");
        if (systemService instanceof LayoutInflater) {
            ((LayoutInflater) systemService).inflate(R.layout.recyclerview_slide_menu_layout, this);
        }
    }
}
