package defpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public class cac extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f556a;

    public cac() {
        cal.d("HuaweiOpenSSLSocketFactory", "init HuaweiOpenSSLSocketFactory");
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, new TrustManager[]{new caf()}, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            if (socketFactory == null) {
                cal.c("HuaweiOpenSSLSocketFactory", "socketFactory is null error!");
            }
            this.f556a = socketFactory;
        } catch (KeyManagementException e) {
            cal.c("HuaweiOpenSSLSocketFactory", "sslContext init failed." + e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            cal.c("HuaweiOpenSSLSocketFactory", "get SSLContext instance failed. " + e2.getMessage());
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        Socket socketCreateSocket = this.f556a.createSocket();
        e(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket socketCreateSocket = this.f556a.createSocket(inetAddress, i, inetAddress2, i2);
        e(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.f556a.createSocket(inetAddress, i);
        e(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socketCreateSocket = this.f556a.createSocket(socket, str, i, z);
        e(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.f556a.createSocket(str, i, inetAddress, i2);
        e(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.f556a.createSocket(str, i);
        e(socketCreateSocket);
        return socketCreateSocket;
    }

    private void e(Socket socket) {
        cal.d("HuaweiOpenSSLSocketFactory", "enter setEnableSafeCipherSuites");
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            if (enabledCipherSuites == null || enabledCipherSuites.length == 0) {
                cal.c("HuaweiOpenSSLSocketFactory", "Current enabled cipherSuites is invalid!");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : enabledCipherSuites) {
                if (cae.d.contains(str)) {
                    arrayList.add(str);
                }
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
            return;
        }
        cal.c("HuaweiOpenSSLSocketFactory", "socket is not instanceof SSLSocket");
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f556a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f556a.getSupportedCipherSuites();
    }
}
