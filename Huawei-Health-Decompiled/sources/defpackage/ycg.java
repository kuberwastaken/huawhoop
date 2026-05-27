package defpackage;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.huawei.featureuserprofile.route.navigationparser.NavigationFileParser;
import com.huawei.hihealthservice.old.model.OldToNewMotionPath;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.openalliance.ad.constant.ErrorCode;
import com.huawei.openalliance.ad.constant.MetaCreativeType;
import com.huawei.openalliance.ad.constant.MimeType;
import com.huawei.pluginfitnessadvice.FitWorkout;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class ycg {
    private static final Map<Integer, c> d = new ConcurrentHashMap();

    static {
        e(0, "text/plain", "txt", true);
        e(16, "application/cose; cose-type=\"cose-encrypt0\"", "cbor");
        e(17, "application/cose; cose-type=\"cose-mac0\"", "cbor");
        e(18, "application/cose; cose-type=\"cose-sign1\"", "cbor");
        e(19, "application/ace+cbor", "cbor");
        e(21, MimeType.GIF, MetaCreativeType.GIF);
        e(22, "image/jpeg", "jpeg");
        e(23, "image/png", "png");
        e(40, "application/link-format", "wlnk", false);
        e(41, "application/xml", "xml", false);
        e(42, FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM, NavigationFileParser.BIN);
        e(46, "application/xmpp+xml", "xmpp", false);
        e(47, "application/exi", "exi");
        e(50, "application/json", "json", false);
        e(51, "application/json-patch+json", "json", false);
        e(52, "application/merge-patch+json", "json", false);
        e(60, "application/cbor", "cbor");
        e(61, "application/cwt", "cwt");
        e(62, "application/multipart-core", "part");
        e(63, "application/cbor-seq", "cbor");
        e(96, "application/cose; cose-type=\"cose-encrypt\"", "cbor");
        e(97, "application/cose; cose-type=\"cose-mac\"", "cbor");
        e(98, "application/cose; cose-type=\"cose-sign\"", "cbor");
        e(101, "application/cose-key", "cbor");
        e(102, "application/cose-key-set", "cbor");
        e(110, "application/senml+json", "json", false);
        e(111, "application/sensml+json", "json", false);
        e(112, "application/senml+cbor", "cbor");
        e(113, "application/sensml+cbor", "cbor");
        e(114, "application/senml+exi", "exi");
        e(115, "application/sensml+exi", "exi");
        e(256, "application/coap-group+json", "json", false);
        e(OldToNewMotionPath.SPORT_TYPE_BASKETBALL, "application/dots+cbor", "cbor");
        e(272, "application/missing-blocks+cbor-seq", "cbor");
        e(OldToNewMotionPath.SPORT_TYPE_CROSS_COUNTRY_RACE, "application/pkcs7-mime; smime-type=\"server-generated-key\"", "pkcs");
        e(281, "application/pkcs7-mime; smime-type=\"certs-only\"", "pkcs");
        e(FitWorkout.CATEGORY_REAL_SCENE, "application/pkcs8", "pkcs");
        e(285, "application/csattrs", "csattrs");
        e(286, "application/pkcs10", "pkcs");
        e(287, "application/pkix-cert", "pkix");
        e(310, "application/senml+xml", "xml", false);
        e(311, "application/sensml+xml", "xml", false);
        e(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, "application/senml-etch+json", "json", false);
        e(322, "application/senml-etch+cbor", "cbor");
        e(ErrorCode.ERROR_CODE_NO_PACKAGE, "application/td+json", "json", false);
        e(10000, "application/vnd.ocf+cbor", "cbor");
        e(10001, "application/oscore", "oscore");
        e(10002, "application/javascript", "js", false);
        e(11542, "application/vnd.oma.lwm2m+tlv", "tlv");
        e(11543, "application/vnd.oma.lwm2m+json", "json", false);
        e(11544, "application/vnd.oma.lwm2m+cbor", "cbor");
        e(20000, "text/css", "css", false);
        e(30000, "image/svg+xml", "xml", false);
    }

    public static boolean a(int i) {
        c cVar = d.get(Integer.valueOf(i));
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    public static String c(int i) {
        if (i == -1) {
            return "undefined";
        }
        c cVar = d.get(Integer.valueOf(i));
        if (cVar != null) {
            return cVar.a();
        }
        return "unknown/" + i;
    }

    private static void e(int i, String str, String str2) {
        d(new c(Integer.valueOf(i), str, str2));
    }

    private static void e(int i, String str, String str2, boolean z) {
        d(new c(Integer.valueOf(i), str, str2, z));
    }

    public static void d(c cVar) {
        d.put(cVar.e(), cVar);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f19233a;
        private final boolean b;
        private final boolean c;
        private final String d;
        private final String e;

        public c(Integer num, String str, String str2) {
            if (num == null) {
                throw new NullPointerException("type must not be null!");
            }
            if (str == null) {
                throw new NullPointerException("mime must not be null!");
            }
            if (str2 == null) {
                throw new NullPointerException("file extension must not be null!");
            }
            this.f19233a = num;
            this.e = str;
            this.d = str2;
            this.c = false;
            this.b = false;
        }

        public c(Integer num, String str, String str2, boolean z) {
            if (num == null) {
                throw new NullPointerException("type must not be null!");
            }
            if (str == null) {
                throw new NullPointerException("mime must not be null!");
            }
            if (str2 == null) {
                throw new NullPointerException("file extension must not be null!");
            }
            this.f19233a = num;
            this.e = str;
            this.d = str2;
            this.c = true;
            this.b = z;
        }

        public Integer e() {
            return this.f19233a;
        }

        public String a() {
            return this.e;
        }

        public boolean d() {
            return this.c;
        }
    }
}
