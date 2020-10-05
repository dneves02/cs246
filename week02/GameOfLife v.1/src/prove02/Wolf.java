package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aggressor, Aware, Spawner {

    Random _rand = new Random();
    private Boolean _canSpawn;
    private Direction direction;

    public Wolf() {
        _health = 1;
        _canSpawn = false;

        int preferredDirection = _rand.nextInt(4);

        switch(preferredDirection) {
            case 0:
                direction = Direction.Up;
                break;
            case 1:
                direction = Direction.Right;
                break;
            case 2:
                direction = Direction.Down;
                break;
            case 3:
                direction = Direction.Left;
                break;
            default:
                break;
        }
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
            _canSpawn = true;
            spawnNewCreature();
        }

    }



    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(128, 128, 128);
    }

    public void move () {
        // Move in the preferred direction each time move() is called.
        switch (direction) {
            case Right:
                _location.x++;
                break;
            case Left:
                _location.x--;
                break;
            case Up:
                _location.y++;
                break;
            case Down:
                _location.y--;
                break;
            default:
                break;
        }

    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        if (direction == Direction.Up) {

            if (above instanceof Animal) {
                direction = Direction.Up;
            }
            else if (right instanceof Animal) {
                direction = Direction.Right;
            }
            else if (below instanceof Animal) {
                direction = Direction.Down;
            }
            else if (left instanceof Animal) {
                direction = Direction.Left;
            }
        }

        if (direction == Direction.Right) {

            if (right instanceof Animal) {
                direction = Direction.Right;
            }
            else if (below instanceof Animal) {
                direction = Direction.Down;
            }
            else if (left instanceof Animal) {
                direction = Direction.Left;
            }
            else if (above instanceof Animal) {
                direction = Direction.Up;
            }
        }

        if (direction == Direction.Down) {

            if (below instanceof Animal) {
                direction = Direction.Down;
            }
            else if (left instanceof Animal) {
                direction = Direction.Left;
            }
            else if (above instanceof Animal) {
                direction = Direction.Up;
            }
            else if (right instanceof Animal) {
                direction = Direction.Right;
            }
        }

        if (direction == Direction.Left) {

            if (left instanceof Animal) {
                direction = Direction.Left;
            }
            else if (above instanceof Animal) {
                direction = Direction.Up;
            }
            else if (right instanceof Animal) {
                direction = Direction.Right;
            }
            else if (below instanceof Animal) {
                direction = Direction.Down;
            }
        }

    }

    public Wolf spawnNewCreature() {
        if (_canSpawn) {
            _canSpawn = false;
            Wolf babyWolf = new Wolf();
            babyWolf.setLocation(new Point(_location.x--, _location.y));

            return babyWolf;
        }
        return null;
    }
}
