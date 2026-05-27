package com.huawei.haf.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LocalBroadcastManagerImpl implements LocalBroadcastManagerBridge {
    private static final int MSG_EXECUTE_PENDING_BROADCASTS = 1;
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();

    LocalBroadcastManagerImpl(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManagerImpl.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<ReceiverRecord> arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<ReceiverRecord> arrayListRemove = this.mReceivers.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                ReceiverRecord receiverRecord = arrayListRemove.get(size);
                receiverRecord.mDead = true;
                for (int i = 0; i < receiverRecord.mFilter.countActions(); i++) {
                    removeReceiver(receiverRecord.mFilter.getAction(i), broadcastReceiver);
                }
            }
        }
    }

    private void removeReceiver(String str, BroadcastReceiver broadcastReceiver) {
        ArrayList<ReceiverRecord> arrayList = this.mActions.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ReceiverRecord receiverRecord = arrayList.get(size);
                if (receiverRecord.mReceiver == broadcastReceiver) {
                    receiverRecord.mDead = true;
                    arrayList.remove(size);
                }
            }
            if (arrayList.size() <= 0) {
                this.mActions.remove(str);
            }
        }
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public boolean sendBroadcast(Intent intent) {
        synchronized (this.mReceivers) {
            ArrayList<ReceiverRecord> arrayList = this.mActions.get(intent.getAction());
            if (arrayList == null) {
                return false;
            }
            ArrayList<ReceiverRecord> arrayListMatchReceivers = matchReceivers(intent, arrayList);
            if (arrayListMatchReceivers == null) {
                return false;
            }
            for (int i = 0; i < arrayListMatchReceivers.size(); i++) {
                arrayListMatchReceivers.get(i).mBroadcasting = false;
            }
            this.mPendingBroadcasts.add(new BroadcastRecord(intent, arrayListMatchReceivers));
            if (!this.mHandler.hasMessages(1)) {
                this.mHandler.sendEmptyMessage(1);
            }
            return true;
        }
    }

    private ArrayList<ReceiverRecord> matchReceivers(Intent intent, ArrayList<ReceiverRecord> arrayList) {
        String str;
        String action = intent.getAction();
        String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
        Uri data = intent.getData();
        String scheme = intent.getScheme();
        Set<String> categories = intent.getCategories();
        ArrayList<ReceiverRecord> arrayList2 = null;
        int i = 0;
        while (i < arrayList.size()) {
            ReceiverRecord receiverRecord = arrayList.get(i);
            if (receiverRecord.mBroadcasting) {
                str = action;
            } else {
                str = action;
                if (receiverRecord.mFilter.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager") >= 0) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    arrayList2.add(receiverRecord);
                    receiverRecord.mBroadcasting = true;
                }
            }
            i++;
            action = str;
        }
        return arrayList2;
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePendingBroadcasts() {
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                int size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(broadcastRecordArr);
                this.mPendingBroadcasts.clear();
            }
            executeBroadcasts(broadcastRecordArr);
        }
    }

    private void executeBroadcasts(BroadcastRecord[] broadcastRecordArr) {
        for (BroadcastRecord broadcastRecord : broadcastRecordArr) {
            int size = broadcastRecord.mReceivers.size();
            for (int i = 0; i < size; i++) {
                ReceiverRecord receiverRecord = broadcastRecord.mReceivers.get(i);
                if (!receiverRecord.mDead && receiverRecord.mReceiver != null) {
                    receiverRecord.mReceiver.onReceive(this.mAppContext, broadcastRecord.mIntent);
                }
            }
        }
    }

    static final class ReceiverRecord {
        boolean mBroadcasting;
        boolean mDead;
        final IntentFilter mFilter;
        final BroadcastReceiver mReceiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.mFilter = intentFilter;
            this.mReceiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.mReceiver);
            sb.append(" filter=");
            sb.append(this.mFilter);
            if (this.mDead) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static final class BroadcastRecord {
        final Intent mIntent;
        final ArrayList<ReceiverRecord> mReceivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.mIntent = intent;
            this.mReceivers = arrayList;
        }
    }
}
