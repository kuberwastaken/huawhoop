package com.huawei.hianalytics;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hianalytics.core.log.LogAdapter;

/* JADX INFO: loaded from: classes5.dex */
public class z0 implements LogAdapter {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f122a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4111a = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f121a = "FormalHASDK";

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public void init(int i, String str) {
        if (this.f122a) {
            return;
        }
        this.f4111a = i;
        this.f122a = true;
        this.f121a = str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("======================================= ");
        sb.append(System.lineSeparator());
        sb.append(this.f121a + "_3.2.13.508");
        sb.append(System.lineSeparator());
        sb.append("=======================================");
        Log.i(str, sb.toString());
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public void println(int i, String str, String str2) {
        a(i, TextUtils.isEmpty(this.f121a) ? "FormalHASDK" : this.f121a, str + "==> " + str2);
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public boolean isLoggable(int i) {
        return this.f122a && i >= this.f4111a;
    }

    public final void a(int i, String str, String str2) {
        int length = str2.length();
        int i2 = 3000;
        int i3 = 0;
        for (int i4 = 0; i4 < (length / 3000) + 1; i4++) {
            if (length > i2) {
                String strSubstring = str2.substring(i3, i2);
                if (i == 3) {
                    Log.d(str, strSubstring);
                } else if (i == 5) {
                    Log.w(str, strSubstring);
                } else if (i != 6) {
                    Log.i(str, strSubstring);
                } else {
                    Log.e(str, strSubstring);
                }
                int i5 = i2;
                i2 += 3000;
                i3 = i5;
            } else if (i == 3) {
                Log.d(str, str2.substring(i3, length));
            } else if (i == 5) {
                Log.w(str, str2.substring(i3, length));
            } else if (i != 6) {
                Log.i(str, str2.substring(i3, length));
            } else {
                Log.e(str, str2.substring(i3, length));
            }
        }
    }
}
