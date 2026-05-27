package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.regex.Pattern;
import org.eclipse.californium.elements.util.StandardCharsets;

/* JADX INFO: loaded from: classes8.dex */
public class ygp {
    public static final boolean b;
    public static final String c;
    private static final Pattern e = Pattern.compile("^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])$");
    private static final Pattern h = Pattern.compile("^(\\[[0-9a-fA-F:]+(%\\w+)?\\]|[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})$");
    public static final String d = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f19303a = "0123456789ABCDEF".toCharArray();
    private static final String[] i = new String[10];

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    static {
        /*
            java.lang.String r0 = "^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            defpackage.ygp.e = r0
            java.lang.String r0 = "^(\\[[0-9a-fA-F:]+(%\\w+)?\\]|[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            defpackage.ygp.h = r0
            java.lang.String r0 = "line.separator"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            defpackage.ygp.d = r0
            java.lang.String r0 = "0123456789ABCDEF"
            char[] r0 = r0.toCharArray()
            defpackage.ygp.f19303a = r0
            r0 = 10
            java.lang.String[] r0 = new java.lang.String[r0]
            defpackage.ygp.i = r0
            java.lang.String r0 = ""
            r1 = 0
            r2 = r1
        L2a:
            java.lang.String[] r3 = defpackage.ygp.i
            int r4 = r3.length
            if (r2 >= r4) goto L45
            r3[r2] = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "\t"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            int r2 = r2 + 1
            goto L2a
        L45:
            java.lang.Class<java.net.InetSocketAddress> r0 = java.net.InetSocketAddress.class
            java.lang.String r2 = "getHostString"
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.NoSuchMethodException -> L52
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.NoSuchMethodException -> L52
            if (r0 == 0) goto L52
            r1 = 1
        L52:
            defpackage.ygp.b = r1
            java.lang.Class<ygp> r0 = defpackage.ygp.class
            java.lang.Package r0 = r0.getPackage()
            if (r0 == 0) goto L68
            java.lang.String r0 = r0.getImplementationVersion()
            java.lang.String r1 = "0.0"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L69
        L68:
            r0 = 0
        L69:
            defpackage.ygp.c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ygp.<clinit>():void");
    }

    public static String b(InetSocketAddress inetSocketAddress) {
        if (b) {
            return inetSocketAddress.getHostString();
        }
        InetAddress address = inetSocketAddress.getAddress();
        if (address != null) {
            String string = address.toString();
            if (string.startsWith("/")) {
                return string.substring(1);
            }
            return address.getHostName();
        }
        return inetSocketAddress.getHostName();
    }

    public static String a(int i2) {
        if (i2 < 0) {
            return "";
        }
        String[] strArr = i;
        if (i2 >= strArr.length) {
            return strArr[strArr.length - 1];
        }
        return strArr[i2];
    }

    public static String b() {
        return d;
    }

    public static byte[] c(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("'" + str + "' has odd length!");
        }
        int i2 = length / 2;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int iDigit = Character.digit(str.charAt(i3), 16);
            if (iDigit < 0) {
                throw new IllegalArgumentException("'" + str + "' digit " + i3 + " is not hexadecimal!");
            }
            bArr[i4] = (byte) (iDigit << 4);
            int i5 = i3 + 1;
            int iDigit2 = Character.digit(str.charAt(i5), 16);
            if (iDigit2 < 0) {
                throw new IllegalArgumentException("'" + str + "' digit " + i5 + " is not hexadecimal!");
            }
            bArr[i4] = (byte) (bArr[i4] | ((byte) iDigit2));
            i3 += 2;
        }
        return bArr;
    }

    public static String e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return bArr.length == 0 ? "" : b(bArr, (char) 0, 0);
    }

    public static String c(byte[] bArr) {
        return b(bArr, (char) 0, 0);
    }

    public static String b(byte[] bArr, char c2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return "--";
        }
        if (i2 == 0 || i2 > bArr.length) {
            i2 = bArr.length;
        }
        StringBuilder sb = new StringBuilder((c2 == 0 ? 2 : 3) * i2);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = bArr[i3];
            int i4 = b2 & UnsignedBytes.MAX_VALUE;
            char[] cArr = f19303a;
            sb.append(cArr[i4 >>> 4]);
            sb.append(cArr[b2 & 15]);
            if (c2 != 0 && i3 < i2 - 1) {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public static String b(String str, int i2) {
        return (str == null || i2 <= 0 || i2 >= str.length()) ? str : str.substring(0, i2);
    }

    public static String a(byte[] bArr, int i2) {
        if (bArr == null) {
            return "<no data>";
        }
        if (bArr.length == 0) {
            return "<empty data>";
        }
        if (bArr.length < i2) {
            i2 = bArr.length;
        }
        int length = bArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                byte b2 = bArr[i3];
                if (32 > b2 && b2 != 9 && b2 != 10 && b2 != 13) {
                    break;
                }
                i3++;
            } else {
                CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
                charsetDecoderNewDecoder.onMalformedInput(CodingErrorAction.REPORT);
                charsetDecoderNewDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                CharBuffer charBufferAllocate = CharBuffer.allocate(i2);
                CoderResult coderResultDecode = charsetDecoderNewDecoder.decode(byteBufferWrap, charBufferAllocate, true);
                charsetDecoderNewDecoder.flush(charBufferAllocate);
                charBufferAllocate.flip();
                if (CoderResult.OVERFLOW == coderResultDecode) {
                    return "\"" + ((Object) charBufferAllocate) + "\".. " + bArr.length + " bytes";
                }
                if (!coderResultDecode.isError()) {
                    return "\"" + ((Object) charBufferAllocate) + "\"";
                }
            }
        }
        String strB = b(bArr, ' ', i2);
        if (bArr.length <= i2) {
            return strB;
        }
        return strB + ".." + bArr.length + " bytes";
    }

    public static String a(InetAddress inetAddress) {
        if (inetAddress == null) {
            return null;
        }
        return inetAddress.getHostAddress();
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        String strA;
        if (inetSocketAddress == null) {
            return null;
        }
        if (b) {
            strA = b(inetSocketAddress);
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            strA = address != null ? a(address) : "<unresolved>";
        }
        if (inetSocketAddress.getAddress() instanceof Inet6Address) {
            return "[" + strA + "]:" + inetSocketAddress.getPort();
        }
        return strA + ":" + inetSocketAddress.getPort();
    }

    public static String c(SocketAddress socketAddress) {
        if (socketAddress == null) {
            return null;
        }
        if (socketAddress instanceof InetSocketAddress) {
            return a((InetSocketAddress) socketAddress);
        }
        return socketAddress.toString();
    }

    public static String d(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            return null;
        }
        InetAddress address = inetSocketAddress.getAddress();
        if (address != null && address.isAnyLocalAddress()) {
            return "port " + inetSocketAddress.getPort();
        }
        String str = "";
        String strB = b ? b(inetSocketAddress) : "";
        String strA = address != null ? a(address) : "<unresolved>";
        if (!strB.equals(strA)) {
            str = strB + "/";
        }
        if (inetSocketAddress.getAddress() instanceof Inet6Address) {
            return str + "[" + strA + "]:" + inetSocketAddress.getPort();
        }
        return str + strA + ":" + inetSocketAddress.getPort();
    }

    public static Object d(final SocketAddress socketAddress) {
        if (socketAddress == null) {
            return null;
        }
        return new Object() { // from class: ygp.2
            public String toString() {
                SocketAddress socketAddress2 = socketAddress;
                if (socketAddress2 instanceof InetSocketAddress) {
                    return ygp.d((InetSocketAddress) socketAddress2);
                }
                return socketAddress2.toString();
            }
        };
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return e.matcher(str).matches();
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return h.matcher(str).matches();
    }

    public static String e(InetAddress inetAddress) throws URISyntaxException {
        int iIndexOf;
        int i2;
        if (inetAddress == null) {
            throw new NullPointerException("address must not be null!");
        }
        String hostAddress = inetAddress.getHostAddress();
        if (!(inetAddress instanceof Inet6Address)) {
            return hostAddress;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        if ((inet6Address.getScopedInterface() == null && inet6Address.getScopeId() <= 0) || (iIndexOf = hostAddress.indexOf(37)) <= 0 || (i2 = iIndexOf + 1) >= hostAddress.length()) {
            return hostAddress;
        }
        String strSubstring = hostAddress.substring(i2);
        String strSubstring2 = hostAddress.substring(0, iIndexOf);
        String str = strSubstring2 + "%25" + strSubstring;
        try {
            new URI(null, null, str, -1, null, null, null);
            return str;
        } catch (URISyntaxException e2) {
            String strReplaceAll = strSubstring.replaceAll("[-._~]", "");
            if (strReplaceAll.isEmpty()) {
                return strSubstring2;
            }
            String str2 = strSubstring2 + "%25" + strReplaceAll;
            try {
                new URI(null, null, str2, -1, null, null, null);
                return str2;
            } catch (URISyntaxException unused) {
                throw e2;
            }
        }
    }

    public static String h(String str) {
        if (str == null) {
            return "";
        }
        if (str.isEmpty() || str.endsWith(" ")) {
            return str;
        }
        return str + " ";
    }

    public static String c(Certificate certificate) {
        String[] strArrSplit = certificate.toString().split("\n");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : strArrSplit) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                int iG = g(strTrim);
                if (iG < 0 && strTrim.length() == 1) {
                    i2 += iG;
                    iG = 0;
                }
                sb.append(a(i2));
                sb.append(strTrim);
                sb.append("\n");
                i2 += iG;
            } else {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static int g(String str) {
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            length--;
            char cCharAt = str.charAt(length);
            if (cCharAt == '[') {
                i2++;
            } else if (cCharAt == ']') {
                i2--;
            }
        }
        if (i2 == 0 || !str.matches("\\d+:\\s+.*")) {
            return i2;
        }
        return 0;
    }

    public static String c(PublicKey publicKey) {
        return publicKey.toString().replaceAll("\n\\s+", "\n");
    }

    public static boolean b(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static String d(String str) {
        String property;
        String str2 = System.getenv(str);
        return ((str2 == null || str2.isEmpty()) && (property = System.getProperty(str)) != null) ? property : str2;
    }

    public static Boolean e(String str) {
        String strD = d(str);
        if (strD == null || strD.isEmpty()) {
            return null;
        }
        return Boolean.valueOf(strD);
    }
}
