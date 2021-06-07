package com.leeroy.totalNutrition.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leeroy.totalNutrition.FetchData;
import com.leeroy.totalNutrition.R;
import com.leeroy.totalNutrition.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import static com.leeroy.totalNutrition.MainActivity.counter;

public class HomeFragment extends Fragment {


    double totalCal=0, totalProtein=0, totalCarbs=0, totalFat=0, totalMacros=0,proteinPercent=0,
    carbPercent=0,fatPercent=0;

    int size = FetchData.foodItemList.size();
    String [] selectableFoods = new String[size];




    boolean[] checkedItems= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected = new ArrayList<>();
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.homeAddFoodButton0600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<FetchData.foodItemList.size(); i++){
                    selectableFoods[i]=FetchData.foodItemList.get(i).getName();
                    System.out.println(selectableFoods[i]);
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelected.add(position);
                        } else {
                            itemsSelected.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String item = "";
                                for(int i = 0; i<itemsSelected.size(); i++){
                                    item=item+selectableFoods[itemsSelected.get(i)];
                                    if(i != itemsSelected.size() -1){
                                        item=item+", ";
                                    }
                                }
                                binding.homeItemsSelected0600.setText(item);
                            }
                        });

                        mBuilder.setNegativeButton(getString(R.string.dismiss_label), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                mBuilder.setNeutralButton(getString(R.string.clear_all_label), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            itemsSelected.clear();
                            binding.homeItemsSelected0600.setText("");
                        }
                    }
                });

                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });









        for (int i = 0; i<FetchData.foodItemList.size()-1; i++){

            totalCal = totalCal + FetchData.foodItemList.get(i).getCalories();
            totalProtein=totalProtein+FetchData.foodItemList.get(i).getProtein();
            totalCarbs=totalCarbs+FetchData.foodItemList.get(i).getCarbs();
            totalFat=totalFat+FetchData.foodItemList.get(i).getFat();
        }


        totalMacros=totalProtein+totalCarbs+totalFat;
        proteinPercent = (totalProtein/totalMacros)*100;
        carbPercent = (totalCarbs/totalMacros)*100;
        fatPercent = (totalFat/totalMacros)*100;

        binding.homeCaloriesTv.setText(""+Math.round(totalCal)+" Cal");
        binding.homeProteinTv.setText(""+Math.round(proteinPercent)+"% P");
        binding.homeCarbTv.setText(""+Math.round(carbPercent)+"% C");
        binding.homeFatTv.setText(""+Math.round(fatPercent)+"% F");


        return root;
    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("",counter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}