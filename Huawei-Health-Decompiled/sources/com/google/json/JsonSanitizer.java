package com.google.json;

import com.google.common.base.Ascii;
import com.huawei.operation.utils.Constants;
import java.math.BigInteger;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes.dex */
public final class JsonSanitizer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_NESTING_DEPTH = 64;
    private static final int[] DIGITS_BY_BASE_THAT_FIT_IN_63B;
    private static final char[] HEX_DIGITS;
    public static final int MAXIMUM_NESTING_DEPTH = 4096;
    private static final boolean SUPER_VERBOSE_AND_SLOW_LOGGING = false;
    private static final UnbracketedComma UNBRACKETED_COMMA;
    private int bracketDepth;
    private int cleaned;
    private boolean[] isMap;
    private final String jsonish;
    private final int maximumNestingDepth;
    private StringBuilder sanitizedJson;

    enum State {
        START_ARRAY,
        BEFORE_ELEMENT,
        AFTER_ELEMENT,
        START_MAP,
        BEFORE_KEY,
        AFTER_KEY,
        BEFORE_VALUE,
        AFTER_VALUE
    }

    private static int hexVal(char c) {
        int i = c | ' ';
        return i - (i <= 57 ? 48 : 87);
    }

    private static boolean isHex(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        int i = c | ' ';
        return 97 <= i && i <= 102;
    }

    private static boolean isOct(char c) {
        return '0' <= c && c <= '7';
    }

    public static String sanitize(String str) {
        return sanitize(str, 64);
    }

    public static String sanitize(String str, int i) {
        JsonSanitizer jsonSanitizer = new JsonSanitizer(str, i);
        jsonSanitizer.sanitize();
        return jsonSanitizer.toString();
    }

    JsonSanitizer(String str) {
        this(str, 64);
    }

    JsonSanitizer(String str, int i) {
        this.maximumNestingDepth = Math.min(Math.max(1, i), 4096);
        this.jsonish = str == null ? Constants.NULL : str;
    }

    int getMaximumNestingDepth() {
        return this.maximumNestingDepth;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x010b A[Catch: UnbracketedComma -> 0x0236, TryCatch #0 {UnbracketedComma -> 0x0236, blocks: (B:5:0x001f, B:26:0x0051, B:32:0x006c, B:49:0x0094, B:51:0x009f, B:52:0x00a6, B:62:0x00ba, B:69:0x00c9, B:72:0x00d0, B:74:0x00d5, B:76:0x00df, B:77:0x00e1, B:79:0x00e5, B:81:0x00ec, B:87:0x0107, B:82:0x00f3, B:84:0x00f9, B:86:0x00ff, B:28:0x0056, B:173:0x021d, B:88:0x010b, B:90:0x010f, B:91:0x011a, B:103:0x0139, B:108:0x014b, B:109:0x0150, B:111:0x0154, B:114:0x015d, B:115:0x0160, B:100:0x012e, B:101:0x0132, B:102:0x0136, B:118:0x0166, B:120:0x016f, B:124:0x017a, B:126:0x0186, B:127:0x018a, B:128:0x018e, B:130:0x0193, B:131:0x0197, B:132:0x019e, B:134:0x01a3, B:138:0x01b0, B:140:0x01b4, B:149:0x01cb, B:157:0x01e7, B:150:0x01ce, B:152:0x01d2, B:153:0x01d4, B:155:0x01dd, B:159:0x01ea, B:160:0x01f0, B:162:0x01f5, B:163:0x01fd, B:165:0x0201, B:166:0x0204, B:167:0x0207, B:168:0x020d, B:169:0x0213, B:170:0x0219, B:171:0x021b), top: B:218:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void sanitize() {
        /*
            Method dump skipped, instruction units count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.json.JsonSanitizer.sanitize():void");
    }

    /* JADX INFO: renamed from: com.google.json.JsonSanitizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$json$JsonSanitizer$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$google$json$JsonSanitizer$State = iArr;
            try {
                iArr[State.BEFORE_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$json$JsonSanitizer$State[State.BEFORE_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$json$JsonSanitizer$State[State.BEFORE_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$json$JsonSanitizer$State[State.AFTER_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$json$JsonSanitizer$State[State.START_MAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$json$JsonSanitizer$State[State.START_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$json$JsonSanitizer$State[State.AFTER_ELEMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$json$JsonSanitizer$State[State.AFTER_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a A[PHI: r6
      0x006a: PHI (r6v33 int) = (r6v31 int), (r6v49 int) binds: [B:97:0x015c, B:38:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f A[LOOP:1: B:44:0x007c->B:46:0x007f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sanitizeString(int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.json.JsonSanitizer.sanitizeString(int, int):void");
    }

    private State requireValueState(int i, State state, boolean z) throws UnbracketedComma {
        switch (AnonymousClass1.$SwitchMap$com$google$json$JsonSanitizer$State[state.ordinal()]) {
            case 1:
                return State.AFTER_VALUE;
            case 2:
            case 6:
                return State.AFTER_ELEMENT;
            case 3:
            case 5:
                if (z) {
                    return State.AFTER_KEY;
                }
                insert(i, "\"\":");
                return State.AFTER_VALUE;
            case 4:
                insert(i, ':');
                return State.AFTER_VALUE;
            case 7:
                if (this.bracketDepth == 0) {
                    throw UNBRACKETED_COMMA;
                }
                insert(i, ',');
                return State.AFTER_ELEMENT;
            case 8:
                if (z) {
                    insert(i, ',');
                    return State.AFTER_KEY;
                }
                insert(i, ",\"\":");
                return State.AFTER_VALUE;
            default:
                throw new AssertionError();
        }
    }

    private void insert(int i, char c) {
        replace(i, i, c);
    }

    private void insert(int i, String str) {
        replace(i, i, str);
    }

    private void elide(int i, int i2) {
        if (this.sanitizedJson == null) {
            this.sanitizedJson = new StringBuilder(this.jsonish.length() + 16);
        }
        this.sanitizedJson.append((CharSequence) this.jsonish, this.cleaned, i);
        this.cleaned = i2;
    }

    private void replace(int i, int i2, char c) {
        elide(i, i2);
        this.sanitizedJson.append(c);
    }

    private void replace(int i, int i2, String str) {
        elide(i, i2);
        this.sanitizedJson.append(str);
    }

    private static int endOfQuotedString(String str, int i) {
        int i2;
        char cCharAt = str.charAt(i);
        int iIndexOf = i;
        do {
            iIndexOf = str.indexOf(cCharAt, iIndexOf + 1);
            if (iIndexOf >= 0) {
                i2 = iIndexOf;
                while (i2 > i && str.charAt(i2 - 1) == '\\') {
                    i2--;
                }
            } else {
                return str.length();
            }
        } while (((iIndexOf - i2) & 1) != 0);
        return iIndexOf + 1;
    }

    private void elideTrailingComma(int i) {
        while (true) {
            int i2 = i - 1;
            if (i2 >= this.cleaned) {
                char cCharAt = this.jsonish.charAt(i2);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                    if (cCharAt == ',') {
                        elide(i2, i);
                        return;
                    } else {
                        throw new AssertionError("" + this.jsonish.charAt(i2));
                    }
                }
                i = i2;
            } else {
                int length = this.sanitizedJson.length();
                while (true) {
                    length--;
                    if (length >= 0) {
                        char cCharAt2 = this.sanitizedJson.charAt(length);
                        if (cCharAt2 != '\t' && cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ') {
                            if (cCharAt2 == ',') {
                                this.sanitizedJson.setLength(length);
                                return;
                            } else {
                                throw new AssertionError("" + this.sanitizedJson.charAt(length));
                            }
                        }
                    } else {
                        throw new AssertionError("Trailing comma not found in " + this.jsonish + " or " + ((Object) this.sanitizedJson));
                    }
                }
            }
        }
    }

    private void normalizeNumber(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        if (i < i2) {
            char cCharAt2 = this.jsonish.charAt(i);
            if (cCharAt2 == '+') {
                int i7 = i + 1;
                elide(i, i7);
                i = i7;
            } else if (cCharAt2 == '-') {
                i++;
            }
        }
        int iEndOfDigitRun = endOfDigitRun(i, i2);
        if (i == iEndOfDigitRun) {
            insert(i, '0');
        } else if ('0' == this.jsonish.charAt(i)) {
            int i8 = iEndOfDigitRun - i;
            int i9 = 16;
            int iMax = 0;
            boolean z = true;
            if (i8 == 1 && iEndOfDigitRun < i2 && 120 == (this.jsonish.charAt(iEndOfDigitRun) | ' ')) {
                int i10 = iEndOfDigitRun + 1;
                int i11 = i10;
                while (i11 < i2) {
                    char cCharAt3 = this.jsonish.charAt(i11);
                    if ('0' > cCharAt3 || cCharAt3 > '9') {
                        char c = (char) (cCharAt3 | ' ');
                        if ('a' > c || c > 'f') {
                            break;
                        } else {
                            i6 = c - 'W';
                        }
                    } else {
                        i6 = cCharAt3 - '0';
                    }
                    iMax = Math.max(i6, iMax);
                    i11++;
                }
                i4 = iMax;
                i5 = 16;
                int i12 = i11;
                i3 = i10;
                iEndOfDigitRun = i12;
            } else if (i8 > 1) {
                for (int i13 = i; i13 < iEndOfDigitRun; i13++) {
                    int iCharAt = this.jsonish.charAt(i13) - '0';
                    if (iCharAt < 0) {
                        break;
                    }
                    iMax = Math.max(iCharAt, iMax);
                }
                i4 = iMax;
                i5 = 8;
                i3 = i;
            } else {
                i3 = -1;
                z = false;
                i4 = 0;
                i5 = 10;
            }
            if (z) {
                elide(i, iEndOfDigitRun);
                String strSubstring = this.jsonish.substring(i3, iEndOfDigitRun);
                int length = strSubstring.length();
                if (i5 > i4) {
                    i9 = i5;
                } else if (i4 <= 10) {
                    i9 = 10;
                }
                if (length == 0) {
                    this.sanitizedJson.append('0');
                } else if (DIGITS_BY_BASE_THAT_FIT_IN_63B[i9] >= length) {
                    this.sanitizedJson.append(Long.parseLong(strSubstring, i9));
                } else {
                    this.sanitizedJson.append(new BigInteger(strSubstring, i9));
                }
            }
        }
        if (iEndOfDigitRun < i2 && this.jsonish.charAt(iEndOfDigitRun) == '.') {
            int i14 = iEndOfDigitRun + 1;
            int iEndOfDigitRun2 = endOfDigitRun(i14, i2);
            if (iEndOfDigitRun2 == i14) {
                insert(i14, '0');
            }
            iEndOfDigitRun = iEndOfDigitRun2;
        }
        if (iEndOfDigitRun < i2 && 101 == (this.jsonish.charAt(iEndOfDigitRun) | ' ')) {
            int i15 = iEndOfDigitRun + 1;
            if (i15 < i2 && ((cCharAt = this.jsonish.charAt(i15)) == '+' || cCharAt == '-')) {
                i15 = iEndOfDigitRun + 2;
            }
            iEndOfDigitRun = endOfDigitRun(i15, i2);
            if (iEndOfDigitRun == i15) {
                insert(i15, '0');
            }
        }
        if (iEndOfDigitRun != i2) {
            elide(iEndOfDigitRun, i2);
        }
    }

    private boolean canonicalizeNumber(int i, int i2) {
        elide(i, i);
        int length = this.sanitizedJson.length();
        normalizeNumber(i, i2);
        elide(i2, i2);
        return canonicalizeNumber(this.sanitizedJson, length, this.sanitizedJson.length());
    }

    private static boolean canonicalizeNumber(StringBuilder sb, int i, int i2) {
        int i3;
        int i4;
        char c;
        char cCharAt;
        char cCharAt2;
        int i5 = i + (sb.charAt(i) == '-' ? 1 : 0);
        int i6 = i5;
        while (i6 < i2 && '0' <= (cCharAt2 = sb.charAt(i6)) && cCharAt2 <= '9') {
            i6++;
        }
        if (i6 != i2 && '.' == sb.charAt(i6)) {
            do {
                i6++;
                if (i6 >= i2 || '0' > (cCharAt = sb.charAt(i6))) {
                    break;
                }
            } while (cCharAt <= '9');
        }
        if (i6 == i2) {
            i3 = i2;
        } else {
            i3 = i6 + 1;
            if (sb.charAt(i3) == '+') {
                i3 = i6 + 2;
            }
        }
        if (i2 == i3) {
            i4 = 0;
        } else {
            try {
                i4 = Integer.parseInt(sb.substring(i3, i2), 10);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        int i7 = i5;
        int i8 = i7;
        boolean z = false;
        int i9 = 0;
        boolean z2 = true;
        while (i7 < i6) {
            char cCharAt3 = sb.charAt(i7);
            if (cCharAt3 == '.') {
                if (z2) {
                    i9 = 0;
                }
                z = true;
            } else {
                if ((!z2 || cCharAt3 != '0') && !z) {
                    i4++;
                }
                if (cCharAt3 == '0') {
                    i9++;
                } else {
                    if (z2) {
                        if (z) {
                            i4 -= i9;
                        }
                        i9 = 0;
                    }
                    while (true) {
                        if (i9 == 0 && cCharAt3 == 0) {
                            break;
                        }
                        if (i9 == 0) {
                            c = 0;
                        } else {
                            i9--;
                            c = cCharAt3;
                            cCharAt3 = '0';
                        }
                        sb.setCharAt(i8, cCharAt3);
                        i8++;
                        cCharAt3 = c;
                    }
                    z2 = false;
                }
            }
            i7++;
        }
        sb.setLength(i8);
        int i10 = i8 - i5;
        if (z2) {
            sb.setLength(i);
            sb.append('0');
            return true;
        }
        if (i10 <= i4 && i4 <= 21) {
            while (i10 < i4) {
                sb.append('0');
                i10++;
            }
        } else if (i4 > 0 && i4 <= 21) {
            sb.insert(i5 + i4, FilenameUtils.EXTENSION_SEPARATOR);
        } else if (-6 < i4 && i4 <= 0) {
            sb.insert(i5, "0.000000".substring(0, 2 - i4));
        } else {
            if (i10 != 1) {
                sb.insert(i5 + 1, FilenameUtils.EXTENSION_SEPARATOR);
            }
            int i11 = i4 - 1;
            sb.append('e');
            sb.append(i11 >= 0 ? '+' : '-');
            sb.append(Math.abs(i11));
        }
        return true;
    }

    private boolean isKeyword(int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 5) {
            return "false".regionMatches(0, this.jsonish, i, i3);
        }
        if (i3 == 4) {
            return Constants.NULL.regionMatches(0, this.jsonish, i, i3) || "true".regionMatches(0, this.jsonish, i, i3);
        }
        return false;
    }

    private boolean isOctAt(int i) {
        return isOct(this.jsonish.charAt(i));
    }

    private boolean isHexAt(int i) {
        return isHex(this.jsonish.charAt(i));
    }

    private boolean isJsonSpecialChar(int i) {
        char cCharAt = this.jsonish.charAt(i);
        return cCharAt <= ' ' || cCharAt == '\"' || cCharAt == ',' || cCharAt == ':' || cCharAt == '[' || cCharAt == ']' || cCharAt == '{' || cCharAt == '}';
    }

    private void appendHex(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < 0) {
                return;
            }
            int i3 = (i >>> (i2 * 4)) & 15;
            this.sanitizedJson.append((char) (i3 + (i3 < 10 ? 48 : 87)));
        }
    }

    static final class UnbracketedComma extends Exception {
        private static final long serialVersionUID = 783239978717247850L;

        private UnbracketedComma() {
        }

        /* synthetic */ UnbracketedComma(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private int endOfDigitRun(int i, int i2) {
        while (i < i2) {
            char cCharAt = this.jsonish.charAt(i);
            if ('0' > cCharAt || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return i2;
    }

    static {
        UnbracketedComma unbracketedComma = new UnbracketedComma(null);
        UNBRACKETED_COMMA = unbracketedComma;
        unbracketedComma.setStackTrace(new StackTraceElement[0]);
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        DIGITS_BY_BASE_THAT_FIT_IN_63B = new int[]{-1, -1, 63, 39, 31, 27, 24, 22, 21, 19, 18, 18, 17, 17, 16, 16, 15};
    }

    CharSequence toCharSequence() {
        CharSequence charSequence = this.sanitizedJson;
        if (charSequence == null) {
            charSequence = this.jsonish;
        }
        return charSequence;
    }

    public String toString() {
        StringBuilder sb = this.sanitizedJson;
        return sb != null ? sb.toString() : this.jsonish;
    }

    private static int unescapedChar(String str, int i) {
        int length = str.length();
        int iCharAt = 0;
        if (i >= length) {
            return 0;
        }
        char cCharAt = str.charAt(i);
        if (cCharAt != '\\') {
            return cCharAt | Ascii.MIN;
        }
        int i2 = i + 1;
        if (i2 == length) {
            return 65536;
        }
        char cCharAt2 = str.charAt(i2);
        if (cCharAt2 == 'b') {
            return 131080;
        }
        if (cCharAt2 == 'f') {
            return 131084;
        }
        if (cCharAt2 == 'n') {
            return 131082;
        }
        if (cCharAt2 == 'r') {
            return 131085;
        }
        if (cCharAt2 != 'x') {
            switch (cCharAt2) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    int i3 = i + 2;
                    if (i3 < length && isOct(str.charAt(i3))) {
                        i3 = i + 3;
                        if (cCharAt2 <= '3' && i3 < length && isOct(str.charAt(i3))) {
                            i3 = i + 4;
                        }
                    }
                    while (i2 < i3) {
                        iCharAt = (str.charAt(i2) - '0') | (iCharAt << 3);
                        i2++;
                    }
                    return ((i3 - i) << 16) | iCharAt;
                default:
                    switch (cCharAt2) {
                        case 't':
                            return 131081;
                        case 'u':
                            int i4 = i + 5;
                            if (i4 < length) {
                                char cCharAt3 = str.charAt(i + 2);
                                char cCharAt4 = str.charAt(i + 3);
                                char cCharAt5 = str.charAt(i + 4);
                                char cCharAt6 = str.charAt(i4);
                                if (isHex(cCharAt3) && isHex(cCharAt4) && isHex(cCharAt5) && isHex(cCharAt6)) {
                                    return hexVal(cCharAt6) | (hexVal(cCharAt5) << 4) | (hexVal(cCharAt3) << 12) | 393216 | (hexVal(cCharAt4) << 8);
                                }
                            }
                            break;
                        case 'v':
                            return 131080;
                    }
                    break;
            }
        } else {
            int i5 = i + 3;
            if (i5 < length) {
                char cCharAt7 = str.charAt(i + 2);
                char cCharAt8 = str.charAt(i5);
                if (isHex(cCharAt7) && isHex(cCharAt8)) {
                    return hexVal(cCharAt8) | (hexVal(cCharAt7) << 4) | 262144;
                }
            }
        }
        return 0 | cCharAt2;
    }

    private static int unescapedCharRev(String str, int i) {
        int i2;
        if (i < 0) {
            return 0;
        }
        int i3 = 1;
        while (true) {
            if (i3 >= 6 || (i2 = i - i3) < 0) {
                break;
            }
            if (str.charAt(i2) == '\\') {
                int i4 = 1;
                while (true) {
                    int i5 = i2 - i4;
                    if (i5 < 0 || str.charAt(i5) != '\\') {
                        break;
                    }
                    i4++;
                }
                if ((i4 & 1) == 1) {
                    int iUnescapedChar = unescapedChar(str, i2);
                    if ((iUnescapedChar >>> 16) - 1 == i3) {
                        return iUnescapedChar;
                    }
                }
            } else {
                i3++;
            }
        }
        return str.charAt(i) | Ascii.MIN;
    }

    private static int runSlashPreceding(String str, int i) {
        int i2 = i;
        while (i2 >= 0 && str.charAt(i2) == '\\') {
            i2--;
        }
        return i - i2;
    }
}
