package defpackage;

import com.huawei.hms.common.internal.Preconditions;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class nsj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16157a;
    private List<nsf> e;

    public nsj(String str, List<nsf> list) {
        Preconditions.checkNotNull(str);
        this.f16157a = str;
        this.e = list;
    }

    public List<nsf> c() {
        return this.e;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "DataType{%s%s}", this.f16157a, this.e);
    }
}
