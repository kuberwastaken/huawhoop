package defpackage;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.CommonUtil;
import health.compact.a.CompileParameterUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class kpr {
    public static final boolean i = CompileParameterUtil.e("IS_SUPPORT_NYX", false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f14826a = CompileParameterUtil.e("IS_SUPPORT_GRUS", false);
    public static final boolean e = CompileParameterUtil.e("IS_SUPPORT_JANUS", false);
    public static final boolean d = CompileParameterUtil.e("IS_SUPPORT_ERIS", false);
    public static final boolean c = CompileParameterUtil.e("SUPPORT_A1", false);
    public static final boolean f = CompileParameterUtil.e("SUPPORT_METIS", false);
    public static final boolean j = CompileParameterUtil.e("SUPPORT_R1", false);
    public static final String g = e() + "/Huawei/Health/";
    public static final String b = BaseApplication.getAppPackage() + ".fileprovider";

    private static String e() {
        try {
            return CommonUtil.h((Context) null).getCanonicalPath();
        } catch (IOException unused) {
            LogUtil.a("BTDialogActivity", "getCanonicalPath Failed");
            return "";
        }
    }
}
