package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class wth {
    public static String[] e() {
        return new String[]{"app_Id", "expire_time", "failure_expire_time", "vender_code", "cert_finger_print", "cert_finger_print_extra", "time_stamp"};
    }

    public static String d() {
        return "create table  IF NOT EXISTS tb_wear_engine_scope_response(app_Id TEXT PRIMARY KEY NOT NULL,expire_time INTEGER,failure_expire_time INTEGER,vender_code TEXT,cert_finger_print TEXT,cert_finger_print_extra TEXT,time_stamp INTEGER)";
    }
}
