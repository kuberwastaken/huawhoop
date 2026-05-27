package defpackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huawei.tabtemplate.BaseTemplateConfig;

/* JADX INFO: loaded from: classes8.dex */
public class uyg<T extends BaseTemplateConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("version")
    @Expose
    private String f18514a;

    @SerializedName("template_config")
    @Expose
    private T c;

    @SerializedName("template_parser")
    @Expose
    private String d;

    @SerializedName("template_id")
    @Expose
    private String e;

    public String e() {
        return this.f18514a;
    }

    public T d() {
        return this.c;
    }
}
