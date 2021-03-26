    package com.thecodechemist.basicidlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private Game game;

    private InvestmentArrayAdapter investmentArrayAdapter;
    private Handler hUiUpdate;
    private Runnable rUiUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();

        //Setup for Investments ListView
        ListView lvInvestments = findViewById(R.id.lvInvestments);
        investmentArrayAdapter = new InvestmentArrayAdapter(getApplicationContext(), R.layout.investment_list_item, game);
        lvInvestments.setAdapter(investmentArrayAdapter);
        List<Investment> investmentList = game.getInvestmentsList();
        for(Investment investment: investmentList) {
            investmentArrayAdapter.add(investment);
        }

        //Setup for refreshing UI every 1 second
        hUiUpdate = new Handler();
        rUiUpdate = () -> {
            game.generateIncomeFromInvestments();
            updateUI();
            hUiUpdate.postDelayed(rUiUpdate, 1000);
        };
        hUiUpdate.post(rUiUpdate);

        //Setup for Gain Money Button
        Button btnAddMoney = findViewById(R.id.btnAddMoney);
        btnAddMoney.setOnClickListener(v -> {
            game.moneyButtonTapped();
            updateUI();
        });

        //Button for debugging/testing purposes only to get a large amount of cash
        Button btnDebugCash = findViewById(R.id.btnDebugCash);
        btnDebugCash.setOnClickListener(v -> {
            game.setMoney(game.getMoney() + 1000000000);
            updateUI();
        });

    }

        public void updateUI() {
        //Update the view on screen with the current cash and investment info
        TextView tvCurrentMoney = findViewById(R.id.tvCurrentMoney);
        tvCurrentMoney.setText("£ " + game.getMoney());
        investmentArrayAdapter.notifyDataSetChanged();

    }
}