package com.huawei.openalliance.ad;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes6.dex */
public abstract class hu {
    public static String a(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : ExifInterface.LONGITUDE_EAST : "W" : "I" : "D";
    }
}
