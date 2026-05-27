package defpackage;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsIntegerRange;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* JADX INFO: loaded from: classes8.dex */
public class wxh implements KfsConstraintValidator<KfsIntegerRange, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18963a;
    private String c;
    private int d;
    private int e;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void initialize(String str, KfsIntegerRange kfsIntegerRange) throws www {
        this.d = kfsIntegerRange.min();
        this.e = kfsIntegerRange.max();
        this.f18963a = str;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean isValid(Integer num) {
        if (num == null) {
            this.c = this.f18963a + " is null";
            return false;
        }
        if (this.d > num.intValue()) {
            this.c = this.f18963a + " must >= " + this.d;
            return false;
        }
        if (this.e >= num.intValue()) {
            return true;
        }
        this.c = this.f18963a + " must <= " + this.e;
        return false;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.c;
    }
}
