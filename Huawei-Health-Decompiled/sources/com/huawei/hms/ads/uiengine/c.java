package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* JADX INFO: loaded from: classes5.dex */
public interface c extends IInterface {
    void a();

    void a(int i);

    void a(long j, long j2);

    void a(Bundle bundle);

    void a(IObjectWrapper iObjectWrapper);

    void a(IObjectWrapper iObjectWrapper, int i);

    void a(IObjectWrapper iObjectWrapper, Bundle bundle);

    void a(IObjectWrapper iObjectWrapper, String str);

    void a(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    void a(IPPSUiEngineCallback iPPSUiEngineCallback);

    void a(String str, int i);

    void a(String str, long j, long j2, int i, int i2);

    void a(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    void a(boolean z);

    String b();

    void b(String str, long j, long j2, int i, int i2);

    void b(String str, Bundle bundle);

    void c();

    boolean d();

    boolean e();

    public static abstract class a extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.c$a$a, reason: collision with other inner class name */
        static class C0106a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f4538a;
            private IBinder b;

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (!this.b.transact(10, parcelObtain, parcelObtain2, 0) && a.g() != null) {
                        return a.g().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (!this.b.transact(8, parcelObtain, parcelObtain2, 0) && a.g() != null) {
                        return a.g().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (this.b.transact(15, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().c();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void b(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(18, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().b(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void b(String str, long j, long j2, int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.b.transact(3, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().b(str, j, j2, i, i2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public String b() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (this.b.transact(17, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.g().b();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.b.transact(4, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(20, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(str, iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(String str, long j, long j2, int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.b.transact(2, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(str, j, j2, i, i2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(str, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.b.transact(14, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(11, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(iObjectWrapper, str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(IObjectWrapper iObjectWrapper, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (this.b.transact(9, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(iObjectWrapper, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(12, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(IObjectWrapper iObjectWrapper, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeInt(i);
                    if (this.b.transact(7, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(iObjectWrapper, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.b.transact(6, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(iObjectWrapper);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(16, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(long j, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    if (this.b.transact(5, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(j, j2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeInt(i);
                    if (this.b.transact(13, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (this.b.transact(19, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().a();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            C0106a(IBinder iBinder) {
                this.b = iBinder;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        b(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        boolean zD = d();
                        parcel2.writeNoException();
                        parcel2.writeInt(zD ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        boolean zE = e();
                        parcel2.writeNoException();
                        parcel2.writeInt(zE ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(IPPSUiEngineCallback.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        String strB = b();
                        parcel2.writeNoException();
                        parcel2.writeString(strB);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        b(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                        a(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.huawei.hms.ads.uiengine.INativeApi");
            return true;
        }

        public static c g() {
            return C0106a.f4538a;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.ads.uiengine.INativeApi");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0106a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public a() {
            attachInterface(this, "com.huawei.hms.ads.uiengine.INativeApi");
        }
    }
}
