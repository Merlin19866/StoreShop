package com.merlin.StoreShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "str_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 50)
    private String name;
    private String unittype;
    private int weight;

    @ManyToOne
    private Customer customer;

    public Product(String name, int weight, String unittype) {
        this.name = name;
        this.weight = weight;
        this.unittype = unittype;
    }

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getUnittype() {
        return unittype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setUnittype(String unittype) {
        this.unittype = unittype;
    }

    public void setUnittype(int a)
    {
        if (a == 0) 
            {
                this.unittype = "db";
            } 
        else if (a == 1) 
            {
                this.unittype = "karton";
            } 
        else if (a == 2) 
            {
                this.unittype = "display";
            } 
        else 
            {
                this.unittype = "set";
            }

    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", unittype=" + unittype + ", weight=" + weight + '}';
    }

}
