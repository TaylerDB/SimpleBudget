package com.example.tayle.simplebudget;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

/***************************************
 * Hours Spent on this project:
 * 7 hrs
****************************************/

public class MainActivity extends AppCompatActivity {

    // An adapter to interact between the _contactList and the contactListVeiw.
    //BudgetsAdapter budgetsAdapter;

    // All budgets are stored on this list
    List<Budget> budgetList;

    // Selected budget
    private int selectedBudgetPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        registerClickCallBack();

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

//        Button removeBudgetButton = (Button) findViewById(R.id.removeBudgetButton);
//        // ..set what happens when the user clicks
//        removeBudgetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("My App", "remove budget button was clicked");
//                Toast.makeText(getApplicationContext(), "Revoved Budget", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void populateListView() {

        // Create list of items
        String[] myItems = {"Blue", "Green", "Red", "Purple"};

        // Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,                // Context for Activity
                R.layout.item_budget,       // Layout to use (create)
                myItems);                   // Items to be displayed

        // Configure the list view
        ListView list = (ListView) findViewById(R.id.budgetListView);
        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        ListView list = (ListView) findViewById(R.id.budgetListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = "You clicked # " + position + ", which is string: " + textView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onAddBudget(View btnAddBudget) {
        Toast.makeText(getApplicationContext(), "Added New Budget", Toast.LENGTH_SHORT).show();
    }

    public void onRemoveBudget(View btnRemoveBudget) {
        if (!budgetList.isEmpty()) {
            // Make sure we don't try to delete at a negative index
            if(selectedBudgetPosition < 0) {
                selectedBudgetPosition = budgetList.size() - 1;
            }
            if (selectedBudgetPosition <= budgetList.size()) {
                budgetList.remove(budgetList.remove(selectedBudgetPosition));
                //budgetsAdapter.notifyDataSetChanged();
//                if (budgetList.isEmpty()) {
//                    _variablesList.clear();
//                    _variablesAdapter.notifyDataSetChanged();
//                }
            }

            // Check if the selected contact position is past the size of the list
            if (selectedBudgetPosition >= budgetList.size()) {
                // Make sure we don't set the position negative
                selectedBudgetPosition--;
//                _variablesList.clear();
//                _variablesAdapter.notifyDataSetChanged();

                // A hack for unselecting the empty space where the deleted contact was
                ListView budgetListView = (ListView) findViewById(R.id.budgetListView);
                budgetListView.setSelector(android.R.color.transparent);
            }
        }
    }

}