package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class czc {

    @SerializedName("countryCodeList")
    private List<String> c = new ArrayList();

    czc() {
    }

    public List<String> b() {
        return this.c;
    }

    public String toString() {
        return "CountryCodeStruct{countryCodeList='" + this.c + '}';
    }
}
