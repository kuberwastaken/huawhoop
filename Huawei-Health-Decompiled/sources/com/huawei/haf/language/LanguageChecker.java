package com.huawei.haf.language;

import com.huawei.haf.download.DownloadPluginCallback;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LanguageChecker {
    private static final String c = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f2155a;
    private boolean b;
    private Map<String, String> d;
    private final LanguagePackage e;
    private Map<String, String> g;

    class CheckDownloadPluginCallback implements DownloadPluginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f2156a;
        final /* synthetic */ LanguageChecker b;
        private final DownloadPluginCallback c;

        @Override // com.huawei.haf.download.DownloadPluginCallback
        public boolean onDownloadPluginResult(int i, String str, int i2) {
            if (this.f2156a != this.b.b) {
                return false;
            }
            String strD = this.b.e.d(str, null);
            if (i2 == 0) {
                File fileC = this.b.e.c(str);
                if (fileC != null) {
                    this.b.g.put(str, fileC.getName());
                } else {
                    this.b.f2155a.put(str, strD);
                }
            } else {
                this.b.d.put(str, strD);
            }
            this.c.onDownloadPluginResult(i, str, i2);
            return true;
        }

        @Override // com.huawei.haf.download.DownloadPluginCallback
        public void startDownloadProgress(int i) {
            if (this.f2156a != this.b.b) {
                return;
            }
            this.c.startDownloadProgress(i);
        }

        @Override // com.huawei.haf.download.DownloadPluginCallback
        public void showDownloadProgress(int i, int i2, int i3) {
            if (this.f2156a != this.b.b) {
                return;
            }
            this.c.showDownloadProgress(i, i2, i3);
        }

        @Override // com.huawei.haf.download.DownloadPluginCallback
        public void onDownloadResult(int i, int i2) {
            if (this.f2156a != this.b.b) {
                return;
            }
            this.c.onDownloadResult(i, i2);
        }
    }
}
