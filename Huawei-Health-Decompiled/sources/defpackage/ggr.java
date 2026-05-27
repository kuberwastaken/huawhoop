package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ggr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("questionResult")
    private List<ggt> f13449a;

    public void d(List<ggt> list) {
        this.f13449a = list;
    }

    public List<ggt> d() {
        return this.f13449a;
    }

    public String toString() {
        return "{\"QuestionnaireResult\": {\"questionnaire\":" + this.f13449a + "}}";
    }
}
