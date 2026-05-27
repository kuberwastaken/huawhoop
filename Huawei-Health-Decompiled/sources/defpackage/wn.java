package defpackage;

import com.chipsea.health.CSAlgorithmUtils;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class wn {
    private int b;
    private float c;
    private float g;
    private float h;
    private int i;
    private byte j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18854a = "No Authorized Access!";
    private final String e = "Illegal device!";
    private final long d = 8613800138008L;
    private boolean f = true;
    private int m = Calendar.getInstance().get(1);

    public void b(float f, float f2, byte b, int i, float f3) {
        this.c = f;
        this.h = f2;
        this.j = b;
        this.b = i;
        this.g = f3;
        this.i = 0;
    }

    public int e(float f, float f2, byte b, int i, float f3) {
        if (f < 90.0f || f > 220.0f) {
            return -3;
        }
        if (f2 < 20.0f || f2 > 150.0f) {
            return -2;
        }
        if (i < 10 || i > 99) {
            return -4;
        }
        if (b != 0 && b != 1) {
            return -5;
        }
        this.c = f;
        this.h = f2;
        this.j = b;
        this.b = i;
        this.g = f3;
        this.i = 0;
        return 0;
    }

    public float h() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getTFR(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getTFRS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float i() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getSLM(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getSLMS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float f() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getSMM(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getSMMS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float a() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getPM(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getPMS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float b() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getBFR(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getBFRS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float d() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getBMR(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getBMRS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float e() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getMSW(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getMSWS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float g() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getVFR(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getVFRS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public float c() throws wq {
        int bodyAgeS;
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            bodyAgeS = new CSAlgorithmUtils().getBodyAge(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        } else {
            bodyAgeS = new CSAlgorithmUtils().getBodyAgeS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        int i = this.b;
        int i2 = bodyAgeS - i;
        if (i2 > 10) {
            bodyAgeS = i + 10;
        } else if (i2 < -10) {
            bodyAgeS = i - 10;
        }
        return bodyAgeS;
    }

    public int j() throws wq {
        if (!this.f) {
            throw new wq("No Authorized Access!");
        }
        if (this.i == 0) {
            return new CSAlgorithmUtils().getScore(this.c, this.j, this.h, this.b, (int) this.g, this.m);
        }
        return new CSAlgorithmUtils().getScoreS(this.c, this.j, this.h, this.b, (int) this.g, this.m);
    }

    public static int c(float f, byte b, float f2, int i, float f3) {
        return new CSAlgorithmUtils().getResistance(f, b, f2, i, f3);
    }
}
