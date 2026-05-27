package defpackage;

import com.huawei.health.device.model.HealthDevice;
import com.huawei.hihealth.CharacteristicConstant;
import com.huawei.hihealthservice.old.model.OldToNewMotionPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class gmb {
    public static Map e = new HashMap();
    public static Map d = new HashMap();
    public static List b = new ArrayList();
    public static List c = new ArrayList();

    static {
        e.put(264, HealthDevice.HealthDeviceKind.HDK_TREADMILL);
        Map map = e;
        Integer numValueOf = Integer.valueOf(OldToNewMotionPath.SPORT_TYPE_INDOOR_BIKE);
        map.put(numValueOf, HealthDevice.HealthDeviceKind.HDK_EXERCISE_BIKE);
        Map map2 = e;
        Integer numValueOf2 = Integer.valueOf(OldToNewMotionPath.SPORT_TYPE_ROW_MACHINE);
        map2.put(numValueOf2, HealthDevice.HealthDeviceKind.HDK_ROWING_MACHINE);
        Map map3 = e;
        Integer numValueOf3 = Integer.valueOf(OldToNewMotionPath.SPORT_TYPE_CROSS_TRAINER);
        map3.put(numValueOf3, HealthDevice.HealthDeviceKind.HDK_ELLIPTICAL_MACHINE);
        d.put(264, Integer.valueOf(CharacteristicConstant.DeviceType.TYPE_TREADMILL_INDEX.getDeviceTypeValue()));
        d.put(numValueOf, Integer.valueOf(CharacteristicConstant.DeviceType.TYPE_INDOORBIKE_INDEX.getDeviceTypeValue()));
        d.put(numValueOf2, Integer.valueOf(CharacteristicConstant.DeviceType.TYPE_ROWER_INDEX.getDeviceTypeValue()));
        d.put(numValueOf3, Integer.valueOf(CharacteristicConstant.DeviceType.TYPE_CROSSTRAINER_INDEX.getDeviceTypeValue()));
        b.add(Integer.valueOf(OldToNewMotionPath.SPORT_TYPE_OTHER_SPORT));
        c.add(257);
        c.add(258);
        c.add(259);
    }
}
