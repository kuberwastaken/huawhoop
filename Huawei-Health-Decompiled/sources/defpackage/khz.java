package defpackage;

import com.huawei.hihealth.HiHealthData;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class khz {
    public static long b(List<HiHealthData> list, HiHealthData hiHealthData) {
        long modifiedTime = 0;
        if (list != null) {
            for (HiHealthData hiHealthData2 : list) {
                if (hiHealthData2.getModifiedTime() >= modifiedTime) {
                    modifiedTime = hiHealthData2.getModifiedTime();
                }
            }
            modifiedTime++;
        }
        return (modifiedTime >= 1388509200000L || hiHealthData.getStartTime() >= System.currentTimeMillis()) ? modifiedTime : hiHealthData.getStartTime();
    }
}
