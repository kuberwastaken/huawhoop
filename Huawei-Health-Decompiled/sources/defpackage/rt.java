package defpackage;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes9.dex */
public class rt extends Migration {
    public rt() {
        super(2, 3);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE `analytics_event` ADD COLUMN `link_type` TEXT DEFAULT NULL");
    }
}
