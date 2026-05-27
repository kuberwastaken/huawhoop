package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import defpackage.acm;
import defpackage.acr;
import defpackage.act;
import java.io.Serializable;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes9.dex */
public class PropertyNamingStrategy implements Serializable {

    @Deprecated
    public static final PropertyNamingStrategy CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES;

    @Deprecated
    public static final PropertyNamingStrategy KEBAB_CASE;

    @Deprecated
    public static final PropertyNamingStrategy LOWER_CAMEL_CASE = new PropertyNamingStrategy();

    @Deprecated
    public static final PropertyNamingStrategy LOWER_CASE;

    @Deprecated
    public static final PropertyNamingStrategy LOWER_DOT_CASE;

    @Deprecated
    public static final PropertyNamingStrategy PASCAL_CASE_TO_CAMEL_CASE;

    @Deprecated
    public static final PropertyNamingStrategy SNAKE_CASE;

    @Deprecated
    public static final PropertyNamingStrategy UPPER_CAMEL_CASE;
    private static final long serialVersionUID = 2;

    public String nameForConstructorParameter(MapperConfig<?> mapperConfig, acr acrVar, String str) {
        return str;
    }

    public String nameForField(MapperConfig<?> mapperConfig, acm acmVar, String str) {
        return str;
    }

    public String nameForGetterMethod(MapperConfig<?> mapperConfig, act actVar, String str) {
        return str;
    }

    public String nameForSetterMethod(MapperConfig<?> mapperConfig, act actVar, String str) {
        return str;
    }

    static {
        c cVar = new c();
        UPPER_CAMEL_CASE = cVar;
        e eVar = new e();
        SNAKE_CASE = eVar;
        LOWER_CASE = new d();
        KEBAB_CASE = new a();
        LOWER_DOT_CASE = new b();
        CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES = eVar;
        PASCAL_CASE_TO_CAMEL_CASE = cVar;
    }

    @Deprecated
    public static abstract class PropertyNamingStrategyBase extends PropertyNamingStrategy {
        public abstract String translate(String str);

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForField(MapperConfig<?> mapperConfig, acm acmVar, String str) {
            return translate(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForGetterMethod(MapperConfig<?> mapperConfig, act actVar, String str) {
            return translate(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForSetterMethod(MapperConfig<?> mapperConfig, act actVar, String str) {
            return translate(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForConstructorParameter(MapperConfig<?> mapperConfig, acr acrVar, String str) {
            return translate(str);
        }

        protected static String translateLowerCaseWithSeparator(String str, char c) {
            int length;
            if (str == null || (length = str.length()) == 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder((length >> 1) + length);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                char lowerCase = Character.toLowerCase(cCharAt);
                if (lowerCase == cCharAt) {
                    if (i > 1) {
                        sb.insert(sb.length() - 1, c);
                    }
                    i = 0;
                } else {
                    if (i == 0 && i2 > 0) {
                        sb.append(c);
                    }
                    i++;
                }
                sb.append(lowerCase);
            }
            return sb.toString();
        }
    }

    @Deprecated
    public static class e extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder(length * 2);
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (i2 > 0 || cCharAt != '_') {
                    if (Character.isUpperCase(cCharAt)) {
                        if (!z && i > 0 && sb.charAt(i - 1) != '_') {
                            sb.append('_');
                            i++;
                        }
                        cCharAt = Character.toLowerCase(cCharAt);
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(cCharAt);
                    i++;
                }
            }
            return i > 0 ? sb.toString() : str;
        }
    }

    @Deprecated
    public static class c extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            char cCharAt;
            char upperCase;
            if (str == null || str.isEmpty() || cCharAt == (upperCase = Character.toUpperCase((cCharAt = str.charAt(0))))) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(0, upperCase);
            return sb.toString();
        }
    }

    @Deprecated
    public static class d extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            return str.toLowerCase();
        }
    }

    @Deprecated
    public static class a extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            return translateLowerCaseWithSeparator(str, '-');
        }
    }

    @Deprecated
    public static class b extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            return translateLowerCaseWithSeparator(str, FilenameUtils.EXTENSION_SEPARATOR);
        }
    }
}
