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
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***************************************
 * Hours Spent on this project:
 * 7 hrs
****************************************/

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This makes it so the keyboard doesn't push up the buttons
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        // Wire up the button to do stuff
        // ..get the button
        Button addNewBudgetButton = (Button) findViewById(R.id.addNewBudgetButton);
        // ..set what happens when the user clicks
        addNewBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("My App", "Add new budget button was clicked");
                Toast.makeText(getApplicationContext(), "Added New Budget", Toast.LENGTH_SHORT).show();
            }
        });

        // Wire up the button to do stuff
        // ..get the button
        Button removeBudgetButton = (Button) findViewById(R.id.removeBudgetButton);
        // ..set what happens when the user clicks
        addNewBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("My App", "Remove new budget button was clicked");
                Toast.makeText(getApplicationContext(), "Added New Budget", Toast.LENGTH_SHORT).show();
            }
        });



    }



}