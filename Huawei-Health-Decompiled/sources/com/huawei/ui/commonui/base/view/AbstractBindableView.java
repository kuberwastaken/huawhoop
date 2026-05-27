package com.huawei.ui.commonui.base.view;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.huawei.hianalytics.visual.autocollect.instrument.ViewClickInstrumentation;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.ui.commonui.base.Bindable;
import com.huawei.ui.commonui.base.Observable;
import com.huawei.ui.commonui.base.viewmodel.ObservableViewModel;
import defpackage.mgx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbstractBindableView extends View implements Bindable, Observable, View.OnClickListener {
    private static final String TAG = "AbstractBindableView";
    protected List<Observable.OnPropertyChangedCallback> mCallbacks;
    protected List<Bindable> mChildViews;
    protected ViewModel mViewModel;

    protected abstract void bindChildViews(ViewModel viewModel);

    protected abstract void onBind(ViewModel viewModel);

    protected abstract void onUnbind();

    public AbstractBindableView(Activity activity) {
        super(activity);
        this.mChildViews = new ArrayList();
        this.mCallbacks = new ArrayList();
    }

    @Override // com.huawei.ui.commonui.base.Bindable
    public void bind(ViewModel viewModel) {
        this.mViewModel = viewModel;
        onBind(viewModel);
        bindChildViews(viewModel);
    }

    @Override // com.huawei.ui.commonui.base.Bindable
    public void unbind() {
        unbindChildView();
        onUnbind();
        this.mCallbacks.clear();
    }

    public void addChildView(AbstractBindableView abstractBindableView) {
        if (this.mChildViews == null) {
            this.mChildViews = new ArrayList();
        }
        if (this.mChildViews.contains(abstractBindableView)) {
            return;
        }
        this.mChildViews.add(abstractBindableView);
    }

    @Override // com.huawei.ui.commonui.base.Observable
    public void addOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        if (onPropertyChangedCallback == null) {
            LogUtil.j(TAG, "can not add null calback");
            return;
        }
        if (!this.mCallbacks.contains(onPropertyChangedCallback)) {
            this.mCallbacks.add(onPropertyChangedCallback);
        } else {
            LogUtil.j(TAG, "already contains this callback");
        }
        LogUtil.e(TAG, "mCallbacks size info", Integer.valueOf(this.mCallbacks.size()));
    }

    @Override // com.huawei.ui.commonui.base.Observable
    public void removeOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        this.mCallbacks.remove(onPropertyChangedCallback);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (Observable.OnPropertyChangedCallback onPropertyChangedCallback : this.mCallbacks) {
            LogUtil.e(TAG, "onPropertyChanged ", getClass().getSimpleName(), " --> ", onPropertyChangedCallback.getClass().getSimpleName());
            onPropertyChangedCallback.onPropertyChanged(this, view.getId());
        }
        ViewModel viewModel = this.mViewModel;
        if (viewModel instanceof ObservableViewModel) {
            ((ObservableViewModel) viewModel).notifyChange(0);
        }
        ViewClickInstrumentation.clickOnView(view);
    }

    private void unbindChildView() {
        if (mgx.d(this.mChildViews)) {
            return;
        }
        for (Bindable bindable : this.mChildViews) {
            if (bindable != null) {
                bindable.unbind();
            }
        }
        this.mChildViews.clear();
    }
}
