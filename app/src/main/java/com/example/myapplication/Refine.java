package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Refine extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editText;
    private TextView charCountTextView;
    ImageView refine;
    TextView seekBarValue;
    Spinner eBlood;
    String[] courses = {"Availble | Hey Let Us Connect", "Away | Stay Discrete And Watch",
            "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView7 = findViewById(R.id.textView7);
        TextView textView8 = findViewById(R.id.textView8);

        refine = findViewById(R.id.back);
        eBlood = findViewById(R.id.Blood);
        editText = findViewById(R.id.ed1);
        charCountTextView = findViewById(R.id.txt);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBarValue = findViewById(R.id.seekBarValue);
        eBlood.setOnItemSelectedListener(this);
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);
        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        eBlood.setAdapter(ad);
        refine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Refine.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set up a TextWatcher to monitor changes in the EditText
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Not needed for this example
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Check if the character count exceeds the limit
                int CHARACTER_LIMIT = 250;
                if (countCharacters(charSequence.toString()) > CHARACTER_LIMIT) {
                    // Trim the text to the limit
                    String trimmedText = charSequence.toString().substring(0, CHARACTER_LIMIT);
                    editText.setText(trimmedText);
                    editText.setSelection(trimmedText.length()); // Move the cursor to the end
                    Toast.makeText(Refine.this, "Character limit reached!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update character count when the text changes
                    int characterCount = countCharacters(charSequence.toString());
                    updateCharacterCount(characterCount);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the TextView with the current progress value
                seekBarValue.setText(String.valueOf(progress));
                updateTextViewPosition(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final TextView[] textViews = {textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8};

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
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String Bloodgroup = courses[i];
        Toast.makeText(this, Bloodgroup, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private int countCharacters(String text) {
        int totalCharacters = 0;
        String[] words = text.split("\\s+");
        for (String word : words) {
            totalCharacters += word.length();
        }
        return totalCharacters;
    }

    private void updateCharacterCount(int count) {
        charCountTextView.setText(String.valueOf(count));
    }

    private void updateTextViewPosition(int progress) {
        // Calculate the new margin based on SeekBar progress
        int margin = calculateNewMargin(progress);

        // Update the margin of the TextView
        updateMargin(seekBarValue, margin);
    }

    private int calculateNewMargin(int progress) {

        int maxMargin = 980;
        return (int) ((float) progress / 100 * maxMargin);
    }

    private void updateMargin(View view, int newMargin) {
        // Update the margin of the view dynamically
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.leftMargin = newMargin;
        view.setLayoutParams(params);
    }


}