package lesson1.enums;

public enum DaysOfWeek {
    MONDAY(8,1),
    TUESDAY(8,2),
    WEDNESDAY(8,3),
    THURSDAY(8,4),
    FRIDAY(7,5),
    SATURDAY(0,6),
    SUNDAY(0,7);

    int workHours;
    int dayOfWeek;

    DaysOfWeek(int workHours, int dayOfWeek) {
        this.workHours = workHours;
        this.dayOfWeek = dayOfWeek;
    }

    public static String getRemainsWorkHours(DaysOfWeek day) {
        if (day.workHours == 0) {
            return "Сегодня выходной";
        }
        int remainsWorkHours = (SATURDAY.dayOfWeek - day.dayOfWeek) * day.workHours;
        return "До конца рабочей недели осталось " + remainsWorkHours + " часов";
    }
}
