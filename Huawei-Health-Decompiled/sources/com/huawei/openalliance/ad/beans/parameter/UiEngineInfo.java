package com.huawei.openalliance.ad.beans.parameter;

/* JADX INFO: loaded from: classes6.dex */
public class UiEngineInfo {
    private String cachedStylePkgVer;
    private String cachedTptEgnVer;

    public static final class Builder {
        private String cachedStylePkgVer;
        private String cachedTptEgnVer;

        public Builder b(String str) {
            this.cachedTptEgnVer = str;
            return this;
        }

        public UiEngineInfo a() {
            UiEngineInfo uiEngineInfo = new UiEngineInfo();
            uiEngineInfo.cachedStylePkgVer = this.cachedStylePkgVer;
            uiEngineInfo.cachedTptEgnVer = this.cachedTptEgnVer;
            return uiEngineInfo;
        }

        public Builder a(String str) {
            this.cachedStylePkgVer = str;
            return this;
        }
    }

    public String b() {
        return this.cachedTptEgnVer;
    }

    public String a() {
        return this.cachedStylePkgVer;
    }
}
