package com.gunshop.gungame.model;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private Double cost;
    private String type_equipment;
    private Integer production_date;

    public Equipment(Long id, String name, Double cost, String type_equipment, Integer production_date) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.type_equipment = type_equipment;
        this.production_date = production_date;
    }

    public Equipment() {

    }

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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getType_equipment() {
        return type_equipment;
    }

    public void setType_equipment(String type_equipment) {
        this.type_equipment = type_equipment;
    }

    public Integer getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Integer production_date) {
        this.production_date = production_date;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", type_equipment='" + type_equipment + '\'' +
                ", production_date=" + production_date +
                '}';
    }
}
