package com.huawei.ohos.localability;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public enum FormState {
    UNKNOWN(0),
    VISIBLE(1),
    INVISIBLE(2);

    private static final Map<Integer, FormState> b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6785a;

    public int getValue() {
        return this.f6785a;
    }

    public static FormState intToEnum(int i) {
        FormState formState = b.get(Integer.valueOf(i));
        return formState == null ? UNKNOWN : formState;
    }

    FormState(int i) {
        this.f6785a = i;
    }

    static {
        for (FormState formState : values()) {
            b.put(Integer.valueOf(formState.getValue()), formState);
        }
    }
}
