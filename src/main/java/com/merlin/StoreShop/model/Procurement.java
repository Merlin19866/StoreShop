package com.merlin.StoreShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table (name="str_procurement")
public class Procurement
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    private int stock;
    private String accountnumber;
    private int totalamount;
    private int nprice;
    private String name;
    private String product;
    private String customer;

    public Procurement(int stock, String accountnumber, int totalamount, int nprice, String name, String product, String customer) {
        this.stock = stock;
        this.accountnumber = accountnumber;
        this.totalamount = totalamount;
        this.nprice = nprice;
        this.name = name;
        this.product = product;
        this.customer = customer;
    }


    public Procurement() 
    {
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    

    public int getStock() {
        return stock;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    /*public int getBprice() 
    {
        return bprice;
    }*/

    public int getNprice() {
        return nprice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    /*public void setBprice(int bprice) {
        this.bprice = bprice;
    }*/

    public void setNprice(int nprice) {
        this.nprice = nprice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }
    
    public int getTotalamount(int stock,int nprice)
    {
        return stock*nprice;
    }
   
}

    