package com.huawei.openalliance.ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.ad.hq;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class LandpageWebBlackList implements Serializable {
    private static final String ALLOW = "-1";
    private static final String REJECT = "-2";
    private static final String TAG = "LandpageWebBlackList";
    private static final long serialVersionUID = -1613710950822978060L;
    private String type = "-1";
    private Set<String> packageList = null;

    public boolean b(String str) {
        if (TextUtils.isEmpty(str) || "-1".equals(this.type)) {
            return false;
        }
        if ("-2".equals(this.type)) {
            return true;
        }
        Set<String> set = this.packageList;
        if (set == null) {
            return false;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public void a(String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if ("-2".equals(str)) {
                this.type = "-2";
                return;
            }
            if ("-1".equals(str)) {
                this.type = "-1";
                return;
            }
            if (this.packageList == null) {
                this.packageList = new HashSet();
            }
            this.packageList.clear();
            String[] strArrSplit = str.split(",");
            int length = strArrSplit.length;
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    if (!TextUtils.isEmpty(strArrSplit[i])) {
                        this.packageList.add(strArrSplit[i]);
                    }
                }
            }
            if (this.packageList.size() > 0) {
                this.type = null;
            }
        } catch (RuntimeException unused) {
            str2 = "fromString RuntimeException";
            hq.c(TAG, str2);
        } catch (Exception unused2) {
            str2 = "fromString Exception";
            hq.c(TAG, str2);
        }
    }
}
