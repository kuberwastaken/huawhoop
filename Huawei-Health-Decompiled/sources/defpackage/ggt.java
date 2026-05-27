package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.jsoperation.JsUtil;

/* JADX INFO: loaded from: classes.dex */
public class ggt {

    @SerializedName(JsUtil.SCORE)
    private int c;

    @SerializedName("question")
    private int e;

    public void c(int i) {
        this.e = i;
    }

    public void e(int i) {
        this.c = i;
    }

    public String toString() {
        return "{\"Questionnaire\": {\"question\":" + this.e + ", \"score\":" + this.c + "}}";
    }
}
