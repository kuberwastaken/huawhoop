package defpackage;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.CommonUtil;
import health.compact.a.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class eou {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("matchRules")
    private Map<String, String> f12700a;

    @SerializedName("greyRules")
    private Map<String, Object> b;

    @SerializedName("ts")
    private long c;

    @SerializedName("source")
    private int d;

    @SerializedName("configId")
    private String e;

    public eou(String str, Map<String, String> map) {
        Objects.requireNonNull(str);
        if (TextUtils.isEmpty(str)) {
            LogUtil.j("RequestBody", "configId is empty.");
            return;
        }
        this.c = System.currentTimeMillis();
        this.d = 1;
        this.e = str;
        this.f12700a = map;
        if (epx.e(str, map)) {
            LogUtil.b("RequestBody", "isNeedAddGrayscale is open.");
            HashMap map2 = new HashMap();
            map2.put("version", "1.0.0");
            map2.put("type", 1);
            if (CommonUtil.cl() && !Utils.n()) {
                map2.put("Device-ID", "10.21.21.104");
            }
            this.b = map2;
        }
    }

    public String e() {
        return this.e;
    }
}
