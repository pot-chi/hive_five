package com.example.lab2;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class abird extends FragmentActivity {

    TextView boxB, boxI, boxR, boxD;
    ImageView imgB, imgI, imgR, imgD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abird);

        // Link the 4 letter boxes (TextViews)
        boxB = findViewById(R.id.B);
        boxI = findViewById(R.id.I);
        boxR = findViewById(R.id.R);
        boxD = findViewById(R.id.D);

        // Link the letter buttons (ImageViews)
        imgB = findViewById(R.id.b1);
        imgI = findViewById(R.id.b2);
        imgR = findViewById(R.id.b3);
        imgD = findViewById(R.id.b4);

        // When a letter is tapped, fill it in the next empty box
        imgB.setOnClickListener(v -> fillNextEmptyBox("B"));
        imgI.setOnClickListener(v -> fillNextEmptyBox("I"));
        imgR.setOnClickListener(v -> fillNextEmptyBox("R"));
        imgD.setOnClickListener(v -> fillNextEmptyBox("D"));

        // Submit button
        findViewById(R.id.enterbttn).setOnClickListener(v -> {
            if (!isCorrectSpelling()) {
                shakeBoxes();
            } else {
                // Optionally show success here!
            }
        });
    }

    private void fillNextEmptyBox(String letter) {
        if (boxB.getText().toString().isEmpty()) {
            boxB.setText(letter);
        } else if (boxI.getText().toString().isEmpty()) {
            boxI.setText(letter);
        } else if (boxR.getText().toString().isEmpty()) {
            boxR.setText(letter);
        } else if (boxD.getText().toString().isEmpty()) {
            boxD.setText(letter);
        }
    }

    private boolean isCorrectSpelling() {
        String spelledWord =
                boxB.getText().toString().trim() +
                        boxI.getText().toString().trim() +
                        boxR.getText().toString().trim() +
                        boxD.getText().toString().trim();

        return spelledWord.equalsIgnoreCase("BIRD");
    }

    private void shakeBoxes() {
        Animation shake = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);

        if (boxB != null) boxB.startAnimation(shake);
        if (boxI != null) boxI.startAnimation(shake);
        if (boxR != null) boxR.startAnimation(shake);
        if (boxD != null) boxD.startAnimation(shake);
    }
}
