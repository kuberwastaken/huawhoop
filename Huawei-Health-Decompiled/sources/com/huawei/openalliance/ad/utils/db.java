package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f7981a = new ArrayList();

    public static boolean a(String str) {
        List<String> list = f7981a;
        if (list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return list.contains(str);
    }

    public static void a(Context context) {
        List<String> list = f7981a;
        list.clear();
        list.add(da.f(context));
        list.add(da.d(context));
        list.add(da.g(context));
        list.add(da.e(context));
    }
}
