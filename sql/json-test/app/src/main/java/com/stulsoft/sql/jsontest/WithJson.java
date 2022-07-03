package com.stulsoft.sql.jsontest;

import javax.persistence.*;

@Entity(name = "WithJson")
@Table(name="with_jsons")
public class WithJson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private JsonTypes type;

//    @Lob
    @Column(name = "data")
    private String jsonData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JsonTypes getType() {
        return type;
    }

    public void setType(JsonTypes type) {
        this.type = type;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String toString() {
        return "WithJson{" +
                "id=" + id +
                ", type=" + type +
                ", jsonData='" + jsonData + '\'' +
                '}';
    }
}
