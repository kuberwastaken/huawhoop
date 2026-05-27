package com.huawei.healthcloud.plugintrack.trackanimation.trackalbum.emotion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import defpackage.ikl;
import defpackage.mgx;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GridViewEmotionAdapter extends BaseAdapter {
    private List<ikl> b;
    private Context d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public GridViewEmotionAdapter(Context context, List<ikl> list) {
        this.d = context;
        this.b = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (!(view instanceof ImageView)) {
            imageView = new ImageView(this.d);
        } else {
            imageView = (ImageView) view;
        }
        Object item = getItem(i);
        if (item instanceof ikl) {
            imageView.setImageResource(((ikl) item).e());
        }
        return imageView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (mgx.e((Collection<?>) this.b, i)) {
            return null;
        }
        return this.b.get(i);
    }
}
