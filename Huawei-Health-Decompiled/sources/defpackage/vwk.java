package defpackage;

import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes8.dex */
public class vwk {
    private static int e = 2;

    public static boolean d(int i) {
        return i >= e;
    }

    public static void b(String str, String str2) {
        if (d(4)) {
            vwf.e().b(new vwe(ExifInterface.LONGITUDE_EAST, str + Constants.LEFT_BRACKET_ONLY + Process.myTid() + Constants.RIGHT_BRACKET_ONLY, str2));
        }
    }
}
