package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.hidatamanager.util.Const;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import defpackage.www;
import defpackage.wxe;
import defpackage.wzb;
import defpackage.wzk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ErrorBody {

    @KfsStringNotEmpty
    private String errorCode;

    @KfsStringNotEmpty
    private String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public static ErrorBody fromString(String str) throws wzb {
        try {
            ErrorBody errorBody = new ErrorBody();
            JSONObject jSONObject = new JSONObject(str);
            errorBody.errorCode = jSONObject.optString("errorCode");
            errorBody.errorMessage = jSONObject.optString("errorMessage");
            wxe.c(errorBody);
            return errorBody;
        } catch (JSONException e) {
            StringBuilder sbB = wzk.b("ErrorBody param is not a valid json string : ");
            sbB.append(e.getMessage());
            throw new wzb(Const.RawDataType.HEALTH_EVENT_RECORD, sbB.toString());
        } catch (www e2) {
            StringBuilder sbB2 = wzk.b("ErrorBody param invalid : ");
            sbB2.append(e2.getMessage());
            throw new wzb(Const.RawDataType.HEALTH_EVENT_RECORD, sbB2.toString());
        }
    }
}
