package com.merlin.StoreShop.view;

import com.merlin.StoreShop.model.Customer;
import com.merlin.gui.forms.InputField;
import com.merlin.gui.forms.InputForm;
import com.merlin.gui.forms.InputSelect;
import java.util.function.Consumer;
import javafx.scene.layout.Pane;

public class CustomerForm extends InputForm
{
   
    public CustomerForm(Pane parent) 
    {
        super(parent);
  
        add("name", new InputField("Beszállító neve"));
        add("type",new InputSelect("Beszállító fajtája",new String[]{"Magánszemély","Cég"}));
        add("payment",new InputSelect("Fizetőeszköz", new String[]{"Készpénz","Bankártya","átutalás"}));
        
    }
public void setValues(Customer customer)
        {
            
        }
  
    public void submit(String buttonText, Consumer<Customer> onClick) 
    {
       button(buttonText,form ->
       {
        Customer customer = new Customer();
        
        customer.setName(form.getValue("name"));
        customer.setType(Integer.parseInt(form.getValue("type")));
        customer.setPayment(Integer.parseInt(form.getValue("payment")));
        
        onClick.accept(customer);
       });
    }
    
}
