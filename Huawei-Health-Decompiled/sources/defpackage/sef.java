package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes11.dex */
public class sef extends sdy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("reqSource")
    private int f17679a;

    @SerializedName("appVersion")
    private String b;

    @SerializedName("taskScenarios")
    private int c;

    @SerializedName(ParsedFieldTag.KAKA_TASK_RULE)
    private int d;

    @SerializedName("taskId")
    private String e;

    public void a(String str) {
        this.e = str;
    }

    public void e(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.d = i;
    }

    public void a(int i) {
        this.f17679a = i;
    }
}
