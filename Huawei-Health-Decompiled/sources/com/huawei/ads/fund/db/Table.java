package com.huawei.ads.fund.db;

/* JADX INFO: loaded from: classes3.dex */
public interface Table {
    String[] getExpireCleanWhereArgs();

    String getExpireCleanWhereClause();

    long getMaxStoreTime();

    String getTableName();

    String getTableScheme();
}
