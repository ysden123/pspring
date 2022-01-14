/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "table1")
public class Table1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "age", nullable = true)
    private Integer age;

    protected Table1() {
    }

    public Table1(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table1)) return false;
        Table1 table1 = (Table1) o;
        return getId().equals(table1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
