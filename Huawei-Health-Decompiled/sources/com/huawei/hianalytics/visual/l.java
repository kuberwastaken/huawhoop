package com.huawei.hianalytics.visual;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import java.lang.reflect.Field;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f4075a = new k();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f4076a = new l();
    }

    public boolean a(Activity activity) {
        String string;
        Uri referrer;
        Uri data;
        if (activity == null) {
            return false;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            string = (String) declaredField.get(activity);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            HiLog.w("JumpManager", "get invoker failed");
            string = "";
        }
        String stringExtra = null;
        if (TextUtils.isEmpty(string)) {
            try {
                referrer = activity.getReferrer();
            } catch (Throwable unused2) {
                HiLog.w("JumpManager", "get referrer error");
                referrer = null;
            }
            if (referrer != null) {
                string = referrer.toString();
            }
        }
        if (!TextUtils.isEmpty(string)) {
            String str = this.f4075a.f4073a;
            if (TextUtils.isEmpty(str) || !Objects.equals(string, str)) {
                this.f4075a.f4073a = string;
            }
        }
        if (TextUtils.isEmpty(this.f4075a.f4073a)) {
            return false;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("HASDKSourceId");
            } catch (Throwable unused3) {
                HiLog.w("JumpManager", "update notification source failed");
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f4075a.b = stringExtra;
            }
        }
        Intent intent2 = activity.getIntent();
        if (intent2 != null && (data = intent2.getData()) != null && !data.isOpaque()) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str2 : data.getQueryParameterNames()) {
                    jSONObject.put(str2, data.getQueryParameter(str2));
                }
            } catch (Exception unused4) {
                HiLog.w("JumpManager", "update channel params error");
            }
            this.f4075a.c = jSONObject;
        }
        k0 k0Var = k0.b;
        Intent intent3 = activity.getIntent();
        k0Var.getClass();
        if (intent3 != null && intent3.hasExtra("$sessionid") && intent3.hasExtra("$sessiontime")) {
            try {
                String stringExtra2 = intent3.getStringExtra("$sessionid");
                long longExtra = intent3.getLongExtra("$sessiontime", 0L);
                j0 j0Var = k0Var.f4074a;
                j0Var.getClass();
                if (TextUtils.isEmpty(stringExtra2) || longExtra <= 0) {
                    HiLog.w("SessionManager", "invalid session to update");
                } else {
                    j0Var.f4072a = stringExtra2;
                    j0Var.b = longExtra;
                }
            } catch (Throwable unused5) {
                HiLog.w("SessionManager", "updateSession error");
            }
        }
        return true;
    }
}
