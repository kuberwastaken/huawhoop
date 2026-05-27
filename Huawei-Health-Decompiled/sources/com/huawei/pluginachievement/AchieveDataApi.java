package com.huawei.pluginachievement;

import android.content.Context;
import android.os.Handler;
import com.huawei.pluginbase.PluginBaseAdapter;
import defpackage.nof;
import defpackage.noi;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface AchieveDataApi {
    void dealKakaTask(Context context, Handler handler, int i);

    void dealWeChatTask();

    void generateReportHealthData(Context context);

    PluginBaseAdapter getAdapter(Context context);

    nof getData(int i, Map<String, String> map);

    boolean getKakaTaskRedDot(Context context);

    noi getSingleDayData();

    void initAdapter(Context context, PluginBaseAdapter pluginBaseAdapter);
}
