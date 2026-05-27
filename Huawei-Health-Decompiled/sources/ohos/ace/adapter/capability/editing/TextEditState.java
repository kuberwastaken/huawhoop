package ohos.ace.adapter.capability.editing;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class TextEditState {
    private final String hint;
    private final int selectionEnd;
    private final int selectionStart;
    private final String text;

    private TextEditState(String str, String str2, int i, int i2) {
        this.text = str;
        this.hint = str2;
        this.selectionStart = i;
        this.selectionEnd = i2;
    }

    public static TextEditState fromJson(JSONObject jSONObject) throws JSONException {
        return new TextEditState(jSONObject.getString("text"), jSONObject.getString("hint"), jSONObject.getInt("selectionStart"), jSONObject.getInt("selectionEnd"));
    }

    public String getText() {
        return this.text;
    }

    public String getHint() {
        return this.hint;
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public int getSelectionEnd() {
        return this.selectionEnd;
    }
}
