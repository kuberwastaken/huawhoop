package com.huawei.haf.language;

import android.content.Context;
import android.content.res.Configuration;
import com.huawei.haf.common.os.FileUtils;
import com.huawei.haf.dynamic.DynamicLoaderException;
import com.huawei.haf.dynamic.DynamicResourcesLoader;
import health.compact.a.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class LanguageInstallHelper {
    private LanguageInstallHelper() {
    }

    public static void onConfigurationChanged(Configuration configuration) {
        LanguageManager.Ar_(configuration, true);
    }

    public static void updateResources(Context context) {
        LanguageManager.b(context);
    }

    static boolean addResources(String str, Context context, File file) {
        try {
            if (file.exists() && file.isFile()) {
                FileUtils.j(file);
                String absolutePath = file.getAbsolutePath();
                boolean zE = DynamicResourcesLoader.e(absolutePath);
                DynamicResourcesLoader.zP_(context, context.getResources(), Collections.singletonList(absolutePath));
                return !zE && DynamicResourcesLoader.e(absolutePath);
            }
            LogUtil.d(str, file.getName(), " does not exists.");
            return false;
        } catch (DynamicLoaderException e) {
            LogUtil.d(str, "addResources ex=", LogUtil.c(e));
            return false;
        }
    }

    static boolean checkUsedResources(File file) {
        return DynamicResourcesLoader.e(file.getAbsolutePath());
    }

    static void checkOrUpdateResources(String str, Context context, File file, File file2) {
        try {
            DynamicResourcesLoader.zP_(context, context.getResources(), getLoadedResourcesPaths(file, file2));
        } catch (DynamicLoaderException e) {
            LogUtil.d(str, "checkOrUpdateResources ex=", LogUtil.c(e));
        }
    }

    private static Collection<String> getLoadedResourcesPaths(File file, File file2) {
        ArrayList arrayList = new ArrayList();
        if (file != null && file.exists() && file.isFile()) {
            arrayList.add(file.getAbsolutePath());
        }
        if (file2 != null && file2.exists() && file2.isFile()) {
            arrayList.add(file2.getAbsolutePath());
        }
        return arrayList;
    }
}
