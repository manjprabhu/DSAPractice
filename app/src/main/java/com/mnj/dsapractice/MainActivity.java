package com.mnj.dsapractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetMinimumFromStack stack = new GetMinimumFromStack();
        stack.push(2);
        stack.push(6);
        stack.push(4);
        stack.push(1);
        stack.push(5);

        stack.display();
        stack.minStackDisplay();

        stack.getMinimum();
    }
}