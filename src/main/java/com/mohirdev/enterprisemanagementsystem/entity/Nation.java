package com.mohirdev.enterprisemanagementsystem.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Nation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nation")
    private String nation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
