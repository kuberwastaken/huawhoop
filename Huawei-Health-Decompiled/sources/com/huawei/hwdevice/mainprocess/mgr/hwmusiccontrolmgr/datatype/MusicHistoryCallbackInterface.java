package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

import defpackage.kyj;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface MusicHistoryCallbackInterface {
    void getHistoryRecordsBusy(int i, String str, int i2);

    void onGetHistoryRecords(int i, String str, List<kyj> list);
}
