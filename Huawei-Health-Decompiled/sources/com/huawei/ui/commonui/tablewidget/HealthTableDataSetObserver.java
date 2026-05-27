package com.huawei.ui.commonui.tablewidget;

/* JADX INFO: loaded from: classes7.dex */
interface HealthTableDataSetObserver {
    void notifyColumnChanged(int i);

    void notifyDataSetChanged();

    void notifyItemChanged(int i, int i2);

    void notifyLayoutChanged();

    void notifyRowChanged(int i);
}
