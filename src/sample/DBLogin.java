package sample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import sample.controllers.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class DBLogin extends Application  {

    private Dialog <Pair<String,String>> dialog;
    private ButtonType loginButtonType;
    private GridPane gridPane;
    private TextField usernameTF;
    private PasswordField passwordField;
    private Node loginButton;

    private String username;
    private String password;

    @Override
    public void start(Stage primaryStage) throws Exception {
        initComponents();
        setButtonsType();
        setLoginGridPane();
        setPromptTextOnFields();
        setLabelsOnGridPane();
        setFieldsOnGridPane();
        setOptionsOnLoginButton();
        addGridPaneToDialog();
        onDialogStartSettings();
        showThisDialog();
        startThatProgram(primaryStage);

    }

    private void startThatProgram(Stage primaryStage) throws IOException, SQLException {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("ORACLE DATABASE");
        primaryStage.setScene(new Scene(root, 800, 600));
        Connector connector = new Connector(getUsername(),getPassword());
        Controller controller = loader.getController();
        if (controller == null) {
            System.out.println("null");
        } else {
            controller.loadUpTheTables(connector);
        }
        primaryStage.show();

    }

    private void initComponents() {
        dialog = new Dialog<>();
        gridPane = new GridPane();
        usernameTF = new TextField();
        passwordField = new PasswordField();
        loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);

    }

    private void setButtonsType() {
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    }

    private void setLoginGridPane() {
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20,150,10,10));


    }

    private void setPromptTextOnFields() {
        usernameTF.setPromptText("username");
        passwordField.setPromptText("password");

    }

    private void setLabelsOnGridPane() {
        gridPane.add(new Label("Username: "),0,0);
        gridPane.add(new Label("Password: "),0,1);

    }

    private void setFieldsOnGridPane() {
        gridPane.add(usernameTF,1,0);
        gridPane.add(passwordField,1,1);

    }

    private void setOptionsOnLoginButton() {

        loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        passwordField.textProperty().addListener((observable, oldValue, newValue)
                -> loginButton.setDisable(newValue.trim().isEmpty()));

    }

    private void addGridPaneToDialog() {
        dialog.getDialogPane().setContent(gridPane);
    }

    private void onDialogStartSettings() {
        Platform.runLater(usernameTF::requestFocus);

        //Pobiera dane wpisane przez użytkownika
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType)
                return  new Pair<>(usernameTF.getText(),passwordField.getText());
            return null;
        });
    }

    private void showThisDialog() {
        dialog.setTitle("Login to Oracle SQL Database");
        //Wyświetlenie okienka i przydzielenie wartości wprowadzonych przez użytkownika
        Optional<Pair<String, String>> result = dialog.showAndWait();

        //Pobranie wartości
        result.ifPresent(usernamePassword -> setData(usernamePassword.getKey(),usernamePassword.getValue()));

    }

    private void setData(String username, String password) {
        this.username = username;
        this.password = password;
    }


    private String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

}
