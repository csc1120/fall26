/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week3.section111;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXControls extends Application {
    private TextField usernameField;
    private PasswordField passwordField;
    private Label report;

    static void main() {
        launch();
    }

    @Override
    public void start(Stage stage) {
        HBox top = new HBox();
        HBox middle = new HBox();
        HBox bottom = new HBox();
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");
        report = new Label("Reporting...");
        usernameField = new TextField();
        passwordField = new PasswordField();
        bottom.setAlignment(Pos.CENTER_RIGHT);
        top.setSpacing(10);
        middle.setSpacing(10);
        bottom.setSpacing(10);
        ok.setOnAction(_ -> login());
        cancel.setOnAction(_ -> cancel());
        usernameField.setOnAction(_ -> login());
        passwordField.setOnAction(_ -> login());

        top.getChildren().addAll(usernameLabel, usernameField);
        middle.getChildren().addAll(passwordLabel, passwordField);
        bottom.getChildren().addAll(cancel, ok);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(top, middle, bottom, report);
        vBox.setSpacing(10);
        Scene scene = new Scene(vBox);
        scene.addEventHandler(
                MouseEvent.MOUSE_CLICKED, this::location);
        stage.setScene(scene);
        stage.show();
    }

    private void login() {
        if(!usernameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            report.setText("Logged in!");
        } else {
            report.setText("");
        }
    }

    private void cancel() {
        usernameField.setText("");
        passwordField.setText("");
    }

    private void location(MouseEvent e) {
        report.setText(e.getSceneX() + " " + e.getSceneY());
    }
}
