/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "table2")
public class Table2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "height", nullable = true)
    private Integer height;

    protected Table2(){}

    public Table2(String name, Integer height) {
        this.name = name;
        this.height = height;
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
        if (!(o instanceof Table2)) return false;
        Table2 table2 = (Table2) o;
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
                ", height=" + height +
                '}';
    }
}
