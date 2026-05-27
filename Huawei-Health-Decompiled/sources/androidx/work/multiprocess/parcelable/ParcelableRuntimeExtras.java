package androidx.work.multiprocess.parcelable;

import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.WorkerParameters;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelableRuntimeExtras implements Parcelable {
    public static final Parcelable.Creator<ParcelableRuntimeExtras> CREATOR = new Parcelable.Creator<ParcelableRuntimeExtras>() { // from class: androidx.work.multiprocess.parcelable.ParcelableRuntimeExtras.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableRuntimeExtras createFromParcel(Parcel parcel) {
            return new ParcelableRuntimeExtras(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableRuntimeExtras[] newArray(int i) {
            return new ParcelableRuntimeExtras[i];
        }
    };
    private WorkerParameters.RuntimeExtras mRuntimeExtras;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mRuntimeExtras = runtimeExtras;
    }

    public ParcelableRuntimeExtras(Parcel parcel) {
        ArrayList arrayList;
        ClassLoader classLoader = getClass().getClassLoader();
        Network network = ParcelUtils.readBooleanValue(parcel) ? (Network) parcel.readParcelable(classLoader) : null;
        if (ParcelUtils.readBooleanValue(parcel)) {
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((Uri) parcelable);
            }
        } else {
            arrayList = null;
        }
        ArrayList<String> arrayListCreateStringArrayList = ParcelUtils.readBooleanValue(parcel) ? parcel.createStringArrayList() : null;
        this.mRuntimeExtras = new WorkerParameters.RuntimeExtras();
        if (Build.VERSION.SDK_INT >= 28) {
            this.mRuntimeExtras.network = network;
        }
        if (arrayList != null) {
            this.mRuntimeExtras.triggeredContentUris = arrayList;
        }
        if (arrayListCreateStringArrayList != null) {
            this.mRuntimeExtras.triggeredContentAuthorities = arrayListCreateStringArrayList;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Network network = Build.VERSION.SDK_INT >= 28 ? this.mRuntimeExtras.network : null;
        boolean z = false;
        boolean z2 = network != null;
        ParcelUtils.writeBooleanValue(parcel, z2);
        if (z2) {
            parcel.writeParcelable(Api21Impl.castToParcelable(network), i);
        }
        List<Uri> list = this.mRuntimeExtras.triggeredContentUris;
        List<String> list2 = this.mRuntimeExtras.triggeredContentAuthorities;
        boolean z3 = (list == null || list.isEmpty()) ? false : true;
        ParcelUtils.writeBooleanValue(parcel, z3);
        if (z3) {
            int size = list.size();
            Uri[] uriArr = new Uri[size];
            for (int i2 = 0; i2 < size; i2++) {
                uriArr[i2] = list.get(i2);
            }
            parcel.writeParcelableArray(uriArr, i);
        }
        if (list2 != null && !list2.isEmpty()) {
            z = true;
        }
        ParcelUtils.writeBooleanValue(parcel, z);
        if (z) {
            parcel.writeStringList(list2);
        }
    }

    public WorkerParameters.RuntimeExtras getRuntimeExtras() {
        return this.mRuntimeExtras;
    }

    static class Api21Impl {
        static Parcelable castToParcelable(Network network) {
            return network;
        }

        private Api21Impl() {
        }
    }
}
