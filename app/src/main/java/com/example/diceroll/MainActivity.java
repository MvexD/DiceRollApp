package com.example.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView rollNumber;
    private Button rollButton;
    private Random rng = new Random();
    private SeekBar numberOfWalls;
    private TextView wallsNumber;
    private int[] walls = {4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,22,24,30,32,34,48,50,60,100};
    private int currentWall = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollNumber = findViewById(R.id.rollNumber);
        rollButton = findViewById(R.id.button);
        rollButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                rollDice();
                System.out.println(walls[3]);
            }
        });
        numberOfWalls = findViewById(R.id.numberOfWalls);
        numberOfWalls.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numberOfWalls.setProgress(progress);
                currentWall = progress;
                wallsNumber.setText("D" + walls[currentWall]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        wallsNumber = findViewById(R.id.wallsNumber);


    }
    private void rollDice(){
        int randomnumber = rng.nextInt(walls[currentWall]) + 1;
        rollNumber.setText(""+randomnumber);
        System.out.println(currentWall);

    }
}
