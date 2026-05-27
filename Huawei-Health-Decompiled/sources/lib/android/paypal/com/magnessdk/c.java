package lib.android.paypal.com.magnessdk;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.huawei.health.suggestion.model.FitRunPlayAudio;
import com.huawei.hms.network.embedded.w9;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.openalliance.ad.constant.MapKeyNames;
import com.huawei.operation.ble.BleConstants;
import com.huawei.ui.main.stories.recommendcloud.constants.RecommendConstants;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    public static class f {
        public static final String[] c = {"com.bignox.appcenter", "com.bluestacks.settings", "com.bluestacks.filemanager", "com.genymotion.superuser", "org.greatfruit.andy.ime", "com.kaopu001.tiantianserver", "com.tiantian.ime", "com.microvirt.installer", "com.android.ld.appstore", "com.ldmnq.launcher3", "com.jide.Appstore"};
        public static final String[] b = {"init.android_x86.rc", "ueventd.android_x86.rc", "fstab.android_x86", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc", "ueventd.android_x86_64.rc", "init.android_x86_64.rc", "fstab.goldfish", "init.goldfish.rc", "init.superuser.rc"};
        public static final String[] e = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props"};
        public static final String[] d = {"/dev/socket/qemud", "/dev/qemu_pipe"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f15194a = {"goldfish"};
        public static final String[] f = {"init.ranchu.rc", "init.remixos.rc", "init.andy.rc", "ueventd.andy.rc", "bin/genybaseband", "bin/genymotion-vbox-sf", "ueventd.nox.rc", "init.nox.rc", "/system/bin/noxd"};
    }

    public enum n {
        TOUCH_EVENT(w9.m),
        FORCE("f"),
        RADIUS("r"),
        TOUCH_LOCATION_X("x"),
        TOUCH_LOCATION_Y("y"),
        TOUCH_COUNT("tc"),
        START_TIME(CmcdConfiguration.KEY_STREAM_TYPE),
        END_TIME("et"),
        MAXIMUM_PRECISION("10000000d"),
        UNINITIALIZED_TIME("-1000"),
        MAXIMUM_EVENT_COUNT("400"),
        MAXIMUM_TIME_ALLOWED("5000"),
        MAXIMUM_TOUCH_COUNT("5");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15208a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15208a;
        }

        public String d() {
            return this.f15208a;
        }

        public long c() {
            return Long.parseLong(this.f15208a);
        }

        public int b() {
            return Integer.parseInt(this.f15208a);
        }

        public double a() {
            return Double.parseDouble(this.f15208a);
        }

        n(String str) {
            this.f15208a = str;
        }
    }

    public enum h {
        NETWORKING("MagnesNetworking");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15196a;

        /* JADX INFO: renamed from: lib.android.paypal.com.magnessdk.c$h$c, reason: collision with other inner class name */
        public enum EnumC0336c {
            GET_REQUEST_STARTED(50),
            GET_REQUEST_ERROR(51),
            GET_REQUEST_SUCCEEDED(52),
            POST_REQUEST_STARTED(53),
            POST_REQUEST_ERROR(54),
            POST_REQUEST_SUCCEEDED(55),
            HTTP_STATUS_FAILED(-1),
            HTTP_STATUS_200(200);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f15199a;

            public int a() {
                return this.f15199a;
            }

            public static EnumC0336c a(int i) {
                EnumC0336c enumC0336c = GET_REQUEST_STARTED;
                if (i == enumC0336c.a()) {
                    return enumC0336c;
                }
                EnumC0336c enumC0336c2 = GET_REQUEST_ERROR;
                if (i == enumC0336c2.a()) {
                    return enumC0336c2;
                }
                EnumC0336c enumC0336c3 = GET_REQUEST_SUCCEEDED;
                if (i == enumC0336c3.a()) {
                    return enumC0336c3;
                }
                EnumC0336c enumC0336c4 = POST_REQUEST_STARTED;
                if (i == enumC0336c4.a()) {
                    return enumC0336c4;
                }
                EnumC0336c enumC0336c5 = POST_REQUEST_ERROR;
                if (i == enumC0336c5.a()) {
                    return enumC0336c5;
                }
                EnumC0336c enumC0336c6 = POST_REQUEST_SUCCEEDED;
                if (i == enumC0336c6.a()) {
                    return enumC0336c6;
                }
                EnumC0336c enumC0336c7 = HTTP_STATUS_FAILED;
                if (i == enumC0336c7.a()) {
                    return enumC0336c7;
                }
                EnumC0336c enumC0336c8 = HTTP_STATUS_200;
                if (i == enumC0336c8.a()) {
                    return enumC0336c8;
                }
                return null;
            }

            EnumC0336c(int i) {
                this.f15199a = i;
            }
        }

        public enum a {
            HTTP_CONNECT_TIMEOUT(60000),
            HTTP_READ_TIMEOUT(60000),
            READ_BYTE(1024);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f15197a;

            public int a() {
                return this.f15197a;
            }

            a(int i) {
                this.f15197a = i;
            }
        }

        public enum b {
            POST("POST"),
            GET("GET");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15198a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15198a;
            }

            b(String str) {
                this.f15198a = str;
            }
        }

        public enum d {
            AUDIT_JSON_URL("https://c.paypal.com/r/v1/device/mg-audit"),
            DEVICE_INFO_URL("https://c.paypal.com/r/v1/device/client-metadata"),
            PRODUCTION_BEACON_URL("https://b.stats.paypal.com/counter.cgi"),
            PRODUCTION_JSON_URL("https://c.paypal.com/r/v1/device/mg"),
            RAMP_CONFIG_URL("https://www.paypalobjects.com/rdaAssets/magnes/magnes_android_rac.json"),
            REMOTE_CONFIG_URL("https://www.paypalobjects.com/rdaAssets/magnes/magnes_android_rec.json"),
            SANDBOX_DEVICE_INFO_URL("https://c.sandbox.paypal.com/r/v1/device/client-metadata"),
            SANDBOX_AUDIT_JSON_URL("https://c.sandbox.paypal.com/r/v1/device/mg-audit"),
            SANDBOX_PROD_JSON_URL("https://c.sandbox.paypal.com/r/v1/device/mg-audit");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15200a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15200a;
            }

            d(String str) {
                this.f15200a = str;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f15196a;
        }

        h(String str) {
            this.f15196a = str;
        }
    }

    public enum k {
        KNOWN_ROOT_APPS_PACKAGES("com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk"),
        SU_PATHS("/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/system/xbin/daemonsu/", "/system/etc/init.d/99SuperSUDaemon/", "/system/bin/.ext/.su/", "/system/etc/.has_su_daemon/", "/system/etc/.installed_su_daemon/", "/cache/", "/data/", "/dev/");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f15203a;

        public enum b {
            NUMBER_OF_ROOTED_FLAGS(7),
            IS_TEST_KEYS_FOUND(0),
            IS_SU_FOUND(1),
            IS_SUPER_USER_APK_FOUND(2),
            DETECT_ROOT_MANAGEMENT_APPS(3),
            CHECK_FOR_BINARY_SU(4),
            CHECK_FOR_BINARY_BUSYBOX(5),
            CHECK_FOR_BINARY_MAGISK(6);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f15205a;

            public int a() {
                return this.f15205a;
            }

            public static b a(int i) {
                b bVar = IS_TEST_KEYS_FOUND;
                if (i == bVar.a()) {
                    return bVar;
                }
                b bVar2 = IS_SU_FOUND;
                if (i == bVar2.a()) {
                    return bVar2;
                }
                b bVar3 = IS_SUPER_USER_APK_FOUND;
                if (i == bVar3.a()) {
                    return bVar3;
                }
                b bVar4 = DETECT_ROOT_MANAGEMENT_APPS;
                if (i == bVar4.a()) {
                    return bVar4;
                }
                b bVar5 = CHECK_FOR_BINARY_SU;
                if (i == bVar5.a()) {
                    return bVar5;
                }
                b bVar6 = CHECK_FOR_BINARY_BUSYBOX;
                if (i == bVar6.a()) {
                    return bVar6;
                }
                b bVar7 = CHECK_FOR_BINARY_MAGISK;
                if (i == bVar7.a()) {
                    return bVar7;
                }
                return null;
            }

            b(int i) {
                this.f15205a = i;
            }
        }

        public enum a {
            SU(CmcdConfiguration.KEY_STARTUP),
            BUSYBOX("busybox"),
            MAGISK("magisk");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15204a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15204a;
            }

            a(String str) {
                this.f15204a = str;
            }
        }

        public String[] a() {
            return this.f15203a;
        }

        k(String... strArr) {
            this.f15203a = strArr;
        }
    }

    public static final class b {

        public enum a {
            MOBILE("MOBILE"),
            WIFI("WIFI"),
            VPN("VPN"),
            BLUETOOTH("Bluetooth Tethering"),
            WIFI_AWARE("WIFI AWARE"),
            LOWPAN("LOW PAN"),
            ETHERNET("Ethernet");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15179a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15179a;
            }

            a(String str) {
                this.f15179a = str;
            }
        }

        /* JADX INFO: renamed from: lib.android.paypal.com.magnessdk.c$b$b, reason: collision with other inner class name */
        public enum EnumC0330b {
            EXCEPTION("Network Setup Exception, Check PPNetworkEnvironment for details");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15180a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15180a;
            }

            EnumC0330b(String str) {
                this.f15180a = str;
            }
        }

        /* JADX INFO: renamed from: lib.android.paypal.com.magnessdk.c$b$c, reason: collision with other inner class name */
        public enum EnumC0331c {
            CMID_EXCEPTION_MESSAGE("PayPal-Client-Metadata-Id exceeds the maximum length allowed. This is your own unique identifier for the payload. If you do not pass in this value, a new PayPal-Client-Metadata-Id is generated per method call. ***Maximum length: 32 characters***"),
            APPGUID_EXCEPTION_MESSAGE("Application’s Globally Unique Identifier (AppGUID) does not match the criteria, This is a string that identifies the merchant application that sets up Magnes on the mobile device. If the merchant app does not pass an AppGuid, Magnes creates one to identify the app. An AppGuid is an application identifier per-installation; that is, if a new instance of the app is installed on the mobile device, or the app is reinstalled, it will have a new AppGuid.\n ***AppGuid Criteria*** \n   Max length: 36 characters \n   Min Length: 30 characters \n   Regex: Letters, numbers and dashes only \n");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15181a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15181a;
            }

            EnumC0331c(String str) {
                this.f15181a = str;
            }
        }
    }

    public enum d {
        ANDROID_ID("android_id"),
        APP_FIRST_INSTALL_TIME("app_first_install_time"),
        APP_GUID("app_guid"),
        APP_ID("app_id"),
        APP_LAST_UPDATE_TIME("app_last_update_time"),
        APP_VERSION("app_version"),
        COMP_VERSION("comp_version"),
        CONF_URL("conf_url"),
        CPU("cpu"),
        DEVICE_MODEL("device_model"),
        DEVICE_NAME("device_name"),
        DISK("disk"),
        EMULATOR_FLAGS("ef"),
        GSF_ID("gsf_id"),
        IN_TREATMENT(FitRunPlayAudio.PLAY_TYPE_T),
        IS_EMULATOR("is_emulator"),
        IS_ROOTED("is_rooted"),
        MAC_ADDRS("mac_addrs"),
        MAGNES_GUID("magnes_guid"),
        MAGNES_SOURCE("magnes_source"),
        NOT_COLLECTIBLE_LIST("nc"),
        NOTIF_TOKEN("notif_token"),
        OS_TYPE("os_type"),
        OS_VERSION("os_version"),
        PAYLOAD_TYPE("payload_type"),
        ROOTED_FLAGS("rf"),
        SCREEN("screen"),
        SENSOR_METADATA("smd"),
        SMS_ENABLED("sms_enabled"),
        SOURCE_APP_VERSION("source_app_version"),
        SYSTEM("system"),
        T(FitRunPlayAudio.PLAY_TYPE_T),
        TOTAL_STORAGE_SPACE("total_storage_space"),
        USER_AGENT("user_agent");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15183a;

        public enum a {
            CORES("cores"),
            MAX_FREQUENCY("maxFreq"),
            MIN_FREQUENCY("minFreq");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15184a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15184a;
            }

            a(String str) {
                this.f15184a = str;
            }
        }

        public enum b {
            TOTAL_SD("total_sd"),
            TOTAL_UD("total");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15185a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15185a;
            }

            b(String str) {
                this.f15185a = str;
            }
        }

        /* JADX INFO: renamed from: lib.android.paypal.com.magnessdk.c$d$c, reason: collision with other inner class name */
        public enum EnumC0333c {
            ANDROID_SDK_BUILD_FOR_X86("Android SDK built for x86"),
            ANDROID_X86("android_x86"),
            ANDY("andy"),
            ANDY_OS("AndyOS"),
            ANDY_OSX("AndyOSX"),
            DRIOD_4X("Driod4X"),
            DROID_4X("Droid4X"),
            GENERIC("generic"),
            GENERIC_X86("generic_x86"),
            GENY_MOTION("Genymotion"),
            GOLDFISH("goldfish"),
            GOODLE_SDK("google_sdk"),
            SDK("sdk"),
            UNKNOWN("unknown"),
            VBOX_86("vbox86"),
            VBOX_86P("vbox86p"),
            RANCHU("ranchu"),
            REMIXEMU("remixemu"),
            TTVM_X86("ttVM_x86");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15186a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15186a;
            }

            EnumC0333c(String str) {
                this.f15186a = str;
            }
        }

        /* JADX INFO: renamed from: lib.android.paypal.com.magnessdk.c$d$d, reason: collision with other inner class name */
        public enum EnumC0334d {
            DENSITY(MapKeyNames.DENSITY),
            DENSITY_DPI("densityDpi"),
            HEIGHT("height"),
            SCALE("scale"),
            WIDTH("width"),
            X_DPI("xdpi"),
            Y_DPI("ydpi");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15187a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15187a;
            }

            EnumC0334d(String str) {
                this.f15187a = str;
            }
        }

        public enum e {
            FIFO_MAX_EVENT_COUNT("mec"),
            MAX_RANGE("mr"),
            NAME("n"),
            POWER("pwr"),
            RESOLUTION("re"),
            VENDOR("v"),
            VERSION(RecommendConstants.VER);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15188a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15188a;
            }

            e(String str) {
                this.f15188a = str;
            }
        }

        public enum f {
            VERSION("version"),
            BOARD("board"),
            BOOTLOADER("bootloader"),
            CPU_ABI1("cpu_abi1"),
            DISPLAY("display"),
            RADIO("radio"),
            FINGERPRINT(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT),
            HARDWARE("hardware"),
            MANUFACTURER("manufacturer"),
            PRODUCT("product"),
            TIME("time"),
            SYSTEM_TYPE("system_type");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15189a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15189a;
            }

            f(String str) {
                this.f15189a = str;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f15183a;
        }

        d(String str) {
            this.f15183a = str;
        }
    }

    public enum e {
        BASE_STATION_ID("base_station_id"),
        BATTERY("battery"),
        BSSID("bssid"),
        BSSID_ARRAY("bssid_array"),
        C("c"),
        CDMA_NETWORK_ID("cdma_network_id"),
        CDMA_SYSTEM_ID("cdma_system_id"),
        CELL_ID("cell_id"),
        CONF_VERSION("conf_version"),
        CONN_TYPE("conn_type"),
        DC_ID("dc_id"),
        DEVICE_ID("device_id"),
        DEVICE_UPTIME("device_uptime"),
        DISK("disk"),
        DS(Constants.RELATION_COL_B_KEY),
        IP_ADDRESSES("ip_addresses"),
        IP_ADDRS("ip_addrs"),
        IS_DEV_MODE_ON("dmo"),
        KNOWN_APPS("known_apps"),
        LINKER_ID("linker_id"),
        LOCALE_COUNTRY("locale_country"),
        LOCALE_LANG("locale_lang"),
        LOCATION("location"),
        LOCATION_AREA_CODE("location_area_code"),
        MEMORY("memory"),
        MG_ID("mg_id"),
        NETWORK_OPERATOR("network_operator"),
        PHONE_TYPE("phone_type"),
        PL("pl"),
        PROXY_SETTING("proxy_setting"),
        RISK_COMP_SESSION_ID("risk_comp_session_id"),
        ROAMING("roaming"),
        SCREEN("screen"),
        SERIAL_NUMBER("serial_number"),
        SIM_OPERATOR_NAME("sim_operator_name"),
        SIM_SERIAL_NUMBER("sim_serial_number"),
        SR("sr"),
        SSID("ssid"),
        SUBSCRIBER_ID("subscriber_id"),
        T(FitRunPlayAudio.PLAY_TYPE_T),
        TIMESTAMP("timestamp"),
        TZ("tz"),
        TZ_NAME("tz_name"),
        VPN_SETTING("VPN_setting");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15190a;

        public enum a {
            CURRENT("current"),
            LEVEL("level"),
            METHOD("method"),
            LOW_POWER("low_power"),
            STATE("state"),
            TEMP(BleConstants.TEMPERATURE),
            VOLTAGE("voltage");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15191a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15191a;
            }

            a(String str) {
                this.f15191a = str;
            }
        }

        public enum b {
            FREE_SD("free_sd"),
            FREE_UD("free"),
            MOUNTED("mounted");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15192a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15192a;
            }

            b(String str) {
                this.f15192a = str;
            }
        }

        /* JADX INFO: renamed from: lib.android.paypal.com.magnessdk.c$e$c, reason: collision with other inner class name */
        public enum EnumC0335c {
            FREE("free"),
            FREE_RUNTIME("free_runtime"),
            MAX_RUNTIME("max_runtime"),
            TOTAL("total"),
            TOTAL_RUNTIME("total_runtime");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f15193a;

            @Override // java.lang.Enum
            public String toString() {
                return this.f15193a;
            }

            EnumC0335c(String str) {
                this.f15193a = str;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f15190a;
        }

        e(String str) {
            this.f15190a = str;
        }
    }

    public enum a {
        AUDIT_KEY("audit"),
        FEATURE("type"),
        PAYLOAD(Constants.CA_PAYLOAD),
        SENSOR_TYPE(FitRunPlayAudio.PLAY_TYPE_T),
        SENSOR_PAYLOAD("p");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15178a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15178a;
        }

        a(String str) {
            this.f15178a = str;
        }
    }

    /* JADX INFO: renamed from: lib.android.paypal.com.magnessdk.c$c, reason: collision with other inner class name */
    public enum EnumC0332c {
        RAMP("ramp"),
        REMOTE("remote");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15182a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15182a;
        }

        EnumC0332c(String str) {
            this.f15182a = str;
        }
    }

    public enum g {
        PRODUCTION("production"),
        STAGE("stage");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15195a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15195a;
        }

        g(String str) {
            this.f15195a = str;
        }
    }

    public enum i {
        OPEN("o"),
        EXCLUDED(FitRunPlayAudio.OPPORTUNITY_E),
        MIN_VERSION(FitRunPlayAudio.OPPORTUNITY_M),
        RAMP_THRESHOLD("r"),
        APP_IDS("ai"),
        APP_SOURCES("as"),
        CONF_REFRESH_TIME_KEY("cr_ti");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15201a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15201a;
        }

        i(String str) {
            this.f15201a = str;
        }
    }

    public enum j {
        CONF_VERSION("conf_version"),
        CONF_ENDPOINT_URL("endpoint_url"),
        CONF_REFRESH_TIME_KEY("conf_refresh_time_interval"),
        ANDROID_APPS_TO_CHECK("android_apps_to_check"),
        NOT_COLLECTABLE("nc"),
        MG_ID(FitRunPlayAudio.OPPORTUNITY_M),
        SENSOR_COLLECT_TIME("s");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15202a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15202a;
        }

        j(String str) {
            this.f15202a = str;
        }
    }

    public enum l {
        AC("ac"),
        GY("gy"),
        MG("mg");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15206a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15206a;
        }

        l(String str) {
            this.f15206a = str;
        }
    }

    public enum m {
        FLIGHT_TIME("flightTime"),
        TELEMETRY_EVENTS("Events"),
        TYPING_SPEED("ts"),
        VIEW_ID("viewId"),
        AUTO_COMPLETE_EVENT("wsac"),
        BACKSPACE_EVENT("wsbs"),
        CUT_EVENT("wsct"),
        PRE_FILLED_EVENT("wspf"),
        REGULAR_TYPING_EVENT("wsrt"),
        FAILED_TO_CONVERT_TO_JSON("Failed to convert to JSON");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15207a;

        @Override // java.lang.Enum
        public String toString() {
            return this.f15207a;
        }

        m(String str) {
            this.f15207a = str;
        }
    }
}
