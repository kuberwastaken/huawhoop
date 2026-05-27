package com.huawei.health.tradeservice.cloud;

import com.huawei.trade.datatype.FunctionAuthResult;

/* JADX INFO: loaded from: classes5.dex */
public class FunctionAuthRsp extends BaseRsp {
    private FunctionAuthResult functionAuthResult;

    public FunctionAuthResult getFunctionAuthResult() {
        return this.functionAuthResult;
    }

    public void setFunctionAuthResult(FunctionAuthResult functionAuthResult) {
        this.functionAuthResult = functionAuthResult;
    }
}
