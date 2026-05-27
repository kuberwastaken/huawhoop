package com.huawei.health.plan.model.util;

import health.compact.a.utils.StringUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SqlUtil {

    public static class b {
        private boolean b;
        private String c;
        private LinkedHashMap<String, SqliteColumnType> d = new LinkedHashMap<>();

        public b d(String str) {
            this.c = str;
            return this;
        }

        public b d() {
            this.b = true;
            return this;
        }

        public b c(String str, SqliteColumnType sqliteColumnType) {
            if (StringUtils.i(str) && sqliteColumnType != null) {
                this.d.put(str, sqliteColumnType);
            }
            return this;
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            String str = this.c;
            if (str != null) {
                if (this.b) {
                    sb.append(str);
                    sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT");
                } else {
                    sb.append(str);
                    sb.append(" INTEGER AUTOINCREMENT");
                }
            }
            if (!this.d.isEmpty()) {
                for (Map.Entry<String, SqliteColumnType> entry : this.d.entrySet()) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(entry.getKey());
                    sb.append(" ");
                    sb.append(entry.getValue().getValue());
                }
            }
            return sb.toString();
        }
    }

    public enum SqliteColumnType {
        INTEGER("INTEGER"),
        TEXT("TEXT"),
        BLOB("BLOB"),
        REAL("REAL");

        private String mValue;

        SqliteColumnType(String str) {
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public enum SqliteOrderType {
        ASC("ASC"),
        DESC("DESC");

        private String mValue;

        SqliteOrderType(String str) {
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }

        public String by(String... strArr) {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                if (!StringUtils.f(str)) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    } else {
                        sb.append(" order by");
                        sb.append(" ");
                    }
                    sb.append(str);
                    sb.append(" ");
                    sb.append(name());
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public enum SqliteOperateType {
        SELECT("select");

        private String mValue;

        SqliteOperateType(String str) {
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public enum ConditionLinkerType {
        AND(" and "),
        OR(" or ");

        private String mValue;

        ConditionLinkerType(String str) {
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }
    }
}
