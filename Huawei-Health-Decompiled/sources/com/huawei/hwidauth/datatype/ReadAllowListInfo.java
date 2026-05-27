package com.huawei.hwidauth.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.mly;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes6.dex */
public class ReadAllowListInfo implements Parcelable {
    public static final Parcelable.Creator<ReadAllowListInfo> CREATOR = new Parcelable.Creator<ReadAllowListInfo>() { // from class: com.huawei.hwidauth.datatype.ReadAllowListInfo.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadAllowListInfo createFromParcel(Parcel parcel) {
            return new ReadAllowListInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadAllowListInfo[] newArray(int i) {
            return new ReadAllowListInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    protected ReadAllowListInfo(Parcel parcel) {
    }

    public static void a(XmlPullParser xmlPullParser, ArrayList<String> arrayList, String str) {
        if (xmlPullParser == null || str == null) {
            return;
        }
        if ("hosts".equals(xmlPullParser.getAttributeName(0))) {
            String attributeValue = xmlPullParser.getAttributeValue(0);
            if (TextUtils.isEmpty(attributeValue)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(attributeValue);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (JSONException unused) {
                mly.a("ReadAllowListInfo", "JSONException", true);
            }
        }
    }
}
