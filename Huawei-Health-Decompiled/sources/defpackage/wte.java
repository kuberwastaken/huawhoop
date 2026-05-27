package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class wte {
    public static String[] b() {
        return new String[]{"id", "app_Id", "scope_Id", "name", "uri", "permissions"};
    }

    public static String a() {
        return "create table  IF NOT EXISTS tb_wear_engine_scope_info(id INTEGER PRIMARY KEY AUTOINCREMENT,app_Id TEXT,scope_Id INTEGER,name TEXT,uri TEXT,permissions TEXT)";
    }
}
