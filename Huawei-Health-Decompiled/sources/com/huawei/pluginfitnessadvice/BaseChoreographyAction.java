package com.huawei.pluginfitnessadvice;

import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseChoreographyAction implements Parcelable, Serializable {
    private static final long serialVersionUID = 3629817961368917043L;

    public static final class a {
        public static boolean c(int i) {
            return i == 17 || i == 4 || i == 8;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
