package com.huawei.route;

/* JADX INFO: loaded from: classes7.dex */
public enum RouteType {
    DEFAULT(0),
    EXP(1),
    DRAW(2),
    XC(3);

    private final int mRouteType;

    RouteType(int i) {
        this.mRouteType = i;
    }

    public int routeType() {
        return this.mRouteType;
    }

    public static RouteType getRouteType(int i) {
        for (RouteType routeType : values()) {
            if (routeType.routeType() == i) {
                return routeType;
            }
        }
        return DEFAULT;
    }
}
