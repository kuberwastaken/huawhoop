package ohos.ace.adapter.capability.editing;

/* JADX INFO: loaded from: classes8.dex */
public interface TextInputDelegate {
    void notifyKeyboardClosedByUser(int i);

    void performAction(int i, TextInputAction textInputAction);

    void updateEditingState(int i, String str, int i2, int i3, int i4, int i5);

    void updateInputFilterErrorText(int i, String str);
}
