package com.huawei.hms.maps.model;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.utils.LogM;

/* JADX INFO: loaded from: classes5.dex */
public class CameraUpdateParam implements Parcelable {
    public static final Parcelable.Creator<CameraUpdateParam> CREATOR = new Parcelable.Creator<CameraUpdateParam>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraUpdateParam[] newArray(int i) {
            return new CameraUpdateParam[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraUpdateParam createFromParcel(Parcel parcel) {
            return new CameraUpdateParam(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CameraPosition f5169a;
    private LatLng b;
    private NewLatLngBounds c;
    private NewLatLngBoundsWidthHeight d;
    private NewLatLngZoom e;
    private ScrollBy f;
    private ZoomByWithFocus g;
    private ZoomBy h;
    private ZoomTo i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int iBeginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, getCameraPosition(), i, false);
        parcelWrite.writeParcelable(3, getLatLng(), i, false);
        parcelWrite.writeParcelable(4, getNewLatLngBounds(), i, false);
        parcelWrite.writeParcelable(5, getNewLatLngZoom(), i, false);
        parcelWrite.writeParcelable(6, getScrollBy(), i, false);
        parcelWrite.writeParcelable(7, getZoomByWithFocus(), i, false);
        parcelWrite.writeParcelable(8, getZoomBy(), i, false);
        parcelWrite.writeParcelable(9, getZoomTo(), i, false);
        parcelWrite.writeParcelable(10, getNewLatLngBoundsWidthHeight(), i, false);
        parcelWrite.finishObjectHeader(iBeginObjectHeader);
    }

    public String toString() {
        return getClass().getSimpleName() + ":{cameraPosition=" + this.f5169a + ",latLng=" + this.b + ",scrollBy=" + this.f + ",zoomByWithFocus=" + this.g + ",newLatLngBounds=" + this.c + ",newLatLngZoom=" + this.e + ",zoomBy=" + this.h + ",zoomTo=" + this.i + "}";
    }

    public void setZoomTo(ZoomTo zoomTo) {
        this.i = zoomTo;
    }

    public void setZoomByWithFocus(ZoomByWithFocus zoomByWithFocus) {
        this.g = zoomByWithFocus;
    }

    public void setZoomBy(ZoomBy zoomBy) {
        this.h = zoomBy;
    }

    public void setScrollBy(ScrollBy scrollBy) {
        this.f = scrollBy;
    }

    public void setNewLatLngZoom(NewLatLngZoom newLatLngZoom) {
        this.e = newLatLngZoom;
    }

    public void setNewLatLngBoundsWidthHeight(NewLatLngBoundsWidthHeight newLatLngBoundsWidthHeight) {
        this.d = newLatLngBoundsWidthHeight;
    }

    public void setNewLatLngBounds(NewLatLngBounds newLatLngBounds) {
        this.c = newLatLngBounds;
    }

    public static class NewLatLngBoundsWidthHeight implements Parcelable {
        public static final Parcelable.Creator<NewLatLngBoundsWidthHeight> CREATOR = new Parcelable.Creator<NewLatLngBoundsWidthHeight>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.NewLatLngBoundsWidthHeight.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NewLatLngBoundsWidthHeight[] newArray(int i) {
                return new NewLatLngBoundsWidthHeight[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NewLatLngBoundsWidthHeight createFromParcel(Parcel parcel) {
                return new NewLatLngBoundsWidthHeight(parcel);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLngBounds f5171a;
        private int b;
        private int c;
        private int d;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int iBeginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeParcelable(2, this.f5171a, i, false);
            parcelWrite.writeInt(3, this.b);
            parcelWrite.writeInt(4, this.c);
            parcelWrite.writeInt(5, this.d);
            parcelWrite.finishObjectHeader(iBeginObjectHeader);
        }

        public void setWidth(int i) {
            this.c = i;
        }

        public void setPadding(int i) {
            this.b = i;
        }

        public void setHeight(int i) {
            this.d = i;
        }

        public void setBounds(LatLngBounds latLngBounds) {
            this.f5171a = latLngBounds;
        }

        public int getWidth() {
            return this.c;
        }

        public int getPadding() {
            return this.b;
        }

        public int getHeight() {
            return this.d;
        }

        public LatLngBounds getBounds() {
            return this.f5171a;
        }

        public NewLatLngBoundsWidthHeight(LatLngBounds latLngBounds, int i, int i2, int i3) {
            this.f5171a = latLngBounds;
            this.c = i;
            this.d = i2;
            this.b = i3;
        }

        protected NewLatLngBoundsWidthHeight(Parcel parcel) {
            this.f5171a = null;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f5171a = (LatLngBounds) parcelReader.readParcelable(2, LatLngBounds.CREATOR, null);
            this.b = parcelReader.readInt(3, this.b);
            this.c = parcelReader.readInt(4, this.c);
            this.d = parcelReader.readInt(5, this.d);
        }

        public NewLatLngBoundsWidthHeight() {
            this.f5171a = null;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
        }
    }

    public void setLatLng(LatLng latLng) {
        this.b = latLng;
    }

    public void setCameraPosition(CameraPosition cameraPosition) {
        this.f5169a = cameraPosition;
    }

    public ZoomTo getZoomTo() {
        return this.i;
    }

    public ZoomByWithFocus getZoomByWithFocus() {
        return this.g;
    }

    public static class NewLatLngBounds implements Parcelable {
        public static final Parcelable.Creator<NewLatLngBounds> CREATOR = new Parcelable.Creator<NewLatLngBounds>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.NewLatLngBounds.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NewLatLngBounds[] newArray(int i) {
                return new NewLatLngBounds[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NewLatLngBounds createFromParcel(Parcel parcel) {
                return new NewLatLngBounds(parcel);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLngBounds f5170a;
        private int b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int iBeginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeParcelable(2, this.f5170a, i, false);
            parcelWrite.writeInt(3, this.b);
            parcelWrite.finishObjectHeader(iBeginObjectHeader);
        }

        public void setPadding(int i) {
            this.b = i;
        }

        public void setBounds(LatLngBounds latLngBounds) {
            this.f5170a = latLngBounds;
        }

        public int getPadding() {
            return this.b;
        }

        public LatLngBounds getBounds() {
            return this.f5170a;
        }

        public NewLatLngBounds(LatLngBounds latLngBounds, int i) {
            this.f5170a = latLngBounds;
            this.b = i;
        }

        protected NewLatLngBounds(Parcel parcel) {
            this.f5170a = null;
            this.b = Integer.MAX_VALUE;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f5170a = (LatLngBounds) parcelReader.readParcelable(2, LatLngBounds.CREATOR, null);
            this.b = parcelReader.readInt(3, this.b);
        }

        public NewLatLngBounds() {
            this.f5170a = null;
            this.b = Integer.MAX_VALUE;
        }
    }

    public static class NewLatLngZoom implements Parcelable {
        public static final Parcelable.Creator<NewLatLngZoom> CREATOR = new Parcelable.Creator<NewLatLngZoom>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.NewLatLngZoom.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NewLatLngZoom[] newArray(int i) {
                return new NewLatLngZoom[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NewLatLngZoom createFromParcel(Parcel parcel) {
                return new NewLatLngZoom(parcel);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLng f5172a;
        private float b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int iBeginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeParcelable(2, this.f5172a, i, false);
            parcelWrite.writeFloat(3, this.b);
            parcelWrite.finishObjectHeader(iBeginObjectHeader);
        }

        public void setZoom(float f) {
            this.b = f;
        }

        public void setLatLng(LatLng latLng) {
            this.f5172a = latLng;
        }

        public float getZoom() {
            return this.b;
        }

        public LatLng getLatLng() {
            return this.f5172a;
        }

        public NewLatLngZoom(LatLng latLng, float f) {
            this.f5172a = latLng;
            this.b = f;
        }

        protected NewLatLngZoom(Parcel parcel) {
            this.f5172a = null;
            this.b = -1.0f;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f5172a = (LatLng) parcelReader.readParcelable(2, LatLng.CREATOR, null);
            this.b = parcelReader.readFloat(3, this.b);
        }

        public NewLatLngZoom() {
            this.f5172a = null;
            this.b = -1.0f;
        }
    }

    public static class ScrollBy implements Parcelable {
        public static final Parcelable.Creator<ScrollBy> CREATOR = new Parcelable.Creator<ScrollBy>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.ScrollBy.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ScrollBy[] newArray(int i) {
                return new ScrollBy[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ScrollBy createFromParcel(Parcel parcel) {
                return new ScrollBy(parcel);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f5173a;
        private float b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int iBeginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f5173a);
            parcelWrite.writeFloat(3, this.b);
            parcelWrite.finishObjectHeader(iBeginObjectHeader);
        }

        public void setyPixel(float f) {
            this.b = f;
        }

        public void setxPixel(float f) {
            this.f5173a = f;
        }

        public float getyPixel() {
            return this.b;
        }

        public float getxPixel() {
            return this.f5173a;
        }

        protected ScrollBy(Parcel parcel) {
            this.f5173a = Float.MAX_VALUE;
            this.b = Float.MAX_VALUE;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f5173a = parcelReader.readFloat(2, this.f5173a);
            this.b = parcelReader.readFloat(3, this.b);
        }

        public ScrollBy(float f, float f2) {
            this.f5173a = f;
            this.b = f2;
        }

        public ScrollBy() {
            this.f5173a = Float.MAX_VALUE;
            this.b = Float.MAX_VALUE;
        }
    }

    public static class ZoomByWithFocus implements Parcelable {
        public static final Parcelable.Creator<ZoomByWithFocus> CREATOR = new Parcelable.Creator<ZoomByWithFocus>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.ZoomByWithFocus.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ZoomByWithFocus[] newArray(int i) {
                return new ZoomByWithFocus[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ZoomByWithFocus createFromParcel(Parcel parcel) {
                return new ZoomByWithFocus(parcel);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f5175a;
        private Point b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int iBeginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f5175a);
            parcelWrite.writeParcelable(3, this.b, i, false);
            parcelWrite.finishObjectHeader(iBeginObjectHeader);
        }

        public void setFocus(Point point) {
            this.b = point;
        }

        public void setAmount(float f) {
            this.f5175a = f;
        }

        public Point getFocus() {
            return this.b;
        }

        public float getAmount() {
            return this.f5175a;
        }

        protected ZoomByWithFocus(Parcel parcel) {
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f5175a = parcelReader.readFloat(2, 1.0f);
            this.b = (Point) parcelReader.readParcelable(3, Point.CREATOR, null);
        }

        public ZoomByWithFocus(float f, Point point) {
            this.f5175a = f;
            this.b = point;
        }

        public ZoomByWithFocus() {
        }
    }

    public ZoomBy getZoomBy() {
        return this.h;
    }

    public ScrollBy getScrollBy() {
        return this.f;
    }

    public NewLatLngZoom getNewLatLngZoom() {
        return this.e;
    }

    public static class ZoomBy implements Parcelable {
        public static final Parcelable.Creator<ZoomBy> CREATOR = new Parcelable.Creator<ZoomBy>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.ZoomBy.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ZoomBy[] newArray(int i) {
                return new ZoomBy[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ZoomBy createFromParcel(Parcel parcel) {
                return new ZoomBy(parcel);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f5174a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            LogM.d("zoomby", "zoomBy: writeToParcel " + this.f5174a);
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int iBeginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f5174a);
            parcelWrite.finishObjectHeader(iBeginObjectHeader);
        }

        public void setAmount(float f) {
            this.f5174a = f;
        }

        public float getAmount() {
            return this.f5174a;
        }

        protected ZoomBy(Parcel parcel) {
            this.f5174a = new ParcelReader(parcel).readFloat(2, 0.0f);
            LogM.d("zoomby", "zoomBy: constructor ReadDone " + this.f5174a);
        }

        public ZoomBy(float f) {
            this.f5174a = f;
        }
    }

    public static class ZoomTo implements Parcelable {
        public static final Parcelable.Creator<ZoomTo> CREATOR = new Parcelable.Creator<ZoomTo>() { // from class: com.huawei.hms.maps.model.CameraUpdateParam.ZoomTo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ZoomTo[] newArray(int i) {
                return new ZoomTo[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ZoomTo createFromParcel(Parcel parcel) {
                return new ZoomTo(parcel);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f5176a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int iBeginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f5176a);
            parcelWrite.finishObjectHeader(iBeginObjectHeader);
        }

        public void setZoom(float f) {
            this.f5176a = f;
        }

        public float getZoom() {
            return this.f5176a;
        }

        protected ZoomTo(Parcel parcel) {
            this.f5176a = Float.MAX_VALUE;
            this.f5176a = new ParcelReader(parcel).readFloat(2, this.f5176a);
        }

        public ZoomTo(float f) {
            this.f5176a = f;
        }
    }

    public NewLatLngBoundsWidthHeight getNewLatLngBoundsWidthHeight() {
        return this.d;
    }

    public NewLatLngBounds getNewLatLngBounds() {
        return this.c;
    }

    public LatLng getLatLng() {
        return this.b;
    }

    public CameraPosition getCameraPosition() {
        return this.f5169a;
    }

    protected CameraUpdateParam(Parcel parcel) {
        this.f5169a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        LogM.d("ContentValues", "CameraUpdateParam: zoomBy");
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f5169a = (CameraPosition) parcelReader.readParcelable(2, CameraPosition.CREATOR, null);
        this.b = (LatLng) parcelReader.readParcelable(3, LatLng.CREATOR, null);
        this.c = (NewLatLngBounds) parcelReader.readParcelable(4, NewLatLngBounds.CREATOR, null);
        this.e = (NewLatLngZoom) parcelReader.readParcelable(5, NewLatLngZoom.CREATOR, null);
        this.f = (ScrollBy) parcelReader.readParcelable(6, ScrollBy.CREATOR, null);
        this.g = (ZoomByWithFocus) parcelReader.readParcelable(7, ZoomByWithFocus.CREATOR, null);
        this.h = (ZoomBy) parcelReader.readParcelable(8, ZoomBy.CREATOR, null);
        this.i = (ZoomTo) parcelReader.readParcelable(9, ZoomTo.CREATOR, null);
        this.d = (NewLatLngBoundsWidthHeight) parcelReader.readParcelable(10, NewLatLngBoundsWidthHeight.CREATOR, null);
    }

    public CameraUpdateParam() {
        this.f5169a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }
}
