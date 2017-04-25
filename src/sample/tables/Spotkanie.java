package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by creat on 25.04.2017.
 */
public class Spotkanie {
    private IntegerProperty id;
    private IntegerProperty idSedzi;
    private IntegerProperty idDruzyny1;
    private IntegerProperty idDruzyny2;
    private IntegerProperty idMiasta;
    private IntegerProperty bramkiD1;
    private IntegerProperty bramkiD2;
    private StringProperty data; //TO_DATE('17/04/25', 'RR/MM/DD')


    public Spotkanie(){
        this(0,0,0,0,0,0,0,"nieznana");
    }

    public Spotkanie(int id, int idSedzi, int idDruzyny1, int idDruzyny2, int idMiasta, int bramkiD1, int bramkiD2, String data) {
        this.id = new SimpleIntegerProperty(id);
        this.idSedzi = new SimpleIntegerProperty(idSedzi);
        this.idDruzyny1 = new SimpleIntegerProperty(idDruzyny1);
        this.idDruzyny2 = new SimpleIntegerProperty(idDruzyny2);
        this.idMiasta = new SimpleIntegerProperty(idMiasta);
        this.bramkiD1 = new SimpleIntegerProperty(bramkiD1);
        this.bramkiD2 = new SimpleIntegerProperty(bramkiD2);
        this.data = new SimpleStringProperty(data);

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

    public int getIdSedzi() {
        return idSedzi.get();
    }

    public IntegerProperty idSedziProperty() {
        return idSedzi;
    }

    public void setIdSedzi(int idSedzi) {
        this.idSedzi.set(idSedzi);
    }

    public int getIdDruzyny1() {
        return idDruzyny1.get();
    }

    public IntegerProperty idDruzyny1Property() {
        return idDruzyny1;
    }

    public void setIdDruzyny1(int idDruzyny1) {
        this.idDruzyny1.set(idDruzyny1);
    }

    public int getIdDruzyny2() {
        return idDruzyny2.get();
    }

    public IntegerProperty idDruzyny2Property() {
        return idDruzyny2;
    }

    public void setIdDruzyny2(int idDruzyny2) {
        this.idDruzyny2.set(idDruzyny2);
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

    public int getBramkiD1() {
        return bramkiD1.get();
    }

    public IntegerProperty bramkiD1Property() {
        return bramkiD1;
    }

    public void setBramkiD1(int bramkiD1) {
        this.bramkiD1.set(bramkiD1);
    }

    public int getBramkiD2() {
        return bramkiD2.get();
    }

    public IntegerProperty bramkiD2Property() {
        return bramkiD2;
    }

    public void setBramkiD2(int bramkiD2) {
        this.bramkiD2.set(bramkiD2);
    }

    public String getData() {
        return data.get();
    }

    public StringProperty dataProperty() {
        return data;
    }

    public void setData(String data) {
        this.data.set(data);
    }

}
