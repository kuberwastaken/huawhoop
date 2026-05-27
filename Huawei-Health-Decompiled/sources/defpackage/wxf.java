package defpackage;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsLongRange;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* JADX INFO: loaded from: classes8.dex */
public class wxf implements KfsConstraintValidator<KfsLongRange, Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f18962a;
    private Long c;
    private String d;
    private String e;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void initialize(String str, KfsLongRange kfsLongRange) throws www {
        this.f18962a = Long.valueOf(kfsLongRange.min());
        this.c = Long.valueOf(kfsLongRange.max());
        this.e = str;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isValid(Long l) {
        if (l == null) {
            this.d = this.e + " is null";
            return false;
        }
        if (l.longValue() < this.f18962a.longValue()) {
            this.d = this.e + " must >= " + this.f18962a;
            return false;
        }
        if (l.longValue() <= this.c.longValue()) {
            return true;
        }
        this.d = this.e + " must <= " + this.c;
        return false;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.d;
    }
}
