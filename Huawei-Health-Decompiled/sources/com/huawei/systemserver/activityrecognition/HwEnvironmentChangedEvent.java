package com.huawei.systemserver.activityrecognition;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class HwEnvironmentChangedEvent implements Parcelable {
    public static final Parcelable.Creator<HwEnvironmentChangedEvent> CREATOR = new Parcelable.Creator<HwEnvironmentChangedEvent>() { // from class: com.huawei.systemserver.activityrecognition.HwEnvironmentChangedEvent.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cFc_, reason: merged with bridge method [inline-methods] */
        public HwEnvironmentChangedEvent createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return new HwEnvironmentChangedEvent(new HwActivityRecognitionExtendEvent[0]);
            }
            int i = parcel.readInt();
            HwActivityRecognitionExtendEvent[] hwActivityRecognitionExtendEventArr = new HwActivityRecognitionExtendEvent[HwEnvironmentChangedEvent.checkEnvReportLen(i) ? i : 0];
            parcel.readTypedArray(hwActivityRecognitionExtendEventArr, HwActivityRecognitionExtendEvent.CREATOR);
            return new HwEnvironmentChangedEvent(hwActivityRecognitionExtendEventArr);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public HwEnvironmentChangedEvent[] newArray(int i) {
            return new HwEnvironmentChangedEvent[i];
        }
    };
    private static final int MAX_ENV_REPORT_LEN = 1000;
    private static final String TAG = "ARMoudle.HwEnvironmentChangedEvent";
    private final List<HwActivityRecognitionExtendEvent> mEnvironmentRecognitionEvents;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HwEnvironmentChangedEvent(HwActivityRecognitionExtendEvent[] hwActivityRecognitionExtendEventArr) {
        if (hwActivityRecognitionExtendEventArr == null) {
            throw new InvalidParameterException("Parameter 'environmentRecognitionEvents' must not be null.");
        }
        this.mEnvironmentRecognitionEvents = Arrays.asList(hwActivityRecognitionExtendEventArr);
    }

    public Iterable<HwActivityRecognitionExtendEvent> getEnvironmentRecognitionEvents() {
        return this.mEnvironmentRecognitionEvents;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        HwActivityRecognitionExtendEvent[] hwActivityRecognitionExtendEventArr = (HwActivityRecognitionExtendEvent[]) this.mEnvironmentRecognitionEvents.toArray(new HwActivityRecognitionExtendEvent[0]);
        parcel.writeInt(hwActivityRecognitionExtendEventArr.length);
        parcel.writeTypedArray(hwActivityRecognitionExtendEventArr, i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ EnvironmentChangedEvent:");
        for (HwActivityRecognitionExtendEvent hwActivityRecognitionExtendEvent : this.mEnvironmentRecognitionEvents) {
            sb.append("\n    ");
            sb.append(hwActivityRecognitionExtendEvent.toString());
        }
        sb.append("\n]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkEnvReportLen(int i) {
        if (i >= 0 && i <= 1000) {
            return true;
        }
        Log.e(TAG, "report env invalid.");
        return false;
    }
}
