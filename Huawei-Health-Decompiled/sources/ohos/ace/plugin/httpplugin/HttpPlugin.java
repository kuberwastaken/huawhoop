package ohos.ace.plugin.httpplugin;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class HttpPlugin {
    private static final String FIRE_NAME = "/cache.json";
    private static final String LOG_TAG = "Context is null";
    private final Context context_;

    protected native void nativeInit();

    public HttpPlugin(Context context) {
        this.context_ = context;
        nativeInit();
    }

    public String getCacheDir() throws IOException {
        Context context = this.context_;
        if (context == null) {
            return LOG_TAG;
        }
        String str = context.getCacheDir().getPath() + FIRE_NAME;
        File file = new File(str);
        if (file.exists()) {
            return str;
        }
        file.createNewFile();
        return str;
    }
}
