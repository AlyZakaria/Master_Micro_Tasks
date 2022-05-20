package com.company;

public class range {

    private String type;
    private double defaultValue;
    private double max;
    private double min;

    public range(String type, double defaultValue, double max, double min) {
        this.type = type;
        this.defaultValue = defaultValue;
        this.max = max;
        this.min = min;
    }

    public String getType() {
        return type;
    }

    public double getDefaultValue() {
        return defaultValue;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDefaultValue(double defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }



}
