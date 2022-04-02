package com.stulsoft.jpa;

import javax.persistence.*;

@Entity(name = "Nested2")
@Table(name = "nested2s")
public class Nested2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "kind", nullable = true)
    private String kind;

    protected Nested2() {
    }

    public Nested2(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Nested2{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                '}';
    }
}
