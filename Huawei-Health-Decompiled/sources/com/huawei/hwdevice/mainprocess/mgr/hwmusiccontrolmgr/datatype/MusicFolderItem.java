package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class MusicFolderItem implements Parcelable {
    public static final Parcelable.Creator<MusicFolderItem> CREATOR = new Parcelable.Creator<MusicFolderItem>() { // from class: com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicFolderItem.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bNE_, reason: merged with bridge method [inline-methods] */
        public MusicFolderItem createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            MusicFolderItem musicFolderItem = new MusicFolderItem();
            musicFolderItem.setFolderName(string);
            musicFolderItem.setNumber(string2);
            return musicFolderItem;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicFolderItem[] newArray(int i) {
            return new MusicFolderItem[i];
        }
    };
    private String folderName;
    private String number;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public void setFolderName(String str) {
        this.folderName = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.folderName);
        parcel.writeString(this.number);
    }
}
