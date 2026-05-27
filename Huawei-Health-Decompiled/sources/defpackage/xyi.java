package defpackage;

import java.util.Collections;
import java.util.Map;
import net.openid.appauth.ClientAuthentication;

/* JADX INFO: loaded from: classes8.dex */
public class xyi implements ClientAuthentication {
    public static final xyi d = new xyi();

    @Override // net.openid.appauth.ClientAuthentication
    public Map<String, String> getRequestHeaders(String str) {
        return null;
    }

    private xyi() {
    }

    @Override // net.openid.appauth.ClientAuthentication
    public Map<String, String> getRequestParameters(String str) {
        return Collections.singletonMap("client_id", str);
    }
}
