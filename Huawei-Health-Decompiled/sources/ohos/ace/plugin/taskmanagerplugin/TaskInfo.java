package ohos.ace.plugin.taskmanagerplugin;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TaskInfo {
    private int action;
    private int code;
    private long ctime;
    private String data;
    private String description;
    private long downloadId;
    private String extras;
    private int faults;
    private List<FileSpec> files;
    private List<FormItem> forms;
    private boolean gauge;
    private String mimeType;
    private int mode;
    private long mtime;
    private int priority;
    private Progress progress;
    private String reason;
    private boolean retry;
    private String saveas;
    private TaskState taskStates;
    private long tid;
    private String title;
    private String token;
    private int tries;
    private String url;
    private int version;
    private boolean withSystem;

    public String getSaveas() {
        return this.saveas;
    }

    public void setSaveas(String str) {
        this.saveas = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public Progress getProgress() {
        return this.progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public long getCtime() {
        return this.ctime;
    }

    public void setCtime(long j) {
        this.ctime = j;
    }

    public long getMtime() {
        return this.mtime;
    }

    public void setMtime(long j) {
        this.mtime = j;
    }

    public int getFaults() {
        return this.faults;
    }

    public void setFaults(int i) {
        this.faults = i;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public long getDownloadId() {
        return this.downloadId;
    }

    public void setDownloadId(long j) {
        this.downloadId = j;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public TaskState getTaskStates() {
        return this.taskStates;
    }

    public void setTaskStates(TaskState taskState) {
        this.taskStates = taskState;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public List<FileSpec> getFiles() {
        return this.files;
    }

    public void setFiles(List<FileSpec> list) {
        this.files = list;
    }

    public List<FormItem> getForms() {
        return this.forms;
    }

    public void setForms(List<FormItem> list) {
        this.forms = list;
    }

    public boolean isGauge() {
        return this.gauge;
    }

    public void setGauge(boolean z) {
        this.gauge = z;
    }

    public boolean isRetry() {
        return this.retry;
    }

    public void setRetry(boolean z) {
        this.retry = z;
    }

    public int getTries() {
        return this.tries;
    }

    public void setTries(int i) {
        this.tries = i;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public boolean isWithSystem() {
        return this.withSystem;
    }

    public void setWithSystem(boolean z) {
        this.withSystem = z;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public String getExtras() {
        return this.extras;
    }

    public void setExtras(String str) {
        this.extras = str;
    }
}
