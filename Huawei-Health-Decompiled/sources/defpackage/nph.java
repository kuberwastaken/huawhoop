package defpackage;

import android.text.TextUtils;
import com.huawei.pluginachievement.manager.model.AchieveInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class nph {
    private static boolean b(int i, int i2) {
        if (i > i2) {
            return true;
        }
        return i == i2 && i2 != 0;
    }

    public static int c(int i, int i2) {
        return (i2 != 0 && i2 <= 1) ? i + 1 : i2;
    }

    public static String c(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (b(a(str), a(str2))) {
            return str;
        }
        List<String> listD = d(str2.split(","));
        List<String> listD2 = d(str.split(","));
        return listD2.containsAll(listD) ? str : listD.containsAll(listD2) ? str2 : b(listD2, listD);
    }

    private static List<String> d(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        arrayList.addAll(Arrays.asList(strArr));
        return arrayList;
    }

    public static String b(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(16);
        StringBuilder sb2 = new StringBuilder(16);
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (list2.indexOf(str) != -1) {
                arrayList.add(str);
            }
            e(str, sb, sb2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            list2.remove((String) it.next());
        }
        arrayList.clear();
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            e(it2.next(), sb, sb2);
        }
        return b(sb, sb2);
    }

    private static String b(StringBuilder sb, StringBuilder sb2) {
        d(sb, sb2);
        return sb.toString();
    }

    private static StringBuilder d(StringBuilder sb, StringBuilder sb2) {
        if (sb2.length() == 0) {
            return sb;
        }
        if (sb.length() == 0) {
            sb.append((CharSequence) sb2);
            return sb;
        }
        sb.append("," + ((Object) sb2));
        return sb;
    }

    private static void e(String str, StringBuilder sb, StringBuilder sb2) {
        if (str.contains("A")) {
            if (sb.length() > 0) {
                sb.append("," + str);
                return;
            }
            sb.append(str);
            return;
        }
        if (sb2.length() > 0) {
            sb2.append("," + str);
            return;
        }
        sb2.append(str);
    }

    private static int a(String str) {
        Iterator it = Arrays.asList(str.split(",")).iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((String) it.next()).contains("A")) {
                i++;
            }
        }
        return i;
    }

    public static int b(AchieveInfo achieveInfo) {
        return (achieveInfo == null || TextUtils.isEmpty(achieveInfo.getHuid()) || achieveInfo.acquireDataType() == -1 || achieveInfo.getUserLevel() == -1 || achieveInfo.getUserPoint() == -1 || achieveInfo.getSyncTimestamp() == -1) ? -1 : 0;
    }
}
