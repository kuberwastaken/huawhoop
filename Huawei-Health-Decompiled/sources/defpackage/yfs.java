package defpackage;

import java.util.concurrent.TimeUnit;
import org.eclipse.californium.elements.config.DocumentedDefinition;

/* JADX INFO: loaded from: classes8.dex */
public class yfs extends DocumentedDefinition<Long> {
    public yfs(String str, String str2) {
        super(str, str2, Long.class, null);
    }

    public yfs(String str, String str2, long j, TimeUnit timeUnit) {
        super(str, str2, Long.class, Long.valueOf(TimeUnit.NANOSECONDS.convert(j, timeUnit)));
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String writeValue(Long l) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (l.longValue() != 0) {
            timeUnit = TimeUnit.NANOSECONDS;
            if (l.longValue() % 1000 == 0) {
                timeUnit = TimeUnit.MICROSECONDS;
                l = Long.valueOf(l.longValue() / 1000);
                if (l.longValue() % 1000 == 0) {
                    timeUnit = TimeUnit.MILLISECONDS;
                    l = Long.valueOf(l.longValue() / 1000);
                    if (l.longValue() % 1000 == 0) {
                        timeUnit = TimeUnit.SECONDS;
                        l = Long.valueOf(l.longValue() / 1000);
                        if (l.longValue() % 60 == 0) {
                            timeUnit = TimeUnit.MINUTES;
                            l = Long.valueOf(l.longValue() / 60);
                            if (l.longValue() % 60 == 0) {
                                timeUnit = TimeUnit.HOURS;
                                l = Long.valueOf(l.longValue() / 60);
                                if (l.longValue() % 24 == 0) {
                                    timeUnit = TimeUnit.DAYS;
                                    l = Long.valueOf(l.longValue() / 24);
                                }
                            }
                        }
                    }
                }
            }
        }
        return l + "[" + a(timeUnit) + "]";
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long checkValue(Long l) throws yfr {
        if (l == null || l.longValue() >= 0) {
            return l;
        }
        throw new yfr("Time " + l + " must be not less than 0!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long parseValue(String str) throws yfr {
        return b(str);
    }

    public static Long b(String str) throws yfr {
        TimeUnit timeUnitD;
        TimeUnit timeUnitD2 = TimeUnit.MILLISECONDS;
        int iIndexOf = str.indexOf(91);
        if (iIndexOf >= 0) {
            int iIndexOf2 = str.indexOf(93);
            if (iIndexOf < iIndexOf2) {
                String strTrim = str.substring(0, iIndexOf).trim();
                String strTrim2 = str.substring(iIndexOf + 1, iIndexOf2).trim();
                timeUnitD2 = d(strTrim2);
                if (timeUnitD2 == null) {
                    throw new yfr(strTrim2 + " unknown unit!");
                }
                str = strTrim;
            } else {
                throw new yfr(str + " doesn't match value[unit]!");
            }
        } else if (!Character.isDigit(str.charAt(str.length() - 1)) && (timeUnitD = d(str)) != null) {
            str = str.substring(0, str.length() - a(timeUnitD).length()).trim();
            timeUnitD2 = timeUnitD;
        }
        return Long.valueOf(TimeUnit.NANOSECONDS.convert(Long.parseLong(str), timeUnitD2));
    }

    /* JADX INFO: renamed from: yfs$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            e = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                e[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                e[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                e[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                e[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(TimeUnit timeUnit) {
        switch (AnonymousClass2.e[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "ys";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                return "";
        }
    }

    public static TimeUnit d(String str) {
        String str2 = "";
        TimeUnit timeUnit = null;
        for (TimeUnit timeUnit2 : TimeUnit.values()) {
            String strA = a(timeUnit2);
            if (!strA.isEmpty()) {
                if (strA.equals(str)) {
                    return timeUnit2;
                }
                if (str.endsWith(strA) && strA.length() > str2.length()) {
                    timeUnit = timeUnit2;
                    str2 = strA;
                }
            }
        }
        return timeUnit;
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    public String getTypeName() {
        return "Time";
    }
}
