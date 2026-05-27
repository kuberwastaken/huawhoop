package defpackage;

import com.huawei.pluginmgr.EzPluginConfigBase;
import com.huawei.pluginmgr.EzPluginType;

/* JADX INFO: loaded from: classes7.dex */
public class oem extends EzPluginConfigBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EzPluginType f16324a;

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public boolean isPluginDirectory() {
        return true;
    }

    public oem(EzPluginType ezPluginType, String str) {
        super(null, str);
        if (ezPluginType == null) {
            throw new IllegalArgumentException("pluginType == null");
        }
        this.f16324a = ezPluginType;
    }

    /* JADX INFO: renamed from: oem$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[EzPluginType.values().length];
            d = iArr;
            try {
                iArr[EzPluginType.SKIP_ROPE_RESOURCES_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[EzPluginType.SMART_COACH_RESOURCES_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[EzPluginType.SPORT_INTENSITY_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[EzPluginType.DYNAMIC_TRACK_RESOURCES_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[EzPluginType.DYNAMIC_TRACK_CUSTOM_MAP_RESOURCES_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[EzPluginType.HEALTH_MODEL_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[EzPluginType.FAMILY_HEALTH_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                d[EzPluginType.HEALTH_BLOODSUGAR_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                d[EzPluginType.UX_TEMPLATE_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                d[EzPluginType.NORTH_DEVICE_IMG_RESOURCES_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getPluginConfigId() {
        switch (AnonymousClass4.d[this.f16324a.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "com.huawei.health_common_config";
            case 10:
                return "com.huawei.health_ecologydevice_config";
            default:
                return "";
        }
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getPluginQueryString(String str) {
        switch (AnonymousClass4.d[this.f16324a.ordinal()]) {
            case 1:
                return "resources=skip_rope";
            case 2:
                return "resources=smart_coach";
            case 3:
                return "resources=sport_intensity_desc";
            case 4:
                return "resources=dynamic_track";
            case 5:
                return "resources=dynamic_track_map";
            case 6:
                return "resources=health_model";
            case 7:
                return "resources=family_health";
            case 8:
                return "resources=health_blood_sugar";
            case 9:
                return "resources=healthdetail_common_template_config";
            case 10:
                return "resources=north_device_img";
            default:
                return "";
        }
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getIndexFileFiled() {
        switch (AnonymousClass4.d[this.f16324a.ordinal()]) {
            case 1:
                return "skip_rope_index";
            case 2:
                return "smart_coach_index";
            case 3:
                return "index_sport_intensity";
            case 4:
                return "dynamic_track_resource_index";
            case 5:
                return "dynamic_track_map_resource_config";
            case 6:
                return "health_model_index";
            case 7:
                return "family_health_index";
            case 8:
                return "health_blood_sugar_index";
            case 9:
                return "ux_index";
            case 10:
                return "north_device_img_index";
            default:
                return "plugin_index";
        }
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getIndexSaveKey() {
        switch (AnonymousClass4.d[this.f16324a.ordinal()]) {
            case 1:
                return "skip_rope_index";
            case 2:
                return "smart_coach_index";
            case 3:
                return "index_sport_intensity";
            case 4:
                return "dynamic_track_resource_index";
            case 5:
                return "dynamic_track_map_index";
            case 6:
                return "health_model_index";
            case 7:
                return "family_health_index";
            case 8:
                return "health_blood_sugar_index";
            case 9:
                return "ux_index";
            case 10:
                return "north_device_img_index";
            default:
                return "index";
        }
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public String getPluginSaveKey(String str) {
        switch (AnonymousClass4.d[this.f16324a.ordinal()]) {
            case 1:
                return "skip_rope_res";
            case 2:
                return "smart_coach_res";
            case 3:
                return "sport_intensity_res";
            case 4:
                return "dynamic_track_music_resource";
            case 5:
                return "dynamic_track_map_resource";
            case 6:
                return "health_model_res";
            case 7:
                return "family_health_res";
            case 8:
                return "health_blood_sugar_res";
            case 9:
                return "ux_model_res";
            case 10:
                return "north_device_img_res";
            default:
                return str;
        }
    }

    @Override // com.huawei.pluginmgr.EzPluginConfigBase
    public boolean needDescriptionFile() {
        return this.f16324a == EzPluginType.COMMON_DEVICE_INDEX_TYPE;
    }
}
