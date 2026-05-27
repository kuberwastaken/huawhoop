package com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.health.R;
import com.huawei.hwcommonmodel.application.BaseApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class GroundImpactAccelerationAdvice extends RunningPostureAdviceBase {
    public static final Parcelable.Creator<GroundImpactAccelerationAdvice> CREATOR = new Parcelable.Creator<GroundImpactAccelerationAdvice>() { // from class: com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.GroundImpactAccelerationAdvice.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bnR_, reason: merged with bridge method [inline-methods] */
        public GroundImpactAccelerationAdvice createFromParcel(Parcel parcel) {
            return new GroundImpactAccelerationAdvice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public GroundImpactAccelerationAdvice[] newArray(int i) {
            return new GroundImpactAccelerationAdvice[i];
        }
    };
    private static final int GROUND_IMPACT_ACCELERATION_LEVEL_NORMAL = 20;
    private static final String RUNNING_POSTURE_LANDING_FRAGMENT = "com.huawei.health.suggestion.ui.fragment.LandingImpactFragment";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public int judgeLevel(float f) {
        return f <= 20.0f ? 1 : 3;
    }

    public GroundImpactAccelerationAdvice(int i) {
        this.mPostureId = 11;
        initData(i);
    }

    protected GroundImpactAccelerationAdvice(Parcel parcel) {
        if (parcel == null) {
            throw new RuntimeException("Invaild input");
        }
        this.mValue = parcel.readFloat();
        this.mLevel = parcel.readInt();
        this.mLevelShortTip = parcel.readInt();
        this.mLevelLongTip = parcel.readInt();
        this.mAdvice = parcel.readInt();
        this.mActionList = parcel.createStringArrayList();
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public void initActionList() {
        this.mActionList = new ArrayList(2);
        this.mActionList.add("018B");
        this.mActionList.add("001B");
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public String getText() {
        return BaseApplication.getContext().getResources().getString(R.string._2130843053_res_0x7f0215ad);
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public void judgeAdvices(int i) {
        super.judgeAdvices(i);
        if (i == 1) {
            this.mLevelShortTip = R.string._2130841753_res_0x7f021099;
            this.mLevelLongTip = R.string._2130846577_res_0x7f022371;
            this.mAdvice = R.string._2130843260_res_0x7f02167c;
        } else {
            this.mLevelShortTip = R.string._2130843237_res_0x7f021665;
            this.mLevelLongTip = R.string._2130843094_res_0x7f0215d6;
            this.mAdvice = R.string._2130843261_res_0x7f02167d;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeFloat(this.mValue);
        parcel.writeInt(this.mLevel);
        parcel.writeInt(this.mLevelShortTip);
        parcel.writeInt(this.mLevelLongTip);
        parcel.writeInt(this.mAdvice);
        parcel.writeStringList(this.mActionList);
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public String getRunningPostureFragment() {
        return RUNNING_POSTURE_LANDING_FRAGMENT;
    }
}
