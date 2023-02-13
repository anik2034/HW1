package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextNumber);
        TextView textView = findViewById(R.id.textView2);
        Button button = findViewById(R.id.convert);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = 0;
                try {
                     number = Integer.parseInt(editText.getText().toString());
                    if(number > 999999999 || number < 0){
                        Toast.makeText(MainActivity.this, "Invalid Number", Toast.LENGTH_LONG).show();

                    }
                    else {
                        String result = numberToWord(number);
                        textView.setText(result);
                    }
                }
                catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Invalid Number", Toast.LENGTH_LONG).show();

                }


            }
        });





    }


    private static String hundred(int number, Map<Integer,String> numberMap) {
        String str = "";

        while (number > 0) {

            if (number < 10) {
                str += numberMap.get(number) + " ";
                break;
            } else if (number >= 10 && number < 20) {
                str += numberMap.get(number) + " ";
                break;
            } else if (number >= 20 && number < 100) {
                str += numberMap.get((number / 10) * 10) + " ";
                number = number % 10;
                continue;
            }
            else if(number >= 100 && number < 1000){
                str += numberMap.get(number/100) + " " + numberMap.get(100) + " ";
                number = number%100;
                continue;
            }
        }
        return str;

    }

    public static String numberToWord(int number){

        String str = "";

        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(0,"zero");
        numberMap.put(1,"one");
        numberMap.put(2,"two");
        numberMap.put(3,"three");
        numberMap.put(4,"four");
        numberMap.put(5,"five");
        numberMap.put(6,"six");
        numberMap.put(7,"seven");
        numberMap.put(8,"eight");
        numberMap.put(9,"nine");
        numberMap.put(10,"ten");
        numberMap.put(11,"eleven");
        numberMap.put(12,"twelve");
        numberMap.put(13,"thirteen");
        numberMap.put(14,"fourteen");
        numberMap.put(15,"fifteen");
        numberMap.put(16,"sixteen");
        numberMap.put(17,"seventeen");
        numberMap.put(18,"eighteen");
        numberMap.put(19,"nineteen");
        numberMap.put(20,"twenty");
        numberMap.put(30,"thirty");
        numberMap.put(40,"forty");
        numberMap.put(50,"fifty");
        numberMap.put(60,"sixty");
        numberMap.put(70,"seventy");
        numberMap.put(80,"eighty");
        numberMap.put(90,"ninety");
        numberMap.put(100,"hundred");
        numberMap.put(1000,"thousand");
        numberMap.put(10000,"ten thousand");
        numberMap.put(100000,"hundred thousand");
        numberMap.put(1000000,"million");
        numberMap.put(10000000,"ten million");
        numberMap.put(100000000,"hundred million");

        if(number == 0 ) return numberMap.get(0);

        while(number > 0){


            if(number < 1000){
                str += hundred(number,numberMap);
                break;
            }
            else if(number >= 1000 && number < 10000){
                str += hundred(number/1000,numberMap) + numberMap.get(1000) + " ";
                number = number % 1000;
                continue;

            }
            else if(number >= 10000 && number < 100000){
                str += hundred(number/1000,numberMap) + numberMap.get(1000) + " ";
                number = number % 10000;
                number = number % 1000;
                continue;

            }
            else if(number >= 100000 && number < 1000000){
                str += hundred(number/1000,numberMap) + numberMap.get(1000) + " ";
                number = number % 100000;
                number = number % 10000;
                number = number % 1000;
                continue;

            }

            else if(number >= 1000000 && number < 10000000){
                str += hundred(number/1000000,numberMap) + numberMap.get(1000000) + " ";
                number = number % 1000000;
                continue;

            }
            else if(number >= 10000000 && number < 100000000){
                str += hundred(number/1000000,numberMap) + numberMap.get(1000000) + " ";
                number = number % 10000000;
                number = number % 1000000;
                continue;

            }
            else if(number >= 100000000 && number < 1000000000){
                str += hundred(number/1000000,numberMap) + numberMap.get(1000000) + " ";
                number = number % 100000000;
                number = number % 10000000;
                number = number % 1000000;
                continue;

            }








        }

        return str;


    }
}