package com.merlin.StoreShop.view;

import com.merlin.StoreShop.model.Customer;
import com.merlin.StoreShop.model.CustomerRepository;
import com.merlin.StoreShop.model.Product;
import com.merlin.gui.forms.InputField;
import com.merlin.gui.forms.InputForm;
import com.merlin.gui.forms.InputSelect;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javafx.scene.layout.Pane;

public class ProductForm extends InputForm {

    private Product instance; //osztály szinten van deklarálva

    public ProductForm(Pane parent) {
        super(parent);

        add("name", new InputField("Termék neve"));
        add("unittype", new InputSelect("Mennyiségi egység", new String[]{"db", "carton", "display", "set"}));
        add("weight", new InputField("Súly"));

        instance = null;

    }

    public void setValues(Product product) {
        int weight = product.getWeight();

        instance = product;

        setValue("name", product.getName());
        setValue("weight", String.valueOf(weight));
        setValue("unittype", String.valueOf(product.getUnittype()));
        
    }

    public void submit(String buttonText, Consumer<Product> onClick) {
        button(buttonText, form
                -> {
            if (instance == null) {
                instance = new Product();
            }

            instance.setName(form.getValue("name"));
            //instance.setUnittype(form.getValue("unittype"));
            instance.setUnittype(Integer.parseInt(form.getValue("unittype")));

            instance.setWeight(Integer.parseInt(form.getValue("weight")));

            onClick.accept(instance);
        });

    }
}
