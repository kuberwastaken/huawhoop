package ohos.ace.adapter.capability.web;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebDownloadItemObject {
    private String guid_;
    private long id_;
    private int state_;
    private String suggestedFilename_;
    private String url_;
    private long downloadId_ = -1;
    private long lastBytes_ = 0;
    private long receivedBytes_ = 0;
    private long totalSize_ = 0;
    private long currentSpeed_ = 0;
    private int errCode_ = 0;
    private int percentComplete_ = 0;
    private String method_ = "";
    private String mimeType_ = "";
    private String fullPath_ = "";
    private String realName_ = "";
    private String realPath_ = "";

    public AceWebDownloadItemObject(long j, String str, String str2, int i, String str3) {
        this.id_ = j;
        this.guid_ = str;
        this.suggestedFilename_ = str2;
        this.state_ = i;
        this.url_ = str3;
    }

    public long getWebId() {
        long j;
        synchronized (this) {
            j = this.id_;
        }
        return j;
    }

    public void setGuid(String str) {
        synchronized (this) {
            this.guid_ = str;
        }
    }

    public String getGuid() {
        String str;
        synchronized (this) {
            str = this.guid_;
        }
        return str;
    }

    public void setDownloadId(long j) {
        synchronized (this) {
            this.downloadId_ = j;
        }
    }

    public long getDownloadId() {
        long j;
        synchronized (this) {
            j = this.downloadId_;
        }
        return j;
    }

    public void setCurrentSpeed(long j) {
        synchronized (this) {
            this.currentSpeed_ = j;
        }
    }

    public long getCurrentSpeed() {
        long j;
        synchronized (this) {
            j = this.currentSpeed_;
        }
        return j;
    }

    public void setPercentComplete(int i) {
        synchronized (this) {
            this.percentComplete_ = i;
        }
    }

    public int getPercentComplete() {
        int i;
        synchronized (this) {
            i = this.percentComplete_;
        }
        return i;
    }

    public void setTotalBytes(long j) {
        synchronized (this) {
            this.totalSize_ = j;
        }
    }

    public long getTotalBytes() {
        long j;
        synchronized (this) {
            j = this.totalSize_;
        }
        return j;
    }

    public void setState(int i) {
        synchronized (this) {
            this.state_ = i;
        }
    }

    public int getState() {
        int i;
        synchronized (this) {
            i = this.state_;
        }
        return i;
    }

    public void setLastErrorCode(int i) {
        synchronized (this) {
            this.errCode_ = i;
        }
    }

    public int getLastErrorCode() {
        int i;
        synchronized (this) {
            i = this.errCode_;
        }
        return i;
    }

    public void setMethod(String str) {
        synchronized (this) {
            this.method_ = str;
        }
    }

    public String getMethod() {
        String str;
        synchronized (this) {
            str = this.method_;
        }
        return str;
    }

    public void setMimeType(String str) {
        synchronized (this) {
            this.mimeType_ = str;
        }
    }

    public String getMimeType() {
        String str;
        synchronized (this) {
            str = this.mimeType_;
        }
        return str;
    }

    public void setUrl(String str) {
        synchronized (this) {
            this.url_ = str;
        }
    }

    public String getUrl() {
        String str;
        synchronized (this) {
            str = this.url_;
        }
        return str;
    }

    public void setSuggestedFileName(String str) {
        synchronized (this) {
            this.suggestedFilename_ = str;
        }
    }

    public String getSuggestedFileName() {
        String str;
        synchronized (this) {
            str = this.suggestedFilename_;
        }
        return str;
    }

    public void setRealName(String str) {
        synchronized (this) {
            this.realName_ = str;
        }
    }

    public String getRealName() {
        String str;
        synchronized (this) {
            str = this.realName_;
        }
        return str;
    }

    public void setRealPath(String str) {
        synchronized (this) {
            this.realPath_ = str;
        }
    }

    public String getRealPath() {
        String str;
        synchronized (this) {
            str = this.realPath_;
        }
        return str;
    }

    public void setLastBytes(long j) {
        synchronized (this) {
            this.lastBytes_ = j;
        }
    }

    public long getLastBytes() {
        long j;
        synchronized (this) {
            j = this.lastBytes_;
        }
        return j;
    }

    public void setReceivedBytes(long j) {
        synchronized (this) {
            this.receivedBytes_ = j;
        }
    }

    public long getReceivedBytes() {
        long j;
        synchronized (this) {
            j = this.receivedBytes_;
        }
        return j;
    }

    public void setFullPath(String str) {
        synchronized (this) {
            this.fullPath_ = str;
        }
    }

    public String getFullPath() {
        String str;
        synchronized (this) {
            str = this.fullPath_;
        }
        return str;
    }
}
