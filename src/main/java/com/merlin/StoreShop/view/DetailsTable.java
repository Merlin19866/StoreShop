package com.merlin.StoreShop.view;

import com.merlin.StoreShop.model.Product;
import com.merlin.gui.Table;
import javafx.scene.layout.Pane;


public class DetailsTable extends Table<Product>
{
    
    public DetailsTable(Pane parent) 
    {
        super(parent);
        
        addColumn("Beszállító", "name", 0);
        addColumn("Ára", "price", 0);
    }
    
}
