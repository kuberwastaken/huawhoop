package com.huawei.agconnect.remoteconfig.internal.server;

import com.huawei.agconnect.https.annotation.Result;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteConfigResponse {

    @Result("experiments")
    private List<Map<String, String>> experiments;

    @Result("configItems")
    private List<Parameter> parameters;

    @Result("ret")
    private ConnectRet ret;

    @Result("tag")
    private String tag;

    public void setTag(String str) {
        this.tag = str;
    }

    public void setRet(ConnectRet connectRet) {
        this.ret = connectRet;
    }

    public void setParameters(List<Parameter> list) {
        this.parameters = list;
    }

    public void setExperiments(List<Map<String, String>> list) {
        this.experiments = list;
    }

    public boolean isSuccess() {
        ConnectRet connectRet = this.ret;
        return connectRet != null && connectRet.getCode() == 0;
    }

    public String getTag() {
        return this.tag;
    }

    public ConnectRet getRet() {
        return this.ret;
    }

    public List<Parameter> getParameters() {
        return this.parameters;
    }

    public List<Map<String, String>> getExperiments() {
        return this.experiments;
    }
}
