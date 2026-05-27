package com.huawei.picture.security.base.broadcast;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.secure.android.common.intent.SafeIntent;

/* JADX INFO: loaded from: classes11.dex */
public class SafeBroadcastSender {

    static abstract class BaseSender {
        Context context;
        Intent intent;

        BaseSender(Intent intent, Context context) {
            this.intent = intent;
            this.context = context;
        }
    }

    public static class c extends BaseSender {
        boolean b;

        public c(Intent intent, Context context, boolean z) {
            super(intent, context);
            this.b = z;
        }

        @Deprecated
        public void d() {
            if (this.context != null) {
                this.context.sendBroadcast(this.intent);
            }
        }
    }

    public static a b(String str, Context context) {
        return new a(str, context);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f8659a;
        BaseSender b;
        Context d;
        Intent e;

        a(String str, Context context) {
            this.e = new SafeIntent(new Intent(str));
            this.d = context;
        }

        public c d() {
            c cVar = new c(this.e, this.d, this.f8659a);
            this.b = cVar;
            return cVar;
        }

        public a cmi_(Uri uri) {
            this.e.setData(uri);
            return this;
        }
    }
}
