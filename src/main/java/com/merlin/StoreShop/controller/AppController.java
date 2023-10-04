
package com.merlin.StoreShop.controller;


import com.merlin.StoreShop.AppCore;
import com.merlin.StoreShop.model.Model;
import com.merlin.StoreShop.model.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class AppController implements Initializable 
{
    CustomerController  customercontroller;
    ProcurementController packlistcontroller;
    ProductController productcontroller;
    ProcurementController procurementcontroller;
    
    @FXML
    private Label txtTitle;
    @FXML 
    private Pane container;
   
    @FXML
    void newProcurement()
    {
        procurementcontroller.newProcurement();
    }
    @FXML
    void newCustomer()
    {
        customercontroller.newCustomer();
    }
    @FXML
    void newProduct()
    {
        productcontroller.newProduct();
    }
    @FXML
    void ListofProduct()
    {
        productcontroller.listActivity();
    }
    @FXML
    void ListofCustomer()
    {
    customercontroller.listActivity();
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       customercontroller = new CustomerController(this);
       packlistcontroller  = new ProcurementController(this);
       productcontroller = new ProductController(this);
       procurementcontroller = new ProcurementController(this);
       
       newProcurement();
    }    

    public Pane getContainer() /*ez azért kell,hogy más osztály is meg tudják kapni a container objektumot*/
    {
        return container;
    }
    
    public void initview(String title)
    {
        txtTitle.setText(title);
        container.getChildren().clear();
    }
}
