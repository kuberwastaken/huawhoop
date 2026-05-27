package com.huawei.ui.main.stories.template.health.contract;

import com.huawei.ui.main.stories.template.BaseComponent;
import com.huawei.ui.main.stories.template.BasePresenter;
import com.huawei.ui.main.stories.template.BaseView;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class DataDetailFragmentContract {

    public interface DetailFragmentPresenter<V extends DetailFragmentView> extends BasePresenter<V> {
        void setComponents(List<BaseComponent> list);
    }

    public interface DetailFragmentView extends BaseView {
    }
}
