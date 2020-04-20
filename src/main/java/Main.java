import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uti.StageManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/menu.fxml"));
        AnchorPane root = loader.load();
        primaryStage.setTitle("App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        StageManager.setStage(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
