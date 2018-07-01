package com.example.android.cellulartechquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     *The method is called when submit button is clicked
     */
    public void submitAttempts(View view) {

        //figure out if the user has entered name
        EditText userName = (EditText) findViewById(R.id.name_field);
        String name = userName.getText().toString();

        //figure out if question 1 answered
        CheckBox fourG = (CheckBox) findViewById(R.id.checkbox_1a);
        boolean hasFourG = fourG.isChecked();
        CheckBox oneG = (CheckBox) findViewById(R.id.checkbox_1c);
        boolean hasOneG = oneG.isChecked();
        CheckBox threeG = (CheckBox) findViewById(R.id.checkbox_1d);
        boolean hasThreeG = threeG.isChecked();
        CheckBox twoG = (CheckBox) findViewById(R.id.checkbox_1b);
        boolean hasTwoG = twoG.isChecked();

        //figure out if question2 is answered
        RadioButton hspa = (RadioButton) findViewById(R.id.radio_button_1c);
        boolean hasHspa = hspa.isChecked();

        //figure out if question 3 answered
        CheckBox gsm = (CheckBox) findViewById(R.id.checkbox_2a);
        boolean hasGsm = gsm.isChecked();
        CheckBox nordicMobile = (CheckBox) findViewById(R.id.checkbox_2c);
        boolean hasNmt = nordicMobile.isChecked();
        CheckBox lte = (CheckBox) findViewById(R.id.checkbox_2b);
        boolean hasLte = lte.isChecked();

        //figure out if question4 is answered
        RadioButton fdma = (RadioButton) findViewById(R.id.radio_button_2b);
        boolean hasFdma = fdma.isChecked();

        //figure out if question 5 is answered
        EditText zeroFour = (EditText) findViewById(R.id.date_field);
        String year = zeroFour.getText().toString();

        //figure out if question 6 is answered
        RadioButton twoMega = (RadioButton) findViewById(R.id.radio_button_3b);
        boolean hasTwoMega = twoMega.isChecked();

        //figure out if question7 is answered
        CheckBox massiveMimo = (CheckBox) findViewById(R.id.checkbox_3a);
        boolean hasMimo = massiveMimo.isChecked();
        CheckBox mmWaves = (CheckBox) findViewById(R.id.checkbox_3c);
        boolean hasMm = mmWaves.isChecked();
        CheckBox antenna = (CheckBox) findViewById(R.id.checkbox_3b);
        boolean hasAntenna = antenna.isChecked();
        CheckBox none = (CheckBox) findViewById(R.id.checkbox_3d);
        boolean hasNone = none.isChecked();

        //figure out if question 8 is answered
        EditText fiveG = (EditText) findViewById(R.id.nextgen_field);
        String nextGen = fiveG.getText().toString();


        // call the calculateScore method
        int score = calculateScore(hasFourG, hasOneG, hasThreeG,hasTwoG,
                hasHspa, hasGsm, hasNmt, hasFdma, hasLte, year, hasTwoMega, hasMm,
                hasMimo,hasAntenna,hasNone, nextGen);

        /*
        *@score is the give score value
        * Toasts messages within conditional loops displaying score and user performance
         */

        if (score >= 6) {
            Toast.makeText(this, name + "\n\nYou scored " + score + " out of 8" + "\n\nExcellent", Toast.LENGTH_LONG).show();
        } else if (score == 5) {
            Toast.makeText(this, name + "\n\nYou scored " + score + " out of 8" + "\n\nGood", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, name + "\n\nYou scored " + score + " out of 8" + "\n\nTry Again!", Toast.LENGTH_LONG).show();
        }
    }

    /*
     *This method checks correct answers and return total points
     */
    private int calculateScore(boolean hasFourG, boolean hasOneG, boolean hasThreeG,boolean hasTwoG, boolean hasHspa,
                               boolean hasGsm, boolean hasNmt, boolean hasFdma, boolean hasLte, String year,
                               boolean hasTwoMega, boolean hasMm, boolean hasMimo,boolean hasAntenna,boolean hasNone, String nextGen) {
        int points = 0;

        // add 1 point to correct answer for question 1
        if (hasFourG && hasOneG && hasThreeG && !hasTwoG) {
            points += 1;
        }

        // add 1 point to correct answer for question 2
        if (hasHspa) {
            points += 1;
        }

        // add 1 point to correct answer for question 3
        if (hasGsm && hasNmt && !hasLte) {
            points += 1;
        }

        // add 1 point to correct answer for question 4
        if (hasFdma) {
            points += 1;
        }

        // add 1 point to correct answer for question 5
        if (year.equalsIgnoreCase("2004")) {
            points += 1;
        }

        // add 1 point to correct answer for question 6
        if (hasTwoMega) {
            points += 1;
        }

        // add 1 point to correct answer for question 7
        if (hasMimo && hasMm && !hasAntenna && !hasNone) {
            points += 1;
        }

        // add 1 point to correct answer for question 8
        if (nextGen.equalsIgnoreCase("5G")) {
            points += 1;
        }
        return points;

    }

    public void resetAttempts(View view) {

        // Reset the username
        EditText userName = (EditText) findViewById(R.id.name_field);
        userName.getText().clear();

        // reset quesstion 1
        CheckBox fourG = (CheckBox) findViewById(R.id.checkbox_1a);
        fourG.setChecked(false);
        CheckBox oneG = (CheckBox) findViewById(R.id.checkbox_1c);
        oneG.setChecked(false);
        CheckBox threeG = (CheckBox) findViewById(R.id.checkbox_1d);
        threeG.setChecked(false);
        CheckBox twoG = (CheckBox) findViewById(R.id.checkbox_1b);
        twoG.setChecked(false);

        //reset question 2
        RadioGroup question2 = (RadioGroup) findViewById(R.id.radio_group_1);
        question2.clearCheck();

        //reset question 3
        CheckBox gsm = (CheckBox) findViewById(R.id.checkbox_2a);
        gsm.setChecked(false);
        CheckBox lte = (CheckBox) findViewById(R.id.checkbox_2b);
        lte.setChecked(false);
        CheckBox nordicMobile = (CheckBox) findViewById(R.id.checkbox_2c);
        nordicMobile.setChecked(false);

        //reset question 4
        RadioGroup question4 = (RadioGroup) findViewById(R.id.radio_group_2);
        question4.clearCheck();

        //reset question 5
        EditText zeroFour = (EditText) findViewById(R.id.date_field);
        zeroFour.getText().clear();

        //reset question 6
        RadioGroup question6 = (RadioGroup) findViewById(R.id.radio_group_3);
        question6.clearCheck();

        //reset question 7
        CheckBox massiveMimo = (CheckBox) findViewById(R.id.checkbox_3a);
        massiveMimo.setChecked(false);
        CheckBox mmWaves = (CheckBox) findViewById(R.id.checkbox_3c);
        mmWaves.setChecked(false);
        CheckBox antenna = (CheckBox) findViewById(R.id.checkbox_3b);
        antenna.setChecked(false);
        CheckBox none = (CheckBox) findViewById(R.id.checkbox_3d);
        none.setChecked(false);

        //reset question 8
        EditText fiveG = (EditText) findViewById(R.id.nextgen_field);
        fiveG.getText().clear();

        Toast.makeText(this, "The quiz has been reset!", Toast.LENGTH_LONG).show();
    }
}

