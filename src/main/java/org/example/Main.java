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
        // Se asigna el título de la ventana principal
        stage.setTitle("Formulario Telefono");

        // Se crea un panel de cuadrícula (GridPane) para organizar los elementos
        GridPane gridPane = new GridPane();
        // Se establece el espacio horizontal entre columnas: 10 píxeles
        gridPane.setHgap(10);
        // Se establece el espacio vertical entre filas: 10 píxeles
        gridPane.setVgap(10);

        // Se crea una etiqueta "Telefono"
        Label telefonoLabel = new Label("Telefono");
        // Se crea un campo de texto donde el usuario ingresará el número de teléfono
        TextField telefonoTextField = new TextField();
        // Se crea un botón con el texto "Aceptar"
        Button botonAceptar = new Button("Aceptar");

        // Se asigna una acción al botón cuando es presionado
        botonAceptar.setOnAction(e -> {
            // Se obtiene el texto ingresado en el campo de teléfono
            String telefono = telefonoTextField.getText();

            // Se valida que el teléfono tenga exactamente 9 dígitos usando una expresión regular
            // \\d{9} significa: 9 caracteres numéricos (dígitos del 0 al 9)
            if(telefono.matches("\\d{9}")){
                // Si el formato es correcto, se crea una alerta de tipo INFORMATION
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                // Se establece el título de la alerta
                alerta.setTitle("Informacion");
                // Se establece el encabezado mostrando el teléfono ingresado
                alerta.setHeaderText("Telefono ingresado: " + telefono);
                // Se muestra la alerta y se espera a que el usuario la cierre
                alerta.showAndWait();
            } else {
                // Si el formato es incorrecto, se crea una alerta de tipo WARNING
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                // Se establece el título de la alerta
                alerta.setTitle("Error");
                // Se establece el encabezado indicando error en el teléfono
                alerta.setHeaderText("Error de telefono");
                // Se muestra la alerta de advertencia
                alerta.showAndWait();
            }
        });

        // Se añade la etiqueta en la columna 0, fila 0
        gridPane.add(telefonoLabel, 0, 0);
        // Se añade el campo de texto en la columna 1, fila 0
        gridPane.add(telefonoTextField, 1, 0);
        // Se añade el botón en la columna 1, fila 1
        gridPane.add(botonAceptar, 1, 1);

        // Se crea la escena con el GridPane como raíz, de 300x200 píxeles
        Scene scene = new Scene(gridPane, 300, 200);
        // Se asigna la escena a la ventana
        stage.setScene(scene);
        // Se hace visible la ventana
        stage.show();
    }

    public static void main(String[] args) {
        // Lanza la aplicación JavaFX
        launch(args);
    }
}