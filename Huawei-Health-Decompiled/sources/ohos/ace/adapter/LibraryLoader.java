package ohos.ace.adapter;

import android.os.Trace;

/* JADX INFO: loaded from: classes11.dex */
public final class LibraryLoader {
    private static final String ANDROID_LIB_NAME = "arkui_android";
    private static final Object JNI_LOAD_LOCK = new Object();
    private static final String LOG_TAG = "LibraryLoader";
    private static volatile boolean jniLoaded = false;

    private LibraryLoader() {
    }

    public static boolean isJniLoaded() {
        return jniLoaded;
    }

    private static boolean loadAndroidJniLibrary() {
        try {
            Trace.beginSection("loadJniLibrary");
            ALog.i(LOG_TAG, "Load android ace lib");
            System.loadLibrary(ANDROID_LIB_NAME);
            Trace.endSection();
            jniLoaded = true;
            return true;
        } catch (UnsatisfiedLinkError e) {
            ALog.e(LOG_TAG, "Could not load android ace lib. Exception:" + e.getMessage());
            Trace.endSection();
            return false;
        }
    }

    static boolean loadJniLibrary() {
        if (jniLoaded) {
            ALog.i(LOG_TAG, "Has loaded ace lib");
            return true;
        }
        synchronized (JNI_LOAD_LOCK) {
            if (jniLoaded) {
                ALog.i(LOG_TAG, "Has loaded ace lib");
                return true;
            }
            ALog.i(LOG_TAG, "Load ace lib");
            jniLoaded = loadAndroidJniLibrary();
            return jniLoaded;
        }
    }
}
