package com.huawei.health.track.post.process.callback;

import com.huawei.hwfoundationmodel.trackprocess.TrajectoryPoint;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public interface TrackProcessCallback {
    void onResponse(int i, ArrayList<TrajectoryPoint> arrayList);
}
