package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;

/* JADX INFO: loaded from: classes4.dex */
public class giz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private int f13481a;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private int b;

    @SerializedName("operType")
    private int c;

    @SerializedName("pageNo")
    private int d;

    @SerializedName("infoType")
    private int e;

    private giz(a aVar) {
        this.d = aVar.e;
        this.b = aVar.b;
        this.c = aVar.d;
        this.e = aVar.f13482a;
        this.f13481a = aVar.c;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13482a;
        private int b;
        private int c;
        private int d;
        private int e;

        public a b(int i) {
            this.e = i;
            return this;
        }

        public a d(int i) {
            this.b = i;
            return this;
        }

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a e(int i) {
            this.f13482a = i;
            return this;
        }

        public a c(int i) {
            this.c = i;
            return this;
        }

        public giz e() {
            return new giz(this);
        }
    }
}
