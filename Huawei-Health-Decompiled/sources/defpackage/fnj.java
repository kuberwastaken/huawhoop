package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fnj implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("distanceTypes")
    private List<Cfor> f13040a;

    @SerializedName("pathThemes")
    private List<Cfor> b;

    @SerializedName("pathTypes")
    private List<Cfor> c;

    @SerializedName("pathClasses")
    private List<Cfor> e;

    public List<Cfor> a() {
        return this.b;
    }

    public List<Cfor> b() {
        return this.c;
    }

    public List<Cfor> c() {
        return this.f13040a;
    }

    public String toString() {
        return "CityPathAttribute{pathClasses=" + this.e + ", pathThemes=" + this.b + ", pathTypes=" + this.c + ", distanceTypes=" + this.f13040a + '}';
    }
}
