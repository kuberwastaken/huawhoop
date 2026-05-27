package com.huawei.agconnect.common.api;

/* JADX INFO: loaded from: classes3.dex */
public class CPUModelUtil {
    private static final String FILE_KEY = "Hardware";
    private static final String FILE_PATH = "/proc/cpuinfo";
    private static final String SPLIT_KEY = ":";
    private static final String TAG = "CPUModelUtil";

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        r0 = r3.split(":")[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        com.huawei.agconnect.common.api.Logger.e(com.huawei.agconnect.common.api.CPUModelUtil.TAG, "close cpuinfo io error :" + r3.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r4.close();
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCpuModel() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.common.api.CPUModelUtil.getCpuModel():java.lang.String");
    }
}
