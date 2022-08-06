package com.example.smell;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    TextView smellDescs;
    Button learnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        String mainDescs = "Smell isn’t just important for making you hungry whenever food is around. Smell is an important part of our survival. When you smell food, an animal, or even an object, you can often use that information to tell you what that thing is and what condition it is in. You might be able to use your sense of smell to tell if food is spoiled. When we smell that food is spoiled, we don’t have to “taste test” to figure out if it will make us sick. Our ancestors used all their senses – including smell – to hunt animals and find edible food in the wild.";

        smellDescs = findViewById(R.id.smellDescs);
        learnMore = findViewById(R.id.learnMore);

        smellDescs.setText(mainDescs);
        learnMore.setOnClickListener(v-> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
    }
}