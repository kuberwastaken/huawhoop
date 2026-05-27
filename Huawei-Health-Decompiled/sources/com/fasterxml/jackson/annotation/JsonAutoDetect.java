package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAutoDetect {
    Visibility creatorVisibility() default Visibility.DEFAULT;

    Visibility fieldVisibility() default Visibility.DEFAULT;

    Visibility getterVisibility() default Visibility.DEFAULT;

    Visibility isGetterVisibility() default Visibility.DEFAULT;

    Visibility setterVisibility() default Visibility.DEFAULT;

    /* JADX INFO: loaded from: classes9.dex */
    public enum Visibility {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public boolean isVisible(Member member) {
            int i = AnonymousClass2.c[ordinal()];
            if (i == 1) {
                return true;
            }
            if (i == 3) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (i != 4) {
                if (i != 5) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class b implements JacksonAnnotationValue<JsonAutoDetect>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected static final b f1650a;
        protected static final b e;
        private static final Visibility h;
        private static final long serialVersionUID = 1;
        protected final Visibility b;
        protected final Visibility c;
        protected final Visibility d;
        protected final Visibility i;
        protected final Visibility j;

        static {
            Visibility visibility = Visibility.PUBLIC_ONLY;
            h = visibility;
            f1650a = new b(visibility, Visibility.PUBLIC_ONLY, Visibility.PUBLIC_ONLY, Visibility.ANY, Visibility.PUBLIC_ONLY);
            e = new b(Visibility.DEFAULT, Visibility.DEFAULT, Visibility.DEFAULT, Visibility.DEFAULT, Visibility.DEFAULT);
        }

        private b(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5) {
            this.d = visibility;
            this.b = visibility2;
            this.j = visibility3;
            this.i = visibility4;
            this.c = visibility5;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonAutoDetect> valueFor() {
            return JsonAutoDetect.class;
        }

        public Visibility e() {
            return this.d;
        }

        public Visibility b() {
            return this.b;
        }

        public Visibility c() {
            return this.j;
        }

        public Visibility d() {
            return this.i;
        }

        public Visibility a() {
            return this.c;
        }

        protected Object readResolve() {
            b bVarE = e(this.d, this.b, this.j, this.i, this.c);
            return bVarE == null ? this : bVarE;
        }

        public String toString() {
            return String.format("JsonAutoDetect.Value(fields=%s,getters=%s,isGetters=%s,setters=%s,creators=%s)", this.d, this.b, this.j, this.i, this.c);
        }

        public int hashCode() {
            return ((this.d.ordinal() + 1) ^ (((this.b.ordinal() * 3) - (this.j.ordinal() * 7)) + (this.i.ordinal() * 11))) ^ (this.c.ordinal() * 13);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            return obj.getClass() == getClass() && b(this, (b) obj);
        }

        private static b e(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5) {
            if (visibility == h) {
                b bVar = f1650a;
                if (visibility2 == bVar.b && visibility3 == bVar.j && visibility4 == bVar.i && visibility5 == bVar.c) {
                    return bVar;
                }
                return null;
            }
            if (visibility == Visibility.DEFAULT && visibility2 == Visibility.DEFAULT && visibility3 == Visibility.DEFAULT && visibility4 == Visibility.DEFAULT && visibility5 == Visibility.DEFAULT) {
                return e;
            }
            return null;
        }

        private static boolean b(b bVar, b bVar2) {
            return bVar.d == bVar2.d && bVar.b == bVar2.b && bVar.j == bVar2.j && bVar.i == bVar2.i && bVar.c == bVar2.c;
        }
    }

    /* JADX INFO: renamed from: com.fasterxml.jackson.annotation.JsonAutoDetect$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[PropertyAccessor.values().length];
            b = iArr;
            try {
                iArr[PropertyAccessor.CREATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PropertyAccessor.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[PropertyAccessor.GETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[PropertyAccessor.IS_GETTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[PropertyAccessor.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[PropertyAccessor.SETTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[PropertyAccessor.ALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[Visibility.values().length];
            c = iArr2;
            try {
                iArr2[Visibility.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[Visibility.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[Visibility.NON_PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[Visibility.PROTECTED_AND_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                c[Visibility.PUBLIC_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }
}
