package com.example.lab2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class nfour extends FragmentActivity {

    TextView boxB, boxI, boxR, boxD;
    TextView letB, letI, letR, letD;
    List<TextView> letterViews;
    List<String> letterValues = new ArrayList<>();
    Button backbttn;
    Dialog mDialog;
    Dialog nDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfour);

        backbttn = findViewById(R.id.backbttn);
        mDialog = new Dialog(this);

        backbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mDialog.setContentView(R.layout.newcategpopup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button confirmButton = mDialog.findViewById(R.id.ncenter);
                Button cancelButton = mDialog.findViewById(R.id.ncexit);

                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nfour.this, CategActivity.class);
                        startActivity(intent);
                        mDialog.dismiss();
                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
                mDialog.show();
            }
        });

        boxB = findViewById(R.id.box_b);
        boxI = findViewById(R.id.box_i);
        boxR = findViewById(R.id.box_r);
        boxD = findViewById(R.id.box_d);

        letB = findViewById(R.id.let_b);
        letI = findViewById(R.id.let_i);
        letR = findViewById(R.id.let_r);
        letD = findViewById(R.id.let_d);

        letterViews = new ArrayList<>();
        letterViews.add(letB);
        letterViews.add(letI);
        letterViews.add(letR);
        letterViews.add(letD);

        letterValues.add("F");
        letterValues.add("O");
        letterValues.add("U");
        letterValues.add("R");

        for (TextView tv : letterViews) {
            tv.setOnClickListener(v -> fillNextEmptyBox((TextView) v));
        }

        findViewById(R.id.enterbttn).setOnClickListener(v -> {
            if (!isCorrectSpelling()) {
                shakeBoxes();
                clearBoxes();
            } else {
                nDialog = new Dialog(this);
                nDialog.setContentView(R.layout.goodjobpopup);
                nDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button nextButton = nDialog.findViewById(R.id.gjnextbtn);
                Button backButton = nDialog.findViewById(R.id.gjbackbtn);

                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nfour.this,nfive.class);
                        startActivity(intent);
                        nDialog.dismiss();
                    }
                });

                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nDialog.dismiss();
                    }
                });
                nDialog.show();
            }
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
        } else {
            return;
        }

        selectedLetter.setVisibility(View.INVISIBLE);
    }

    private void backspaceLastLetter() {
        if (!boxD.getText().toString().isEmpty()) {
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
                        boxI.getText().toString().trim() + boxR.getText().toString().trim() +
                        boxD.getText().toString().trim();

        return spelledWord.equalsIgnoreCase("FOUR");
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
    }

    private void clearBoxes() {
        boxB.setText("");
        boxI.setText("");
        boxR.setText("");
        boxD.setText("");

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