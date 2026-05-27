package com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder;

import com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.FitDesign;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseMessage extends BaseData {
    public static final int DEFINITION_MESSAGE = 1;
    public static final int RECORD_DATA_MESSAGE = 0;
    protected FitDesign.d mHead = new FitDesign.d();
    public List<FitDesign.a> mFieldDefinitions = new ArrayList();

    @Override // com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.BaseData
    public int getSize() {
        return 0;
    }

    public void setFieldDefinitions(List<FitDesign.a> list) {
        this.mFieldDefinitions.addAll(list);
    }
}
