package fr.miage.moureypierson.dicegame.view;


import fr.miage.moureypierson.dicegame.controller.GameController;
import fr.miage.moureypierson.dicegame.controller.LoginController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by Asus on 08/01/2017.
 */
public class GameView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/jeu.fxml"));
        Parent root = fxmlLoader.load();

        stage.setTitle("Dice Game");
        stage.setScene(new Scene(root, 600, 400));
        GameController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }

    public void animation(ImageView imageView, int endValue){

        ArrayList<Image> listeImages = new ArrayList<>();
        listeImages.add(new Image("/images/1.png"));
        listeImages.add(new Image("/images/2.png"));
        listeImages.add(new Image("/images/3.png"));
        listeImages.add(new Image("/images/4.png"));
        listeImages.add(new Image("/images/5.png"));
        listeImages.add(new Image("/images/6.png"));

        int index = (int)(Math.random() * 6);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), imageView.getImage())),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(imageView.imageProperty(), listeImages.get(index)))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        imageView.setImage(new Image("/images/"+endValue+".png"));

    }

}
