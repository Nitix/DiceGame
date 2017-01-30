package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Des;
import fr.miage.moureypierson.dicegame.view.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Asus on 23/01/2017.
 */
public class GameController implements Initializable {

    private Des des;

    @FXML
    private Button boutonJouer;

    @FXML
    private Button boutonMesScores;

    @FXML
    private Button boutonLesScores;

    @FXML
    private ImageView imageDe1;

    @FXML
    private ImageView imageDe2;

    private GameView gameView = new GameView();

    public GameView getGameView() {
        return gameView;
    }

    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        des = new Des();

        boutonJouer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int value = getResult();
                animation(value);
            }
        });

        boutonLesScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadScoreScene(false);
            }
        });

        boutonMesScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadScoreScene(true);
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void animation(int value){
        int[] images = getDeImage(value);
        //this.getGameView().animation(imageDe1,images[0]);
        //this.getGameView().animation(imageDe2,images[1]);

        imageDe1.setImage(new Image("/images/"+images[0]+".png"));
        imageDe2.setImage(new Image("/images/"+images[1]+".png"));
    }

    private int[] getDeImage(int value){
        int de1 = 1;
        int de2 = 1;
        int dispo = (int) (Math.random()*3);
        switch (value){
            case 3:
                de1 = 1; de2 = 2;
                break;
            case 4:
                if(dispo == 1){ de1 = de2 = 2;}
                else{de1 = 1; de2 = 3;}
                break;
            case 5:
                if(dispo == 1){de1 = 1; de2 = 4;}
                else {de1 = 2; de2 = 3;}
                break;
            case 6:
                if(dispo == 1){de1 = 1; de2 = 5;}
                else if(dispo == 2){de1 = 2; de2 = 4;}
                else{de1 = de2 = 3;}
                break;
            case 7:
                if(dispo == 1){de1 = 1; de2 = 6;}
                else if(dispo == 2){de1 = 2; de2 = 5;}
                else {de1 = 3; de2 = 4;}
                break;
            case 8:
                if(dispo == 1){de1 = 2; de2 = 6;}
                else if(dispo == 2){de1 = 3; de2 = 5;}
                else {de1 = 4; de2 = 4;}
                break;
            case 9:
                if(dispo == 1){de1 = 3; de2 = 6;}
                else {de1 = 4; de2 = 5;}
                break;
            case 10:
                if(dispo == 1){de1 = 4; de2 = 6;}
                else {de1 = 5; de2 = 5;}
                break;
            case 11:
                de1 = 5; de2 = 6;
                break;
            case 12:
                de1 = 6; de2 = 6;
                break;
            default:
                de1 = 1; de2 = 1;
                break;
        }
        int[] des = {de1,de2};
        return des;
    }

    public int getResult(){
        this.des.roll();
        return this.des.getValue();
    }

    public void loadScoreScene(boolean isMyScore){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/scores.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Dice Game");
        stage.setScene(new Scene(root, 600, 400));
        ScoreController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setType(isMyScore);
        stage.show();
    }

}
