package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by creat on 25.04.2017.
 */
public class Trener {
    private IntegerProperty id;
    private IntegerProperty idDruzyny;
    private StringProperty imie;
    private StringProperty nazwisko;
    private StringProperty wiek;
    private StringProperty narodowosc;

    public Trener(){
        this(0,0,"nieznany","nieznany","0/0/0","nieznana");
    }

    public Trener(int id, int idDruzyny, String imie, String nazwisko, String wiek,  String narodowosc) {
        this.id = new SimpleIntegerProperty(id);
        this.idDruzyny = new SimpleIntegerProperty(idDruzyny);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.wiek = new SimpleStringProperty(wiek);
        this.narodowosc = new SimpleStringProperty(narodowosc);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    public String getImie() {
        return imie.get();
    }

    public StringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public StringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getWiek() {
        return wiek.get();
    }

    public StringProperty wiekProperty() {
        return wiek;
    }

    public void setWiek(String wiek) {
        this.wiek.set(wiek);
    }

    public String getNarodowosc() {
        return narodowosc.get();
    }

    public StringProperty narodowoscProperty() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc.set(narodowosc);
    }
}
