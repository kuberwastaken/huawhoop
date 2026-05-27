package defpackage;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class wzt {
    public boolean a(Context context) {
        long jE = wze.e(e(), 0L, context);
        wzg.a("LocalCDNFile", "lastQueryTime is " + jE, new Object[0]);
        return System.currentTimeMillis() - jE > 432000000;
    }

    public Map c(Context context) {
        HashMap map = new HashMap();
        String strA = wze.a("ETag_ucscomponent", "", context);
        String strA2 = wze.a("Last-Modified_ucscomponent", "", context);
        map.put(HttpHeaders.ETAG, strA);
        map.put("If-Modified-Since", strA2);
        return map;
    }

    public String e() {
        return "Last-Query-Time_ucscomponent_ucscomponent.jws";
    }
}
