package defpackage;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;

/* JADX INFO: loaded from: classes9.dex */
class tm {
    private final CustomTabsIntent.Builder e;

    tm() {
        this(new CustomTabsIntent.Builder());
    }

    tm(CustomTabsIntent.Builder builder) {
        this.e = builder;
    }

    void bW_(Context context, Uri uri, boolean z) {
        CustomTabsIntent customTabsIntentBuild = this.e.build();
        if (z) {
            customTabsIntentBuild.intent.addFlags(268435456);
        }
        customTabsIntentBuild.launchUrl(context, uri);
    }
}
