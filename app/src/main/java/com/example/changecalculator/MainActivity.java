package com.example.changecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    float cost = 0;
    float cash = 0;
    float change = 0;

    int dollars = 0;
    int quarters = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get cash and cost via interface




        //below code triggers on pressing calculate button
        if (cash > cost)
        {
            change = cash - cost;
            pennies = (int)(change * 100);
            dollars = pennies / 100;
            pennies -= dollars * 100;
            quarters = pennies / 25;
            pennies -= quarters * 25;
            dimes = pennies / 10;
            pennies -= dimes * 10;
            nickels = pennies / 5;
            pennies -= nickels * 5;

           /* Display this
                System.out.println("Your change is: \n"
                    + dollars + " Dollars\n"
                    + quarters + " Quarters\n"
                    + dimes + " Dimes\n"
                    + nickels + " Nickels, and\n"
                    + pennies + " Pennies\n");

            */
        }
        else
        {
            // display System.out.println("The cash given cannot cover the cost\n");
        }

    }
}