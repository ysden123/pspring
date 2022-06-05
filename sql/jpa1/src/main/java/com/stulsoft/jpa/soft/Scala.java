/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa.soft;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "scala")
public class Scala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "resource_id", nullable = false)
    private Long resourceId;

    @Column(name = "version", nullable = true)
    private String version;

    protected Scala(){

    }

    public Scala(Long resourceId, String version) {
        this.resourceId = resourceId;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Scala{" +
                "id=" + id +
                ", resourceId=" + resourceId +
                ", version='" + version + '\'' +
                '}';
    }
}
