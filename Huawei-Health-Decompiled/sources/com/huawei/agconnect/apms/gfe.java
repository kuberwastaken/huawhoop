package com.huawei.agconnect.apms;

import android.text.TextUtils;
import com.squareup.okhttp.internal.Version;

/* JADX INFO: loaded from: classes10.dex */
public class gfe {
    public static final String abc;
    public int bcd;
    public int cde;

    static {
        String strUserAgent;
        try {
            strUserAgent = Version.userAgent();
        } catch (Throwable unused) {
            strUserAgent = "";
        }
        abc = strUserAgent;
    }

    public gfe() {
        if (!TextUtils.isEmpty(abc)) {
            abc();
        } else {
            this.bcd = 2;
            this.cde = 0;
        }
    }

    public final void abc() {
        try {
            String[] strArrSplit = abc.split("/")[1].split("\\.");
            if (strArrSplit.length > 2) {
                this.bcd = Integer.parseInt(strArrSplit[0]);
                this.cde = Integer.parseInt(strArrSplit[1]);
                Integer.parseInt(strArrSplit[2]);
            } else {
                this.bcd = 2;
                this.cde = 0;
            }
        } catch (Throwable unused) {
            this.bcd = 2;
            this.cde = 0;
        }
    }
}
