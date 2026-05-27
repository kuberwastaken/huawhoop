package ohos.ace.adapter.capability.font;

/* JADX INFO: loaded from: classes11.dex */
public class SystemFontInfo {
    private boolean italic;
    private String name;
    private String path;
    private int weight;

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setItalic(boolean z) {
        this.italic = z;
    }

    public boolean isItalic() {
        return this.italic;
    }
}
