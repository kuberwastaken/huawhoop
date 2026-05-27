package com.huawei.pluginfitnessadvice.plandata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class CreateRunPlanParams implements Parcelable {
    public static final Parcelable.Creator<CreateRunPlanParams> CREATOR = new Parcelable.Creator<CreateRunPlanParams>() { // from class: com.huawei.pluginfitnessadvice.plandata.CreateRunPlanParams.4
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cte_, reason: merged with bridge method [inline-methods] */
        public CreateRunPlanParams createFromParcel(Parcel parcel) {
            return new CreateRunPlanParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CreateRunPlanParams[] newArray(int i) {
            return new CreateRunPlanParams[i];
        }
    };

    @SerializedName("planInfo")
    private PlanInfoBean mPlanInfoBean;

    @SerializedName("userInfo")
    private UserInfoBean mUserInfoBean;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CreateRunPlanParams() {
    }

    private CreateRunPlanParams(Parcel parcel) {
        this.mUserInfoBean = (UserInfoBean) parcel.readParcelable(UserInfoBean.class.getClassLoader());
        this.mPlanInfoBean = (PlanInfoBean) parcel.readParcelable(PlanInfoBean.class.getClassLoader());
    }

    public void setUserInfoBean(UserInfoBean userInfoBean) {
        this.mUserInfoBean = userInfoBean;
    }

    public UserInfoBean getUserInfoBean() {
        return this.mUserInfoBean;
    }

    public PlanInfoBean getPlanInfoBean() {
        return this.mPlanInfoBean;
    }

    public void setPlanInfoBean(PlanInfoBean planInfoBean) {
        this.mPlanInfoBean = planInfoBean;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mUserInfoBean, i);
        parcel.writeParcelable(this.mPlanInfoBean, i);
    }
}
