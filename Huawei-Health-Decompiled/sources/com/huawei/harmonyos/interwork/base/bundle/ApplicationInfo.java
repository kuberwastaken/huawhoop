package com.huawei.harmonyos.interwork.base.bundle;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.csl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ApplicationInfo implements Parcelable {
    public static final Parcelable.Creator<ApplicationInfo> CREATOR = new Parcelable.Creator<ApplicationInfo>() { // from class: com.huawei.harmonyos.interwork.base.bundle.ApplicationInfo.4
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: BM_, reason: merged with bridge method [inline-methods] */
        public final ApplicationInfo createFromParcel(Parcel parcel) {
            return new ApplicationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final ApplicationInfo[] newArray(int i) {
            return new ApplicationInfo[i];
        }
    };
    private static final int MAX_LIMIT_SIZE = 1024;
    private String description;
    private int descriptionId;
    private String icon;
    private int iconId;
    private String label;
    private int labelId;
    private List<csl> moduleInfos;
    private String name;
    private List<String> permissions;
    private int supportedModes;
    private Boolean systemApp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ApplicationInfo() {
        this.name = "";
        this.icon = "";
        this.label = "";
        this.description = "";
        this.systemApp = Boolean.FALSE;
        this.supportedModes = 0;
        this.labelId = 0;
        this.iconId = 0;
        this.descriptionId = 0;
        this.permissions = new ArrayList(0);
        this.moduleInfos = new ArrayList(0);
    }

    public ApplicationInfo(ApplicationInfo applicationInfo) {
        this.name = "";
        this.icon = "";
        this.label = "";
        this.description = "";
        this.systemApp = Boolean.FALSE;
        this.supportedModes = 0;
        this.labelId = 0;
        this.iconId = 0;
        this.descriptionId = 0;
        this.permissions = new ArrayList(0);
        this.moduleInfos = new ArrayList(0);
        this.name = applicationInfo.name;
        this.icon = applicationInfo.icon;
        this.label = applicationInfo.label;
        this.description = applicationInfo.description;
        this.permissions = applicationInfo.permissions;
        this.systemApp = applicationInfo.systemApp;
        this.moduleInfos = applicationInfo.moduleInfos;
        this.supportedModes = applicationInfo.supportedModes;
        this.labelId = applicationInfo.labelId;
        this.iconId = applicationInfo.iconId;
        this.descriptionId = applicationInfo.descriptionId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getLabel() {
        return this.label;
    }

    public String getDescription() {
        return this.description;
    }

    public int getSupportedModes() {
        return this.supportedModes;
    }

    public List<String> getModuleSourceDirs() {
        ArrayList arrayList = new ArrayList();
        Iterator<csl> it = this.moduleInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return arrayList;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public List<csl> getModuleInfos() {
        return this.moduleInfos;
    }

    public Boolean getSystemApp() {
        return this.systemApp;
    }

    public int getIconId() {
        return this.iconId;
    }

    public int getDescriptionId() {
        return this.descriptionId;
    }

    public int getLabelId() {
        return this.labelId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.icon);
        parcel.writeString(this.label);
        parcel.writeString(this.description);
        parcel.writeBoolean(this.systemApp.booleanValue());
        parcel.writeInt(this.supportedModes);
        parcel.writeInt(this.iconId);
        parcel.writeInt(this.descriptionId);
        parcel.writeInt(this.labelId);
        parcel.writeInt(this.permissions.size());
        Iterator<String> it = this.permissions.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
        parcel.writeInt(this.moduleInfos.size());
        for (csl cslVar : this.moduleInfos) {
            parcel.writeString(cslVar.b());
            parcel.writeString(cslVar.a());
        }
    }

    public ApplicationInfo(Parcel parcel) {
        this.name = "";
        this.icon = "";
        this.label = "";
        this.description = "";
        this.systemApp = Boolean.FALSE;
        this.supportedModes = 0;
        this.labelId = 0;
        this.iconId = 0;
        this.descriptionId = 0;
        this.permissions = new ArrayList(0);
        this.moduleInfos = new ArrayList(0);
        this.name = parcel.readString();
        this.icon = parcel.readString();
        this.label = parcel.readString();
        this.description = parcel.readString();
        this.systemApp = Boolean.valueOf(parcel.readBoolean());
        this.supportedModes = parcel.readInt();
        this.iconId = parcel.readInt();
        this.descriptionId = parcel.readInt();
        this.labelId = parcel.readInt();
        int i = parcel.readInt();
        if (i > 1024) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.permissions.add(parcel.readString());
        }
        int i3 = parcel.readInt();
        if (i3 > 1024) {
            return;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            this.moduleInfos.add(new csl(parcel.readString(), parcel.readString()));
        }
    }
}
