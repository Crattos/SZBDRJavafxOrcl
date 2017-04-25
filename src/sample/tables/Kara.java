package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by creat on 25.04.2017.
 */
public class Kara {

    private IntegerProperty idSpotkania;
    private IntegerProperty idDruzyny;
    private IntegerProperty idPilkarza;
    private IntegerProperty minuta;
    private StringProperty kara;


    public Kara(){
        this(0,0,0,0,"nic");
    }

    public Kara(int idSpotkania, int idDruzyny, int idPilkarza, int minuta, String kara) {
        this.idSpotkania = new SimpleIntegerProperty(idSpotkania);
        this.idDruzyny = new SimpleIntegerProperty(idDruzyny);
        this.idPilkarza = new SimpleIntegerProperty(idPilkarza);
        this.minuta = new SimpleIntegerProperty(minuta);
        this.kara = new SimpleStringProperty(kara);
    }

    public int getIdSpotkania() {
        return idSpotkania.get();
    }

    public IntegerProperty idSpotkaniaProperty() {
        return idSpotkania;
    }

    public void setIdSpotkania(int idSpotkania) {
        this.idSpotkania.set(idSpotkania);
    }

    public int getIdDruzyny() {
        return idDruzyny.get();
    }

    public IntegerProperty idDruzynyProperty() {
        return idDruzyny;
    }

    public void setIdDruzyny(int idDruzyny) {
        this.idDruzyny.set(idDruzyny);
    }

    public int getIdPilkarza() {
        return idPilkarza.get();
    }

    public IntegerProperty idPilkarzaProperty() {
        return idPilkarza;
    }

    public void setIdPilkarza(int idPilkarza) {
        this.idPilkarza.set(idPilkarza);
    }

    public int getMinuta() {
        return minuta.get();
    }

    public IntegerProperty minutaProperty() {
        return minuta;
    }

    public void setMinuta(int minuta) {
        this.minuta.set(minuta);
    }

    public String getKara() {
        return kara.get();
    }

    public StringProperty karaProperty() {
        return kara;
    }

    public void setKara(String kara) {
        this.kara.set(kara);
    }
}
