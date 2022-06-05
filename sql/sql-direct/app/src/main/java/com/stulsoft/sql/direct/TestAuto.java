package com.stulsoft.sql.direct;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "TestAuto")
@Table(name = "test_Autos")
public class TestAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;


    protected TestAuto() {
    }

    public TestAuto(Long id, String name) {
        this.id=id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestAuto)) return false;
        TestAuto testAuto = (TestAuto) o;
        return getId().equals(testAuto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TestAuto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}