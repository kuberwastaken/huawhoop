package defpackage;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.d0.f;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.network.embedded.c0;
import com.huawei.operation.utils.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ld {
    public static ld c = new ld();
    public f d;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r0 = r1[1].trim();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String v() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "/proc/cpuinfo"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L43
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f
            r4 = 8192(0x2000, float:1.148E-41)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L3f
        L11:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L3a
            boolean r4 = defpackage.kn.a(r1)     // Catch: java.lang.Throwable -> L3e
            if (r4 != 0) goto L11
            java.lang.String r4 = ":"
            java.lang.String[] r1 = r1.split(r4)     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L11
            int r4 = r1.length     // Catch: java.lang.Throwable -> L3e
            r5 = 1
            if (r4 <= r5) goto L11
            r4 = 0
            r4 = r1[r4]     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = "BogoMIPS"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> L3e
            if (r4 == 0) goto L11
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L3e
        L3a:
            r2.close()     // Catch: java.lang.Throwable -> L4c
            goto L4c
        L3e:
            r1 = r3
        L3f:
            r7 = r2
            r2 = r1
            r1 = r7
            goto L44
        L43:
            r2 = r1
        L44:
            if (r1 == 0) goto L49
            r1.close()     // Catch: java.lang.Throwable -> L49
        L49:
            if (r2 == 0) goto L4f
            r3 = r2
        L4c:
            r3.close()     // Catch: java.lang.Throwable -> L4f
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ld.v():java.lang.String");
    }

    public final String s() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                try {
                    String line = bufferedReader2.readLine();
                    if (!kn.a(line)) {
                        String strTrim = line.trim();
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                        return strTrim;
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused3) {
                    }
                } catch (Throwable unused4) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (fileReader == null) {
                        return "";
                    }
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            fileReader = null;
        }
        try {
            fileReader.close();
            return "";
        } catch (Throwable unused8) {
            return "";
        }
    }

    public String t() {
        StringBuilder sb = new StringBuilder("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put(SystemUtils.PRODUCT_BRAND, "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            String str2 = (String) linkedHashMap.get(str);
            String strE = kn.e(str, "");
            sb.append((strE == null || !strE.contains(str2)) ? '0' : '1');
        }
        return sb.toString();
    }

    public String q() {
        String str;
        String lowerCase;
        StringBuilder sb = new StringBuilder("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put(Constants.HOME_TAB_DEVICE, "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str2 : linkedHashMap.keySet()) {
            try {
                String str3 = (String) Build.class.getField(str2).get(null);
                str = (String) linkedHashMap.get(str2);
                lowerCase = str3 != null ? str3.toLowerCase() : null;
            } catch (Throwable unused) {
            }
            char c2 = (lowerCase == null || !lowerCase.contains(str)) ? '0' : '1';
            sb.append(c2);
        }
        return sb.toString();
    }

    public String s(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            Intent intentRegisterReceiver = Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(null, intentFilter, 2) : context.registerReceiver(null, intentFilter);
            int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("status", -1);
            boolean z = intExtra2 == 2 || intExtra2 == 5;
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "1" : "0");
            sb.append(":");
            sb.append(intExtra);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String p() {
        LineNumberReader lineNumberReader;
        StringBuilder sb = new StringBuilder("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        for (String str : linkedHashMap.keySet()) {
            char c2 = '0';
            try {
                lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String line = lineNumberReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c2 = '1';
                            break;
                        }
                    } catch (Throwable unused) {
                        sb.append('0');
                        if (lineNumberReader != null) {
                        }
                    }
                }
                sb.append(c2);
            } catch (Throwable unused2) {
                lineNumberReader = null;
            }
            try {
                lineNumberReader.close();
            } catch (Throwable unused3) {
            }
        }
        return sb.toString();
    }

    public String r(Context context) {
        long jLastModified;
        try {
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            long jMax = 0;
            for (int i = 0; i < 5; i++) {
                try {
                    jLastModified = new File(strArr[i]).lastModified();
                } catch (Throwable unused) {
                    jLastModified = -1;
                }
                jMax = Math.max(jLastModified, jMax);
            }
            return "1:" + jMax;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public String r() {
        StringBuilder sb = new StringBuilder("00:");
        try {
            Class.forName(new String[]{"dalvik.system.Taint"}[0]);
            sb.append("1");
        } catch (Throwable unused) {
            sb.append("0");
        }
        return sb.toString();
    }

    public String m(Context context) {
        String strE = lg.e(c0.h);
        if (strE != null) {
            return strE;
        }
        if (this.d.isBackgroundRunning()) {
            return "";
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && strE == null) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                            strE = inetAddressNextElement.getHostAddress().toString();
                            break;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        String str = strE != null ? strE : "";
        lg.d(c0.h, str);
        return str;
    }

    public String n() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append("00:");
            for (int i = 0; i < 7; i++) {
                sb.append(new File(strArr[i]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String k() {
        try {
            return SystemClock.elapsedRealtime() + "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public String o(Context context) {
        try {
            String strB = b(context);
            String strM = m(context);
            if (kn.b(strB) && kn.b(strM)) {
                return strB + ":" + m(context);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public String l() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            return "" + (jCurrentTimeMillis - (jCurrentTimeMillis % 1000));
        } catch (Throwable unused) {
            return "";
        }
    }

    public String n(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public String m() {
        String displayName;
        try {
            displayName = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            displayName = "";
        }
        return displayName == null ? "" : displayName;
    }

    public String l(Context context) {
        synchronized (this) {
            String androidId = this.d.getAndroidId();
            if (androidId != null) {
                return androidId;
            }
            String strE = lg.e("ANDROIDID");
            if (strE != null) {
                return strE;
            }
            if (this.d.isBackgroundRunning()) {
                return "";
            }
            try {
                strE = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable unused) {
            }
            if (strE == null) {
                strE = "";
            }
            lg.d("ANDROIDID", strE);
            return strE;
        }
    }

    public String o() {
        String string;
        try {
            string = Locale.getDefault().toString();
        } catch (Throwable unused) {
            string = "";
        }
        return string == null ? "" : string;
    }

    public String k(Context context) {
        synchronized (this) {
            String strE = lg.e("SimSerial");
            if (strE != null) {
                return strE;
            }
            if (!this.d.isBackgroundRunning() && !b(context, "android.permission.READ_PHONE_STATE")) {
                lg.d("SimSerial", strE);
                return strE;
            }
            return "";
        }
    }

    public String h() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public String f(Context context) {
        try {
            return "" + context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            return "";
        }
    }

    public String g() {
        long blockSize;
        try {
            StatFs statFs = new StatFs("/sdcard");
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Throwable unused) {
            blockSize = 0;
        }
        return "" + blockSize;
    }

    public String h(Context context) {
        try {
            return "" + context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable unused) {
            return "";
        }
    }

    public String i() {
        long blockCount;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            blockCount = 0;
        }
        return "" + blockCount;
    }

    public String j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    public String j() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileReader fileReader = null;
        BufferedReader bufferedReader3 = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader2 = new BufferedReader(fileReader2, 8192);
                try {
                    j = bufferedReader2.readLine() != null ? Integer.parseInt(r2.split("\\s+")[1]) : 0L;
                    try {
                        fileReader2.close();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    bufferedReader3 = bufferedReader2;
                    bufferedReader = bufferedReader3;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader2 = bufferedReader;
                    }
                    return "" + j;
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        try {
            bufferedReader2.close();
        } catch (Throwable unused6) {
        }
        return "" + j;
    }

    public String i(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public String f() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileReader fileReader = null;
        BufferedReader bufferedReader3 = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader2 = new BufferedReader(fileReader2);
                try {
                    String[] strArrSplit = bufferedReader2.readLine().split(":\\s+", 2);
                    if (strArrSplit != null && strArrSplit.length > 1) {
                        String str = strArrSplit[1];
                        try {
                            fileReader2.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused2) {
                        }
                        return str;
                    }
                    try {
                        fileReader2.close();
                    } catch (Throwable unused3) {
                    }
                } catch (Throwable unused4) {
                    bufferedReader3 = bufferedReader2;
                    bufferedReader = bufferedReader3;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader2 = bufferedReader;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            bufferedReader = null;
        }
        try {
            bufferedReader2.close();
            return "";
        } catch (Throwable unused8) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String g(android.content.Context r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L4d
            java.lang.String r0 = "sensor"
            java.lang.Object r4 = r4.getSystemService(r0)     // Catch: java.lang.Throwable -> L4d
            android.hardware.SensorManager r4 = (android.hardware.SensorManager) r4     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L4d
            r0 = -1
            java.util.List r4 = r4.getSensorList(r0)     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L4d
            int r0 = r4.size()     // Catch: java.lang.Throwable -> L4d
            if (r0 <= 0) goto L4d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L4d
        L22:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L44
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L4d
            android.hardware.Sensor r1 = (android.hardware.Sensor) r1     // Catch: java.lang.Throwable -> L4d
            java.lang.String r2 = r1.getName()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            int r2 = r1.getVersion()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = r1.getVendor()     // Catch: java.lang.Throwable -> L4d
            r0.append(r1)     // Catch: java.lang.Throwable -> L4d
            goto L22
        L44:
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r4 = defpackage.kn.e(r4)     // Catch: java.lang.Throwable -> L4d
            goto L4e
        L4d:
            r4 = 0
        L4e:
            if (r4 != 0) goto L52
            java.lang.String r4 = ""
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ld.g(android.content.Context):java.lang.String");
    }

    public String a() {
        String strS = s();
        return !kn.a(strS) ? strS : v();
    }

    public String a(Context context) {
        synchronized (this) {
            String strE = lg.e("NetworkOperatorName");
            if (strE != null) {
                return strE;
            }
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        strE = telephonyManager.getNetworkOperatorName();
                    }
                } catch (Throwable unused) {
                }
            }
            if (strE == null || Constants.NULL.equals(strE)) {
                strE = "";
            }
            lg.d("NetworkOperatorName", strE);
            return strE;
        }
    }

    public String e() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new le(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    public String e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", "" + i);
            jSONObject.put(NotificationCompat.CATEGORY_CALL, "" + streamVolume);
            jSONObject.put("system", "" + streamVolume2);
            jSONObject.put("ring", "" + streamVolume3);
            jSONObject.put("music", "" + streamVolume4);
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, "" + streamVolume5);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        r0 = r6.substring(r6.indexOf(":") + 1, r6.length()).trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b() {
        /*
            r9 = this;
            java.lang.String r0 = "0000000000000000"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L50
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L50
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L50
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L50
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4e
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L52
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L52
            r1 = 1
            r5 = r1
        L1b:
            r6 = 100
            if (r5 >= r6) goto L47
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L47
            java.lang.String r7 = "Serial"
            int r7 = r6.indexOf(r7)     // Catch: java.lang.Throwable -> L45
            r8 = -1
            if (r7 <= r8) goto L42
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Throwable -> L45
            int r5 = r5 + r1
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L45
            java.lang.String r1 = r6.substring(r5, r1)     // Catch: java.lang.Throwable -> L45
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L45
            goto L47
        L42:
            int r5 = r5 + 1
            goto L1b
        L45:
            r1 = r4
            goto L52
        L47:
            r4.close()     // Catch: java.lang.Throwable -> L4a
        L4a:
            r3.close()     // Catch: java.lang.Throwable -> L5e
            goto L5e
        L4e:
            r3 = r1
            goto L52
        L50:
            r2 = r1
            r3 = r2
        L52:
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.lang.Throwable -> L57
        L57:
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.lang.Throwable -> L5c
        L5c:
            if (r2 == 0) goto L61
        L5e:
            r2.close()     // Catch: java.lang.Throwable -> L61
        L61:
            if (r0 != 0) goto L65
            java.lang.String r0 = ""
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ld.b():java.lang.String");
    }

    public String d(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 ? "1" : "0";
    }

    public String c() {
        long blockSize;
        try {
            StatFs statFs = new StatFs("/sdcard");
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable unused) {
            blockSize = 0;
        }
        return "" + blockSize;
    }

    public String c(Context context) {
        synchronized (this) {
            String subscriberId = this.d.getSubscriberId();
            if (subscriberId != null) {
                return subscriberId;
            }
            String strE = lg.e("imsi");
            if (strE != null) {
                return strE;
            }
            if (this.d.isBackgroundRunning() || b(context, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            if (strE == null) {
                strE = "";
            }
            lg.d("imsi", strE);
            return strE;
        }
    }

    public String d() {
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            availableBlocks = 0;
        }
        return "" + availableBlocks;
    }

    public static String b(Context context) {
        if (b(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return "WIFI";
                }
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean e(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean b(Context context, String str) {
        return !e(context, str);
    }

    public static ld b(f fVar) {
        ld ldVar = c;
        ldVar.d = fVar;
        return ldVar;
    }
}
