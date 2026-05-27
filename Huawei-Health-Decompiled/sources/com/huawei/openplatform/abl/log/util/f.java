package com.huawei.openplatform.abl.log.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f8512a = new ArrayList();

    public static boolean a(String str) {
        List<String> list = f8512a;
        if (list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return list.contains(str);
    }

    public static void a(Context context) {
        List<String> list = f8512a;
        list.clear();
        list.add(e.a(context));
        list.add(e.b(context));
        list.add(e.c(context));
        list.add(e.d(context));
    }
}
