package com.huawei.openalliance.ad.views.web;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import androidx.webkit.ProxyConfig;
import com.huawei.agconnect.apms.instrument.URLConnectionInstrumentation;
import com.huawei.agconnect.apms.instrument.apacheclient.ApacheClientInstrumentation;
import com.huawei.hms.network.embedded.g2;
import com.huawei.openalliance.ad.hq;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* JADX INFO: loaded from: classes6.dex */
public class g extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f8484a;
    private HostnameVerifier b;
    private org.apache.http.conn.ssl.SSLSocketFactory c;
    private X509HostnameVerifier d;
    private SslErrorHandler e;
    private String f;
    private a g;
    private Context h;

    public interface a {
        void a(Context context, String str);

        void b(Context context, String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v3, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        Exception e;
        HttpsURLConnection httpsURLConnection;
        IOException e2;
        InputStream inputStream;
        super.run();
        HttpsURLConnection httpsURLConnection2 = null;
        if (this.c != null && this.d != null) {
            if (this.e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f)) {
                        try {
                            try {
                                this.c.setHostnameVerifier(this.d);
                                BasicHttpParams basicHttpParams = new BasicHttpParams();
                                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                                HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
                                SchemeRegistry schemeRegistry = new SchemeRegistry();
                                schemeRegistry.register(new Scheme(ProxyConfig.MATCH_HTTPS, this.c, g2.n));
                                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                                HttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                                HttpGet httpGet = new HttpGet();
                                httpGet.setURI(new URI(this.f));
                                hq.b("WebViewSSLCheckThread", "status code is : " + (!(defaultHttpClient instanceof HttpClient) ? defaultHttpClient.execute(httpGet) : ApacheClientInstrumentation.execute(defaultHttpClient, httpGet)).getStatusLine().getStatusCode());
                                a((Reader) null);
                                b();
                                return;
                            } catch (Throwable th) {
                                hq.a("WebViewSSLCheckThread", "apache run: exception : %s", th.getMessage());
                                hq.c("WebViewSSLCheckThread", "apache run: exception : " + th.getClass().getSimpleName());
                                a();
                                a((Reader) null);
                                return;
                            }
                        } catch (IOException e3) {
                            hq.a("WebViewSSLCheckThread", "apache IOException  exception : %s", e3.getMessage());
                            hq.c("WebViewSSLCheckThread", "apache IOException  exception : " + e3.getClass().getSimpleName());
                            a();
                            a((Reader) null);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    a((Reader) null);
                    throw th2;
                }
            }
            hq.d("WebViewSSLCheckThread", "sslErrorHandler or url is null");
            a();
            return;
        }
        if (this.f8484a != null) {
            ?? r0 = this.b;
            try {
                if (r0 != 0) {
                    try {
                        URLConnection uRLConnectionOpenConnection = URLConnectionInstrumentation.openConnection(new URL(this.f).openConnection());
                        if (uRLConnectionOpenConnection instanceof HttpsURLConnection) {
                            httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.f8484a);
                                httpsURLConnection.setHostnameVerifier(this.b);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(20000);
                                httpsURLConnection.getResponseCode();
                                httpsURLConnection2 = httpsURLConnection;
                                inputStream = httpsURLConnection.getInputStream();
                            } catch (IOException e4) {
                                e2 = e4;
                                hq.a("WebViewSSLCheckThread", "IOException : %s", e2.getMessage());
                                hq.c("WebViewSSLCheckThread", "IOException : " + e2.getClass().getSimpleName());
                                a();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                a((InputStream) null);
                                return;
                            } catch (Exception e5) {
                                e = e5;
                                hq.a("WebViewSSLCheckThread", "exception : %s", e.getMessage());
                                hq.c("WebViewSSLCheckThread", "exception : " + e.getClass().getSimpleName());
                                a();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                a((InputStream) null);
                                return;
                            }
                        } else {
                            inputStream = null;
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        a(inputStream);
                        b();
                        return;
                    } catch (IOException e6) {
                        e2 = e6;
                        httpsURLConnection = null;
                    } catch (Exception e7) {
                        e = e7;
                        httpsURLConnection = null;
                    } catch (Throwable th3) {
                        th = th3;
                        r0 = 0;
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                        a((InputStream) null);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        a();
    }

    private void b() {
        hq.b("WebViewSSLCheckThread", "callbackProceed: ");
        SslErrorHandler sslErrorHandler = this.e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(this.h, this.f);
        }
    }

    private void a(Reader reader) {
        a((Closeable) reader);
    }

    private void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                hq.d("WebViewSSLCheckThread", "closeSecure IOException");
            }
        }
    }

    private void a() {
        hq.b("WebViewSSLCheckThread", "callbackCancel: ");
        if (this.e != null) {
            hq.b("WebViewSSLCheckThread", "callbackCancel 2: ");
            this.e.cancel();
        }
        a aVar = this.g;
        if (aVar != null) {
            aVar.b(this.h, this.f);
        }
    }
}
