package com.leeroy.totalNutrition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.leeroy.totalNutrition.database.DBManager;
import com.leeroy.totalNutrition.ui.foodItems.FoodItemsFragment;

public class AddFood extends Activity implements View.OnClickListener {

    private Button addFoodBtn;
    private EditText nameEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Food");
        setContentView(R.layout.activity_add_food_item);

        nameEditText=(EditText) findViewById(R.id.add_food_edittext);

        addFoodBtn = (Button) findViewById((R.id.add_food_button));

        dbManager = new DBManager(this);
        dbManager.open();
        addFoodBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_fooditem_button:
                final String name = nameEditText.getText().toString();
                dbManager.insert(name);
                Intent main = new Intent(AddFood.this, FoodItemsFragment.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }
}

