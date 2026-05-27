package com.huawei.ui.main.stories.nps.interactors.util;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes8.dex */
public class TaskUtils {
    public static final String K_CLOUD_FRAGEMENT_MIDDLE = "IrzLoccccR72B/H4EI3GKB6ny7lTZGH7";

    private TaskUtils() {
    }

    public static <Params, Progress, Result> void executeAsyncTask(AsyncTask<Params, Params, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
