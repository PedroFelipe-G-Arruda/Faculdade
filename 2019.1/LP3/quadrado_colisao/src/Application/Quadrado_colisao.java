/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author pedro
 */
public class Quadrado_colisao extends Application {
    

 final Rectangle rect1 = new Rectangle (0, 0, 40, 40);
 final Rectangle rect2 = new Rectangle (100, 100, 40, 40);

 FadeTransition ft;

 @Override
 public void start(Stage stage) throws Exception {
        stage.setTitle("Controlling an object movement by the keyboard");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 375);

  scene.setOnKeyPressed(evt -> {
   scene_onKeyPressed(evt);
  });

  ft = new FadeTransition(Duration.millis(2000), rect2);
  ft.setFromValue(1.0);
     ft.setToValue(0);
     ft.setCycleCount(1);

        root.getChildren().add(rect1);
        root.getChildren().add(rect2);

        stage.setScene(scene);
        stage.show();

 }

        private void scene_onKeyPressed(KeyEvent evt) {
  if (evt.getCode() == KeyCode.RIGHT) rect1.setTranslateX(rect1.getTranslateX()+5);
  if (evt.getCode() == KeyCode.LEFT)  rect1.setTranslateX(rect1.getTranslateX()-5);
  if (evt.getCode() == KeyCode.UP)    rect1.setTranslateY(rect1.getTranslateY()-5);
  if (evt.getCode() == KeyCode.DOWN)  rect1.setTranslateY(rect1.getTranslateY()+5);

  if (rect1.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
      rect2.setFill(Color.RED);
      rect2.setTranslateZ(-1);
      ft.play();
  }
 }

 public static void main(String[] args) {
            Application.launch(args);
        }

}