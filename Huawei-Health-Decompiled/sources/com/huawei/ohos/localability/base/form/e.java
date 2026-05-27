package com.huawei.ohos.localability.base.form;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
class e implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6789a;
    private int b;
    private b c;
    private Set<String> d;
    private String e;

    static final class c implements Parcelable.Creator<e> {
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i) {
            if (i >= 0) {
                return new e[i];
            }
            return null;
        }
    }

    public e(Parcel parcel) {
        String[] strArr;
        this.f6789a = parcel.readString();
        parcel.readInt();
        b bVarCreateFromParcel = null;
        this.d = null;
        if (parcel.readInt() == 1) {
            int i = parcel.readInt();
            if (i < 0 || i > 512000) {
                strArr = new String[0];
            } else {
                strArr = new String[i];
                for (int i2 = 0; i2 < i; i2++) {
                    strArr[i2] = parcel.readString();
                }
            }
            this.d = new HashSet(Arrays.asList(strArr));
        }
        this.b = parcel.readInt();
        this.c = null;
        if (parcel.readInt() != 1) {
            this.c = bVarCreateFromParcel;
        } else if (parcel.readInt() != 0) {
            bVarCreateFromParcel = b.d.createFromParcel(parcel);
            this.c = bVarCreateFromParcel;
        }
        parcel.readInt();
        this.e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6789a);
        parcel.writeInt(-1);
        parcel.writeInt(-1);
        parcel.writeInt(this.b);
        if (this.c == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(1);
            this.c.writeToParcel(parcel, 0);
        }
        parcel.writeInt(-1);
        parcel.writeString(this.e);
        parcel.writeInt(-1);
    }

    public int hashCode() {
        String str = this.f6789a;
        int iHashCode = str != null ? str.hashCode() : 0;
        b bVar = this.c;
        if (bVar != null) {
            iHashCode += bVar.hashCode();
        }
        Set<String> set = this.d;
        if (set != null) {
            iHashCode += set.hashCode();
        }
        String str2 = this.e;
        return str2 != null ? iHashCode + str2.hashCode() : iHashCode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (Objects.equals(this.f6789a, eVar.f6789a) && Objects.equals(this.e, eVar.e) && Objects.equals(this.c, eVar.c) && Objects.equals(this.d, eVar.d)) {
                return true;
            }
        }
        return false;
    }

    public e() {
        this.b = 0;
    }
}
