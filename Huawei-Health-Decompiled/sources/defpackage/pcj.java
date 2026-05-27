package defpackage;

import com.huawei.ucd.helper.android.Medal3DLogApi;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes11.dex */
public class pcj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f16619a = true;
    private static WeakReference<Medal3DLogApi> e;

    public static void b(String str, String str2) {
        WeakReference<Medal3DLogApi> weakReference = e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        e.get().medalLogShow("Medal3D_" + str, str2);
    }

    public static void b(WeakReference<Medal3DLogApi> weakReference) {
        e = weakReference;
    }

    public static String a() {
        if (!f16619a) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(Thread.currentThread().getName());
            stringBuffer.append("-> ");
            stringBuffer.append(Thread.currentThread().getStackTrace()[3].getMethodName());
            stringBuffer.append("()");
            stringBuffer.append(" ");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
