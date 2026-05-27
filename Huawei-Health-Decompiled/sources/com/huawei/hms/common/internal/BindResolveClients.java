package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes5.dex */
public class BindResolveClients {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<ResolveClientBean> f4636a;

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final BindResolveClients f4637a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.f4637a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean zContains;
        synchronized (b) {
            zContains = this.f4636a.contains(resolveClientBean);
        }
        return zContains;
    }

    public void notifyClientReconnect() {
        synchronized (b) {
            ListIterator<ResolveClientBean> listIterator = this.f4636a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f4636a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (!this.f4636a.contains(resolveClientBean)) {
                this.f4636a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (this.f4636a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f4636a.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (b) {
            this.f4636a.clear();
        }
    }

    private BindResolveClients() {
        this.f4636a = new ArrayList<>();
    }
}
