package com.huawei.profile.kv;

import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface ProfileValue extends Parcelable {
    int dataType();

    String getId();

    boolean getIsNeedCloud();

    boolean getIsNeedNearField();

    Map<String, Object> getProfile();

    String getType();

    String toString();

    boolean verify();
}
