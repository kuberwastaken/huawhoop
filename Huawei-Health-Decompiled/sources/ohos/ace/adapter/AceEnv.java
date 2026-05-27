package ohos.ace.adapter;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes11.dex */
public final class AceEnv {
    public static final int ACE_PLATFORM_ANDROID = 0;
    private static volatile AceEnv INSTANCE = null;
    private static final Object INSTANCE_LOCK = new Object();
    private static final String LOG_TAG = "AceEnv";
    private boolean isLoadSuccess;

    private AceEnv() {
        this.isLoadSuccess = false;
        ALog.i(LOG_TAG, "AceEnv init start.");
        boolean zLoadJniLibrary = LibraryLoader.loadJniLibrary();
        this.isLoadSuccess = zLoadJniLibrary;
        if (zLoadJniLibrary) {
            return;
        }
        ALog.e(LOG_TAG, "LoadLibrary failed");
    }

    public static AceEnv getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (INSTANCE_LOCK) {
            if (INSTANCE != null) {
                return INSTANCE;
            }
            INSTANCE = new AceEnv();
            return INSTANCE;
        }
    }

    public void setLibraryLoaded() {
        this.isLoadSuccess = true;
    }

    public boolean isLibraryLoaded() {
        return this.isLoadSuccess;
    }

    public static void dump(int i, String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        DumpHelper.dump(i, str, fileDescriptor, printWriter, strArr);
    }
}
