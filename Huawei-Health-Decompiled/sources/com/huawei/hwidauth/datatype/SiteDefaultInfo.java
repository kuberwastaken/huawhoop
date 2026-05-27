package com.huawei.hwidauth.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.mly;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes6.dex */
public class SiteDefaultInfo implements Parcelable {
    public static final Parcelable.Creator<SiteDefaultInfo> CREATOR = new Parcelable.Creator<SiteDefaultInfo>() { // from class: com.huawei.hwidauth.datatype.SiteDefaultInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SiteDefaultInfo createFromParcel(Parcel parcel) {
            SiteDefaultInfo siteDefaultInfo = new SiteDefaultInfo();
            siteDefaultInfo.f6585a = parcel.readString();
            siteDefaultInfo.b = parcel.readString();
            siteDefaultInfo.c = parcel.readString();
            siteDefaultInfo.d = parcel.readString();
            return siteDefaultInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public SiteDefaultInfo[] newArray(int i) {
            return new SiteDefaultInfo[i];
        }
    };
    public static final String TAG = "SiteDefaultInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6585a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static void a(XmlPullParser xmlPullParser, SiteDefaultInfo siteDefaultInfo) {
        try {
            if ("domain".equals(xmlPullParser.getAttributeName(0))) {
                JSONObject jSONObject = new JSONObject(xmlPullParser.getAttributeValue(0));
                siteDefaultInfo.a(a(jSONObject, "logout").trim());
                siteDefaultInfo.b(a(jSONObject, "qrauth").trim());
                siteDefaultInfo.c(a(jSONObject, "cas").trim());
                siteDefaultInfo.e(a(jSONObject, "honor-cas").trim());
                siteDefaultInfo.d(a(jSONObject, "as").trim());
            }
        } catch (JSONException e) {
            mly.a(TAG, "parseJSONArrayInfos JSONException: " + e.getClass().getSimpleName(), true);
        } catch (Exception e2) {
            mly.a(TAG, "parseJSONArrayInfos Exception: " + e2.getClass().getSimpleName(), true);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6585a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public String a() {
        return this.f6585a;
    }

    private void a(String str) {
        this.f6585a = str;
    }

    public String b() {
        return this.b;
    }

    private void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    private void c(String str) {
        this.c = str;
    }

    private void d(String str) {
        this.e = str;
    }

    private void e(String str) {
        this.d = str;
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : "";
    }
}
