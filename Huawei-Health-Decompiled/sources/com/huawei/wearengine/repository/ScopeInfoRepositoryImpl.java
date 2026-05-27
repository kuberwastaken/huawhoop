package com.huawei.wearengine.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.wearengine.repository.api.ScopeInfoRepository;
import com.huawei.wearengine.scope.ScopeInfo;
import defpackage.wte;
import defpackage.wti;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ScopeInfoRepositoryImpl implements ScopeInfoRepository {
    private wti e;

    public ScopeInfoRepositoryImpl(Context context) {
        this.e = new wti(context, "tb_wear_engine_scope_info", wte.b());
    }

    @Override // com.huawei.wearengine.repository.api.ScopeInfoRepository
    public boolean insertScope(ScopeInfo scopeInfo, String str) {
        return this.e.fDe_(fCY_(scopeInfo, str)) > 0;
    }

    @Override // com.huawei.wearengine.repository.api.ScopeInfoRepository
    public boolean deleteScope(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.e.a("app_Id =? ", new String[]{str}) > 0;
    }

    @Override // com.huawei.wearengine.repository.api.ScopeInfoRepository
    public List<ScopeInfo> getScopes(String str) {
        return fDa_(this.e.fDf_("app_Id =? ", new String[]{str}, null, null, null));
    }

    @Override // com.huawei.wearengine.repository.api.ScopeInfoRepository
    public boolean updateScope(ScopeInfo scopeInfo, String str) {
        if (TextUtils.isEmpty(str) || scopeInfo == null) {
            return false;
        }
        deleteScope(str);
        return insertScope(scopeInfo, str);
    }

    private ContentValues fCY_(ScopeInfo scopeInfo, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_Id", str);
        contentValues.put("name", scopeInfo.getName());
        contentValues.put("scope_Id", Integer.valueOf(scopeInfo.getId()));
        contentValues.put("uri", scopeInfo.getUri());
        contentValues.put("permissions", scopeInfo.getPermissionsString());
        return contentValues;
    }

    private List<ScopeInfo> fDa_(Cursor cursor) {
        if (cursor == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(10);
        while (cursor.moveToNext()) {
            try {
                arrayList.add(fCZ_(cursor));
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    private ScopeInfo fCZ_(Cursor cursor) {
        ScopeInfo scopeInfo = new ScopeInfo();
        scopeInfo.setId(cursor.getInt(cursor.getColumnIndex("scope_Id")));
        scopeInfo.setName(cursor.getString(cursor.getColumnIndex("name")));
        scopeInfo.setUri(cursor.getString(cursor.getColumnIndex("uri")));
        scopeInfo.setPermissions(scopeInfo.getPermissionList(cursor.getString(cursor.getColumnIndex("permissions"))));
        return scopeInfo;
    }
}
