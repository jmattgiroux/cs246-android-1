package com.example.changecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

//    https://crunchify.com/how-to-create-simple-calculator-android-app-using-android-studio/

    float cost = 0;
    float cash = 0;
    float change = 0;

    int dollars = 0;
    int quarters = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;

    Button calculate;

    EditText inputCost, inputCash;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calculate = (Button) findViewById(R.id.CalculateButton);

//        https://abhiandroid.com/ui/edittext
        inputCost = (EditText) findViewById(R.id.CostField);
        inputCash =  (EditText) findViewById(R.id.CashField);

        result = (TextView) findViewById(R.id.Result);

        //get cash and cost via interface



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                https://stackoverflow.com/questions/10735679/how-to-convert-string-into-float-value-in-android/10735754

                try{
                    String string = inputCost.getText().toString();

                    cost = Float.parseFloat(string);

                    string = inputCash.getText().toString();

                    cash = Float.parseFloat(string);
                } catch (Exception e){
                    result.setText("Please only input numbers");
                }


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

                    String resultString;

                    resultString = "Your change is: \n"
                            + dollars + " Dollars\n"
                            + quarters + " Quarters\n"
                            + dimes + " Dimes\n"
                            + nickels + " Nickels, and\n"
                            + pennies + " Pennies\n";
           /* Display this
                System.out.println("Your change is: \n"
                    + dollars + " Dollars\n"
                    + quarters + " Quarters\n"
                    + dimes + " Dimes\n"
                    + nickels + " Nickels, and\n"
                    + pennies + " Pennies\n");
            */
                    result.setText(resultString);

                }
                else
                {

                    result.setText("The cash given cannot cover the cost");
                    // display System.out.println("The cash given cannot cover the cost\n");
                }
                //reset our values
                cost = 0;
                cash = 0;

            }
        });






    }
}