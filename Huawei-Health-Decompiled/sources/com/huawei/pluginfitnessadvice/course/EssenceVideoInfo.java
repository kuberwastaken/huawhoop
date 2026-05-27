package com.huawei.pluginfitnessadvice.course;

import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.PayPalPaymentIntent;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class EssenceVideoInfo implements BaseVideoInfo, Parcelable {
    public static final Parcelable.Creator<EssenceVideoInfo> CREATOR = new Parcelable.Creator<EssenceVideoInfo>() { // from class: com.huawei.pluginfitnessadvice.course.EssenceVideoInfo.4
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ctd_, reason: merged with bridge method [inline-methods] */
        public EssenceVideoInfo createFromParcel(Parcel parcel) {
            return new EssenceVideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EssenceVideoInfo[] newArray(int i) {
            return new EssenceVideoInfo[i];
        }
    };

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("courseName")
    private String courseName;

    @SerializedName("guideCourseId")
    private String guideCourseId;

    @SerializedName("guideShowTime")
    private int guideShowTime;

    @SerializedName("guideText")
    private String guideText;

    @SerializedName("introduction")
    private String introduction;

    @SerializedName(PayPalPaymentIntent.ORDER)
    private int order;

    @SerializedName("serialCourseId")
    private String serialCourseId;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("videoCourseId")
    private String videoCourseId;

    @SerializedName("videoUrl")
    private String videoUrl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.pluginfitnessadvice.course.BaseVideoInfo
    public int getType() {
        return 1;
    }

    protected EssenceVideoInfo(Parcel parcel) {
        this.serialCourseId = parcel.readString();
        this.videoCourseId = parcel.readString();
        this.courseName = parcel.readString();
        this.introduction = parcel.readString();
        this.videoUrl = parcel.readString();
        this.thumbnail = parcel.readString();
        this.avatar = parcel.readString();
        this.guideText = parcel.readString();
        this.guideShowTime = parcel.readInt();
        this.guideCourseId = parcel.readString();
        this.order = parcel.readInt();
    }

    public EssenceVideoInfo() {
    }

    public String getVideoCourseId() {
        return this.videoCourseId;
    }

    public void setVideoCourseId(String str) {
        this.videoCourseId = str;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getSerialCourseId() {
        return this.serialCourseId;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getGuideText() {
        return this.guideText;
    }

    public int getGuideShowTime() {
        return this.guideShowTime;
    }

    public String getGuideCourseId() {
        return this.guideCourseId;
    }

    public int getOrder() {
        return this.order;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public String toString() {
        return "EssenceVideoInfo{serialCourseId='" + this.serialCourseId + "', videoCourseId='" + this.videoCourseId + "', courseName='" + this.courseName + "', introduction='" + this.introduction + "', videoUrl='" + this.videoUrl + "', thumbnail='" + this.thumbnail + "', avatar='" + this.avatar + "', guideText='" + this.guideText + "', guideShowTime=" + this.guideShowTime + ", guideCourseId='" + this.guideCourseId + "', order='" + this.order + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.serialCourseId);
        parcel.writeString(this.videoCourseId);
        parcel.writeString(this.courseName);
        parcel.writeString(this.introduction);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.avatar);
        parcel.writeString(this.guideText);
        parcel.writeInt(this.guideShowTime);
        parcel.writeString(this.guideCourseId);
        parcel.writeInt(this.order);
    }

    @Override // com.huawei.pluginfitnessadvice.course.BaseVideoInfo
    public String getUrl() {
        return getVideoUrl();
    }
}
