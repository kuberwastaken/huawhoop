package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class HwRollbackRuleDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11220a = "HwRollbackRuleDetector";
    private int b;
    private int c;
    private GestureDetector d;
    private View e;
    private boolean f;
    private RollBackScrollListener g;
    private Class<?> h;
    private Object i;
    private Context j;
    private Handler m = new b();
    private GestureDetector.OnGestureListener n = new d();

    public interface RollBackScrollListener {
        int getScrollYDistance();
    }

    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            HwRollbackRuleDetector.this.c = 0;
        }
    }

    class d implements GestureDetector.OnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HwRollbackRuleDetector.this.m.removeMessages(1);
            if (motionEvent == null || motionEvent2 == null || motionEvent.getY() >= motionEvent2.getY() || Math.abs(f2) <= Math.abs(f)) {
                HwRollbackRuleDetector.this.c = 0;
            } else {
                HwRollbackRuleDetector.a(HwRollbackRuleDetector.this);
                HwRollbackRuleDetector.this.b();
                if (HwRollbackRuleDetector.this.a() && HwRollbackRuleDetector.this.d()) {
                    HwRollbackRuleDetector.this.c = 0;
                    HwRollbackRuleDetector.this.d("com.huawei.control.intent.action.RollBackEvent");
                }
                HwRollbackRuleDetector.this.m.sendEmptyMessageDelayed(1, 1000L);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public HwRollbackRuleDetector(RollBackScrollListener rollBackScrollListener) {
        this.g = rollBackScrollListener;
    }

    public void c() {
        if (this.f) {
            if (this.j == null) {
                Log.w(f11220a, "mServiceContext is null");
                return;
            }
            Class<?> cls = this.h;
            if (cls != null && this.i != null) {
                try {
                    cls.getDeclaredMethod("unbindService", Context.class).invoke(this.i, this.j);
                } catch (IllegalAccessException unused) {
                    Log.w(f11220a, "com.huawei.decision.DecisionHelper.unbindService() Illegal Access");
                } catch (NoSuchMethodException unused2) {
                    Log.w(f11220a, "com.huawei.decision.DecisionHelper no function unbindService()");
                } catch (InvocationTargetException unused3) {
                    Log.w(f11220a, "com.huawei.decision.DecisionHelper.unbindService() Invocation Target");
                }
                this.h = null;
            }
            this.e = null;
            this.d = null;
            this.f = false;
        }
    }

    public void d(String str) {
        Class<?> cls = this.h;
        if (cls == null || this.i == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("executeEvent", String.class).invoke(this.i, str);
        } catch (IllegalAccessException unused) {
            Log.w(f11220a, "com.huawei.decision.DecisionHelper.executeEvent() IllegalAccessException!");
        } catch (NoSuchMethodException unused2) {
            Log.w(f11220a, "com.huawei.decision.DecisionHelper no function executeEvent()!");
        } catch (InvocationTargetException unused3) {
            Log.w(f11220a, "com.huawei.decision.DecisionHelper.executeEvent() InvocationTargetException!");
        }
    }

    public void eEk_(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        if (this.f && (gestureDetector = this.d) != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public void eEl_(View view) {
        if (view == null) {
            Log.w(f11220a, "view is null!");
            return;
        }
        if (this.f) {
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            Log.w(f11220a, "context is null");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.j = context;
        if (c(context)) {
            try {
                Class<?> cls = Class.forName("com.huawei.decision.DecisionHelper");
                Object objNewInstance = cls.newInstance();
                cls.getDeclaredMethod("bindService", Context.class).invoke(objNewInstance, this.j);
                this.d = new GestureDetector(this.j, this.n);
                this.h = cls;
                this.i = objNewInstance;
                this.e = view;
                this.f = true;
            } catch (ReceiverCallNotAllowedException unused) {
                Log.w(f11220a, "There is a problem with the APP application scenario:BroadcastReceiver components are not allowed to register to receive intents");
            } catch (ClassNotFoundException unused2) {
                Log.w(f11220a, "com.huawei.decision.DecisionHelper not found!");
            } catch (IllegalAccessException unused3) {
                Log.w(f11220a, "com.huawei.decision.DecisionHelper.bindService() Illegal Access");
            } catch (InstantiationException unused4) {
                Log.w(f11220a, "com.huawei.decision.DecisionHelper.bindService() InstantiationException!");
            } catch (NoSuchMethodException unused5) {
                Log.w(f11220a, "com.huawei.decision.DecisionHelper no function bindService()");
            } catch (InvocationTargetException unused6) {
                Log.w(f11220a, "com.huawei.decision.DecisionHelper.bindService() Invocation Target");
            }
        }
    }

    static /* synthetic */ int a(HwRollbackRuleDetector hwRollbackRuleDetector) {
        int i = hwRollbackRuleDetector.c;
        hwRollbackRuleDetector.c = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return this.c > 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        RollBackScrollListener rollBackScrollListener = this.g;
        return rollBackScrollListener != null && rollBackScrollListener.getScrollYDistance() > this.b;
    }

    private boolean c(Context context) {
        if (context != null) {
            return (Settings.Secure.getInt(context.getContentResolver(), "com.huawei.recsys.LMT_FeatureRecStatus", 0) & 1) != 1;
        }
        Log.w(f11220a, "isRollbackUnused context is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        View view = this.e;
        if (view != null) {
            this.b = view.getHeight() * 3;
        }
    }
}
