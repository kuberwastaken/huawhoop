package ohos.ace.plugin.taskmanagerplugin;

/* JADX INFO: loaded from: classes2.dex */
public class Filter {
    private int action;
    private long after;
    private long before;
    private String bundle;
    private int mode;
    private int state;

    public String getBundle() {
        return this.bundle;
    }

    public void setBundle(String str) {
        this.bundle = str;
    }

    public long getBefore() {
        return this.before;
    }

    public void setBefore(long j) {
        this.before = j;
    }

    public long getAfter() {
        return this.after;
    }

    public void setAfter(long j) {
        this.after = j;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
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
}
