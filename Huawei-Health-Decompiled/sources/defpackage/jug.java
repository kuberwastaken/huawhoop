package defpackage;

import android.text.TextUtils;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.data.type.HiHealthDataType;
import com.huawei.operation.utils.Constants;
import health.compact.a.CommonUtil;
import health.compact.a.LogAnonymous;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class jug {
    public static String d(int i, int i2) {
        return c(i, i2, "sample_session");
    }

    public static String c(int i, int i2, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "datetime(start_time/1000" + d();
        } else {
            str2 = "datetime(" + str + ".start_time/1000" + d();
        }
        switch (i) {
            case 1:
                return "(strftime('%H', " + str2 + "*60+strftime('%M', " + str2 + ")/" + i2 + " as unit_index,";
            case 2:
                return "strftime('%Y-%m-%d %H', " + str2 + " as unit_index,";
            case 3:
                return "strftime('%Y-%m-%d', " + str2 + " as unit_index,";
            case 4:
                return "strftime('%Y-%W', " + str2 + " as unit_index,";
            case 5:
                return "strftime('%Y-%m', " + str2 + " as unit_index,";
            case 6:
                return "strftime('%Y', " + str2 + " as unit_index,";
            case 7:
                return "strftime('AGG_ALL', " + str2 + " as unit_index,";
            default:
                return "";
        }
    }

    public static String e(int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 0) {
            b(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
        } else if (i == 1) {
            e(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
        } else if (i == 2) {
            e(stringBuffer, "stat_type", i2, str);
        } else if (i == 3) {
            a(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
        } else if (i == 4) {
            c(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
        } else if (i == 5) {
            d(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
        }
        return stringBuffer.toString();
    }

    public static String b(int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 0) {
            b(stringBuffer, "sample_point", "type_id", "value", i2, str);
        } else if (i == 1) {
            e(stringBuffer, "sample_point", "type_id", "value", i2, str);
        } else if (i == 2) {
            e(stringBuffer, "sample_point", "type_id", i2, str);
        } else if (i == 3) {
            a(stringBuffer, "sample_point", "type_id", "value", i2, str);
        } else if (i == 4) {
            c(stringBuffer, "sample_point", "type_id", "value", i2, str);
        } else if (i == 5) {
            d(stringBuffer, "sample_point", "type_id", "value", i2, str);
        }
        return stringBuffer.toString();
    }

    public static String d(int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 == 0) {
            c(stringBuffer, i, str);
            return stringBuffer.toString();
        }
        if (i == 0) {
            b(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
        } else if (i == 1) {
            e(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
        } else if (i == 2) {
            e(stringBuffer, "type_id", i2, str);
        } else if (i == 3) {
            a(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
        } else if (i == 4) {
            c(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
        } else if (i == 5) {
            d(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
        }
        return stringBuffer.toString();
    }

    private static void c(StringBuffer stringBuffer, int i, String str) {
        if (i == 1) {
            stringBuffer.append(" sum ");
        } else if (i == 2) {
            stringBuffer.append(" count ");
        } else if (i == 3) {
            stringBuffer.append(" avg ");
        } else if (i == 4) {
            stringBuffer.append(" max ");
        } else if (i == 5) {
            stringBuffer.append(" min ");
        }
        stringBuffer.append(Constants.LEFT_BRACKET_ONLY).append(str).append(Constants.RIGHT_BRACKET_ONLY).append(" as ").append(str);
    }

    public static String a(int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 1) {
            e(stringBuffer, "sample_point_health_stress", "type_id", "value", i2, str);
        } else if (i == 2) {
            e(stringBuffer, "sample_point_health_stress", "type_id", i2, str);
        } else if (i == 3) {
            a(stringBuffer, "sample_point_health_stress", "type_id", "value", i2, str);
        } else if (i == 4) {
            c(stringBuffer, "sample_point_health_stress", "type_id", "value", i2, str);
        } else if (i == 5) {
            d(stringBuffer, "sample_point_health_stress", "type_id", "value", i2, str);
        }
        return stringBuffer.toString();
    }

    public static String b(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 0 || i == 1) {
            stringBuffer.append(" sum (sample_session.end_time - sample_session.start_time )/1000 as ").append(str);
        } else if (i == 2) {
            stringBuffer.append(" count (sample_session.type_id) as ").append(str);
        }
        return stringBuffer.toString();
    }

    public static String d(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 0 || i == 1) {
            stringBuffer.append(" sum (sample_session_health.end_time - sample_session_health.start_time )/1000 as ").append(str);
        } else if (i == 2) {
            stringBuffer.append(" count (sample_session_health.type_id) as ").append(str);
        }
        return stringBuffer.toString();
    }

    public static String c(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 0 || i == 1) {
            stringBuffer.append(" sum (sample_session_core.end_time - sample_session_core.start_time )/1000 as ").append(str);
        } else if (i == 2) {
            stringBuffer.append(" count (sample_session_core.type_id) as ").append(str);
        }
        return stringBuffer.toString();
    }

    public static void e(StringBuffer stringBuffer, String str, String str2) {
        stringBuffer.append(" group by ").append(str).append(".").append(str2);
    }

    public static void b(StringBuffer stringBuffer, String str, int i) {
        if (i == 0) {
            stringBuffer.append(" ORDER BY ").append(str).append(" ASC ");
        } else {
            if (i != 1) {
                return;
            }
            stringBuffer.append(" ORDER BY ").append(str).append(" DESC ");
        }
    }

    public static void c(StringBuffer stringBuffer, String str, String str2, int i) {
        if (i == 0) {
            stringBuffer.append(" ORDER BY ").append(str).append(".").append(str2).append(" ASC ");
        } else {
            if (i != 1) {
                return;
            }
            stringBuffer.append(" ORDER BY ").append(str).append(".").append(str2).append(" DESC ");
        }
    }

    public static void b(StringBuffer stringBuffer, String str) {
        stringBuffer.append(" having ").append("menstrual_status").append(" = ").append(d(str));
    }

    private static String d(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ReleaseLogUtil.c("HiH_SqlUtilHelper", "appendHaving getString", LogAnonymous.b(e));
            i = 0;
        }
        return HiHealthDataType.a(i);
    }

    public static void e(StringBuffer stringBuffer, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        stringBuffer.append(" limit ").append(i).append(",").append(i2);
    }

    public static void e(StringBuffer stringBuffer, String str, String str2, int i, String str3) {
        stringBuffer.append(" sum ").append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append("1 else 0 end)").append(" as ").append(str3);
    }

    private static void e(StringBuffer stringBuffer, String str, int i, String str2) {
        stringBuffer.append(" sum ").append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(" when ").append(i).append(" then ").append("1 else 0 end)").append(" as ").append(str2);
    }

    public static void a(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(Constants.LEFT_BRACKET_ONLY).append(" sum ").append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" else 0 end)").append("/").append(" sum ").append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append("1 else 0 end))").append(" as ").append(str4);
    }

    public static void e(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(" sum ").append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" end)").append(" as ").append(str4);
    }

    public static void c(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(" max ").append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" end)").append(" as ").append(str4);
    }

    public static void d(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(" min ").append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" end)").append(" as ").append(str4);
    }

    public static void b(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(Constants.LEFT_BRACKET_ONLY).append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" else 0 end)").append(" as ").append(str4);
    }

    public static void e(StringBuffer stringBuffer, String str) {
        stringBuffer.append(" group by ").append(str);
    }

    public static void b(String str, List<Integer> list, StringBuffer stringBuffer, String[] strArr, int i) {
        e(str, CommonUtil.c(list), stringBuffer, strArr, i);
    }

    public static void e(String str, int[] iArr, StringBuffer stringBuffer, String[] strArr, int i) {
        if (i == 0) {
            stringBuffer.append(str).append(" in ( ");
        } else {
            stringBuffer.append(" and ").append(str).append(" in ( ");
        }
        c(iArr, stringBuffer, strArr, i);
    }

    public static void b(String str, int[] iArr, StringBuffer stringBuffer, String[] strArr, int i) {
        if (i == 0) {
            stringBuffer.append(str).append(" not in ( ");
        } else {
            stringBuffer.append(" and ").append(str).append(" not in ( ");
        }
        c(iArr, stringBuffer, strArr, i);
    }

    public static void a(StringBuffer stringBuffer, String str) {
        if (!stringBuffer.toString().endsWith(" and ")) {
            stringBuffer.append(" and ");
        }
        stringBuffer.append(str).append(".").append("modified_time").append(" >=? and ").append(str).append(".").append("modified_time").append(" <=? ");
    }

    public static int b(String[] strArr, int i, HiDataReadOption hiDataReadOption) {
        if (hiDataReadOption.getModifiedEndTime() <= 0) {
            return i;
        }
        strArr[i] = Long.toString(hiDataReadOption.getModifiedStartTime());
        strArr[i + 1] = Long.toString(hiDataReadOption.getModifiedEndTime());
        return i + 2;
    }

    private static void c(int[] iArr, StringBuffer stringBuffer, String[] strArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 == 0) {
                stringBuffer.append(" ? ");
            } else {
                stringBuffer.append(",?");
            }
            strArr[i + i2] = Integer.toString(iArr[i2]);
        }
        stringBuffer.append(" )");
    }

    private static String d() {
        return ", 'unixepoch','localtime'))";
    }

    public static String d(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return "date as unit_index,";
            case 5:
                return "date/100 as unit_index,";
            case 6:
                return "date/10000 as unit_index,";
            case 7:
                return "date/10000000000 as unit_index,";
            case 8:
            default:
                return "";
            case 9:
                return "strftime('%Y-%W', substr(date,1,4)-substr(date,5,2)-substr(date,7,2)) as unit_index,";
        }
    }
}
