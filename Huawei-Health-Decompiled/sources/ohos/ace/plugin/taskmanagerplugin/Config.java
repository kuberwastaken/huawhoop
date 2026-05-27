package ohos.ace.plugin.taskmanagerplugin;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class Config {
    private int action;
    private boolean background = true;
    private int begins;
    private String bodyFds;
    private String bodyFileNames;
    private long cTime;
    private String data;
    private String description;
    private int ends;
    private String extras;
    private String files;
    private String forms;
    private boolean gauge;
    private HashMap<String, String> headers;
    private int index;
    private boolean metered;
    private String method;
    private String mimeType;
    private int mode;
    private int network;
    private boolean overwrite;
    private boolean precise;
    private int priority;
    private boolean redirect;
    private boolean retry;
    private boolean roaming;
    private String saveas;
    private long taskId;
    private String title;
    private String token;
    private String url;
    private int version;

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
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

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public boolean isOverwrite() {
        return this.overwrite;
    }

    public void setOverwrite(boolean z) {
        this.overwrite = z;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(HashMap<String, String> map) {
        this.headers = map;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getSaveas() {
        return this.saveas;
    }

    public void setSaveas(String str) {
        this.saveas = str;
    }

    public int getNetwork() {
        return this.network;
    }

    public void setNetwork(int i) {
        this.network = i;
    }

    public boolean isMetered() {
        return this.metered;
    }

    public void setMetered(boolean z) {
        this.metered = z;
    }

    public boolean isRoaming() {
        return this.roaming;
    }

    public void setRoaming(boolean z) {
        this.roaming = z;
    }

    public boolean isRedirect() {
        return this.redirect;
    }

    public void setRedirect(boolean z) {
        this.redirect = z;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getBegins() {
        return this.begins;
    }

    public void setBegins(int i) {
        this.begins = i;
    }

    public int getEnds() {
        return this.ends;
    }

    public void setEnds(int i) {
        this.ends = i;
    }

    public boolean isGauge() {
        return this.gauge;
    }

    public void setGauge(boolean z) {
        this.gauge = z;
    }

    public boolean isPrecise() {
        return this.precise;
    }

    public void setPrecise(boolean z) {
        this.precise = z;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getExtras() {
        return this.extras;
    }

    public void setExtras(String str) {
        this.extras = str;
    }

    public long getcTime() {
        return this.cTime;
    }

    public void setcTime(long j) {
        this.cTime = j;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public boolean isRetry() {
        return this.retry;
    }

    public void setRetry(boolean z) {
        this.retry = z;
    }

    public boolean isBackground() {
        return this.background;
    }

    public void setBackground(boolean z) {
        this.background = z;
    }

    public String getForms() {
        return this.forms;
    }

    public void setForms(String str) {
        this.forms = str;
    }

    public String getFiles() {
        return this.files;
    }

    public void setFiles(String str) {
        this.files = str;
    }

    public String getBodyFds() {
        return this.bodyFds;
    }

    public void setBodyFds(String str) {
        this.bodyFds = str;
    }

    public String getBodyFileNames() {
        return this.bodyFileNames;
    }

    public void setBodyFileNames(String str) {
        this.bodyFileNames = str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
