package defpackage;

import java.util.HashMap;
import java.util.Map;
import net.openid.appauth.ClientAuthentication;

/* JADX INFO: loaded from: classes8.dex */
public class xyd implements ClientAuthentication {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19206a;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(String str) {
        return null;
    }

    public xyd(String str) {
        this.f19206a = (String) xym.c(str, (Object) "clientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(String str) {
        HashMap map = new HashMap();
        map.put("client_id", str);
        map.put("client_secret", this.f19206a);
        return map;
    }
}
