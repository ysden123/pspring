package com.stulsoft.sql.jpa3;

import java.util.List;

public class MinMaxTestAuto {
    String minName;
    String maxName;

    public MinMaxTestAuto(List<String> values) {
        this.minName = values.get(0);
        this.maxName = values.get(1);
    }

    public MinMaxTestAuto(Object[] values) {
        this.minName = values[0].toString();
        this.maxName = values[1].toString();
    }

    @Override
    public String toString() {
        return "MinMaxTestAuto{" +
                "minName='" + minName + '\'' +
                ", maxName='" + maxName + '\'' +
                '}';
    }
}
