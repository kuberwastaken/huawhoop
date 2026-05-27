package defpackage;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.Constants;
import health.compact.a.LogUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class chv {
    public static boolean d(String str, String str2) throws ParseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String str3 = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS).format(new Date(System.currentTimeMillis()));
        LogUtil.a("TimeDateFormatUtils", "nowTimeStr: ", str3);
        boolean zC = c(new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS).parse(str3), new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS).parse(str), new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS).parse(str2));
        LogUtil.a("TimeDateFormatUtils", "isEffectiveDate: ", Boolean.valueOf(zC));
        return zC;
    }

    private static boolean c(Date date, Date date2, Date date3) {
        if (date.getTime() == date2.getTime() || date.getTime() == date3.getTime()) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        return calendar.after(calendar2) && calendar.before(calendar3);
    }
}
