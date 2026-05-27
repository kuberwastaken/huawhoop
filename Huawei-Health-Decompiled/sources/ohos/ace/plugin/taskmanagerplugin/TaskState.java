package ohos.ace.plugin.taskmanagerplugin;

/* JADX INFO: loaded from: classes2.dex */
public class TaskState {
    private String message;
    private String path;
    private int responseCode;

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
