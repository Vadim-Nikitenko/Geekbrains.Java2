package lesson1.competitors;

public class Participant implements Competitor {
    private String name;
    private String type;

    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean onDistance;

    public Participant(String type, String name, int maxRunDistance, int maxJumpHeight) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int distance) {
        if (onDistance) {
            if (distance <= maxRunDistance) {
                System.out.println(type + " " + name + " успешно пробежал " + distance + " метров");
            } else {
                System.out.println(type + " " + name + " не смог пробежать " + distance + " метров");
                onDistance = false;
                System.out.println(type + " " + name + " выбывает из соревнований \n - - - - - - -");
            }
        }
    }

    @Override
    public void jump(int height) {
        if (onDistance) {
            if (height <= maxJumpHeight) {
                System.out.println(type + " " + name + " успешно перепрыгнул " + height + " метров");
            } else {
                System.out.println(type + " " + name + " не может перепрыгнуть " + height + " метров");
                onDistance = false;
                System.out.println(type + " " + name + " выбывает из соревнований \n - - - - - - -");
            }
        }
    }

}
