package ohos.ace.adapter.capability.editing;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class TextInputConfiguration {
    private final TextInputAction action;
    private final String actionLabel;
    private final boolean autoCorrect;
    private final String capitalization;
    private final String inputFilterRule;
    private final String keyboardAppearance;
    private final int maxInputLength;
    private final boolean obscure;
    private final TextInputType type;

    private TextInputConfiguration(TextInputType textInputType, boolean z, TextInputAction textInputAction, String str, boolean z2, String str2, String str3, String str4, int i) {
        this.type = textInputType;
        this.obscure = z;
        this.action = textInputAction;
        this.actionLabel = str;
        this.autoCorrect = z2;
        this.capitalization = str2;
        this.keyboardAppearance = str3;
        this.inputFilterRule = str4;
        this.maxInputLength = i;
    }

    public static TextInputConfiguration fromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new TextInputConfiguration(TextInputType.of(Integer.valueOf(jSONObject.has("type") ? jSONObject.getInt("type") : 0)), jSONObject.has("obscureText") ? jSONObject.getBoolean("obscureText") : false, TextInputAction.of(Integer.valueOf(jSONObject.has("action") ? jSONObject.getInt("action") : 0)), jSONObject.has("actionLabel") ? jSONObject.getString("actionLabel") : "", jSONObject.has("autoCorrect") ? jSONObject.getBoolean("autoCorrect") : false, jSONObject.has("capitalization") ? jSONObject.getString("capitalization") : "", jSONObject.has("keyboardAppearance") ? jSONObject.getString("keyboardAppearance") : "", jSONObject.has("inputFilter") ? jSONObject.getString("inputFilter") : "", jSONObject.has("maxLength") ? jSONObject.getInt("maxLength") : -1);
    }

    public TextInputType getType() {
        return this.type;
    }

    public boolean isObscure() {
        return this.obscure;
    }

    public TextInputAction getAction() {
        return this.action;
    }

    public String getActionLabel() {
        return this.actionLabel;
    }

    public boolean canAutoCorrect() {
        return this.autoCorrect;
    }

    public String getCapitalization() {
        return this.capitalization;
    }

    public String getKeyboardAppearance() {
        return this.keyboardAppearance;
    }

    public String getInputFilterRule() {
        return this.inputFilterRule;
    }

    public int getMaxInputLength() {
        return this.maxInputLength;
    }
}
