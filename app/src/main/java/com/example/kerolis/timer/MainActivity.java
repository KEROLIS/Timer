package com.example.kerolis.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView tv;
    Button go;
    int min;
    int sec;
    String second;
    int pro;
    void trans(long  seconds){  min= (int) (seconds/60);
        sec= (int) (seconds%60);
        if (sec<=9)
            second="0"+Integer.toString(sec);
        else
            second=Integer.toString(sec);

        tv.setText(Integer.toString(min)+" : "+second);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        go= (Button) findViewById(R.id.go);
        tv=(TextView) findViewById(R.id.tv);
        seekBar=(SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(600);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, boolean fromUser) {
                trans(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(seekBar.getProgress()*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        seekBar.setProgress((int) (millisUntilFinished/1000));
                    }

                    @Override
                    public void onFinish() {

                        Toast.makeText(MainActivity.this, "time up !", Toast.LENGTH_SHORT).show();
                        tv.setText("0 : 00");
                    }
                }.start();



            }
        });





    }

}
