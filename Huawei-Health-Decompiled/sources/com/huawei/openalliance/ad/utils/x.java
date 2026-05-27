package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public final class x {
    public static int a(Context context) {
        if (context == null) {
            return -1;
        }
        Cursor cursorA = null;
        try {
            cursorA = ar.a(context, Uri.parse("content://com.huawei.hms.contentprovider/com.huawei.hms.ads.dc.shared/dc_shared"));
            if (cursorA != null && cursorA.moveToFirst()) {
                hq.b("ProviderUtil", "cursor is valid");
                return cursorA.getInt(cursorA.getColumnIndexOrThrow("result"));
            }
        } finally {
            try {
            } finally {
            }
        }
        return -1;
    }
}
