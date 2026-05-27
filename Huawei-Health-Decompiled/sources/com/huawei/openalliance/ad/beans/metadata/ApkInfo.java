package com.huawei.openalliance.ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.a;
import com.huawei.openalliance.ad.annotations.d;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ApkInfo {
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private String appDesc;
    private String appDetailDesc;
    private String appName;
    private int autoOpenAfterInstall;
    private int autoOpenAfterInstallV2;
    private String channelInfo;
    private int checkSha256Flag;
    private String contentBtnAction;
    private String contiBtn;
    private String detailUrl;
    private String developerName;
    private String dlBtnText;
    private String dlOpenBtnText;
    private String downCountDesc;
    private Long downloadNum;
    private long fileSize;
    private String fullScrnNotifyText;

    @d(a = "hasper")
    private Integer hasPermission;
    private String hot;

    @d(a = "appIcon")
    @a
    private String iconUrl;
    private String insActvNotifyBtnText;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String nextInstallWays;
    private int noAlertTime;
    private String packageName;
    private String permissionUrl;
    private List<Permission> permissions;
    private String pkgNameEncoded;
    private int popUpAfterInstallNew;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String pureModeText;
    private Long rateNum;
    private String reservedPkgName;

    @a
    private String secondUrl;
    private String sha256;
    private int trafficReminder;

    @a
    private String url;
    private String versionCode;
    private String versionName;
    private String permPromptForCard = "1";
    private String permPromptForLanding = "0";
    private int channelInfoSaveLimit = -2;
    private int popNotify = 1;
    private int fullScrnNotify = 0;
    private int insActvNotifyCfg = 1;
    private int appType = 1;

    public void z(String str) {
        this.developerName = str;
    }

    public String z() {
        return this.appDesc;
    }

    public void y(String str) {
        this.intentPackage = str;
    }

    public int y() {
        return this.channelInfoSaveLimit;
    }

    public void x(String str) {
        this.intent = str;
    }

    public String x() {
        return this.iconUrl;
    }

    public void w(String str) {
        this.insActvNotifyBtnText = str;
    }

    public String w() {
        return this.channelInfo;
    }

    public void v(String str) {
        this.fullScrnNotifyText = str;
    }

    public String v() {
        return this.popUpAfterInstallText;
    }

    public void u(String str) {
        this.afDlBtnText = str;
    }

    public int u() {
        return this.popUpAfterInstallNew;
    }

    public void t(String str) {
        this.dlBtnText = str;
    }

    public String t() {
        String str = this.permPromptForLanding;
        return str == null ? "0" : str;
    }

    public void s(String str) {
        this.appDesc = str;
    }

    public String s() {
        String str = this.permPromptForCard;
        return str == null ? "1" : str;
    }

    public void r(String str) {
        this.iconUrl = str;
    }

    public InstallConfig r() {
        return this.installConfig;
    }

    public void q(String str) {
        this.channelInfo = str;
    }

    public String q() {
        return TextUtils.isEmpty(this.contentBtnAction) ? this.priorInstallWay : this.contentBtnAction;
    }

    public void p(String str) {
        this.popUpAfterInstallText = str;
    }

    public String p() {
        return this.downCountDesc;
    }

    public void o(String str) {
        this.permPromptForLanding = str;
    }

    public Long o() {
        return this.downloadNum;
    }

    public void n(String str) {
        this.permPromptForCard = str;
    }

    public Long n() {
        return this.rateNum;
    }

    public void m(String str) {
        this.contentBtnAction = str;
    }

    public String m() {
        return this.hot;
    }

    public void l(String str) {
        this.downCountDesc = str;
    }

    public String l() {
        return this.priorInstallWay;
    }

    public void k(String str) {
        this.hot = str;
    }

    public List<Permission> k() {
        return this.permissions;
    }

    public void j(String str) {
        this.priorInstallWay = str;
    }

    public String j() {
        return this.appName;
    }

    public void i(String str) {
        this.appName = str;
    }

    public void i(int i) {
        this.autoOpenAfterInstallV2 = i;
    }

    public String i() {
        return this.detailUrl;
    }

    public void h(String str) {
        this.detailUrl = str;
    }

    public void h(int i) {
        this.autoOpenAfterInstall = i;
    }

    public String h() {
        return this.permissionUrl;
    }

    public void g(String str) {
        this.permissionUrl = str;
    }

    public void g(int i) {
        this.appType = i;
    }

    public String g() {
        return this.secondUrl;
    }

    public void f(String str) {
        this.secondUrl = str;
    }

    public void f(int i) {
        this.insActvNotifyCfg = i;
    }

    public String f() {
        return this.sha256;
    }

    public void e(String str) {
        this.sha256 = str;
    }

    public void e(int i) {
        this.fullScrnNotify = i;
    }

    public long e() {
        return this.fileSize;
    }

    public void d(String str) {
        this.url = str;
    }

    public void d(int i) {
        this.popNotify = i;
    }

    public String d() {
        return this.url;
    }

    public void c(String str) {
        this.versionName = str;
    }

    public void c(int i) {
        this.trafficReminder = i;
    }

    public String c() {
        return this.versionName;
    }

    public void b(String str) {
        this.versionCode = str;
    }

    public void b(Long l) {
        this.downloadNum = l;
    }

    public void b(long j) {
        this.allAreaPopDelay = j;
    }

    public void b(int i) {
        this.channelInfoSaveLimit = i;
    }

    public String b() {
        return this.versionCode;
    }

    public String ac() {
        return this.appDetailDesc;
    }

    public String ab() {
        return this.dlOpenBtnText;
    }

    public int aa() {
        return this.autoOpenAfterInstallV2;
    }

    public void a(List<Permission> list) {
        this.permissions = list;
    }

    public void a(String str) {
        this.packageName = str;
    }

    public void a(Long l) {
        this.rateNum = l;
    }

    public void a(Integer num) {
        this.hasPermission = num;
    }

    public void a(InstallConfig installConfig) {
        this.installConfig = installConfig;
    }

    public void a(long j) {
        this.fileSize = j;
    }

    public void a(int i) {
        this.popUpAfterInstallNew = i;
    }

    public String a() {
        return this.packageName;
    }

    public String Z() {
        return this.reservedPkgName;
    }

    public String Y() {
        return this.contiBtn;
    }

    public String X() {
        return this.installPureModeText;
    }

    public String W() {
        return this.pureModeText;
    }

    public String V() {
        return this.installPermiText;
    }

    public int U() {
        return this.popUpStyle;
    }

    public long T() {
        return this.allAreaPopDelay;
    }

    public int S() {
        return this.autoOpenAfterInstall;
    }

    public int R() {
        return this.appType;
    }

    public String Q() {
        return this.actName;
    }

    public int P() {
        return this.checkSha256Flag;
    }

    public String O() {
        return this.nextInstallWays;
    }

    public String N() {
        return this.pkgNameEncoded;
    }

    public String M() {
        return this.developerName;
    }

    public Integer L() {
        return this.hasPermission;
    }

    public String K() {
        return this.intentPackage;
    }

    public void J(String str) {
        this.appDetailDesc = str;
    }

    public String J() {
        return this.intent;
    }

    public void I(String str) {
        this.dlOpenBtnText = str;
    }

    public int I() {
        return this.insActvNotifyCfg;
    }

    public void H(String str) {
        this.reservedPkgName = str;
    }

    public String H() {
        return this.insActvNotifyBtnText;
    }

    public void G(String str) {
        this.contiBtn = str;
    }

    public String G() {
        return this.fullScrnNotifyText;
    }

    public void F(String str) {
        this.installPureModeText = str;
    }

    public int F() {
        return this.fullScrnNotify;
    }

    public void E(String str) {
        this.pureModeText = str;
    }

    public int E() {
        return this.popNotify;
    }

    public void D(String str) {
        this.installPermiText = str;
    }

    public String D() {
        return this.afDlBtnText;
    }

    public void C(String str) {
        this.actName = str;
    }

    public String C() {
        return this.dlBtnText;
    }

    public void B(String str) {
        this.nextInstallWays = str;
    }

    public int B() {
        return this.trafficReminder;
    }

    public void A(String str) {
        this.pkgNameEncoded = str;
    }

    public int A() {
        return this.noAlertTime;
    }
}
