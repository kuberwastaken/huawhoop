package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* JADX INFO: loaded from: classes5.dex */
public class ExceptionCode {
    public static final int CANCEL = 10000100;
    private static final String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 10000402;
    public static final int CONNECTION_REFUSED = 10000404;
    public static final int CONNECTION_RESET = 10000401;
    public static final int CONNECT_FAILED = 10000403;
    public static final int CRASH_EXCEPTION = 10000000;
    public static final int INTERRUPT_CONNECT_CLOSE = 10000405;
    public static final int INTERRUPT_EXCEPTION = 10000804;
    public static final int NETWORK_CHANGED = 10000201;
    public static final int NETWORK_IO_EXCEPTION = 10000802;
    public static final int NETWORK_TIMEOUT = 10000101;
    public static final int NETWORK_UNREACHABLE = 10000200;
    public static final int NETWORK_UNSUPPORTED = 10000102;
    public static final int PROTOCOL_ERROR = 10000801;
    private static final String READ = "read";
    public static final int READ_ERROR = 10000601;
    public static final int ROUTE_FAILED = 10000301;
    public static final int SHUTDOWN_EXCEPTION = 10000202;
    public static final int SOCKET_CLOSE = 10000406;
    public static final int SOCKET_CONNECT_TIMEOUT = 10000400;
    public static final int SOCKET_READ_TIMEOUT = 10000600;
    public static final int SOCKET_TIMEOUT = 10000803;
    public static final int SOCKET_WRITE_TIMEOUT = 10000700;
    public static final int SSL_HANDSHAKE_EXCEPTION = 10000501;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 10000502;
    public static final int SSL_PROTOCOL_EXCEPTION = 10000500;
    public static final int UNABLE_TO_RESOLVE_HOST = 10000300;
    public static final int UNEXPECTED_EOF = 10000800;
    private static final String WRITE = "write";

    public static int getErrorCodeFromException(Exception exc) {
        if (exc == null) {
            return 10000802;
        }
        if (!(exc instanceof IOException)) {
            return CRASH_EXCEPTION;
        }
        String message = exc.getMessage();
        if (message == null) {
            return 10000802;
        }
        String lowerCase = StringUtils.toLowerCase(message);
        int errorCodeFromMsg = getErrorCodeFromMsg(lowerCase);
        if (errorCodeFromMsg != 10000802) {
            return errorCodeFromMsg;
        }
        if (exc instanceof SocketTimeoutException) {
            return getErrorCodeSocketTimeout(exc);
        }
        if (exc instanceof ConnectException) {
            return 10000403;
        }
        if (exc instanceof NoRouteToHostException) {
            return 10000301;
        }
        if (exc instanceof SSLProtocolException) {
            return 10000500;
        }
        if (exc instanceof SSLHandshakeException) {
            return 10000501;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 10000502;
        }
        if (exc instanceof UnknownHostException) {
            return 10000300;
        }
        return exc instanceof InterruptedIOException ? lowerCase.contains("connection has been shut down") ? 10000405 : 10000804 : exc instanceof ProtocolException ? PROTOCOL_ERROR : errorCodeFromMsg;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int getErrorCodeSocketTimeout(java.lang.Exception r7) {
        /*
            java.lang.String r0 = "connect"
            java.lang.String r1 = "read"
            java.lang.String r2 = "write"
            java.lang.String[] r3 = new java.lang.String[]{r0, r1, r2}
            java.lang.String r7 = checkExceptionContainsKey(r7, r3)
            r7.hashCode()
            int r3 = r7.hashCode()
            r4 = 3496342(0x355996, float:4.899419E-39)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L39
            r1 = 113399775(0x6c257df, float:7.3103804E-35)
            if (r3 == r1) goto L30
            r1 = 951351530(0x38b478ea, float:8.605591E-5)
            if (r3 == r1) goto L27
            goto L3f
        L27:
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L2e
            goto L3f
        L2e:
            r7 = r5
            goto L42
        L30:
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L37
            goto L3f
        L37:
            r7 = r6
            goto L42
        L39:
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L41
        L3f:
            r7 = -1
            goto L42
        L41:
            r7 = 0
        L42:
            if (r7 == 0) goto L54
            if (r7 == r6) goto L50
            if (r7 == r5) goto L4c
            r7 = 10000803(0x9899a3, float:1.401411E-38)
            return r7
        L4c:
            r7 = 10000400(0x989810, float:1.4013545E-38)
            return r7
        L50:
            r7 = 10000700(0x98993c, float:1.4013966E-38)
            return r7
        L54:
            r7 = 10000600(0x9898d8, float:1.4013825E-38)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.ExceptionCode.getErrorCodeSocketTimeout(java.lang.Exception):int");
    }

    private static int getErrorCodeFromMsg(String str) {
        if (str.contains("unexpected end of stream")) {
            return 10000800;
        }
        if (str.contains("unable to resolve host")) {
            return 10000300;
        }
        if (str.contains("read error")) {
            return 10000601;
        }
        if (str.contains("connection reset")) {
            return 10000401;
        }
        if (str.contains("software caused connection abort")) {
            return 10000402;
        }
        if (str.contains("failed to connect to")) {
            return 10000403;
        }
        if (str.contains("connection refused")) {
            return 10000404;
        }
        if (str.contains("connection timed out")) {
            return 10000400;
        }
        if (str.contains("no route to host")) {
            return 10000301;
        }
        if (str.contains("network is unreachable")) {
            return 10000200;
        }
        return str.contains("socket closed") ? 10000406 : 10000802;
    }

    private static String checkExceptionContainsKey(Exception exc, String... strArr) {
        return checkStrContainsKey(StringUtils.toLowerCase(exc.getMessage()), strArr);
    }

    private static String checkStrContainsKey(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }
}
