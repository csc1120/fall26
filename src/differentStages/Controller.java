package differentStages;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {

    private Stage secondStage;

    public void setStage(Stage sc) {
        this.secondStage = sc;
    }

    @FXML
    private void open() {
        secondStage.show();
    }

    @FXML
    private void close() {
        secondStage.close();
    }
}
