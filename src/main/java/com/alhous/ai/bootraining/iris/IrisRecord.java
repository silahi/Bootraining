package com.alhous.ai.bootraining.iris;

public class IrisRecord {
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private int spece;

    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(double petalLength) {
        this.petalLength = petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

    public int getSpece() {
        return spece;
    }

    public void setSpece(int spece) {
        this.spece = spece;
    }

    public IrisRecord(double sepalLength, double sepalWidth, double petalLength, double petalWidth, int spece) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.spece = spece;
    }

    public IrisRecord() {
    }

    public IrisRecord(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
    }

    @Override
    public String toString() {
        return "IrisRecord [petalLength=" + petalLength + ", petalWidth=" + petalWidth + ", sepalLength=" + sepalLength
                + ", sepalWidth=" + sepalWidth + ", spece=" + spece + "]";
    }

}
