package com.huawei.appgallery.marketinstallerservice.api;

/* JADX INFO: loaded from: classes3.dex */
public class InstallParamSpec extends BaseParamSpec {
    public static final int FAIL_RESULT_DIALOG = 2;
    public static final int FAIL_RESULT_NOTHING = 1;
    public static final int FAIL_RESULT_TOAST = 0;
    private MarketInfo c;
    private boolean e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1911a = 0;

    public void setSilentDownload(boolean z) {
        this.e = z;
    }

    public void setMarketInfo(MarketInfo marketInfo) {
        this.c = marketInfo;
    }

    public void setFailResultPromptType(int i) {
        this.f1911a = i;
    }

    public boolean isSilentDownload() {
        return this.e;
    }

    public MarketInfo getMarketInfo() {
        return this.c;
    }

    public int getFailResultPromptType() {
        return this.f1911a;
    }
}
