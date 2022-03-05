/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "TestVersion")
@Table(name = "test_Versions")
public class TestVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    protected TestVersion() {
    }

    public TestVersion(String name, Integer version) {
        this.name = name;
        this.version = version;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestVersion)) return false;
        TestVersion that = (TestVersion) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && Objects.equals(getVersion(), that.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getVersion());
    }

    @Override
    public String toString() {
        return "TestVersion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
