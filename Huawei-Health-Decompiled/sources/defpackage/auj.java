package defpackage;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.c.a.b.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class auj extends e<aud> {
    public String c(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorC = c("select distinct prepareTraceId from pre_records where syncType = ?", new String[]{str});
            if (cursorC != null) {
                try {
                    if (cursorC.moveToFirst()) {
                        do {
                            arrayList.add(cursorC.getString(0));
                        } while (cursorC.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorC != null) {
                cursorC.close();
            }
        } catch (Exception e) {
            avi.c("PreRecordOperator", "queryPrepareTraceId error: " + e.toString());
        }
        return !arrayList.isEmpty() ? (String) arrayList.get(0) : "";
    }

    public int e(String str) {
        try {
            Cursor cursorC = c("select sum(times) as num from pre_records where syncType = ?", new String[]{str});
            if (cursorC != null && cursorC.moveToFirst()) {
                return cursorC.getInt(0);
            }
        } catch (Exception e) {
            avi.c("PreRecordOperator", "countRecords error " + e.getMessage());
        }
        return 0;
    }

    public void d(String str) {
        avi.b("PreRecordOperator", "clearByType, syncType = " + str);
        try {
            a("DELETE FROM pre_records where syncType = ?", new String[]{str});
        } catch (Exception e) {
            avi.c("PreRecordOperator", "clearByType error " + e.getMessage());
        }
    }

    public long a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorC = c("select endTime from pre_records where syncType = ? order by endTime desc", new String[]{str});
            if (cursorC != null && cursorC.moveToFirst()) {
                arrayList.add(Long.valueOf(cursorC.getLong(0)));
            }
        } catch (Exception e) {
            avi.c("PreRecordOperator", "getLatestEndTime error " + e.getMessage());
        }
        if (arrayList.isEmpty()) {
            return 0L;
        }
        return ((Long) arrayList.get(0)).longValue();
    }

    public void a() {
        avi.b("PreRecordOperator", "clearAll");
        try {
            a("DELETE FROM pre_records", (String[]) null);
        } catch (Exception e) {
            avi.c("PreRecordOperator", "clearAll error " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.android.hicloud.sync.c.a.b.e
    /* JADX INFO: renamed from: fZ_, reason: merged with bridge method [inline-methods] */
    public aud a(Cursor cursor) {
        aud audVar = new aud();
        audVar.d(cursor.getString(0));
        audVar.b(cursor.getString(1));
        audVar.e(cursor.getInt(2));
        audVar.a(cursor.getLong(3));
        audVar.e(cursor.getLong(4));
        audVar.c(cursor.getString(5));
        audVar.c(cursor.getInt(6));
        return audVar;
    }
}
