package com.huawei.hihealth;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HiHealthKitDataOhos implements Parcelable {
    public static final Parcelable.Creator<HiHealthKitDataOhos> CREATOR = new Parcelable.Creator<HiHealthKitDataOhos>() { // from class: com.huawei.hihealth.HiHealthKitDataOhos.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bAF_, reason: merged with bridge method [inline-methods] */
        public HiHealthKitDataOhos createFromParcel(Parcel parcel) {
            return new HiHealthKitDataOhos(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public HiHealthKitDataOhos[] newArray(int i) {
            return new HiHealthKitDataOhos[i];
        }
    };
    private static final int DEFAULT_SIZE = 16;
    private static final double DEFAULT_VALUE = -1.0d;
    private static final String DOUBLE = "Double";
    private static final String FLOAT = "Float";
    private static final String INTEGER = "Integer";
    private static final int INVALID_VALUE = -1;
    private static final String LONG = "Long";
    private static final int MAP_INITIAL_CAPACITY = 16;
    private static final String PRECISION_DEFAULT = "-1";
    private static final String PRECISION_DOUBLE = "3";
    private static final String PRECISION_FLOAT = "2";
    private static final String PRECISION_INT = "0";
    private static final String PRECISION_LONG = "1";
    private List<String> mHolderConstraint;
    private List<String> mHolderValue;
    private Map mMap;
    private List<String> mMapConstraint;
    private List<String> mMapValue;
    private List<String> mMapValueType;
    private int mType;
    private ContentValues mValueHolder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HiHealthKitDataOhos() {
        this.mHolderConstraint = new ArrayList(16);
        this.mHolderValue = new ArrayList(16);
        this.mMapConstraint = new ArrayList(16);
        this.mMapValue = new ArrayList(16);
        this.mMapValueType = new ArrayList(16);
        this.mValueHolder = new ContentValues();
        this.mMap = new HashMap(16);
    }

    public HiHealthKitDataOhos(Parcel parcel) {
        this.mHolderConstraint = new ArrayList(16);
        this.mHolderValue = new ArrayList(16);
        this.mMapConstraint = new ArrayList(16);
        this.mMapValue = new ArrayList(16);
        this.mMapValueType = new ArrayList(16);
        parcel.readStringList(this.mHolderConstraint);
        parcel.readStringList(this.mHolderValue);
        parcel.readStringList(this.mMapConstraint);
        parcel.readStringList(this.mMapValue);
        parcel.readStringList(this.mMapValueType);
        this.mType = parcel.readInt();
        constructMap();
        constructValueHolder();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void constructMap() {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hihealth.HiHealthKitDataOhos.constructMap():void");
    }

    private Object getKeyOfMap(String str, String str2) {
        str2.hashCode();
        return !str2.equals("0") ? str : Integer.valueOf(str);
    }

    private void constructValueHolder() {
        List<String> list = this.mHolderValue;
        if (list == null || list.isEmpty() || this.mHolderValue.size() != this.mHolderConstraint.size()) {
            return;
        }
        for (int i = 0; i < this.mHolderConstraint.size(); i++) {
            if (this.mValueHolder == null) {
                this.mValueHolder = new ContentValues();
            }
            this.mValueHolder.put(this.mHolderConstraint.get(i), this.mHolderValue.get(i));
        }
    }

    public void setContentValues(ContentValues contentValues) {
        this.mValueHolder = contentValues;
        if (contentValues == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            this.mHolderConstraint.add(entry.getKey());
            this.mHolderValue.add(String.valueOf(entry.getValue()));
        }
    }

    public ContentValues getContentValues() {
        return this.mValueHolder;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mHolderConstraint);
        parcel.writeStringList(this.mHolderValue);
        parcel.writeStringList(this.mMapConstraint);
        parcel.writeStringList(this.mMapValue);
        parcel.writeStringList(this.mMapValueType);
        parcel.writeInt(this.mType);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setMap(Map map) {
        this.mMap = map;
        if (map == null || map.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(16);
        for (Map.Entry entry : this.mMap.entrySet()) {
            this.mMapConstraint.add(String.valueOf(entry.getKey()));
            arrayList.add(getMapType(entry.getKey()));
            this.mMapValue.add(String.valueOf(entry.getValue()));
            this.mMapValueType.add(getMapType(entry.getValue()));
        }
        this.mMapValueType.addAll(arrayList);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private String getMapType(Object obj) {
        String name = obj.getClass().getName();
        if (TextUtils.isEmpty(name)) {
            return "-1";
        }
        int iLastIndexOf = name.lastIndexOf(".");
        byte b = -1;
        if (iLastIndexOf == -1) {
            return "-1";
        }
        String strSubstring = name.substring(iLastIndexOf + 1);
        strSubstring.hashCode();
        switch (strSubstring.hashCode()) {
            case -672261858:
                if (strSubstring.equals(INTEGER)) {
                    b = 0;
                }
                break;
            case 2374300:
                if (strSubstring.equals(LONG)) {
                    b = 1;
                }
                break;
            case 67973692:
                if (strSubstring.equals(FLOAT)) {
                    b = 2;
                }
                break;
            case 2052876273:
                if (strSubstring.equals(DOUBLE)) {
                    b = 3;
                }
                break;
        }
        return b != 0 ? b != 1 ? b != 2 ? b != 3 ? "-1" : "3" : "2" : "1" : "0";
    }

    public Map getMap() {
        return this.mMap;
    }
}
