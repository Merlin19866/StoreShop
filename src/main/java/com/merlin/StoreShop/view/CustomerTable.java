package com.merlin.StoreShop.view;

import com.merlin.StoreShop.model.Customer;
import com.merlin.gui.Table;
import java.util.List;
import javafx.scene.layout.Pane;

public class CustomerTable extends Table<Customer>
{
    
    public CustomerTable(Pane parent) 
    {
        super(parent);
        
        addColumn("A beszállító neve", "name", 100);
        addColumn("A beszállító típusa", "type", 100);
        addColumn("Fizetési mód", "payment", 100);
        
        setPlaceholder("Nincs Beszállító");
    }
    public void setItems(List<Customer>customers)
    {
        var items = getItems();
        items.clear();
        
        for(Customer customer : customers)
        {
           items.add(customer);
        }
    }
}
