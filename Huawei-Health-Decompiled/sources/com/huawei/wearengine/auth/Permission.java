package com.huawei.wearengine.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.nfc.PluginPayAdapter;

/* JADX INFO: loaded from: classes8.dex */
public class Permission implements Parcelable {
    private final String mName;
    public static final Parcelable.Creator<Permission> CREATOR = new Parcelable.Creator<Permission>() { // from class: com.huawei.wearengine.auth.Permission.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: fBC_, reason: merged with bridge method [inline-methods] */
        public Permission createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return new Permission("");
            }
            return new Permission(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Permission[] newArray(int i) {
            return (i > 65535 || i < 0) ? new Permission[0] : new Permission[i];
        }
    };
    public static final Permission DEVICE_MANAGER = new Permission("device_manager");
    public static final Permission NOTIFY = new Permission("notify");
    public static final Permission SENSOR = new Permission("sensor");
    public static final Permission MOTION_SENSOR = new Permission("motion_sensor");
    public static final Permission WEAR_USER_STATUS = new Permission("wear_user_status");
    public static final Permission DEVICE_SN = new Permission(PluginPayAdapter.KEY_DEVICE_INFO_SN);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Permission(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.mName);
    }
}
