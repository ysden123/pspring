/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "table3")
public class Table3 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "width", nullable = true)
    private Integer width;

    protected Table3(){}

    public Table3(String name, Integer width) {
        this.name = name;
        this.width = width;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table3)) return false;
        Table3 table2 = (Table3) o;
        return Objects.equals(getId(), table2.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Table2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", width=" + width +
                '}';
    }
}
