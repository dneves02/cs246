package dneves;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Player {
    String name;
    int health;
    int mana;
    int gold;
    Map<String, Integer> equipment;

    @Override
    public String toString () {
        String s = "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", mana=" + mana +
                ", gold=" + gold +
                ", equipment= ";
        Iterator<Map.Entry<String,Integer>> it = equipment.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String,Integer> e = it.next();
            s = s.concat(e.getKey() + ": " + e.getValue() + "\n");
        }

        return s;
    }

    public Player (String name, int health, int mana, int gold) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
        this.equipment = new HashMap<>();
    }

    public void addEquipment(String e, Integer cost){
        equipment.put(e, cost);
    }
}
