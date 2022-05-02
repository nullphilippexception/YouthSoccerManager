package com.example.youthsoccermanager.gamecreation.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.youthsoccermanager.dataclasses.admin.GlobalGameVar;
import com.example.youthsoccermanager.dataclasses.admin.Mail;
import com.example.youthsoccermanager.dataclasses.admin.Team;
import com.example.youthsoccermanager.gamecreation.database.TeamDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

@Database(entities = {Mail.class, GlobalGameVar.class, Team.class}, version = 1)
public abstract class GameDatabase extends RoomDatabase {
    // CHANGE TO SINGLETON DESIGN PATTERN HERE? https://developer.android.com/training/data-storage/room#java
    private static GameDatabase gameDB;

    public static void init(Context context) {
        gameDB = Room.databaseBuilder(context,
                GameDatabase.class, "game-db").allowMainThreadQueries().build();
    }

    public static GameDatabase getDB() {
        return gameDB;
    }

    public abstract MailDAO mailDao();
    public abstract GlobalGameVarDAO gameVarDAO();
    public abstract TeamDAO teamDAO();


}
