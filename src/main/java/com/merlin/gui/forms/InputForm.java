package com.merlin.gui.forms;
/*inpuit mezők csoportják kezelhetnénk mint egy formot inputfieldekre fogadására alkalmas, 
add lehet,hozzáadnigombokat hoz létre név megnevézés alapján tudnál kiolvasni különböző beviteli mezők értékét
*/
import java.util.HashMap;
import java.util.function.Consumer;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/*az inputform az a lényege,hogy bel tudunk dobálgatni különböző inputfieldeket és bele tudunk rakni gombokat és 
műveletsort tudunk megadni mi történjen gomb megnyomásakor,esetleg beviteli mezőknek be tudunk állítani értékeket
Hasmap arra jó,hogy kulcs érték párokat fogad,elemeket úgy helyezek bele,hogy adok neki egy kulcsot gyakorlatilag a
belehelyezet adatnak nevet tudok adni és név alapján tudom kiszedni */
public class InputForm extends VBox //vboxra kiterjesztve egy konténerben legyen
{
    protected HashMap<String, InputField> fields;
    /*String kulcsokkal ellátott elemei vannak és inputfield tipusú elemeket foglal magában
    így mikor hozzáadunk valamit akkor szöveges key értékkel nevezzük el amit bele akarok tenni
    és egy inputfield elemet rakok bele*/
    /*A Hasmapnél nem csak azt mondjuk meg,hogy milyen elemeket tartalmazz(inputfield) hanem előtte azt is,hogy 
    milyen típusú kulcsot esetünkben Stringet.
    Hasmapnek az a lényege,hogy elemeket akár általam megadott szöveges kulcs érték alapján tudjak berakni
    és kivenni pl ha e-maulnek nevezem el akkor e-mail-re hivatkozva kivehetem*/        
    public InputForm(Pane parent)
    {
        fields = new HashMap<>();
        parent.getChildren().add(this);//saját magamat helyezem a megadott szülőelemen
        VBox.setMargin(this, new Insets(20,30,30,20) );
    }
    
    public void add(String key, InputField field)//inputfield objektumokat tud hozzáadni és egy string típusú key
    {
        fields.put(key, field);//ezeket pedig az adatok miatt fontos fields .put adunk hozzá
        getChildren().add(field);//és saját magához is oda adja ez a megjelenítés szempontjából fontos
    }
    
    public void button(String buttonText, Consumer<InputForm> onClick)/*mi jelenjen meg a gombon bottontest,
            mi történjen a gomb megnyomásakor consumer ami majd végrehajtáskor argumentumkor egy utasítást kap
            ami maga az inputform és a consumer onClicknek fogjuk elnevezni. 
        a concumer egy eljárást tud eltárolni magában egy konkrét művelet sort jelent mikor rákattintunk a gombra
          a mi példánkban ha rákattintunk a gombra  values változó formájában egy inputform objektumot,hogy
            tudjam olvasni az értékeket a művelet során kezeljen egy értéket*/
    {
        Button button = new Button(buttonText);
        getChildren().add(button);
        
        button.setOnAction(evt ->//lambdás szerkezet amit leírok az végrehajtásra kerül
        {
            onClick.accept(this);//mivel inputformot kell továbbítani így saját magam továbbítom
            
            
        });
    }
    
    public String getValue(String key) //lehetőséget ad,hogy adott inputfield értékeket megtudjak kérdezni
    {
        if(fields.containsKey(key))//ha tartalmaz ilyen kulcst akkor return-be rak
        {
            return fields.get(key).getValue();
        }
        return null;
        
    }
    public void setValue(String key, String value)
    {
        if(fields.containsKey(key))//ha létezik a key-nek megfelelő beviteli mező
        {
            fields.get(key).setValue(value);/*fontos,hogy mikor azt írjuk,hogy fields.get(key) ez egy inputfields
            objektumot ad oda nekem a fields listámból és annak mondom,hogy setValue*/
        }
    }
    public void clear() //minden beviteli mezőt visszaállítunk üres állapotra
    {   
        fields.forEach((key,field)->/*forEach megmondhatod milyen művelet végrehajtás történjen meg összes 
   elemre vonatkozóan csak tudni kell,hogy milyen paramétereket kapt.esetünkben egy keyt és egy beviteli mezőt*/
        {
            field.setValue("");//setvaluvel állítjuk be,hogy üres
        });
    }
}
