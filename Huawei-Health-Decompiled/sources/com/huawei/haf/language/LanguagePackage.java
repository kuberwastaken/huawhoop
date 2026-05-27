package com.huawei.haf.language;

import android.text.TextUtils;
import com.huawei.haf.bundle.AppBundleBuildConfig;
import com.huawei.haf.download.DownloadPluginCallback;
import com.huawei.openalliance.ad.constant.Constants;
import health.compact.a.BuildConfigProperties;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LanguagePackage {
    static final boolean b;
    static final boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LanguagePlugin f2159a;
    private final LanguageInfo c;

    static {
        b = AppBundleBuildConfig.m() || BuildConfigProperties.e("SUPPORT_STORE_LANGUAGE", false);
        d = BuildConfigProperties.e("SUPPORT_CLOUD_LANGUAGE", false);
    }

    public LanguagePackage(LanguagePlugin languagePlugin) {
        this(null, languagePlugin);
    }

    public LanguagePackage(LanguageInfo languageInfo, LanguagePlugin languagePlugin) {
        this.c = languageInfo == null ? DefaultLanguageInfo.a() : languageInfo;
        this.f2159a = languagePlugin;
    }

    public boolean c() {
        return this.f2159a != null;
    }

    public LanguageInfo b() {
        return this.c;
    }

    public int a(List<String> list, int i, DownloadPluginCallback downloadPluginCallback) {
        LanguagePlugin languagePlugin = this.f2159a;
        if (languagePlugin != null) {
            return languagePlugin.startUpdateTask(list, i, downloadPluginCallback);
        }
        return 0;
    }

    public File c(String str) {
        LanguagePlugin languagePlugin = this.f2159a;
        if (languagePlugin != null) {
            return languagePlugin.getPluginFile(str);
        }
        return null;
    }

    public void a(String str) {
        LanguagePlugin languagePlugin = this.f2159a;
        if (languagePlugin == null) {
            return;
        }
        if (this.c instanceof DefaultLanguageInfo) {
            if (TextUtils.isEmpty(str)) {
                str = this.f2159a.getVersion();
            }
            this.f2159a.deleteExpiredPlugins(new OtherLanguagePackageFilter(this.c.getAllLanguageUuid(false), str));
            return;
        }
        languagePlugin.deleteExpiredPlugins(null);
    }

    public String d(String str, Locale locale) {
        StringBuilder sb = new StringBuilder(32);
        sb.append("language-");
        sb.append(this.c.getLanguageName(str, locale));
        sb.append(".lpk");
        return sb.toString();
    }

    static class OtherLanguagePackageFilter implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2160a;
        private final int b;
        private final String c;
        private final Collection<String> d;

        OtherLanguagePackageFilter(Collection<String> collection, String str) {
            this.f2160a = str;
            this.c = Constants.LINK + str;
            this.d = collection;
            this.b = collection.isEmpty() ? 0 : collection.iterator().next().length();
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (this.b <= 0 || str == null) {
                return false;
            }
            int length = str.length();
            int i = this.b;
            if (length <= i) {
                if (str.startsWith(this.f2160a, 15)) {
                    return false;
                }
                return str.startsWith(LanguagePlugin.INDEX_LANGUAGE_DIR);
            }
            if (str.startsWith(this.c, i)) {
                return false;
            }
            return this.d.contains(str.substring(0, this.b));
        }
    }
}
