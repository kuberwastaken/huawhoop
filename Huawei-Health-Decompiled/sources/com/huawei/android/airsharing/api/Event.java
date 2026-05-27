package com.huawei.android.airsharing.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class Event implements Parcelable {
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() { // from class: com.huawei.android.airsharing.api.Event.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: eO_, reason: merged with bridge method [inline-methods] */
        public Event createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            Log.d(Event.TAG, "eventId " + i);
            if (i == 2010) {
                return new InitializationInfoEvent(i, parcel);
            }
            if (i == 3014) {
                return new GrabStateChangedEvent(i, parcel);
            }
            if (i != 3600) {
                switch (i) {
                    case 3100:
                    case 3101:
                    case 3102:
                        break;
                    default:
                        switch (i) {
                            case IEventListener.EVENT_ID_HISIGHT_STATE_PLAYING /* 3104 */:
                            case IEventListener.EVENT_ID_HISIGHT_STATE_PAUSED /* 3105 */:
                            case IEventListener.EVENT_ID_HISIGHT_STATE_CONNECTING /* 3106 */:
                            case IEventListener.EVENT_ID_HISIGHT_STATE_KIT_NOT_CERTIFIED /* 3108 */:
                                break;
                            case 3107:
                                return new AuthRequestEvent(i, parcel);
                            default:
                                return new Event(i);
                        }
                        break;
                }
                return new ConnectionStatusEvent(i, parcel);
            }
            return new ErrorInfoEvent(i, parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Event[] newArray(int i) {
            return new Event[i];
        }
    };
    protected static final String TAG = "AirsharingEvent";
    protected final int mEventId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Event(int i) {
        this.mEventId = i;
    }

    protected Event(Parcel parcel) {
        this.mEventId = parcel.readInt();
    }

    public int getEventId() {
        return this.mEventId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeInt(this.mEventId);
        }
    }
}
