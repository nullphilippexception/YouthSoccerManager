package com.example.youthsoccermanager.gamecreation.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.youthsoccermanager.dataclasses.admin.GlobalGameVar;
import com.example.youthsoccermanager.dataclasses.admin.Mail;

import java.util.List;

@Dao
public interface GlobalGameVarDAO {

    @Query("SELECT * FROM globalgamevar")
    List<GlobalGameVar> getAll();

    @Query("SELECT * FROM globalgamevar WHERE category LIKE 'date'")
    GlobalGameVar getDate();

    @Query("SELECT * FROM globalgamevar WHERE category LIKE 'money'")
    GlobalGameVar getMoney();

    @Insert
    void setGlobalGameVar(GlobalGameVar ggv);

    @Delete
    void delete(Mail mail);
}
