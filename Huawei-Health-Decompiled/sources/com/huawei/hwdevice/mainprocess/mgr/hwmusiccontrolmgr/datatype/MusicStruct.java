package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class MusicStruct implements Parcelable {
    public static final Parcelable.Creator<MusicStruct> CREATOR = new Parcelable.Creator<MusicStruct>() { // from class: com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicStruct.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MusicStruct[] newArray(int i) {
            return new MusicStruct[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bNJ_, reason: merged with bridge method [inline-methods] */
        public MusicStruct createFromParcel(Parcel parcel) {
            MusicStruct musicStruct = new MusicStruct();
            if (parcel == null) {
                return musicStruct;
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            String string3 = parcel.readString();
            int i2 = parcel.readInt();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            int i5 = parcel.readInt();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            String string11 = parcel.readString();
            musicStruct.setMusicName(string);
            musicStruct.setMusicSinger(string2);
            musicStruct.setMusicIndex(i);
            musicStruct.setFileName(string3);
            musicStruct.setFileId(i2);
            musicStruct.setMusicAlbum(string4);
            musicStruct.setMusicId(string5);
            musicStruct.setMusicType(i3);
            musicStruct.setMusicCopyright(i4);
            musicStruct.setMusicEncryption(i5);
            musicStruct.setMusicKey(string6);
            musicStruct.setMusicIv(string7);
            musicStruct.setAccountName(string8);
            musicStruct.setMusicAppType(i6);
            musicStruct.setMusicDuration(i7);
            musicStruct.setMusicFolder(string9);
            musicStruct.setMusicAlbumId(string10);
            musicStruct.setPackageName(string11);
            return musicStruct;
        }
    };
    private String mAccountName;
    private int mFileId;
    private String mFileName;
    private String mMusicAlbum;
    private String mMusicAlbumId;
    private String mMusicFolder;
    private String mMusicId;
    private int mMusicIndex;
    private String mMusicIv;
    private String mMusicKey;
    private String mMusicName;
    private String mMusicSinger;
    private String mPackageName;
    private int mMusicType = -1;
    private int mMusicCopyright = -1;
    private int mMusicEncryption = -1;
    private int mMusicAppType = -1;
    private int mMusicDuration = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMusicName() {
        return (String) kqt.e(this.mMusicName);
    }

    public void setMusicName(String str) {
        this.mMusicName = (String) kqt.e(str);
    }

    public String getMusicSinger() {
        return (String) kqt.e(this.mMusicSinger);
    }

    public void setMusicSinger(String str) {
        this.mMusicSinger = (String) kqt.e(str);
    }

    public int getMusicIndex() {
        return ((Integer) kqt.e(Integer.valueOf(this.mMusicIndex))).intValue();
    }

    public void setMusicIndex(int i) {
        this.mMusicIndex = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getFileName() {
        return (String) kqt.e(this.mFileName);
    }

    public void setFileName(String str) {
        this.mFileName = (String) kqt.e(str);
    }

    public int getFileId() {
        return ((Integer) kqt.e(Integer.valueOf(this.mFileId))).intValue();
    }

    public void setFileId(int i) {
        this.mFileId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getMusicAlbum() {
        return (String) kqt.e(this.mMusicAlbum);
    }

    public void setMusicAlbum(String str) {
        this.mMusicAlbum = (String) kqt.e(str);
    }

    public String getMusicId() {
        return (String) kqt.e(this.mMusicId);
    }

    public void setMusicId(String str) {
        this.mMusicId = (String) kqt.e(str);
    }

    public int getMusicType() {
        return ((Integer) kqt.e(Integer.valueOf(this.mMusicType))).intValue();
    }

    public void setMusicType(int i) {
        this.mMusicType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getMusicCopyright() {
        return ((Integer) kqt.e(Integer.valueOf(this.mMusicCopyright))).intValue();
    }

    public void setMusicCopyright(int i) {
        this.mMusicCopyright = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getMusicEncryption() {
        return ((Integer) kqt.e(Integer.valueOf(this.mMusicEncryption))).intValue();
    }

    public void setMusicEncryption(int i) {
        this.mMusicEncryption = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getMusicKey() {
        return (String) kqt.e(this.mMusicKey);
    }

    public void setMusicKey(String str) {
        this.mMusicKey = (String) kqt.e(str);
    }

    public String getMusicIv() {
        return (String) kqt.e(this.mMusicIv);
    }

    public void setMusicIv(String str) {
        this.mMusicIv = (String) kqt.e(str);
    }

    public String getAccountName() {
        return (String) kqt.e(this.mAccountName);
    }

    public void setAccountName(String str) {
        this.mAccountName = (String) kqt.e(str);
    }

    public int getMusicAppType() {
        return ((Integer) kqt.e(Integer.valueOf(this.mMusicAppType))).intValue();
    }

    public void setMusicAppType(int i) {
        this.mMusicAppType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getMusicDuration() {
        return ((Integer) kqt.e(Integer.valueOf(this.mMusicDuration))).intValue();
    }

    public void setMusicDuration(int i) {
        this.mMusicDuration = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getMusicFolder() {
        return (String) kqt.e(this.mMusicFolder);
    }

    public void setMusicFolder(String str) {
        this.mMusicFolder = (String) kqt.e(str);
    }

    public String getMusicAlbumId() {
        return (String) kqt.e(this.mMusicAlbumId);
    }

    public void setMusicAlbumId(String str) {
        this.mMusicAlbumId = (String) kqt.e(str);
    }

    public String getPackageName() {
        return (String) kqt.e(this.mPackageName);
    }

    public void setPackageName(String str) {
        this.mPackageName = (String) kqt.e(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.mMusicName);
        parcel.writeString(this.mMusicSinger);
        parcel.writeInt(this.mMusicIndex);
        parcel.writeString(this.mFileName);
        parcel.writeInt(this.mFileId);
        parcel.writeString(this.mMusicAlbum);
        parcel.writeString(this.mMusicId);
        parcel.writeInt(this.mMusicType);
        parcel.writeInt(this.mMusicCopyright);
        parcel.writeInt(this.mMusicEncryption);
        parcel.writeString(this.mMusicKey);
        parcel.writeString(this.mMusicIv);
        parcel.writeString(this.mAccountName);
        parcel.writeInt(this.mMusicAppType);
        parcel.writeInt(this.mMusicDuration);
        parcel.writeString(this.mMusicFolder);
        parcel.writeString(this.mMusicAlbumId);
        parcel.writeString(this.mPackageName);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("[ musicName:");
        sb.append(this.mMusicName);
        sb.append(" musicSinger:");
        sb.append(this.mMusicSinger);
        sb.append(" musicIndex:");
        sb.append(this.mMusicIndex);
        sb.append(" fileName:");
        sb.append(this.mFileName);
        sb.append(" MusicAlbum:");
        sb.append(this.mMusicAlbum);
        sb.append(" MusicId:");
        sb.append(this.mMusicId);
        sb.append(" MusicType:");
        sb.append(this.mMusicType);
        sb.append(" MusicCopyright:");
        sb.append(this.mMusicCopyright);
        sb.append(" MusicEncryption:");
        sb.append(this.mMusicEncryption);
        sb.append(" MusicKey:");
        sb.append(this.mMusicKey);
        sb.append(" MusicIv:");
        sb.append(this.mMusicIv);
        sb.append(" AccountName:");
        sb.append(this.mAccountName);
        sb.append(" MusicAppType:");
        sb.append(this.mMusicAppType);
        sb.append(" MusicDuration:");
        sb.append(this.mMusicDuration);
        sb.append(" MusicFolder:");
        sb.append(this.mMusicFolder);
        sb.append(" MusicAlbumId:");
        sb.append(this.mMusicAlbumId);
        sb.append(" PackageName:");
        sb.append(this.mPackageName);
        sb.append("]");
        return sb.toString();
    }
}
