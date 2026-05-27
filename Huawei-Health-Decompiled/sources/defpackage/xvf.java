package defpackage;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;
import lib.android.paypal.com.magnessdk.c;
import lib.android.paypal.com.magnessdk.log.a;
import lib.android.paypal.com.magnessdk.network.base.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
class xvf extends c implements SensorEventListener {
    private static AtomicInteger b = new AtomicInteger(0);
    private SensorManager c;
    private JSONObject d;
    private Sensor e;
    private Handler f;
    private int g;
    private JSONArray h;
    private long i = 0;
    private JSONArray j;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f == null) {
            return;
        }
        d();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.i <= 25 || this.h.length() >= 150) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(String.valueOf(sensorEvent.values[0]));
        jSONArray.put(String.valueOf(sensorEvent.values[1]));
        jSONArray.put(String.valueOf(sensorEvent.values[2]));
        jSONArray.put(jCurrentTimeMillis);
        this.h.put(jSONArray);
        this.i = jCurrentTimeMillis;
    }

    public JSONObject e() {
        if (this.e == null) {
            return new JSONObject();
        }
        fET_(this.c);
        h();
        return this.d;
    }

    @Override // lib.android.paypal.com.magnessdk.network.base.c
    public void d() {
        fES_(this.c);
    }

    @Override // lib.android.paypal.com.magnessdk.network.base.c
    public void c() {
        this.d = new JSONObject();
        this.h = new JSONArray();
        this.j = new JSONArray();
        b();
    }

    private void h() {
        try {
            this.d.put(c.a.SENSOR_PAYLOAD.toString(), this.h);
            this.j.put(this.d);
        } catch (JSONException e) {
            a.d(getClass(), 3, e);
        }
    }

    private void fET_(SensorManager sensorManager) {
        sensorManager.unregisterListener(this, this.e);
        AtomicInteger atomicInteger = b;
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            return;
        }
        b.getAndDecrement();
    }

    private void fES_(SensorManager sensorManager) {
        fER_(sensorManager);
    }

    private void fER_(SensorManager sensorManager) {
        AtomicInteger atomicInteger;
        try {
            if (this.e == null || (atomicInteger = b) == null || atomicInteger.get() >= 120) {
                return;
            }
            sensorManager.registerListener(this, this.e, 50000, this.f);
            b.getAndIncrement();
            JSONObject jSONObjectC = xuv.c(this.d, xuv.fEI_(this.e));
            this.d = jSONObjectC;
            if (this.g == 1) {
                jSONObjectC.put(c.a.SENSOR_TYPE.toString(), c.l.AC.toString());
            }
            if (this.g == 4) {
                this.d.put(c.a.SENSOR_TYPE.toString(), c.l.GY.toString());
            }
            if (this.g == 2) {
                this.d.put(c.a.SENSOR_TYPE.toString(), c.l.MG.toString());
            }
        } catch (JSONException e) {
            a.d(getClass(), 3, e);
        }
    }

    xvf(Context context, Handler handler, int i) {
        this.f = handler;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.c = sensorManager;
        this.g = i;
        this.e = sensorManager.getDefaultSensor(i);
    }
}
