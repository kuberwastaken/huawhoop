package com.huawei.android.airsharing.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import defpackage.arb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PlayerCapability implements Parcelable {
    public static final String CAPABILITY_DRM_PROPERTIES = "DRM_PROPERTIES_CAPABILITY";
    public static final String CAPABILITY_SUPPORT_4K = "SUPPORT_4K";
    public static final String CAPABILITY_SUPPORT_DRM = "DRM_CAPABILITY";
    public static final int DRM_TYPE_BASE = 1;
    public static final int DRM_TYPE_CHINADRM = 16;
    public static final int DRM_TYPE_CLEARKEY = 2;
    public static final int DRM_TYPE_PLAYREADY = 8;
    public static final int DRM_TYPE_WIDEVINE = 4;
    public static final String PARAMS_PLAYER_VERSION_CODE = "PLAYER_VERSION_CODE";
    public static final String PARAMS_STREAM_VOLUME = "MEDIA_VOLUME";
    private static final String TAG = "HiSight-S-PlayerCapability";
    public static final int VERSION_CODE = 1;
    private int mDrmCapability;
    private Map<String, Map<String, String>> mDrmProperties;
    private boolean mIsSupport4K;
    private int mOriginalVolume;
    private int mPlayerVersionCode;
    public static final Parcelable.Creator<PlayerCapability> CREATOR = new Parcelable.Creator<PlayerCapability>() { // from class: com.huawei.android.airsharing.api.PlayerCapability.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: eZ_, reason: merged with bridge method [inline-methods] */
        public PlayerCapability createFromParcel(Parcel parcel) {
            return new PlayerCapability(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public PlayerCapability[] newArray(int i) {
            return new PlayerCapability[i];
        }
    };
    private static arb sLog = arb.d();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlayerCapability() {
        this.mDrmProperties = new HashMap();
        this.mIsSupport4K = false;
        this.mOriginalVolume = -1;
        this.mDrmCapability = 1;
        this.mPlayerVersionCode = 1;
    }

    protected PlayerCapability(Parcel parcel) {
        this.mDrmProperties = new HashMap();
        this.mIsSupport4K = false;
        this.mOriginalVolume = -1;
        this.mDrmCapability = 1;
        this.mPlayerVersionCode = 1;
        this.mIsSupport4K = parcel.readByte() != 0;
        this.mOriginalVolume = parcel.readInt();
        this.mDrmCapability = parcel.readInt();
        this.mDrmProperties = parcel.readHashMap(HashMap.class.getClassLoader());
        this.mPlayerVersionCode = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeByte(this.mIsSupport4K ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mOriginalVolume);
        parcel.writeInt(this.mDrmCapability);
        parcel.writeMap(this.mDrmProperties);
        parcel.writeInt(this.mPlayerVersionCode);
    }

    public void setIsSupport4K(boolean z) {
        this.mIsSupport4K = z;
    }

    public void setPlayerVersionCode(int i) {
        if (i > 0) {
            this.mPlayerVersionCode = i;
        }
    }

    public void setOriginalVolume(int i) {
        if (i >= 0) {
            this.mOriginalVolume = i;
        }
    }

    public void setDrmCapability(int i) {
        if (i > 0) {
            this.mDrmCapability = i;
        }
    }

    public void setDrmPropertiesCapability(String str) {
        Log.i(TAG, "setDrmPropertiesCapability  propertiesJson:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDrmProperties.clear();
        jsonToMap(str);
    }

    private void jsonToMap(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                HashMap map = new HashMap();
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    Log.i(TAG, "jsonToMap  key:" + next + ", obj:" + obj.toString());
                    JSONObject jSONObject2 = (JSONObject) obj;
                    Iterator<String> itKeys2 = jSONObject2.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        String string = jSONObject2.getString(next2);
                        Log.i(TAG, "jsonToMap  itemKey:" + next2 + ", itemVal:" + string);
                        map.put(next2, string);
                    }
                    this.mDrmProperties.put(next, map);
                }
            }
        } catch (JSONException unused) {
            sLog.b(TAG, "PlayerCapability parse drm properties occur JSONException");
        }
    }

    public boolean isSupport4K() {
        return this.mIsSupport4K;
    }

    public int getPlayerVersionCode() {
        return this.mPlayerVersionCode;
    }

    public int getOriginalVolume() {
        return this.mOriginalVolume;
    }

    public int getDrmCapability() {
        return this.mDrmCapability;
    }

    public Map<String, String> getDrmProperties(int i) {
        Map<String, String> map;
        if (i == 2) {
            map = this.mDrmProperties.get("DRM_TYPE_CLEARKEY");
        } else if (i == 4) {
            map = this.mDrmProperties.get("DRM_TYPE_WIDEVINE");
        } else if (i == 8) {
            map = this.mDrmProperties.get("DRM_TYPE_PLAYREADY");
        } else {
            map = i != 16 ? null : this.mDrmProperties.get("DRM_TYPE_CHINADRM");
        }
        return map == null ? new HashMap() : map;
    }
}
