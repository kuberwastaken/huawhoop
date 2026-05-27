package com.huawei.updatesdk.a.a.b;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.updatesdk.a.a.d.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HttpURLConnection f11304a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11305a;
        private int b;
        private String c;

        public String c() {
            return this.c;
        }

        public String b() {
            return this.f11305a;
        }

        public int a() {
            return this.b;
        }
    }

    public void a() {
        HttpURLConnection httpURLConnection = this.f11304a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public a a(String str, String str2, String str3, String str4, Context context) throws Throwable {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        a aVar = new a();
        DataOutputStream dataOutputStream = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            HttpURLConnection httpURLConnectionA = a(str, context);
            this.f11304a = httpURLConnectionA;
            httpURLConnectionA.setDoInput(true);
            this.f11304a.setDoOutput(true);
            this.f11304a.setUseCaches(false);
            this.f11304a.setConnectTimeout(5000);
            this.f11304a.setReadTimeout(10000);
            this.f11304a.setRequestMethod("POST");
            this.f11304a.setRequestProperty("Content-Type", "application/x-gzip");
            this.f11304a.setRequestProperty("Content-Encoding", Constants.GZIP);
            this.f11304a.setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
            this.f11304a.setRequestProperty(HttpHeaders.USER_AGENT, str4);
            DataOutputStream dataOutputStream2 = new DataOutputStream(this.f11304a.getOutputStream());
            try {
                dataOutputStream2.write(a(str2.getBytes(str3)));
                dataOutputStream2.flush();
                a(aVar, this.f11304a);
                int responseCode = this.f11304a.getResponseCode();
                aVar.b = responseCode;
                bufferedInputStream2 = responseCode == 200 ? new BufferedInputStream(this.f11304a.getInputStream()) : new BufferedInputStream(this.f11304a.getErrorStream());
                com.huawei.updatesdk.a.a.d.b bVar = new com.huawei.updatesdk.a.a.d.b();
                byte[] bArrA = com.huawei.updatesdk.a.a.b.a.b().a();
                while (true) {
                    int i = bufferedInputStream2.read(bArrA);
                    if (i == -1) {
                        break;
                    }
                    bVar.a(bArrA, i);
                }
                com.huawei.updatesdk.a.a.b.a.b().a(bArrA);
                aVar.f11305a = bVar.a();
                HttpURLConnection httpURLConnection = this.f11304a;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                d.a(dataOutputStream2);
                d.a(bufferedInputStream2);
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
                dataOutputStream = dataOutputStream2;
                bufferedInputStream = bufferedInputStream3;
                HttpURLConnection httpURLConnection2 = this.f11304a;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                d.a(dataOutputStream);
                d.a(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    private byte[] a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        DataOutputStream dataOutputStream3 = null;
        DataOutputStream dataOutputStream4 = null;
        dataOutputStream3 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream2 = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
            } catch (IOException e) {
                e = e;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            dataOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            dataOutputStream2.write(bArr, 0, bArr.length);
            dataOutputStream2.flush();
        } catch (IOException e3) {
            e = e3;
            dataOutputStream4 = dataOutputStream2;
            dataOutputStream = dataOutputStream4;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                com.huawei.updatesdk.a.a.c.a.a.a.a("HttpsUtil", "gzip error!", e);
                dataOutputStream2 = dataOutputStream;
                byteArrayOutputStream = byteArrayOutputStream2;
            } catch (Throwable th3) {
                th = th3;
                DataOutputStream dataOutputStream5 = dataOutputStream;
                byteArrayOutputStream = byteArrayOutputStream2;
                dataOutputStream3 = dataOutputStream5;
                d.a(dataOutputStream3);
                d.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream3 = dataOutputStream2;
            d.a(dataOutputStream3);
            d.a(byteArrayOutputStream);
            throw th;
        }
        d.a(dataOutputStream2);
        d.a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private void a(a aVar, HttpURLConnection httpURLConnection) {
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            com.huawei.updatesdk.a.a.c.a.a.a.d("HttpsUtil", "headers is null.");
            return;
        }
        List<String> list = headerFields.get("x-traceId");
        if (list == null || list.isEmpty()) {
            com.huawei.updatesdk.a.a.c.a.a.a.d("HttpsUtil", "no x-traceId.");
        } else {
            aVar.c = list.get(0);
        }
    }

    public static HttpURLConnection a(String str, Context context) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setSSLSocketFactory(SecureSSLSocketFactoryNew.getInstance(context));
        httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        return httpsURLConnection;
    }
}
