package com.huawei.agconnect.apms;

import android.text.TextUtils;
import com.huawei.agconnect.apms.log.AgentLog;
import com.huawei.agconnect.apms.log.AgentLogManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class q0 {
    public static final AgentLog abc = AgentLogManager.getAgentLog();

    public static int abc(int i, StringBuilder sb, String str, int i2, char c, int i3) {
        BufferedReader bufferedReader;
        String string = Integer.toString(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add("/system/bin/logcat");
        arrayList.add("-b");
        arrayList.add(str);
        arrayList.add("-d");
        arrayList.add("-v");
        arrayList.add("threadtime");
        arrayList.add("-t");
        arrayList.add(Integer.toString(i2));
        arrayList.add("--pid");
        arrayList.add(string);
        arrayList.add("*:" + c);
        Object[] array = arrayList.toArray(new String[0]);
        sb.append("--------- tail end of log ");
        sb.append(str);
        sb.append(" (");
        sb.append(TextUtils.join(" ", array));
        sb.append(")\n");
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[0]).command(arrayList).start().getInputStream(), "UTF-8"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null && i3 >= line.length()) {
                        i3 -= line.length();
                        sb.append(line);
                        sb.append("\n");
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        abc.warn("run logcat command failed." + th);
                        if (bufferedReader != null) {
                            break;
                        }
                        return i3;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                                abc.warn("close logcat failed.");
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            break;
        } catch (IOException unused2) {
        }
        return i3;
    }

    public static String abc(String str, int i) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                int i2 = 0;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String strTrim = line.trim();
                        if (!strTrim.isEmpty()) {
                            i2++;
                            if (i == 0 || i2 <= i) {
                                sb.append("  ");
                                sb.append(strTrim);
                                sb.append("\n");
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            abc.warn("get info from " + str + " failed. " + th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                    abc.warn("close file failed.");
                                }
                            }
                            throw th2;
                        }
                    }
                }
                bufferedReader.close();
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception unused2) {
            abc.warn("close file failed.");
        }
        return sb.toString();
    }
}
