package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.kqt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MusicFolderStruct implements Parcelable {
    public static final Parcelable.Creator<MusicFolderStruct> CREATOR = new Parcelable.Creator<MusicFolderStruct>() { // from class: com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicFolderStruct.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public MusicFolderStruct[] newArray(int i) {
            return new MusicFolderStruct[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bNF_, reason: merged with bridge method [inline-methods] */
        public MusicFolderStruct createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            String string = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(MusicStruct.CREATOR);
            MusicFolderStruct musicFolderStruct = new MusicFolderStruct();
            musicFolderStruct.setFolderName(string);
            musicFolderStruct.setFolderIndex(i);
            musicFolderStruct.setFolderMusicAssociationFrameCount(i2);
            musicFolderStruct.setMusicStructList(arrayListCreateTypedArrayList);
            musicFolderStruct.setFolderMusicCount(i3);
            ArrayList arrayList = new ArrayList(16);
            parcel.readList(arrayList, Integer.class.getClassLoader());
            musicFolderStruct.setMusicIndexList(arrayList);
            return musicFolderStruct;
        }
    };
    private int mFolderIndex;
    private int mFolderMusicAssociationFrameCount;
    private int mFolderMusicCount;
    private String mFolderName;
    private List<Integer> mMusicIndexList;
    private List<MusicStruct> mMusicStructList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFolderMusicCount() {
        return this.mFolderMusicCount;
    }

    public void setFolderMusicCount(int i) {
        this.mFolderMusicCount = i;
    }

    public List<MusicStruct> getMusicStructList() {
        return (List) kqt.e(this.mMusicStructList);
    }

    public void setMusicStructList(List<MusicStruct> list) {
        this.mMusicStructList = (List) kqt.e(list);
    }

    public String getFolderName() {
        return (String) kqt.e(this.mFolderName);
    }

    public void setFolderName(String str) {
        this.mFolderName = (String) kqt.e(str);
    }

    public int getFolderIndex() {
        return ((Integer) kqt.e(Integer.valueOf(this.mFolderIndex))).intValue();
    }

    public void setFolderIndex(int i) {
        this.mFolderIndex = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getFolderMusicAssociationFrameCount() {
        return ((Integer) kqt.e(Integer.valueOf(this.mFolderMusicAssociationFrameCount))).intValue();
    }

    public void setFolderMusicAssociationFrameCount(int i) {
        this.mFolderMusicAssociationFrameCount = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<Integer> getMusicIndexList() {
        return (List) kqt.e(this.mMusicIndexList);
    }

    public void setMusicIndexList(List<Integer> list) {
        this.mMusicIndexList = (List) kqt.e(list);
        setFolderMusicCount(list.size());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.mFolderName);
        parcel.writeInt(this.mFolderIndex);
        parcel.writeInt(this.mFolderMusicAssociationFrameCount);
        parcel.writeTypedList(this.mMusicStructList);
        parcel.writeInt(this.mFolderMusicCount);
        parcel.writeList(this.mMusicIndexList);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(" folderName:");
        sb.append(this.mFolderName);
        sb.append(" folderIndex:");
        sb.append(this.mFolderIndex);
        sb.append(" folderMusicAssociationFrameCount:");
        sb.append(this.mFolderMusicAssociationFrameCount);
        sb.append(" folderMusicCount:");
        sb.append(this.mFolderMusicCount);
        sb.append(" {");
        Iterator<MusicStruct> it = this.mMusicStructList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
