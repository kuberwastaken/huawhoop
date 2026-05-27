package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class gbf {
    public static List<String> c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.contains("/")) {
                int iLastIndexOf = str.lastIndexOf("/");
                if (iLastIndexOf == -1) {
                    return arrayList;
                }
                arrayList.add(str.substring(0, iLastIndexOf));
            }
        }
        return arrayList;
    }

    public static List<String> a(List<String> list) {
        String strSubstring;
        int iLastIndexOf;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.contains("/")) {
                int iLastIndexOf2 = str.lastIndexOf("/");
                if (iLastIndexOf2 == -1 || (iLastIndexOf = (strSubstring = str.substring(0, iLastIndexOf2)).lastIndexOf("/")) == -1) {
                    return arrayList;
                }
                String strSubstring2 = strSubstring.substring(0, iLastIndexOf);
                int i = iLastIndexOf + 1;
                String strSubstring3 = i <= strSubstring.length() ? strSubstring.substring(i) : "";
                arrayList.add(strSubstring2);
                arrayList.add(strSubstring3);
            }
        }
        return arrayList;
    }
}
