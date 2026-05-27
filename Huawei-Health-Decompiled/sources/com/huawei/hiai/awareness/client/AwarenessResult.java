package com.huawei.hiai.awareness.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AwarenessResult implements Parcelable {
    public static final Parcelable.Creator<AwarenessResult> CREATOR = new Parcelable.Creator<AwarenessResult>() { // from class: com.huawei.hiai.awareness.client.AwarenessResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AwarenessResult createFromParcel(Parcel parcel) {
            return new AwarenessResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AwarenessResult[] newArray(int i) {
            return new AwarenessResult[i];
        }
    };
    public static final String MESSAGE_TYPE = "context_awareness_result";
    private int code;
    private String extra;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AwarenessResult(int i) {
        this.code = i;
    }

    public AwarenessResult(int i, String str) {
        this(i);
        this.extra = str;
    }

    private AwarenessResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.extra = parcel.readString();
    }

    public int code() {
        return this.code;
    }

    public String getExtra() {
        return this.extra;
    }

    public boolean isSuccessful() {
        return code() >= 10000;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.extra);
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "AwarenessResult{%d} - %s", Integer.valueOf(code()), getExtra());
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static final class Code {
        public static final int ERROR_ABILITY_SUBSCRIBE_FAIL = 14;
        public static final int ERROR_CREATE_FENCE_FAIL = 12;
        public static final int ERROR_FENCE_INFO_IS_EMPTY = 15;
        public static final int ERROR_FENCE_NUM_EXCEEDED_THE_UPPER_LIMIT = 9;
        public static final int ERROR_FENCE_PERMISSION_CHECK_FAIL = 13;
        public static final int ERROR_INVALID_EFFECTIVE_TIME = 10;
        public static final int ERROR_INVALID_IDENTIFIER = 11;
        public static final int ERROR_INVALID_PARAMETER = 3;
        public static final int ERROR_LOCATION_FENCE_SWITCH_IS_OFF = 5;
        public static final int ERROR_PLACE_SWITCH_IS_OFF = 6;
        public static final int ERROR_SMART_ASSISTANT_LABEL_DISABLE = 8;
        public static final int ERROR_SMART_ASSISTANT_SWITCH_IS_OFF = 7;
        public static final int ERROR_UNAUTHORIZED = 4;
        public static final int EXCEED_THE_UPPER_LIMIT = 1;
        public static final int FAILURE = 0;
        public static final int INCONSISTENT_TYPE = 2;
        public static final int SUCCESS = 10000;
        public static final Map<Integer, String> retMsgMap;

        static {
            HashMap map = new HashMap();
            retMsgMap = map;
            map.put(10000, MonitorResult.SUCCESS);
            map.put(0, "FAILURE");
            map.put(1, "EXCEED_THE_UPPER_LIMIT");
            map.put(2, "INCONSISTENT_TYPE");
            map.put(3, "ERROR_INVALID_PARAMETER");
            map.put(4, "ERROR_UNAUTHORIZED");
            map.put(5, "ERROR_LOCATION_FENCE_SWITCH_IS_OFF");
            map.put(6, "ERROR_PLACE_SWITCH_IS_OFF");
            map.put(7, "ERROR_SMART_ASSISTANT_SWITCH_IS_OFF");
            map.put(8, "ERROR_SMART_ASSISTANT_LABEL_DISABLE");
            map.put(9, "ERROR_FENCE_NUM_EXCEEDED_THE_UPPER_LIMIT");
            map.put(10, "ERROR_INVALID_EFFECTIVE_TIME");
            map.put(11, "ERROR_INVALID_IDENTIFIER");
            map.put(12, "ERROR_CREATE_FENCE_FAIL");
            map.put(13, "ERROR_FENCE_PERMISSION_CHECK_FAIL");
            map.put(14, "ERROR_ABILITY_SUBSCRIBE_FAIL");
            map.put(15, "ERROR_FENCE_INFO_IS_EMPTY");
        }
    }

    @Deprecated
    public String reason() {
        return "";
    }
}
