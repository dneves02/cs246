package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aggressor, Aware {

    Random _rand;

    public Wolf() {
        _rand = new Random();
        _health = 1;
    }
    public Boolean isAlive() {
        return _health > 0;
    }


    public void attack(Creature target) {
        // Zombies only eat animals. Giving them 10 damage
        // and increase our health by one.
        if (target instanceof Animal) {
            target.takeDamage(5);
            _health++;
        }

    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(128, 128, 128);
    }

    public void move() {
        // Choose a random direction each time move() is called.
        switch(_rand.nextInt(4)) {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.y--;
                break;
            default:
                break;
        }

    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

    }
}
