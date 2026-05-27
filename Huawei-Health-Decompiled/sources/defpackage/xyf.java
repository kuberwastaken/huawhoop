package defpackage;

import android.util.Base64;
import java.util.Collections;
import java.util.Map;
import net.openid.appauth.ClientAuthentication;

/* JADX INFO: loaded from: classes8.dex */
public class xyf implements ClientAuthentication {
    private String c;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(String str) {
        return null;
    }

    public xyf(String str) {
        this.c = (String) xym.c(str, (Object) "mClientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(String str) {
        return Collections.singletonMap("Authorization", "Basic " + Base64.encodeToString((xyv.b(str) + ":" + xyv.b(this.c)).getBytes(), 2));
    }
}
