package com.huawei.watchface.api;

import android.content.Context;
import com.huawei.watchface.ea;

/* JADX INFO: loaded from: classes8.dex */
public class PluginBase {
    private PluginBaseAdapter mAdapter;

    public void finish() {
    }

    public void init(Context context) {
    }

    public PluginBaseAdapter getAdapter() {
        return (PluginBaseAdapter) ea.a(this.mAdapter);
    }

    public void setAdapter(PluginBaseAdapter pluginBaseAdapter) {
        this.mAdapter = (PluginBaseAdapter) ea.a(pluginBaseAdapter);
    }
}
