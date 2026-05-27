package health.compact.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import androidx.media3.common.C;
import com.huawei.haf.application.BroadcastManager;
import com.huawei.haf.common.dfx.memory.MemoryMonitor;
import com.huawei.haf.common.utils.ScreenUtil;
import com.huawei.haf.localbroadcastmanager.LocalBroadcastManager;
import com.huawei.health.connectivity.StepCounterManager;
import com.huawei.health.connectivity.extendstepcounter.ExtendStepCounter;
import com.huawei.health.connectivity.extendstepcounter.ExtendStepDataManager;
import com.huawei.health.connectivity.extendstepcounter.MidwareStepCounter;
import com.huawei.health.connectivity.standstepcounter.StandStepDataManager;
import com.huawei.health.icommon.HwHealthSensorEventListener;
import com.huawei.health.icommon.ISimpleResultCallback;
import com.huawei.health.icommon.IStepReport;
import com.huawei.health.icommon.LocalStepDataReport;
import com.huawei.health.icommon.SportIntensity;
import com.huawei.health.manager.LogicalStepCounter$ExtendStepMsg;
import com.huawei.health.manager.LogicalStepCounter$FlushDbMsg;
import com.huawei.health.manager.LogicalStepCounter$ReadStaticDealCallback;
import com.huawei.health.manager.MockStepHelper;
import com.huawei.health.manager.ScreenOnStatisticsUtil;
import com.huawei.health.manager.common.FlushableStepDataCache;
import com.huawei.health.manager.receiver.DaemonBrowseModeReceiver;
import com.huawei.health.manager.receiver.DaemonDynamicBroadcastReceiver;
import com.huawei.health.manager.util.Consts;
import com.huawei.health.manager.util.DeviceClassWatchDog;
import com.huawei.health.manager.util.GoalValue;
import com.huawei.health.manager.util.HiHealthHelper;
import com.huawei.health.manager.util.HuaweiServerTokenNotification;
import com.huawei.health.manager.util.SleepDataDbUtil;
import com.huawei.health.manager.util.TimeUtil;
import com.huawei.health.manager.util.TotalDetailStepsCacheBean;
import com.huawei.health.manager.util.UploadUtil;
import com.huawei.health.manager.util.UserInfo;
import com.huawei.health.provider.HealthFaDataExtendHelper;
import com.huawei.health.ui.notification.uihandlers.HealthStepsNotificationHelper;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.api.HiHealthManager;
import com.huawei.hihealth.api.HiHealthNativeApi;
import com.huawei.hihealth.data.listener.HiCommonListener;
import com.huawei.hihealth.data.listener.HiDataReadResultListener;
import com.huawei.hihealth.data.listener.HiSubscribeListener;
import com.huawei.hihealth.data.listener.HiUnSubscribeListener;
import com.huawei.hihealth.dictionary.utils.DicDataTypeUtil;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import com.huawei.thirdloginbasemodule.ThirdLoginDataStorageUtil;
import com.huawei.threecircle.ThreeCircleConfigUtil;
import com.huawei.threecircle.manager.WheelChairStateManager;
import com.huawei.utils.FoundationCommonUtil;
import com.huawei.watchface.api.HwWatchFaceApi;
import defpackage.hpn;
import defpackage.hql;
import defpackage.hum;
import defpackage.hun;
import defpackage.kpy;
import defpackage.kql;
import defpackage.mgx;
import defpackage.mmp;
import defpackage.par;
import defpackage.paw;
import defpackage.paz;
import health.compact.a.BroadcastManagerUtil;
import health.compact.a.LogicalStepCounter;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class LogicalStepCounter implements StandStepDataManager.IGetCacheTodaySteps {
    private static boolean b = false;
    private static LogicalStepCounter c = null;
    private static volatile boolean d = false;
    private static long f;
    private static long j;
    private HealthStepsNotificationHelper ab;
    private boolean ae;
    private ProcessAliveMonitor as;
    private ArrayList<Integer> bj;
    private StepsRecordManager bl;
    private DaemonDynamicBroadcastReceiver k;
    private DaemonBrowseModeReceiver m;
    private Context p;
    private GoalValue y;
    private static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f13766a = new Object();
    private static long i = System.currentTimeMillis();
    private StandStepCounter bd = null;
    private StandStepDataManager bh = null;
    private StepCounterManager bf = null;
    private ExtendStepCounter x = null;
    private ExtendStepDataManager w = null;
    private DistanceManager t = null;
    private CaloriesManager l = null;
    private boolean aj = false;
    private int bq = 0;
    private int ba = 0;
    private int n = 0;
    private int an = 0;
    private int be = 0;
    private int bc = 0;
    private int aw = 0;
    private int av = 0;
    private int at = 0;
    private int bb = 0;
    private int ax = 0;
    private int bn = 0;
    private double g = 0.0d;
    private UserInfo bp = null;
    private String q = "unKnown";
    private int ao = 0;
    private boolean ai = true;
    private boolean am = false;
    private boolean ad = false;
    private HandlerThread br = new HandlerThread("DaemonLogicStepCounter");
    private volatile Handler bo = null;
    private int az = 0;
    private int ap = 0;
    private long s = 0;
    private ISimpleResultCallback ac = null;
    private DeviceClassWatchDog o = null;
    private UploadUtil bm = null;
    private long bi = System.currentTimeMillis();
    private long aq = 0;
    private long r = 0;
    private long bg = 0;
    private boolean ak = false;
    private boolean ag = false;
    private AtomicBoolean h = new AtomicBoolean(false);
    private long al = -1;
    private ArrayList<IStepReport> au = new ArrayList<>(16);
    private AtomicBoolean af = new AtomicBoolean(false);
    private List<Integer> ay = null;
    private boolean z = false;
    private boolean u = false;
    private List<Integer> bk = null;
    private boolean ar = false;
    private boolean aa = AuthorizationUtils.a(BaseApplication.getContext());
    private final boolean ah = CommonUtil.bf();
    private BroadcastReceiver v = new BroadcastReceiver() { // from class: com.huawei.health.manager.LogicalStepCounter$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && HwWatchFaceApi.ACTION_FOREGROUND_STATUS.equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("isForeground", false);
                LogUtil.b("Step_LSC", "mForegroundStatusChangeReceiver() isForeground: ", Boolean.valueOf(booleanExtra));
                if (this.f2830a.ae == booleanExtra) {
                    return;
                }
                this.f2830a.ae = booleanExtra;
                if (this.f2830a.ae) {
                    ReleaseLogUtil.d("Step_LSC", "mIsForeground = true");
                    this.f2830a.aw();
                    if (this.f2830a.bo != null) {
                        this.f2830a.bo.sendEmptyMessageDelayed(1021, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    }
                    if (!paw.b(this.f2830a.p)) {
                        this.f2830a.d(false);
                    }
                    boolean zE = ScreenUtil.e();
                    LogUtil.b("Step_LSC", "isScreenOn", Boolean.valueOf(zE));
                    if (this.f2830a.ar && zE) {
                        this.f2830a.an();
                        return;
                    }
                    return;
                }
                LogicalStepCounter logicalStepCounter = this.f2830a;
                logicalStepCounter.d((List<Integer>) logicalStepCounter.ay);
            }
        }
    };

    private LogicalStepCounter(Context context) {
        this.bl = null;
        this.y = null;
        this.p = null;
        if (context == null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "LogicalStepCounter context is null.");
            this.p = BaseApplication.getContext();
        } else {
            this.p = context;
        }
        this.y = new GoalValue(this.p);
        StepsRecordManager stepsRecordManager = new StepsRecordManager();
        this.bl = stepsRecordManager;
        stepsRecordManager.d();
    }

    public static LogicalStepCounter d(Context context) {
        LogicalStepCounter logicalStepCounter;
        synchronized (e) {
            if (c == null) {
                c = new LogicalStepCounter(context);
            }
            logicalStepCounter = c;
        }
        return logicalStepCounter;
    }

    private void ao() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("com.huawei.health.WIDGET_ENABLE");
        intentFilter.addAction("com.huawei.health.WIDGET_DISABLE");
        intentFilter.addAction("com.huawei.health.WIDGET_FORCE_UPDATE");
        intentFilter.addAction("com.huawei.health.SERVER_TOKEN_INVALIDE");
        intentFilter.addAction("com.huawei.health.start_step_counter");
        intentFilter.addAction("com.huawei.health.check_sensor_state");
        intentFilter.addAction("com.huawei.health.action.ACTION_WEAR_DEVICE_CAPABILITY");
        intentFilter.addAction("com.huawei.health.AUTHORIZATION_CHANGED");
        intentFilter.addAction("com.huawei.health.SYNC_DB_FOR_DEVICE_CHANGE");
        this.k = new DaemonDynamicBroadcastReceiver(this);
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "registerDynamicBroadcastReceiver");
        Context context = this.p;
        if (context != null) {
            BroadcastManagerUtil.bLA_(context, this.k, intentFilter, Consts.f2863a, null);
            d = true;
        }
    }

    private void az() {
        if (this.p == null || this.k == null || !d) {
            return;
        }
        try {
            try {
                this.p.unregisterReceiver(this.k);
            } catch (IllegalArgumentException e2) {
                health.compact.a.hwlogsmodel.ReleaseLogUtil.c("Step_LSC", "Receiver already unregistered ", LogAnonymous.b(e2));
            }
        } finally {
            this.k = null;
            d = false;
        }
    }

    public void anj_(Intent intent) {
        if (this.bo != null && intent != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1007);
            messageObtainMessage.obj = intent.clone();
            this.bo.sendMessage(messageObtainMessage);
        } else {
            if (!CommonUtil.bv()) {
                hum.d(2);
            }
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "dealLogicalBroadcastEvent mWorkerHandler null");
        }
    }

    public void c(boolean z) {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "refreshBrowseModeStatus", Boolean.valueOf(z));
        this.ad = z;
        SharedPerferenceUtils.e(this.p, z);
        if (z) {
            this.bn = 0;
        } else {
            WheelChairStateManager.e().g();
            WheelChairStateManager.e().d();
        }
    }

    public boolean j() {
        return SharedPerferenceUtils.q(this.p);
    }

    public void d(int i2) {
        this.ap = i2;
    }

    public void b(ISimpleResultCallback iSimpleResultCallback) {
        HandlerThread handlerThread = this.br;
        String string = handlerThread == null ? "" : handlerThread.getState().toString();
        health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "init mWorkThread state:", string);
        try {
            HandlerThread handlerThread2 = this.br;
            if (handlerThread2 == null) {
                health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "init mWorkThread == null true");
                HandlerThread handlerThread3 = new HandlerThread("DaemonLogicStepCounter");
                this.br = handlerThread3;
                handlerThread3.start();
                hum.e(1, string);
            } else if (handlerThread2.getState() == Thread.State.NEW) {
                health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "init mWorkThread state new");
                this.br.start();
            } else if (!this.br.isAlive()) {
                health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "init mWorkThread state no isAlive");
                HandlerThread handlerThread4 = new HandlerThread("DaemonLogicStepCounter");
                this.br = handlerThread4;
                handlerThread4.start();
                hum.e(4, string);
            } else {
                hum.e(6, string);
                health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "init mWorkThread isAlive state");
                return;
            }
        } catch (IllegalThreadStateException e2) {
            hum.e(3, string);
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "WorkThread.start illegalThreadStateException:", string, LogAnonymous.b(e2));
        }
        Looper looper = this.br.getLooper();
        if (looper == null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "init looper == null", string);
            hum.e(5, string);
        }
        final Looper looper2 = (Looper) Objects.requireNonNull(looper);
        this.bo = new Handler(looper2) { // from class: com.huawei.health.manager.LogicalStepCounter$2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.d.amT_(message)) {
                    return;
                }
                super.handleMessage(message);
            }
        };
        Message messageObtainMessage = this.bo.obtainMessage();
        messageObtainMessage.what = 1018;
        messageObtainMessage.obj = iSimpleResultCallback;
        this.bo.sendMessage(messageObtainMessage);
    }

    private void amZ_(Message message) {
        this.as = ProcessAliveMonitor.b(this.p);
        if (!(message.obj instanceof ISimpleResultCallback)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "processInit ", "msg.obj invalid type");
            return;
        }
        ISimpleResultCallback iSimpleResultCallback = (ISimpleResultCallback) message.obj;
        Context context = this.p;
        if (context != null) {
            this.al = SharedPerferenceUtils.m(context);
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "init ....", iSimpleResultCallback);
            this.ac = iSimpleResultCallback;
            UserInfo.e(this.p);
            this.bp = UserInfo.c();
        }
        this.bm = new UploadUtil(this.p, this.q, this.bo);
        x();
        this.ad = Utils.i();
        b = StepCounterSupport.a(this.p);
        SharedPerferenceUtils.e(this.p, this.ad);
        health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "init mIsBrowseMode", Boolean.valueOf(this.ad), " sIsRemoveReduceClass ", Boolean.valueOf(b));
        ao();
        ar();
        if (AuthorizationUtils.a(this.p) && CommonUtil.r(BaseApplication.getContext())) {
            aw();
        } else {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "subscribeSportData hasAuth or appOnForeground false");
        }
        BroadcastManager.xN_(this.v);
        boolean zU = u();
        DistanceManager distanceManagerE = DistanceManager.e(this.p);
        this.t = distanceManagerE;
        this.l = CaloriesManager.b(this.p, distanceManagerE, this.w);
        TotalDetailStepsCacheBean totalDetailStepsCacheBeanY = SharedPerferenceUtils.y(this.p);
        if (totalDetailStepsCacheBeanY != null && kql.c(totalDetailStepsCacheBeanY.g(), System.currentTimeMillis())) {
            this.bb = totalDetailStepsCacheBeanY.b();
            this.ax = totalDetailStepsCacheBeanY.d();
        }
        if (this.bo != null) {
            this.bo.sendEmptyMessage(1008);
        }
        if (!zU) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "isInitStepCounterStatus false");
            return;
        }
        hpn.a().d();
        hpn.a().c();
        if (this.bo != null) {
            this.bo.sendEmptyMessage(1006);
            this.bo.sendEmptyMessageDelayed(101010, 10000L);
        }
    }

    private void x() {
        String[] strArrF;
        Context context = this.p;
        if (context == null || (strArrF = SharedPerferenceUtils.f(context)) == null) {
            return;
        }
        try {
            if (strArrF.length < 2 || !kql.c(System.currentTimeMillis(), Long.parseLong(strArrF[0]))) {
                return;
            }
            this.g = Double.parseDouble(strArrF[1]);
        } catch (NumberFormatException e2) {
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "initDiffAltitudefromFile ", e2.getMessage());
        }
    }

    private void e(int i2) {
        Context context = this.p;
        if (context != null) {
            this.g += (double) (i2 - this.at);
            SharedPerferenceUtils.c(context, System.currentTimeMillis(), this.g);
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "saveDiffAltitudeToFile total db", LogAnonymous.d(i2), " mAltitudeDiff ", LogAnonymous.d((int) this.g));
        }
    }

    private boolean u() {
        MockStepHelper mockStepHelper;
        this.bf = new StepCounterManager(this.p);
        boolean zA = MockStepHelper.a(this.p);
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "initStepCounter isSupportMockStepCounter = ", Boolean.valueOf(zA));
        if (zA) {
            mockStepHelper = new MockStepHelper(this.p);
            mockStepHelper.c();
            this.bd = this.bf.c(true);
            ExtendStepCounter extendStepCounterE = this.bf.e(true);
            this.x = extendStepCounterE;
            mockStepHelper.d(this.bd, extendStepCounterE);
        } else {
            this.bd = this.bf.d();
            this.x = this.bf.e(false);
            mockStepHelper = null;
        }
        if (StepCounterSupport.g(this.p)) {
            this.am = true;
            this.w = new ExtendStepDataManager(this.p);
            this.o = new DeviceClassWatchDog(this.p);
            this.x.init(this.ac);
        } else if (mockStepHelper != null) {
            if (mockStepHelper.a()) {
                this.ac.onSuccess(null);
            }
        } else if (StepCounterSupport.j(this.p)) {
            this.ac.onSuccess(null);
        } else {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "do nothing");
        }
        StandStepDataManager standStepDataManager = new StandStepDataManager();
        this.bh = standStepDataManager;
        standStepDataManager.d(this.ap);
        return this.bd != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amT_(Message message) {
        if (message == null) {
            return false;
        }
        boolean zAmX_ = amX_(message);
        return !zAmX_ ? amY_(message) : zAmX_;
    }

    private boolean amX_(Message message) {
        int i2 = message.what;
        if (i2 == 1000) {
            ang_(message);
        } else if (i2 == 1001) {
            amU_(message);
        } else if (i2 == 1003) {
            ae();
        } else if (i2 == 1004) {
            amV_(message);
        } else if (i2 == 1010) {
            ae();
        } else if (i2 == 1016) {
            ane_(message);
        } else {
            if (i2 != 1018) {
                return false;
            }
            amZ_(message);
        }
        return true;
    }

    private boolean amY_(Message message) {
        int i2 = message.what;
        if (i2 == 1017) {
            ana_(message);
        } else if (i2 != 101010) {
            switch (i2) {
                case 1005:
                    anh_(message);
                    break;
                case 1006:
                    anc_(message);
                    break;
                case 1007:
                    if (!(message.obj instanceof Intent)) {
                        return false;
                    }
                    amW_((Intent) message.obj);
                    break;
                    break;
                case 1008:
                    w();
                    break;
                default:
                    switch (i2) {
                        case 1011:
                            ah();
                            break;
                        case 1012:
                            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "sync with db");
                            a(new ISimpleResultCallback(this) { // from class: com.huawei.health.manager.LogicalStepCounter$FlushCallbackInter
                                private WeakReference<LogicalStepCounter> e;

                                {
                                    this.e = null;
                                    this.e = new WeakReference<>(this);
                                }

                                @Override // com.huawei.health.icommon.ISimpleResultCallback
                                public void onSuccess(Bundle bundle) {
                                    LogicalStepCounter logicalStepCounter;
                                    LogUtil.b("Step_LSC", "FlushCallbackInter onSuccess.");
                                    WeakReference<LogicalStepCounter> weakReference = this.e;
                                    if (weakReference == null || (logicalStepCounter = weakReference.get()) == null) {
                                        return;
                                    }
                                    logicalStepCounter.q();
                                }

                                @Override // com.huawei.health.icommon.ISimpleResultCallback
                                public void onFailed(Bundle bundle) {
                                    LogicalStepCounter logicalStepCounter;
                                    ReleaseLogUtil.a("Step_LSC", "FlushCallbackInter onFailed, continue work");
                                    WeakReference<LogicalStepCounter> weakReference = this.e;
                                    if (weakReference == null || (logicalStepCounter = weakReference.get()) == null) {
                                        return;
                                    }
                                    logicalStepCounter.q();
                                }
                            }, false, false);
                            break;
                        case 1013:
                            an();
                            break;
                        default:
                            switch (i2) {
                                case 1019:
                                    am();
                                    break;
                                case 1020:
                                    anf_(message);
                                    break;
                                case 1021:
                                    al();
                                    break;
                                case 1022:
                                    c(message.arg1, message.arg2, ((Long) message.obj).longValue());
                                    break;
                                default:
                                    return false;
                            }
                            break;
                    }
                    break;
            }
        } else {
            hpn.a().b();
        }
        return true;
    }

    private void am() {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", " processSportIntensity ");
        SportIntensity.e(this.p).e(3);
    }

    private void ane_(Message message) {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "user info change");
        Object obj = message.obj;
        Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
        if (bundle == null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "processSetUserInfoByMessage userInfo is null.");
            return;
        }
        e(false);
        a(null, false, true);
        this.bp.b(bundle.get("weight") != null ? ((Float) bundle.get("weight")).floatValue() : this.bp.f(), bundle.get("height") != null ? ((Float) bundle.get("height")).floatValue() : this.bp.e(), bundle.get("ownerId") != null ? ((Integer) bundle.get("ownerId")).intValue() : this.bp.d(), bundle.get(CommonConstant.KEY_GENDER) != null ? ((Integer) bundle.get(CommonConstant.KEY_GENDER)).intValue() : this.bp.a(), bundle.get("age") != null ? ((Integer) bundle.get("age")).intValue() : this.bp.b());
    }

    public HwHealthSensorEventListener c() {
        return this.bd;
    }

    private void ang_(Message message) {
        if (this.h.get()) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "onStandStepChanged phone shutdown, return");
            return;
        }
        if (message.obj == null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "processStandDealStepDate msg.obj is null.");
            return;
        }
        long jLongValue = ((Long) message.obj).longValue();
        int i2 = message.arg1;
        int i3 = message.arg2;
        a(i2);
        c(i2);
        this.be = i2;
        if (!this.af.get()) {
            Object obj = f13766a;
            synchronized (obj) {
                this.af.set(true);
                obj.notifyAll();
            }
        }
        isProcessNewDayReport(false);
        long jE = com.huawei.hwlogsmodel.LogUtil.e(5000, f);
        if (jE != -1) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", mmp.b("onSStepChgd ", Integer.valueOf(i2), " se ", Integer.valueOf(i3)));
            f = jE;
        }
        j(i2);
        b(i2);
        h(i2);
        if (this.bm.c(i2)) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "flushTempCacheToDB by stand");
            e((ISimpleResultCallback) null);
        }
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager != null) {
            standStepDataManager.b(jLongValue, i2);
            com.huawei.hwlogsmodel.LogUtil.e("Step_LSC", "mPreDaemonSteps :", Integer.valueOf(this.ap));
            if (this.bh.d() > 0) {
                this.bh.d(0);
            }
        }
        if (this.bo != null) {
            this.bo.sendEmptyMessageDelayed(1006, 300L);
        }
    }

    private void j(int i2) {
        if (System.currentTimeMillis() - i > 86400000) {
            b = StepCounterSupport.a(this.p);
            i = System.currentTimeMillis();
        }
        if (b) {
            return;
        }
        long jE = com.huawei.hwlogsmodel.LogUtil.e(2000, j);
        if (jE != -1) {
            g(i2);
            j = jE;
        }
    }

    private void a(int i2) {
        int i3;
        if (this.z || (i3 = this.be) == 0 || i2 <= i3) {
            return;
        }
        health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "processStandDealStepDate initModule enter ");
        SportIntensity.e(this.p).b();
        HiHealthNativeApi.e(this.p).subscribeHiHealthData(4, new HiSubscribeListener(this) { // from class: com.huawei.health.manager.LogicalStepCounter$SportIntensityCallback
            private WeakReference<LogicalStepCounter> e;

            {
                this.e = null;
                this.e = new WeakReference<>(this);
            }

            @Override // com.huawei.hihealth.data.listener.HiSubscribeListener
            public void onResult(List<Integer> list, List<Integer> list2) {
                LogicalStepCounter logicalStepCounter = this.e.get();
                if (logicalStepCounter == null) {
                    LogUtil.a("Step_LSC", "logicalStepCounter == null");
                } else if (mgx.e(list)) {
                    logicalStepCounter.bk = list;
                }
            }

            @Override // com.huawei.hihealth.data.listener.HiSubscribeListener
            public void onChange(int i4, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j2) {
                ReleaseLogUtil.d("Step_LSC", "SportIntensityCallback ");
                WeakReference<LogicalStepCounter> weakReference = this.e;
                if (weakReference != null) {
                    LogicalStepCounter logicalStepCounter = weakReference.get();
                    if (logicalStepCounter == null || logicalStepCounter.bo == null) {
                        return;
                    }
                    logicalStepCounter.bo.sendEmptyMessage(1019);
                    return;
                }
                ReleaseLogUtil.a("Step_LSC", "mLogicalStepCounterRef == null");
            }
        });
        this.z = true;
    }

    private void c(int i2) {
        int i3;
        if (this.u || (i3 = this.be) == 0 || i2 <= i3) {
            return;
        }
        health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "processStandDealStepDate refreshMotion enter ");
        d(false);
        this.u = true;
    }

    private void amV_(Message message) {
        Object obj = message.obj;
        LogicalStepCounter$ExtendStepMsg logicalStepCounter$ExtendStepMsg = obj instanceof LogicalStepCounter$ExtendStepMsg ? (LogicalStepCounter$ExtendStepMsg) obj : null;
        if (logicalStepCounter$ExtendStepMsg != null && this.w != null) {
            new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ").format(new Date(logicalStepCounter$ExtendStepMsg.f2832a));
            this.w.d(this.bp.d(), logicalStepCounter$ExtendStepMsg.f2832a, logicalStepCounter$ExtendStepMsg.b, logicalStepCounter$ExtendStepMsg.e, logicalStepCounter$ExtendStepMsg.c);
        }
        if (this.bo == null || this.bo.hasMessages(1006)) {
            return;
        }
        this.bo.sendEmptyMessageDelayed(1006, 300L);
    }

    private void ae() {
        ExtendStepDataManager extendStepDataManager = this.w;
        if (extendStepDataManager != null) {
            extendStepDataManager.a();
        }
    }

    private void anh_(Message message) {
        if (message.arg1 == 100) {
            at();
        } else if (message.arg1 == 101) {
            ax();
        } else {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "processStepCounterSateChange default.");
        }
    }

    private void amU_(Message message) {
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager != null && standStepDataManager.e() < getCacheTodaySteps()) {
            q();
        } else {
            e(false);
        }
        if (message.obj instanceof LogicalStepCounter$FlushDbMsg) {
            a(((LogicalStepCounter$FlushDbMsg) message.obj).b, false, false);
        } else {
            a(null, false, false);
        }
    }

    public void c(Map<String, Object> map) {
        SleepDataDbUtil.d(this.p, map);
    }

    public void q() {
        if (this.bo != null && ScreenUtil.e()) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "ScreenON ,MSG_SYNC_WITH_DB");
            aq();
            this.bo.sendEmptyMessage(1013);
            this.al = -1L;
            SharedPerferenceUtils.e(this.p, -1L);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.al = jCurrentTimeMillis;
        SharedPerferenceUtils.e(this.p, jCurrentTimeMillis);
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "ScreenOFF ,drop this time MSG_SYNC_WITH_DB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        this.ar = false;
        ExtendStepCounter extendStepCounter = this.x;
        if ((extendStepCounter instanceof MidwareStepCounter) && !((MidwareStepCounter) extendStepCounter).d() && this.bo != null) {
            this.bo.sendEmptyMessageDelayed(1013, 500L);
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "processSyncStepsWithHiHealth times check");
        HiHealthNativeApi.e(this.p).aggregateHiHealthData(HiHealthHelper.b(), new LogicalStepCounter$ReadStaticDealCallback(this, 1017));
        if (!CommonUtil.be()) {
            v();
        }
        this.y.d();
    }

    private void v() {
        HiDataReadOption hiDataReadOption = new HiDataReadOption();
        long jCurrentTimeMillis = System.currentTimeMillis();
        hiDataReadOption.setTimeInterval(kql.r(jCurrentTimeMillis), kql.a(jCurrentTimeMillis));
        hiDataReadOption.setType(new int[]{901});
        HiHealthNativeApi.e(this.p).readHiHealthData(hiDataReadOption, new HiDataReadResultListener(this) { // from class: com.huawei.health.manager.LogicalStepCounter$ReadDeviceStepCallback
            private WeakReference<LogicalStepCounter> b;

            @Override // com.huawei.hihealth.data.listener.HiDataReadResultListener
            public void onResultIntent(int i2, Object obj, int i3, int i4) {
            }

            {
                this.b = null;
                this.b = new WeakReference<>(this);
            }

            @Override // com.huawei.hihealth.data.listener.HiDataReadResultListener
            public void onResult(Object obj, int i2, int i3) {
                Object[] objArr = new Object[4];
                objArr[0] = "getStepCounterDetails, errorCode = ";
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = " data ";
                objArr[3] = obj != null ? obj.toString() : null;
                LogUtil.b("Step_LSC", objArr);
                if (i2 != 0) {
                    LogUtil.a("Step_LSC", "Error query step counter, errorCode = ", Integer.valueOf(i2));
                    return;
                }
                List<HiHealthData> list = (List) ((SparseArray) obj).get(901);
                if (mgx.d(list)) {
                    ReleaseLogUtil.d("Step_LSC", "ReadDeviceStepCallback hiHealthDataList isEmpty");
                    c(0);
                    return;
                }
                for (HiHealthData hiHealthData : list) {
                    if (hiHealthData != null && hun.b(hiHealthData.getString("device_uniquecode"))) {
                        c((int) hiHealthData.getFloatValue());
                    }
                }
            }

            private void c(int i2) {
                LogicalStepCounter logicalStepCounter = this.b.get();
                if (logicalStepCounter == null || logicalStepCounter.bh == null) {
                    return;
                }
                logicalStepCounter.bh.c(i2);
            }
        });
    }

    private void d(int i2, int i3, long j2) {
        e(false);
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager != null) {
            if (standStepDataManager.e() == i2) {
                if (this.bh.e(i2)) {
                    aq();
                    return;
                }
                return;
            }
            if (this.bd != null && !this.ah && i2 > this.bh.e() && this.bo != null) {
                this.bd.e();
                if (this.bo.hasMessages(1022)) {
                    this.bo.removeMessages(1022);
                }
                health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "syncWithHiHealth send message MSG_SYNC_DIFF_DATA_DELAY");
                Message messageObtainMessage = this.bo.obtainMessage(1022);
                messageObtainMessage.arg1 = i2;
                messageObtainMessage.arg2 = i3;
                messageObtainMessage.obj = Long.valueOf(j2);
                this.bo.sendMessageDelayed(messageObtainMessage, 500L);
                return;
            }
            if (!kql.c(j2, System.currentTimeMillis())) {
                health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "syncWithHiHealth data not same day,return dataStartTime:", Long.valueOf(j2));
            } else if (this.bh.e(i2)) {
                this.ba = i3;
            } else {
                health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "syncWithHiHealth localTotalSteps > dBTotalSteps");
                r();
            }
        }
    }

    private void c(int i2, int i3, long j2) {
        if (!kql.c(j2, System.currentTimeMillis())) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "calculateDiffForDb data not same day,return dataStartTime:", Long.valueOf(j2));
            return;
        }
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager == null || !standStepDataManager.e(i2)) {
            return;
        }
        this.ba = i3;
        isProcessNewDayReport(false);
    }

    private void amW_(Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "processHandleBroadcastAction action:", action);
                if ("android.intent.action.SCREEN_ON".equals(action)) {
                    ac();
                } else if ("android.intent.action.TIME_TICK".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "ACTION_TIME_TICK");
                    ad();
                } else if ("android.intent.action.ACTION_SHUTDOWN".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "ACTION_SHUTDOWN");
                    ai();
                } else if ("com.huawei.health.WIDGET_FORCE_UPDATE".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "ACTION_HEALTH_WIDGET_FORCE_UPDATE");
                    z();
                } else if ("com.huawei.hihealth.action_today_sport_data_refresh".equals(action)) {
                    anb_(intent);
                } else if ("android.intent.action.TIME_SET".equals(action)) {
                    ak();
                } else if ("com.huawei.health.action.UPLOAD_STATICS".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "ACTION_RESTART_SENSOR_MSG");
                    and_(intent);
                } else if ("com.huawei.health.SERVER_TOKEN_INVALIDE".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "ACTION_HEALTH_SERVER_TOKEN_INVALIDE");
                    HuaweiServerTokenNotification.b(this.p);
                } else if ("event_manual_ui".equals(action)) {
                    SportIntensity.e(this.p).e(4);
                } else if ("com.huawei.health.action.ACTION_WEAR_DEVICE_CAPABILITY".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "ACTION_WEAR_DEVICE_CAPABILITY");
                    ani_(intent);
                } else if ("com.huawei.health.start_step_counter".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "START_STEP_COUNTER");
                    kpy.a().d(20220112);
                    if (StepCounterSupportUtils.j(this.p)) {
                        m();
                    } else {
                        aj();
                    }
                } else if ("com.huawei.health.check_sensor_state".equals(action)) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "CHECK_SENSOR_STATE");
                    s();
                } else if ("com.huawei.health.AUTHORIZATION_CHANGED".equals(action)) {
                    ab();
                } else if ("com.huawei.health.SYNC_DB_FOR_DEVICE_CHANGE".equals(action)) {
                    if (this.ae && ScreenUtil.e()) {
                        an();
                    } else {
                        this.ar = true;
                    }
                } else {
                    com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "processHandleBroadcastAction intent does not match");
                }
            } catch (BadParcelableException e2) {
                com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", e2.getMessage());
            }
        }
    }

    private void ab() {
        boolean zA = AuthorizationUtils.a(this.p);
        this.aa = zA;
        health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "processAuthChanged AuthorizationStatus = ", Boolean.valueOf(zA));
        if (zA) {
            if (StepCounterSupportUtils.b(this.p)) {
                m();
                StepCounterSupport.e(this.p, -1);
            }
            w();
            d(this.ay);
            aw();
            WheelChairStateManager.e().g();
            WheelChairStateManager.e().d();
            return;
        }
        if (StepCounterSupportUtils.b(this.p)) {
            p();
        }
    }

    public boolean e() {
        return this.aa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw() {
        ArrayList<Integer> arrayList = new ArrayList<>(16);
        this.bj = arrayList;
        arrayList.add(1);
        if (!paw.b(this.p)) {
            this.bj.add(Integer.valueOf(DicDataTypeUtil.DataType.ACTIVE_HOUR.value()));
            this.bj.add(103);
        }
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "mTypeList is ", this.bj);
        HiHealthNativeApi.e(this.p).subscribeHiHealthData(this.bj, new HiSubscribeListener(this) { // from class: com.huawei.health.manager.LogicalStepCounter$SportDataCallback
            private WeakReference<LogicalStepCounter> e;

            {
                this.e = new WeakReference<>(this);
            }

            @Override // com.huawei.hihealth.data.listener.HiSubscribeListener
            public void onResult(List<Integer> list, List<Integer> list2) {
                LogicalStepCounter logicalStepCounter = this.e.get();
                if (logicalStepCounter == null) {
                    LogUtil.j("Step_LSC", "onResult logicalStepCounter == null");
                } else {
                    if (mgx.d(list)) {
                        return;
                    }
                    ReleaseLogUtil.d("Step_LSC", "SportDataCallback success");
                    logicalStepCounter.ay = list;
                }
            }

            @Override // com.huawei.hihealth.data.listener.HiSubscribeListener
            public void onChange(int i2, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j2) {
                Object[] objArr = new Object[10];
                objArr[0] = "SportIntensityCallback ";
                objArr[1] = hiHealthData == null ? null : hiHealthData.toString();
                objArr[2] = " type ";
                objArr[3] = Integer.valueOf(i2);
                objArr[4] = " client ";
                objArr[5] = hiHealthClient != null ? hiHealthClient.getHuid() : null;
                objArr[6] = "changeKey ";
                objArr[7] = str;
                objArr[8] = " time ";
                objArr[9] = Long.valueOf(j2);
                LogUtil.b("Step_LSC", objArr);
                if (i2 == 1) {
                    LogicalStepCounter logicalStepCounter = this.e.get();
                    if (logicalStepCounter != null) {
                        if (logicalStepCounter.bo.hasMessages(1021)) {
                            return;
                        }
                        logicalStepCounter.bo.sendEmptyMessageDelayed(1021, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                        return;
                    }
                    LogUtil.j("Step_LSC", "logicalStepCounter == null");
                    return;
                }
                if (i2 == DicDataTypeUtil.DataType.ACTIVE_HOUR.value()) {
                    LogicalStepCounter logicalStepCounter2 = this.e.get();
                    if (logicalStepCounter2 != null) {
                        logicalStepCounter2.al();
                        return;
                    } else {
                        LogUtil.j("Step_LSC", "logicalStepCounter == null");
                        return;
                    }
                }
                if (i2 == 103) {
                    LogicalStepCounter logicalStepCounter3 = this.e.get();
                    if (logicalStepCounter3 == null) {
                        LogUtil.j("Step_LSC", "logicalStepCounter is null");
                        return;
                    }
                    if ("900200006".equals(str) || "900200008".equals(str) || "900200009".equals(str) || "900200007".equals(str)) {
                        logicalStepCounter3.k();
                        logicalStepCounter3.d(true);
                        logicalStepCounter3.d(str);
                    } else if ("900200004".equals(str) || "900200010".equals(str) || "900200011".equals(str)) {
                        logicalStepCounter3.d(str);
                        logicalStepCounter3.e(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if ("900200004".equals(str)) {
            SharedPreferenceManager.d("fitness_step_module_id", "active_hours_set_alert_toggle", "1".equals(hql.d(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        HiHealthNativeApi.e(this.p).aggregateHiHealthData(HiHealthHelper.b(), new LogicalStepCounter$ReadStaticDealCallback(this, 1020));
    }

    private void ac() {
        ag();
        ThirdLoginDataStorageUtil.getAccessTokenFromDb();
        av();
        ScreenOnStatisticsUtil.d(this.p);
    }

    private void ad() {
        af();
        if (isProcessNewDayReport(false)) {
            SportIntensityUtil.c();
        }
        aa();
        t();
        as();
    }

    private void as() {
        if (System.currentTimeMillis() - SharedPreferenceManager.c("MODULE_DEAMON_SERVER", "KEY_BI_STEP_NOTIFICATION", 0L) <= 86400000) {
            return;
        }
        SharedPreferenceManager.e("MODULE_DEAMON_SERVER", "KEY_BI_STEP_NOTIFICATION", System.currentTimeMillis());
        hum.a(SharedPerferenceUtils.s(this.p));
    }

    private void aj() {
        if (!StepCounterSupportUtils.e(this.p)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", " processStartStepCounter failed with cant step counter.");
            return;
        }
        StandStepCounter standStepCounter = this.bd;
        if (standStepCounter != null) {
            standStepCounter.c();
        }
    }

    private void and_(Intent intent) {
        String stringExtra = intent.getStringExtra("extra_user_intent");
        if (stringExtra != null) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "ACTION_RESTART_SENSOR_MSG userIntent:", stringExtra);
            StandStepCounter standStepCounter = this.bd;
            if (standStepCounter != null) {
                standStepCounter.e();
            }
            if ("extra_user_intent_pre_alarm".equals(stringExtra)) {
                r();
            }
        }
    }

    private void ani_(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("WEAR_DEVICE_CAPBILITY", false);
        String[] strArrAd = SharedPerferenceUtils.ad(this.p);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (strArrAd != null) {
            try {
                if (strArrAd.length <= 0 || kql.c(jCurrentTimeMillis, Long.parseLong(strArrAd[0]))) {
                    return;
                }
                com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "processWearDeviceCapability wearDeviceCapability ", strArrAd);
                SharedPerferenceUtils.c(this.p, booleanExtra, jCurrentTimeMillis);
            } catch (NumberFormatException e2) {
                com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "processWearDeviceCapability Exception = ", e2.getMessage());
            }
        }
    }

    private void z() {
        if (this.bo != null) {
            this.bo.sendMessage(this.bo.obtainMessage(1006));
        }
    }

    private void anb_(Intent intent) {
        int intExtra = intent.getIntExtra("refresh_type", 0);
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "ACTION_SYNC_WITH_DB refreshType", Integer.valueOf(intExtra));
        if (intExtra == 0) {
            if (this.bo != null) {
                this.bo.sendMessage(this.bo.obtainMessage(1012));
                y();
                return;
            }
            return;
        }
        if (intExtra == 2) {
            if (this.bo != null) {
                this.bo.sendMessage(this.bo.obtainMessage(1012));
                return;
            }
            return;
        }
        if (intExtra == 5) {
            if (this.bo != null) {
                y();
            }
        } else {
            if (intExtra == 7) {
                Intent intent2 = new Intent("DaemonService_LocalBroadcast");
                intent2.setPackage(this.p.getPackageName());
                intent2.putExtra("refresh_type", 7);
                LocalBroadcastManager.getInstance().sendBroadcast(intent2);
                return;
            }
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "ACTION_SYNC_WITH_DB no refreshType");
        }
    }

    private void ak() {
        if (kql.c(this.bi, System.currentTimeMillis())) {
            return;
        }
        a(null, true, false);
        ExtendStepDataManager extendStepDataManager = this.w;
        if (extendStepDataManager != null) {
            extendStepDataManager.e();
        }
        isProcessNewDayReport(true);
        q();
    }

    private void ag() {
        StandStepCounter standStepCounter = this.bd;
        if (standStepCounter != null) {
            standStepCounter.a();
        }
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "processScreenOn :", Long.valueOf(this.al), Long.valueOf(System.currentTimeMillis()));
        long j2 = this.al;
        if (j2 != -1 && j2 <= System.currentTimeMillis() && this.bo != null) {
            this.al = -1L;
            if (this.bo.hasMessages(1012)) {
                this.bo.removeMessages(1012);
            }
            this.bo.sendEmptyMessageDelayed(1012, 1000L);
        }
        if (!isProcessNewDayReport(false) && this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1006);
            messageObtainMessage.arg1 = 200;
            messageObtainMessage.arg2 = 201;
            this.bo.sendMessage(messageObtainMessage);
        }
        HealthFaDataExtendHelper.c().e();
        s();
    }

    private void s() {
        if (StepCounterSupportUtils.j(this.p)) {
            if (StandStepCounter.d() || MidwareStepCounter.b()) {
                return;
            }
            boolean z = ContextCompat.checkSelfPermission(this.p, "android.permission.ACTIVITY_RECOGNITION") == 0;
            health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", " isModelControlledByPermission permission is granted ", Boolean.valueOf(z));
            if (z) {
                m();
                return;
            }
            return;
        }
        if (StandStepCounter.d()) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "sensor register successfully");
            return;
        }
        try {
            boolean z2 = ContextCompat.checkSelfPermission(this.p, "android.permission.ACTIVITY_RECOGNITION") == 0;
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", " permission is granted ", Boolean.valueOf(z2));
            if (z2) {
                aj();
            }
        } catch (SecurityException unused) {
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "checkRegisterSensor SecurityException ");
        }
    }

    private void ai() {
        this.h.set(true);
        if (this.bo != null) {
            this.bo.sendEmptyMessage(1003);
            this.bo.sendEmptyMessage(1012);
        }
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager != null) {
            standStepDataManager.d(this.bq, this.ba, this.n, this.bb, this.ax);
        }
    }

    private void ana_(Message message) {
        if (!mgx.e(message.obj, HiHealthData.class)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "processReadCallback ", "msg.obj invalid type");
            return;
        }
        List list = (List) message.obj;
        if (list.size() == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        long startTime = hiHealthData.getStartTime();
        if (!kql.c(startTime, jCurrentTimeMillis)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "data not same day,return dataStartTime:", Long.valueOf(startTime));
            return;
        }
        int i2 = hiHealthData.getInt("run_step");
        int i3 = hiHealthData.getInt(ParsedFieldTag.STEP_SUM);
        int i4 = hiHealthData.getInt("calorie_sum");
        int i5 = hiHealthData.getInt("altitude_sum");
        int i6 = hiHealthData.getInt("distance_sum");
        int i7 = hiHealthData.getInt("intensity_time");
        int i8 = hiHealthData.getInt("active_hours");
        int i9 = hiHealthData.getInt("wheel_chair");
        if (this.bh != null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "procRCallback ", Integer.valueOf(i3), " insity ", Integer.valueOf(i7), " ActHs ", Integer.valueOf(i8), "totalCalories ", Integer.valueOf(i4), "wc:", Integer.valueOf(i9));
            d(i3, i2, startTime);
            this.t.e(i3, i6);
            this.l.d(jCurrentTimeMillis, i3, i4);
            this.bb = i7;
            this.ax = Math.min(i8, 24);
            this.bn = i9;
            e(i5);
            aq();
            this.bh.b(System.currentTimeMillis());
        }
    }

    private void anf_(Message message) {
        if (!mgx.e(message.obj, HiHealthData.class)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "processReadCallback ", "msg.obj invalid type");
            return;
        }
        List list = (List) message.obj;
        if (list.size() == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        if (!kql.c(hiHealthData.getStartTime(), jCurrentTimeMillis)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "data not same day,return");
            return;
        }
        int i2 = hiHealthData.getInt(ParsedFieldTag.STEP_SUM);
        hiHealthData.getInt("calorie_sum");
        int i3 = hiHealthData.getInt("intensity_time");
        int i4 = hiHealthData.getInt("active_hours");
        int i5 = hiHealthData.getInt("wheel_chair");
        this.bb = i3;
        this.ax = Math.min(i4, 24);
        this.bn = i5;
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "processSportDataCallback ", Integer.valueOf(i2), " totalIntensity ", Integer.valueOf(i3), " totalActiveHours ", Integer.valueOf(i4), "wheelChair ", Integer.valueOf(i5));
        e(true);
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager != null) {
            standStepDataManager.b(System.currentTimeMillis());
        }
    }

    private void af() {
        if (!AuthorizationUtils.a(this.p)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "processMemoryCheck hasAuth false");
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "alreadySport", KeyValDbManager.e(this.p).a("already_sport"));
        MemoryMonitor.e(!String.valueOf(true).equals(r0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        if (this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1006);
            messageObtainMessage.arg1 = 200;
            this.bo.sendMessage(messageObtainMessage);
        }
    }

    private void anc_(Message message) {
        if (this.bo != null) {
            this.bo.removeMessages(1006);
        }
        boolean z = message.arg2 != 201 ? message.arg1 == 200 : true;
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager == null || standStepDataManager.e() < 0) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "MSG_REPORT_STEP_DATA dropreport ");
            this.bc = 0;
            this.aw = 0;
            this.av = 0;
            this.at = 0;
            return;
        }
        e(z);
    }

    public void a(LocalStepDataReport localStepDataReport) {
        if (localStepDataReport != null) {
            this.bl.e(localStepDataReport);
        }
    }

    public void b(boolean z) {
        this.am = z;
    }

    public StandStepDataManager.e i() {
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager != null) {
            return standStepDataManager.f();
        }
        return new StandStepDataManager.e();
    }

    public void l() {
        StandStepCounter standStepCounter = this.bd;
        if (standStepCounter != null) {
            standStepCounter.e();
        }
    }

    private void a(int i2, long j2) {
        if (kql.c(j2, ((long) i2) * 60000)) {
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "refreshCheckNewDay: new day, detailDataTimestamp is ", Long.valueOf(j2));
        isProcessNewDayReport(false);
    }

    private void e(boolean z) {
        long j2;
        if (this.bh == null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.c("Step_LSC", "refreshReportData: mStandStepDataManager == null");
            return;
        }
        if (!z && isProcessNewDayReport(false)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "isNextDay, not refresh ");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iD = (int) TimeUtil.d(jCurrentTimeMillis);
        String[] strArrX = SharedPerferenceUtils.x(this.p);
        TotalDetailStepsCacheBean totalDetailStepsCacheBeanY = SharedPerferenceUtils.y(this.p);
        if (totalDetailStepsCacheBeanY != null) {
            j2 = totalDetailStepsCacheBeanY.g();
        } else {
            j2 = strArrX != null ? CommonUtil.j(strArrX[0]) : 0L;
        }
        a(iD, j2);
        this.bc = this.bh.e();
        this.az = iD;
        c(iD - 1, strArrX);
        this.av = this.t.b(this.bc);
        this.aw = this.l.b(jCurrentTimeMillis, this.bc);
        if (this.am) {
            this.at = (int) this.w.c();
        } else {
            this.at = 0;
        }
        this.at = (int) (((double) this.at) + this.g);
        StepsRecord stepsRecord = new StepsRecord();
        stepsRecord.j = this.bc;
        stepsRecord.c = this.bh.h();
        stepsRecord.f13778a = this.aw;
        stepsRecord.b = this.av;
        stepsRecord.e = this.at;
        stepsRecord.h = this.y.c();
        stepsRecord.i = this.bb;
        stepsRecord.d = this.ax;
        stepsRecord.g = this.bn;
        this.bm.e(stepsRecord);
        this.bl.e(-1L, stepsRecord);
        this.bl.c(z);
        d(stepsRecord);
        ap();
    }

    private void ap() {
        if (this.bc > 0) {
            DaemonServiceSpUtils.o();
            long jF = DaemonServiceSpUtils.f();
            if (jF <= 0) {
                return;
            }
            DaemonServiceSpUtils.d(0L);
            hum.b(jF, this.bc);
        }
    }

    private void d(StepsRecord stepsRecord) {
        if (stepsRecord.d == 0 && stepsRecord.i == 0 && stepsRecord.f13778a == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("activeHourType", stepsRecord.d);
        bundle.putInt("intensityType", stepsRecord.i);
        bundle.putInt("caloriesType", stepsRecord.f13778a);
        hpn.a().aRk_("TodayAchievement", bundle);
    }

    @Override // com.huawei.health.connectivity.standstepcounter.StandStepDataManager.IGetCacheTodaySteps
    public boolean isProcessNewDayReport(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StandStepDataManager standStepDataManager = this.bh;
        if (standStepDataManager == null || !standStepDataManager.e(jCurrentTimeMillis, z)) {
            return false;
        }
        this.bm.b(this.bh.b());
        if (this.bd != null && SharedPerferenceUtils.q(this.p)) {
            this.bd.e();
        }
        ExtendStepDataManager extendStepDataManager = this.w;
        if (extendStepDataManager != null) {
            extendStepDataManager.d();
            this.w.e();
        }
        this.bi = jCurrentTimeMillis;
        this.u = false;
        this.bq = 0;
        this.ba = 0;
        this.n = 0;
        this.g = 0.0d;
        this.t.a();
        this.l.c(jCurrentTimeMillis);
        this.aw = 0;
        this.at = 0;
        this.av = 0;
        this.bb = 0;
        this.ax = 0;
        this.bn = 0;
        SharedPerferenceUtils.c(this.p, System.currentTimeMillis(), 0.0d);
        SharedPerferenceUtils.e(this.p, System.currentTimeMillis(), 0.0d);
        SharedPerferenceUtils.a(this.p, System.currentTimeMillis(), 0.0d);
        SharedPerferenceUtils.a(this.p, System.currentTimeMillis(), 0);
        if (this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1006);
            messageObtainMessage.arg1 = 200;
            messageObtainMessage.arg2 = 201;
            this.bo.sendMessage(messageObtainMessage);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("activeHourType", 0);
        bundle.putInt("intensityType", 0);
        bundle.putInt("caloriesType", 0);
        hpn.a().aRk_("TodayAchievement", bundle);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final boolean z) {
        health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "insertSportAchievementGoalVal isGoalChange:", Boolean.valueOf(z));
        ArrayList arrayList = new ArrayList(4);
        arrayList.add("900200006");
        arrayList.add("900200008");
        arrayList.add("900200009");
        arrayList.add("900200007");
        par.e(arrayList, new IBaseResponseCallback() { // from class: com.huawei.health.manager.LogicalStepCounter$3
            @Override // com.huawei.hwbasemgr.IBaseResponseCallback
            public void onResponse(int i2, Object obj) {
                if (!(obj instanceof HashMap)) {
                    ReleaseLogUtil.a("Step_LSC", "insertSportAchievementGoalVal objData is not instanceof HashMap");
                    return;
                }
                HashMap map = (HashMap) obj;
                int iC = par.c(map, "900200006", this.d.y.c());
                int iC2 = par.c(map, "900200008", 25);
                int iC3 = par.c(map, "900200009", 12);
                int iC4 = par.c(map, "900200007", 270000);
                ReleaseLogUtil.d("Step_LSC", mmp.b("insertSportAchievementGoalVal stepValue is ", Integer.valueOf(iC), " intensityValue is ", Integer.valueOf(iC2), " standValue is ", Integer.valueOf(iC3), " calorieGoalValue is ", Integer.valueOf(iC4)));
                this.d.b(iC, iC2, iC3, iC4);
                if (z) {
                    this.d.e(iC, iC2, iC3, iC4);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2, int i3, int i4, int i5) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_STEP_GOAL_STATE.value()), Integer.valueOf(HiHealthHelper.e(i2, this.bc)));
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_GOAL_STATE.value()), Integer.valueOf(HiHealthHelper.e(i3, this.bb)));
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_GOAL_STATE.value()), Integer.valueOf(HiHealthHelper.e(i4, this.ax)));
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_GOAL_STATE.value()), Integer.valueOf(HiHealthHelper.e(i5, this.aw)));
        paz.e().a(this.p, map, System.currentTimeMillis(), new IBaseResponseCallback() { // from class: com.huawei.health.manager.LogicalStepCounter$4
            @Override // com.huawei.hwbasemgr.IBaseResponseCallback
            public void onResponse(int i6, Object obj) {
                LogUtil.b("Step_LSC", "saveAchieveStatus errorCode ", Integer.valueOf(i6));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Intent intent = new Intent("com.huawei.health.ACTION_SEND_SPORT_GOAL");
        intent.putExtra("configId", str);
        BroadcastManagerUtil.bLG_(this.p, intent);
    }

    private void e(HashMap<Integer, Integer> map) {
        if (ThreeCircleConfigUtil.e(ThreeCircleConfigUtil.ThreeCircleConfig.CALORIE)) {
            map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_IS_RING_NEW.value()), 1);
        }
        if (ThreeCircleConfigUtil.e(ThreeCircleConfigUtil.ThreeCircleConfig.ACTIVE_HOUR)) {
            map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_IS_RING.value()), 1);
        }
        if (ThreeCircleConfigUtil.e(ThreeCircleConfigUtil.ThreeCircleConfig.STEP)) {
            map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_STEP_IS_RING.value()), 1);
        }
        if (ThreeCircleConfigUtil.e(ThreeCircleConfigUtil.ThreeCircleConfig.INTENSITY)) {
            map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_IS_RING.value()), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, int i3, int i4, int i5) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_STEP_GOAL_VALUE.value()), Integer.valueOf(i2));
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_DURATION_GOAL_VALUE.value()), Integer.valueOf(i3));
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_ACTIVE_GOAL_VALUE.value()), Integer.valueOf(i4));
        map.put(Integer.valueOf(DicDataTypeUtil.DataType.SPORT_GOAL_ACHIEVEMENT_DATA_CALORIE_GOAL_VALUE.value()), Integer.valueOf(i5));
        e(map);
        paz.e().a(this.p, map, System.currentTimeMillis(), new IBaseResponseCallback() { // from class: com.huawei.health.manager.LogicalStepCounter$5
            @Override // com.huawei.hwbasemgr.IBaseResponseCallback
            public void onResponse(int i6, Object obj) {
                ReleaseLogUtil.d("Step_LSC", "new day saveSportGoalAchievementData errorCode ", Integer.valueOf(i6));
                if (i6 == 0) {
                    BroadcastManagerUtil.bLG_(BaseApplication.getContext(), new Intent("UPDATE_THREE_GOAL"));
                }
            }
        });
    }

    private void aa() {
        ProcessAliveMonitor processAliveMonitor = this.as;
        if (processAliveMonitor == null) {
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "processAliveMonitorCheck mProcessAliveMonitor == null");
        } else {
            processAliveMonitor.c();
        }
    }

    private void ax() {
        StandStepCounter standStepCounter = this.bd;
        if (standStepCounter != null) {
            standStepCounter.b();
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "stopStepCounterInter stand");
        }
        ExtendStepCounter extendStepCounter = this.x;
        if (extendStepCounter != null) {
            extendStepCounter.stopStepCounter();
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "stopStepCounterInter extend");
        }
        this.aj = false;
    }

    private void at() {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "startStepCounterInter mStandStepCounter = ", this.bd);
        StandStepCounter standStepCounter = this.bd;
        if (standStepCounter != null) {
            standStepCounter.c();
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "startStepCounterInter stand");
        }
        ExtendStepCounter extendStepCounter = this.x;
        if (extendStepCounter != null) {
            extendStepCounter.startStepCounter();
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "startStepCounterInter extend");
        }
        this.aj = true;
    }

    public void e(ISimpleResultCallback iSimpleResultCallback) {
        e(iSimpleResultCallback, false);
    }

    public void e(ISimpleResultCallback iSimpleResultCallback, boolean z) {
        com.huawei.hwlogsmodel.LogUtil.e("Step_LSC", "flushTempCacheToDb enter... callback:", iSimpleResultCallback, " flushByUI:", Boolean.valueOf(z));
        if (this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1001);
            LogicalStepCounter$FlushDbMsg logicalStepCounter$FlushDbMsg = new LogicalStepCounter$FlushDbMsg();
            logicalStepCounter$FlushDbMsg.b = iSimpleResultCallback;
            messageObtainMessage.obj = logicalStepCounter$FlushDbMsg;
            this.bo.sendMessage(messageObtainMessage);
        }
    }

    public Bundle anl_() {
        StepsRecordManager stepsRecordManager = this.bl;
        if (stepsRecordManager == null) {
            return null;
        }
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "getTodaySportData mStepsRecordManager=", stepsRecordManager);
        return this.bl.e().acY_();
    }

    public Bundle ank_() {
        StepsRecord stepsRecordE;
        StepsRecordManager stepsRecordManager = this.bl;
        if (stepsRecordManager == null || (stepsRecordE = stepsRecordManager.e()) == null) {
            return null;
        }
        Bundle bundleAcY_ = stepsRecordE.acY_();
        bundleAcY_.putInt("cacheTotalSteps", getCacheTodaySteps());
        String strT = SharedPerferenceUtils.t(this.p);
        if (!TextUtils.isEmpty(strT)) {
            bundleAcY_.putString("serviceRestartRecord", strT);
        }
        Map<String, Object> mapC = this.bh.c();
        if (mapC != null) {
            bundleAcY_.putInt("standardBase", ((Integer) mapC.get("standardBase")).intValue());
            bundleAcY_.putInt("restartSteps", ((Integer) mapC.get("restartSteps")).intValue());
            bundleAcY_.putInt("otherSteps", ((Integer) mapC.get("otherSteps")).intValue());
            bundleAcY_.putInt("UIShowSteps", ((Integer) mapC.get("UIShowSteps")).intValue());
        }
        return bundleAcY_;
    }

    public boolean g() {
        ProcessAliveMonitor processAliveMonitor = this.as;
        if (processAliveMonitor == null) {
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "isNeedPromptKeepAlive mProcessAliveMonitor is null.");
            return false;
        }
        return processAliveMonitor.e();
    }

    public void o() {
        ProcessAliveMonitor processAliveMonitor = this.as;
        if (processAliveMonitor == null) {
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "makePromptNoSense processAliveMonitor null,failed,return");
        } else {
            processAliveMonitor.d();
        }
    }

    private void w() {
        if (!AuthorizationUtils.a(this.p)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "getDeviceId fail, authorization not admitted");
            return;
        }
        String androidId = FoundationCommonUtil.getAndroidId(this.p);
        this.q = androidId;
        this.bm.b(androidId);
        ExtendStepDataManager extendStepDataManager = this.w;
        if (extendStepDataManager != null) {
            extendStepDataManager.d(this.q);
        }
    }

    private void y() {
        HiHealthManager.a(this.p).fetchUserData(new HiCommonListener() { // from class: com.huawei.health.manager.LogicalStepCounter$6
            @Override // com.huawei.hihealth.data.listener.HiCommonListener
            public void onSuccess(int i2, Object obj) {
                List<HiUserInfo> list;
                LogUtil.e("Step_LSC", "getUserInfoFromDb");
                if (obj == null) {
                    ReleaseLogUtil.a("Step_LSC", "getUserInfoFromDb, data is null.");
                    return;
                }
                try {
                    list = (List) obj;
                } catch (ClassCastException e2) {
                    LogUtil.j("Step_LSC", e2.getMessage());
                    list = null;
                }
                if (list == null || list.size() == 0) {
                    ReleaseLogUtil.a("Step_LSC", "getUserInfoFromDb userInfoLists is null or userInfoList.size() == 0");
                    return;
                }
                for (HiUserInfo hiUserInfo : list) {
                    if (hiUserInfo.getRelateType() == 0) {
                        LogUtil.b("Step_LSC", "setUserInfo sync");
                        Bundle bundle = new Bundle();
                        bundle.putFloat("weight", hiUserInfo.getWeightOrDefaultValue());
                        bundle.putFloat("height", hiUserInfo.getHeightOrDefaultValue());
                        bundle.putInt("ownerId", hiUserInfo.getOwnerId());
                        bundle.putString("huid", hiUserInfo.getHuid());
                        bundle.putInt(CommonConstant.KEY_GENDER, hiUserInfo.getGenderOrDefaultValue());
                        bundle.putInt("age", hiUserInfo.getAgeOrDefaultValue());
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 1016;
                        messageObtain.obj = bundle;
                        this.d.bo.sendMessage(messageObtain);
                    }
                }
            }

            @Override // com.huawei.hihealth.data.listener.HiCommonListener
            public void onFailure(int i2, Object obj) {
                LogUtil.a("Step_LSC", "getUserInfo onFailure = ", obj);
            }
        });
    }

    public void anm_(Bundle bundle) {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "setUserInfo userSet ignore!!! from db refresh");
    }

    public void k() {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "setStepsTarget");
        this.y.d();
        if (this.bo != null) {
            this.bo.sendMessage(this.bo.obtainMessage(1006));
        }
        Context context = this.p;
        if (context != null) {
            SharedPerferenceUtils.a(context, this.y.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ISimpleResultCallback iSimpleResultCallback) {
        if (iSimpleResultCallback != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("result", true);
            iSimpleResultCallback.onSuccess(bundle);
        }
    }

    private void ar() {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "registerBrowseBroadcastReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.plugin.account.login");
        intentFilter.addAction("com.huawei.plugin.account.logout");
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        DaemonBrowseModeReceiver daemonBrowseModeReceiver = new DaemonBrowseModeReceiver(this);
        this.m = daemonBrowseModeReceiver;
        Context context = this.p;
        if (context != null) {
            BroadcastManagerUtil.bLC_(context, daemonBrowseModeReceiver, intentFilter, LocalBroadcast.d, null);
        }
    }

    private void au() {
        Context context;
        DaemonBrowseModeReceiver daemonBrowseModeReceiver = this.m;
        if (daemonBrowseModeReceiver == null || (context = this.p) == null) {
            return;
        }
        context.unregisterReceiver(daemonBrowseModeReceiver);
        this.m = null;
    }

    private void a(final ISimpleResultCallback iSimpleResultCallback, boolean z, boolean z2) {
        if (this.ad) {
            com.huawei.hwlogsmodel.LogUtil.a("Step_LSC", "browse mode not support write to db");
            return;
        }
        if (!this.am) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "not support calss1,then uploadstaticdata");
            r();
            a(iSimpleResultCallback);
            return;
        }
        if (this.bh != null && !z && (this.bc != this.an || z2)) {
            r();
            this.an = this.bc;
        }
        this.w.b(new FlushableStepDataCache.MyFlushCallback() { // from class: com.huawei.health.manager.LogicalStepCounter$7
            @Override // com.huawei.health.manager.common.FlushableStepDataCache.MyFlushCallback
            public void onSuccess() {
                if (this.d.bo != null) {
                    this.d.bo.sendEmptyMessage(1003);
                    Message messageObtainMessage = this.d.bo.obtainMessage(1006);
                    messageObtainMessage.arg1 = 200;
                    this.d.bo.sendMessage(messageObtainMessage);
                }
                this.d.w.d();
                this.d.a(iSimpleResultCallback);
                LogUtil.b("Step_LSC", "flush2DB result success");
            }

            @Override // com.huawei.health.manager.common.FlushableStepDataCache.MyFlushCallback
            public void onFailed() {
                LogUtil.b("Step_LSC", "flush2DB result error");
            }
        });
    }

    public void b() {
        health.compact.a.hwlogsmodel.ReleaseLogUtil.d("R_Step_LSC", "destroy.");
        if (this.bo != null) {
            this.bo.removeMessages(1000);
            this.bo.removeMessages(1001);
            this.bo.removeMessages(1006);
            this.bo.removeMessages(1003);
            this.bo.removeMessages(1011);
        }
        HandlerThread handlerThread = this.br;
        if (handlerThread != null) {
            handlerThread.quit();
            this.br = null;
        }
        SportIntensity.e(this.p).c();
        az();
        au();
        BroadcastManager.yb_(this.v);
        d(this.bk);
        hpn.a().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<Integer> list) {
        if (mgx.e(list)) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "unSubscribeSportData");
            HiHealthNativeApi.e(this.p).unSubscribeHiHealthData(list, new HiUnSubscribeListener() { // from class: com.huawei.health.manager.LogicalStepCounter$8
                @Override // com.huawei.hihealth.data.listener.HiUnSubscribeListener
                public void onResult(boolean z) {
                    ReleaseLogUtil.d("Step_LSC", "unSubscribeSportData isSuccess = ", Boolean.valueOf(z));
                }
            });
        }
    }

    public void b(LocalStepDataReport localStepDataReport) {
        a(localStepDataReport);
        if (this.bo != null) {
            this.bo.sendEmptyMessage(1006);
        }
    }

    public void e(long j2, int i2, int i3, int i4) {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "setBaseData mWorkerHandler ", this.bo, " steps ", LogAnonymous.d(i2));
    }

    public void m() {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "startStepCounter enter...");
        if (!StepCounterSupportUtils.e(this.p)) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", " processStartStepCounter failed with cant step counter.");
            return;
        }
        SharedPerferenceUtils.a(this.p, true);
        if (this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1005);
            messageObtainMessage.arg1 = 100;
            this.bo.sendMessage(messageObtainMessage);
        }
    }

    public void p() {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "stopStepCounter");
        SharedPerferenceUtils.a(this.p, false);
        if (this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1005);
            messageObtainMessage.arg1 = 101;
            this.bo.sendMessage(messageObtainMessage);
        }
    }

    public boolean n() {
        return this.aj;
    }

    public void d(long j2, int i2, int i3) {
        if (this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage(1000);
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = Long.valueOf(j2);
            messageObtainMessage.arg2 = i3;
            this.bo.sendMessage(messageObtainMessage);
        }
    }

    public int a() {
        if (this.af.get()) {
            return this.be;
        }
        Object obj = f13766a;
        synchronized (obj) {
            if (!this.af.get()) {
                try {
                    obj.wait(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "getStandSteps timeout");
                    hum.f();
                } catch (InterruptedException unused) {
                    com.huawei.hwlogsmodel.LogUtil.a("Step_LSC", "getStandSteps exception");
                }
            }
        }
        return this.be;
    }

    public boolean f() {
        return this.af.get();
    }

    private void g(int i2) {
        DeviceClassWatchDog deviceClassWatchDog = this.o;
        if (deviceClassWatchDog == null || !deviceClassWatchDog.c() || !this.o.b(i2) || this.bo == null) {
            return;
        }
        health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "reduce class");
        this.bo.sendEmptyMessage(1011);
    }

    private void h(int i2) {
        if (this.ai) {
            this.ao = i2;
            this.ai = false;
        }
        int i3 = i2 - this.ao;
        if (i3 > 100) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "standStepCounter report 100 steps,write fe");
            if (this.bo != null) {
                this.bo.sendMessage(this.bo.obtainMessage(1003));
            }
            this.ai = true;
            return;
        }
        if (i3 > 0) {
            if (this.bo != null) {
                this.bo.removeMessages(1010);
                this.bo.sendEmptyMessageDelayed(1010, 30000L);
                return;
            }
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "tryToRecordStepsToFileCache default.");
    }

    public void b(long j2, int i2, int i3, int i4) {
        long jA = j2;
        if (this.h.get()) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "onExtendStepChanged phone shutdown, return");
            return;
        }
        this.r = jA;
        if (this.aq != jA) {
            this.ag = false;
            this.aq = jA;
            this.bg = System.currentTimeMillis();
        } else if (this.ak) {
            this.ag = true;
        } else if (!this.ag && System.currentTimeMillis() - this.bg >= 60000) {
            this.ag = true;
        }
        if (this.ag) {
            com.huawei.hwlogsmodel.LogUtil.e("Step_LSC", "mIsCalibrateTime true,timestamp before:", Long.valueOf(j2));
            jA = (TimeUtil.a(System.currentTimeMillis()) * 1000) + 7;
            com.huawei.hwlogsmodel.LogUtil.e("Step_LSC", "mIsCalibrateTime after,timestamp before:", Long.valueOf(jA));
        }
        long j3 = jA;
        com.huawei.hwlogsmodel.LogUtil.e("Step_LSC", "onExtend:", Long.valueOf(j3), " ", Integer.valueOf(i2), " ", Integer.valueOf(i3), " ", Integer.valueOf(i4));
        long j4 = this.s;
        if (j3 < j4) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "timestamp back,mExtendReportTimestamp = ", Long.valueOf(j4));
            this.ak = true;
        } else {
            this.ak = false;
        }
        this.s = j3;
        DeviceClassWatchDog deviceClassWatchDog = this.o;
        if (deviceClassWatchDog != null) {
            deviceClassWatchDog.b();
        }
        d(i2, i3, i4, j3);
    }

    private void d(int i2, int i3, int i4, long j2) {
        int i5 = i3 > 0 ? 6 : i4;
        c(j2, i2, i3, i4);
        LogicalStepCounter$ExtendStepMsg logicalStepCounter$ExtendStepMsg = new LogicalStepCounter$ExtendStepMsg(j2, i2, i3 * 30, i5);
        if (this.bo != null) {
            Message messageObtainMessage = this.bo.obtainMessage();
            messageObtainMessage.what = 1004;
            messageObtainMessage.obj = logicalStepCounter$ExtendStepMsg;
            this.bo.sendMessage(messageObtainMessage);
        }
        UploadUtil uploadUtil = this.bm;
        if (uploadUtil != null && uploadUtil.e(i2)) {
            com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "flushTempCacheToDb by ext");
            e((ISimpleResultCallback) null);
        }
        long j3 = this.al;
        if (j3 == -1 || j3 > j2 || this.bo == null) {
            return;
        }
        if (com.huawei.hwlogsmodel.LogUtil.e(60000, this.al) == -1) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "send MSG_FLUSH_AND_SYNC_WITH_DB updateFrequency fast");
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "send MSG_FLUSH_AND_SYNC_WITH_DB message", Long.valueOf(this.al), Long.valueOf(j2));
        this.al = -1L;
        this.bo.sendMessage(this.bo.obtainMessage(1012));
    }

    private void c(int i2, String[] strArr) {
        d(i2, strArr);
        ExtendStepDataManager extendStepDataManager = this.w;
        OneMinuteStepData oneMinuteStepDataB = extendStepDataManager != null ? extendStepDataManager.b(i2) : null;
        if (oneMinuteStepDataB != null) {
            int iB = oneMinuteStepDataB.b();
            if (iB == 20003) {
                this.ba += oneMinuteStepDataB.a();
            } else if (iB == 20004) {
                this.n += oneMinuteStepDataB.a();
            } else {
                this.bq += oneMinuteStepDataB.a();
            }
        }
        TotalDetailStepsCacheBean.Builder builder = new TotalDetailStepsCacheBean.Builder();
        builder.b(((long) i2) * 60000);
        builder.b(this.bh.e());
        builder.i(this.bq);
        builder.e(this.ba);
        builder.a(this.n);
        builder.a(SystemClock.elapsedRealtime());
        builder.c(this.bb);
        builder.d(this.ax);
        SharedPerferenceUtils.b(this.p, builder.d());
    }

    private void d(int i2, String[] strArr) {
        if (strArr == null) {
            return;
        }
        try {
            long j2 = Long.parseLong(strArr[0]);
            int i3 = Integer.parseInt(strArr[2]);
            int i4 = Integer.parseInt(strArr[3]);
            int i5 = Integer.parseInt(strArr[4]);
            if (kql.c(j2, ((long) i2) * 60000)) {
                this.bq = i3;
                this.ba = i4;
                this.n = i5;
            }
        } catch (NumberFormatException e2) {
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "stepsDetailCalculation Exception", e2.getMessage());
        }
    }

    @Override // com.huawei.health.connectivity.standstepcounter.StandStepDataManager.IGetCacheTodaySteps
    public int getCacheTodaySteps() {
        ExtendStepDataManager extendStepDataManager = this.w;
        if (extendStepDataManager != null) {
            return extendStepDataManager.j();
        }
        return 0;
    }

    private void ah() {
        com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "CLASS1 change to CLASS2");
        StepCounterSupport.e(this.p, 2);
        this.am = false;
        this.bf.a();
        this.x.stopStepCounter();
        ExtendStepCounter extendStepCounterC = this.bf.c();
        this.x = extendStepCounterC;
        extendStepCounterC.startStepCounter();
        this.t.reduceClass();
        this.l.reduceClass();
    }

    public void r() {
        if (this.bh != null) {
            if (isProcessNewDayReport(false)) {
                health.compact.a.hwlogsmodel.ReleaseLogUtil.d("Step_LSC", "uploadStaticsToDb is new day");
            } else if (this.bh.i() && this.bh.e() == 0) {
                com.huawei.hwlogsmodel.LogUtil.b("Step_LSC", "today has no steps report");
            } else {
                this.bm.c(this.bh.e(), this.bh.h(), this.aw, this.at, this.av);
            }
        }
    }

    public void a(IStepReport iStepReport) {
        if (this.au != null) {
            synchronized (e) {
                this.au.add(iStepReport);
            }
        }
    }

    public void c(IStepReport iStepReport) {
        ArrayList<IStepReport> arrayList = this.au;
        if (arrayList == null || !arrayList.contains(iStepReport)) {
            return;
        }
        synchronized (e) {
            this.au.remove(iStepReport);
        }
    }

    private void c(long j2, int i2, int i3, int i4) {
        if (mgx.d(this.au)) {
            return;
        }
        synchronized (e) {
            for (IStepReport iStepReport : this.au) {
                if (iStepReport != null) {
                    iStepReport.onExtendStepChanged(j2, i2, i3, i4);
                }
            }
        }
    }

    private void b(int i2) {
        ArrayList<IStepReport> arrayList = this.au;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        synchronized (e) {
            for (IStepReport iStepReport : this.au) {
                if (iStepReport != null) {
                    iStepReport.onStandStepChanged(i2);
                }
            }
        }
    }

    public void t() {
        Context context;
        if (!ScreenUtil.e() || (context = this.p) == null) {
            return;
        }
        if (!Boolean.TRUE.toString().equals(SharedPerferenceUtils.s(context))) {
            com.huawei.hwlogsmodel.LogUtil.j("Step_LSC", "updateStepNotifyLayout StepsNotification switch is close or unset");
            return;
        }
        av();
        StepsRecordManager stepsRecordManager = this.bl;
        if (stepsRecordManager == null || this.ab == null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "updateStepNotifyLayout data null");
            return;
        }
        StepsRecord stepsRecordE = stepsRecordManager.e();
        if (stepsRecordE == null) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.a("Step_LSC", "updateStepNotifyLayout stepsRecord == null");
        } else {
            this.ab.c(stepsRecordE.j, stepsRecordE.f13778a, stepsRecordE.h, stepsRecordE.d);
        }
    }

    private void av() {
        if (this.ab == null) {
            this.ab = HealthStepsNotificationHelper.a(this.p);
        }
        this.ab.d(NotificationUtil.i());
        this.ab.b(NotificationUtil.j());
    }
}
