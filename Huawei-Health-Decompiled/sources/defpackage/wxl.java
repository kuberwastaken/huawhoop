package defpackage;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringRegex;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* JADX INFO: loaded from: classes8.dex */
public class wxl implements KfsConstraintValidator<KfsStringRegex, String> {
    private String b;
    private String c;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void initialize(String str, KfsStringRegex kfsStringRegex) throws www {
        this.b = kfsStringRegex.regex();
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean isValid(String str) {
        if (str == null) {
            this.c = "string is null";
            return false;
        }
        if (str.matches(this.b)) {
            return true;
        }
        this.c = "value is not match";
        return false;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.c;
    }
}
