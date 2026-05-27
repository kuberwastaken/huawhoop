package defpackage;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class kbu {
    private d appAuditInfo;
    private a redirectInfo;

    public d getAppAuditInfo() {
        return this.appAuditInfo;
    }

    public a getRedirectInfo() {
        return this.redirectInfo;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class d {
        private String betaScopes;
        private String passedScopes;

        public String getPassedScopes() {
            if (this.passedScopes == null) {
                this.passedScopes = "";
            }
            return this.passedScopes;
        }

        public String getBetaScopes() {
            if (this.betaScopes == null) {
                this.betaScopes = "";
            }
            return this.betaScopes;
        }
    }

    public static class a {
        private String appId;
        private long expiredTimestamp;
        private String secret;
        private String signature;
        private Set<String> urlSchemes;

        public Set<String> getUrlSchemes() {
            return this.urlSchemes;
        }

        public String getSecret() {
            return this.secret;
        }

        public void setSecret(String str) {
            this.secret = str;
        }

        public void setExpiredTimestamp(long j) {
            this.expiredTimestamp = j;
        }

        public boolean isExpired() {
            return this.expiredTimestamp - System.currentTimeMillis() < 0;
        }

        public String getSignature() {
            return this.signature;
        }

        public void setSignature(String str) {
            this.signature = str;
        }

        public String getAppId() {
            return this.appId;
        }

        public void setAppId(String str) {
            this.appId = str;
        }
    }
}
