package com.huawei.animationkit.computationalwallpaper.generator;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.animationkit.computationalwallpaper.coloranalysis.ColorResult;
import defpackage.awb;
import defpackage.axt;
import java.util.Properties;

/* JADX INFO: loaded from: classes10.dex */
public class ResolverResult implements Parcelable {
    public static final Parcelable.Creator<ResolverResult> CREATOR = new Parcelable.Creator<ResolverResult>() { // from class: com.huawei.animationkit.computationalwallpaper.generator.ResolverResult.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: gZ_, reason: merged with bridge method [inline-methods] */
        public ResolverResult createFromParcel(Parcel parcel) {
            return new ResolverResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolverResult[] newArray(int i) {
            return new ResolverResult[i];
        }
    };
    private final axt mAiResult;
    private final ColorResult mColorResult;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ResolverResult(ColorResult colorResult, axt axtVar) {
        this.mColorResult = colorResult;
        this.mAiResult = axtVar;
    }

    protected ResolverResult(Parcel parcel) {
        this.mColorResult = (ColorResult) parcel.readParcelable(ColorResult.class.getClassLoader());
        this.mAiResult = null;
    }

    public ColorResult getColorResult() {
        return this.mColorResult;
    }

    public axt getAiResult() {
        return this.mAiResult;
    }

    public void save(Properties properties) {
        this.mColorResult.save(properties);
    }

    public void load(Properties properties) throws awb {
        this.mColorResult.load(properties);
    }

    public String toString() {
        return "{aiResult=" + this.mAiResult + ", colorResult=" + this.mColorResult + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mColorResult, i);
    }
}
