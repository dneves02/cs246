package dneves;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here

       Player newPlayer = new Player("Sam", 10, 10,10);
       newPlayer.addEquipment("Ax",10);
       newPlayer.addEquipment("Hammer", 5);
       Game newGame = new Game(newPlayer);
       newGame.saveGame();

       Game myGame = Game.loadGame("myGame.txt");

       System.out.println(myGame.toString());
    }
}
