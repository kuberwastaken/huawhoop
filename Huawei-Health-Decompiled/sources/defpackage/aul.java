package defpackage;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.c.a.b.e;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class aul extends e<SyncData> {
    public ArrayList<SyncData> b(String str) {
        avi.a("EtagOperator", "query4VoNormal");
        return b("SELECT luid,etag,uuid,guid,hash,recycle_status FROM  etag where type = ? and recycle_status != -1", new String[]{str});
    }

    public ArrayList<SyncData> c(List<String> list, String str) {
        ArrayList<SyncData> arrayList = new ArrayList<>();
        avi.a("EtagOperator", "query4Luid begin");
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.addAll(b("SELECT luid,etag,uuid,guid,hash,recycle_status FROM  etag where guid = ? and type = ?", new String[]{list.get(i), str}));
            }
        }
        return arrayList;
    }

    public void d(List<SyncData> list, String str) throws Exception {
        avi.a("EtagOperator", "batchReplace begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        avi.a("EtagOperator", "batchReplace , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<SyncData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(e(it.next(), str));
        }
        a("REPLACE INTO etag(luid,type,etag,uuid,guid,hash,recycle_status) VALUES(?,?,?,?,?,?,?)", arrayList);
    }

    private String[] e(SyncData syncData, String str) {
        String[] strArr = new String[7];
        strArr[0] = syncData.getLuid();
        strArr[1] = str;
        strArr[2] = syncData.getEtag();
        if (syncData.getUuid() == null) {
            strArr[3] = "";
        } else {
            strArr[3] = syncData.getUuid();
        }
        strArr[4] = syncData.getGuid();
        if (syncData.getHash() == null) {
            strArr[5] = "";
        } else {
            strArr[5] = syncData.getHash();
        }
        strArr[6] = "" + syncData.getRecycleStatus();
        return strArr;
    }

    public ArrayList<SyncData> a(List<String> list, String str) {
        ArrayList<SyncData> arrayList = new ArrayList<>();
        avi.a("EtagOperator", "query4Guid begin");
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.addAll(b("SELECT luid,etag,uuid,guid,hash,recycle_status FROM  etag where luid = ? and type = ? ", new String[]{list.get(i), str}));
            }
        }
        return arrayList;
    }

    public ArrayList<SyncData> d(String str) {
        avi.a("EtagOperator", "query4Vo");
        return b("SELECT luid,etag,uuid,guid,hash,recycle_status FROM  etag where type = ?", new String[]{str});
    }

    public void d() throws Exception {
        avi.a("EtagOperator", "deleteAll ");
        a("DELETE FROM etag ", (String[]) null);
    }

    public void e(List<String> list, String str) throws auq {
        avi.a("EtagOperator", "batchDelete batDeleteList begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        avi.a("EtagOperator", "batchDelete batDeleteList , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new String[]{it.next(), str});
        }
        a("DELETE FROM etag WHERE luid = ? and type = ?", arrayList);
    }

    public int e(Map<String, String> map, String str) {
        avi.b("EtagOperator", "batUpdate4Luid begin type = " + str);
        ArrayList<String[]> arrayList = new ArrayList<>();
        if (map == null || map.isEmpty()) {
            return -2;
        }
        avi.b("EtagOperator", "luidMapSize = " + map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            avi.b("EtagOperator", "[ luidMap.oldluid = " + entry.getKey() + " luidMap.newluid = " + entry.getValue() + " ]");
            arrayList.add(new String[]{entry.getValue(), entry.getKey(), str});
        }
        avi.b("EtagOperator", "argsListSize = " + arrayList.size());
        return a("update etag set luid = ? where luid = ? and type = ?", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.android.hicloud.sync.c.a.b.e
    /* JADX INFO: renamed from: fX_, reason: merged with bridge method [inline-methods] */
    public SyncData a(Cursor cursor) {
        SyncData syncData = new SyncData();
        syncData.setLuid(cursor.getString(0));
        syncData.setEtag(cursor.getString(1));
        syncData.setUuid(cursor.getString(2));
        syncData.setGuid(cursor.getString(3));
        syncData.setHash(cursor.getString(4));
        syncData.setRecycleStatus(cursor.getInt(5));
        return syncData;
    }
}
