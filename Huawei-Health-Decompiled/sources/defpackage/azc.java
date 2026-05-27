package defpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ApiCode;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class azc implements IConnectionResult {
    private final PendingIntent b;
    private final int c;
    private final String d;

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.b.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), this.b, this.d});
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public boolean hasResolution() {
        return (this.c == 0 || this.b == null) ? false : true;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public int getStatusCode() {
        return this.c;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public PendingIntent getResolution() {
        return this.b;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public String getErrorMessage() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof azc)) {
            return false;
        }
        azc azcVar = (azc) obj;
        if (this.c == azcVar.c && this.b == null) {
            if (azcVar.b == null) {
                return true;
            }
        } else if (this.b.equals(azcVar.b) && TextUtils.equals(this.d, azcVar.d)) {
            return true;
        }
        return false;
    }

    public azc(int i, PendingIntent pendingIntent, String str) {
        this.c = i;
        this.b = pendingIntent;
        this.d = str;
    }

    public azc(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, ApiCode.getStatusCodeString(i));
    }

    public azc(int i) {
        this(i, null);
    }
}
