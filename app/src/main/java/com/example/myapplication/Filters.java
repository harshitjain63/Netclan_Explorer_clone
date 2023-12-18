package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Filters extends AppCompatActivity {
    ImageView img;
    TextView seekBarValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        img=findViewById(R.id.back);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView7 = findViewById(R.id.textView7);
        TextView textView8 = findViewById(R.id.textView8);
        TextView textView9 = findViewById(R.id.textView9);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBarValue = findViewById(R.id.seekBarValues);

        final TextView[] textViews = {textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,textView9};

        // Set click listener for each TextView
        for (final TextView textView : textViews) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle the background color of the clicked TextView
                    if (textView.getTag() == null || (boolean) textView.getTag()) {
//                        textView.setBackgroundColor(Color.TRANSPARENT);
                        textView.setBackground(getDrawable(R.drawable.borderz));
                        textView.setTextColor(getResources().getColor(R.color.white));
                        textView.setTag(false);
                    } else {
//                        textView.setBackgroundColor(getResources().getColor(R.color.black));
                        textView.setBackground(getDrawable(R.drawable.border));
                        textView.setTextColor(getResources().getColor(R.color.darkblue));
                        textView.setTag(true);
                    }
                }
            });
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Filters.this, MainActivity.class);
                startActivity(i);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the TextView with the current progress value
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}