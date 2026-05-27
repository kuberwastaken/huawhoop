package com.huawei.hms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.PatternItem;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IPolygonDelegate extends maa {
    boolean equalsRemote(IPolygonDelegate iPolygonDelegate);

    int getFillColor();

    List getHoles();

    List<LatLng> getPoints();

    int getStrokeColor();

    int getStrokeJointType();

    List<PatternItem> getStrokePattern();

    float getStrokeWidth();

    boolean isGeodesic();

    void setFillColor(int i);

    void setGeodesic(boolean z);

    void setHoles(List list);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i);

    void setStrokeJointType(int i);

    void setStrokePattern(List<PatternItem> list);

    void setStrokeWidth(float f);

    public static abstract class Stub extends Binder implements IPolygonDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        static class Proxy implements IPolygonDelegate {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5214a;

            @Override // com.huawei.hms.maps.model.internal.maa
            public void setZIndex(float f) {
                mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 27, Float.valueOf(f));
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public void setVisible(boolean z) {
                mab.a(z, this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 26);
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public void setTag(IObjectWrapper iObjectWrapper) {
                mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 25, iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setStrokeWidth(float f) {
                mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 24, Float.valueOf(f));
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setStrokePattern(List<PatternItem> list) {
                mab.b(list, this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 23);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setStrokeJointType(int i) {
                mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 22, Integer.valueOf(i));
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setStrokeColor(int i) {
                mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 21, Integer.valueOf(i));
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setPoints(List<LatLng> list) {
                mab.a(list, this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 20);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setHoles(List list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolygonDelegate");
                    parcelObtain.writeList(list);
                    this.f5214a.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setGeodesic(boolean z) {
                mab.a(z, this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 18);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public void setFillColor(int i) {
                mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 17, Integer.valueOf(i));
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public void setClickable(boolean z) {
                mab.a(z, this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 16);
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public void remove() {
                mab.i(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 15);
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public boolean isVisible() {
                return mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 14);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public boolean isGeodesic() {
                return mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 13);
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public boolean isClickable() {
                return mab.a(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 12);
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public int hashCodeRemote() {
                return mab.b(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 11);
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public float getZIndex() {
                return mab.c(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 10);
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public IObjectWrapper getTag() {
                return IObjectWrapper.Stub.asInterface(mab.j(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 9));
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public float getStrokeWidth() {
                return mab.c(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 8);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public List<PatternItem> getStrokePattern() {
                return mab.h(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 7);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public int getStrokeJointType() {
                return mab.b(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 6);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public int getStrokeColor() {
                return mab.b(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 5);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public List<LatLng> getPoints() {
                return mab.g(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 4);
            }

            public String getInterfaceDescriptor() {
                return "com.huawei.hms.maps.model.internal.IPolygonDelegate";
            }

            @Override // com.huawei.hms.maps.model.internal.maa
            public String getId() {
                return mab.d(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 3);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public List getHoles() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.maps.model.internal.IPolygonDelegate");
                    this.f5214a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public int getFillColor() {
                return mab.b(this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 1);
            }

            @Override // com.huawei.hms.maps.model.internal.IPolygonDelegate
            public boolean equalsRemote(IPolygonDelegate iPolygonDelegate) {
                return mab.a(iPolygonDelegate, this.f5214a, "com.huawei.hms.maps.model.internal.IPolygonDelegate", 28);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5214a;
            }

            Proxy(IBinder iBinder) {
                this.f5214a = iBinder;
            }
        }

        public static IPolygonDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.maps.model.internal.IPolygonDelegate");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPolygonDelegate)) ? new Proxy(iBinder) : (IPolygonDelegate) iInterfaceQueryLocalInterface;
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.maps.model.internal.IPolygonDelegate");
        }
    }
}
