package com.merlin.gui.forms;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InputField extends VBox
{
    private Label label;//
    protected Control field; /*control,mert ugyanilyen contorol típusu változókba egyéb más elemeket is bele tudjunk
    combox,stb inputfield combatiblis legyen az ősosztályok egyedi beviteli mezőivel is 
    a control a beviteli mezők öse*/
    
    public InputField(String text)//második konstruktor itt csak a szöveget tudom
    {/*be tudunk álltani egyből spacinget meg margókat,mert az inputfield ki lett terjesztve a vboxra
        */
        label = new Label(text);
        field = createField();
        
        setSpacing(10);
        VBox.setMargin(this, new Insets(10,20,30,0));
        
      getChildren().add(label);
      getChildren().add(field);
    }
     public InputField(String text, Pane parent)//konstruktor itt a szöveget is tudom és szülőelemet is
    {
        this(text);
        parent.getChildren().add(this);//saját magamat hozzáadom szülőelememhez
    }
     
    public String getValue()/*mivel a field a control típusú objektumként van deklarálva itt nekünk kell gondosokodni
            hogy kasztoljon egy speciálsabb oszátlypéldánnyá ami gettext és settextel is rendlekezzen*/
    {   
        TextInputControl control = (TextInputControl)field;
        return control.getText();
    }
     public void setValue(String value)
     {
         TextInputControl control = (TextInputControl)field;
         control.setText(value);
     }
     
     public void setPlaceholder(String placeholder)// üres állapotban 
     {
         TextInputControl control = (TextInputControl)field;
            control.setPromptText(placeholder);//üres ablak beállízásta
     }
     
     protected Control createField()/*ez azért kell,mert itt dől el milyen bevíteli mező fieldjéről van szó*/
     {
         return new TextField();
     }
}
