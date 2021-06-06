package com.leeroy.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leeroy.myapplication.FetchData;
import com.leeroy.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        double totalCal=0;
        double totalProtein=0;
        double totalCarbs=0;
        double totalFat=0;

        for (int i = 0; i<FetchData.foodItemList.size()-1; i++){
            totalCal = totalCal + FetchData.foodItemList.get(i).getCalories();
            totalProtein=totalProtein+FetchData.foodItemList.get(i).getProtein();
            totalCarbs=totalCarbs+FetchData.foodItemList.get(i).getCarbs();
            totalFat=totalFat+FetchData.foodItemList.get(i).getFat();
        }


        binding.homeCaloriesTv.setText(""+Math.round(totalCal*100d)/100d);
        binding.homeProteinTv.setText(""+Math.round(totalProtein*100d)/100d);
        binding.homeCarbTv.setText(""+Math.round(totalCarbs*100d)/100d);
        binding.homeFatTv.setText(""+Math.round(totalFat*100d)/100d);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}