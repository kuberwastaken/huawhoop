package defpackage;

import android.text.TextUtils;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.LogAnonymous;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public class gjg {
    private int f = 450;
    private int b = 420;
    private int c = 390;
    private int d = 360;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13489a = 330;
    private int e = 300;

    public int i() {
        return this.f;
    }

    public void j(int i) {
        this.f = i;
    }

    public int a() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int e() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public int d() {
        return this.f13489a;
    }

    public void a(int i) {
        this.f13489a = i;
    }

    public int c() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public int a(float f) {
        float f2 = this.b;
        if (f > f2 && f <= this.f) {
            return 0;
        }
        float f3 = this.c;
        if (f > f3 && f <= f2) {
            return 1;
        }
        float f4 = this.d;
        if (f > f4 && f <= f3) {
            return 2;
        }
        float f5 = this.f13489a;
        if (f <= f5 || f > f4) {
            return (f <= ((float) this.e) || f > f5) ? -1 : 4;
        }
        return 3;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.a("Track_PaceZoneConfig", "paceZoneConfigStr is null");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 6) {
                this.f = jSONArray.getInt(0);
                this.b = jSONArray.getInt(1);
                this.c = jSONArray.getInt(2);
                this.d = jSONArray.getInt(3);
                this.f13489a = jSONArray.getInt(4);
                this.e = jSONArray.getInt(5);
            }
        } catch (JSONException e) {
            LogUtil.a("Track_PaceZoneConfig", "transformPaceZoneConfig:", LogAnonymous.b(e));
        }
    }

    public int c(int i, boolean z) {
        int i2;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (z) {
                                return this.e;
                            }
                            return this.f13489a;
                        }
                        LogUtil.a("Track_PaceZoneConfig", "paceZone should be given right data ", Integer.valueOf(i));
                        if (i > 0) {
                            return this.f;
                        }
                        return this.e;
                    }
                    if (z) {
                        i2 = this.f13489a;
                    } else {
                        return this.d;
                    }
                } else if (z) {
                    i2 = this.d;
                } else {
                    return this.c;
                }
            } else if (z) {
                i2 = this.c;
            } else {
                return this.b;
            }
        } else if (z) {
            i2 = this.b;
        } else {
            return this.f;
        }
        return i2 + 1;
    }

    public int[] h() {
        return new int[]{this.f, this.b, this.c, this.d, this.f13489a, this.e};
    }
}
