package defpackage;

import com.google.gson.annotations.SerializedName;
import defpackage.cvg;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class cvj implements Comparator<cvj> {

    @SerializedName("sleepMonitorReport")
    private cvg.b e;

    @SerializedName("isRead")
    private boolean b = false;

    @SerializedName("isFavourite")
    private boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isAutoCleared")
    private boolean f12049a = false;

    public cvg.b d() {
        return this.e;
    }

    public void c(cvg.b bVar) {
        this.e = bVar;
    }

    public boolean e() {
        return this.c;
    }

    public boolean b() {
        return this.f12049a;
    }

    public void d(boolean z) {
        this.f12049a = z;
    }

    public int hashCode() {
        cvg.b bVar = this.e;
        if (bVar == null) {
            return 0;
        }
        return bVar.hashCode();
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compare(cvj cvjVar, cvj cvjVar2) {
        if (cvjVar.d().a() > cvjVar2.d().a()) {
            return 1;
        }
        return cvjVar.d().a() < cvjVar2.d().a() ? -1 : 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cvj)) {
            return false;
        }
        cvj cvjVar = (cvj) obj;
        if (this.e == null && cvjVar.d() == null) {
            return true;
        }
        if (this.e == null && cvjVar.d() != null) {
            return false;
        }
        if (this.e == null || cvjVar.d() != null) {
            return this.e.equals(cvjVar.d());
        }
        return false;
    }

    public String toString() {
        return "SleepVoiceInfoWrapper{sleepMonitorReport=" + this.e + ", isRead=" + this.b + ", isFavourite=" + this.c + ", isAutoCleared=" + this.f12049a + '}';
    }
}
