package com.huawei.health.sportservice.datasource;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseSource<T> {
    public void destroy() {
    }

    protected abstract void generateData(T t);

    protected abstract String getLogTag();

    public void recoveryData() {
    }

    protected abstract void updateSourceData();
}
