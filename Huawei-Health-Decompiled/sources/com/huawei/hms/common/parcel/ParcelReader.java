package com.huawei.hms.common.parcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import com.huawei.operation.utils.Constants;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ParcelReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4650a = 0;
    private static final int b = 1;
    private static final int c = 65262;
    public HashMap<Integer, Integer[]> d = new HashMap<>();
    private Parcel e;

    private int a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    public short readShort(int i, short s) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return s;
        }
        b(i, 4);
        return (short) this.e.readInt();
    }

    public <T extends Parcelable> T readParcelable(int i, Parcelable.Creator<T> creator, T t) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return t;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        T tCreateFromParcel = creator.createFromParcel(this.e);
        this.e.setDataPosition(iDataPosition + iB);
        return tCreateFromParcel;
    }

    public Long readLongObject(int i, Long l) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return l;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        a(iB, 8);
        return Long.valueOf(this.e.readLong());
    }

    public long readLong(int i, long j) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return j;
        }
        b(i, 8);
        return this.e.readLong();
    }

    public void readList(int i, List list, ClassLoader classLoader) {
        if (this.d.containsKey(Integer.valueOf(i))) {
            int iB = b(i);
            int iDataPosition = this.e.dataPosition();
            if (iB != 0) {
                this.e.readList(list, classLoader);
                this.e.setDataPosition(iDataPosition + iB);
            }
        }
    }

    public Integer readIntegerObject(int i, Integer num) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return num;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        a(iB, 4);
        return Integer.valueOf(this.e.readInt());
    }

    public int readInt(int i, int i2) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return i2;
        }
        b(i, 4);
        return this.e.readInt();
    }

    public IBinder readIBinder(int i, IBinder iBinder) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return iBinder;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        IBinder strongBinder = this.e.readStrongBinder();
        this.e.setDataPosition(iDataPosition + iB);
        return strongBinder;
    }

    public Float readFloatObject(int i, Float f) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return f;
        }
        if (b(i) == 0) {
            return null;
        }
        a(i, 4);
        return Float.valueOf(this.e.readFloat());
    }

    public float readFloat(int i, float f) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return f;
        }
        b(i, 4);
        return this.e.readFloat();
    }

    public Double readDoubleObject(int i, Double d) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return d;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        a(iB, 8);
        return Double.valueOf(this.e.readDouble());
    }

    public double readDouble(int i, double d) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return d;
        }
        b(i, 8);
        return this.e.readDouble();
    }

    public char readChar(int i, char c2) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return c2;
        }
        b(i, 4);
        return (char) this.e.readInt();
    }

    public byte readByte(int i, byte b2) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return b2;
        }
        b(i, 4);
        return (byte) this.e.readInt();
    }

    public Bundle readBundle(int i, Bundle bundle) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bundle;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        Bundle bundle2 = this.e.readBundle();
        this.e.setDataPosition(iDataPosition + iB);
        return bundle2;
    }

    public Boolean readBooleanObject(int i, Boolean bool) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bool;
        }
        if (b(i) == 0) {
            return null;
        }
        a(i, 4);
        int i2 = this.e.readInt();
        if (i2 == 0) {
            return Boolean.FALSE;
        }
        if (i2 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public boolean readBoolean(int i, boolean z) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return z;
        }
        b(i, 4);
        return this.e.readInt() != 0;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.e.readInt(), this.e.readInt() != 0 ? creator.createFromParcel(this.e) : null);
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public <T> ArrayList<T> createTypedList(int i, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<T> arrayListCreateTypedArrayList = this.e.createTypedArrayList(creator);
        this.e.setDataPosition(iDataPosition + iB);
        return arrayListCreateTypedArrayList;
    }

    public <T> T[] createTypedArray(int i, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return tArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        T[] tArr2 = (T[]) this.e.createTypedArray(creator);
        this.e.setDataPosition(iDataPosition + iB);
        return tArr2;
    }

    public SparseArray<String> createStringSparseArray(int i, SparseArray<String> sparseArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.e.readInt(), this.e.readString());
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public ArrayList<String> createStringList(int i, ArrayList<String> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<String> arrayListCreateStringArrayList = this.e.createStringArrayList();
        this.e.setDataPosition(iDataPosition + iB);
        return arrayListCreateStringArrayList;
    }

    public String[] createStringArray(int i, String[] strArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return strArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        String[] strArrCreateStringArray = this.e.createStringArray();
        this.e.setDataPosition(iDataPosition + iB);
        return strArrCreateStringArray;
    }

    public String createString(int i, String str) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return str;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        String string = this.e.readString();
        this.e.setDataPosition(iDataPosition + iB);
        return string;
    }

    public SparseLongArray createSparseLongArray(int i, SparseLongArray sparseLongArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseLongArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseLongArray2.append(this.e.readInt(), this.e.readLong());
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseLongArray2;
    }

    public SparseIntArray createSparseIntArray(int i, SparseIntArray sparseIntArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseIntArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseIntArray2.append(this.e.readInt(), this.e.readInt());
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseIntArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i, SparseBooleanArray sparseBooleanArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseBooleanArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        SparseBooleanArray sparseBooleanArray2 = this.e.readSparseBooleanArray();
        this.e.setDataPosition(iDataPosition + iB);
        return sparseBooleanArray2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i, SparseArray<Parcel> sparseArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i2 = 0; i2 < iA; i2++) {
            int i3 = this.e.readInt();
            int i4 = this.e.readInt();
            if (i4 != 0) {
                int iDataPosition2 = this.e.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.e, iDataPosition2, i4);
                sparseArray2.append(i3, parcelObtain);
                this.e.setDataPosition(iDataPosition2 + i4);
            } else {
                sparseArray2.append(i3, null);
            }
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public ArrayList<Parcel> createParcelList(int i, ArrayList<Parcel> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < iA; i2++) {
            int i3 = this.e.readInt();
            if (i3 != 0) {
                int iDataPosition2 = this.e.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.e, iDataPosition2, i3);
                arrayList2.add(parcelObtain);
                this.e.setDataPosition(iDataPosition2 + i3);
            } else {
                arrayList2.add(null);
            }
        }
        this.e.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public Parcel[] createParcelArray(int i, Parcel[] parcelArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return parcelArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        Parcel[] parcelArr2 = new Parcel[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            int i3 = this.e.readInt();
            if (i3 != 0) {
                int iDataPosition2 = this.e.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.e, iDataPosition2, i3);
                parcelArr2[i2] = parcelObtain;
                this.e.setDataPosition(iDataPosition2 + i3);
            } else {
                parcelArr2[i2] = null;
            }
        }
        this.e.setDataPosition(iDataPosition + iB);
        return parcelArr2;
    }

    public Parcel createParcel(int i, Parcel parcel) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return parcel;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(this.e, iDataPosition, iB);
        this.e.setDataPosition(iDataPosition + iB);
        return parcelObtain;
    }

    public ArrayList<Long> createLongList(int i, ArrayList<Long> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Long.valueOf(this.e.readLong()));
        }
        this.e.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public long[] createLongArray(int i, long[] jArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return jArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        long[] jArrCreateLongArray = this.e.createLongArray();
        this.e.setDataPosition(iDataPosition + iB);
        return jArrCreateLongArray;
    }

    public ArrayList<Integer> createIntegerList(int i, ArrayList<Integer> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Integer.valueOf(this.e.readInt()));
        }
        this.e.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public int[] createIntArray(int i, int[] iArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return iArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int[] iArrCreateIntArray = this.e.createIntArray();
        this.e.setDataPosition(iDataPosition + iB);
        return iArrCreateIntArray;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i, SparseArray<IBinder> sparseArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(iA);
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.e.readInt(), this.e.readStrongBinder());
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public ArrayList<IBinder> createIBinderList(int i, ArrayList<IBinder> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<IBinder> arrayListCreateBinderArrayList = this.e.createBinderArrayList();
        this.e.setDataPosition(iDataPosition + iB);
        return arrayListCreateBinderArrayList;
    }

    public IBinder[] createIBinderArray(int i, IBinder[] iBinderArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return iBinderArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        IBinder[] iBinderArrCreateBinderArray = this.e.createBinderArray();
        this.e.setDataPosition(iDataPosition + iB);
        return iBinderArrCreateBinderArray;
    }

    public SparseArray<Float> createFloatSparseArray(int i, SparseArray<Float> sparseArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.e.readInt(), Float.valueOf(this.e.readFloat()));
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public ArrayList<Float> createFloatList(int i, ArrayList<Float> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Float.valueOf(this.e.readFloat()));
        }
        this.e.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public float[] createFloatArray(int i, float[] fArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return fArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        float[] fArrCreateFloatArray = this.e.createFloatArray();
        this.e.setDataPosition(iDataPosition + iB);
        return fArrCreateFloatArray;
    }

    public SparseArray<Double> createDoubleSparseArray(int i, SparseArray<Double> sparseArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.e.readInt(), Double.valueOf(this.e.readDouble()));
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public ArrayList<Double> createDoubleList(int i, ArrayList<Double> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Double.valueOf(this.e.readDouble()));
        }
        this.e.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public double[] createDoubleArray(int i, double[] dArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return dArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        double[] dArrCreateDoubleArray = this.e.createDoubleArray();
        this.e.setDataPosition(iDataPosition + iB);
        return dArrCreateDoubleArray;
    }

    public char[] createCharArray(int i, char[] cArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return cArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        char[] cArrCreateCharArray = this.e.createCharArray();
        this.e.setDataPosition(iDataPosition + iB);
        return cArrCreateCharArray;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i, SparseArray<byte[]> sparseArray) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(iA);
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.e.readInt(), this.e.createByteArray());
        }
        this.e.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public byte[][] createByteArrayArray(int i, byte[][] bArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        byte[][] bArr2 = new byte[iA][];
        for (int i2 = 0; i2 < iA; i2++) {
            bArr2[i2] = this.e.createByteArray();
        }
        this.e.setDataPosition(iDataPosition + iB);
        return bArr2;
    }

    public byte[] createByteArray(int i, byte[] bArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        byte[] bArrCreateByteArray = this.e.createByteArray();
        this.e.setDataPosition(iDataPosition + iB);
        return bArrCreateByteArray;
    }

    public ArrayList<Boolean> createBooleanList(int i, ArrayList<Boolean> arrayList) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int iA = a(this.e.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Boolean.valueOf(this.e.readInt() != 0));
        }
        this.e.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public boolean[] createBooleanArray(int i, boolean[] zArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return zArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        boolean[] zArrCreateBooleanArray = this.e.createBooleanArray();
        this.e.setDataPosition(iDataPosition + iB);
        return zArrCreateBooleanArray;
    }

    public BigInteger[] createBigIntegerArray(int i, BigInteger[] bigIntegerArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bigIntegerArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        BigInteger[] bigIntegerArr2 = new BigInteger[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            bigIntegerArr2[i2] = new BigInteger(this.e.createByteArray());
        }
        this.e.setDataPosition(iDataPosition + iB);
        return bigIntegerArr2;
    }

    public BigInteger createBigInteger(int i, BigInteger bigInteger) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bigInteger;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        byte[] bArrCreateByteArray = this.e.createByteArray();
        this.e.setDataPosition(iDataPosition + iB);
        return new BigInteger(bArrCreateByteArray);
    }

    public BigDecimal[] createBigDecimalArray(int i, BigDecimal[] bigDecimalArr) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bigDecimalArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        int iA = a(this.e.readInt());
        BigDecimal[] bigDecimalArr2 = new BigDecimal[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            byte[] bArrCreateByteArray = this.e.createByteArray();
            bigDecimalArr2[i2] = new BigDecimal(new BigInteger(bArrCreateByteArray), this.e.readInt());
        }
        this.e.setDataPosition(iDataPosition + iB);
        return bigDecimalArr2;
    }

    public BigDecimal createBigDecimal(int i, BigDecimal bigDecimal) {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            return bigDecimal;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.e.dataPosition();
        byte[] bArrCreateByteArray = this.e.createByteArray();
        int i2 = this.e.readInt();
        this.e.setDataPosition(iDataPosition + iB);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i2);
    }

    private int b(int i, int i2) {
        Integer[] numArr = this.d.get(Integer.valueOf(i));
        if (numArr != null) {
            this.e.setDataPosition(numArr[0].intValue());
            a(i, i2);
            return i2;
        }
        throw new ParseException("Field is null:" + numArr, this.e);
    }

    private int b(int i) {
        Integer[] numArr = this.d.get(Integer.valueOf(i));
        if (numArr != null) {
            this.e.setDataPosition(numArr[0].intValue());
            return numArr[1].intValue();
        }
        throw new ParseException("Field is null:" + numArr, this.e);
    }

    private void a(int i, int i2) {
        Integer[] numArr = this.d.get(Integer.valueOf(i));
        if (numArr == null) {
            throw new ParseException("Field is null:" + numArr, this.e);
        }
        int iIntValue = numArr[1].intValue();
        if (iIntValue == i2) {
            return;
        }
        throw new ParseException("the field size is not " + i2 + " got " + iIntValue + " (0x" + Integer.toHexString(iIntValue) + Constants.RIGHT_BRACKET_ONLY, this.e);
    }

    private void a() {
        int i = this.e.readInt();
        int i2 = i & 65535;
        int i3 = (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & 65535 : this.e.readInt();
        if (i2 != c) {
            throw new ParseException("Parse header error, not 65262. Got 0x" + Integer.toHexString(i2), this.e);
        }
        int iDataPosition = this.e.dataPosition();
        int i4 = i3 + iDataPosition;
        if (i4 < iDataPosition || i4 > this.e.dataSize()) {
            throw new ParseException("invalid size, start=" + iDataPosition + " end=" + i4, this.e);
        }
        while (this.e.dataPosition() < i4) {
            int i5 = this.e.readInt();
            int i6 = (i5 & SupportMenu.CATEGORY_MASK) != -65536 ? (i5 >> 16) & 65535 : this.e.readInt();
            int iDataPosition2 = this.e.dataPosition();
            this.d.put(Integer.valueOf(i5 & 65535), new Integer[]{Integer.valueOf(iDataPosition2), Integer.valueOf(i6)});
            this.e.setDataPosition(iDataPosition2 + i6);
        }
        if (this.e.dataPosition() == i4) {
            return;
        }
        throw new ParseException("the dataPosition is not" + i4, this.e);
    }

    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    public ParcelReader(Parcel parcel) {
        this.e = parcel;
        a();
    }
}
