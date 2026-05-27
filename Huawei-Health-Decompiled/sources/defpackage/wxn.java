package defpackage;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringRange;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* JADX INFO: loaded from: classes8.dex */
public class wxn implements KfsConstraintValidator<KfsStringRange, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18965a;
    private String b;
    private String d;
    private int e;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void initialize(String str, KfsStringRange kfsStringRange) throws www {
        this.f18965a = kfsStringRange.min();
        this.e = kfsStringRange.max();
        this.d = str;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean isValid(String str) {
        if (str == null) {
            this.b = this.d + " is null";
            return false;
        }
        if (str.length() < this.f18965a) {
            this.b = this.d + " length must >= " + this.f18965a;
            return false;
        }
        if (str.length() <= this.e) {
            return true;
        }
        this.b = this.d + " length must <= " + this.e;
        return false;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.b;
    }
}
