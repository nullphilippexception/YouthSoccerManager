package com.example.youthsoccermanager.gamecreation;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.youthsoccermanager.dataclasses.admin.Mail;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;
import com.example.youthsoccermanager.gamecreation.database.MailDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatorMailDB {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createInitialMails() {
        adminWelcome();
        presidentWelcome();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void adminWelcome() {
        String sender = "GameAdmin";
        String date = "01-07";
        String title = "Welcome to the game!";
        String text = "Welcome to YouthSoccerManager! If you are unsure what do to next, " +
                "just refer to the tutorials or the question mark in the top right corner.";

        Mail welcomeMail = new Mail(sender, date, title, text);
        MailDAO mailDAO = GameDatabase.getDB().mailDao();
        mailDAO.insertMail(welcomeMail);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void presidentWelcome() {
        String sender = "President";
        String date = "01-07";
        String title = "Welcome to the club!";
        String text = "Hello new Manager, welcome to our Soccer club! I expect you to build a successful Youth Academy, " +
                "which will compete at the highest level and serve as a pipeline to the Pro's.";

        Mail welcomeMail = new Mail(sender, date, title, text);
        MailDAO mailDAO = GameDatabase.getDB().mailDao();
        mailDAO.insertMail(welcomeMail);
    }
}
