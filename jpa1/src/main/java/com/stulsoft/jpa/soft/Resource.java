/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa.soft;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(
            name = "id",
            referencedColumnName = "resource_id",
            insertable = false, updatable = false,
            foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Generic generic;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(
            name = "id",
            referencedColumnName = "resource_id",
            insertable = false, updatable = false,
            foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Scala scala;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Generic getGeneric() {
        return generic;
    }

    public Scala getScala() {
        return scala;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", generic=" + generic +
                ", scala=" + scala +
                '}';
    }
}
