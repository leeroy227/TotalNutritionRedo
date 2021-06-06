package com.leeroy.myapplication.ui.foodItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leeroy.myapplication.databinding.FragmentFoodItemsBinding;

public class FoodItemsFragment extends Fragment {
    public static String text="";
    private FragmentFoodItemsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFoodItemsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Sets the text of the scroll view to the dataParsed from FetchData.class
        binding.foodItemTextView.setText(text);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}