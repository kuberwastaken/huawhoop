package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.haf.common.utils.CollectionUtils;
import defpackage.kqt;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes6.dex */
public class OperationStruct implements Parcelable {
    public static final Parcelable.Creator<OperationStruct> CREATOR = new Parcelable.Creator<OperationStruct>() { // from class: com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.OperationStruct.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OperationStruct[] newArray(int i) {
            return new OperationStruct[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bNL_, reason: merged with bridge method [inline-methods] */
        public OperationStruct createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string = parcel.readString();
            int i3 = parcel.readInt();
            OperationStruct operationStruct = new OperationStruct();
            operationStruct.setOperationType(i);
            operationStruct.setFolderIndex(i2);
            operationStruct.setFolderName(string);
            operationStruct.setOperateResult(i3);
            return operationStruct;
        }
    };
    private int mFolderIndex;
    private String mFolderName;
    private List<Integer> mMusicIndexs;
    private int mOperateResult;
    private int mOperationType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getOperationType() {
        return ((Integer) kqt.e(Integer.valueOf(this.mOperationType))).intValue();
    }

    public void setOperationType(int i) {
        this.mOperationType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getFolderIndex() {
        return ((Integer) kqt.e(Integer.valueOf(this.mFolderIndex))).intValue();
    }

    public void setFolderIndex(int i) {
        this.mFolderIndex = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<Integer> getMusicIndexs() {
        return (List) kqt.e(this.mMusicIndexs);
    }

    public void setMusicIndexs(List<Integer> list) {
        if (!CollectionUtils.e(list)) {
            this.mMusicIndexs = (List) kqt.e((List) list.stream().distinct().collect(Collectors.toList()));
        } else {
            this.mMusicIndexs = (List) kqt.e(list);
        }
    }

    public int getOperateResult() {
        return ((Integer) kqt.e(Integer.valueOf(this.mOperateResult))).intValue();
    }

    public void setOperateResult(int i) {
        this.mOperateResult = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getFolderName() {
        return (String) kqt.e(this.mFolderName);
    }

    public void setFolderName(String str) {
        this.mFolderName = (String) kqt.e(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.mOperationType);
        parcel.writeInt(this.mFolderIndex);
        parcel.writeString(this.mFolderName);
        parcel.writeInt(this.mOperateResult);
    }

    public String toString() {
        List<Integer> list = this.mMusicIndexs;
        String string = list != null ? list.toString() : "";
        StringBuilder sb = new StringBuilder(16);
        sb.append("{operationType:");
        sb.append(this.mOperationType);
        sb.append(",folderIndex:");
        sb.append(this.mFolderIndex);
        sb.append(",musicIndex:");
        sb.append(string);
        sb.append(",folderName:");
        sb.append(this.mFolderName);
        sb.append(",operateResult:");
        sb.append(this.mOperateResult);
        sb.append("}");
        return sb.toString();
    }
}
