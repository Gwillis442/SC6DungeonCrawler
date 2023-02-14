import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DungeonCrawl extends Application {
  private static final int WIDTH = 600;
  private static final int HEIGHT = 600;
  private static final int BLOCK_SIZE = 50;
  
  private Rectangle player;
  
  public static void main(String[] args) {
    launch(args);
  }

@Override
  public void start(Stage primaryStage) throws Exception {
    Pane root = new Pane();
    player = new Rectangle(BLOCK_SIZE, BLOCK_SIZE, Color.RED);
    player.setTranslateX(WIDTH / 2 - BLOCK_SIZE / 2);
    player.setTranslateY(HEIGHT / 2 - BLOCK_SIZE / 2);
    root.getChildren().add(player);
    
    Scene scene = new Scene(root, WIDTH, HEIGHT);
    
    scene.setOnKeyPressed(this::handle);
    
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void handle(KeyEvent event) {
    int dx = 0;
    int dy = 0;

    if (event.getCode() == KeyCode.W) {
      dy = -BLOCK_SIZE;
    } else if (event.getCode() == KeyCode.S) {
      dy = BLOCK_SIZE;
    } else if (event.getCode() == KeyCode.A) {
      dx = -BLOCK_SIZE;
    } else if (event.getCode() == KeyCode.D) {
      dx = BLOCK_SIZE;
    }

    player.setTranslateX(player.getTranslateX() + dx);
    player.setTranslateY(player.getTranslateY() + dy);





  }
}
