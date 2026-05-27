package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {
    public static final String DEFAULT_LOCALE = "##default";
    public static final String DEFAULT_TIMEZONE = "##default";

    /* JADX INFO: loaded from: classes9.dex */
    public enum Feature {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        ACCEPT_CASE_INSENSITIVE_PROPERTIES,
        ACCEPT_CASE_INSENSITIVE_VALUES,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES,
        ADJUST_DATES_TO_CONTEXT_TIME_ZONE
    }

    OptBoolean lenient() default OptBoolean.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    Shape shape() default Shape.ANY;

    String timezone() default "##default";

    Feature[] with() default {};

    Feature[] without() default {};

    /* JADX INFO: loaded from: classes9.dex */
    public enum Shape {
        ANY,
        NATURAL,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN,
        BINARY;

        public boolean isNumeric() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }

        public boolean isStructured() {
            return this == OBJECT || this == ARRAY;
        }
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class e {
        private static final e b = new e(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1652a;
        private final int e;

        private e(int i, int i2) {
            this.f1652a = i;
            this.e = i2;
        }

        public static e d() {
            return b;
        }

        public static e a(JsonFormat jsonFormat) {
            return c(jsonFormat.with(), jsonFormat.without());
        }

        public static e c(Feature[] featureArr, Feature[] featureArr2) {
            int iOrdinal = 0;
            for (Feature feature : featureArr) {
                iOrdinal |= 1 << feature.ordinal();
            }
            int iOrdinal2 = 0;
            for (Feature feature2 : featureArr2) {
                iOrdinal2 |= 1 << feature2.ordinal();
            }
            return new e(iOrdinal, iOrdinal2);
        }

        public e c(e eVar) {
            if (eVar == null) {
                return this;
            }
            int i = eVar.e;
            int i2 = eVar.f1652a;
            if (i == 0 && i2 == 0) {
                return this;
            }
            int i3 = this.f1652a;
            if (i3 == 0 && this.e == 0) {
                return eVar;
            }
            int i4 = ((~i) & i3) | i2;
            int i5 = this.e;
            int i6 = i | ((~i2) & i5);
            return (i4 == i3 && i6 == i5) ? this : new e(i4, i6);
        }

        public Boolean a(Feature feature) {
            int iOrdinal = 1 << feature.ordinal();
            if ((this.e & iOrdinal) != 0) {
                return Boolean.FALSE;
            }
            if ((iOrdinal & this.f1652a) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public String toString() {
            return this == b ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.f1652a), Integer.valueOf(this.e));
        }

        public int hashCode() {
            return this.e + this.f1652a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return eVar.f1652a == this.f1652a && eVar.e == this.e;
        }
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class b implements JacksonAnnotationValue<JsonFormat>, Serializable {
        private static final b e = new b();
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f1651a;
        private final String b;
        private final Boolean c;
        private final Locale d;
        private final String g;
        private final Shape i;
        private transient TimeZone j;

        public b() {
            this("", Shape.ANY, "", "", e.d(), null);
        }

        public b(JsonFormat jsonFormat) {
            this(jsonFormat.pattern(), jsonFormat.shape(), jsonFormat.locale(), jsonFormat.timezone(), e.a(jsonFormat), jsonFormat.lenient().asBoolean());
        }

        public b(String str, Shape shape, String str2, String str3, e eVar, Boolean bool) {
            this(str, shape, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, eVar, bool);
        }

        public b(String str, Shape shape, Locale locale, String str2, TimeZone timeZone, e eVar, Boolean bool) {
            this.b = str == null ? "" : str;
            this.i = shape == null ? Shape.ANY : shape;
            this.d = locale;
            this.j = timeZone;
            this.g = str2;
            this.f1651a = eVar == null ? e.d() : eVar;
            this.c = bool;
        }

        public static final b d() {
            return e;
        }

        public static b d(b bVar, b bVar2) {
            return bVar == null ? bVar2 : bVar.b(bVar2);
        }

        public static final b b(JsonFormat jsonFormat) {
            return jsonFormat == null ? e : new b(jsonFormat);
        }

        public final b b(b bVar) {
            b bVar2;
            e eVarC;
            String str;
            TimeZone timeZone;
            if (bVar == null || bVar == (bVar2 = e) || bVar == this) {
                return this;
            }
            if (this == bVar2) {
                return bVar;
            }
            String str2 = bVar.b;
            if (str2 == null || str2.isEmpty()) {
                str2 = this.b;
            }
            String str3 = str2;
            Shape shape = bVar.i;
            if (shape == Shape.ANY) {
                shape = this.i;
            }
            Shape shape2 = shape;
            Locale locale = bVar.d;
            if (locale == null) {
                locale = this.d;
            }
            Locale locale2 = locale;
            e eVar = this.f1651a;
            if (eVar == null) {
                eVarC = bVar.f1651a;
            } else {
                eVarC = eVar.c(bVar.f1651a);
            }
            e eVar2 = eVarC;
            Boolean bool = bVar.c;
            if (bool == null) {
                bool = this.c;
            }
            Boolean bool2 = bool;
            String str4 = bVar.g;
            if (str4 == null || str4.isEmpty()) {
                str = this.g;
                timeZone = this.j;
            } else {
                timeZone = bVar.j;
                str = str4;
            }
            return new b(str3, shape2, locale2, str, timeZone, eVar2, bool2);
        }

        public static b e(boolean z) {
            return new b("", null, null, null, null, e.d(), Boolean.valueOf(z));
        }

        public b b(Boolean bool) {
            return bool == this.c ? this : new b(this.b, this.i, this.d, this.g, this.j, this.f1651a, bool);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonFormat> valueFor() {
            return JsonFormat.class;
        }

        public String c() {
            return this.b;
        }

        public Shape b() {
            return this.i;
        }

        public Locale e() {
            return this.d;
        }

        public Boolean a() {
            return this.c;
        }

        public TimeZone h() {
            TimeZone timeZone = this.j;
            if (timeZone != null) {
                return timeZone;
            }
            String str = this.g;
            if (str == null) {
                return null;
            }
            TimeZone timeZone2 = TimeZone.getTimeZone(str);
            this.j = timeZone2;
            return timeZone2;
        }

        public boolean f() {
            return this.i != Shape.ANY;
        }

        public boolean g() {
            String str = this.b;
            return str != null && str.length() > 0;
        }

        public boolean i() {
            return this.d != null;
        }

        public boolean m() {
            String str;
            return (this.j == null && ((str = this.g) == null || str.isEmpty())) ? false : true;
        }

        public boolean j() {
            return this.c != null;
        }

        public Boolean e(Feature feature) {
            return this.f1651a.a(feature);
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", this.b, this.i, this.c, this.d, this.g, this.f1651a);
        }

        public int hashCode() {
            String str = this.g;
            int iHashCode = str == null ? 1 : str.hashCode();
            String str2 = this.b;
            if (str2 != null) {
                iHashCode ^= str2.hashCode();
            }
            int iHashCode2 = iHashCode + this.i.hashCode();
            Boolean bool = this.c;
            if (bool != null) {
                iHashCode2 ^= bool.hashCode();
            }
            Locale locale = this.d;
            if (locale != null) {
                iHashCode2 += locale.hashCode();
            }
            return iHashCode2 ^ this.f1651a.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.i == bVar.i && this.f1651a.equals(bVar.f1651a)) {
                return b(this.c, bVar.c) && b(this.g, bVar.g) && b(this.b, bVar.b) && b(this.j, bVar.j) && b(this.d, bVar.d);
            }
            return false;
        }

        private static <T> boolean b(T t, T t2) {
            if (t == null) {
                return t2 == null;
            }
            if (t2 == null) {
                return false;
            }
            return t.equals(t2);
        }
    }
}
