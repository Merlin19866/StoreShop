package com.merlin.StoreShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="str_customers")
public class Customer 
{
    /*automata id generálás*/
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    @Column (length = 65)
    private String name;
    private String type;
    private String payment;

    public Customer(String name, String type, String payment) {
        this.name = name;
        this.type = type;
        this.payment = payment;
    }

   
    public Customer() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPayment() {
        return payment;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setType(int type) 
    {
        if(type==0)
        {
            this.type="Magánszemély";
        }
        else
        {
            this.type = "Cég";
        }
        
    }
    public void setPayment(int b) 
    {
        if(b == 0)
        {  
            this.payment = "Készpénz";
        }
        else if(b == 1)
        {
            this.payment = "Bankártya";
        }
        else
        {
            this.payment ="Átutalás";
        }
    }
    
     public void setPayment(String payment) {
        this.payment = payment;
    }
   

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", type=" + type + ", payment=" + payment + '}';
    }
  
    
    
}
