package com.huawei.featureuserprofile.todo.datatype;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TodoSwitchSync {

    @SerializedName("k")
    private List<String> keys;

    @SerializedName("v")
    private List<Integer> values;

    public List<String> getKeys() {
        return this.keys;
    }

    public void setKeys(List<String> list) {
        this.keys = list;
    }

    public List<Integer> getValues() {
        return this.values;
    }

    public void setValues(List<Integer> list) {
        this.values = list;
    }
}
