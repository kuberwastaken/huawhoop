package com.huawei.health.sportservice.datasource;

import com.huawei.health.sportservice.inter.DataSourceCallback;

/* JADX INFO: loaded from: classes10.dex */
public class DataSource {
    protected DataSourceCallback mDataSourceCallback;

    public void destroy() {
    }

    public void init() {
    }

    public void registerDataCallback(DataSourceCallback dataSourceCallback) {
        this.mDataSourceCallback = dataSourceCallback;
    }
}
