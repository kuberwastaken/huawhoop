package defpackage;

import android.icu.text.AlphabeticIndex;
import android.text.TextUtils;
import android.util.Log;
import java.lang.Character;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class vmu {
    private static vmu j;
    private final a i;
    private final Locale l;
    private String o;
    public static final Locale b = new Locale("ar");
    public static final Locale c = new Locale("fa");
    public static final Locale e = new Locale("el");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Locale f18662a = new Locale("he");
    public static final Locale h = new Locale("th");
    public static final Locale g = new Locale("uk");
    public static final Locale d = new Locale("hi");
    private static final String f = Locale.JAPANESE.getLanguage();

    static class e extends a {
        e(Locale locale) {
            super(locale);
        }
    }

    private vmu(Locale locale) {
        if (locale == null) {
            this.l = Locale.getDefault();
        } else {
            this.l = locale;
        }
        String language = this.l.getLanguage();
        this.o = language;
        if (language.equals(f)) {
            this.i = new c(this.l);
        } else if (this.l.equals(Locale.CHINA)) {
            this.i = new e(this.l);
        } else {
            this.i = new a(this.l);
        }
    }

    public static vmu d() {
        vmu vmuVar;
        synchronized (vmu.class) {
            vmu vmuVar2 = j;
            if (vmuVar2 == null || !vmuVar2.d(Locale.getDefault())) {
                j = new vmu(null);
            }
            vmuVar = j;
        }
        return vmuVar;
    }

    public String a(String str) {
        return this.i.a(str);
    }

    public String b(int i) {
        return this.i.a(i);
    }

    public String d(String str) {
        char cCharAt;
        char cCharAt2;
        if (!TextUtils.isEmpty(str)) {
            if ("TW".equals(this.l.getCountry()) && (cCharAt2 = a(str).charAt(0)) >= 12549 && cCharAt2 <= 12585) {
                return String.valueOf(cCharAt2);
            }
            if ("ar".equals(this.l.getLanguage()) && (cCharAt = a(str).charAt(0)) < 1574 && cCharAt > 1569) {
                return "آ";
            }
        }
        return b(e(a(str)));
    }

    public boolean d(Locale locale) {
        return this.l.equals(locale);
    }

    public int e(String str) {
        return this.i.e(str);
    }

    static class c extends a {
        private static final Set<Character.UnicodeBlock> b;
        private final int c;

        static {
            HashSet hashSet = new HashSet();
            hashSet.add(Character.UnicodeBlock.HIRAGANA);
            hashSet.add(Character.UnicodeBlock.KATAKANA);
            hashSet.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
            hashSet.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
            hashSet.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
            hashSet.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
            b = Collections.unmodifiableSet(hashSet);
        }

        c(Locale locale) {
            super(locale);
            this.c = super.e("日");
        }

        private static boolean c(int i) {
            return b.contains(Character.UnicodeBlock.of(i));
        }

        @Override // vmu.a
        public int e(String str) {
            int iE = super.e(str);
            return ((iE != this.c || c(Character.codePointAt(str, 0))) && iE <= this.c) ? iE : iE + 1;
        }

        @Override // vmu.a
        public int e() {
            return super.e() + 1;
        }

        @Override // vmu.a
        public String a(int i) {
            int i2 = this.c;
            if (i == i2) {
                return "他";
            }
            if (i > i2) {
                i--;
            }
            return super.a(i);
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Locale f18663a;
        private int b;
        private int c;
        protected AlphabeticIndex.ImmutableIndex d;

        a(Locale locale) {
            this.d = null;
            this.c = 0;
            this.b = 0;
            this.f18663a = locale;
            AlphabeticIndex.ImmutableIndex immutableIndexBuildImmutableIndex = new AlphabeticIndex(locale).setMaxLabelCount(300).addLabels(Locale.ENGLISH).addLabels(Locale.JAPANESE).addLabels(Locale.KOREAN).addLabels(vmu.h).addLabels("fa".equals(locale.getLanguage()) ? vmu.c : vmu.b).addLabels(vmu.f18662a).addLabels(vmu.e).addLabels(vmu.g).addLabels(vmu.d).buildImmutableIndex();
            this.d = immutableIndexBuildImmutableIndex;
            int bucketCount = immutableIndexBuildImmutableIndex.getBucketCount();
            this.b = bucketCount;
            this.c = bucketCount - 1;
        }

        private boolean c(int i) {
            return (!Character.isSpaceChar(i) && i != 43) && (i != 40) && (i != 35) && ((i != 41 && i != 46) & (i != 45));
        }

        public String a(String str) {
            return str;
        }

        public int e(String str) {
            int i;
            if (str == null) {
                Log.w("HwSectionLocaleUtils", "getBucketIndex: displayName is null!");
                return -1;
            }
            int length = str.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = Character.codePointAt(str, iCharCount);
                if (Character.isDigit(iCodePointAt) || c(iCodePointAt)) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            int bucketIndex = this.d.getBucketIndex(str);
            if (bucketIndex < 0) {
                return -1;
            }
            if (bucketIndex >= this.c) {
                return bucketIndex + 1;
            }
            if (!"TW".equals(this.f18663a.getCountry()) || length <= iCharCount) {
                return bucketIndex;
            }
            int iCodePointAt2 = Character.codePointAt(str, iCharCount);
            if (iCodePointAt2 < 12549 || iCodePointAt2 > 12573) {
                if (iCodePointAt2 >= 12573 && iCodePointAt2 <= 12585) {
                    i = iCodePointAt2 - 12550;
                }
                return bucketIndex;
            }
            i = iCodePointAt2 - 12549;
            return i + 1;
        }

        public int e() {
            return this.b + 1;
        }

        public String a(int i) {
            if (i >= 0 && i < e()) {
                if (i == 0) {
                    return "#";
                }
                if (i > this.c) {
                    i--;
                }
                if (this.d.getBucket(i) != null) {
                    return this.d.getBucket(i).getLabel();
                }
            }
            return "";
        }
    }
}
