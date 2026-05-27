package com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.health.R;
import com.huawei.hwcommonmodel.application.BaseApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class GroundVerticalAmplitudeAdvice extends RunningPostureAdviceBase {
    public static final Parcelable.Creator<GroundVerticalAmplitudeAdvice> CREATOR = new Parcelable.Creator<GroundVerticalAmplitudeAdvice>() { // from class: com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.GroundVerticalAmplitudeAdvice.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bnV_, reason: merged with bridge method [inline-methods] */
        public GroundVerticalAmplitudeAdvice createFromParcel(Parcel parcel) {
            return new GroundVerticalAmplitudeAdvice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public GroundVerticalAmplitudeAdvice[] newArray(int i) {
            return new GroundVerticalAmplitudeAdvice[i];
        }
    };
    public static final float GROUND_VERTICAL_AMPLITUDE_LEVEL_EXCELLENT = 5.5f;
    public static final int GROUND_VERTICAL_AMPLITUDE_LEVEL_NORMAL = 8;
    public static final int GROUND_VERTICAL_AMPLITUDE_LEVEL_POORER = 15;
    public static final int GROUND_VERTICAL_AMPLITUDE_LEVEL_SUBOPTIMAL = 12;
    private static final String RUNNING_POSTURE_VERTICAL_FRAGMENT = "com.huawei.health.suggestion.ui.fragment.VerticalOscillationFragment";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GroundVerticalAmplitudeAdvice(float f) {
        this.mPostureId = 4;
        initData(f);
    }

    protected GroundVerticalAmplitudeAdvice(Parcel parcel) {
        if (parcel != null) {
            this.mValue = parcel.readFloat();
            this.mLevel = parcel.readInt();
            this.mLevelShortTip = parcel.readInt();
            this.mLevelLongTip = parcel.readInt();
            this.mAdvice = parcel.readInt();
            this.mDescription = parcel.readInt();
            this.mActionList = parcel.createStringArrayList();
        }
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public int judgeLevel(float f) {
        if (Float.compare(f, 5.5f) <= 0) {
            return 3;
        }
        if (Float.compare(f, 8.0f) <= 0) {
            return 2;
        }
        if (Float.compare(f, 12.0f) <= 0) {
            return 1;
        }
        return Float.compare(f, 15.0f) <= 0 ? 0 : -1;
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public void initActionList() {
        this.mActionList = new ArrayList(2);
        this.mActionList.add("002B");
        this.mActionList.add("001B");
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public String getText() {
        return BaseApplication.getContext().getResources().getString(R.string._2130845508_res_0x7f021f44);
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public void judgeAdvices(int i) {
        super.judgeAdvices(i);
        this.mAdvice = R.string._2130845645_res_0x7f021fcd;
        this.mDescription = R.string._2130845646_res_0x7f021fce;
        this.mLevelLongTip = R.string._2130845786_res_0x7f02205a;
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
        parcel.writeInt(this.mDescription);
        parcel.writeStringList(this.mActionList);
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public float getValue() {
        return this.mValue;
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public String getRunningPostureFragment() {
        return RUNNING_POSTURE_VERTICAL_FRAGMENT;
    }
}
