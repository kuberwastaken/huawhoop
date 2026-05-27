package defpackage;

import android.content.ContentValues;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealthservice.db.table.DBPointCommon;
import health.compact.a.HiDateUtil;

/* JADX INFO: loaded from: classes5.dex */
public class jtj extends DBPointCommon {
    private jtj() {
    }

    protected jtj(String str) {
        super(str);
    }

    public static jtj e() {
        return a.f14446a;
    }

    /* JADX INFO: loaded from: classes9.dex */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final jtj f14446a = new jtj();
    }

    public static String c() {
        return getPointCommonIndexSQL("HealthPointIndex", "sample_point_health");
    }

    public static String h() {
        return getStartTimeIndexSQL("PointHealthStartTimeIndex", "sample_point_health");
    }

    public static String d() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(" CREATE INDEX  IF NOT EXISTS PointHealthSyncStatusIndex ON sample_point_health(sync_status)");
        return sb.toString();
    }

    public static String a() {
        return getPointCreateTableSQL("sample_point_health");
    }

    public static ContentValues bDP_(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues(11);
        contentValues.put("start_time", Long.valueOf(hiHealthData.getStartTime()));
        contentValues.put("end_time", Long.valueOf(hiHealthData.getEndTime()));
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("value", Double.valueOf(hiHealthData.getValue()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put(DBPointCommon.COLUMN_UNIT_ID, Integer.valueOf(hiHealthData.getPointUnit()));
        contentValues.put("client_id", Integer.valueOf(i));
        contentValues.put("merged", Integer.valueOf(i2));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("timeZone", HiDateUtil.a(hiHealthData.getTimeZone()));
        contentValues.put("modified_time", Long.valueOf(hiHealthData.getModifiedTime()));
        return contentValues;
    }

    public static ContentValues bDQ_(HiHealthData hiHealthData, int i) {
        ContentValues contentValues = new ContentValues(6);
        contentValues.put("value", Double.valueOf(hiHealthData.getValue()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put(DBPointCommon.COLUMN_UNIT_ID, Integer.valueOf(hiHealthData.getPointUnit()));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(hiHealthData.getModifiedTime()));
        return contentValues;
    }

    public static ContentValues bDR_(int i, int i2) {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("sync_status", Integer.valueOf(i2));
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    @Override // com.huawei.hihealthservice.db.table.DBCommon
    public String getTableName() {
        return "sample_point_health";
    }

    public static String b() {
        return " DROP INDEX IF EXISTS HealthPointIndex";
    }
}
