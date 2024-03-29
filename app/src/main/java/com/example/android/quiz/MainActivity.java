package com.example.android.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  submitAll(View v){
        score=0;
        calculateRadioScore("q1");
        calculateRadioScore("q2");
        calculateCheckBoxScore();
        calculateEditTextScore();
        displayScore();

    }

    public void calculateRadioScore(String radioId){
        if(radioId=="q1"){
            RadioGroup q1_rg= (RadioGroup) findViewById(R.id.q1);
            int answerId = q1_rg.getCheckedRadioButtonId();
            if(answerId==2131165278){
                score++;
            }
        }
        else if(radioId=="q2"){
            RadioGroup q2_rg= (RadioGroup) findViewById(R.id.q2);
            int answerId = q2_rg.getCheckedRadioButtonId();
            if(answerId==2131165283){
                score++;
            }
        }
    }

    public void calculateCheckBoxScore(){
        CheckBox check1= (CheckBox) findViewById(R.id.q3_1);
        CheckBox check2= (CheckBox) findViewById(R.id.q3_2);
        CheckBox check3= (CheckBox) findViewById(R.id.q3_3);
        if(check1.isChecked() && check2.isChecked() && !check3.isChecked()){
            score++;
        }
    }

    public void calculateEditTextScore(){
        EditText q4= (EditText) findViewById(R.id.q4);
        if(q4.getText().toString().equals("function")){
            score++;
        }
    }

    public void displayScore(){
        Context context = getApplicationContext();
        CharSequence text = "Your score is "+score+"/4";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
