package com.huawei.aifitness.mobilesensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.huawei.aifitness.bodyrebuild.ModelManager;

/* JADX INFO: loaded from: classes.dex */
public class MobileSensorManager {
    private static MobileSensorManager instance;
    private AccGyroListener accGyroListener;
    private AlgSensorListener algSensorListener;
    private int preCode = -1;
    private SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.huawei.aifitness.mobilesensor.MobileSensorManager.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() != 1) {
                return;
            }
            MobileSensorManager.this.setAccData(sensorEvent);
        }
    };

    private MobileSensorManager() {
    }

    public static MobileSensorManager getInstance() {
        MobileSensorManager mobileSensorManager;
        synchronized (MobileSensorManager.class) {
            if (instance == null) {
                instance = new MobileSensorManager();
            }
            mobileSensorManager = instance;
        }
        return mobileSensorManager;
    }

    public void setAccGyroListener(AccGyroListener accGyroListener) {
        this.accGyroListener = accGyroListener;
    }

    public void initSensor(Context context, AlgSensorListener algSensorListener) {
        this.algSensorListener = algSensorListener;
        this.preCode = -1;
        ModelManager.AlgInitAR();
        ModelManager.AlgDataCollect(new float[]{System.currentTimeMillis() / 1000.0f}, 12, (short) 1);
        Object systemService = context.getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            sensorManager.registerListener(this.sensorEventListener, sensorManager.getDefaultSensor(1), 10000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccData(SensorEvent sensorEvent) {
        ModelManager.AlgDataCollect(sensorEvent.values, 0, (short) 1);
        if (this.algSensorListener != null) {
            int iAlgGetResultAR = ModelManager.AlgGetResultAR();
            AccGyroListener accGyroListener = this.accGyroListener;
            if (accGyroListener != null) {
                accGyroListener.getAcc(sensorEvent, iAlgGetResultAR);
            }
            if (iAlgGetResultAR != this.preCode) {
                this.preCode = iAlgGetResultAR;
                this.algSensorListener.getAlgResult(iAlgGetResultAR);
            }
        }
    }

    private void setGyroscope(SensorEvent sensorEvent) {
        int iAlgGetResultAR;
        AccGyroListener accGyroListener = this.accGyroListener;
        if (accGyroListener != null) {
            accGyroListener.getGyro(sensorEvent);
        }
        ModelManager.AlgDataCollect(sensorEvent.values, 1, (short) 1);
        if (this.algSensorListener == null || (iAlgGetResultAR = ModelManager.AlgGetResultAR()) == this.preCode) {
            return;
        }
        this.preCode = iAlgGetResultAR;
        this.algSensorListener.getAlgResult(iAlgGetResultAR);
    }

    public void closeSensor(Context context) {
        Object systemService = context.getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            ((SensorManager) systemService).unregisterListener(this.sensorEventListener);
        }
    }
}
