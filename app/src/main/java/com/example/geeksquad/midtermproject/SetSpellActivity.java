package com.example.geeksquad.midtermproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetSpellActivity  extends ClosableActivity {


    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button submitButton;
    int[] spells = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_spell);
        getSupportActionBar().hide();
        findElements();
    }

    @Override
    public void onBackPressed() {
        //Take away the ability to use back button
    }

    void onSubmit(View view) {
        int spellIndex = 0;
        for(int i = 0; i < spells.length; i++) {
            if(spells[i] == 1) {
                MainActivity.player.setSpell(chooseSpell(i), spellIndex++);
            }
        }
        finish();
    }

    Spell chooseSpell(int choice) {
        switch(choice) {
            case 0:
                return new Spell("Fireball", "fire", 1, "burned");
            case 1:
                return new Spell("Lightning", "electric", 1, "shocked");
            case 2:
                return new Spell("Frostbolt", "ice", 1, "freezed");
            case 3:
                return new Spell("Tsunami", "water", 1, "none");
            case 4:
                return new Spell("Earthquake", "ground", 1, "none");
            case 5:
                return new Spell("GrassCannon", "grass", 1, "none");
            case 6:
                return new Spell("Enchantment", "fire", 1, "none");
            case 7:
                return new Spell("ClearDay", "grass", 1, "none");
            case 8:
                return new Spell("DragonFocus", "dragon", 1, "none");
            case 9:
                return new Spell("IceArmor", "ice", 1, "none");
            case 10:
                return new Spell("RockFist", "ground", 1, "none");
            case 11:
                return new Spell("Zap", "electric", 1, "none");

        }
        //Should never get here
        return null;
    }

    void showSubmit() {
        if(isFull())
            submitButton.setVisibility(View.VISIBLE);
        else
            submitButton.setVisibility(View.INVISIBLE);
    }

    void findElements() {
        submitButton = findViewById(R.id.submit);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);

        btn1.setBackgroundColor(Color.WHITE);
        btn2.setBackgroundColor(Color.WHITE);
        btn3.setBackgroundColor(Color.WHITE);
        btn4.setBackgroundColor(Color.WHITE);
        btn5.setBackgroundColor(Color.WHITE);
        btn6.setBackgroundColor(Color.WHITE);
        btn7.setBackgroundColor(Color.WHITE);
        btn8.setBackgroundColor(Color.WHITE);
        btn9.setBackgroundColor(Color.WHITE);
        btn10.setBackgroundColor(Color.WHITE);
        btn11.setBackgroundColor(Color.WHITE);
        btn12.setBackgroundColor(Color.WHITE);


    }

    public boolean isFull() {
        int amountOfSpells = 0;
        for(int i = 0; i < spells.length; i++) {
            if(spells[i] != 0) {
                //There's an element at that location
                amountOfSpells++;
            }
        }
        if(amountOfSpells < 3)
        {
            return false;
        }
        return true;
    }

    public void onButton1(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[0] == 1) {
                spells[0] = 0;
                btn1.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[0] = 1;
                btn1.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[0] = 0;
            btn1.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton2(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[1] == 1) {
                spells[1] = 0;
                btn2.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[1] = 1;
                btn2.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[1] = 0;
            btn2.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton3(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[2] == 1) {
                spells[2] = 0;
                btn3.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[2] = 1;
                btn3.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[2] = 0;
            btn3.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton4(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[3] == 1) {
                spells[3] = 0;
                btn4.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[3] = 1;
                btn4.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[3] = 0;
            btn4.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton5(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[4] == 1) {
                spells[4] = 0;
                btn5.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[4] = 1;
                btn5.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[4] = 0;
            btn5.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton6(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[5] == 1) {
                spells[5] = 0;
                btn6.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[5] = 1;
                btn6.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[5] = 0;
            btn6.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton7(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[6] == 1) {
                spells[6] = 0;
                btn7.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[6] = 1;
                btn7.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[6] = 0;
            btn7.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton8(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[7] == 1) {
                spells[7] = 0;
                btn8.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[7] = 1;
                btn8.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[7] = 0;
            btn8.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton9(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[8] == 1) {
                spells[8] = 0;
                btn9.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[8] = 1;
                btn9.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[8] = 0;
            btn9.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton10(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[9] == 1) {
                spells[9] = 0;
                btn10.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[9] = 1;
                btn10.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[9] = 0;
            btn10.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton11(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[10] == 1) {
                spells[10] = 0;
                btn11.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[10] = 1;
                btn11.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[10] = 0;
            btn11.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }
    public void onButton12(View view) {
        if(!isFull()) {
            //if the list is not full

            //toggle the status of the spell and the look of the button
            if(spells[11] == 1) {
                spells[11] = 0;
                btn12.setBackgroundColor(Color.WHITE);
            }
            else {
                spells[11] = 1;
                btn12.setBackgroundColor(Color.YELLOW);
            }
        }
        else {
            spells[11] = 0;
            btn12.setBackgroundColor(Color.WHITE);
        }
        showSubmit();
    }

}
