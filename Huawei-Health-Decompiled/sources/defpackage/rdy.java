package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class rdy {

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String b;

    @SerializedName("onlineDate")
    private String d;

    public String a() {
        return this.d;
    }

    public String toString() {
        return "TimeDaoBean{workoutId='" + this.b + "', onlineDate='" + this.d + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        rdy rdyVar = (rdy) obj;
        return Objects.equals(this.b, rdyVar.b) && Objects.equals(this.d, rdyVar.d);
    }

    public int hashCode() {
        return Objects.hash(this.b, this.d);
    }
}
