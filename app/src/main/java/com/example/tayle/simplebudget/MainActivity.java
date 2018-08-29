package com.example.tayle.simplebudget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***************************************
 * Hours Spent on this project:
 * 10 hrs
****************************************/
public class MainActivity extends AppCompatActivity {

    Button addNewBudgetButton;
    Button removeNewBudgetButton;
    TextView totalAmountView;

    double budget = 0.00d;

    // Sets decimal precision to two
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This makes it so the keyboard doesn't push up the buttons
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    } // End of onCreate()

    /**
     * This method will add a value to the budget
     *      Using modified code from https://stackoverflow.com/questions/10903754/input-text-dialog-android
     */
    public void onAddValue(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Value to be added to budget");

        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Added New Budget", Toast.LENGTH_SHORT).show();

                // Convert string to a number
                double newAddedValue = Double.parseDouble(input.getText().toString());
                budget = budget + newAddedValue;
                display(budget);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    } // End of onAddValue()

    /**
     * This method wil remove from the budget
     *      Using modified code from https://stackoverflow.com/questions/10903754/input-text-dialog-android
     */
    public void onRemoveValue(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Value to be removed from the budget");

        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("REMOVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Added New Budget", Toast.LENGTH_SHORT).show();

                // Convert string to a number
                double newRemovedValue = Double.parseDouble(input.getText().toString());
                budget = budget - newRemovedValue;
                display(budget);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    } // End of onRemoveValue()

    /**
     * This method displays the budget
     * @param number
     */
    private void display(double number){
        // Find the totalAmount TextView
        totalAmountView = (TextView)findViewById(R.id.totalAmount);
        totalAmountView.setText("$" + df2.format(number));
    } // End of display()
}