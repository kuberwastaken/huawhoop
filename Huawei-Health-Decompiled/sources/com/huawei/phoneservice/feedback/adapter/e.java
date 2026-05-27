package com.huawei.phoneservice.feedback.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.health.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class e extends BaseAdapter {
    private final int b;
    private List<CharSequence> d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        if (view == null) {
            bVar = new b();
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feedback_sdk_item_list_dialog, viewGroup, false);
            bVar.f8549a = (TextView) viewInflate.findViewById(R.id.list_dialog_item_content);
            bVar.c = (RadioButton) viewInflate.findViewById(R.id.list_dialog_item_radio);
            bVar.e = viewInflate.findViewById(R.id.list_dialog_item_line);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        bVar.f8549a.setText(getItem(i));
        bVar.c.setChecked(i == this.b);
        bVar.e.setVisibility(i == getCount() - 1 ? 8 : 0);
        return viewInflate;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f8549a;
        RadioButton c;
        View e;

        b() {
        }
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int i) {
        return this.d.get(i);
    }

    public e(CharSequence[] charSequenceArr, int i) {
        this.d = new ArrayList();
        if (charSequenceArr != null) {
            this.d = Arrays.asList(charSequenceArr);
        }
        this.b = i;
    }
}
