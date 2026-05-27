package defpackage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.huawei.haf.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class iza {
    public static Drawable btL_(String str, int i) {
        LogUtil.b("SportRecordImageHelper", "getSportRecordDrawable imageName = ", str);
        String str2 = epp.b("com.huawei.health_Sport_Common", "sport_record_image", (String) null) + File.separator;
        BitmapDrawable bitmapDrawableCTe_ = pkd.cTe_(str2 + str + ".webp");
        if (bitmapDrawableCTe_ != null) {
            return bitmapDrawableCTe_;
        }
        BitmapDrawable bitmapDrawableCTe_2 = pkd.cTe_(str2 + str + ".png");
        return bitmapDrawableCTe_2 != null ? bitmapDrawableCTe_2 : BaseApplication.a().getDrawable(i);
    }

    public static Drawable btK_(String str) {
        LogUtil.b("SportRecordImageHelper", "getSportRecordDrawable imageName = ", str);
        String str2 = epp.b("com.huawei.health_Sport_Common", "sport_record_image", (String) null) + File.separator;
        BitmapDrawable bitmapDrawableCTe_ = pkd.cTe_(str2 + str + ".webp");
        if (bitmapDrawableCTe_ != null) {
            return bitmapDrawableCTe_;
        }
        return pkd.cTe_(str2 + str + ".png");
    }
}
