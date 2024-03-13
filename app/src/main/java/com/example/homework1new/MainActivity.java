package com.example.homework1new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int CountNum = 0;
    public MyViewModel model;
    TextView nameView;
    TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        nameView = findViewById(R.id.nameView);
        countView = findViewById(R.id.countView);

        model.getUserName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String userName) {
                nameView.setText("Привет, " + userName);
            }
        });


        model.getCountNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer num) {
                countView.setText(String.valueOf(num));
            }
        });

    }

    public void buttonClick(View view) {
        CountNum++;
        model.setCountNum(CountNum);
    }

    public void buttonSetName(View view) {

        EditText editText = findViewById(R.id.editText);
        if(editText.getText().toString().isEmpty()) {
            model.setUserName("Аноним!");
        } else {
            model.setUserName(String.valueOf(editText.getText()));
        }

    }


}