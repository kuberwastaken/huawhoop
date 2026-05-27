package com.huawei.maps.offlinedata.service.device.consts;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: com.huawei.maps.offlinedata.service.device.consts.a$a, reason: collision with other inner class name */
    public enum EnumC0183a {
        MAP_SUCCESS(0),
        MAP_ERROR_NO_ENOUGH_SPACE(1),
        MAP_ERROR_NO_UPDATE(2),
        MAP_ERROR_IN_USE(3),
        MAP_ERROR_DEVICE_ERROR(4);

        private final int f;

        EnumC0183a(int i) {
            this.f = i;
        }

        public int a() {
            return this.f;
        }
    }

    public enum c {
        SUCCESS("0"),
        FAILURE("1");

        private final String c;

        c(String str) {
            this.c = str;
        }

        public String a() {
            return this.c;
        }
    }

    public enum b {
        QUERY_DEVICE_REMAIN_SPACE(1, HiAnalyticsConstant.KeyAndValue.NUMBER_01),
        SYNC_POLITICAL_PERSPECTIVE(2, com.huawei.hms.ads.dynamic.a.t),
        QUERY_DEVICE_DOWNLOADED_MAP_INFO(3, "03"),
        TRANSMIT_MAP_HANDSHAKE(4, "04"),
        DELETE_DEVICE_MAP(5, "05"),
        DEVICE_PING_MAP(6, "06"),
        DEVICE_REQUEST_POLITICAL_PERSPECTIVE(7, "07"),
        TRANSMIT_MAP_PARSE_FINISH(8, "08"),
        DEVICE_QUERY_MAP_SIZE(9, "09"),
        MAP_SIZE_BY_WEAR(10, "0A"),
        DOWNLOAD_BY_WEAR(11, "0B");

        private final int l;
        private final String m;

        b(int i, String str) {
            this.l = i;
            this.m = str;
        }

        public int a() {
            return this.l;
        }

        public String b() {
            return this.m;
        }
    }
}
