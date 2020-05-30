package lesson4.calculator;

import javafx.application.Application;
import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader ll = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Калькулятор");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400, 520));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
