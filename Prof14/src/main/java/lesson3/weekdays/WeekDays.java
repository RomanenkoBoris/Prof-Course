package lesson3.weekdays;

import java.util.Arrays;

public enum  WeekDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,

    FRIDAY,
    SATURDAY,
    SUNDAY;

    public boolean isWeekDay() {

        return ordinal() < 5;
    }

    public static void main(String[] args) {
        System.out.println(MONDAY);
        System.out.println(SUNDAY.ordinal());
        System.out.println(Arrays.toString(WeekDays.values()));

        WeekDays f = WeekDays.FRIDAY;
        WeekDays w = WeekDays.valueOf("WEDNESDAY");
        // WeekDays noSuchDay = WeekDays.valueOf("NOSUCHDAY");

        System.out.println(f.isWeekDay());
        System.out.println(SUNDAY.isWeekDay());
        System.out.println(WeekDays.values()[2]);

    }
}
