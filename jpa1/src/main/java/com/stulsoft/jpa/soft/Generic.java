/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa.soft;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "generic")
public class Generic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "resource_id", nullable = false)
    private Long resourceId;

    @Column(name = "language", nullable = true)
    private String language;

    protected Generic(){

    }

    public Generic(Long resourceId, String language) {
        this.resourceId = resourceId;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "id=" + id +
                ", resourceId=" + resourceId +
                ", language='" + language + '\'' +
                '}';
    }
}
