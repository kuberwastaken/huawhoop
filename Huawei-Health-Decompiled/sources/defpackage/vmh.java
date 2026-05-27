package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.media3.common.C;
import com.huawei.health.R;
import com.huawei.openalliance.ad.constant.Constants;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class vmh {
    private static final Typeface b = Typeface.create(Constants.FONT, 0);
    private static final Typeface e = Typeface.create(C.SANS_SERIF_NAME, 0);

    public static boolean a(Context context) {
        if (context == null || context.getResources() == null) {
            return false;
        }
        Configuration configuration = context.getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        String country = configuration.locale.getCountry();
        if ("my".equals(language)) {
            return "MM".equals(country) || "ZG".equals(country);
        }
        return false;
    }

    public static String b(int i) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.getDefault());
        numberInstance.setGroupingUsed(false);
        return numberInstance.format(i);
    }

    public static float c(Context context, float f) {
        return (f / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static void evG_(Typeface typeface, Paint paint) {
        if (paint != null) {
            paint.setTypeface(typeface);
        }
    }

    public static Typeface evE_(Context context) {
        return Typeface.create(context.getResources().getString(R.string._2130851947_res_0x7f02386b), 0);
    }

    public static Typeface evF_(Context context) {
        return Typeface.create(context.getResources().getString(R.string._2130851948_res_0x7f02386c), 0);
    }
}
