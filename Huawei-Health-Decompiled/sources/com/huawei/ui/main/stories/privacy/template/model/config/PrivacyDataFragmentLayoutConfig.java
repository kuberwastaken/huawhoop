package com.huawei.ui.main.stories.privacy.template.model.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huawei.ui.main.stories.template.health.config.HealthCommonExpandViewConfig;

/* JADX INFO: loaded from: classes8.dex */
public class PrivacyDataFragmentLayoutConfig implements Parcelable {
    public static final Parcelable.Creator<PrivacyDataFragmentLayoutConfig> CREATOR = new Parcelable.Creator<PrivacyDataFragmentLayoutConfig>() { // from class: com.huawei.ui.main.stories.privacy.template.model.config.PrivacyDataFragmentLayoutConfig.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ema_, reason: merged with bridge method [inline-methods] */
        public PrivacyDataFragmentLayoutConfig createFromParcel(Parcel parcel) {
            return new PrivacyDataFragmentLayoutConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PrivacyDataFragmentLayoutConfig[] newArray(int i) {
            return new PrivacyDataFragmentLayoutConfig[i];
        }
    };

    @SerializedName("list_view")
    @Expose
    private HealthCommonExpandViewConfig listView;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected PrivacyDataFragmentLayoutConfig(Parcel parcel) {
        this.listView = (HealthCommonExpandViewConfig) parcel.readParcelable(HealthCommonExpandViewConfig.class.getClassLoader());
    }

    public HealthCommonExpandViewConfig getListView() {
        return this.listView;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.listView, i);
    }
}
