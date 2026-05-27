package defpackage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class lq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15394a = "";
    public static String d = "";
    public static String e = "";

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void d(List<String> list) {
        synchronized (lq.class) {
            if (!kn.a(f15394a) && !kn.a(d)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(d);
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(", " + it.next());
                }
                stringBuffer.append("\n");
                try {
                    File file = new File(e);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(e, f15394a);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                    fileWriter.write(stringBuffer.toString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void d(Throwable th) {
        synchronized (lq.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(th));
            d(arrayList);
        }
    }

    public static void e(String str, String str2, String str3) {
        synchronized (lq.class) {
            e = str;
            f15394a = str2;
            d = str3;
        }
    }

    public static void d(String str) {
        synchronized (lq.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            d(arrayList);
        }
    }
}
