package com.huawei.haf.mediaprocess;

import android.view.Surface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public interface IVideoEncodeThread {
    CountDownLatch getEglContextLatch();

    Surface getSurface();
}
