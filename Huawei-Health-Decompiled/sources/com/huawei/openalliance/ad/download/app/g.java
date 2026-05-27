package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.health.R;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import com.huawei.openalliance.ad.utils.bj;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7016a;
    private List<PermissionEntity> b;
    private LayoutInflater c;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[PHI: r0 r7 r8
      0x006b: PHI (r0v8 java.lang.String) = (r0v4 java.lang.String), (r0v10 java.lang.String) binds: [B:23:0x0068, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x006b: PHI (r7v6 android.view.View) = (r7v1 android.view.View), (r7v7 android.view.View) binds: [B:23:0x0068, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x006b: PHI (r8v9 android.widget.TextView) = (r8v4 android.widget.TextView), (r8v13 android.widget.TextView) binds: [B:23:0x0068, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            java.util.List<com.huawei.openalliance.ad.inter.data.PermissionEntity> r0 = r5.b
            java.lang.Object r0 = r0.get(r6)
            com.huawei.openalliance.ad.inter.data.PermissionEntity r0 = (com.huawei.openalliance.ad.inter.data.PermissionEntity) r0
            int r1 = r5.getItemViewType(r6)
            r2 = 0
            java.lang.String r3 = ""
            if (r1 == 0) goto L40
            r4 = 1
            if (r1 == r4) goto L15
            goto L6f
        L15:
            if (r7 != 0) goto L29
            android.view.LayoutInflater r7 = r5.c
            r1 = 2131166363(0x7f07049b, float:1.794697E38)
            android.view.View r7 = r7.inflate(r1, r8, r2)
            com.huawei.openalliance.ad.download.app.g$a r8 = new com.huawei.openalliance.ad.download.app.g$a
            r8.<init>(r7)
            r7.setTag(r8)
            goto L2f
        L29:
            java.lang.Object r8 = r7.getTag()
            com.huawei.openalliance.ad.download.app.g$a r8 = (com.huawei.openalliance.ad.download.app.g.a) r8
        L2f:
            if (r0 == 0) goto L36
            java.lang.String r0 = r0.getName()
            goto L37
        L36:
            r0 = r3
        L37:
            android.widget.TextView r8 = r8.f7017a
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L6b
            goto L6c
        L40:
            if (r7 != 0) goto L54
            android.view.LayoutInflater r7 = r5.c
            r1 = 2131166365(0x7f07049d, float:1.7946973E38)
            android.view.View r7 = r7.inflate(r1, r8, r2)
            com.huawei.openalliance.ad.download.app.g$b r8 = new com.huawei.openalliance.ad.download.app.g$b
            r8.<init>(r7)
            r7.setTag(r8)
            goto L5a
        L54:
            java.lang.Object r8 = r7.getTag()
            com.huawei.openalliance.ad.download.app.g$b r8 = (com.huawei.openalliance.ad.download.app.g.b) r8
        L5a:
            if (r0 == 0) goto L61
            java.lang.String r0 = r0.getName()
            goto L62
        L61:
            r0 = r3
        L62:
            android.widget.TextView r8 = r8.f7018a
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L6b
            goto L6c
        L6b:
            r3 = r0
        L6c:
            r8.setText(r3)
        L6f:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r6 = new java.lang.Object[]{r8, r6}
            java.lang.String r8 = "AppPermissionsDialog"
            java.lang.String r0 = "getView, time:%d, position:%d"
            com.huawei.openalliance.ad.hq.a(r8, r0, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.download.app.g.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (bj.a(this.b) || this.b.get(i) == null) {
            return 0;
        }
        return this.b.get(i).getType();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bj.a(this.b)) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bj.a(this.b)) {
            return null;
        }
        return this.b.get(i);
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f7017a;

        public a(View view) {
            this.f7017a = (TextView) view.findViewById(R.id.hiad_permissions_dialog_child_tv);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f7018a;

        public b(View view) {
            this.f7018a = (TextView) view.findViewById(R.id.hiad_permissions_dialog_parent_tv);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (bj.a(this.b)) {
            return 0;
        }
        return this.b.size();
    }

    public g(Context context, List<PermissionEntity> list) {
        this.f7016a = context;
        this.b = list;
        this.c = LayoutInflater.from(context);
    }
}
