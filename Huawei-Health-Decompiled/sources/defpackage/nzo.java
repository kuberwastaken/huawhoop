package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes7.dex */
public class nzo {

    @SerializedName(ParsedFieldTag.ACTION_TYPE)
    private int c;

    @SerializedName("actionId")
    private String d;

    public String a() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    public int b() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }
}
