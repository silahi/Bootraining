package com.alhous.ai.bootraining.iris;

public class Reporter {
    private double f1Score;
    private double precision;
    private double recall;
    private double accuracy;

    public double getF1Score() {
        return f1Score;
    }

    public void setF1Score(double f1Score) {
        this.f1Score = f1Score;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getRecall() {
        return recall;
    }

    public void setRecall(double recall) {
        this.recall = recall;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public Reporter(double f1Score, double precision, double recall, double accuracy) {
        this.f1Score = f1Score;
        this.precision = precision;
        this.recall = recall;
        this.accuracy = accuracy;
    }

    public Reporter() {
    }

    @Override
    public String toString() {
        return "Reporter [accuracy=" + accuracy + ", f1Score=" + f1Score + ", precision=" + precision + ", recall="
                + recall + "]";
    }

}
