package defpackage;

import com.huawei.health.R;
import com.huawei.health.suggestion.ui.voice.IVoiceContentConstructor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class hmf implements IVoiceContentConstructor {
    private static volatile hmf c;
    private int d = R.raw._2131886250_res_0x7f1200aa;
    private int j = R.raw._2131886249_res_0x7f1200a9;
    private int e = R.raw._2131886246_res_0x7f1200a6;
    private int b = R.raw._2131886247_res_0x7f1200a7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13886a = R.raw._2131886248_res_0x7f1200a8;

    private hmf() {
    }

    public static hmf a() {
        if (c == null) {
            synchronized (hmf.class) {
                if (c == null) {
                    c = new hmf();
                }
            }
        }
        return c;
    }

    private Integer e(int i) {
        if (i == 1) {
            return Integer.valueOf(this.d);
        }
        if (i == 2) {
            return Integer.valueOf(this.j);
        }
        if (i == 3) {
            return Integer.valueOf(this.e);
        }
        if (i == 4) {
            return Integer.valueOf(this.b);
        }
        if (i != 5) {
            return null;
        }
        return Integer.valueOf(this.f13886a);
    }

    private Object d(Integer num) {
        ArrayList arrayList = new ArrayList();
        int iIntValue = num.intValue();
        if (iIntValue == 1) {
            arrayList.add(Integer.valueOf(R.raw._2131886295_res_0x7f1200d7));
            arrayList.add(Integer.valueOf(R.raw._2131886225_res_0x7f120091));
        } else if (iIntValue == 2) {
            arrayList.add(Integer.valueOf(R.raw._2131886245_res_0x7f1200a5));
            arrayList.add(Integer.valueOf(R.raw._2131886224_res_0x7f120090));
        }
        return arrayList;
    }

    @Override // com.huawei.health.suggestion.ui.voice.IVoiceContentConstructor
    public Object constructContent(int i, Object obj) {
        if (i == 1) {
            if (obj instanceof Integer) {
                return e(((Integer) obj).intValue());
            }
        } else if (i == 101 && (obj instanceof Integer)) {
            return d((Integer) obj);
        }
        return null;
    }
}
