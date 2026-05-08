package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Formulario Telefono");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label telefonoLabel = new Label("Telefono");
        TextField telefonoTextField = new TextField();
        Button botonAceptar = new Button("Aceptar");
        botonAceptar.setOnAction(e -> {
            String telefono = telefonoTextField.getText();
            if(telefono.matches("\\d{9}")){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Informacion");
                alerta.setHeaderText("Telefono ingresado: " + telefono);
                alerta.showAndWait();
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Error");
                alerta.setHeaderText("Error de telefono");
                alerta.showAndWait();
            }
        });
        gridPane.add(telefonoLabel, 0, 0);
        gridPane.add(telefonoTextField, 1, 0);
        gridPane.add(botonAceptar, 1, 1);

        Scene scene = new Scene(gridPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
