package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.NumberStringConverter;
import sample.Connector;
import sample.tables.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    private Connector connector;








    @FXML
    public TableView<Miasto> miasta;
    @FXML
    public TableColumn<Miasto, Number> miastoID;
    @FXML
    public TableColumn<Miasto, String> miastoNazwa;

    public TableView<Druzyna> druzyny;
    public TableColumn<Druzyna, Number> druzynyId;
    public TableColumn<Druzyna, Number> druzynyMiastaId;
    public TableColumn<Druzyna, String> druzynyNazwa;
    public TableColumn<Druzyna, Number> druzynyPunkty;
    public TableColumn<Druzyna, Number> druzynyBramki;
    public TableColumn<Druzyna, Number> druzynyIloscSpotkan;


    public TableView <Pilkarz>          pilkarze;
    public TableColumn<Pilkarz, Number> pilkarzeId;
    public TableColumn<Pilkarz, Number> pilkarzeDruzynyId;
    public TableColumn<Pilkarz, String> pilkarzeImie;
    public TableColumn<Pilkarz, String> pilkarzeNazwisko;
    public TableColumn<Pilkarz, String> pilkarzeDataUrodzenia;
    public TableColumn<Pilkarz, String> pilkarzePozycja;
    public TableColumn<Pilkarz, String> pilkarzeNarodowosc;

    public TableView  <Trener>trenerzy;
    public TableColumn<Trener, Number>trenerzyId;
    public TableColumn<Trener, Number>trenerzyDruzynyId;
    public TableColumn<Trener, String>trenerzyImie;
    public TableColumn<Trener, String>trenerzyNazwisko;
    public TableColumn<Trener, String>trenerzyDataUrodzenia;
    public TableColumn<Trener, String>trenerzyNarodowosc;

    public TableView  <Sedzia>sedziowie;
    public TableColumn<Sedzia, Number>sedziowieId;
    public TableColumn<Sedzia, String>sedziowieImie;
    public TableColumn<Sedzia, String>sedziowieNazwisko;

    public TableView  <Spotkanie> spotkania;
    public TableColumn<Spotkanie, Number> spotkaniaId;
    public TableColumn<Spotkanie, Number> spotkaniaSedziaId;
    public TableColumn<Spotkanie, Number> spotkaniaDruzynaId;
    public TableColumn<Spotkanie, Number> spotkaniaMiastaId;
    public TableColumn<Spotkanie, Number> spotkaniaDruzyna2Id;
    public TableColumn<Spotkanie, Number> spotkaniaBramkiD1;
    public TableColumn<Spotkanie, Number> spotkaniaBramkiD2;
    public TableColumn<Spotkanie, String> spotkaniaData;


    public TableView  <Wynik> wyniki;
    public TableColumn<Wynik, Number> wynikiSpotkaniaId;
    public TableColumn<Wynik, Number> wynikiDruzynaId;
    public TableColumn<Wynik, Number> wynikiPilkarzId;
    public TableColumn<Wynik, Number> wynikiMinuta;


    public TableView  <Kara>  kary;
    public TableColumn<Kara, Number> karySpotkaniaId;
    public TableColumn<Kara, Number> karyDruzynaId;
    public TableColumn<Kara, Number> karyPilkarzId;
    public TableColumn<Kara, Number> karyMinuta;
    public TableColumn<Kara, String> karyKara;




    private void connectTableColumns() {


        miastoID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        miastoNazwa.setCellValueFactory(cellData -> cellData.getValue().nazwaProperty());

        druzynyId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        druzynyMiastaId.setCellValueFactory(cellData -> cellData.getValue().idMiastaProperty());
        druzynyNazwa.setCellValueFactory(cellData -> cellData.getValue().nazwaProperty());
        druzynyPunkty.setCellValueFactory(cellData -> cellData.getValue().punktyProperty());
        druzynyBramki.setCellValueFactory(cellData -> cellData.getValue().bramkiProperty());
        druzynyIloscSpotkan.setCellValueFactory(cellData -> cellData.getValue().iloscSpotkanProperty());

        pilkarzeId              .setCellValueFactory(cellData -> cellData.getValue().idProperty());
        pilkarzeDruzynyId       .setCellValueFactory(cellData -> cellData.getValue().idDruzynyProperty());
        pilkarzeImie            .setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        pilkarzeNazwisko        .setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        pilkarzeDataUrodzenia   .setCellValueFactory(cellData -> cellData.getValue().wiekProperty());
        pilkarzePozycja         .setCellValueFactory(cellData -> cellData.getValue().pozycjaProperty());
        pilkarzeNarodowosc      .setCellValueFactory(cellData -> cellData.getValue().narodowoscProperty());

        trenerzyId              .setCellValueFactory(cellData -> cellData.getValue().idProperty());
        trenerzyDruzynyId       .setCellValueFactory(cellData -> cellData.getValue().idDruzynyProperty());
        trenerzyImie            .setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        trenerzyNazwisko        .setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        trenerzyDataUrodzenia   .setCellValueFactory(cellData -> cellData.getValue().wiekProperty());
        trenerzyNarodowosc      .setCellValueFactory(cellData -> cellData.getValue().narodowoscProperty());

        sedziowieId             .setCellValueFactory(cellData -> cellData.getValue().idProperty());
        sedziowieImie           .setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        sedziowieNazwisko       .setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());

        spotkaniaId             .setCellValueFactory(cellData -> cellData.getValue().idProperty());
        spotkaniaSedziaId           .setCellValueFactory(cellData -> cellData.getValue().idSedziProperty());
        spotkaniaDruzynaId          .setCellValueFactory(cellData -> cellData.getValue().idDruzyny1Property());
        spotkaniaMiastaId       .setCellValueFactory(cellData -> cellData.getValue().idMiastaProperty());
        spotkaniaDruzyna2Id     .setCellValueFactory(cellData -> cellData.getValue().idDruzyny2Property());
        spotkaniaBramkiD1       .setCellValueFactory(cellData -> cellData.getValue().bramkiD1Property());
        spotkaniaBramkiD2       .setCellValueFactory(cellData -> cellData.getValue().bramkiD2Property());
        spotkaniaData           .setCellValueFactory(cellData -> cellData.getValue().dataProperty());

        wynikiSpotkaniaId       .setCellValueFactory(cellData -> cellData.getValue().idSpotkaniaProperty());
        wynikiDruzynaId         .setCellValueFactory(cellData -> cellData.getValue().idDruzynyProperty());
        wynikiPilkarzId         .setCellValueFactory(cellData -> cellData.getValue().idPilkarzaProperty());
        wynikiMinuta            .setCellValueFactory(cellData -> cellData.getValue().minutaProperty());

        karySpotkaniaId         .setCellValueFactory(cellData -> cellData.getValue().idSpotkaniaProperty());
        karyDruzynaId       .setCellValueFactory(cellData -> cellData.getValue().idDruzynyProperty());
        karyPilkarzId       .setCellValueFactory(cellData -> cellData.getValue().idPilkarzaProperty());
        karyMinuta          .setCellValueFactory(cellData -> cellData.getValue().minutaProperty());
        karyKara            .setCellValueFactory(cellData -> cellData.getValue().karaProperty());
    }

    public void loadUpTheTables(Connector connector) throws SQLException {

        miasta.setItems(connector.findAllMiasta());
        druzyny.setItems(connector.findAllDruzyny());
        pilkarze.setItems(connector.findAllPilkarze());
        trenerzy.setItems(connector.findAllTrenerzy());
        sedziowie.setItems(connector.findAllSedziowie());
        spotkania.setItems(connector.findAllSpotkania());
        wyniki.setItems(connector.findAllWyniki());
        kary.setItems(connector.findAllKary());
        this.connector = connector;
    }


    public void refresh() throws SQLException {

        miasta.setItems(connector.findAllMiasta());
        druzyny.setItems(connector.findAllDruzyny());
        pilkarze.setItems(connector.findAllPilkarze());
        trenerzy.setItems(connector.findAllTrenerzy());
        sedziowie.setItems(connector.findAllSedziowie());
        spotkania.setItems(connector.findAllSpotkania());
        wyniki.setItems(connector.findAllWyniki());
        kary.setItems(connector.findAllKary());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectTableColumns();
        setEditableCells();
    }

    private void setEditableCells() {
        miastoID.    setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        miastoNazwa. setCellFactory(TextFieldTableCell.forTableColumn());

        druzynyId.          setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        druzynyMiastaId.    setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        druzynyNazwa.          setCellFactory(TextFieldTableCell.forTableColumn());
        druzynyPunkty.       setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        druzynyBramki.      setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        druzynyIloscSpotkan.    setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        pilkarzeId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        pilkarzeDruzynyId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        pilkarzeImie.setCellFactory(TextFieldTableCell.forTableColumn());
        pilkarzeNazwisko.setCellFactory(TextFieldTableCell.forTableColumn());
        pilkarzeDataUrodzenia.setCellFactory(TextFieldTableCell.forTableColumn());
        pilkarzePozycja.setCellFactory(TextFieldTableCell.forTableColumn());
        pilkarzeNarodowosc.setCellFactory(TextFieldTableCell.forTableColumn());

        trenerzyId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        trenerzyDruzynyId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        trenerzyImie.   setCellFactory(TextFieldTableCell.forTableColumn());
        trenerzyNazwisko. setCellFactory(TextFieldTableCell.forTableColumn());
        trenerzyDataUrodzenia.setCellFactory(TextFieldTableCell.forTableColumn());
        trenerzyNarodowosc.    setCellFactory(TextFieldTableCell.forTableColumn( ));
        sedziowieId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        sedziowieImie.setCellFactory(TextFieldTableCell.forTableColumn());
        sedziowieNazwisko.   setCellFactory(TextFieldTableCell.forTableColumn());
        spotkaniaId. setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        spotkaniaSedziaId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        spotkaniaDruzynaId.    setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        spotkaniaMiastaId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        spotkaniaDruzyna2Id.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        spotkaniaBramkiD1.   setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        spotkaniaBramkiD2. setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        spotkaniaData.setCellFactory(TextFieldTableCell.forTableColumn());
        wynikiSpotkaniaId.    setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        wynikiDruzynaId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        wynikiPilkarzId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        wynikiMinuta.   setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        karySpotkaniaId. setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        karyDruzynaId       .setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        karyPilkarzId       .setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        karyMinuta          .setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        karyKara            .   setCellFactory(TextFieldTableCell.forTableColumn());

    }




    /**
     * MIASTA
     */
    public void editMiastaNazwa(CellEditEvent<Miasto, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("MIASTA","NAZWA_MIASTA","ID_MIASTA", cell.getNewValue(),id);
    }

    /**
     * Druzyny
     */

    public void editDruzynyMiastaId(CellEditEvent<Druzyna, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("DRUZYNY","ID_MIASTA","ID_DRUZYNY", cell.getNewValue().toString(),id);
    }


    public void editDruzynyNazwa(CellEditEvent<Druzyna, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("DRUZYNY","NAZWA_DRUZYNY","ID_DRUZYNY", cell.getNewValue(),id);
    }

    public void editDruzynyPunkty(CellEditEvent<Druzyna, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("DRUZYNY","PUNKTY","ID_DRUZYNY", cell.getNewValue().toString(),id);
    }

    public void editDruzynyBramki(CellEditEvent<Druzyna, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("DRUZYNY","BRAMKI","ID_DRUZYNY", cell.getNewValue().toString(),id);
    }

    public void editDruzynyIloscSpotkan(CellEditEvent<Druzyna, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("DRUZYNY","ILOSC_SPOTKAN","ID_DRUZYNY", cell.getNewValue().toString(),id);
    }

    /**
     * Pilkarze
     */

    public void editPilkarzeDruzynyId(CellEditEvent<Pilkarz, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("PILKARZE","ID_DRUZYNY","ID_PILKARZA", cell.getNewValue().toString(),id);
    }

    public void editPilkarzeImie(CellEditEvent<Pilkarz, String>  cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("PILKARZE","IMIE_PILKARZA","ID_PILKARZA", cell.getNewValue(),id);
    }

    public void editPilkarzeNazwisko(CellEditEvent<Pilkarz, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("PILKARZE","NAZWISKO_PILKARZA","ID_PILKARZA", cell.getNewValue(),id);
    }

    public void editPilkarzeDataUrodzenia(CellEditEvent<Pilkarz, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("PILKARZE","WIEK_PILKARZA","ID_PILKARZA", cell.getNewValue(),id);
    }

    public void editPilkarzePozycja(CellEditEvent<Pilkarz, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("PILKARZE","POZYCJA","ID_PILKARZA", cell.getNewValue(),id);
    }

    public void editPilkarzeNarodowosc(CellEditEvent<Pilkarz, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("PILKARZE","NARODOWOSC_PILKARZA","ID_PILKARZA", cell.getNewValue(),id);
    }


    /**
     * Trenerzy
     */


    public void editTrenerzyDruzynyId(CellEditEvent<Trener, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("TRENERZY","ID_DRUZYNY","ID_TRENERA", cell.getNewValue().toString(),id);
    }

    public void editTrenerzyImie(CellEditEvent<Trener, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("TRENERZY","IMIE_TRENERA","ID_TRENERA", cell.getNewValue(),id);
    }

    public void editTrenerzyNazwisko(CellEditEvent<Trener, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("TRENERZY","NAZWISKO_TRENERA","ID_TRENERA", cell.getNewValue(),id);
    }

    public void editTrenerzyDataUrodzenia(CellEditEvent<Trener, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("TRENERZY","WIEK_TRENERA","ID_TRENERA", cell.getNewValue(),id);
    }

    public void editTrenerzyNarodowosc(CellEditEvent<Trener, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("TRENERZY","NARODOWOSC_TRENERA","ID_TRENERA", cell.getNewValue(),id);
    }

    /**
     * Sedziowie
     */

    public void editSedziowieImie(CellEditEvent<Sedzia, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SEDZIOWIE","IMIE_SEDZI","ID_SEDZI", cell.getNewValue(),id);
    }

    public void editSedziowieNazwisko(CellEditEvent<Sedzia, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SEDZIOWIE","NAZWISKO_SEDZI","ID_SEDZI", cell.getNewValue(),id);
    }
    /**
     * Spotkania
     */

    public void editSpotkaniaSedziaId(CellEditEvent<Spotkanie, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SPOTKANIA","ID_SEDZI","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editSpotkaniaDruzynaId(CellEditEvent <Spotkanie, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SPOTKANIA","ID_DRUZYNY","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editSpotkaniaMiastaId(CellEditEvent <Spotkanie, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SPOTKANIA","ID_MIASTA","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editSpotkaniaDruzyna2Id(CellEditEvent  <Spotkanie, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SPOTKANIA","DRU_ID_DRUZYNY","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editSpotkaniaBramkiD1(CellEditEvent  <Spotkanie, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SPOTKANIA","BRAMKI_D1","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editSpotkaniaBramkiD2(CellEditEvent <Spotkanie, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SPOTKANIA","BRAMKI_D2","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editSpotkaniaData(CellEditEvent  <Spotkanie, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("SPOTKANIA","DATA_SPOTKANIA","ID_SPOTKANIA", cell.getNewValue(),id);
    }


    /**
     * Wyniki
     */

    public void editWynikiSpotkaniaId(CellEditEvent <Wynik, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("WYNIK","ID_SPOTKANIA","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editWynikiDruzynaId(CellEditEvent <Wynik, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("WYNIK","ID_DRUZYNY","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editWynikiPilkarzId(CellEditEvent <Wynik, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("WYNIK","ID_PILKARZA","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editWynikiMinuta(CellEditEvent <Wynik, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("WYNIK","MINUTA_WYNIKU","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    /**
     * Kary
     */
    public void editKarySpotkaniaId(CellEditEvent <Kara, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("KARY","ID_SPOTKANIA","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }


    public void editKaryDruzynaId(CellEditEvent <Kara, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("KARY","ID_DRUZYNY","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }


    public void editKaryPilkarzId(CellEditEvent<Kara, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("KARY","ID_PILKARZA","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editKaryMinuta(CellEditEvent <Kara, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("KARY","MINUTA_KARY","ID_SPOTKANIA", cell.getNewValue().toString(),id);
    }

    public void editKaryKara(CellEditEvent <Kara, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getIdSpotkania();
        connector.updateCell("KARY","KARA","ID_SPOTKANIA", cell.getNewValue(),id);
    }



    /**
     *
     *
     * Deleting
     *
     *
     */



    public void modifyKary(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Kara kara =  kary.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("KARY","ID_SPOTKANIA",  kara.getIdSpotkania());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNowaKara();
            refresh();
        }
    }

    public void modifyWyniki(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Wynik wynik =  wyniki.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("WYNIK","ID_SPOTKANIA",  wynik.getIdSpotkania());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNowyWynik();
            refresh();
        }
    }

    public void modifySpotkania(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Spotkanie spotkanie =  spotkania.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("SPOTKANIA","ID_SPOTKANIA",  spotkanie.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNoweSpotkanie();
            refresh();
        }
    }

    public void modifySedziowie(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Sedzia sedzia =  sedziowie.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("SEDZIOWIE","ID_SEDZI",  sedzia.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNowySedzia();
            refresh();
        }
    }

    public void modifyTrenerzy(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Trener trener =  trenerzy.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("TRENERZY","ID_TRENERA",  trener.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNowyTrener();
            refresh();
        }
    }

    public void modifyPilkarze(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Pilkarz pilkarz =  pilkarze.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("PILKARZE","ID_PILKARZA",  pilkarz.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNowyPilkarz();
            refresh();
        }
    }

    public void modifyDruzyny(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Druzyna druzyna =  druzyny.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("DRUZYNY","ID_DRUZYNY",  druzyna.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNowaDruzyna();
            refresh();
        }
    }

    public void modifyMiasta(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Miasto miasto =  miasta.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("MIASTA","ID_MIASTA",  miasto.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNoweMiasto();
            refresh();
        }
    }
}

