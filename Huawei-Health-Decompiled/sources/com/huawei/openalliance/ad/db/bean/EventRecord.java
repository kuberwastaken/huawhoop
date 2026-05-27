package com.huawei.openalliance.ad.db.bean;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.e;
import com.huawei.openalliance.ad.hq;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class EventRecord extends a {
    public static final String AD_TYPE = "adType";
    public static final String LAST_FAIL_REASON = "lastFailReason";
    public static final String LAST_REPORT_TIME = "lastReportTime";
    public static final String REPEATED_COUNT = "repeatedCount";
    public static final String TIME = "time";

    @e
    private String _id;
    private int adType_;
    private String agVerifyCode;
    private String appDownloadRelatedActionSource;
    private String appVersionCode;
    private String clickComponent;
    private String clickPos;
    private String clickSuccessDestination_;
    private String contentDownMethod;
    private String contentId;
    private String creativeSize;
    private String customData;
    private String downloadDuration;
    private String downloadMode;
    private String downloadReason;
    private String downloadSize;
    private int exposure;
    private EncryptionField<String> ext;
    private String fullDownload;
    private String impSource;
    private String installRelatedActionSource;
    private String installType;
    private String intentDest;
    private String intentFailReason;
    private String isAdContainerSizeMatched;
    private List<String> keyWords;
    private List<String> keyWordsType;
    private String lastFailReason;
    private String lastReportTime;
    private int opTimesInLandingPage_;
    private EncryptionField<String> paramFromServer_;
    private String playedProgress;
    private String preCheckResult;
    private List<String> preContentSuccessList;
    private int rawX_;
    private int rawY_;

    @e
    private String realAppPkgName;
    private String realFailedReason;
    private long repeatedCount;
    private String requestId;
    private String shakeAngle;
    private String showid_;
    private String slotPosition;
    private long time_;
    private String type_;
    private String userId;
    private String venusExt;

    @e
    private long videoTime;
    private long showTimeDuration_ = -111111;
    private int maxShowRatio_ = -111111;
    private long videoPlayStartTime_ = -111111;
    private long videoPlayEndTime_ = -111111;
    private int videoPlayStartProgress_ = -111111;
    private int videoPlayEndProgress_ = -111111;
    private int requestType = 0;
    private int encodingMode = -111111;
    private int clickX = -111111;
    private int clickY = -111111;
    private int magLockPosition = -111111;
    private int sld = -111111;

    @e
    private float density = -111111.0f;
    private int upX = -111111;
    private int upY = -111111;
    private long clickDTime = -111111;
    private long clickUTime = -111111;
    private float clickDownPressure = -111111.0f;
    private float clickUpPressure = -111111.0f;
    private float clickDownSize = -111111.0f;
    private float clickUpSize = -111111.0f;
    private int clickDownScrollHeight = -111111;
    private int clickUpScrollHeight = -111111;
    private long startShowTime = -111111;
    private int playedTime = -111111;
    private int adReqSource = -111111;

    public void z(String str) {
        this.agVerifyCode = str;
    }

    public String z() {
        return this.intentDest;
    }

    public void y(String str) {
        this.requestId = str;
    }

    public List<String> y() {
        return this.preContentSuccessList;
    }

    public void x(String str) {
        this.contentId = str;
    }

    public String x() {
        return this.contentDownMethod;
    }

    public void w(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public long w() {
        return this.repeatedCount;
    }

    public void v(String str) {
        this.userId = str;
    }

    public String v() {
        return this.lastFailReason;
    }

    public void u(String str) {
        this.customData = str;
    }

    public String u() {
        return this.lastReportTime;
    }

    public void t(String str) {
        this.fullDownload = str;
    }

    public List<String> t() {
        return this.keyWordsType;
    }

    public void s(String str) {
        this.downloadMode = str;
    }

    public List<String> s() {
        return this.keyWords;
    }

    public void r(String str) {
        this.downloadDuration = str;
    }

    public EncryptionField<String> r() {
        return this.ext;
    }

    public void q(String str) {
        this.downloadSize = str;
    }

    public int q() {
        return this.opTimesInLandingPage_;
    }

    public void p(String str) {
        this.downloadReason = str;
    }

    public void p(int i) {
        this.clickUpScrollHeight = i;
    }

    public int p() {
        return this.rawY_;
    }

    public void o(String str) {
        this.appVersionCode = str;
    }

    public void o(int i) {
        this.clickDownScrollHeight = i;
    }

    public int o() {
        return this.rawX_;
    }

    public void n(String str) {
        this.impSource = str;
    }

    public void n(int i) {
        this.adReqSource = i;
    }

    public EncryptionField<String> n() {
        return this.paramFromServer_;
    }

    public void m(String str) {
        this.preCheckResult = str;
    }

    public void m(int i) {
        this.upY = i;
    }

    public int m() {
        return this.adType_;
    }

    public void l(String str) {
        this.installRelatedActionSource = str;
    }

    public void l(int i) {
        this.upX = i;
    }

    public String l() {
        return this.showid_;
    }

    public void k(String str) {
        this.appDownloadRelatedActionSource = str;
    }

    public void k(int i) {
        this.sld = i;
    }

    public long k() {
        return this.time_;
    }

    public void j(String str) {
        this.intentFailReason = str;
    }

    public void j(int i) {
        this.playedTime = i;
    }

    public String j() {
        return this.type_;
    }

    public void i(String str) {
        this.intentDest = str;
    }

    public void i(long j) {
        this.clickUTime = j;
    }

    public void i(int i) {
        this.requestType = i;
    }

    public String i() {
        return this._id;
    }

    public void h(String str) {
        this.contentDownMethod = str;
    }

    public void h(long j) {
        this.clickDTime = j;
    }

    public void h(int i) {
        this.exposure = i;
    }

    public int h() {
        return this.maxShowRatio_;
    }

    public void g(String str) {
        this.lastFailReason = str;
    }

    public void g(long j) {
        this.videoTime = j;
    }

    public void g(int i) {
        this.opTimesInLandingPage_ = i;
    }

    public int g() {
        return this.videoPlayEndProgress_;
    }

    public void f(String str) {
        this.lastReportTime = str;
    }

    public void f(long j) {
        this.startShowTime = j;
    }

    public void f(int i) {
        this.rawY_ = i;
    }

    public int f() {
        return this.videoPlayStartProgress_;
    }

    public void e(String str) {
        if (this.ext == null) {
            this.ext = new EncryptionField<>(String.class);
        }
        this.ext.a(str);
    }

    public void e(long j) {
        this.repeatedCount = j;
    }

    public void e(int i) {
        this.rawX_ = i;
    }

    public void e(float f) {
        this.clickUpSize = f;
    }

    public long e() {
        return this.videoPlayEndTime_;
    }

    public void d(String str) {
        this.showid_ = str;
    }

    public void d(long j) {
        this.time_ = j;
    }

    public void d(int i) {
        this.adType_ = i;
    }

    public void d(float f) {
        this.clickDownSize = f;
    }

    public long d() {
        return this.videoPlayStartTime_;
    }

    public void c(String str) {
        this.type_ = str;
    }

    public void c(long j) {
        this.videoPlayEndTime_ = j;
    }

    public void c(int i) {
        this.maxShowRatio_ = i;
    }

    public void c(float f) {
        this.clickUpPressure = f;
    }

    public String c() {
        return this.clickSuccessDestination_;
    }

    public void b(List<String> list) {
        this.keyWordsType = list;
    }

    public void b(String str) {
        this.clickSuccessDestination_ = str;
    }

    public void b(Integer num) {
        this.clickY = num.intValue();
    }

    public void b(long j) {
        this.videoPlayStartTime_ = j;
    }

    public void b(int i) {
        this.videoPlayEndProgress_ = i;
    }

    public void b(float f) {
        this.clickDownPressure = f;
    }

    public long b() {
        return this.showTimeDuration_;
    }

    public int av() {
        return this.clickUpScrollHeight;
    }

    public int au() {
        return this.clickDownScrollHeight;
    }

    public float at() {
        return this.clickUpSize;
    }

    public float as() {
        return this.clickDownSize;
    }

    public float ar() {
        return this.clickUpPressure;
    }

    public float aq() {
        return this.clickDownPressure;
    }

    public String ap() {
        return this.shakeAngle;
    }

    public long ao() {
        return this.clickUTime;
    }

    public long an() {
        return this.clickDTime;
    }

    public String am() {
        return this.realAppPkgName;
    }

    public long al() {
        return this.videoTime;
    }

    public int ak() {
        return this.adReqSource;
    }

    public String aj() {
        return this.slotPosition;
    }

    public int ai() {
        return this.upY;
    }

    public int ah() {
        return this.upX;
    }

    public float ag() {
        return this.density;
    }

    public int af() {
        return this.sld;
    }

    public int ae() {
        return this.encodingMode;
    }

    public String ad() {
        return this.playedProgress;
    }

    public int ac() {
        return this.playedTime;
    }

    public long ab() {
        return this.startShowTime;
    }

    public String aa() {
        return this.venusExt;
    }

    public void a(List<String> list) {
        this.keyWords = list;
    }

    public void a(String str) {
        this.realFailedReason = str;
    }

    public void a(Integer num) {
        this.clickX = num.intValue();
    }

    public void a(EncryptionField<String> encryptionField) {
        this.paramFromServer_ = encryptionField;
    }

    public void a(long j) {
        this.showTimeDuration_ = j;
    }

    public void a(int i) {
        this.videoPlayStartProgress_ = i;
    }

    public void a(float f) {
        this.density = f;
    }

    public String a() {
        return this.realFailedReason;
    }

    public String Z() {
        return this.creativeSize;
    }

    public int Y() {
        return this.clickY;
    }

    public String X() {
        return this.clickPos;
    }

    public String W() {
        return this.clickComponent;
    }

    public int V() {
        return this.clickX;
    }

    public String U() {
        return this.installType;
    }

    public String T() {
        return this.agVerifyCode;
    }

    public String S() {
        return this.requestId;
    }

    public String R() {
        return this.contentId;
    }

    public int Q() {
        return this.requestType;
    }

    public Integer P() {
        try {
            return Integer.valueOf(Integer.parseInt(this.isAdContainerSizeMatched));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public String O() {
        return this.userId;
    }

    public String N() {
        return this.customData;
    }

    public int M() {
        return this.exposure;
    }

    public String L() {
        return this.fullDownload;
    }

    public String K() {
        return this.downloadMode;
    }

    public String J() {
        return this.downloadDuration;
    }

    public void I(String str) {
        this.shakeAngle = str;
    }

    public String I() {
        return this.downloadSize;
    }

    public void H(String str) {
        this.realAppPkgName = str;
    }

    public String H() {
        return this.downloadReason;
    }

    public void G(String str) {
        this.slotPosition = str;
    }

    public String G() {
        return this.appVersionCode;
    }

    public void F(String str) {
        this.playedProgress = str;
    }

    public void E(String str) {
        this.venusExt = str;
    }

    public String E() {
        return this.impSource;
    }

    public void D(String str) {
        this.creativeSize = str;
    }

    public String D() {
        return this.preCheckResult;
    }

    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            hq.b(a.TAG, "clickPos is invalid");
        } else {
            this.clickPos = str;
        }
    }

    public String C() {
        return this.installRelatedActionSource;
    }

    public void B(String str) {
        if (TextUtils.isEmpty(str)) {
            hq.b(a.TAG, "clickComponent is invalid");
        } else {
            this.clickComponent = str;
        }
    }

    public String B() {
        return this.appDownloadRelatedActionSource;
    }

    public void A(String str) {
        this.installType = str;
    }

    public String A() {
        return this.intentFailReason;
    }
}
