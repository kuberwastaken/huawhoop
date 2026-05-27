package com.huawei.health.h5pro.jsbridge.system.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.huawei.health.h5pro.utils.LogUtil;
import com.huawei.hms.network.embedded.q0;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class SensorManagerApi implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorDataCallback f2484a;
    public SensorManager b;
    public SensorTypeEnum d;
    public long e = 0;
    public final float[] c = new float[3];

    public interface SensorDataCallback {
        void onComplete();

        void onFailure(int i, String str);

        void onSuccess(JSONObject jSONObject);
    }

    public void unregisterSensorListener() {
        SensorManager sensorManager = this.b;
        if (sensorManager == null) {
            return;
        }
        sensorManager.unregisterListener(this);
        SensorDataCallback sensorDataCallback = this.f2484a;
        if (sensorDataCallback == null) {
            return;
        }
        sensorDataCallback.onComplete();
        this.f2484a = null;
    }

    public void registerSensorListener(String str, String str2, SensorDataCallback sensorDataCallback) {
        unregisterSensorListener();
        this.f2484a = sensorDataCallback;
        try {
            SensorTypeEnum sensorTypeEnumValueOf = SensorTypeEnum.valueOf(str);
            this.d = sensorTypeEnumValueOf;
            Sensor defaultSensor = this.b.getDefaultSensor(sensorTypeEnumValueOf.sensorType);
            if (defaultSensor == null) {
                this.f2484a.onFailure(1002, String.format(Locale.ENGLISH, "Sensor %s not supported", str));
            } else {
                this.b.registerListener(this, defaultSensor, (TextUtils.isEmpty(str2) ? SamplingPeriodUs.SENSOR_DELAY_UI : SamplingPeriodUs.valueOf(str2)).samplingPeriodUs);
            }
        } catch (IllegalArgumentException e) {
            this.f2484a.onFailure(-1, e.getMessage());
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public enum SamplingPeriodUs {
        SENSOR_DELAY_FASTEST(0),
        SENSOR_DELAY_GAME(1),
        SENSOR_DELAY_UI(2),
        SENSOR_DELAY_NORMAL(3);

        public final int samplingPeriodUs;

        SamplingPeriodUs(int i) {
            this.samplingPeriodUs = i;
        }
    }

    public enum SensorTypeEnum {
        SENSOR_TYPE_GYROSCOPE(4),
        SENSOR_TYPE_ACCELEROMETER(1),
        SENSOR_TYPE_GRAVITY(9),
        SENSOR_TYPE_ROTATION_VECTOR(11),
        SENSOR_TYPE_LINEAR_ACCELERATION(10),
        SENSOR_TYPE_MAGNETIC_FIELD(2),
        SENSOR_TYPE_PROXIMITY(8),
        SENSOR_TYPE_LIGHT(5),
        SENSOR_TYPE_PRESSURE(6),
        SENSOR_TYPE_AMBIENT_TEMPERATURE(13);

        public final int sensorType;

        SensorTypeEnum(int i) {
            this.sensorType = i;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f2484a == null) {
            LogUtil.w("H5PRO_SensorManagerApi", "onSensorChanged: mSensorDataCallback is null");
            return;
        }
        if (sensorEvent == null) {
            LogUtil.w("H5PRO_SensorManagerApi", "onSensorChanged: SensorEvent is null");
            this.f2484a.onFailure(-1, "SensorEvent is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(q0.j, new JSONArray(sensorEvent.values));
            jSONObject.put("accuracy", sensorEvent.accuracy);
            jSONObject.put("timestamp", sensorEvent.timestamp);
            jSONObject.put("sensorType", this.d.name());
            if (this.d.sensorType == 4) {
                jSONObject.put("angle", new JSONArray(ZY_(sensorEvent)));
            }
            this.f2484a.onSuccess(jSONObject);
        } catch (JSONException e) {
            LogUtil.e("H5PRO_SensorManagerApi", "onSensorChanged: exception -> " + e.getMessage());
            this.f2484a.onFailure(-1, e.getMessage());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        LogUtil.i("H5PRO_SensorManagerApi", sensor.getType() + " <- sensor - onAccuracyChanged - accuracy -> " + i);
    }

    private float[] ZY_(SensorEvent sensorEvent) {
        if (this.e == 0) {
            this.e = sensorEvent.timestamp;
            return new float[]{0.0f, 0.0f, 0.0f};
        }
        float f = (sensorEvent.timestamp - r0) * 1.0E-9f;
        float[] fArr = this.c;
        float f2 = fArr[0];
        float[] fArr2 = sensorEvent.values;
        fArr[0] = f2 + (fArr2[0] * f);
        fArr[1] = fArr[1] + (fArr2[1] * f);
        fArr[2] = fArr[2] + (fArr2[2] * f);
        return fArr;
    }

    public SensorManagerApi(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(SensorManager.class);
        this.b = sensorManager;
        if (sensorManager == null) {
            this.b = (SensorManager) context.getSystemService("sensor");
        }
    }
}
