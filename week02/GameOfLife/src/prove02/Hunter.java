package prove02;

import java.awt.*;
import java.util.Random;

public class Hunter extends Creature implements Movable, Aggressor, Aware, Spawner {

    Random _rand = new Random();
    private Boolean _canSpawn;
    private Direction direction;

    public Hunter() {
        _health = 10;
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
        // Hunters only eat animals. Giving them 10 damage
        // and increase our health by one.
        if (target instanceof Animal) {
            target.takeDamage(5);
            _health++;
            _canSpawn = true;
            spawnNewCreature();
        } else if (target instanceof Zombie){
            target.takeDamage(10);
            _health--;
            _canSpawn = false;
        } else if (target instanceof Wolf){
            target.takeDamage(1);
            _health++;
            _canSpawn = false;
        }

    }



    public Shape getShape() {
        return Shape.Circle;
    }

    public Color getColor() {
        return new Color(255, 255, 0);
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

    public Hunter spawnNewCreature() {
        if (_canSpawn) {
            _canSpawn = false;
            Hunter baby = new Hunter();
            baby.setLocation(new Point(_location.x-1, _location.y-1));

            return baby;
        }
        return null;
    }
}
