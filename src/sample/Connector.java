package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.pool.OracleDataSource;
import sample.tables.*;

import java.sql.*;


public class Connector {

    private String username = "";
    private String password = "";
    private Connection connection;

    Connector(String username, String password) {
        this.username = username;
        this.password = password;
    }


    private void getDBConnection()  throws SQLException{
        OracleDataSource dataSource;
        dataSource = new OracleDataSource();
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        dataSource.setURL(jdbcUrl);
        connection = dataSource.getConnection(username,password);
    }


    /**
     *
     *
     * Finders
     *
     */

    public ObservableList<Miasto> findAllMiasta() throws SQLException {
        getDBConnection();

        ObservableList<Miasto> miasto = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Miasta ORDER BY ID_MIASTA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            miasto.add(createMiasto(resultSet));
        }
        return miasto;
    }

    public ObservableList<Druzyna> findAllDruzyny() throws SQLException {
        getDBConnection();

        ObservableList<Druzyna> druzyna = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Druzyny ORDER BY ID_DRUZYNY";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            druzyna.add(createDruzyna(resultSet));
        }
        return druzyna;
    }

    public ObservableList<Pilkarz> findAllPilkarze() throws SQLException {
        getDBConnection();

        ObservableList<Pilkarz> druzyna = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Pilkarze ORDER BY ID_PILKARZA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            druzyna.add(createPilkarz(resultSet));
        }
        return druzyna;
    }

    public ObservableList<Trener> findAllTrenerzy() throws SQLException {
        getDBConnection();

        ObservableList<Trener> trener = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Trenerzy ORDER BY ID_TRENERA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            trener.add(createTrener(resultSet));
        }
        return trener;
    }


    public ObservableList<Sedzia> findAllSedziowie() throws SQLException {
        getDBConnection();

        ObservableList<Sedzia> sedzia = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Sedziowie ORDER BY ID_SEDZI";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            sedzia.add(createSedzia(resultSet));
        }
        return sedzia;
    }

    public ObservableList<Spotkanie> findAllSpotkania()  throws SQLException {
        getDBConnection();

        ObservableList<Spotkanie> spotkanie = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Spotkania ORDER BY ID_SPOTKANIA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            spotkanie.add(createSpotkanie(resultSet));
        }
        return spotkanie;
    }


    public ObservableList<Wynik> findAllWyniki()throws SQLException {
        getDBConnection();

        ObservableList<Wynik> wynik = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Wynik ORDER BY ID_SPOTKANIA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            wynik.add(createWynik(resultSet));
        }
        return wynik;
    }

    public ObservableList<Kara> findAllKary()throws SQLException {
        getDBConnection();

        ObservableList<Kara> kara = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Kary ORDER BY ID_SPOTKANIA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            kara.add(createKara(resultSet));
        }
        return kara;
    }


    /**
     *
     *  Creators
     *
     */



    private Miasto createMiasto(ResultSet resultSet) throws SQLException {
        Miasto miasto = new Miasto();
        miasto.setId(resultSet.getInt("ID_MIASTA"));
        miasto.setNazwa(resultSet.getString("NAZWA_MIASTA"));
        System.out.println(miasto.toString());
        return miasto;
    }

    private Druzyna createDruzyna(ResultSet resultSet)throws SQLException {
        Druzyna druzyna = new Druzyna();
        druzyna.setId(resultSet.getInt("ID_DRUZYNY"));
        druzyna.setIdMiasta(resultSet.getInt("ID_MIASTA"));
        druzyna.setNazwa(resultSet.getString("NAZWA_DRUZYNY"));
        druzyna.setPunkty(resultSet.getInt("PUNKTY"));
        druzyna.setBramki(resultSet.getInt("BRAMKI"));
        druzyna.setIloscSpotkan(resultSet.getInt("ILOSC_SPOTKAN"));
        System.out.println(druzyna.toString());
        return druzyna;
    }

    private Pilkarz createPilkarz(ResultSet resultSet) throws SQLException {
        Pilkarz pilkarz = new Pilkarz();
        pilkarz.setId(resultSet.getInt("ID_PILKARZA"));
        pilkarz.setIdDruzyny(resultSet.getInt("ID_DRUZYNY"));
        pilkarz.setImie(resultSet.getString("IMIE_PILKARZA"));
        pilkarz.setNazwisko(resultSet.getString("NAZWISKO_PILKARZA"));
        pilkarz.setWiek(resultSet.getString("WIEK_PILKARZA"));
        pilkarz.setPozycja(resultSet.getString("POZYCJA"));
        pilkarz.setNarodowosc(resultSet.getString("NARODOWOSC_PILKARZA"));
        System.out.println(pilkarz.toString());
        return pilkarz;

    }

    private Trener createTrener(ResultSet resultSet)throws SQLException {
        Trener trener = new Trener();
        trener.setId(resultSet.getInt("ID_TRENERA"));
        trener.setIdDruzyny(resultSet.getInt("ID_DRUZYNY"));
        trener.setImie(resultSet.getString("IMIE_TRENERA"));
        trener.setNazwisko(resultSet.getString("NAZWISKO_TRENERA"));
        trener.setWiek(resultSet.getString("WIEK_TRENERA"));
        trener.setNarodowosc(resultSet.getString("NARODOWOSC_TRENERA"));
        System.out.println(trener.toString());
        return trener;
    }

    private Sedzia createSedzia(ResultSet resultSet) throws SQLException {
        Sedzia sedzia = new Sedzia();
        sedzia.setId(resultSet.getInt("ID_SEDZI"));
        sedzia.setImie(resultSet.getString("IMIE_SEDZI"));
        sedzia.setNazwisko(resultSet.getString("NAZWISKO_SEDZI"));
        System.out.println(sedzia.toString());
        return sedzia;
    }

    private Spotkanie createSpotkanie(ResultSet resultSet) throws SQLException {
        Spotkanie spotkanie = new Spotkanie();
        spotkanie.setId(resultSet.getInt("ID_SPOTKANIA"));
        spotkanie.setIdSedzi(resultSet.getInt("ID_SEDZI"));
        spotkanie.setIdDruzyny1(resultSet.getInt("ID_DRUZYNY"));
        spotkanie.setIdMiasta(resultSet.getInt("ID_MIASTA"));
        spotkanie.setIdDruzyny2(resultSet.getInt("DRU_ID_DRUZYNY"));
        spotkanie.setBramkiD1(resultSet.getInt("BRAMKI_D1"));
        spotkanie.setBramkiD2(resultSet.getInt("BRAMKI_D2"));
        spotkanie.setData(resultSet.getString("DATA_SPOTKANIA"));

        System.out.println(spotkanie.toString());
        return spotkanie;
    }

    private Wynik createWynik(ResultSet resultSet) throws SQLException {
        Wynik wynik = new Wynik();
        wynik.setIdSpotkania(resultSet.getInt("ID_SPOTKANIA"));
        wynik.setIdDruzyny(resultSet.getInt("ID_DRUZYNY"));
        wynik.setIdPilkarza(resultSet.getInt("ID_PILKARZA"));
        wynik.setMinuta(resultSet.getInt("MINUTA_WYNIKU"));

        System.out.println(wynik.toString());
        return wynik;
    }


    private Kara createKara(ResultSet resultSet)throws SQLException {
        Kara kara = new Kara();
        kara.setIdSpotkania(resultSet.getInt("ID_SPOTKANIA"));
        kara.setIdDruzyny(resultSet.getInt("ID_DRUZYNY"));
        kara.setIdPilkarza(resultSet.getInt("ID_PILKARZA"));
        kara.setMinuta(resultSet.getInt("MINUTA_KARY"));
        kara.setKara(resultSet.getString("KARA"));
        System.out.println(kara.toString());
        return kara;
    }




    /**
     *
     *
     * INSERT NEW VALUES
     *
     */

    public void insertNoweMiasto() throws SQLException {
        int id = getMaxId("MIASTA","ID_MIASTA");
        String unknown = "'unknown'";
        getDBConnection();
        String selectQuery = "INSERT INTO Miasta VALUES("+id+", "+unknown+")";
        prepareStatement(selectQuery);
    }

    public void insertNowaDruzyna() throws SQLException {
        int value = 1;
        int id = getMaxId("DRUZYNY","ID_DRUZYNY");
        String unknown = "'unknown'";
        getDBConnection();
        String selectQuery = "INSERT INTO Druzyny VALUES("+id+", "+value+", "+unknown+", "+ value+", "+ value+", "+ value+")";
        prepareStatement(selectQuery);
    }

    public void insertNowyPilkarz() throws SQLException {
        int value = 1;
        int id = getMaxId("PILKARZE","ID_PILKARZA");
        String unknown = "'unknown'";
        getDBConnection();
        String selectQuery = "INSERT INTO Pilkarze VALUES("+id+", "+value+", "+unknown+", "+ unknown+", TO_DATE('90/06/12', 'RR/MM/DD'), "+ unknown+", "+ unknown+")";
        prepareStatement(selectQuery);
    }

    public void insertNowyTrener() throws SQLException {
        int value = 1;
        int id = getMaxId("TRENERZY","ID_TRENERA");
        String unknown = "'unknown'";
        getDBConnection();
        String selectQuery = "INSERT INTO Trenerzy VALUES("+id+", "+value+", "+unknown+", "+ unknown+", TO_DATE('90/06/12', 'RR/MM/DD'), "+ unknown+")";
        prepareStatement(selectQuery);
    }

    public void insertNowySedzia() throws SQLException {
        int id = getMaxId("SEDZIOWIE","ID_SEDZI");
        String unknown = "'unknown'";
        getDBConnection();
        String selectQuery = "INSERT INTO Sedziowie VALUES("+id+", "+unknown+", "+ unknown+")";
        prepareStatement(selectQuery);
    }


    public void insertNoweSpotkanie() throws SQLException {
        int value = 1;
        int id = getMaxId("SPOTKANIA","ID_SPOTKANIA");
        getDBConnection();
        String selectQuery = "INSERT INTO Spotkania VALUES("+id+", "+value+", "+value+", "+ value+", "+ value+", "+ value+", "+ value+", TO_DATE('17/01/01', 'RR/MM/DD'))";
        prepareStatement(selectQuery);
    }

    public void insertNowyWynik() throws SQLException {
        int value = 1;
        getDBConnection();
        String selectQuery = "INSERT INTO Wynik VALUES("+value+", "+value+", "+value+", "+ value+")";
        prepareStatement(selectQuery);
    }

    public void insertNowaKara() throws SQLException {
        int value = 1;
        String unknown = "'unknown'";
        getDBConnection();
        String selectQuery = "INSERT INTO Kary VALUES("+value+", "+value+", "+value+", "+ value+", "+ unknown+")";
        prepareStatement(selectQuery);
    }

    /**
     *
     *
     * UPDATE AND DELETE ROWS
     *
     */

    public void updateCell(String nameOfTable, String nameOfColumn, String nameOfIDColumn, String newValue, int id) throws SQLException {
        getDBConnection();

        String selectQuery = "UPDATE "+nameOfTable+" SET "+nameOfColumn+" = '"+ newValue +"' WHERE "+nameOfIDColumn+" = "+id+"";

        prepareStatement(selectQuery);
    }

    public void deleteRow(String nameOfTable,  String nameOfIDColumn,  int id) throws SQLException {
        getDBConnection();
        String selectQuery = "DELETE FROM "+nameOfTable+" WHERE "+nameOfIDColumn+" = "+id;
        prepareStatement(selectQuery);
    }


    /**
     *
     *
     * SETMAXID AND PREPRARESTATEMENT
     *
     *
     */


    private int getMaxId(String nameOfTable, String nameOfIdColumn) throws SQLException {
        getDBConnection();

        String selectQuery = "Select max("+nameOfIdColumn+") From "+nameOfTable;
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int max = resultSet.getInt(1);
        return max+1;
    }

    private void prepareStatement(String selectQuery) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.executeUpdate();
    }



}
