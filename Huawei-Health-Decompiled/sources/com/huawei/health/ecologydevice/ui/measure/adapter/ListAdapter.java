package com.huawei.health.ecologydevice.ui.measure.adapter;

import android.widget.BaseAdapter;
import defpackage.dgk;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ListAdapter extends BaseAdapter {
    private ArrayList<dgk> mProductList = null;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setProductList(ArrayList<dgk> arrayList) {
        this.mProductList = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mProductList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<dgk> arrayList = this.mProductList;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.mProductList.get(i);
    }
}
