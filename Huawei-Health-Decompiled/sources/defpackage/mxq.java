package defpackage;

import com.huawei.multisimsdk.attacheddevicemanager.common.IAttachedDeviceManagerCallback;
import com.huawei.multisimservice.model.SimInfo;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mxq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAttachedDeviceManagerCallback f15919a;
    private String b;
    private List<SimInfo> c;
    private String d;
    private String e;
    private int f;

    public IAttachedDeviceManagerCallback d() {
        return this.f15919a;
    }

    public int b() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        mxq mxqVar = (mxq) obj;
        if (this.f != mxqVar.f) {
            return false;
        }
        IAttachedDeviceManagerCallback iAttachedDeviceManagerCallback = this.f15919a;
        if (iAttachedDeviceManagerCallback == null ? mxqVar.f15919a != null : !iAttachedDeviceManagerCallback.equals(mxqVar.f15919a)) {
            return false;
        }
        String str = this.d;
        if (str == null ? mxqVar.d != null : !str.equals(mxqVar.d)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? mxqVar.b != null : !str2.equals(mxqVar.b)) {
            return false;
        }
        String str3 = this.e;
        if (str3 == null ? mxqVar.e != null : !str3.equals(mxqVar.e)) {
            return false;
        }
        List<SimInfo> list = this.c;
        return list != null ? list.equals(mxqVar.c) : mxqVar.c == null;
    }

    public int hashCode() {
        int iHashCode = this.f;
        IAttachedDeviceManagerCallback iAttachedDeviceManagerCallback = this.f15919a;
        if (iAttachedDeviceManagerCallback != null) {
            iHashCode = (iHashCode * 31) + iAttachedDeviceManagerCallback.hashCode();
        }
        String str = this.d;
        if (str != null) {
            iHashCode = (iHashCode * 31) + str.hashCode();
        }
        String str2 = this.b;
        if (str2 != null) {
            iHashCode = (iHashCode * 31) + str2.hashCode();
        }
        String str3 = this.e;
        if (str3 != null) {
            iHashCode = (iHashCode * 31) + str3.hashCode();
        }
        List<SimInfo> list = this.c;
        return list != null ? (iHashCode * 31) + list.hashCode() : iHashCode;
    }
}
