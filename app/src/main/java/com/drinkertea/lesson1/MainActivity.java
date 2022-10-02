package com.drinkertea.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView mainTextView;
    Button button_go;
    CheckBox checkBoxRobot;
    ArrayList<String> students = new ArrayList<>();
    public static String url = "https://converse.sharix-app.org";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = "Evgen@sharix-app.org";
        mainTextView = (TextView) findViewById(R.id.main_text_view);
        button_go = (Button) findViewById(R.id.button_go);
        checkBoxRobot = (CheckBox) findViewById(R.id.checkbox_robot);

        students.add("Виталий");
        students.add("Ася");
        students.add("Александр");
        students.add("Даниил");
        students.add("Валенитниа");

        for (String item : students){
            System.out.println(item.toUpperCase(Locale.ROOT));
        }


        int day = 6;
        boolean isMan = day > 6;
        float weight = (float) 65.6;
        double weight_double = 65.6;
        final int age_const = 7;
        button_go.setOnClickListener(view -> sayHelloOnClick("Ася", mainTextView, view, "https://vk.com/"));
        checkBoxRobot.setOnClickListener(view -> button_go.setEnabled(((CheckBox)view).isChecked()));
    }

//    private void enabledButton(View view, Button button) {
//        CheckBox checkBox = (CheckBox) view;
//        if (checkBox.isChecked()){
//            button.setEnabled(true);
//        }
//        else {
//            button.setEnabled(false);
//        }
//    }

//    private boolean isChecked(View view){
//        CheckBox checkBox = (CheckBox) view;
//        if (checkBox.isChecked()){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    private void sayHelloOnClick(String name, TextView textView, View view, String link){
        url = link;
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(new Intent(this, SecondActivity.class));
        //finish();
//        Button button = (Button)view;
//        button.setBackgroundColor(Color.parseColor("#0081ff"));
//        textView.setText("Привет " + name.toUpperCase() + "!");
    }
}