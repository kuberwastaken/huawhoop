package defpackage;

import com.huawei.wearengine.sensor.DataResult;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes9.dex */
public class aim extends DateFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final DateFormat f238a;
    protected static final TimeZone b;
    protected static final String[] c;
    protected static final Locale d;
    protected static final Calendar e;
    protected static final Pattern g;
    public static final aim h;
    protected static final Pattern i = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");
    protected final Locale f;
    protected Boolean j;
    private transient DateFormat k;
    private boolean m;
    protected transient TimeZone n;
    private transient Calendar o;

    @Override // java.text.DateFormat
    public boolean equals(Object obj) {
        return obj == this;
    }

    static {
        try {
            g = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
            c = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
            TimeZone timeZone = TimeZone.getTimeZone(DataResult.UTC);
            b = timeZone;
            Locale locale = Locale.US;
            d = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            f238a = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            h = new aim();
            e = new GregorianCalendar(timeZone, locale);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public aim() {
        this.m = true;
        this.f = d;
    }

    protected aim(TimeZone timeZone, Locale locale, Boolean bool, boolean z) {
        this.n = timeZone;
        this.f = locale;
        this.j = bool;
        this.m = z;
    }

    public aim d(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = b;
        }
        TimeZone timeZone2 = this.n;
        return (timeZone == timeZone2 || timeZone.equals(timeZone2)) ? this : new aim(timeZone, this.f, this.j, this.m);
    }

    public aim e(Locale locale) {
        return locale.equals(this.f) ? this : new aim(this.n, locale, this.j, this.m);
    }

    public aim a(Boolean bool) {
        return d(bool, this.j) ? this : new aim(this.n, this.f, bool, this.m);
    }

    @Override // java.text.DateFormat, java.text.Format
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public aim clone() {
        return new aim(this.n, this.f, this.j, this.m);
    }

    @Override // java.text.DateFormat
    public TimeZone getTimeZone() {
        return this.n;
    }

    @Override // java.text.DateFormat
    public void setTimeZone(TimeZone timeZone) {
        if (timeZone.equals(this.n)) {
            return;
        }
        a();
        this.n = timeZone;
    }

    @Override // java.text.DateFormat
    public void setLenient(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        if (d(boolValueOf, this.j)) {
            return;
        }
        this.j = boolValueOf;
        a();
    }

    @Override // java.text.DateFormat
    public boolean isLenient() {
        Boolean bool = this.j;
        return bool == null || bool.booleanValue();
    }

    @Override // java.text.DateFormat
    public Date parse(String str) throws ParseException {
        String strTrim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date dateC = c(strTrim, parsePosition);
        if (dateC != null) {
            return dateC;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : c) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(str2);
        }
        sb.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", strTrim, sb.toString()), parsePosition.getErrorIndex());
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        try {
            return c(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }

    protected Date c(String str, ParsePosition parsePosition) throws ParseException {
        if (e(str)) {
            return d(str, parsePosition);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < '0' || cCharAt > '9') {
                if (length > 0 || cCharAt != '-') {
                    break;
                }
            }
        }
        if (length < 0 && (str.charAt(0) == '-' || xh.c(str, false))) {
            return e(str, parsePosition);
        }
        return a(str, parsePosition);
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.n;
        if (timeZone == null) {
            timeZone = b;
        }
        c(timeZone, this.f, date, stringBuffer);
        return stringBuffer;
    }

    protected void c(TimeZone timeZone, Locale locale, Date date, StringBuffer stringBuffer) {
        Calendar calendarB = b(timeZone);
        calendarB.setTime(date);
        int i2 = calendarB.get(1);
        if (calendarB.get(0) == 0) {
            c(stringBuffer, i2);
        } else {
            if (i2 > 9999) {
                stringBuffer.append('+');
            }
            b(stringBuffer, i2);
        }
        stringBuffer.append('-');
        d(stringBuffer, calendarB.get(2) + 1);
        stringBuffer.append('-');
        d(stringBuffer, calendarB.get(5));
        stringBuffer.append('T');
        d(stringBuffer, calendarB.get(11));
        stringBuffer.append(':');
        d(stringBuffer, calendarB.get(12));
        stringBuffer.append(':');
        d(stringBuffer, calendarB.get(13));
        stringBuffer.append(FilenameUtils.EXTENSION_SEPARATOR);
        e(stringBuffer, calendarB.get(14));
        int offset = timeZone.getOffset(calendarB.getTimeInMillis());
        if (offset != 0) {
            int i3 = offset / 60000;
            int iAbs = Math.abs(i3 / 60);
            int iAbs2 = Math.abs(i3 % 60);
            stringBuffer.append(offset < 0 ? '-' : '+');
            d(stringBuffer, iAbs);
            if (this.m) {
                stringBuffer.append(':');
            }
            d(stringBuffer, iAbs2);
            return;
        }
        if (this.m) {
            stringBuffer.append("+00:00");
        } else {
            stringBuffer.append("+0000");
        }
    }

    protected void c(StringBuffer stringBuffer, int i2) {
        if (i2 == 1) {
            stringBuffer.append("+0000");
        } else {
            stringBuffer.append('-');
            b(stringBuffer, i2 - 1);
        }
    }

    private static void d(StringBuffer stringBuffer, int i2) {
        int i3 = i2 / 10;
        if (i3 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i3 + 48));
            i2 -= i3 * 10;
        }
        stringBuffer.append((char) (i2 + 48));
    }

    private static void e(StringBuffer stringBuffer, int i2) {
        int i3 = i2 / 100;
        if (i3 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i3 + 48));
            i2 -= i3 * 100;
        }
        d(stringBuffer, i2);
    }

    private static void b(StringBuffer stringBuffer, int i2) {
        int i3 = i2 / 100;
        if (i3 == 0) {
            stringBuffer.append('0').append('0');
        } else {
            if (i3 > 99) {
                stringBuffer.append(i3);
            } else {
                d(stringBuffer, i3);
            }
            i2 -= i3 * 100;
        }
        d(stringBuffer, i2);
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", getClass().getName(), this.n, this.f, this.j);
    }

    public String d() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (");
        sb.append(Boolean.FALSE.equals(this.j) ? "strict" : "lenient");
        sb.append(")]");
        return sb.toString();
    }

    @Override // java.text.DateFormat
    public int hashCode() {
        return System.identityHashCode(this);
    }

    protected boolean e(String str) {
        return str.length() >= 7 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-' && Character.isDigit(str.charAt(5));
    }

    private Date e(String str, ParsePosition parsePosition) throws ParseException {
        try {
            return new Date(xh.a(str));
        } catch (NumberFormatException unused) {
            throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", str), parsePosition.getErrorIndex());
        }
    }

    protected Date d(String str, ParsePosition parsePosition) throws ParseException {
        try {
            return b(str, parsePosition);
        } catch (IllegalArgumentException e2) {
            throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", str, e2.getMessage()), parsePosition.getErrorIndex());
        }
    }

    protected Date b(String str, ParsePosition parsePosition) throws ParseException, IllegalArgumentException {
        String str2;
        int length = str.length();
        TimeZone timeZone = b;
        if (this.n != null && 'Z' != str.charAt(length - 1)) {
            timeZone = this.n;
        }
        Calendar calendarB = b(timeZone);
        calendarB.clear();
        int iCharAt = 0;
        if (length <= 10) {
            if (i.matcher(str).matches()) {
                calendarB.set(c(str, 0), d(str, 5) - 1, d(str, 8), 0, 0, 0);
                calendarB.set(14, 0);
                return calendarB.getTime();
            }
            str2 = "yyyy-MM-dd";
        } else {
            Matcher matcher = g.matcher(str);
            if (matcher.matches()) {
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                int i2 = iEnd - iStart;
                if (i2 > 1) {
                    int iD = d(str, iStart + 1) * 3600;
                    if (i2 >= 5) {
                        iD += d(str, iEnd - 2) * 60;
                    }
                    calendarB.set(15, str.charAt(iStart) == '-' ? iD * (-1000) : iD * 1000);
                    calendarB.set(16, 0);
                }
                calendarB.set(c(str, 0), d(str, 5) - 1, d(str, 8), d(str, 11), d(str, 14), (length <= 16 || str.charAt(16) != ':') ? 0 : d(str, 17));
                int iStart2 = matcher.start(1);
                int i3 = iStart2 + 1;
                int iEnd2 = matcher.end(1);
                if (i3 >= iEnd2) {
                    calendarB.set(14, 0);
                } else {
                    int i4 = iEnd2 - i3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                if (i4 != 3 && i4 > 9) {
                                    throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", str, matcher.group(1).substring(1)), i3);
                                }
                                iCharAt = str.charAt(iStart2 + 3) - '0';
                            }
                            iCharAt += (str.charAt(iStart2 + 2) - '0') * 10;
                        }
                        iCharAt += (str.charAt(i3) - '0') * 100;
                    }
                    calendarB.set(14, iCharAt);
                }
                return calendarB.getTime();
            }
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        }
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", str, str2, this.j), 0);
    }

    private static int c(String str, int i2) {
        return ((str.charAt(i2) - '0') * 1000) + ((str.charAt(i2 + 1) - '0') * 100) + ((str.charAt(i2 + 2) - '0') * 10) + (str.charAt(i2 + 3) - '0');
    }

    private static int d(String str, int i2) {
        return ((str.charAt(i2) - '0') * 10) + (str.charAt(i2 + 1) - '0');
    }

    protected Date a(String str, ParsePosition parsePosition) {
        if (this.k == null) {
            this.k = b(f238a, "EEE, dd MMM yyyy HH:mm:ss zzz", this.n, this.f, this.j);
        }
        return this.k.parse(str, parsePosition);
    }

    private static final DateFormat b(DateFormat dateFormat, String str, TimeZone timeZone, Locale locale, Boolean bool) {
        DateFormat simpleDateFormat;
        if (!locale.equals(d)) {
            simpleDateFormat = new SimpleDateFormat(str, locale);
            if (timeZone == null) {
                timeZone = b;
            }
            simpleDateFormat.setTimeZone(timeZone);
        } else {
            simpleDateFormat = (DateFormat) dateFormat.clone();
            if (timeZone != null) {
                simpleDateFormat.setTimeZone(timeZone);
            }
        }
        if (bool != null) {
            simpleDateFormat.setLenient(bool.booleanValue());
        }
        return simpleDateFormat;
    }

    protected void a() {
        this.k = null;
    }

    protected Calendar b(TimeZone timeZone) {
        Calendar calendar = this.o;
        if (calendar == null) {
            calendar = (Calendar) e.clone();
            this.o = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    protected static <T> boolean d(T t, T t2) {
        if (t == t2) {
            return true;
        }
        return t != null && t.equals(t2);
    }
}
