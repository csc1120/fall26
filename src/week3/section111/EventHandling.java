/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week3.section111;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Example program showing various ways to implement EventHandlers.
 */
public class EventHandling extends Application {
    private Button button;
    static void main() {
        launch();
    }

    @Override
    public void start(Stage stage) {
        final int dimensions = 200;
        final int width = 70;
        final int height = 60;
        final int fontSize = 30;

        button = new Button("Hello");
        button.setMinWidth(width);
        button.setMinHeight(height);
        button.setFont(new Font(fontSize));
        // anonymous inner class
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////            Button b = (Button) actionEvent.getSource();
//                if(button.getEffect() == null) {
//                    button.setEffect(new BoxBlur());
//                } else {
//                    button.setEffect(null);
//                }
//            }
//        })
//        lamba expression
        button.setOnAction(_ -> buttonHandle());
//        button.setOnAction(this::buttonHandle); // method reference

        StackPane root = new StackPane(button);
        stage.setScene(new Scene(root, dimensions, dimensions));
        stage.show();
    }

    private void buttonHandle() {
        if(button.getEffect() == null) {
            button.setEffect(new BoxBlur());
        } else {
            button.setEffect(null);
        }
    }

    // inner class
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
//            Button b = (Button) actionEvent.getSource();
            if(button.getEffect() == null) {
                button.setEffect(new BoxBlur());
            } else {
                button.setEffect(null);
            }
        }
    }
}
