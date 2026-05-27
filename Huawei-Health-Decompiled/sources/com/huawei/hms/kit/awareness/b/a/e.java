package com.huawei.hms.kit.awareness.b.a;

import android.location.Location;

/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f5016a = 6378.137d;
    private static final int b = 2;
    private static final double c = 50.0d;

    public static boolean a(Location location, Location location2) {
        return (location == null || location2 == null || a(location.getLongitude(), location.getLatitude(), location2.getLongitude(), location2.getLatitude()) > c) ? false : true;
    }

    public static double a(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(d4);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((radians - radians2) / 2.0d), 2.0d) + (Math.cos(radians) * Math.cos(radians2) * Math.pow(Math.sin((Math.toRadians(d) - Math.toRadians(d3)) / 2.0d), 2.0d)))) * 2.0d * f5016a;
    }

    private e() {
    }
}
