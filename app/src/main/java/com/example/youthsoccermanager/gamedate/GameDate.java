package com.example.youthsoccermanager.gamedate;

public class GameDate {
    private int day;
    private EMonth month;

    public GameDate(int day, EMonth month) {
        this.day = day;
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public EMonth getMonth() {
        return month;
    }

    public int daysInMonth() {
        final int DAYS_SHORT_MONTH = 30;
        final int DAYS_LONG_MONTH = 31;
        final int DAYS_FEBRUARY = 28; // disregard additional day every four years (in reality)
        if(month.equals(EMonth.APR) || month.equals(EMonth.JUN) || month.equals(EMonth.SEP) || month.equals(EMonth.NOV)) {
            return DAYS_SHORT_MONTH;
        }
        else if(month.equals(EMonth.FEB)) {
            return DAYS_FEBRUARY;
        }
        else {
            return DAYS_LONG_MONTH;
        }
    }

    public String getDateAsString() {
        return String.valueOf(day) + " " + month.toString();
    }

    public String getCurrentMonthAsString() {
        return this.month.toString();
    }

    public int getCurrentMonthAsInt() {
        return this.month.monthValue;
    }


}
