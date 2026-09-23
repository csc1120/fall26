package differentStages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        final int width = 300;
        final int height = 275;
        final int startingX = 25;
        final int startingY = 25;

        // configure first stage
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Controller.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Different Stages");
        primaryStage.setX(startingX);
        primaryStage.setY(startingY);
        primaryStage.setScene(new Scene(root, width, height));

        // add new Stage
        Stage stage2 = new Stage();
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("SecondWindow.fxml"));
        Parent root2 = loader2.load();
        stage2.setTitle("Second Window");
        stage2.setX(startingX);
        stage2.setY(startingY + height);

        // Get the controller and make 'em talk
        Controller controller = loader.getController();
        controller.setStage(stage2);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
