var rules = [
// 饮食记录早餐分析规则
// mealType = 0 早餐， 1 午餐， 2晚餐
// 碳水-carbohydrate，糖类-sugar

// 饮食记录早餐分析规则规则
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar > 7) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_empty_high_up"; // "空腹血糖偏高，如频发，建议咨询医生。餐后血糖高可能与餐前血糖偏高有关"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar > 7) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar > 7) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_empty_high_tip"; // "空腹及餐后偏高，如频发，建议咨询医生。同时，为了让血糖更平稳，建议下次适当减少高碳水食物的份量，同时避免高GI食物的摄入，再查看餐前餐后测量结果"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar > 7) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 7)
            && (this.afterBloodSugar > 10) && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_after_high"; // "餐后血糖偏高，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 7)
            && (this.afterBloodSugar > 10) && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3));
    },
    "consequence": function (R) {
        this.matched = true

        // "餐后血糖偏高，早餐摄入碳水XX克，建议下次将高碳水食物的份量减半，同时避免高GI食物的摄入，再查看餐前餐后测量结果"
        this.suggestion = "IDS_bsdiet_after_breakfast";
        this.params = "carbohydrate";
        R.stop(); //stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 7)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_nomal"; // "餐前餐后血糖正常，饮食适量，简直完美"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 7)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 7)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true

         // "餐前餐后血糖正常，碳水摄入有些过量，为了让血糖更平稳，建议下次适当减少高碳水食物的份量，同时避免高GI食物的摄入，再查看餐前餐后测量结果"
        this.suggestion = "IDS_bsdiet_nomal_more";
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 7)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar > 7)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_empty_high"; // "空腹血糖偏高，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0) && (this.beforeBloodSugar > 7)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 7)
            && (this.afterBloodSugar < 3.9));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop(); // stop if matched. no need to process next rule.
    }
},

// 饮食记录午餐，晚餐分析规则
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0) && (this.beforeBloodSugar > 10) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_meal_high"; // "餐前餐后血糖偏高，如频发，建议咨询医生";
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0) && (this.beforeBloodSugar > 10) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0) && (this.beforeBloodSugar > 10) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.params = "carbohydrate";

        // "餐前餐后血糖偏高，XX（中/晚）餐摄入碳水XX克，建议下次将高碳水食物的份量减半，同时避免高GI食物的摄入，再查看餐前餐后测量结果"
        switch(this.mealType) {
            case 1:
                this.suggestion = "IDS_bsdiet_lunch_tip";
              break
            case 2:
                this.suggestion = "IDS_bsdiet_dinner_tip";
              break
            default:
              break
        }
        R.stop(); //stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0) && (this.beforeBloodSugar > 10) && (this.afterBloodSugar > 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar > 10) && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_after_high"; // "餐后血糖偏高，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar > 10) && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.params = "carbohydrate";

        // "餐后血糖偏高，XX（中/晚）餐摄入碳水XX克，建议下次将高碳水食物的份量减半，同时避免高GI食物的摄入，再查看餐前餐后测量结果"
        switch(this.mealType) {
            case 1:
                this.suggestion = "IDS_bsdiet_after_lunch";
              break
            case 2:
                this.suggestion = "IDS_bsdiet_after_dinner";
              break
            default:
              break
        }
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        var beforeBloodSugarTemp = Math.round(this.beforeBloodSugar * 10); // 保留1位小数，乘以10后四舍五入
        var afterBloodSugarTemp = Math.round(this.afterBloodSugar * 10);
        R.when((this.type == 0) && (this.mealType != 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(beforeBloodSugarTemp - afterBloodSugarTemp) < 3.3 * 10)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_nomal"; // "餐前餐后血糖正常，简直完美"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        var beforeBloodSugarTemp = Math.round(this.beforeBloodSugar * 10); // 保留1位小数，乘以10后四舍五入
        var afterBloodSugarTemp = Math.round(this.afterBloodSugar * 10);
        R.when((this.type == 0) && (this.mealType != 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && afterBloodSugarTemp - beforeBloodSugarTemp >= 3.3 * 10);
    },
    "consequence": function (R) {
        this.matched = true

        // "餐前餐后血糖正常，碳水摄入有些过量，为了让血糖更平稳，建议下次适当减少高碳水食物的份量，同时避免高GI食物的摄入，再查看餐前餐后测量结果"
        this.suggestion = "IDS_bsdiet_nomal_more";
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0) && (this.beforeBloodSugar > 10)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0)
            && (this.beforeBloodSugar >= 3.9) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar < 3.9));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0)
            && this.beforeBloodSugar > 7 && this.afterBloodSugar < 3.9
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0)
            && this.beforeBloodSugar > 10 && this.afterBloodSugar < 3.9
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0)
            && this.beforeBloodSugar > 7 && (this.afterBloodSugar >= 3.9 && this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar >= 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_empty_high"; // "空腹血糖偏高，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0)
            && this.beforeBloodSugar > 7 && (this.afterBloodSugar >= 3.9 && this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3)
            && this.afterBloodSugar - this.beforeBloodSugar < 0);
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType != 0)
            && this.beforeBloodSugar > 10 && (this.afterBloodSugar >= 3.9 && this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) < 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_go_down_tip"; // "不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 0) && (this.mealType == 0)
            && this.beforeBloodSugar > 7 && (this.afterBloodSugar >= 3.9 && this.afterBloodSugar <= 10)
            && (Math.abs(this.beforeBloodSugar - this.afterBloodSugar) >= 3.3));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bsdiet_high_go_down_tip"; // "餐前血糖偏高, 不明原因餐后血糖降低，如频发，建议咨询医生"
        R.stop();//stop if matched. no need to process next rule.
    }
},


