package defpackage;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.huawei.operation.utils.Constants;
import com.huawei.watchface.videoedit.utils.Utils;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class mll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f15706a;

    public mll() {
        this.f15706a = null;
        ConcurrentHashMap<String, String> concurrentHashMapA = mlj.a();
        this.f15706a = concurrentHashMapA;
        if (concurrentHashMapA.isEmpty()) {
            mly.a("DataHelper", "resourcesMap is empty", true);
            return;
        }
        mly.a("DataHelper", "resourcesMap--" + this.f15706a.size(), false);
    }

    public boolean c(String str) {
        return this.f15706a.containsKey(str);
    }

    public WebResourceResponse bXM_(String str) throws Throwable {
        String str2;
        String str3 = this.f15706a.get(str);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            InputStream inputStreamE = mls.e(mlj.e() + str3);
            if (inputStreamE == null) {
                return null;
            }
            if (str.contains(".css")) {
                mly.a("DataHelper", "mimeType is css", false);
                str2 = "text/css";
            } else if (str.contains(".png") || str.contains(".ico") || str.contains(Utils.SUFFIX_GIF)) {
                mly.a("DataHelper", "mimeType is png", false);
                str2 = Constants.IMAGE_TYPE;
            } else if (str.contains(".js")) {
                mly.a("DataHelper", "mimeType is js", false);
                str2 = "text/javascript";
            } else {
                mly.a("DataHelper", "getReplacedWebResourceResponse: mimetype default", false);
                return null;
            }
            mly.a("DataHelper", "getReplacedWebResourceResponse = " + this.f15706a.get(str), false);
            return new WebResourceResponse(str2, "utf-8", inputStreamE);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
            mly.b("DataHelper", "get hw folder or parse InputSteam failed", true);
            return null;
        }
    }
}
