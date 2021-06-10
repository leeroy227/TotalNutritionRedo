package com.leeroy.totalNutrition.ui.foodItems;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leeroy.totalNutrition.AddFood;
import com.leeroy.totalNutrition.R;
import com.leeroy.totalNutrition.database.DBManager;
import com.leeroy.totalNutrition.database.DatabaseHelper;
import com.leeroy.totalNutrition.databinding.FragmentFoodItemsBinding;

public class FoodItemsFragment extends Fragment {
    public static String text="";
    private FragmentFoodItemsBinding binding;
    private DBManager dbManager;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[]{DatabaseHelper._ID,DatabaseHelper.NAME};
    final int[] to = new int[]{R.id.id,R.id.name};
    private ListView listView;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFoodItemsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setHasOptionsMenu(true);

        dbManager = new DBManager(getContext());
        dbManager.open();
        Cursor cursor = dbManager.fetch();


        adapter = new SimpleCursorAdapter(getContext(), R.layout.activity_add_food_item, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        binding.foodItemsListView.setAdapter(adapter);

        binding.foodItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView nameTextView = (TextView) view.findViewById(R.id.name);

                String id = idTextView.getText().toString();
                String name = nameTextView.getText().toString();
               // Intent modify_intent = new Intent(getActivity().getApplicationContext(), ModifyFoodItemActivity.class);
                //modify_intent.putExtra("name", name);
               // modify_intent.putExtra("id", id);
               // startActivity(modify_intent);
            }
            });




   return root;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_food_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_food_button) {

            Intent add_mem = new Intent(getContext(), AddFood.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}