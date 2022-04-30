package com.example.youthsoccermanager.dataclasses.admin;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Entity
public class Mail {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "mailId")
    public String mailId;

    @ColumnInfo(name = "sender")
    public String sender;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "text")
    public String text;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Mail(String sender, String date, String title, String text) {
        this.sender = sender;
        this.date = date; // maybe pull gamedate here instead?
        this.title = title;
        this.text = text;
        try {
            TimeUnit.MILLISECONDS.sleep(100); // to avoid two mailIds that are the same (no multithreading here!)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.mailId = String.valueOf(System.currentTimeMillis()); // TESTING
    }

    public String getMailId() {
        return mailId;
    }

    public String getSender() {
        return sender;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
