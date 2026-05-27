package defpackage;

import com.huawei.openalliance.ad.constant.JsbMapKeyNames;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import org.eclipse.californium.elements.util.JceNames;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes8.dex */
public class ygn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[][] f19301a;
    private static volatile ygn b;
    private static final String[] c;
    private static final String[] d;
    private static final Logger e = ylq.a((Class<?>) ygn.class);
    private final boolean f;
    private final String g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean m;
    private final boolean o;

    public static void d() {
    }

    static {
        String[] strArr = {JceNames.ED25519, "1.3.101.112", JceNames.OID_ED25519, JceNames.EDDSA, JceNames.ED25519v2};
        d = strArr;
        String[] strArr2 = {JceNames.ED448, "1.3.101.113", JceNames.OID_ED448, JceNames.EDDSA, JceNames.ED448v2};
        c = strArr2;
        f19301a = new String[][]{new String[]{JceNames.DH, "DiffieHellman"}, new String[]{JceNames.EC, JceNames.ECv2}, strArr, strArr2, new String[]{JceNames.X25519, JceNames.X25519v2, JceNames.OID_X25519}, new String[]{JceNames.X448, JceNames.X448v2, JceNames.OID_X448}};
        try {
            try {
                Class.forName(AccessController.class.getName());
                f();
            } catch (Throwable th) {
                e.error("JCE:", th);
            }
        } catch (ClassNotFoundException unused) {
            j();
        }
    }

    private static void f() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: ygn.2
            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Void run() {
                try {
                    ygn.j();
                    return null;
                } catch (Throwable th) {
                    ygn.e.error("JCE:", th);
                    return null;
                }
            }
        });
    }

    private static boolean e(Provider provider) {
        return provider != null && provider.getName().equals(JceNames.JCE_PROVIDER_BOUNCY_CASTLE);
    }

    private static boolean a(Provider provider) {
        return provider != null && provider.getClass().getName().equals("net.i2p.crypto.eddsa.EdDSASecurityProvider");
    }

    private static void a(Provider provider, String str, String str2) {
        if (str2.equals(provider.getProperty(str))) {
            return;
        }
        provider.setProperty(str, str2);
    }

    private static Provider b(String str) {
        try {
            Provider provider = (Provider) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            e.debug("Loaded {}", str);
            return provider;
        } catch (Throwable th) {
            Logger logger = e;
            if (logger.isTraceEnabled()) {
                logger.trace("Loading {} failed!", str, th);
                return null;
            }
            logger.debug("Loading {} failed!", str);
            return null;
        }
    }

    private static void i() {
        try {
            Class<?> cls = Class.forName("org.slf4j.bridge.SLF4JBridgeHandler");
            cls.getMethod("removeHandlersForRootLogger", new Class[0]).invoke(null, new Object[0]);
            cls.getMethod(JsbMapKeyNames.H5_TEXT_DOWNLOAD_INSTALL, new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException unused) {
            e.warn("Setup BC logging failed, missing logging bridge 'jul-to-slf4j'!");
        } catch (Throwable th) {
            e.warn("Setup BC logging failed!", th);
        }
    }

    private static String g() {
        String property = Security.getProperty("securerandom.strongAlgorithms");
        if (property != null) {
            if (property.contains("NativePRNGBlocking")) {
                Security.setProperty("securerandom.strongAlgorithms", property.replaceAll("NativePRNGBlocking", "NativePRNGNonBlocking"));
            } else {
                SecureRandom secureRandom = new SecureRandom();
                String str = secureRandom.getAlgorithm() + ":";
                if (!property.contains(str)) {
                    Security.setProperty("securerandom.strongAlgorithms", str + secureRandom.getProvider().getName() + "," + property);
                } else {
                    e.info("Random: {} already in {}", str, property);
                }
            }
        }
        return property;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(35:0|2|(1:21)(35:6|(1:8)(2:9|(33:11|20|23|148|24|(3:166|26|27)(1:28)|(2:32|(1:34)(6:35|(1:37)(1:38)|39|(7:156|41|152|42|(1:44)|45|46)|(1:48)|(3:54|150|55)))|(2:58|(1:60)(2:61|(5:158|63|154|64|65)))|164|66|67|(1:69)(2:160|70)|74|144|75|76|78|168|79|80|82|(1:96)(5:162|88|91|(1:93)(1:94)|95)|97|(1:99)|(1:101)(1:102)|103|(1:119)(9:106|(1:108)(2:109|(1:111))|146|112|113|142|115|116|118)|120|(1:122)(1:123)|124|(1:126)|127|(5:129|(2:132|130)|170|133|134)(1:171))(2:12|(32:14|23|148|24|(0)(0)|(2:32|(0)(0))|(2:58|(0)(0))|164|66|67|(0)(0)|74|144|75|76|78|168|79|80|82|(3:84|86|96)(0)|97|(0)|(0)(0)|103|(1:119)(0)|120|(0)(0)|124|(0)|127|(0)(0))(2:15|(1:17)(1:18))))|19|20|23|148|24|(0)(0)|(0)|(0)|164|66|67|(0)(0)|74|144|75|76|78|168|79|80|82|(0)(0)|97|(0)|(0)(0)|103|(0)(0)|120|(0)(0)|124|(0)|127|(0)(0))|22|23|148|24|(0)(0)|(0)|(0)|164|66|67|(0)(0)|74|144|75|76|78|168|79|80|82|(0)(0)|97|(0)|(0)(0)|103|(0)(0)|120|(0)(0)|124|(0)|127|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        r2 = false;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x014a, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015b, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x016c, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j() {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ygn.j():void");
    }

    public static boolean b() {
        return b.k;
    }

    public static boolean c() {
        return b.i;
    }

    public static boolean a(String str) {
        if (JceNames.EC.equalsIgnoreCase(str)) {
            return b.j;
        }
        if (JceNames.RSA.equalsIgnoreCase(str)) {
            return b.o;
        }
        String strB = b(str, null);
        if (JceNames.OID_ED25519.equals(strB)) {
            return b.h;
        }
        if (JceNames.OID_ED448.equals(strB)) {
            return b.f;
        }
        return JceNames.EDDSA.equalsIgnoreCase(str) && (b.h || b.f);
    }

    public static String b(String str, String str2) {
        if (JceNames.EDDSA.equalsIgnoreCase(str)) {
            return JceNames.EDDSA;
        }
        return ygp.b(d, str) ? JceNames.OID_ED25519 : ygp.b(c, str) ? JceNames.OID_ED448 : str2;
    }

    public static boolean a(String str, String str2) {
        if (str != null && str.equals(str2)) {
            return true;
        }
        for (String[] strArr : f19301a) {
            if (ygp.b(strArr, str) && ygp.b(strArr, str2)) {
                return true;
            }
        }
        return false;
    }

    private ygn(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str) {
        this.k = z;
        this.o = z2;
        this.j = z3;
        this.h = z4;
        this.f = z5;
        this.m = z6;
        this.i = z7;
        this.g = str;
    }

    public int hashCode() {
        int i = this.h ? 41 : 37;
        int i2 = this.f ? 41 : 37;
        int i3 = this.m ? 41 : 37;
        int i4 = this.j ? 41 : 37;
        return ((((((((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + (this.o ? 41 : 37)) * 31) + (this.k ? 41 : 37)) * 31) + this.g.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ygn ygnVar = (ygn) obj;
        return this.h == ygnVar.h && this.f == ygnVar.f && this.m == ygnVar.m && this.j == ygnVar.j && this.o == ygnVar.o && this.k == ygnVar.k && this.g.equals(ygnVar.g);
    }
}
