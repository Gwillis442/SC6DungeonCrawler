import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class appDungGame extends Application {
    /*This is the actual app that is launched in Main.java.*/


private Stage window;

/*sceneArray[] will hold the two scenes that will be frequently reused(The game screen and the inventory screen).*/
private Scene[] sceneArray = new Scene[3];


public void setScreen(Scene s){
    /*Sets the current scene that is being displayed in the game window.*/
    this.window.setScene(s);
}
public Scene getScene(int n){
    /*Simple "getter" method to retrieve the game or inventory scenes from sceneArray[]*/
    return sceneArray[n];
}

    @Override
    public void start(Stage window) throws Exception {
        Main.character.equipWeapon(dungeon.lvl0W);
        Main.character.equipArmor(dungeon.lvl0A);
        this.window = window;
        FXMLLoader startLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("startScreen.fxml")));
        FXMLLoader gameLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("dungeonGame.fxml")));
        FXMLLoader invLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("inventoryScreen.fxml")));
        FXMLLoader battleLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("battleScreen.fxml")));

        sceneArray[0] =  new Scene(gameLoader.load());
        sceneArray[1] =  new Scene(invLoader.load());
        sceneArray[2] = new Scene(battleLoader.load());

        dungeon.createEnemies();

        Parent start = startLoader.load();
        window.setTitle("Super Duper Dungeon");
        Scene startScr = new Scene(start);
        window.setScene(startScr);

        //uncomment to test battle scene
//




        controllerStart startControl = startLoader.getController();
        controllerGame gameControl = gameLoader.getController();
        controllerInventory invControl = invLoader.getController();
        controllerBattle battleControl = battleLoader.getController();
        invControl.setApp(this,gameControl);
        gameControl.setApp(this,invControl);
        startControl.setApp(this, gameControl);
        battleControl.setApp(this,gameControl);
        battle.setApp(battleControl);






        Main.character.playerInventory[1]= dungeon.lvl2A;
        Main.character.playerInventory[2]= dungeon.lvl2W;
        Main.character.playerInventory[3]= dungeon.lvl4A;


        window.show();

    }


}
