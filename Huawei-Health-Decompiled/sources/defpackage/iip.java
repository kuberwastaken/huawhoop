package defpackage;

import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.hms.network.inner.api.NetworkService;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class iip {
    private static final String e = ody.b + "dynamic_track_music_resource" + File.separator;

    public static String a() {
        try {
            return new File(e).getCanonicalPath();
        } catch (IOException e2) {
            ReleaseLogUtil.c("DynamicConfigParam", "getDynamicCloudConfigPathPrefix exception ", ExceptionUtils.a(e2));
            return "";
        }
    }

    public static String b() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(e);
        sb.append("package resource");
        sb.append(File.separator);
        sb.append("image");
        sb.append(File.separator);
        sb.append("1.1.1");
        sb.append(File.separator);
        return sb.toString();
    }

    public static String d() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(e);
        sb.append("package resource");
        sb.append(File.separator);
        sb.append("default_music");
        sb.append(File.separator);
        sb.append("1.1.1");
        sb.append(File.separator);
        return sb.toString();
    }

    public static String e() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(e);
        sb.append("package resource");
        sb.append(File.separator);
        sb.append(NetworkService.Constants.CONFIG_SERVICE);
        sb.append(File.separator);
        sb.append("1.1.1");
        sb.append(File.separator);
        sb.append("resource_config.json");
        return sb.toString();
    }

    public static String c() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(e);
        sb.append("package resource");
        sb.append(File.separator);
        sb.append(NetworkService.Constants.CONFIG_SERVICE);
        sb.append(File.separator);
        return sb.toString();
    }

    public static String c(String str) {
        StringBuilder sb = new StringBuilder(16);
        sb.append(e);
        sb.append("package resource");
        sb.append(File.separator);
        sb.append("image");
        sb.append(File.separator);
        sb.append("1.1.1");
        sb.append(File.separator);
        sb.append(str);
        sb.append(".png");
        return sb.toString();
    }

    public static String d(String str, boolean z) {
        StringBuilder sb = new StringBuilder(16);
        sb.append(e);
        if (z) {
            sb.append("package resource");
            sb.append(File.separator);
            sb.append("default_music");
            sb.append(File.separator);
        } else {
            sb.append(str);
            sb.append(File.separator);
        }
        sb.append("1.1.1");
        sb.append(File.separator);
        sb.append(str);
        sb.append(".aac");
        return sb.toString();
    }
}
