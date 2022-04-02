package com.stulsoft.jpa;

import javax.persistence.*;

@Entity(name = "SourceFile")
@Table(name = "sourceFiles")
public class SourceFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "sha1", nullable = true)
    private String sha1;

    protected SourceFile() {
    }

    public SourceFile(String name, String sha1) {
        this.name = name;
        this.sha1 = sha1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    @Override
    public String toString() {
        return "SourceFile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sha1=" + sha1 +
                '}';
    }
}
