package defpackage;

import com.huawei.hihealthservice.db.table.DBSessionCommon;

/* JADX INFO: loaded from: classes5.dex */
public class jto extends DBSessionCommon {
    private jto() {
    }

    /* JADX INFO: loaded from: classes9.dex */
    static class d {
        private static final jto b = new jto();
    }

    public static jto a() {
        return d.b;
    }

    public static String b() {
        return getSessionCreateTableSQL("sample_session_core");
    }

    public static String e() {
        return getSessionCommonIndexSQL("CoreSessionIndex", "sample_session_core");
    }

    @Override // com.huawei.hihealthservice.db.table.DBCommon
    public String getTableName() {
        return "sample_session_core";
    }
}
