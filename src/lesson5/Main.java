package lesson5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        first();
        second();
    }

    static void first() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        calculation(arr, size);
        System.out.println("Один поток. Время: " +  (System.currentTimeMillis() - a));
    }

    static void second() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(() -> {
            calculation(a1, a1.length);
        });
        Thread t2 = new Thread(() -> {
            calculation(a2, a2.length);
        });
        t1.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Два потока. Время: " +  (System.currentTimeMillis() - a));
    }

    private static void calculation(float[] arr, int length) {
        for (int i = 0; i < length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}