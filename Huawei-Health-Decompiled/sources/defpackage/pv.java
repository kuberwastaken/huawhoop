package defpackage;

import android.os.Process;
import androidx.core.internal.view.SupportMenu;
import defpackage.pw;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes3.dex */
public class pv {
    private static Hashtable<String, int[]> b = new Hashtable<>();
    private static short e;

    public static void c(String str) {
        synchronized (pv.class) {
            if (str == null) {
                pw.d.c("SenderIdManager", "registerSender, param == null");
            } else {
                b.remove(str);
            }
        }
    }

    public static void d(String str) {
        synchronized (pv.class) {
            if (str == null) {
                pw.d.c("SenderIdManager", "registerSender, param == null");
                return;
            }
            pw.d.a("SenderIdManager", "registerSender groupId:" + ((int) e));
            short s = (short) (e + 1);
            e = s;
            short sAbs = (short) (Math.abs((int) s) % 32767);
            e = sAbs;
            int[] iArr = {Process.myPid(), sAbs << 16};
            pw.d.a("SenderIdManager", "registerSender, tidAndTime:" + str + " senderId:" + iArr[0] + "," + iArr[1]);
            b.put(str, iArr);
        }
    }

    public static int[] a(String str) {
        synchronized (pv.class) {
            if (str == null) {
                pw.d.c("SenderIdManager", "getSenderId, param == null");
                return null;
            }
            int[] iArr = b.get(str);
            if (iArr == null || 2 != iArr.length) {
                pw.d.c("SenderIdManager", "getSenderId, param: " + str + " fail!");
                return null;
            }
            iArr[1] = ((short) (Math.abs((int) ((short) (((short) (iArr[1] & 65535)) + 1))) % 32767)) | (iArr[1] & SupportMenu.CATEGORY_MASK);
            pw.d.a("SenderIdManager", "getSenderId, tidAndTime:" + str + " pid:" + iArr[0] + ", gid:" + (iArr[1] & SupportMenu.CATEGORY_MASK) + ", seq:" + (iArr[1] & 65535));
            return iArr;
        }
    }
}
