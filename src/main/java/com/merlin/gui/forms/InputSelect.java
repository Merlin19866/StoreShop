package com.merlin.gui.forms;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
/*Egyetlen típus jelentse azt,hogy címke és beviteli mező páros*/
public class InputSelect extends InputField
{
    public InputSelect(String text,String[] options )
    {
        super(text);
        setOptions(options);/*eleve options-kel hozzam létre*/
    }
    
    public InputSelect(String text)/**/
    {
        super(text);
    }
    
    public void setOptions(String[] options)/*egy string tömböt adunk neki amiben opciókat sorakoztatounk fel
            amik közül lehet válogatni.*/
    {
        ComboBox box = (ComboBox)field; //itt irányított combox lesz
        var items = box.getItems();
        
        for(String option : options)//bejárjuk az options töbmet az option
        {
            items.add(option);
        }
        setValue("0");//alapból az első lesz kiválasztva 
    }

    @Override/*felülkell írni,hogy máshogy viselkedjen mint az ősosztály
    */
    public void setValue(String value) 
    {
        ComboBox box = (ComboBox)field;
        int index = value == "" ? 0:Integer.parseInt(value);/*integer.parseint szöveges számból egy egész szám lesz
        amennyiben value üres vagy 0 akkor átalakítja számmá ez azért kell,mert a clear függvénnyel töröljük a mezőket
        és ezért kitörölni az alap beállított opciót esetünkben az első*/
        box.getSelectionModel().select(index);//
    }
    @Override
    public String getValue() 
    {
        ComboBox box = (ComboBox)field;
        int index = box.getSelectionModel().getSelectedIndex();
        return Integer.toString(index);
    }
    
    

    @Override
    protected Control createField() /*beviteli mező létrehozásakor az alapot kitöröltem és létrehoztam egy
            comboboxot egy lenyíló listát*/
    {
        return new ComboBox();
    }
    
    
}
