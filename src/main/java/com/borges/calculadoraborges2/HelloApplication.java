package com.borges.calculadoraborges2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Somar.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Calculadora 1.0");
        stage.setScene(scene);
        stage.show();

        HelloController helloController = fxmlLoader.getController();

        stage.setOnCloseRequest(e -> {
            if (helloController.onCloseQuery()) {
                System.exit(0);
            } else {
                e.consume();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}