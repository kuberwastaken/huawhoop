package com.huawei.wearengine;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.wrm;
import defpackage.wut;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class ClientHubActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        wrm.d("ClientHubActivity", "ClientHubActivity onCreate");
        super.onCreate(bundle);
        wut.e(this);
        Intent intent = getIntent();
        if (!fAH_(intent)) {
            d(5, "invalid intent");
            return;
        }
        String stringExtra = intent.getStringExtra("target_json");
        String stringExtra2 = intent.getStringExtra("start_request_json");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            d(5, "ClientHubActivity start authNameJson is empty or requestDataJsonString is empty");
        } else {
            b(stringExtra, stringExtra2);
        }
    }

    private void d(int i, String str) {
        wrm.e("ClientHubActivity", "errorReturn:" + str + ", resultCode:" + i);
        setResult(i);
        finish();
    }

    private boolean fAH_(Intent intent) {
        if (intent != null) {
            return true;
        }
        wrm.e("ClientHubActivity", "checkIntent intent is null");
        return false;
    }

    private void b(String str, String str2) {
        wrm.d("ClientHubActivity", "startJumpActivity");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("target_package_name");
            String string2 = jSONObject.getString("target_activity_name");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                d(12, "targetPackageName or targetActivityName is empty");
                return;
            }
            Intent intent = new Intent();
            intent.setPackage(string);
            intent.setClassName(string, string2);
            intent.putExtra("start_request_json", str2);
            Intent intentFDL_ = wut.fDL_(intent);
            if (intentFDL_ == null) {
                d(12, "createExplicitActivityIntent, intent is null.");
                return;
            }
            try {
                startActivityForResult(intentFDL_, 19900);
            } catch (ActivityNotFoundException unused) {
                d(12, "startJumpActivity not find JumpActivity");
            }
        } catch (JSONException unused2) {
            d(12, "startJumpActivity JSONException");
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        wrm.d("ClientHubActivity", "onActivityResult requestCode:" + i + ", resultCode:" + i2);
        if (i == 19900) {
            wrm.d("ClientHubActivity", "onActivityResult finish");
            setResult(i2);
            finish();
        }
    }
}
