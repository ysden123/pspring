package com.stulsoft.jpa;

import javax.persistence.*;

@Entity(name = "SourceLibrary")
@Table(name = "sourceLibraries")
public class SourceLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    protected SourceLibrary() {
    }

    public SourceLibrary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SourceLibrary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
