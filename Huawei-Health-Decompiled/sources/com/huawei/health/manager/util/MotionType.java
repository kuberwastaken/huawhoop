package com.huawei.health.manager.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MotionType {
    private static final Map<Integer, Integer> b;

    public static int c(int i) {
        switch (i) {
            case 20002:
                return 4;
            case 20003:
                return 3;
            case 20004:
                return 6;
            case 20005:
                return 2;
            default:
                return 0;
        }
    }

    public static int e(int i, int i2) {
        if (i == 2) {
            return 20005;
        }
        if (i == 3) {
            return 20003;
        }
        if (i == 4) {
            return 20002;
        }
        if (i != 6) {
            return i2;
        }
        return 20004;
    }

    static {
        HashMap map = new HashMap(16);
        b = map;
        map.put(2, 1);
        map.put(6, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(0, 6);
        map.put(1, 7);
    }

    private MotionType() {
    }

    public static int d(int i, int i2) {
        Map<Integer, Integer> map = b;
        Integer num = map.get(Integer.valueOf(i));
        Integer num2 = map.get(Integer.valueOf(i2));
        if (num != null) {
            return (num2 != null && num.intValue() > num2.intValue()) ? i2 : i;
        }
        if (num2 != null) {
            return i2;
        }
        return 0;
    }

    public static int d(int i) {
        return e(i, 20002);
    }
}
