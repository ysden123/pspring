package com.stulsoft.jpa;

import javax.persistence.*;

@Entity(name = "Container")
@Table(name = "containers")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name="nestedId")
    private Nested nested;

    @ManyToOne
    @JoinColumn(name="nested2Id")
    private Nested2 nested2;

    protected Container(){

    }

    public Container(String type, Nested nested) {
        this.type = type;
        this.nested = nested;
    }

    public Container(String type, Nested nested, Nested2 nested2) {
        this.type = type;
        this.nested = nested;
        this.nested2 = nested2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Nested getNested() {
        return nested;
    }

    public void setNested(Nested nested) {
        this.nested = nested;
    }

    public Nested2 getNested2() {
        return nested2;
    }

    public void setNested2(Nested2 nested2) {
        this.nested2 = nested2;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", nested=" + nested +
                ", nested2=" + nested2 +
                '}';
    }
}
