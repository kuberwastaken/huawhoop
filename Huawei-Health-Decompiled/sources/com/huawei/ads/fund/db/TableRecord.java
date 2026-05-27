package com.huawei.ads.fund.db;

import android.content.ContentValues;
import android.database.Cursor;

/* JADX INFO: loaded from: classes3.dex */
public interface TableRecord {
    void toBean(Cursor cursor);

    ContentValues toRecord();
}
