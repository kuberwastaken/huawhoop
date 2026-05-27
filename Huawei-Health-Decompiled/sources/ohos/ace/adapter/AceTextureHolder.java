package ohos.ace.adapter;

import android.graphics.SurfaceTexture;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class AceTextureHolder {
    private static final String LOG_TAG = "AceTextureHolder";
    private static final Map<Long, SurfaceTexture> surfaceTextureMap = new ConcurrentHashMap();

    public static SurfaceTexture getSurfaceTexture(long j) {
        ALog.i(LOG_TAG, "getSurfaceTexture");
        return surfaceTextureMap.get(Long.valueOf(j));
    }

    public static void addSurfaceTexture(long j, SurfaceTexture surfaceTexture) {
        ALog.i(LOG_TAG, "addSurfaceTexture");
        surfaceTextureMap.put(Long.valueOf(j), surfaceTexture);
    }

    public static void removeSurfaceTexture(long j) {
        ALog.i(LOG_TAG, "removeSurfaceTexture");
        surfaceTextureMap.remove(Long.valueOf(j));
    }
}
