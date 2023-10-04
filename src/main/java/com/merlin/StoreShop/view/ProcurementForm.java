package com.merlin.StoreShop.view;

import com.merlin.StoreShop.model.Customer;
import com.merlin.StoreShop.model.Procurement;
import com.merlin.StoreShop.model.Product;
import com.merlin.gui.forms.InputField;
import com.merlin.gui.forms.InputForm;
import com.merlin.gui.forms.InputSelect;
import java.util.List;
import java.util.function.Consumer;
import javafx.scene.layout.Pane;

public class ProcurementForm extends InputForm {

    private Procurement instance;
    private List<Product> products;
    private List<Customer> customers;

    public ProcurementForm(Pane parent) {
        super(parent);
        add("accountnumber",new InputField("Számla/Szállítólevél szám"));
        add("product", new InputSelect("Termékek"));
        add("customer", new InputSelect("Beszállítók"));
        add("stock", new InputField("Mennyiség"));
        add("nprice", new InputField("Beszerzési ár"));
        calculteTotalAmount("Beszerzési ár");
        add("totalAmount", new InputField("Végösszeg"));

        instance = null;
    }

    private void calculteTotalAmount(String buttonText) {
        button(buttonText, form
                -> {
            if (instance == null) {
                instance = new Procurement();
            }
            {
                try {
                  String value =  getTotals(parseInteger(form.getValue("stock")), parseInteger(form.getValue("nprice")));
                  form.setValue("totalAmount", value);
                } catch (Exception exception) {
                    System.out.println("not a number");
                      form.setValue("totalAmount", "0");
                }
            }
        });
    }
    
    public String getTotals(Integer stock, Integer price) throws Exception {
        Integer result = 0;
        if (stock * price > Integer.MAX_VALUE) {
            throw new Exception("ohh very big");
        } else {
             result = stock * price;
        }
        return result.toString();
    }
    

    private Integer parseInteger(String number) {
        var numberFromText = Integer.parseInt(number);
        return numberFromText;
    }

    public void setProductsName(List<Product> products) {
        this.products = products;

        InputSelect field = (InputSelect) fields.get("product");
        String[] options = new String[products.size() + 1];

        options[0] = "";

        for (int i = 1; i < options.length; i++) {
            options[i] = products.get(i - 1).getName();

        }
        field.setOptions(options);

    }

    public void setCustomerName(List<Customer> customers) {
        this.customers = customers;

        InputSelect field = (InputSelect) fields.get("customer");
        String[] options = new String[customers.size() + 1];
        options[0] = "";

        for (int i = 1; i < options.length; i++) {

            options[i] = customers.get(i - 1).getName();

        }
        field.setOptions(options);

    }

    /*  public void setValues(Procurement procurement,Product product,Customer customer)
        {
            int accountnumber=procurement.getAccountnumber();
            int stock=procurement.getStock();
            int nprice=procurement.getNprice();
           
            
               instance = procurement;
               
               //setValue("accountnumber",String.valueOf(accountnumber));
               setValue("product", product.getName());
               setValue("customer", customer.getName());
               setValue("stock", String.valueOf(stock));
               setValue("nprice", String.valueOf(nprice));
               setValue("totalAmount", procurement.getAccountnumber());
               setValue("totalAmount", String.valueOf(procurement.getTotalamount(stock, nprice)));
        }
     */
    public void submit(String buttonText, Consumer<Procurement> onClick) {
        button(buttonText, form
                -> {
            if (instance == null) {
                instance = new Procurement();
            }

            instance.setAccountnumber(form.getValue("accountnumber"));
            instance.setProduct(getSelectedProductName(products, form.getValue("product")));
            instance.setCustomer(getSelectedCustomerName(customers, form.getValue("customer")));
            instance.setStock(Integer.parseInt(form.getValue("stock")));
            instance.setNprice(Integer.parseInt(form.getValue("nprice")));
            instance.setTotalamount(Integer.parseInt(form.getValue("totalAmount")));

            onClick.accept(instance);
        });
    }

    private String getSelectedCustomerName(List<Customer> customers, String selectedIndex) {
        return customers.get(Integer.parseInt(selectedIndex) - 1).getName();
    }

    private String getSelectedProductName(List<Product> products, String selectedIndex) {
        return products.get(Integer.parseInt(selectedIndex) - 1).getName();
    }

}
