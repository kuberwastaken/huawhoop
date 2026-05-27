package com.huawei.ohos.localability;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public enum ListenerType {
    VISIBLE(0),
    INVISIBLE(1);

    private static final Map<Integer, ListenerType> b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6786a;

    public int getValue() {
        return this.f6786a;
    }

    public static ListenerType intToEnum(int i) {
        ListenerType listenerType = b.get(Integer.valueOf(i));
        return listenerType == null ? VISIBLE : listenerType;
    }

    ListenerType(int i) {
        this.f6786a = i;
    }

    static {
        for (ListenerType listenerType : values()) {
            b.put(Integer.valueOf(listenerType.getValue()), listenerType);
        }
    }
}
