package ohos.ace.adapter.capability.web;

import android.webkit.ConsoleMessage;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebConsoleMessageObject {
    private static final String LOG_TAG = "AceWebConsoleMessageObject";
    private static final int ONELEVEL = 1;
    private ConsoleMessage consoleMessage;

    public AceWebConsoleMessageObject(ConsoleMessage consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    public int getLineNumber() {
        return this.consoleMessage.lineNumber();
    }

    public String getMessage() {
        return this.consoleMessage.message() != null ? this.consoleMessage.message().toString() : "";
    }

    public int getMessageLevel() {
        return this.consoleMessage.messageLevel().ordinal() + 1;
    }

    public String getSourceId() {
        return this.consoleMessage.sourceId() != null ? this.consoleMessage.sourceId().toString() : "";
    }
}
