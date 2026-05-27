package com.huawei.animationkit.computationalwallpaper.coloranalysis;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.awb;
import defpackage.awi;
import defpackage.awq;
import defpackage.awt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes10.dex */
public class ColorResult implements Parcelable {
    private static final String ADDITIONAL_COLORS = "additional_colors";
    private static final String ADDITIONAL_GRADIENTS = "additional_gradients";
    private static final String COLOR_DELIMITER = ",";
    public static final Parcelable.Creator<ColorResult> CREATOR = new Parcelable.Creator<ColorResult>() { // from class: com.huawei.animationkit.computationalwallpaper.coloranalysis.ColorResult.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: gT_, reason: merged with bridge method [inline-methods] */
        public ColorResult createFromParcel(Parcel parcel) {
            try {
                return new ColorResult(parcel);
            } catch (awb e) {
                parcel.writeException(e);
                return null;
            }
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ColorResult[] newArray(int i) {
            return new ColorResult[i];
        }
    };
    private static final String MAIN_COLORS = "main_colors";
    private static final String MAIN_GRADIENTS = "main_gradients";
    private static final String PROPERTY_DELIMITER = ":";
    private List<awi> mAdditionalColors;
    private List<awi> mAdditionalGradients;
    private List<awi> mMainColors;
    private List<awi> mMainGradients;
    private List<awi> mOriginalColors;
    private List<List<awi>> mProcessHistory;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ColorResult() {
        this.mMainColors = Collections.emptyList();
        this.mMainGradients = Collections.emptyList();
        this.mAdditionalColors = Collections.emptyList();
        this.mAdditionalGradients = Collections.emptyList();
    }

    public ColorResult(ColorResult colorResult) {
        this.mOriginalColors = new ArrayList(colorResult.getOriginalColors());
        this.mMainColors = new ArrayList(colorResult.getMainColors());
        this.mAdditionalColors = new ArrayList(colorResult.getAdditionalColors());
        this.mMainGradients = new ArrayList(colorResult.getMainGradients());
        this.mAdditionalGradients = new ArrayList(colorResult.getAdditionalGradients());
    }

    protected ColorResult(Parcel parcel) throws awb {
        initColor(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    public List<awi> getOriginalColors() {
        return this.mOriginalColors;
    }

    public void setOriginalColors(List<awi> list) {
        this.mOriginalColors = list;
    }

    public List<awi> getMainColors() {
        return this.mMainColors;
    }

    public void setMainColors(List<awi> list) {
        this.mMainColors = list;
    }

    public List<awi> getAdditionalColors() {
        return this.mAdditionalColors;
    }

    public void setAdditionalColors(List<awi> list) {
        this.mAdditionalColors = list;
    }

    public List<awi> getMainGradients() {
        return this.mMainGradients;
    }

    public void setMainGradients(List<awi> list) {
        this.mMainGradients = list;
    }

    public List<awi> getAdditionalGradients() {
        return this.mAdditionalGradients;
    }

    public void setAdditionalGradients(List<awi> list) {
        this.mAdditionalGradients = list;
    }

    public List<Integer> getAllColors() {
        List<Integer> list = (List) this.mMainColors.stream().map(new awt()).collect(Collectors.toList());
        List<awi> list2 = this.mAdditionalColors;
        if (list2 != null) {
            list.addAll((Collection) list2.stream().map(new awt()).collect(Collectors.toList()));
        }
        return list;
    }

    public List<Integer> getAllGradients() {
        List<Integer> list = (List) this.mMainGradients.stream().map(new awt()).collect(Collectors.toList());
        List<awi> list2 = this.mAdditionalGradients;
        if (list2 != null) {
            list.addAll((Collection) list2.stream().map(new awt()).collect(Collectors.toList()));
        }
        return list;
    }

    public void save(Properties properties) {
        properties.put(MAIN_COLORS, (String) this.mMainColors.stream().map(new awq(this)).collect(Collectors.joining(",")));
        properties.put(ADDITIONAL_COLORS, (String) this.mAdditionalColors.stream().map(new awq(this)).collect(Collectors.joining(",")));
        properties.put(MAIN_GRADIENTS, (String) this.mMainGradients.stream().map(new awq(this)).collect(Collectors.joining(",")));
        properties.put(ADDITIONAL_GRADIENTS, (String) this.mAdditionalGradients.stream().map(new awq(this)).collect(Collectors.joining(",")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatColor(awi awiVar) {
        return awiVar.a() + ":" + awiVar.e();
    }

    public void load(Properties properties) throws awb {
        initColor(properties.getProperty(MAIN_COLORS), properties.getProperty(MAIN_GRADIENTS), properties.getProperty(ADDITIONAL_COLORS), properties.getProperty(ADDITIONAL_GRADIENTS));
    }

    public void addHistory(List<awi> list) {
        if (this.mProcessHistory == null) {
            this.mProcessHistory = new ArrayList();
        }
        this.mProcessHistory.add(list);
    }

    public List<List<awi>> getHistory() {
        return this.mProcessHistory;
    }

    private void initColor(String str, String str2, String str3, String str4) throws awb {
        this.mMainColors = new ArrayList();
        for (String str5 : str.split(",")) {
            this.mMainColors.add(parseColor(str5));
        }
        this.mMainGradients = new ArrayList();
        for (String str6 : str2.split(",")) {
            this.mMainGradients.add(parseColor(str6));
        }
        if (str3 != null && !str3.isEmpty()) {
            this.mAdditionalColors = new ArrayList();
            String[] strArrSplit = str3.split(",");
            for (String str7 : strArrSplit) {
                this.mAdditionalColors.add(parseColor(str7));
            }
        }
        if (str4 == null || str4.isEmpty()) {
            return;
        }
        this.mAdditionalGradients = new ArrayList();
        for (String str8 : str4.split(",")) {
            this.mAdditionalGradients.add(parseColor(str8));
        }
    }

    private awi parseColor(String str) throws awb {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2) {
            throw new awb("parse color failed " + str);
        }
        try {
            return new awi(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        } catch (NumberFormatException e) {
            throw new awb(e);
        }
    }

    public String toString() {
        return "{mainColors=" + this.mMainColors + ", additionalColors=" + this.mAdditionalColors + ", mainGradients=" + this.mMainGradients + ", additionalGradients=" + this.mAdditionalGradients + ", originalColors=" + this.mOriginalColors + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString((String) this.mMainColors.stream().map(new awq(this)).collect(Collectors.joining(",")));
        parcel.writeString((String) this.mAdditionalColors.stream().map(new awq(this)).collect(Collectors.joining(",")));
        parcel.writeString((String) this.mMainGradients.stream().map(new awq(this)).collect(Collectors.joining(",")));
        parcel.writeString((String) this.mAdditionalGradients.stream().map(new awq(this)).collect(Collectors.joining(",")));
    }
}
