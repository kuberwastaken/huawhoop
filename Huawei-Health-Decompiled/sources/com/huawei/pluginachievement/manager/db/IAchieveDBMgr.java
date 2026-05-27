package com.huawei.pluginachievement.manager.db;

import defpackage.nof;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IAchieveDBMgr {
    public static final String PARAM_HUID = "huid";
    public static final String PARAM_PAGE = "page";
    public static final String PARAM_PAGE_SIZE = "pageSize";
    public static final String PARAM_REPORT_NO = "reportNo";

    int delete(nof nofVar);

    long insert(nof nofVar);

    nof query(Map<String, String> map);

    List<nof> queryAll(Map<String, String> map);

    int update(nof nofVar);
}
