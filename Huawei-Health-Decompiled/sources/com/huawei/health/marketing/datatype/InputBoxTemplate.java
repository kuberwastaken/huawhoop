package com.huawei.health.marketing.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.health.marketing.datatype.ColumRecommendInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class InputBoxTemplate extends ColumRecommendInfo implements Parcelable {
    public static final Parcelable.Creator<InputBoxTemplate> CREATOR = new Parcelable.Creator<InputBoxTemplate>() { // from class: com.huawei.health.marketing.datatype.InputBoxTemplate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBoxTemplate createFromParcel(Parcel parcel) {
            return new InputBoxTemplate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBoxTemplate[] newArray(int i) {
            return new InputBoxTemplate[i];
        }
    };
    public static final String NONE_TYPE = "none";
    public static final String NORMAL_TYPE = "normal";
    public static final String SEARCH_TYPE = "search";
    private List<Integer> appPageNo;
    private String extend;
    private String lessonSubCategory;
    private String linkType;
    private String linkValue;
    private String resourceId;
    private String resourceName;
    private String theme;
    private String writingId;

    @Override // com.huawei.health.marketing.datatype.ColumRecommendInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.health.marketing.datatype.ColumRecommendInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.theme);
        parcel.writeString(this.linkType);
        parcel.writeString(this.linkValue);
        parcel.writeString(this.extend);
        parcel.writeString(this.lessonSubCategory);
        parcel.writeString(this.writingId);
        parcel.writeList(this.appPageNo);
        parcel.writeString(this.resourceName);
        parcel.writeString(this.resourceId);
    }

    public InputBoxTemplate(ColumRecommendInfo.Builder builder) {
        super(builder);
    }

    protected InputBoxTemplate(Parcel parcel) {
        super(parcel);
        this.theme = parcel.readString();
        this.linkType = parcel.readString();
        this.linkValue = parcel.readString();
        this.extend = parcel.readString();
        this.lessonSubCategory = parcel.readString();
        this.writingId = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.appPageNo = arrayList;
        parcel.readList(arrayList, Integer.class.getClassLoader());
        this.resourceName = parcel.readString();
        this.resourceId = parcel.readString();
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String str) {
        this.theme = str;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String str) {
        this.linkType = str;
    }

    public String getLinkValue() {
        return this.linkValue;
    }

    public void setLinkValue(String str) {
        this.linkValue = str;
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public String getLessonSubCategory() {
        return this.lessonSubCategory;
    }

    public void setLessonSubCategory(String str) {
        this.lessonSubCategory = str;
    }

    public String getWritingId() {
        return this.writingId;
    }

    public void setWritingId(String str) {
        this.writingId = str;
    }

    public List<Integer> getAppPageNo() {
        return this.appPageNo;
    }

    public void setAppPageNo(List<Integer> list) {
        this.appPageNo = list;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public void setResourceName(String str) {
        this.resourceName = str;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(String str) {
        this.resourceId = str;
    }
}
