package com.example.youthsoccermanager.personnelandfinance.finance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.personnelandfinance.finance.financialdeals.AvailableDeals;
import com.example.youthsoccermanager.personnelandfinance.finance.financialdeals.CurrentDeals;
import com.example.youthsoccermanager.personnelandfinance.finance.financialdeals.OtherIncomeSources;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FinancialDeals extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_personnel_finance_financial_deals;
    private final int MAIN_VIEW_BODY = R.layout.personnel_finance_financial_deals;
    private final String PAGE_TITLE = "Financial Deals";

    /**
     * onCreate is called when the activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
    }

    public void help(View view) {

    }

    public void goToFinancialDealSubMenu(View view) {
        int selectedId = view.getId();
        Intent intent = getIntent();
        switch(selectedId) {
            case R.id.financial_deals_available_deals:
                intent.setClass(this, AvailableDeals.class);
                break;
            case R.id.financial_deals_current_deals:
                intent.setClass(this, CurrentDeals.class);
                break;
            case R.id.financial_deals_other_income_sources:
                intent.setClass(this, OtherIncomeSources.class);
                break;
            default:
                Logger.getAnonymousLogger().log(Level.WARNING, "Unknown deal submenu requested");
                Toast.makeText(this, "Unknown submenu requested", Toast.LENGTH_LONG);
        }

        startActivity(intent);
    }
}
