package defpackage;

import com.huawei.health.device.kit.wsp.task.BleTaskQueueUtil;
import com.huawei.operation.ble.BleConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class ddy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UUID f12202a;
    public static final UUID aa;
    public static final UUID ab;
    public static final UUID ac;
    public static final UUID ad;
    public static final UUID ae;
    public static final UUID af;
    public static final Set<String> ag;
    public static final UUID ah;
    public static final UUID ai;
    public static final UUID aj;
    public static final UUID ak;
    public static final UUID al;
    public static final UUID am;
    public static final UUID an;
    public static final UUID ao;
    public static final UUID ap;
    public static final Set<String> aq;
    public static final UUID ar;
    public static final UUID as;
    private static Map<BleTaskQueueUtil.TaskType, d> at;
    private static Map<UUID, Integer> au;
    public static final UUID av;
    public static final UUID aw;
    public static final UUID ax;
    public static final UUID b;
    public static final UUID c;
    public static final UUID d;
    public static final UUID e;
    public static final UUID f;
    public static final UUID g;
    public static final UUID h;
    public static final UUID i;
    public static final UUID j;
    public static final UUID k;
    public static final UUID l;
    public static final UUID m;
    public static final UUID n;
    public static final UUID o;
    public static final UUID p;
    public static final UUID q;
    public static final UUID r;
    public static final UUID s;
    public static final UUID t;
    public static final UUID u;
    public static final UUID v;
    public static final UUID w;
    public static final UUID x;
    public static final UUID y;
    public static final UUID z;

    static {
        UUID uuidFromString = UUID.fromString("0000181c-0000-1000-8000-00805f9b34fb");
        ap = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00002a80-0000-1000-8000-00805f9b34fb");
        b = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("00002a8c-0000-1000-8000-00805f9b34fb");
        n = uuidFromString3;
        UUID uuidFromString4 = UUID.fromString("00002a8e-0000-1000-8000-00805f9b34fb");
        s = uuidFromString4;
        UUID uuidFromString5 = UUID.fromString("02b2a08e-f8b0-4047-b1fd-f4e0efeee679");
        r = uuidFromString5;
        UUID uuidFromString6 = UUID.fromString("32330a04-15d9-421a-91c5-2a2d5c7525c9");
        f12202a = uuidFromString6;
        UUID uuidFromString7 = UUID.fromString("a3d330f8-b84f-4f48-a78c-f8d1e33b597a");
        aa = uuidFromString7;
        UUID uuidFromString8 = UUID.fromString("42596cbe-d291-4da3-8ca6-d1ae5d1c9174");
        c = uuidFromString8;
        UUID uuidFromString9 = UUID.fromString("8cc61d7d-66c0-4802-89c3-38c5a163592e");
        ad = uuidFromString9;
        m = UUID.fromString("4338c65e-ed8e-4085-bbea-a25e33ca6b54");
        y = UUID.fromString("3a3a7d71-37f6-4b94-b44a-21ac1916ac4f");
        g = UUID.fromString("2acf269d-6dae-4a64-98a4-dbf98c2e66c4");
        UUID uuidFromString10 = UUID.fromString("319d46ad-df02-4be5-b80f-6aa6f9c69329");
        f = uuidFromString10;
        i = UUID.fromString("4599778a-ea8a-4ffe-9499-de1ba7a03f3a");
        j = UUID.fromString("7749db19-9db5-4430-b6e2-5fcfb3f5b988");
        t = UUID.fromString("78bdadc1-5cae-4ec4-8832-21a020b1080b");
        UUID uuidFromString11 = UUID.fromString("00001805-0000-1000-8000-00805f9b34fb");
        ak = uuidFromString11;
        UUID uuidFromString12 = UUID.fromString("00002a2b-0000-1000-8000-00805f9b34fb");
        h = uuidFromString12;
        l = UUID.fromString("75143e79-f878-4a00-a628-edc40509de7e");
        e = UUID.fromString("426f058d-8211-413e-8320-397a890a08bf");
        k = UUID.fromString("1f5d3d5c-496d-4290-af03-c7a8d5419741");
        z = UUID.fromString("11872f15-a91d-49da-ac89-5107284f3425");
        o = UUID.fromString("7e6dbc73-42e7-45b9-a6ec-6aa2d7834695");
        UUID uuidFromString13 = UUID.fromString("0000181d-0000-1000-8000-00805f9b34fb");
        as = uuidFromString13;
        UUID uuidFromString14 = UUID.fromString("00002a9d-0000-1000-8000-00805f9b34fb");
        ab = uuidFromString14;
        UUID uuidFromString15 = UUID.fromString("0000181b-0000-1000-8000-00805f9b34fb");
        al = uuidFromString15;
        UUID uuidFromString16 = UUID.fromString("00002a9c-0000-1000-8000-00805f9b34fb");
        d = uuidFromString16;
        af = UUID.fromString("46797c17-d639-488d-9476-4789e8472878");
        ae = UUID.fromString("0212f42a-5f19-4bc1-ba52-d7ec7ccb71a4");
        ac = UUID.fromString(BleConstants.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
        p = UUID.fromString("bfc36f6e-4150-4a4b-9052-3d359e52962e");
        am = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
        x = UUID.fromString("0000fff1-0000-1000-8000-00805f9b34fb");
        u = UUID.fromString("0000fff2-0000-1000-8000-00805f9b34fb");
        v = UUID.fromString("0000fff3-0000-1000-8000-00805f9b34fb");
        w = UUID.fromString("0000fff4-0000-1000-8000-00805f9b34fb");
        an = UUID.fromString("00001880-0000-1000-8000-00805f9b34fb");
        q = UUID.fromString("ba216311-1787-472b-bef6-3eb29e62293e");
        ax = UUID.fromString("e3c7a876-3307-414d-84f6-fbcd64710dc3");
        av = UUID.fromString("33ff0cad-834f-4e42-ab91-a0747856d574");
        ai = UUID.fromString("b4e384f2-d880-44e7-8c7e-5249239633b4");
        ao = UUID.fromString("0000fe86-0000-1000-8000-00805f9b34fb");
        ah = UUID.fromString("000018a1-0000-1000-8000-00805f9b34fb");
        aj = UUID.fromString("000018a0-0000-1000-8000-00805f9b34fb");
        aw = UUID.fromString("0000fe01-0000-1000-8000-00805f9b34fb");
        ar = UUID.fromString("0000fe02-0000-1000-8000-00805f9b34fb");
        ag = Collections.unmodifiableSet(new HashSet<String>() { // from class: ddy.5
            {
                add(ddy.q.toString());
                add(ddy.am.toString());
                add(ddy.x.toString());
                add(ddy.v.toString());
                add(ddy.ae.toString());
                add(ddy.ar.toString());
            }
        });
        aq = Collections.unmodifiableSet(new HashSet<String>() { // from class: ddy.3
            {
                add(ddy.q.toString());
                add(ddy.av.toString());
                add(ddy.ai.toString());
                add(ddy.y.toString());
                add(ddy.g.toString());
                add(ddy.aa.toString());
                add(ddy.x.toString());
                add(ddy.u.toString());
                add(ddy.v.toString());
                add(ddy.w.toString());
                add(ddy.i.toString());
                add(ddy.j.toString());
                add(ddy.z.toString());
                add(ddy.o.toString());
                add(ddy.l.toString());
                add(ddy.ad.toString());
                add(ddy.h.toString());
                add(ddy.e.toString());
                add(ddy.f.toString());
                add(ddy.ah.toString());
            }
        });
        HashMap<BleTaskQueueUtil.TaskType, d> map = new HashMap<BleTaskQueueUtil.TaskType, d>(16) { // from class: ddy.4
            public static final long serialVersionUID = -5758607221325354320L;

            {
                put(BleTaskQueueUtil.TaskType.GET_MANAGER_INFO, new d(ddy.ap, ddy.m));
                put(BleTaskQueueUtil.TaskType.SET_MANAGER_INFO, new d(ddy.ap, ddy.y));
                put(BleTaskQueueUtil.TaskType.SEND_HILINK_CONFIG_INFO, new d(ddy.ap, ddy.g));
                put(BleTaskQueueUtil.TaskType.SEND_DEVICE_RESET, new d(ddy.ap, ddy.i));
                put(BleTaskQueueUtil.TaskType.SEND_DELETE_USER_DATA, new d(ddy.ap, ddy.j));
                put(BleTaskQueueUtil.TaskType.SEND_GET_USER_DATA, new d(ddy.ap, ddy.t));
                put(BleTaskQueueUtil.TaskType.GET_DEVICE_SSID, new d(ddy.ak, ddy.l));
                put(BleTaskQueueUtil.TaskType.GET_ALLOW_RESET_WIFI, new d(ddy.ak, ddy.e));
                put(BleTaskQueueUtil.TaskType.GET_WEIGHT_REAL_TIME_DATA, new d(ddy.al, ddy.af));
                put(BleTaskQueueUtil.TaskType.REQUEST_OTA_UPGRADE, new d(ddy.am, ddy.x));
                put(BleTaskQueueUtil.TaskType.OTA_UPGRADE_SHA_CHECK, new d(ddy.am, ddy.u));
                put(BleTaskQueueUtil.TaskType.SEND_OTA_PACKAGE_DATA, new d(ddy.am, ddy.v));
                put(BleTaskQueueUtil.TaskType.GET_OTA_UPGRADE_RESULT, new d(ddy.am, ddy.w));
                put(BleTaskQueueUtil.TaskType.GET_SCALE_VERSION, new d(ddy.ak, ddy.k));
                put(BleTaskQueueUtil.TaskType.GET_WEIGHT_HISTORY_DATA, new d(ddy.al, ddy.ae));
                put(BleTaskQueueUtil.TaskType.SET_WEIGHT_UNIT, new d(ddy.ak, ddy.z));
                put(BleTaskQueueUtil.TaskType.GET_WEIGHT_UNIT, new d(ddy.ak, ddy.o));
                put(BleTaskQueueUtil.TaskType.SEND_WAKE_UP, new d(ddy.ak, ddy.ax));
                put(BleTaskQueueUtil.TaskType.SEND_SSID, new d(ddy.ak, ddy.av));
                put(BleTaskQueueUtil.TaskType.SEND_WIFI_PASSWORD, new d(ddy.ak, ddy.ai));
                put(BleTaskQueueUtil.TaskType.OPEN_STATUS, new d(ddy.ak, ddy.q));
                put(BleTaskQueueUtil.TaskType.WRITE_BLE_FILE, new d(ddy.ao, ddy.aw));
                put(BleTaskQueueUtil.TaskType.NOTIFY_BLE_FILE, new d(ddy.ao, ddy.ar));
                put(BleTaskQueueUtil.TaskType.SEND_OTA_URL, new d(ddy.aj, ddy.ah));
            }
        };
        at = map;
        map.put(BleTaskQueueUtil.TaskType.SET_AGE, new d(uuidFromString, uuidFromString2));
        at.put(BleTaskQueueUtil.TaskType.SET_GENDER, new d(uuidFromString, uuidFromString3));
        at.put(BleTaskQueueUtil.TaskType.SET_HEIGHT, new d(uuidFromString, uuidFromString4));
        at.put(BleTaskQueueUtil.TaskType.SET_SYNC_TIME, new d(uuidFromString11, uuidFromString12));
        at.put(BleTaskQueueUtil.TaskType.ENABLE_WEIGHT_SCALE, new d(uuidFromString13, uuidFromString14));
        at.put(BleTaskQueueUtil.TaskType.ENABLE_BODY_MEASUREMENT, new d(uuidFromString15, uuidFromString16));
        at.put(BleTaskQueueUtil.TaskType.REQUEST_AUTH, new d(uuidFromString, uuidFromString5));
        at.put(BleTaskQueueUtil.TaskType.AUTH_TOKEN, new d(uuidFromString, uuidFromString6));
        at.put(BleTaskQueueUtil.TaskType.SEND_WORK_KEY, new d(uuidFromString, uuidFromString7));
        at.put(BleTaskQueueUtil.TaskType.BIND_REQUEST, new d(uuidFromString, uuidFromString8));
        at.put(BleTaskQueueUtil.TaskType.SET_USER_INFO, new d(uuidFromString, uuidFromString9));
        at.put(BleTaskQueueUtil.TaskType.SEND_HILINK_CONFIG_INFO_ENCRYPTED, new d(uuidFromString, uuidFromString10));
        au = new HashMap<UUID, Integer>(16) { // from class: ddy.2
            public static final long serialVersionUID = -5753607221225351370L;

            {
                put(ddy.b, Integer.valueOf(BleTaskQueueUtil.TaskType.SET_AGE.ordinal()));
                put(ddy.n, Integer.valueOf(BleTaskQueueUtil.TaskType.SET_GENDER.ordinal()));
                put(ddy.s, Integer.valueOf(BleTaskQueueUtil.TaskType.SET_HEIGHT.ordinal()));
                put(ddy.h, Integer.valueOf(BleTaskQueueUtil.TaskType.SET_SYNC_TIME.ordinal()));
                put(ddy.ab, Integer.valueOf(BleTaskQueueUtil.TaskType.ENABLE_WEIGHT_SCALE.ordinal()));
                put(ddy.d, Integer.valueOf(BleTaskQueueUtil.TaskType.ENABLE_BODY_MEASUREMENT.ordinal()));
                put(ddy.r, Integer.valueOf(BleTaskQueueUtil.TaskType.REQUEST_AUTH.ordinal()));
                put(ddy.f12202a, Integer.valueOf(BleTaskQueueUtil.TaskType.AUTH_TOKEN.ordinal()));
                put(ddy.aa, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_WORK_KEY.ordinal()));
                put(ddy.c, Integer.valueOf(BleTaskQueueUtil.TaskType.BIND_REQUEST.ordinal()));
                put(ddy.ad, Integer.valueOf(BleTaskQueueUtil.TaskType.SET_USER_INFO.ordinal()));
                put(ddy.m, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_MANAGER_INFO.ordinal()));
                put(ddy.y, Integer.valueOf(BleTaskQueueUtil.TaskType.SET_MANAGER_INFO.ordinal()));
                put(ddy.g, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_HILINK_CONFIG_INFO.ordinal()));
                put(ddy.i, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_DEVICE_RESET.ordinal()));
                put(ddy.j, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_DELETE_USER_DATA.ordinal()));
                put(ddy.t, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_GET_USER_DATA.ordinal()));
                put(ddy.l, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_DEVICE_SSID.ordinal()));
                put(ddy.e, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_ALLOW_RESET_WIFI.ordinal()));
                put(ddy.af, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_WEIGHT_REAL_TIME_DATA.ordinal()));
                put(ddy.x, Integer.valueOf(BleTaskQueueUtil.TaskType.REQUEST_OTA_UPGRADE.ordinal()));
                put(ddy.u, Integer.valueOf(BleTaskQueueUtil.TaskType.OTA_UPGRADE_SHA_CHECK.ordinal()));
                put(ddy.v, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_OTA_PACKAGE_DATA.ordinal()));
                put(ddy.w, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_OTA_UPGRADE_RESULT.ordinal()));
                put(ddy.k, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_SCALE_VERSION.ordinal()));
                put(ddy.ae, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_WEIGHT_HISTORY_DATA.ordinal()));
                put(ddy.z, Integer.valueOf(BleTaskQueueUtil.TaskType.SET_WEIGHT_UNIT.ordinal()));
                put(ddy.o, Integer.valueOf(BleTaskQueueUtil.TaskType.GET_WEIGHT_UNIT.ordinal()));
                put(ddy.aw, Integer.valueOf(BleTaskQueueUtil.TaskType.WRITE_BLE_FILE.ordinal()));
                put(ddy.f, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_HILINK_CONFIG_INFO_ENCRYPTED.ordinal()));
                put(ddy.ah, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_OTA_URL.ordinal()));
                put(ddy.ax, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_WAKE_UP.ordinal()));
                put(ddy.av, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_SSID.ordinal()));
                put(ddy.ai, Integer.valueOf(BleTaskQueueUtil.TaskType.SEND_WIFI_PASSWORD.ordinal()));
                put(ddy.q, Integer.valueOf(BleTaskQueueUtil.TaskType.OPEN_STATUS.ordinal()));
                put(ddy.ar, Integer.valueOf(BleTaskQueueUtil.TaskType.NOTIFY_BLE_FILE.ordinal()));
            }
        };
    }

    public static Map<UUID, Integer> a() {
        return au;
    }

    public static Map<BleTaskQueueUtil.TaskType, d> d() {
        return at;
    }

    public static UUID d(UUID uuid) {
        Integer num = au.get(uuid);
        BleTaskQueueUtil.TaskType[] taskTypeArrValues = BleTaskQueueUtil.TaskType.values();
        if (taskTypeArrValues == null || taskTypeArrValues.length <= num.intValue()) {
            return null;
        }
        return at.get(taskTypeArrValues[num.intValue()]).c();
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private UUID f12203a;
        private UUID b;

        d(UUID uuid, UUID uuid2) {
            this.f12203a = uuid;
            this.b = uuid2;
        }

        public UUID c() {
            return this.f12203a;
        }

        public UUID a() {
            return this.b;
        }
    }
}
