package com.huawei.hwidauth.utils.globalcfg;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class CountryInfoForCFG implements Parcelable {
    public static final Parcelable.Creator<CountryInfoForCFG> CREATOR = new Parcelable.Creator<CountryInfoForCFG>() { // from class: com.huawei.hwidauth.utils.globalcfg.CountryInfoForCFG.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CountryInfoForCFG createFromParcel(Parcel parcel) {
            return new CountryInfoForCFG(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CountryInfoForCFG[] newArray(int i) {
            return new CountryInfoForCFG[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6603a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CountryInfoForCFG() {
    }

    protected CountryInfoForCFG(Parcel parcel) {
        this.f6603a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6603a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    public String a() {
        return this.f6603a;
    }

    public void a(String str) {
        this.f6603a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String b() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public String c() {
        return this.f;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public String d() {
        return this.h;
    }

    public void h(String str) {
        this.h = str;
    }
}
