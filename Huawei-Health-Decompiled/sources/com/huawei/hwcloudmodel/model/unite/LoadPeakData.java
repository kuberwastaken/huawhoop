package com.huawei.hwcloudmodel.model.unite;

/* JADX INFO: loaded from: classes5.dex */
public class LoadPeakData {
    private int aerobicTrainingLoads;
    private int anaerobicTrainingLoads;
    private int bestTrainingLoadsCeiling;
    private int bestTrainingLoadsFloor;
    private int trainingLoads;

    public int getAerobicTrainingLoads() {
        return this.aerobicTrainingLoads;
    }

    public void setAerobicTrainingLoads(int i) {
        this.aerobicTrainingLoads = i;
    }

    public int getAnaerobicTrainingLoads() {
        return this.anaerobicTrainingLoads;
    }

    public void setAnaerobicTrainingLoads(int i) {
        this.anaerobicTrainingLoads = i;
    }

    public int getBestTrainingLoadsCeiling() {
        return this.bestTrainingLoadsCeiling;
    }

    public void setBestTrainingLoadsCeiling(int i) {
        this.bestTrainingLoadsCeiling = i;
    }

    public int getBestTrainingLoadsFloor() {
        return this.bestTrainingLoadsFloor;
    }

    public void setBestTrainingLoadsFloor(int i) {
        this.bestTrainingLoadsFloor = i;
    }

    public int getTrainingLoads() {
        return this.trainingLoads;
    }

    public void setTrainingLoads(int i) {
        this.trainingLoads = i;
    }

    public String toString() {
        return "LoadPeakData{trainingLoads=" + this.trainingLoads + ", aerobicTrainingLoads=" + this.aerobicTrainingLoads + ", anaerobicTrainingLoads=" + this.anaerobicTrainingLoads + ", bestTrainingLoadsCeiling=" + this.bestTrainingLoadsCeiling + ", bestTrainingLoadsFloor=" + this.bestTrainingLoadsFloor + '}';
    }
}
