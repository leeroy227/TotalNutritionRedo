package com.leeroy.totalNutrition.ui.foodItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leeroy.totalNutrition.FetchData;
import com.leeroy.totalNutrition.databinding.FragmentFoodItemsBinding;

public class FoodItemsFragment extends Fragment {
    public static String text="";
    private FragmentFoodItemsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFoodItemsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Sets the text of the scroll view to the dataParsed from FetchData.class
        for(int i = 0; i< FetchData.foodItemList.size(); i++){
           TextView textView = new TextView(getContext());
           textView.setText(FetchData.foodItemList.get(i).getName());
           textView.setTextSize(24);
           binding.foodItemLinearLayout.addView(textView);
       }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}