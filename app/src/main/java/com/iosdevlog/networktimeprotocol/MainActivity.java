package com.iosdevlog.networktimeprotocol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iosdevlog.networktimeprotocol.Util.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = (TextView) findViewById(R.id.time_textview);

        Button button = (Button) findViewById(R.id.get_network_time_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final long networkTime = Util.getCurrentNetworkTime();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Date date = new Date();
                                if (networkTime > 0) {
                                    date = new Date(networkTime);
                                    Toast.makeText(MainActivity.this, "get network time success",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "get network time failed, use local time",
                                            Toast.LENGTH_SHORT).show();
                                }

                                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                String text = simpleFormatter.format(date);
                                timeTextView.setText(text);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
