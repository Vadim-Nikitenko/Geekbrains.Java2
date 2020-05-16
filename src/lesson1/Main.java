package lesson1;

import lesson1.competitors.Cat;
import lesson1.competitors.Competitor;
import lesson1.competitors.Human;
import lesson1.competitors.Robot;
import lesson1.obstacle.Obstacle;
import lesson1.obstacle.Treadmill;
import lesson1.obstacle.Wall;

public class Main {

    public static void main(String[] args) {
        Competitor[] competitor = {
                new Human(),
                new Robot(),
                new Cat()
        };

        Obstacle[] obstacles = {
                new Wall(2),
                new Treadmill(1500)
        };

        for (Competitor c:competitor) {
            for (Obstacle o:obstacles) {
                o.move(c);
            }
        }
    }
}
