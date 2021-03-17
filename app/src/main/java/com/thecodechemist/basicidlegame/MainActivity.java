package com.thecodechemist.basicidlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game game;
    Handler hUiUpdate;
    Runnable rUiUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();

        hUiUpdate = new Handler();
        rUiUpdate = new Runnable() {
            @Override
            public void run() {
                game.generateIncomeFromInvestments();
                updateUI();
                hUiUpdate.postDelayed(rUiUpdate, 1000);
            }
        };
        hUiUpdate.post(rUiUpdate);

        Button btnAddMoney = findViewById(R.id.btnAddMoney);
        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.moneyButtonTapped();
                updateUI();
            }
        });

        Button btnBuyInvestment = findViewById(R.id.btnBuyInvestment);
        btnBuyInvestment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.purchaseInvestment();
                updateUI();
            }
        });

    }

    public void updateUI() {
        TextView tvCurrentMoney = findViewById(R.id.tvCurrentMoney);
        tvCurrentMoney.setText("£ " + game.getMoney());

        TextView tvCurrentInvestments = findViewById(R.id.tvCurrentInvestments);
        tvCurrentInvestments.setText(Integer.toString(game.getInvestmentCount()));
    }
}