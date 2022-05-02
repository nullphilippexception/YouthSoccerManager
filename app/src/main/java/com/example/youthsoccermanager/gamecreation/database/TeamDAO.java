package com.example.youthsoccermanager.gamecreation.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.youthsoccermanager.dataclasses.admin.Mail;
import com.example.youthsoccermanager.dataclasses.admin.Team;

import java.util.List;

@Dao
public interface TeamDAO {

    @Query("SELECT * FROM team WHERE league LIKE :league")
    List<Team> getAllInLeague(String league);

    @Insert
    void insertTeam(Team team);
}
