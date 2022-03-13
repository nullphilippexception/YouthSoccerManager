package com.example.youthsoccermanager.layouthelper;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPersonnelPreviewValues;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPreviewValues;
import com.example.youthsoccermanager.todaysevents.TodaysEvents;

import java.util.HashMap;
import java.util.Map;

public class PersonPreviewCreator {
    public static void createTeamPlayerPreview(View player_preview, LinearLayout linearLayout,
                                                 HashMap<EPreviewValues, String> playerValues, int playerId, boolean onMyTeam) {
        linearLayout.addView(player_preview);
        String shortenedName = checkAndShortenName(playerValues.get(EPreviewValues.NAME));
        ((TextView)player_preview.findViewById(R.id.myteam_player_preview_name)).setText(shortenedName);
        String ovrDisplay = playerValues.get(EPreviewValues.OVERALL);
        if(!onMyTeam) ovrDisplay = "??";
        String detailText = playerValues.get(EPreviewValues.POSITION) + " | OVR: " + ovrDisplay +
                            " | " + playerValues.get(EPreviewValues.AGE) + " y.o." ;
        ((TextView)player_preview.findViewById(R.id.myteam_player_preview_detaildata)).setText(detailText);
        ((Button)player_preview.findViewById(R.id.template_btn_name_rename)).setId(playerId);
    }


    // FILL THAT METHOD ONCE THESE CLASSES EXIST!
    public static void createMailContactsPreview(View mail_contacts_preview, LinearLayout linearLayout,
                                                 Map<EPersonnelPreviewValues, String> contactValues, int contactId) {
        linearLayout.addView(mail_contacts_preview);
        String shortenedName = checkAndShortenName(contactValues.get(EPersonnelPreviewValues.NAME));
        ((TextView)mail_contacts_preview.findViewById(R.id.mail_contacts_preview_name)).setText(shortenedName);
        ((TextView)mail_contacts_preview.findViewById(R.id.mail_contacts_preview_jobtitle))
                .setText(contactValues.get(EPersonnelPreviewValues.TITLE));
        ((TextView)mail_contacts_preview.findViewById(R.id.mail_contacts_preview_team))
                .setText(contactValues.get(EPersonnelPreviewValues.AFFILIATION));
        ((Button)mail_contacts_preview.findViewById(R.id.template_btn_name_rename_mail_contacts_preview)).setId(contactId);
    }

    // MAYBE ADJUST DETAILS HERE; ALSO CHECK WITH TXT SIZE IN XML
    private static String checkAndShortenName(String fullname) {
        if(fullname.length() >= 18) {
            return fullname.substring(0,15) + "...";
        }
        return fullname;
    }
}
