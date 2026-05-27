package ohos.ace.adapter.capability.web;

import com.huawei.hms.network.embedded.g4;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebDownloadHelperObject {
    private static final int MAX_INCREMENT_ID = 16777216;
    private static final int WEB_ERROR_UNKNOWN = 0;
    private static final int WEB_FILE_FAILED = 1;
    private static final int WEB_FILE_NO_SPACE = 3;
    private static final int WEB_FILE_SAME_AS_SOURCE = 15;
    private static final int WEB_FILE_TOO_SHORT = 13;
    private static final int WEB_FILE_TRANSIENT_ERROR = 10;
    private static final int WEB_NETWORK_DISCONNECTED = 22;
    private static final int WEB_NETWORK_FAILED = 20;
    private static final int WEB_SERVER_BAD_CONTENT = 33;
    private static final int WEB_SERVER_FAILED = 30;
    private static final int WEB_SERVER_FORBIDDEN = 36;
    private static int incrementId_;
    private static List<String> webDownloadFilePathList_ = new ArrayList();
    private static final Object WEB_TOOL_LOCK = new Object();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0027 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int convertsHttpErrorCode(int r2) {
        /*
            r0 = 1
            if (r2 == r0) goto L32
            r1 = 2
            if (r2 == r1) goto L2f
            r1 = 403(0x193, float:5.65E-43)
            if (r2 == r1) goto L2c
            r1 = 404(0x194, float:5.66E-43)
            if (r2 == r1) goto L29
            r1 = 500(0x1f4, float:7.0E-43)
            if (r2 == r1) goto L32
            switch(r2) {
                case 1000: goto L27;
                case 1001: goto L34;
                case 1002: goto L19;
                default: goto L15;
            }
        L15:
            switch(r2) {
                case 1006: goto L25;
                case 1007: goto L22;
                case 1008: goto L1f;
                case 1009: goto L1c;
                default: goto L18;
            }
        L18:
            goto L27
        L19:
            r0 = 20
            goto L34
        L1c:
            r0 = 15
            goto L34
        L1f:
            r0 = 13
            goto L34
        L22:
            r0 = 10
            goto L34
        L25:
            r0 = 3
            goto L34
        L27:
            r0 = 0
            goto L34
        L29:
            r0 = 33
            goto L34
        L2c:
            r0 = 36
            goto L34
        L2f:
            r0 = 22
            goto L34
        L32:
            r0 = 30
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ohos.ace.adapter.capability.web.AceWebDownloadHelperObject.convertsHttpErrorCode(int):int");
    }

    public static void removeFilePathFromList(String str) {
        synchronized (WEB_TOOL_LOCK) {
            webDownloadFilePathList_.remove(str);
        }
    }

    public static void addFilePathToList(String str) {
        synchronized (WEB_TOOL_LOCK) {
            webDownloadFilePathList_.add(str);
        }
    }

    public static final String createDownloadGuid() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = incrementId_ + 1;
        incrementId_ = i;
        if (i >= 16777216) {
            incrementId_ = 0;
        }
        return Long.toHexString(jCurrentTimeMillis) + Integer.toHexString(incrementId_ + 16777216);
    }

    public static final boolean isLegalPath(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile != null) {
            return (parentFile.exists() || (!parentFile.exists() && parentFile.mkdirs())) && parentFile.canWrite() && parentFile.canRead();
        }
        return false;
    }

    public static final String getNonDuplicatePath(String str) {
        String str2;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int i = 1;
        String str3 = str;
        while (true) {
            if (file.exists() || webDownloadFilePathList_.contains(str3)) {
                if (iLastIndexOf != -1) {
                    str2 = str.substring(0, iLastIndexOf) + g4.k + i + g4.l + str.substring(iLastIndexOf);
                } else {
                    str2 = str3 + g4.k + i + g4.l;
                }
                str3 = str2;
                file = new File(str3);
                i++;
            } else {
                addFilePathToList(str3);
                return str3;
            }
        }
    }
}
