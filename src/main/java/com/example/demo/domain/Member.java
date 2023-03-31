package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "s1")
    @SequenceGenerator(name="s1", sequenceName = "s1", initialValue = 1, allocationSize = 1)

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
