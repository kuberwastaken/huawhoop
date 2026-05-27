package com.huawei.hms.iapfull;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.health.R;
import com.huawei.hms.iapfull.network.model.MyPayType;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class m0 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4910a;
    private List<MyPayType> b;
    private int c;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        TextView textView;
        int i2;
        if (view == null) {
            view = LayoutInflater.from(this.f4910a).inflate(R.layout.pay_type_channel_full_item, viewGroup, false);
            aVar = new a();
            aVar.f4911a = (ImageView) view.findViewById(R.id.cardButton);
            aVar.b = (TextView) view.findViewById(R.id.paytype_title);
            aVar.c = (RadioButton) view.findViewById(R.id.radiobutton);
            aVar.d = (TextView) view.findViewById(R.id.paytype_descr);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.c.setChecked(false);
        int mode = this.b.get(i).getMode();
        int payType = this.b.get(i).getPayType();
        aVar.d.setVisibility(8);
        if (5 == payType) {
            aVar.f4911a.setBackgroundResource(R.drawable._2131429895_res_0x7f0b0a07);
            textView = aVar.b;
            i2 = R.string._2130852431_res_0x7f023a4f;
        } else {
            aVar.f4911a.setBackgroundResource(R.drawable._2131429896_res_0x7f0b0a08);
            textView = aVar.b;
            i2 = R.string._2130852469_res_0x7f023a75;
        }
        textView.setText(i2);
        int i3 = this.c;
        if (i3 == i) {
            if (1 == mode) {
                aVar.c.setChecked(true);
            } else {
                this.c = i3 + 1;
            }
        }
        if (1 != mode) {
            aVar.c.setEnabled(false);
            aVar.b.setAlpha(0.38f);
            aVar.f4911a.setAlpha(0.38f);
            aVar.d.setAlpha(0.38f);
            aVar.d.setVisibility(0);
            aVar.d.setTextColor(this.f4910a.getResources().getColor(R.color._2131297419_res_0x7f09048b));
            aVar.d.setText(R.string._2130852447_res_0x7f023a5f);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<MyPayType> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MyPayType> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void a(List<MyPayType> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f4911a;
        TextView b;
        RadioButton c;
        TextView d;

        a() {
        }
    }

    public void a(int i) {
        List<MyPayType> list = this.b;
        if (list == null || list.isEmpty() || i >= this.b.size()) {
            return;
        }
        this.c = i;
    }

    public m0(Context context, List<MyPayType> list, int i) {
        this.f4910a = context;
        this.b = list;
        this.c = i;
    }
}
