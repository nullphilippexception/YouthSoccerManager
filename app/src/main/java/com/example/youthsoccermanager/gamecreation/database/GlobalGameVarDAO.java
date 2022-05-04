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

    @Query("SELECT * FROM globalgamevar WHERE category LIKE 'u19league'")
    GlobalGameVar getU19League();

    @Query("SELECT * FROM globalgamevar WHERE category LIKE 'u17league'")
    GlobalGameVar getU17League();

    @Query("SELECT * FROM globalgamevar WHERE category LIKE 'u15league'")
    GlobalGameVar getU15League();

    @Query("SELECT * FROM globalgamevar WHERE category LIKE 'u13league'")
    GlobalGameVar getU13League();

    @Insert
    void setGlobalGameVar(GlobalGameVar ggv);

    @Delete
    void delete(Mail mail);
}
