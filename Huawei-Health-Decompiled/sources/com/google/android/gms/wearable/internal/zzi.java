package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    private final String value;
    private byte zzbd;
    private final byte zzbe;

    public zzi(byte b, byte b2, String str) {
        this.zzbd = b;
        this.zzbe = b2;
        this.value = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, this.zzbd);
        SafeParcelWriter.writeByte(parcel, 3, this.zzbe);
        SafeParcelWriter.writeString(parcel, 4, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String toString() {
        byte b = this.zzbd;
        byte b2 = this.zzbe;
        String str = this.value;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 73);
        sb.append("AmsEntityUpdateParcelable{, mEntityId=");
        sb.append((int) b);
        sb.append(", mAttributeId=");
        sb.append((int) b2);
        sb.append(", mValue='");
        sb.append(str);
        sb.append("'}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzi zziVar = (zzi) obj;
        return this.zzbd == zziVar.zzbd && this.zzbe == zziVar.zzbe && this.value.equals(zziVar.value);
    }

    public final int hashCode() {
        byte b = this.zzbd;
        return ((((b + Ascii.US) * 31) + this.zzbe) * 31) + this.value.hashCode();
    }
}
