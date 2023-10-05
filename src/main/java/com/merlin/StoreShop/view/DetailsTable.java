package com.merlin.StoreShop.view;

import com.merlin.StoreShop.model.Procurement;
import com.merlin.gui.Table;
import java.util.List;
import javafx.scene.layout.Pane;


public class DetailsTable extends Table<Procurement>
{
    
    public DetailsTable(Pane parent) 
    {
        super(parent);
        
        addColumn("Számlaszám/szállító", "accountnumber", 100);
        addColumn("Termék neve", "name", 100);
        addColumn("A termék egységára", "nprice", 100);
        addColumn("Termék ", "product", 100);
        addColumn("A beszállító ", "customer", 110);
        
    }
    public void setItems(List<Procurement>procurements)
    {
        var items = getItems();
        items.clear();
        
        for(Procurement procurement : procurements)
        {
            items.add(procurement);
        }
    
    }
    
}
