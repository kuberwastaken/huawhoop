package ohos.ace.plugin.taskmanagerplugin;

/* JADX INFO: loaded from: classes2.dex */
public class FileSpec {
    private int fd;
    private String filename;
    private String name;
    private String type;
    private String uri;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public int getFd() {
        return this.fd;
    }

    public void setFd(int i) {
        this.fd = i;
    }
}
