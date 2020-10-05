package dneves;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game {
    Player player;

    public Game (Player player) {
        this.player = player;
    }
    public void saveGame(){
        String data;
        String name;
        Gson g = new Gson();
        data = g.toJson(this);
        name = "myGame.txt";

        try (PrintWriter out = new PrintWriter(name)) {
            out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Game loadGame(String fileName){

        String data = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Gson g = new Gson();
        Game newGame = g.fromJson(data,Game.class);

        return newGame;
    }

    @Override
    public String toString () {
        return "Game{" +
                "player=" + player +
                '}';
    }
}
