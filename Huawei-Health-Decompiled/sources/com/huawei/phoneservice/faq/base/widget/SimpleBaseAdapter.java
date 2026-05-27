package com.huawei.phoneservice.faq.base.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleBaseAdapter<T> extends BaseAdapter {
    public List<T> d = new ArrayList(0);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return view;
    }

    public void b(List<T> list) {
        List<T> list2;
        if (list == null || (list2 = this.d) == null) {
            this.d = new ArrayList();
        } else {
            list2.clear();
            this.d.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<T> list = this.d;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void a(List<T> list) {
        a(this.d.size(), list);
    }

    public void a(int i, List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        List<T> listSubList = this.d.subList(0, i);
        this.d = listSubList;
        listSubList.addAll(list);
    }
}
