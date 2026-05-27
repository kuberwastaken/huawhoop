package com.huawei.health.todo.api;

import android.app.Activity;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import defpackage.hqp;

/* JADX INFO: loaded from: classes.dex */
public interface TodoDataApi {
    void addNewTodoInfo(hqp hqpVar, IBaseResponseCallback iBaseResponseCallback);

    Class<?> getTodoJsClass();

    void getTodoListFromCloud(String str, IBaseResponseCallback iBaseResponseCallback);

    void hideOrShowTodoFloatView(Activity activity, boolean z);

    boolean isMainSwitchChecked();

    boolean isShowTodo();

    void refreshTodoList(IBaseResponseCallback iBaseResponseCallback);

    void removeTodoFloatView();

    void updateTodoInfo(hqp hqpVar, IBaseResponseCallback iBaseResponseCallback);
}
