package com.example.age_calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView t1;
    DatePicker d1,d2;
    Button b1;
    int resyear,resmonth,resday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t);

        d1=findViewById(R.id.d1);
        d2=findViewById(R.id.d2);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                int sday=d1.getDayOfMonth();
                int smonth=d1.getMonth();
                int syear=d1.getYear();

                int eday=d2.getDayOfMonth();
                int emonth=d2.getMonth();
                int eyear=d2.getYear();

                    resyear = eyear - syear;
                    if (emonth >= smonth) {
                        resmonth = emonth - smonth;
                    } else {
                        resmonth = emonth - smonth;
                        resmonth = 12 + resmonth;
                        resyear--;
                    }
                    if (eday >= sday) {
                        resday = eday - sday;
                    } else {
                        resday = eday - sday;
                        resday = 31 + resday;
                        if (resmonth == 0) {
                            resmonth = 11;
                            resyear--;
                        } else {
                            resmonth--;
                        }
                    }
                    if (resday <0 || resmonth<0 || resyear<0) {
                        Toast.makeText(getApplicationContext(), "Date of birth must be greater than current date", Toast.LENGTH_LONG).show();
                        t1.setText("Date of birth must be greater than current date");
                    }
                    else {
                        t1.setText("Age: " + resyear + " years /" + resmonth + " months/" + resday + " days");
                    }
                }
        });
    }
}
