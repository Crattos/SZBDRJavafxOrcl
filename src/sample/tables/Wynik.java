package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by creat on 25.04.2017.
 */
public class Wynik {

    private IntegerProperty idSpotkania;
    private IntegerProperty idDruzyny;
    private IntegerProperty idPilkarza;
    private IntegerProperty minuta;


    public Wynik(){
        this(0,0,0,0);
    }

    public Wynik(int idSpotkania, int idDruzyny, int idPilkarza, int minuta) {
        this.idSpotkania = new SimpleIntegerProperty(idSpotkania);
        this.idDruzyny = new SimpleIntegerProperty(idDruzyny);
        this.idPilkarza = new SimpleIntegerProperty(idPilkarza);
        this.minuta = new SimpleIntegerProperty(minuta);
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
}
