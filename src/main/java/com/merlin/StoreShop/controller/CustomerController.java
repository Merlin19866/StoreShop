package com.merlin.StoreShop.controller;

import com.merlin.StoreShop.AppCore;
import com.merlin.StoreShop.model.Customer;
import com.merlin.StoreShop.model.Model;
import com.merlin.StoreShop.view.CustomerForm;
import com.merlin.StoreShop.view.CustomerTable;
import java.util.List;

public class CustomerController 
{
    private AppController parent;
    private Model model;

    public CustomerController(AppController parent) 
    {
        this.parent = parent;
        model = AppCore.getContext().getBean(Model.class);
    }
    public void newCustomer()
    {
        parent.initview("Új Beszállító");
        CustomerForm form = new  CustomerForm(parent.getContainer());
       
        form.submit("Létrehozás", customer ->
                {
                    model.save(customer);
                    form.clear();
                    
                });
    }
    public void listActivity()
     {
         parent.initview("Beszállítók listája");
         
         List<Customer>customers = model.getCustomers();
         
         CustomerTable table = new CustomerTable(parent.getContainer());
         table.setItems(customers);
         table.addActionColumn("::", (customer, index)->
         {
             editButton(customer);
         });
         table.addActionColumn("Törlés", (customer,index)->
         {
              model.delete(customer);
              listActivity();
         });
     }
    public  void editButton(Customer customer)
    {
        parent.initview("Beszállítók módosítása");
        
        CustomerForm form = new CustomerForm(parent.getContainer());
        form.setValues(customer);
        form.submit("Mentés", cust->
        {
            model.save(cust);
            listActivity();
        });
        
    }
}
