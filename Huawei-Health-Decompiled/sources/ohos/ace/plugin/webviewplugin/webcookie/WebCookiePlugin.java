package ohos.ace.plugin.webviewplugin.webcookie;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes2.dex */
public class WebCookiePlugin {
    private static final String LOG_TAG = "WebCookiePlugin";

    protected static native void onReceiveCookieValue(long j);

    protected static native void onReceiveCookieValue(String str, long j);

    protected static native void onReceiveCookieValue(boolean z, long j);

    protected native void nativeInit();

    public WebCookiePlugin(Context context) {
        nativeInit();
    }

    public void configCookie(String str, String str2, final long j) {
        CookieManager.getInstance().setCookie(str, str2, new ValueCallback<Boolean>() { // from class: ohos.ace.plugin.webviewplugin.webcookie.WebCookiePlugin.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool) {
                WebCookiePlugin.onReceiveCookieValue(true, j);
            }
        });
    }

    public void fetchCookie(String str, long j) {
        String cookie = CookieManager.getInstance().getCookie(str);
        if (cookie == null) {
            cookie = "";
        }
        onReceiveCookieValue(cookie, j);
    }

    public void clearAllCookies(final long j) {
        CookieManager.getInstance().removeAllCookies(new ValueCallback<Boolean>() { // from class: ohos.ace.plugin.webviewplugin.webcookie.WebCookiePlugin.2
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool) {
                WebCookiePlugin.onReceiveCookieValue(j);
            }
        });
    }

    public boolean existCookie(boolean z) {
        CookieManager.getInstance().flush();
        return CookieManager.getInstance().hasCookies();
    }

    public void clearSessionCookie(final long j) {
        CookieManager.getInstance().removeSessionCookies(new ValueCallback<Boolean>() { // from class: ohos.ace.plugin.webviewplugin.webcookie.WebCookiePlugin.3
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool) {
                WebCookiePlugin.onReceiveCookieValue(j);
            }
        });
    }
}
