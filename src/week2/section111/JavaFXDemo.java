/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week2.section111;

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
        Button button = new Button("Press Me");
        Button button2 = new Button("No, Press Me");
        TextField textField = new TextField();

//        FlowPane pane = new FlowPane();
//        StackPane pane = new StackPane();
        HBox pane2 = new HBox();
        HBox pane3 = new HBox();
        VBox pane = new VBox();
        pane.setSpacing(5);
        pane.setAlignment(Pos.TOP_CENTER);
        pane2.setAlignment(Pos.CENTER);
        pane3.setAlignment(Pos.CENTER_RIGHT);
        pane3.setSpacing(10);
        pane2.getChildren().add(textField);
        pane3.getChildren().add(button);
        pane3.getChildren().add(button2);
        pane.getChildren().addAll(pane2, pane3);
        Scene scene = new Scene(pane, 500, 300);

        stage.setScene(scene);
        stage.show();
    }
}
