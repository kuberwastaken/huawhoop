package net.zetetic.database.sqlcipher;

/* JADX INFO: loaded from: classes8.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
