package com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.health.R;
import com.huawei.hwcommonmodel.application.BaseApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class EversionExcursionAngleAdvice extends RunningPostureAdviceBase {
    public static final Parcelable.Creator<EversionExcursionAngleAdvice> CREATOR = new Parcelable.Creator<EversionExcursionAngleAdvice>() { // from class: com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.EversionExcursionAngleAdvice.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bnO_, reason: merged with bridge method [inline-methods] */
        public EversionExcursionAngleAdvice createFromParcel(Parcel parcel) {
            return new EversionExcursionAngleAdvice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public EversionExcursionAngleAdvice[] newArray(int i) {
            return new EversionExcursionAngleAdvice[i];
        }
    };
    private static final int LEVEL_NORMAL_END_NUMBER = 25;
    private static final int LEVEL_NORMAL_START_NUMBER = 5;
    private static final String RUNNING_POSTURE_EVERSION_FRAGMENT = "com.huawei.health.suggestion.ui.fragment.EversionExcursionFragment";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public int judgeLevel(float f) {
        if (f < 5.0f) {
            return 0;
        }
        return f > 25.0f ? 3 : 1;
    }

    public EversionExcursionAngleAdvice(int i) {
        this.mPostureId = 8;
        initData(i);
    }

    protected EversionExcursionAngleAdvice(Parcel parcel) {
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
        this.mActionList.add("117B");
        this.mActionList.add("118B");
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public String getText() {
        return BaseApplication.getContext().getResources().getString(R.string._2130843101_res_0x7f0215dd);
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
    public void judgeAdvices(int i) {
        super.judgeAdvices(i);
        this.mLevelLongTip = R.string._2130843256_res_0x7f021678;
        if (i == 0) {
            this.mLevelShortTip = R.string._2130843238_res_0x7f021666;
            this.mAdvice = R.string._2130843255_res_0x7f021677;
        } else if (i == 1) {
            this.mLevelShortTip = R.string._2130845603_res_0x7f021fa3;
            this.mAdvice = R.string._2130843257_res_0x7f021679;
        } else {
            this.mLevelShortTip = R.string._2130843237_res_0x7f021665;
            this.mAdvice = R.string._2130843265_res_0x7f021681;
        }
    }

    @Override // com.huawei.healthcloud.plugintrack.ui.runningpostureadvicemgr.RunningPostureAdviceBase
    public String getRunningPostureFragment() {
        return RUNNING_POSTURE_EVERSION_FRAGMENT;
    }
}
