package com.merlin.StoreShop.controller;

import com.merlin.StoreShop.AppCore;
import com.merlin.StoreShop.model.Customer;
import com.merlin.StoreShop.model.Model;
import com.merlin.StoreShop.model.Procurement;
import com.merlin.StoreShop.model.Product;
import com.merlin.StoreShop.view.ProcurementForm;
import com.merlin.StoreShop.view.ProductForm;
import com.merlin.StoreShop.view.ProductTable;
import java.util.List;

public class ProcurementController 
{
    private AppController parent;
    private Model model;    

public ProcurementController(AppController parent) 
    {
        this.parent = parent;
        model = AppCore.getContext().getBean(Model.class);
    }
public void newProcurement()
{
    parent.initview("Új bevételezés");
    
    List<Product> products = model.getProducts();
    List<Customer>customers = model.getCustomers();
    
    ProcurementForm form = new ProcurementForm(parent.getContainer());
    
    form.setProductsName(products);
    form.setCustomerName(customers);
    
    form.submit("Létrehozás",Procurement ->
    {
       model.save(Procurement);
        form.clear();
    });

    
}
    /* public void listActivity()
     {
         parent.initview("Termékek listája");
         
         List<Product>products = model.getProducts();
         
         ProductTable table = new ProductTable(parent.getContainer());
         table.setItems(products);
         table.addActionColumn("::", (product, index)->
         {
             editButton(product);
         });
         table.addActionColumn("Törlés", (product,index)->
         {
              model.delete(product);
              listActivity();
         });
     }
     public void editButton(Product product)
     {
         parent.initview("Termék módosítása");
         
         ProductForm form = new ProductForm(parent.getContainer());
         form.setValues(product);
         form.submit("Mentés", prod->
         {
             model.save(prod);
             listActivity();
         });
     }*/
}