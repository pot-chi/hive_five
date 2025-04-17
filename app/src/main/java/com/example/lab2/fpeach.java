package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Main Activity class that loads {@link MainFragment2}.
 */
public class fpeach extends FragmentActivity {

    TextView boxB, boxI, boxR, boxD, boxS;
    TextView letB, letI, letR, letD, letS;
    List<TextView> letterViews;
    List<String> letterValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpeach);

        boxB = findViewById(R.id.box_b);
        boxI = findViewById(R.id.box_i);
        boxR = findViewById(R.id.box_r);
        boxD = findViewById(R.id.box_d);
        boxS = findViewById(R.id.box_s);

        letB = findViewById(R.id.let_b);
        letI = findViewById(R.id.let_i);
        letR = findViewById(R.id.let_r);
        letD = findViewById(R.id.let_d);
        letS = findViewById(R.id.let_s);


        letterViews = new ArrayList<>();
        letterViews.add(letB);
        letterViews.add(letI);
        letterViews.add(letR);
        letterViews.add(letD);
        letterViews.add(letS);


        letterValues.add("P");
        letterValues.add("E");
        letterValues.add("A");
        letterValues.add("C");
        letterValues.add("H");

        for (TextView tv : letterViews) {
            tv.setOnClickListener(v -> fillNextEmptyBox((TextView) v));
        }

        findViewById(R.id.enterbttn).setOnClickListener(v -> {
            if (!isCorrectSpelling()) {
                shakeBoxes();
            }
            clearBoxes();//dito ata maglagay GOODJOB!
        });

        findViewById(R.id.rbackbttn).setOnClickListener(v -> backspaceLastLetter());

        shuffleLetters();
    }

    private void fillNextEmptyBox(TextView selectedLetter) {
        String letter = selectedLetter.getText().toString();

        if (boxB.getText().toString().isEmpty()) {
            boxB.setText(letter);
        } else if (boxI.getText().toString().isEmpty()) {
            boxI.setText(letter);
        } else if (boxR.getText().toString().isEmpty()) {
            boxR.setText(letter);
        } else if (boxD.getText().toString().isEmpty()) {
            boxD.setText(letter);
        } else if (boxS.getText().toString().isEmpty()) {
            boxS.setText(letter);
        } else {
            return;
        }

        selectedLetter.setVisibility(View.INVISIBLE);
    }

    private void backspaceLastLetter() {
        if (!boxS.getText().toString().isEmpty()) {
            restoreLetter(boxS.getText().toString());
            boxS.setText("");
        } else if (!boxD.getText().toString().isEmpty()) {
            restoreLetter(boxD.getText().toString());
            boxD.setText("");
        } else if (!boxR.getText().toString().isEmpty()) {
            restoreLetter(boxR.getText().toString());
            boxR.setText("");
        } else if (!boxI.getText().toString().isEmpty()) {
            restoreLetter(boxI.getText().toString());
            boxI.setText("");
        } else if (!boxB.getText().toString().isEmpty()) {
            restoreLetter(boxB.getText().toString());
            boxB.setText("");
        }
    }

    private void restoreLetter(String letter) {
        for (TextView tv : letterViews) {
            if (tv.getText().toString().equalsIgnoreCase(letter) && tv.getVisibility() == View.INVISIBLE) {
                tv.setVisibility(View.VISIBLE);
                break;
            }
        }
    }

    private boolean isCorrectSpelling() {
        String spelledWord =
                boxB.getText().toString().trim() +
                        boxI.getText().toString().trim() +
                        boxR.getText().toString().trim() +
                        boxD.getText().toString().trim() +
                        boxS.getText().toString().trim();

        return spelledWord.equalsIgnoreCase("PEACH");
    }

    private void shakeBoxes() {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        findViewById(R.id.b1).startAnimation(shake);
        boxB.startAnimation(shake);

        findViewById(R.id.b2).startAnimation(shake);
        boxI.startAnimation(shake);

        findViewById(R.id.b3).startAnimation(shake);
        boxR.startAnimation(shake);

        findViewById(R.id.b4).startAnimation(shake);
        boxD.startAnimation(shake);

        findViewById(R.id.b5).startAnimation(shake);
        boxS.startAnimation(shake);
    }

    private void clearBoxes() {
        boxB.setText("");
        boxI.setText("");
        boxR.setText("");
        boxD.setText("");
        boxS.setText("");

        for (TextView tv : letterViews) {
            tv.setVisibility(View.VISIBLE);
        }

        shuffleLetters();
    }

    private void shuffleLetters() {
        Collections.shuffle(letterValues);

        for (int i = 0; i < letterViews.size(); i++) {
            letterViews.get(i).setText(letterValues.get(i));
        }
    }
}