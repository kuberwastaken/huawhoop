package defpackage;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.huawei.haf.dynamic.DynamicLoaderException;
import com.huawei.haf.dynamic.DynamicResourcesLoader;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public class ary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ars f291a = new ars("SplitInstallHelper");

    public static void a(Context context) {
        if (fr_(context, context.getResources())) {
            return;
        }
        f291a.c("Failed to load context resources", new Object[0]);
    }

    public static void fo_(Activity activity, Resources resources) {
        if (fr_(activity, resources)) {
            return;
        }
        f291a.c("Failed to load activity resources", new Object[0]);
    }

    public static void fp_(Service service) {
        if (fr_(service, service.getBaseContext().getResources())) {
            return;
        }
        f291a.c("Failed to load service resources", new Object[0]);
    }

    public static void fq_(BroadcastReceiver broadcastReceiver, Context context) {
        if (!"ReceiverRestrictedContext".equals(context.getClass().getSimpleName()) || fr_(((ContextWrapper) context).getBaseContext(), context.getResources())) {
            return;
        }
        f291a.c("Failed to load receiver resources", new Object[0]);
    }

    public static void b(Context context, String str) {
        if (atm.c(context, str)) {
            return;
        }
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e) {
            String str2 = context.getApplicationInfo().nativeLibraryDir + File.pathSeparatorChar + System.mapLibraryName(str);
            if (new File(str2).exists()) {
                System.load(str2);
                return;
            }
            throw e;
        }
    }

    private static boolean fr_(Context context, Resources resources) {
        try {
            DynamicResourcesLoader.zP_(context, resources, atq.a().getLoadedModuleApkPaths());
            return true;
        } catch (DynamicLoaderException e) {
            f291a.e(e, "checkOrUpdateResources fail.", new Object[0]);
            return false;
        }
    }
}
