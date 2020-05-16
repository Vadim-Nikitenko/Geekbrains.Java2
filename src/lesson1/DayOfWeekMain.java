package lesson1;

import lesson1.enums.DaysOfWeek;

public class DayOfWeekMain {

    public static void main(String[] args) {
        System.out.println(DaysOfWeek.getRemainsWorkHours(DaysOfWeek.MONDAY));
        System.out.println(DaysOfWeek.getRemainsWorkHours(DaysOfWeek.TUESDAY));
        System.out.println(DaysOfWeek.getRemainsWorkHours(DaysOfWeek.WEDNESDAY));
        System.out.println(DaysOfWeek.getRemainsWorkHours(DaysOfWeek.THURSDAY));
        System.out.println(DaysOfWeek.getRemainsWorkHours(DaysOfWeek.FRIDAY));
        System.out.println(DaysOfWeek.getRemainsWorkHours(DaysOfWeek.SATURDAY));
        System.out.println(DaysOfWeek.getRemainsWorkHours(DaysOfWeek.SUNDAY));
    }
}