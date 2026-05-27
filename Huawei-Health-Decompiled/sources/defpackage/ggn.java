package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes4.dex */
public class ggn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("taskCode")
    private String f13445a;

    @SerializedName("taskId")
    private int b;

    @SerializedName("dailyTaskCard")
    private ggh d;

    @SerializedName(ParsedFieldTag.TASK_TYPE)
    private int e;

    public int a() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public String e() {
        return this.f13445a;
    }

    public ggh c() {
        return this.d;
    }
}
