package lesson2;

public class MyArrayDataException extends Exception{
    private String cell;
    private int i;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    private int j;

    public String getCell() {
        return cell;
    }

    public MyArrayDataException(String message, String cell, int i, int j) {
        super(message);
        this.cell = cell;
        this.i = i;
        this.j = j;
    }
}
