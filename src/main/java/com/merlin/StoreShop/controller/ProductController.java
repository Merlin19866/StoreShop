package com.merlin.StoreShop.controller;

import com.merlin.StoreShop.AppCore;
import com.merlin.StoreShop.model.Model;
import com.merlin.StoreShop.model.Product;
import com.merlin.StoreShop.view.CustomerForm;
import com.merlin.StoreShop.view.ProductForm;
import com.merlin.StoreShop.view.ProductTable;
import java.util.List;


public class ProductController 
{
    private AppController parent;
    private Model model;
    
     public ProductController(AppController parent) 
    {
        this.parent = parent;
        model = AppCore.getContext().getBean(Model.class);
    }
     
     public void newProduct()
    {
        parent.initview("Új Termék");
        ProductForm form = new  ProductForm(parent.getContainer());
        
        form.submit("Létrehozás", product ->
                {
                    model.save(product);
                    form.clear();
                });
    }
     public void listActivity()
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
     }
}


