package ohos.ace.adapter;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes8.dex */
public interface InputConnectionClient {
    InputConnection onCreateInputConnection(View view, EditorInfo editorInfo);
}
