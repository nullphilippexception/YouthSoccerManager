package com.example.youthsoccermanager.dataclasses.admin;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GlobalGameVar {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="category")
    public String category;

    @ColumnInfo(name="value")
    public String value;


    public GlobalGameVar(String category, String value) {
        this.category = category;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
