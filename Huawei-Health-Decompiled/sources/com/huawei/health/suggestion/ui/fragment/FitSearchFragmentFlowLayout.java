package com.huawei.health.suggestion.ui.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.health.R;
import com.huawei.health.suggestion.ui.view.FlowLayout;
import com.huawei.hianalytics.visual.autocollect.instrument.FragmentInstrumentation;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes10.dex */
public class FitSearchFragmentFlowLayout extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FlowLayout f3326a;
    private FowAdapter e;

    public interface FowAdapter {
        LinkedList<String> getShowData();

        void saveShowData(String str);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.sug_fragment_fit_search_flow, viewGroup, false);
        aJa_(viewInflate);
        return viewInflate;
    }

    private void aJa_(View view) {
        this.f3326a = (FlowLayout) view.findViewById(R.id.search_flowlayout);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void e(FlowLayout.OnTextClickListener onTextClickListener) {
        this.f3326a.setTextOnClickListener(onTextClickListener);
    }

    public void d(FowAdapter fowAdapter) {
        if (fowAdapter == null) {
            return;
        }
        this.e = fowAdapter;
        this.f3326a.e(getActivity(), fowAdapter.getShowData());
    }

    public void aJb_(Fragment fragment) {
        if (getActivity() == null || !isAdded()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragment.getFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.hide(this);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void aJc_(Fragment fragment) {
        if (this.e != null && getActivity() != null) {
            this.f3326a.e(getActivity(), this.e.getShowData());
        }
        if (getActivity() == null || !isAdded()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragment.getFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.show(this);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void d(String str) {
        FowAdapter fowAdapter = this.e;
        if (fowAdapter != null) {
            fowAdapter.saveShowData(str);
        }
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FragmentInstrumentation.setUserVisibleHintByFragment(this, z);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentInstrumentation.onViewCreatedByFragment(this, view, bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentInstrumentation.onResumeByFragment(this);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentInstrumentation.onPauseByFragment(this);
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        FragmentInstrumentation.onHiddenChangedByFragment(this, z);
    }
}
