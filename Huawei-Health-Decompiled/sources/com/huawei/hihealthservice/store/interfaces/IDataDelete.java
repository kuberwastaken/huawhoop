package com.huawei.hihealthservice.store.interfaces;

import com.huawei.hihealth.HiDataDeleteOption;
import com.huawei.hwcloudmodel.model.unite.DataTimeDelCondition;
import defpackage.jwv;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface IDataDelete {
    List<DataTimeDelCondition> deleteHealthData(HiDataDeleteOption hiDataDeleteOption, jwv jwvVar, int i);
}
