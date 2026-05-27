package com.huawei.ui.main.stories.privacy.template.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.huawei.health.R;
import com.huawei.ui.commonui.listview.HealthExpandableListView;
import com.huawei.ui.main.stories.privacy.template.contract.PrivacyDetailFragmentContract;

/* JADX INFO: loaded from: classes8.dex */
public class PrivacyGroupDataView extends HealthExpandableListView implements BaseComponent {
    private LoadMoreListener c;
    private AbsListView.OnScrollListener d;

    public interface LoadMoreListener {
        void loadMore();
    }

    @Override // com.huawei.ui.main.stories.privacy.template.view.component.BaseComponent
    public View getView(Context context) {
        return this;
    }

    @Override // com.huawei.ui.main.stories.privacy.template.view.component.BaseComponent
    public void setPresenter(PrivacyDetailFragmentContract.PrivacyFragmentPresenter privacyFragmentPresenter) {
    }

    public PrivacyGroupDataView(Context context) {
        this(context, null);
    }

    public PrivacyGroupDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new AbsListView.OnScrollListener() { // from class: com.huawei.ui.main.stories.privacy.template.view.component.PrivacyGroupDataView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (PrivacyGroupDataView.this.getLastVisiblePosition() == PrivacyGroupDataView.this.getAdapter().getCount() - 1 || PrivacyGroupDataView.this.getLastVisiblePosition() == PrivacyGroupDataView.this.getAdapter().getCount() - 2) {
                        PrivacyGroupDataView.this.a();
                    }
                }
            }
        };
        setVerticalScrollBarEnabled(false);
        b();
        setSelector(R.color._2131299926_res_0x7f090e56);
        setGroupIndicator(null);
    }

    private void b() {
        setOnScrollListener(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        LoadMoreListener loadMoreListener = this.c;
        if (loadMoreListener != null) {
            loadMoreListener.loadMore();
        }
    }

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.c = loadMoreListener;
    }
}
