package defpackage;

import com.huawei.android.airsharing.api.IEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class fhw {
    public static final List<Integer> d = Collections.unmodifiableList(new ArrayList<Integer>() { // from class: fhw.1
        {
            add(3016);
            add(3017);
            add(3018);
            add(3019);
            add(3020);
            add(3042);
            add(3023);
            add(3024);
            add(3026);
            add(3027);
            add(3043);
            add(3044);
        }
    });
    public static final List<Integer> c = Collections.unmodifiableList(new ArrayList<Integer>() { // from class: fhw.3
        {
            addAll(fhw.d);
            add(3001);
            add(3002);
            add(3003);
            add(3004);
        }
    });
    public static final Map<Integer, Integer> b = Collections.unmodifiableMap(new HashMap<Integer, Integer>() { // from class: fhw.4
        {
            put(Integer.valueOf(IEventListener.EVENT_ID_DEVICE_DLNA_CONN_SUCC), 3036);
            put(Integer.valueOf(IEventListener.EVENT_ID_DEVICE_REQUEST_CONN), 3037);
            put(Integer.valueOf(IEventListener.EVENT_ID_DEVICE_UPDATE), 3033);
            put(3010, 3035);
            put(Integer.valueOf(IEventListener.EVENT_ID_GRAB_STATE_CHANGED), 3035);
            put(3009, 3034);
            put(Integer.valueOf(IEventListener.EVENT_ID_DEVICE_REQUEST_PLAY), 3038);
            put(3031, 3040);
        }
    });
}
