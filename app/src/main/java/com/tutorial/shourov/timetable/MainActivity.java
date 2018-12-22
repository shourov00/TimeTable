package com.tutorial.shourov.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DiscreteSeekBar timesTableSeekBar;
    private ListView timesTableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTableSeekBar = findViewById(R.id.timestable_seekbar);
        timesTableListView = findViewById(R.id.times_table_listview);

        /*timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);*/

        timesTableSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (value < min) {
                    timesTable = min;
                    timesTableSeekBar.setProgress(min);
                } else {
                    timesTable = value;
                }

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        /*timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress < min) {
                    timesTable = min;
                    timesTableSeekBar.setProgress(min);
                } else {
                    timesTable = progress;
                }

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/

        generateTimesTable(10);

    }

    private void generateTimesTable(int progressNumber) {

        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            timesTableContent.add("" + progressNumber + " * " + i + " = " + Integer.toString(i * progressNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }
}
