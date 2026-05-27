package defpackage;

import com.huawei.health.ITrackDataForDeveloper;
import com.huawei.hihealth.IRealTimeDataCallback;

/* JADX INFO: loaded from: classes9.dex */
public class kca {
    private IRealTimeDataCallback callback;
    private int permissionTypeId;
    private String permissionTypeName;
    private ITrackDataForDeveloper trackDataForDeveloper;

    public kca(int i, String str, IRealTimeDataCallback iRealTimeDataCallback, ITrackDataForDeveloper iTrackDataForDeveloper) {
        this.permissionTypeId = i;
        this.permissionTypeName = str;
        this.callback = iRealTimeDataCallback;
        this.trackDataForDeveloper = iTrackDataForDeveloper;
    }

    public int getPermissionTypeId() {
        return this.permissionTypeId;
    }

    public String getPermissionTypeName() {
        return this.permissionTypeName;
    }

    public IRealTimeDataCallback getCallback() {
        return this.callback;
    }

    public ITrackDataForDeveloper getTrackDataForDeveloper() {
        return this.trackDataForDeveloper;
    }
}
