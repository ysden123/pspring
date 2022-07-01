package com.stulsoft.jpa;

public class MinMaxTestAuto {
    String minName;
    String maxName;

    public MinMaxTestAuto(String minName, String maxName) {
        this.minName = minName;
        this.maxName = maxName;
    }

    public MinMaxTestAuto(String[] values) {
        this.minName = values[0];
        this.maxName = values[1];
    }

    public String getMinName() {
        return minName;
    }

    public void setMinName(String minName) {
        this.minName = minName;
    }

    public String getMaxName() {
        return maxName;
    }

    public void setMaxName(String maxName) {
        this.maxName = maxName;
    }

    @Override
    public String toString() {
        return "MinMaxTestAuto{" +
                "minName='" + minName + '\'' +
                ", maxName='" + maxName + '\'' +
                '}';
    }
}
