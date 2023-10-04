package com.merlin.gui;

import java.util.function.BiConsumer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

//A Table-t a Tableview-ból fogjuk előhozni.
public class Table <T> extends TableView<T>/*TablevView-ből származtatjuk osztályból rögtön minden olyan
        funkciónalitást benne van tudsz placeholdert beállíttani magasságot szélességet illetve amit Tableviewal 
        megtudsz csinálni azt egy table-el is megtudsz
        <T betüvel megadjuk általános típus nevet,ez is egy paraméter>*/
{   
    public Table(Pane parent)/*egy ős osztályt adtam ami pane-ből származik így használhatunk Vbox,Hboxot is
            mivel  megkapja a pane tulajdonságait*/
    {
        super(); //ez a konstruktor super a szülő osztály tulajdonságaival is bír
        parent.getChildren().add(this);//saját magát hozzáadja a szülő elemhez
        
    }
    
    public void addColumn(String header, String propertyName, int width)/*ezek a sorok nevei,
            T-vel határozzuk meg milyen tipusúak az oszlopok */
    {
        TableColumn<T, String> column = new TableColumn<>(header);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));//
        column.setMinWidth(width);// itt adjuk meg a szélsséget
        getColumns().add(column);
    }
    public void addActionColumn(String buttonText, BiConsumer<T, Integer> onClick )
    {/*buttontext gomb felirat ,
        BiConsumer típus két értékekel is tud dolgozni a példánkban T típus person illetve egy index értéket és e*/
        TableColumn<T, String> column = new TableColumn<>();
        /*callback egy eljárást képes magában foglalni olyan mint egy függvényvt vagy eseményt képes eltárolni magában
        letárolok benne egy eljárást és egy paramétert
        callbak a tablecell hoz létre és megkapja paraméterként.*/
        Callback< TableColumn<T, String>, TableCell<T, String>> factory;/*a callbackolyan program tárolására 
        alkamas ami adott típusú értéket fogad és adott tipusú értéket állít elő
        */
        factory = new Callback<>()/*a callback egy mechanizmust ,rövidke programrészt olyan mintha egy
                rövid kis függvényt tárol le benne eltudunk tárolni egy művelet sort ami egy adott ponton végrehajtásra
                kerül*/
        {
            @Override
            public TableCell<T, String> call(TableColumn<T, String> p)
            {
                TableCell<T,String> cell = new TableCell<>()
                {
                    /*tablecell felülbírálok,hogy eltérően viselkedjen jelen példában a cell frissítse magát*/
                    @Override
                    protected void updateItem(String t, boolean empty) 
                    {
                        super.updateItem(t, empty); //ezzel mondom meg,hogy mi történjen meg szülő osztály szintén
                        
                        if(empty)
                        {
                            setGraphic(null);
                        }
                        else
                        {
                                Button button = new Button(buttonText);
                                button.setOnAction(evt ->
                                {
                                    int index =getIndex();//leakarom kérni hanyadik cella vagyok
                                    T entity = getTableRow().getItem();//letudom kérni a sort ami részét képezi.
                                    
                                    onClick.accept(entity, index);/*bicomsumert objektum aminek van egy 
                                    accept függvénye ami T tipusú és egy integer típusu értéket vár
                                    úgy mükődik,hogy mikor azt mondom,hogy accept akkor fog lefutni az a prorgramrész
                                    amit meghatároztunk itt két értéket is vár*/
                                });
                                
                                setGraphic(button);
                        }
                        setText(null);
                    }
                    
                };
                return cell;
            }
        }; 
        
        column.setCellFactory(factory);
        getColumns().add(column);
    }
    public void addItem(T item)
    {
        getItems().add(item);
    }
    
    public void setPlaceholder(String placeholder)
    {
        //annyit csinál,hogy meghívja a saját placeholder függvégényét ami már labeleldolgozik
        setPlaceholder(new Label(placeholder));
    }
    
}
