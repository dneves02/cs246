package prove02;

import java.awt.*;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {


    Random _rand;

    public Zombie() {
        _rand = new Random();
        _health = 1;
    }
    public Boolean isAlive() {
        return _health > 0;
    }


    public void attack(Creature target) {
        // Zombies only eat animals. Giving them 10 damage
        // and increase our health by one.
        if (target != null && !(target instanceof Plant)) {
            target.takeDamage(10);
        }

    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(10, 10, 225);
    }

    public void move() {
        // Move left to right in the x direction each time move() is called.
        _location.x++;

    }


}
