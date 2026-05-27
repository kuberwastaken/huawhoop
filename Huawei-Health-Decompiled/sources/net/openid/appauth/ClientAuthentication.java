package net.openid.appauth;

import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface ClientAuthentication {
    Map<String, String> getRequestHeaders(String str);

    Map<String, String> getRequestParameters(String str);

    public static class b extends Exception {
        private String d;

        public b(String str) {
            super("Unsupported client authentication method: " + str);
            this.d = str;
        }
    }
}
