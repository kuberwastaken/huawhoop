package com.huawei.phoneservice.faq.base.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ModuleConfigResponse implements Serializable, Parcelable {
    public static final Parcelable.Creator<ModuleConfigResponse> CREATOR = new d();
    private static final long serialVersionUID = 5523493960862839428L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("moduleList")
    private List<ModuleListBean> f8518a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static class ModuleListBean implements Serializable, Parcelable {
        public static final Parcelable.Creator<ModuleListBean> CREATOR = new a();
        private static final long serialVersionUID = -6366144895402746183L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("moduleCode")
        private String f8519a;

        @SerializedName("moduleName")
        private String b;

        @SerializedName("moduleLinkAddress")
        private String c;

        @SerializedName("openLinkType")
        private String d;

        @SerializedName("isLink")
        private String e;

        @SerializedName("subModuleList")
        private List<SubModuleListBean> f;

        @SerializedName("appName")
        private String g;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8519a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeTypedList(this.f);
            parcel.writeString(this.g);
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String getOpenType() {
            return this.d;
        }

        public String getModuleCode() {
            return this.f8519a;
        }

        public String getLinkAddress() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (obj != null && getClass() == obj.getClass()) {
                return this.f8519a.equals(((ModuleListBean) obj).getModuleCode());
            }
            return false;
        }

        public List<SubModuleListBean> b() {
            return this.f;
        }

        class a implements Parcelable.Creator<ModuleListBean> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ModuleListBean[] newArray(int i) {
                return new ModuleListBean[i];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: cjo_, reason: merged with bridge method [inline-methods] */
            public ModuleListBean createFromParcel(Parcel parcel) {
                return new ModuleListBean(parcel);
            }

            a() {
            }
        }

        public String a() {
            return this.g;
        }

        protected ModuleListBean(Parcel parcel) {
            this.f8519a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.createTypedArrayList(SubModuleListBean.CREATOR);
            this.g = parcel.readString();
            parcel.readParcelable(getClass().getClassLoader());
        }

        public ModuleListBean() {
        }
    }

    public static class SubModuleListBean implements Serializable, Parcelable {
        public static final Parcelable.Creator<SubModuleListBean> CREATOR = new c();
        private static final long serialVersionUID = 773325441128424814L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("subModuleCode")
        private String f8520a;

        @SerializedName("subModuleName")
        private String b;

        @SerializedName("subModuleLinkAddress")
        private String c;

        @SerializedName("openLinkType")
        private String d;

        @SerializedName("isLink")
        private String e;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8520a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
        }

        class c implements Parcelable.Creator<SubModuleListBean> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SubModuleListBean[] newArray(int i) {
                return new SubModuleListBean[i];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: cjp_, reason: merged with bridge method [inline-methods] */
            public SubModuleListBean createFromParcel(Parcel parcel) {
                return new SubModuleListBean(parcel);
            }

            c() {
            }
        }

        public String a() {
            return this.f8520a;
        }

        protected SubModuleListBean(Parcel parcel) {
            this.f8520a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f8518a);
    }

    public List<ModuleListBean> getModuleList() {
        return this.f8518a;
    }

    class d implements Parcelable.Creator<ModuleConfigResponse> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModuleConfigResponse[] newArray(int i) {
            return new ModuleConfigResponse[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModuleConfigResponse createFromParcel(Parcel parcel) {
            return new ModuleConfigResponse(parcel);
        }

        d() {
        }
    }

    protected ModuleConfigResponse(Parcel parcel) {
        this.f8518a = parcel.createTypedArrayList(ModuleListBean.CREATOR);
    }

    public ModuleConfigResponse() {
    }
}
