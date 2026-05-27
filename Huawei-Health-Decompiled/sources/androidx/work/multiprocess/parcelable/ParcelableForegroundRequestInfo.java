package androidx.work.multiprocess.parcelable;

import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.ForegroundInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelableForegroundRequestInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableForegroundRequestInfo> CREATOR = new Parcelable.Creator<ParcelableForegroundRequestInfo>() { // from class: androidx.work.multiprocess.parcelable.ParcelableForegroundRequestInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableForegroundRequestInfo createFromParcel(Parcel parcel) {
            return new ParcelableForegroundRequestInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableForegroundRequestInfo[] newArray(int i) {
            return new ParcelableForegroundRequestInfo[i];
        }
    };
    private final ForegroundInfo mForegroundInfo;
    private final String mId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableForegroundRequestInfo(String str, ForegroundInfo foregroundInfo) {
        this.mId = str;
        this.mForegroundInfo = foregroundInfo;
    }

    public ParcelableForegroundRequestInfo(Parcel parcel) {
        this.mId = parcel.readString();
        this.mForegroundInfo = new ForegroundInfo(parcel.readInt(), (Notification) parcel.readParcelable(getClass().getClassLoader()), parcel.readInt());
    }

    public ForegroundInfo getForegroundInfo() {
        return this.mForegroundInfo;
    }

    public String getId() {
        return this.mId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mForegroundInfo.getNotificationId());
        parcel.writeInt(this.mForegroundInfo.getForegroundServiceType());
        parcel.writeParcelable(this.mForegroundInfo.getNotification(), i);
    }
}
