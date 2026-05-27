package com.huawei.health.ecologydevice.connectivity;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.health.device.model.HealthDevice;
import com.huawei.hwlogsmodel.LogUtil;
import defpackage.dun;
import defpackage.dup;
import defpackage.eid;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class ScanFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f2328a = {"0000180d-0000-1000-8000-00805f9b34fb"};
    private MatchRule b;
    private String c;
    private String[] d;

    public enum MatchRule {
        STRICT,
        INCLUSIVE,
        FRONT,
        REAR
    }

    private ScanFilter(String str, String str2, MatchRule matchRule) {
        if (str != null) {
            this.d = str.split(";");
        }
        this.c = str2;
        this.b = matchRule;
    }

    public boolean SZ_(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        try {
            String[] strArr = this.d;
            if (strArr == null || strArr.length <= 0) {
                return !TextUtils.isEmpty(this.c) && this.c.equals(bluetoothDevice.getAddress());
            }
            String name = bluetoothDevice.getName();
            if (name != null) {
                return d(name);
            }
            return false;
        } catch (SecurityException e) {
            LogUtil.a("ScanFilter", "matches SecurityException:", ExceptionUtils.a(e));
            return false;
        }
    }

    public boolean c(dun dunVar) {
        if (dunVar == null) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr == null || strArr.length <= 0) {
            return !TextUtils.isEmpty(this.c) && this.c.equals(dunVar.getAddress());
        }
        String deviceName = dunVar.getDeviceName();
        if (deviceName != null) {
            return d(deviceName);
        }
        return false;
    }

    public boolean b(byte[] bArr) {
        String[] strArr = this.d;
        if (strArr != null && bArr.length > 0) {
            for (String str : strArr) {
                if ("moredevice".equals(str) && eid.e(this.c) == HealthDevice.HealthDeviceKind.HDK_HEART_RATE) {
                    return dup.b(bArr, UUID.fromString(this.f2328a[0]));
                }
            }
        }
        return false;
    }

    public boolean d(String str) {
        String[] strArr;
        if (!TextUtils.isEmpty(str) && (strArr = this.d) != null) {
            for (String str2 : strArr) {
                LogUtil.e("ScanFilter", "isDeviceNameMatched ScanFilter target name is ", str2, " and device name is ", str);
                if (this.b == MatchRule.STRICT) {
                    if (str.equals(str2)) {
                        return true;
                    }
                } else if (this.b == MatchRule.FRONT) {
                    if (str.startsWith(str2)) {
                        return true;
                    }
                } else if (this.b == MatchRule.INCLUSIVE) {
                    if (str.contains(str2)) {
                        return true;
                    }
                } else if (this.b == MatchRule.REAR && str.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ScanFilter d(String str, String str2, MatchRule matchRule) {
        return new ScanFilter(str, str2, matchRule);
    }
}
