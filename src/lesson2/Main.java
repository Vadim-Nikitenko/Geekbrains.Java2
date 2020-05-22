package lesson2;

public class Main {
    public static String[][] strArr = new String[][]{
            new String[]{"1", "2", "3", "4"},
            new String[]{"1", "2", "3", "4"},
            new String[]{"1", "2", "3", "4"},
            new String[]{"1", "2", "3", "F"}
    };

    private static final int MAX_LENGTH = 4;

    public static void main(String[] args) {
        try {
            checkArray(strArr);
        } catch (MyArrayException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Некорретное значение массива в ячейке ["
                    + e.getI() + "][" + e.getJ() + "] : " + e.getCell());
        }
    }


    static void checkArray(String[][] strArr) throws MyArrayException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length < MAX_LENGTH || strArr.length < MAX_LENGTH) {
                throw new MyArrayException("Передан невалидный массив. Метод должен получить массив [4][4]");
            }
            for (int j = 0; j < strArr[i].length; j++) {
                try {
                    sum += Integer.parseInt(strArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удалось преобразовать в Integer", strArr[i][j], i, j);
                }
            }
        }
        System.out.println(sum);
    }
}
