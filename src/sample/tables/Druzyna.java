package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by creat on 25.04.2017.
 */
public class Druzyna {

    private IntegerProperty id;
    private IntegerProperty idMiasta;
    private StringProperty nazwa;
    private IntegerProperty punkty;
    private IntegerProperty bramki;
    private IntegerProperty iloscSpotkan;

    public Druzyna(){
        this(0,0,"nieznana",0,0,0);
    }

    public Druzyna(int id, int idMiasta, String nazwa, int punkty, int bramki, int iloscSpotkan) {
        this.id = new SimpleIntegerProperty(id);
        this.idMiasta = new SimpleIntegerProperty(idMiasta);
        this.nazwa = new SimpleStringProperty(nazwa);
        this.punkty = new SimpleIntegerProperty(punkty);
        this.bramki = new SimpleIntegerProperty(bramki);
        this.iloscSpotkan = new SimpleIntegerProperty(iloscSpotkan);
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

    public int getIdMiasta() {
        return idMiasta.get();
    }

    public IntegerProperty idMiastaProperty() {
        return idMiasta;
    }

    public void setIdMiasta(int idMiasta) {
        this.idMiasta.set(idMiasta);
    }

    public String getNazwa() {
        return nazwa.get();
    }

    public StringProperty nazwaProperty() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa.set(nazwa);
    }

    public int getPunkty() {
        return punkty.get();
    }

    public IntegerProperty punktyProperty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty.set(punkty);
    }

    public int getBramki() {
        return bramki.get();
    }

    public IntegerProperty bramkiProperty() {
        return bramki;
    }

    public void setBramki(int bramki) {
        this.bramki.set(bramki);
    }

    public int getIloscSpotkan() {
        return iloscSpotkan.get();
    }

    public IntegerProperty iloscSpotkanProperty() {
        return iloscSpotkan;
    }

    public void setIloscSpotkan(int iloscSpotkan) {
        this.iloscSpotkan.set(iloscSpotkan);
    }
}
