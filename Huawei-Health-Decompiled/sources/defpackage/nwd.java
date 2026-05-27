package defpackage;

import com.huawei.pluginachievement.manager.model.AchieveUserLevelInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public class nwd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private nwh f16206a;
    private AchieveUserLevelInfo b;
    private ArrayList<nvu> d;

    public void e(AchieveUserLevelInfo achieveUserLevelInfo) {
        this.b = achieveUserLevelInfo;
    }

    public nwh b() {
        return this.f16206a;
    }

    public void a(nwh nwhVar) {
        this.f16206a = nwhVar;
    }

    public ArrayList<nvu> e() {
        return this.d;
    }

    public void d(ArrayList<nvu> arrayList) {
        this.d = arrayList;
    }

    public String toString() {
        return "LevelLocationRelationShipData{userLevelInfo=" + this.f16206a + ", LevelListInfo=" + this.d + '}';
    }
}
