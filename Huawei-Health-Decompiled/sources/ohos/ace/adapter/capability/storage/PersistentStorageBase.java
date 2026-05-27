package ohos.ace.adapter.capability.storage;

/* JADX INFO: loaded from: classes11.dex */
public abstract class PersistentStorageBase {
    public abstract void clear();

    public abstract void delete(String str);

    public abstract String get(String str);

    public abstract void initializeStorage(String str);

    protected native void nativeInit();

    public abstract void set(String str, String str2);
}
