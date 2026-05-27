package defpackage;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes9.dex */
public class ry extends Migration {
    public ry() {
        super(5, 6);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE `analytics_event` ADD COLUMN `start_time` INTEGER DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE `analytics_event` ADD COLUMN `endpoint` TEXT DEFAULT NULL");
        supportSQLiteDatabase.execSQL("ALTER TABLE `analytics_event` ADD COLUMN `end_time` INTEGER DEFAULT -1");
    }
}
