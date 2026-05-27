package androidx.work.impl;

import android.content.Context;
import com.huawei.openalliance.ad.constant.ParamConstants;
import defpackage.xkd;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/Api21Impl;", "", "()V", "getNoBackupFilesDir", "Ljava/io/File;", ParamConstants.Param.CONTEXT, "Landroid/content/Context;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Api21Impl {
    public static final Api21Impl INSTANCE = new Api21Impl();

    private Api21Impl() {
    }

    public final File getNoBackupFilesDir(Context context) {
        xkd.d(context, "");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        xkd.a(noBackupFilesDir, "");
        return noBackupFilesDir;
    }
}
