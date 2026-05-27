package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class HMSPackageManager {
    private static HMSPackageManager o;
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final Object r = new Object();
    private static final Map<String, String> s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6329a;
    private final PackageManagerHelper b;
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private long l;
    private boolean m;
    private int n;

    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6330a;
        private String b;
        private String c;
        private String d;
        private String e;
        private Long f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j) {
            this.f6330a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = Long.valueOf(j);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            return TextUtils.equals(this.e, packagePriorityInfo.e) ? this.f.compareTo(packagePriorityInfo.f) : this.e.compareTo(packagePriorityInfo.e);
        }
    }

    class a implements Comparator<ResolveInfo> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (HMSPackageManager.s.containsKey(str) && HMSPackageManager.s.containsKey(str2)) {
                return str.compareTo(str2);
            }
            if (HMSPackageManager.s.containsKey(str)) {
                return -1;
            }
            return HMSPackageManager.s.containsKey(str2) ? 1 : 0;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> listQueryIntentServices = HMSPackageManager.this.f6329a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                    HMSLog.w("HMSPackageManager", "resolveInfoList is empty.");
                    return;
                }
                Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
                while (it.hasNext()) {
                    if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                        HMSPackageManager.this.d();
                    }
                }
                HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            } catch (Exception e) {
                HMSLog.e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e.getMessage());
            }
        }
    }

    static {
        HashMap map = new HashMap();
        s = map;
        map.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        map.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f6329a = context;
        this.b = new PackageManagerHelper(context);
    }

    private boolean c(String str, String str2) {
        return Objects.equals(str2, this.b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.b.getPackageSignature(str));
    }

    private Pair<String, String> d(String str, String str2) {
        if (!s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.n = 3;
        return new Pair<>(str, str2);
    }

    private void e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f6329a, str) || Build.VERSION.SDK_INT < 28 || b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    private void f() {
        synchronized (q) {
            this.c = null;
            this.d = null;
            this.e = 0;
        }
    }

    private String g() {
        String str;
        HMSLog.i("HMSPackageManager", "Enter getAvailableHMSPackageNameForMultiService.");
        String str2 = this.f;
        if (str2 != null) {
            c(str2);
            if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(this.f)) && (str = this.f) != null) {
                return str;
            }
        }
        HMSLog.i("HMSPackageManager", " return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (p) {
            if (o == null && context != null) {
                if (context.getApplicationContext() != null) {
                    o = new HMSPackageManager(context.getApplicationContext());
                } else {
                    o = new HMSPackageManager(context);
                }
                o.l();
                o.b();
            }
        }
        return o;
    }

    private Pair<String, String> h() {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f6329a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                HMSLog.e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
                return null;
            }
            a(listQueryIntentServices);
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                String packageSigningCertificate = this.b.getPackageSigningCertificate(str);
                String packageSignature = this.b.getPackageSignature(str);
                Pair<String, String> pairD = d(str, packageSigningCertificate);
                if (pairD != null) {
                    HMSLog.i("HMSPackageManager", "signature V3 check success");
                    return pairD;
                }
                Pair<String, String> pairA = a(resolveInfo.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                if (pairA != null) {
                    HMSLog.i("HMSPackageManager", "DSS signature check success");
                    return pairA;
                }
                Pair<String, String> pairA2 = a(str, packageSignature);
                if (pairA2 != null) {
                    HMSLog.i("HMSPackageManager", "signature V2 check success");
                    return pairA2;
                }
            }
            return null;
        } catch (Exception e) {
            HMSLog.e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e.getMessage());
            return null;
        }
    }

    private Pair<String, String> i() {
        Pair<String, String> pairH = h();
        if (pairH != null) {
            HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) pairH.first));
            this.h = "com.huawei.hms.core.aidlservice";
            this.i = null;
            return pairH;
        }
        ArrayList<PackagePriorityInfo> arrayListJ = j();
        if (arrayListJ == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        for (PackagePriorityInfo packagePriorityInfo : arrayListJ) {
            String str = packagePriorityInfo.f6330a;
            String str2 = packagePriorityInfo.b;
            String str3 = packagePriorityInfo.c;
            String str4 = packagePriorityInfo.d;
            String packageSignature = this.b.getPackageSignature(str);
            if (a(str + "&" + packageSignature + "&" + str2, str3, str4)) {
                HMSLog.i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + packagePriorityInfo.f);
                this.h = PackageConstants.GENERAL_SERVICES_ACTION;
                d(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    private ArrayList<PackagePriorityInfo> j() {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f6329a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                HMSLog.e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
                return null;
            }
            ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.b.getPackageFirstInstallTime(str);
                Bundle bundle = resolveInfo.serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                } else {
                    String strA = a(bundle, "hms_app_checker_config");
                    String strA2 = a(strA);
                    if (TextUtils.isEmpty(strA2)) {
                        HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + strA);
                    } else {
                        String strA3 = a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(strA3)) {
                            HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String strA4 = a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(strA4)) {
                                HMSLog.i("HMSPackageManager", "get certChain fail.");
                            } else {
                                HMSLog.i("HMSPackageManager", "add: " + str + ", " + strA + ", " + packageFirstInstallTime);
                                arrayList.add(new PackagePriorityInfo(str, strA, strA3, strA4, strA2, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception e) {
            HMSLog.e("HMSPackageManager", "query aglite action failed. " + e.getMessage());
            return null;
        }
    }

    private void k() {
        synchronized (q) {
            Pair<String, String> pairH = h();
            if (pairH == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                f();
                return;
            }
            String str = (String) pairH.first;
            this.c = str;
            this.d = (String) pairH.second;
            this.e = this.b.getPackageVersionCode(str);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.c + " version: " + this.e);
        }
    }

    private void l() {
        synchronized (q) {
            Pair<String, String> pairI = i();
            if (pairI == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                e();
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                return;
            }
            this.f = (String) pairI.first;
            this.g = (String) pairI.second;
            this.j = this.b.getPackageVersionCode(g());
            e(this.f);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f + " version: " + this.j);
        }
    }

    private boolean m() {
        Bundle bundle;
        PackageManager packageManager = this.f6329a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (AndroidException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e);
        }
        if (!TextUtils.isEmpty(this.h) && (this.h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            HMSLog.i("HMSPackageManager", "action = " + this.h + " exist");
            return false;
        }
        ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public String getHMSFingerprint() {
        String str = this.d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                k();
            }
            String str2 = this.c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                l();
            }
            String str2 = this.f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (p) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                f();
                return packageStates2;
            }
            if ("com.huawei.hwid".equals(this.c) && d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            return (packageStates != PackageManagerHelper.PackageStates.ENABLED || c(this.c, this.d)) ? packageStates : packageStates2;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (p) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                e();
                return packageStates2;
            }
            if ("com.huawei.hwid".equals(this.f) && d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            return (packageStates != PackageManagerHelper.PackageStates.ENABLED || c(this.f, this.g)) ? packageStates : packageStates2;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.b.getPackageVersionCode(getHMSPackageName());
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.h) ? this.h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i) {
        if (this.e < i && m()) {
            int packageVersionCode = this.b.getPackageVersionCode(getHMSPackageName());
            this.e = packageVersionCode;
            if (packageVersionCode < i) {
                return false;
            }
        }
        return true;
    }

    public boolean isApkNeedUpdate(int i) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i);
        return hmsVersionCode < i;
    }

    public boolean isApkUpdateNecessary(int i) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i);
        return m() && hmsVersionCode < i;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            k();
        }
        c(this.c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
            l();
        }
        c(this.f);
    }

    public void resetMultiServiceState() {
        e();
    }

    public void setUseOldCertificate(boolean z) {
        this.m = z;
    }

    private boolean b(String str) {
        return !"com.huawei.hwid".equals(str) || this.n == 3;
    }

    private void a(List<ResolveInfo> list) {
        if (list.size() <= 1) {
            return;
        }
        Collections.sort(list, new a());
    }

    private boolean b(String str, String str2) {
        Map<String, String> map = s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    private void c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    private void b() {
        new Thread(new b(), "Thread-asyncOnceCheckMDMState").start();
    }

    private void d(String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.i = strA.substring(9);
    }

    private void e() {
        synchronized (q) {
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = 0;
        }
    }

    private Pair<String, String> a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.n = 2;
        if (a(bundle, str, str2)) {
            HMSLog.i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        }
        if (!bundle.containsKey("hms_app_cert_chain")) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
            return null;
        }
        if (!a(str + "&" + str3, bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
            HMSLog.e("HMSPackageManager", "checkSigner failed");
            return null;
        }
        if (str4.equals("hms_app_signer_v3")) {
            this.n = 3;
        }
        return new Pair<>(str, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        synchronized (r) {
            HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
            long packageFirstInstallTime = this.b.getPackageFirstInstallTime("com.huawei.hwid");
            if (this.k != 3 && this.l == packageFirstInstallTime) {
                HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.k));
                return this.k;
            }
            this.k = c() ? 2 : 1;
            this.l = this.b.getPackageFirstInstallTime("com.huawei.hwid");
            HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.k));
            return this.k;
        }
    }

    private boolean c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f6329a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    private Pair<String, String> a(String str, String str2) {
        if (b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.w("HMSPackageManager", "check sign fail: " + str + "_" + str2);
        return null;
    }

    private boolean a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !b(str, str2) && Build.VERSION.SDK_INT >= 28;
    }

    private String a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("priority=");
        if (iIndexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int iIndexOf2 = str.indexOf(",", iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        return str.substring(iIndexOf, iIndexOf2);
    }

    private boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> listB = com.huawei.hms.device.a.b(str3);
            if (listB.size() == 0) {
                HMSLog.e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f6329a), listB)) {
                HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            if (!a(listB, Arrays.asList("Huawei CBG Application Integration CA", "Huawei CBG HMS"), Arrays.asList("Huawei CBG", "Huawei CBG Cloud Security Signer"))) {
                HMSLog.i("HMSPackageManager", "failed to verify cert chain.");
                return false;
            }
            if (com.huawei.hms.device.a.a(listB.get(listB.size() - 1), str, str2)) {
                return true;
            }
            HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    }

    private boolean a(List<X509Certificate> list, List<String> list2, List<String> list3) {
        if (list != null && list2 != null && list3 != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                X509Certificate x509Certificate = list.get(size);
                if (size >= list2.size()) {
                    HMSLog.e("HMSPackageManager", "CN is invalid, Array length mismatch.");
                    return false;
                }
                if (!com.huawei.hms.device.a.a(x509Certificate, list2.get(size))) {
                    HMSLog.e("HMSPackageManager", "CN is invalid");
                    return false;
                }
                if (size >= list3.size()) {
                    HMSLog.e("HMSPackageManager", "OU is invalid, Array length mismatch.");
                    return false;
                }
                if (!com.huawei.hms.device.a.b(x509Certificate, list3.get(size))) {
                    HMSLog.e("HMSPackageManager", "OU is invalid");
                    return false;
                }
            }
            return true;
        }
        HMSLog.e("HMSPackageManager", "checkSubjects, params is null.");
        return false;
    }

    private static String a(int i) {
        if (i == 1) {
            return "SPOOFED";
        }
        if (i == 2) {
            return MonitorResult.SUCCESS;
        }
        if (i == 3) {
            return "UNCHECKED";
        }
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i);
        return "";
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }
}
