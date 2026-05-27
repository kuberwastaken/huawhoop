package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManager;
import defpackage.vpb;

/* JADX INFO: loaded from: classes11.dex */
public class HwDeviceAdapter {
    public HwDeviceAdapter() {
    }

    public static HwDeviceAdapter a(Context context) {
        Object objC = vpb.c(context, vpb.d(context, HwDeviceAdapter.class, vpb.e(context, 9, 1)), HwDeviceAdapter.class);
        if (objC instanceof HwDeviceAdapter) {
            return (HwDeviceAdapter) objC;
        }
        return null;
    }

    public HwLinearLayoutManager.LayoutCallback d(Context context) {
        return null;
    }

    public HwDeviceAdapter(Context context) {
    }
}
