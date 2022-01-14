/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "table1")
public class TableAll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "age", nullable = true)
    private Integer age;

    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "name",
            referencedColumnName = "name",
            insertable = false, updatable = false,
            foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Table2 table2;

    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "name",
            referencedColumnName = "name",
            insertable = false, updatable = false,
            foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Table3 table3;

    protected TableAll() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Table2 getTable2() {
        return table2;
    }

    @Override
    public String toString() {
        return "TableAll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", table2=" + table2 +
                ", table3=" + table3 +
                '}';
    }
}
