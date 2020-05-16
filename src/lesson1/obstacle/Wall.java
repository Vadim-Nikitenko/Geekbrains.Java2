package lesson1.obstacle;

import lesson1.competitors.Competitor;

public class Wall implements Obstacle{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void move(Competitor competitor) {
        competitor.jump(height);
    }
}
