/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week2.section121;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXDemo extends Application {
    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // eventually instance variables
        Button button = new Button("Press Me");
        Button button2 = new Button("No, Press Me!");
        TextField textField = new TextField();

//        FlowPane pane = new FlowPane();
//        StackPane pane = new StackPane();
//        ComboBox box = new ComboBox();
        HBox pane2 = new HBox();
        VBox pane = new VBox();
        pane2.setSpacing(10);
        pane2.setAlignment(Pos.TOP_CENTER);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
        pane2.getChildren().addAll(button2, button);
        pane.getChildren().addAll(pane2, textField);
        stage.setScene(new Scene(pane, 500, 150));
        stage.show();
    }
}