// 运动血糖分析规则
// 运动警示-不提示
{
    "condition": function (R) {
        R.when((this.type == 1) && (this.beforeBloodSugar >= 10) && (this.beforeBloodSugar < 13.9)
            && (this.afterBloodSugar >= 10)
            && (this.afterBloodSugar - this.beforeBloodSugar >= 0));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bssport_more_up"; // "运动后血糖仍有些偏高，可以下次增加一些运动量试试"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 1) && (this.beforeBloodSugar >= 10) && (this.beforeBloodSugar <= 13.9)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (this.afterBloodSugar - this.beforeBloodSugar < 0));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bssport_fit"; // "当前运动血糖控制良好，请继续保持"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 1) && (this.beforeBloodSugar >= 10) && (this.beforeBloodSugar < 13.9)
            && (this.afterBloodSugar > 0) && (this.afterBloodSugar < 3.9)
            && (this.afterBloodSugar - this.beforeBloodSugar < 0));
    },
    "consequence": function (R) {
        this.matched = true

        // "运动过量，出现低血糖症状，需立即服用15-20g糖类食物，若血糖和症状仍未缓解，应尽快就医"
        this.suggestion = "IDS_bssport_more_down";
        this.params = "15,20";
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 1) && (this.beforeBloodSugar >= 5) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (this.afterBloodSugar - this.beforeBloodSugar >= 0));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bssport_fit_about"; // "血糖控制理想，运动后升高可能与运动类型有关"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 1) && (this.beforeBloodSugar >= 5) && (this.beforeBloodSugar <= 10)
            && (this.afterBloodSugar >= 3.9) && (this.afterBloodSugar <= 10)
            && (this.afterBloodSugar - this.beforeBloodSugar < 0));
    },
    "consequence": function (R) {
        this.matched = true
        this.suggestion = "IDS_bssport_fit"; // "当前运动血糖控制良好，请继续保持"
        R.stop();//stop if matched. no need to process next rule.
    }
},
{
    "condition": function (R) {
        R.when((this.type == 1) && (this.beforeBloodSugar >= 5) && (this.beforeBloodSugar < 10)
            && (this.afterBloodSugar > 0) && (this.afterBloodSugar < 3.9)
            && (this.afterBloodSugar - this.beforeBloodSugar < 0));
    },
    "consequence": function (R) {
        this.matched = true

        // "运动过量，出现低血糖症状，需立即服用15-20g糖类食物，若血糖和症状仍未缓解，应尽快就医"
        this.suggestion = "IDS_bssport_more_down";
        this.params = "15,20";
        R.stop();//stop if matched. no need to process next rule.
    }
}];
/* Creating Rule Engine instance and registering rule */
R.register(rules);