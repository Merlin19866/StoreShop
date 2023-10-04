package com.merlin.StoreShop.view;

import com.merlin.StoreShop.model.Product;
import com.merlin.gui.Table;
import java.util.List;
import javafx.scene.layout.Pane;

public class ProductTable extends Table<Product>
{
    
    public ProductTable(Pane parent)
    {
        super(parent);
        
        addColumn("Termék neve", "name", 100);
        addColumn("Mennyiségi egység","unittype",120);
        addColumn("Súly", "weight", 100);
        
        setPlaceholder("Nincs termék");
        
    }
    public void setItems(List<Product>products)
    {
        var items = getItems();
        items.clear();
        
        for(Product product : products)
        {
            items.add(product);
        }
    
    }
    
}
