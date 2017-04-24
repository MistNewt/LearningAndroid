package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Variable initializations
     */
    int scoreA,scoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Score manipulating functions Team A
     */
    public void threePointerTeamA(View view) {
        scoreA += 3;
        displayForTeamA(scoreA);
    }
    public void twoPointerTeamA(View view) {
        scoreA += 2;
        displayForTeamA(scoreA);
    }
    public void freeThrowTeamA(View view) {
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    /**
     * Score manipulating functions Team B
     */

    public void threePointerTeamB(View view) {
        scoreB += 3;
        displayForTeamB(scoreB);
    }
    public void twoPointerTeamB(View view) {
        scoreB += 2;
        displayForTeamB(scoreB);
    }
    public void freeThrowTeamB(View view) {
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    //Reset funciton
    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}
