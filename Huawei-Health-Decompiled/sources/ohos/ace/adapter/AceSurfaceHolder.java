package ohos.ace.adapter;

import android.view.Surface;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class AceSurfaceHolder {
    private static final String LOG_TAG = "AceSurfaceHolder";
    private static final HashMap<Integer, Map<Long, Surface>> surfaceMap = new HashMap<>();

    public static Surface getSurface(int i, long j) {
        HashMap<Integer, Map<Long, Surface>> map = surfaceMap;
        if (map.containsKey(Integer.valueOf(i))) {
            return map.get(Integer.valueOf(i)).get(Long.valueOf(j));
        }
        return null;
    }

    public static void addSurface(int i, long j, Surface surface) {
        HashMap<Integer, Map<Long, Surface>> map = surfaceMap;
        if (map.containsKey(Integer.valueOf(i))) {
            map.get(Integer.valueOf(i)).put(Long.valueOf(j), surface);
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(Long.valueOf(j), surface);
        map.put(Integer.valueOf(i), map2);
    }

    public static void removeSurface(int i, long j) {
        HashMap<Integer, Map<Long, Surface>> map = surfaceMap;
        if (map.containsKey(Integer.valueOf(i))) {
            Map<Long, Surface> map2 = map.get(Integer.valueOf(i));
            map2.remove(Long.valueOf(j));
            if (map2.isEmpty()) {
                map.remove(Integer.valueOf(i));
            }
        }
    }
}
