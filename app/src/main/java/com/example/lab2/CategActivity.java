package com.example.lab2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class CategActivity extends FragmentActivity {

    Button animalsbttn;
    Button fruitsbttn;
    Button numbttn;
    Button colorsbttn;
    Dialog mDialog;
    Dialog nDialog;
    Dialog tDialog;
    Dialog dDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categ);
        Button button = findViewById(R.id.backbttn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategActivity.this, START.class);
                startActivity(intent);
            }
        });

        animalsbttn = findViewById(R.id.animalsbttn);
        mDialog = new Dialog(this);

        animalsbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.setContentView(R.layout.animalspopup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button playButton = mDialog.findViewById(R.id.aplaybtn2);
                Button exitButton = mDialog.findViewById(R.id.abackbtn2);

                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CategActivity.this, abird.class);
                        startActivity(intent);
                        mDialog.dismiss();
                    }
                });

                exitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
                mDialog.show();
            }
        });

        fruitsbttn = findViewById(R.id.fruitsbttn);
        nDialog = new Dialog(this);

        fruitsbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nDialog.setContentView(R.layout.fruitspopup);
                nDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button playButton2 = nDialog.findViewById(R.id.aplaybtn2);
                Button exitButton2 = nDialog.findViewById(R.id.abackbtn2);

                playButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CategActivity.this, fkiwi.class);
                        startActivity(intent);
                        nDialog.dismiss();
                    }
                });

                exitButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nDialog.dismiss();
                    }
                });
                nDialog.show();
            }
        });

        numbttn = findViewById(R.id.numbttn);
        tDialog = new Dialog(this);

        numbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDialog.setContentView(R.layout.numberspopup);
                tDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button playButton3 = tDialog.findViewById(R.id.aplaybtn3);
                Button exitButton3 = tDialog.findViewById(R.id.abackbtn3);

                playButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CategActivity.this, none.class);
                        startActivity(intent);
                        tDialog.dismiss();
                    }
                });

                exitButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tDialog.dismiss();
                    }
                });
                tDialog.show();
            }
        });

        colorsbttn = findViewById(R.id.colorsbttn);
        dDialog = new Dialog(this);

        colorsbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dDialog.setContentView(R.layout.colorspopup);
                dDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button playButton4 = dDialog.findViewById(R.id.aplaybtn4);
                Button exitButton4 = dDialog.findViewById(R.id.abackbtn4);

                playButton4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CategActivity.this, cgreen.class);
                        startActivity(intent);
                        dDialog.dismiss();
                    }
                });

                exitButton4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dDialog.dismiss();
                    }
                });
                dDialog.show();
            }
        });
    }
}