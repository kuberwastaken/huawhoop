package com.huawei.openalliance.ad;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes11.dex */
public class rs implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f7779a;
    private Sensor b;
    private a c;
    private final float[] d;
    private float[] e = new float[3];

    public interface a {
        void a(double d, double d2, double d3);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 15) {
            SensorManager.getRotationMatrixFromVector(this.d, sensorEvent.values);
            SensorManager.getOrientation(this.d, this.e);
            double degrees = Math.toDegrees(this.e[0]);
            double degrees2 = Math.toDegrees(this.e[1]);
            double degrees3 = Math.toDegrees(this.e[2]);
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(degrees2, degrees3, degrees);
            }
        }
    }

    public void b() {
        try {
            this.f7779a.unregisterListener(this, this.b);
            this.c = null;
        } catch (Throwable th) {
            hq.c("RotateDetector", "unregister err: %s", th.getClass().getSimpleName());
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a() {
        try {
            this.f7779a.registerListener(this, this.b, 3);
        } catch (Throwable th) {
            hq.c("RotateDetector", "registerListener exception: %s", th.getClass().getSimpleName());
        }
    }

    public rs(Context context) {
        float[] fArr = new float[16];
        this.d = fArr;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f7779a = sensorManager;
        this.b = sensorManager.getDefaultSensor(15);
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        fArr[8] = 1.0f;
        fArr[12] = 1.0f;
    }
}
