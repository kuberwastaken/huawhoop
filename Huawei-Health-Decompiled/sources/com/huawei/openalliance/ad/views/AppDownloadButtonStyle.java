package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.health.R;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.utils.Cdo;
import com.huawei.openalliance.ad.utils.ar;

/* JADX INFO: loaded from: classes6.dex */
public class AppDownloadButtonStyle {
    private Context b;
    protected Drawable cancelBtnDrawable;
    protected Style normalStyle = new Style();
    protected Style processingStyle = new Style();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Style f8058a = new Style();
    protected Style cancelBtnStyle = new Style();
    protected Style installingStyle = new Style();

    public void setCancelBtnDrawable(Drawable drawable) {
        this.cancelBtnDrawable = drawable;
    }

    public Style getStyle(Context context, AppStatus appStatus) {
        if (appStatus == null) {
            return a();
        }
        int i = AnonymousClass1.f8059a[appStatus.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                return this.installingStyle;
            }
            if (i != 4) {
                return a();
            }
        }
        return this.processingStyle;
    }

    public Drawable getCancelBtnDrawable() {
        return this.cancelBtnDrawable;
    }

    public static class Style {
        protected Drawable background;
        protected int textColor;
        protected int textSize = 12;

        public void setTextSize(int i) {
            this.textSize = i;
        }

        public void setTextColor(int i) {
            this.textColor = i;
        }

        public void setBackground(Drawable drawable) {
            this.background = drawable;
        }

        public int getTextSize() {
            return this.textSize;
        }

        public int getTextColor() {
            return this.textColor;
        }

        public Drawable getBackground() {
            return this.background;
        }
    }

    public int e() {
        return ar.n(this.b) ? 28 : 18;
    }

    public Style d() {
        return this.f8058a;
    }

    public Style c() {
        return this.cancelBtnStyle;
    }

    public Style b() {
        return this.processingStyle;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.openalliance.ad.views.AppDownloadButtonStyle.Style a(android.content.Context r2, com.huawei.openalliance.ad.download.app.AppStatus r3, int r4) {
        /*
            r1 = this;
            if (r3 != 0) goto L7
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r2 = r1.a()
            return r2
        L7:
            r0 = 11
            if (r4 != r0) goto L27
            int[] r4 = com.huawei.openalliance.ad.views.AppDownloadButtonStyle.AnonymousClass1.f8059a
            int r0 = r3.ordinal()
            r4 = r4[r0]
            r0 = 1
            if (r4 == r0) goto L22
            r0 = 2
            if (r4 == r0) goto L22
            r0 = 3
            if (r4 == r0) goto L1d
            goto L27
        L1d:
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r4 = r1.d()
            goto L28
        L22:
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r4 = r1.a()
            goto L28
        L27:
            r4 = 0
        L28:
            if (r4 != 0) goto L2e
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r4 = r1.getStyle(r2, r3)
        L2e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.AppDownloadButtonStyle.a(android.content.Context, com.huawei.openalliance.ad.download.app.AppStatus, int):com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style");
    }

    public Style a() {
        return this.normalStyle;
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.views.AppDownloadButtonStyle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8059a;

        static {
            int[] iArr = new int[AppStatus.values().length];
            f8059a = iArr;
            try {
                iArr[AppStatus.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8059a[AppStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8059a[AppStatus.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8059a[AppStatus.WAITING_FOR_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8059a[AppStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8059a[AppStatus.DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8059a[AppStatus.INSTALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public AppDownloadButtonStyle(Context context) {
        this.b = context;
        this.normalStyle.background = context.getResources().getDrawable(R.drawable._2131428662_res_0x7f0b0536);
        this.normalStyle.textColor = context.getResources().getColor(R.color._2131298025_res_0x7f0906e9);
        this.processingStyle.setBackground(Cdo.b(context, R.drawable._2131428664_res_0x7f0b0538));
        this.processingStyle.setTextColor(context.getResources().getColor(R.color._2131297994_res_0x7f0906ca));
        this.installingStyle.setBackground(context.getResources().getDrawable(R.drawable._2131428660_res_0x7f0b0534));
        this.installingStyle.setTextColor(context.getResources().getColor(R.color._2131297988_res_0x7f0906c4));
        this.f8058a.setBackground(context.getResources().getDrawable(R.drawable._2131428737_res_0x7f0b0581));
        this.f8058a.setTextColor(context.getResources().getColor(R.color._2131298034_res_0x7f0906f2));
        this.cancelBtnDrawable = context.getResources().getDrawable(R.drawable._2131428666_res_0x7f0b053a);
    }

    public AppDownloadButtonStyle() {
    }
}
