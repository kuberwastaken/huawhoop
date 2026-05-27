package defpackage;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.c.a.b.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class auk extends e<auh> {
    public ArrayList<auh> c(String str) {
        return b("select scene as c, startTime as s, endTime as e, times, errCode as err from pre_records where syncType = ? order by endTime desc limit 20", new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.android.hicloud.sync.c.a.b.e
    /* JADX INFO: renamed from: ga_, reason: merged with bridge method [inline-methods] */
    public auh a(Cursor cursor) {
        auh auhVar = new auh();
        auhVar.b(cursor.getInt(0));
        auhVar.c(cursor.getLong(1));
        auhVar.a(cursor.getLong(2));
        auhVar.a(cursor.getInt(3));
        auhVar.a(cursor.getString(4));
        return auhVar;
    }
}
