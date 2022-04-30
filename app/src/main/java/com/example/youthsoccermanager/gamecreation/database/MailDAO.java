package com.example.youthsoccermanager.gamecreation.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.youthsoccermanager.dataclasses.admin.Mail;

import java.util.List;

@Dao
public interface MailDAO {
        @Query("SELECT * FROM mail")
        List<Mail> getAll();

        @Query("SELECT * FROM mail WHERE mailId LIKE :thisId")
        Mail getMailById(String thisId);

        @Query("SELECT * FROM mail WHERE sender LIKE :senderName")
        List<Mail> getFromSender(String senderName);

        @Insert
        void insertMail(Mail mail);

        @Delete
        void delete(Mail mail);

        /* //BUGGY RN
        @Query("DELETE FROM mail WHERE mailId = :thisId")
        abstract void deleteById(String thisId);
         */

}
