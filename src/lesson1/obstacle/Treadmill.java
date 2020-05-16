package lesson1.obstacle;

import lesson1.competitors.Competitor;

public class Treadmill implements Obstacle{
    private int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    @Override
    public void move(Competitor competitor) {
        competitor.run(dist);
    }

}
