package com.huawei.systemserver.activityrecognition;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class HwActivityChangedExtendEvent implements Parcelable {
    public static final Parcelable.Creator<HwActivityChangedExtendEvent> CREATOR = new Parcelable.Creator<HwActivityChangedExtendEvent>() { // from class: com.huawei.systemserver.activityrecognition.HwActivityChangedExtendEvent.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cEZ_, reason: merged with bridge method [inline-methods] */
        public HwActivityChangedExtendEvent createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return new HwActivityChangedExtendEvent(new HwActivityRecognitionExtendEvent[0]);
            }
            int i = parcel.readInt();
            HwActivityRecognitionExtendEvent[] hwActivityRecognitionExtendEventArr = new HwActivityRecognitionExtendEvent[HwActivityChangedExtendEvent.checkActivityReportLen(i) ? i : 0];
            parcel.readTypedArray(hwActivityRecognitionExtendEventArr, HwActivityRecognitionExtendEvent.CREATOR);
            return new HwActivityChangedExtendEvent(hwActivityRecognitionExtendEventArr);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public HwActivityChangedExtendEvent[] newArray(int i) {
            return new HwActivityChangedExtendEvent[i];
        }
    };
    private static final int MAX_ACTIVITY_REPORT_LEN = 1000;
    private static final String TAG = "ARMoudle.HwActivityChangedExtendEvent";
    private final List<HwActivityRecognitionExtendEvent> mActivityRecognitionEvents;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HwActivityChangedExtendEvent(HwActivityRecognitionExtendEvent[] hwActivityRecognitionExtendEventArr) {
        if (hwActivityRecognitionExtendEventArr == null) {
            throw new InvalidParameterException("Parameter 'activityRecognitionEvents' must not be null.");
        }
        this.mActivityRecognitionEvents = Arrays.asList(hwActivityRecognitionExtendEventArr);
    }

    public Iterable<HwActivityRecognitionExtendEvent> getActivityRecognitionExtendEvents() {
        return this.mActivityRecognitionEvents;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        HwActivityRecognitionExtendEvent[] hwActivityRecognitionExtendEventArr = (HwActivityRecognitionExtendEvent[]) this.mActivityRecognitionEvents.toArray(new HwActivityRecognitionExtendEvent[0]);
        parcel.writeInt(hwActivityRecognitionExtendEventArr.length);
        parcel.writeTypedArray(hwActivityRecognitionExtendEventArr, i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ActivityChangedExtendEvent:");
        for (HwActivityRecognitionExtendEvent hwActivityRecognitionExtendEvent : this.mActivityRecognitionEvents) {
            sb.append("\n    ");
            sb.append(hwActivityRecognitionExtendEvent.toString());
        }
        sb.append("\n]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkActivityReportLen(int i) {
        if (i >= 0 && i <= 1000) {
            return true;
        }
        Log.e(TAG, "report activity invalid.");
        return false;
    }
}
