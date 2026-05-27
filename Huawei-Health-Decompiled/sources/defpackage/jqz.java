package defpackage;

import android.util.Log;
import com.huawei.hihealth.error.HiHealthError;
import com.huawei.hihealth.listener.ResultCallback;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class jqz {
    private static final Set<String> c;

    static {
        HashSet hashSet = new HashSet();
        c = hashSet;
        hashSet.add("Gender");
        hashSet.add("Birthday");
        hashSet.add("Height");
        hashSet.add("Weight");
    }

    public static boolean a(jpv jpvVar, ResultCallback resultCallback) {
        if ((jpvVar.getType() != 10002 && jpvVar.getType() != 10006) || jpvVar.getStartTime() == jpvVar.getEndTime()) {
            return true;
        }
        Log.w("DataValidateUtil", "startTime is not equal to endTime");
        resultCallback.onResultHandler(2, HiHealthError.e(2));
        return false;
    }
}
