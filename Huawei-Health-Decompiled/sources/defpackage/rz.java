package defpackage;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes9.dex */
public class rz extends Migration {
    public rz() {
        super(3, 4);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE `analytics_event` ADD COLUMN `venmo_installed` INTEGER NOT NULL DEFAULT 0");
    }
}
