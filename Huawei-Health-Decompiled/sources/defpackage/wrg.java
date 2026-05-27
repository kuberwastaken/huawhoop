package defpackage;

import android.content.Context;
import com.huawei.wearengine.common.SecureX509TrustManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes9.dex */
public class wrg extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f18868a = {"TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA"};
    private static volatile wrg c = null;
    private static String[] d = null;
    private SSLContext b = SSLContext.getInstance("TLSv1.2");
    private Context e;

    private wrg(Context context) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.e = context;
        this.b.init(null, new X509TrustManager[]{new SecureX509TrustManager(this.e)}, null);
    }

    public static wrg e(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        if (c == null) {
            synchronized (wrg.class) {
                if (c == null) {
                    c = new wrg(context);
                }
            }
        }
        return c;
    }

    private static void c(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int i = 0;
            while (true) {
                String[] strArr = f18868a;
                if (i < strArr.length) {
                    if (upperCase.contains(strArr[i].toUpperCase(Locale.ENGLISH))) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    arrayList.add(str);
                    break;
                }
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        d = strArr2;
        sSLSocket.setEnabledCipherSuites(strArr2);
    }

    private void c(Socket socket) {
        if (socket == null || !(socket instanceof SSLSocket)) {
            return;
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        e(sSLSocket);
        c(sSLSocket);
    }

    private void e(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] strArr = d;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.b.getSocketFactory().createSocket(str, i);
        c(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (inetAddress == null) {
            return this.b.getSocketFactory().createSocket();
        }
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (inetAddress == null) {
            return this.b.getSocketFactory().createSocket();
        }
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socketCreateSocket = this.b.getSocketFactory().createSocket(socket, str, i, z);
        c(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
