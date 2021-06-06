package com.leeroy.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class FoodItemAdapter extends ArrayAdapter<FoodItem> {
    public FoodItemAdapter(Context context, ArrayList<FoodItem> foodItemArrayList) {
        super(context,0,foodItemArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FoodItem foodItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_food_items, parent, false);
        }
        // Lookup view for data population
        //TextView name = (TextView) convertView.findViewById(R.id.food_item_name);
        //TextView calories = (TextView) convertView.findViewById(R.id.food_item_calories);
        // Populate the data into the template view using the data object
       // name.setText(foodItem.name);
        //calories.setText(foodItem.calories);
        // Return the completed view to render on screen
        return convertView;
    }
}
