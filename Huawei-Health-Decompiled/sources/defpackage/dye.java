package defpackage;

import com.amap.api.services.core.AMapException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class dye implements Serializable {
    private String c;

    public dye(byte b) {
        this.c = "";
        if (b == 2) {
            this.c = "血压模块自检错误，可能是传感器或A/D错误";
            return;
        }
        if (b != 19) {
            switch (b) {
                case 6:
                    this.c = "袖带松或者未连接袖带";
                    break;
                case 7:
                    this.c = "漏气（阀门等处）";
                    break;
                case 8:
                    this.c = "气压错误（可能是阀门没有正常打开）";
                    break;
                case 9:
                    this.c = "弱信号（可能是袖带太松等, 可能与错误0x02有关）";
                    break;
                case 10:
                    this.c = "超范围 （测量对象超过设备测量范围）";
                    break;
                case 11:
                    this.c = "过分运动（有信号干扰等）";
                    break;
                case 12:
                    this.c = "过压";
                    break;
                case 13:
                    this.c = "信号饱和";
                    break;
                case 14:
                    this.c = "漏气（类似于错误0x03）";
                    break;
                case 15:
                    this.c = "系统错误";
                    break;
                default:
                    this.c = AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
                    break;
            }
            return;
        }
        this.c = "测量超时";
    }

    public String b() {
        return this.c;
    }
}
