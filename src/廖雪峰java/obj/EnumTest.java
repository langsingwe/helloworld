package com.java.obj;

/**
 * @author weilc
 * @description
 * @className EnumTest
 * @date 2020-06-04
 */
public class EnumTest {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Stay at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }
    }
}

enum Weekday {
    MON(1,"星期一"),
    TUE(2,"星期二"),
    WEB(3,"星期三"),
    THU(4,"星期四"),
    FRI(5,"星期五"),
    SAT(6,"星期六"),
    SUN(0,"星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}
