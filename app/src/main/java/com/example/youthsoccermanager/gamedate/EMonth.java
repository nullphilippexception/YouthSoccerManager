package com.example.youthsoccermanager.gamedate;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;

public enum EMonth {
    JAN (1),
    FEB (2),
    MAR (3),
    APR (4),
    MAY (5),
    JUN (6),
    JUL (7),
    AUG (8),
    SEP (9),
    OCT (10),
    NOV (11),
    DEC (12);

    int monthValue;
    private EMonth(int monthValue) {
        this.monthValue = monthValue;
    }

    public int getMonthValue() {
        return this.monthValue;
    }

    // ADJUST NULL SAFETY? OPTIONAL<>?
    @RequiresApi(api = Build.VERSION_CODES.N)
    public EMonth getNextMonth() {
        if(monthValue == 12) { // adjust if current month is actually DEC
            monthValue = 0;
        }
        final int nextMonth = monthValue + 1;
        return Arrays.stream(values())
                .filter(EMonth -> EMonth.monthValue == nextMonth)
                .findFirst().get();
    }

    // ADJUST NULL SAFETY? OPTIONAL<>?
    @RequiresApi(api = Build.VERSION_CODES.N)
    public EMonth getPreviousMonth() {
        if(monthValue == 1) { // adjust if current month is actually JAN
            monthValue = 13;
        }
        final int nextMonth = monthValue - 1;
        return Arrays.stream(values())
                .filter(EMonth -> EMonth.monthValue == nextMonth)
                .findFirst().get();
    }
}
