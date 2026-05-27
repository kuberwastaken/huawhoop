package com.huawei.openalliance.ad;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes11.dex */
public class rr implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f7778a;
    private Sensor b;
    private a c;

    public interface a {
        void a(float f, float f2, float f3);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (1 == sensorEvent.sensor.getType()) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            if (hq.a()) {
                hq.a("PhoneAccelerometerDetec", "onSensorChanged x: %s, y: %s, z: %s", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            }
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(f, f2, f3);
            }
        }
    }

    public void b() {
        try {
            this.f7778a.unregisterListener(this, this.b);
            this.c = null;
        } catch (Throwable th) {
            hq.c("PhoneAccelerometerDetec", "unregister err: %s", th.getClass().getSimpleName());
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a() {
        Sensor sensor = this.b;
        if (sensor != null) {
            try {
                this.f7778a.registerListener(this, sensor, 2);
            } catch (Throwable th) {
                hq.c("PhoneAccelerometerDetec", "registerListener exception: %s", th.getClass().getSimpleName());
            }
        }
    }

    public rr(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f7778a = sensorManager;
        this.b = sensorManager.getDefaultSensor(1);
    }
}
