package com.example.youthsoccermanager.layouthelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;

public class TitleBarSetter {
    public static void postTitleBar(View title_bar_view, LinearLayout linearLayout, String pageTitle) {
        // ADD SETTING OF DATE AND MONEY!
        linearLayout.addView(title_bar_view);
        ((TextView)title_bar_view.findViewById(R.id.title_bar_pagetitle)).setText(pageTitle);
        String date = GameDatabase.getDB().gameVarDAO().getDate().getValue();
        ((TextView)title_bar_view.findViewById(R.id.title_bar_date)).setText(date);
        String money = "€ " + GameDatabase.getDB().gameVarDAO().getMoney().getValue();
        ((TextView)title_bar_view.findViewById(R.id.title_bar_money)).setText(money);
    }

}
