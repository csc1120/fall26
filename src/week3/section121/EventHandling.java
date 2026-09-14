/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week3.section121;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Example program showing various ways to implement EventHandlers.
 */
public class EventHandling extends Application {
    static void main() {
        launch();
    }

    @Override
    public void start(Stage stage) {
        final int dimensions = 100;
        StackPane root = new StackPane(new Button("Hello"));
        stage.setScene(new Scene(root, dimensions, dimensions));
        stage.show();
    }
}
