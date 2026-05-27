package ohos.ace.adapter.capability.clipboard;

/* JADX INFO: loaded from: classes11.dex */
public abstract class ClipboardPluginBase {
    public abstract void clear();

    public abstract String getData();

    public abstract boolean hasData();

    protected native void nativeInit();

    public abstract void setData(String str);
}
