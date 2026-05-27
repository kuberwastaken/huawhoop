package com.huawei.hwdevice.phoneprocess.mgr.hwcontactsyncmgr.contacts.sync.utils;

import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class SyncHelper {

    public enum Encode {
        NORMAL,
        ENCODE
    }

    public enum Transferred {
        NORMAL,
        TRANSFERRED
    }

    public static String d() {
        String string = UUID.randomUUID().toString();
        if (string.length() <= 24) {
            return "";
        }
        return string.substring(0, 8) + string.substring(9, 13) + string.substring(14, 18) + string.substring(19, 23) + string.substring(24);
    }
}
