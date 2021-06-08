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
import java.util.Arrays;


public class HomeFragment extends Fragment {


    double totalCal0600=0,totalCal0900=0,totalCal1100=0,totalCal1200=0,totalCal1500=0,totalCal1800=0,totalCalMisc=0, totalCal=0;
    double totalProtein0600=0,totalProtein0900=0,totalProtein1100=0,totalProtein1200=0,totalProtein1500=0,totalProtein1800=0,totalProteinMisc=0,totalProtein=0;
    double totalCarbs0600=0,totalCarbs0900=0,totalCarbs1100=0,totalCarbs1200=0,totalCarbs1500=0,totalCarbs1800=0,totalCarbsMisc=0,totalCarbs=0;
    double totalFat0600=0,totalFat0900=0,totalFat1100=0,totalFat1200=0,totalFat1500=0,totalFat1800=0,totalFatMisc=0,totalFat=0;
    double totalMacros=0, proteinPercent=0, carbPercent=0, fatPercent=0;

    int size = FetchData.foodItemList.size();

    String [] selectableFoods = new String[size];

    boolean[] checkedItems0600= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected0600 = new ArrayList<>();
    int count0600=0;

    boolean[] checkedItems0900= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected0900 = new ArrayList<>();

    boolean[] checkedItems1100= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected1100 = new ArrayList<>();

    boolean[] checkedItems1200= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected1200 = new ArrayList<>();

    boolean[] checkedItems1500= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected1500 = new ArrayList<>();

    boolean[] checkedItems1800= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected1800 = new ArrayList<>();

    boolean[] checkedItemsMisc= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelectedMisc = new ArrayList<>();

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.homeAddFoodButton0600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < FetchData.foodItemList.size(); i++) {
                    selectableFoods[i] = FetchData.foodItemList.get(i).getName();
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItems0600, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelected0600.add(position);
                        } else {
                            for (int j = 0; j < itemsSelected0600.size() ; j++) {
                                for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                                    if (FetchData.foodItemList.get(k).getName().equals(selectableFoods[itemsSelected0600.get(j)])) {
                                        totalCal = totalCal - FetchData.foodItemList.get(k).getCalories();
                                        totalProtein = totalProtein - FetchData.foodItemList.get(k).getProtein();
                                        totalCarbs = totalCarbs - FetchData.foodItemList.get(k).getCarbs();
                                        totalFat = totalFat - FetchData.foodItemList.get(k).getFat();
                                    }
                                }
                            }
                            itemsSelected0600.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < itemsSelected0600.size(); i++) {
                            item = item + selectableFoods[itemsSelected0600.get(i)];
                            if (i != itemsSelected0600.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        binding.homeItemsSelected0600.setText(item);

                        totalCal0600=0;
                        totalProtein0600=0;
                        totalCarbs0600=0;
                        totalFat0600=0;

                        for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                            if (item.contains(FetchData.foodItemList.get(k).getName())) {
                                totalCal0600 = totalCal0600+ FetchData.foodItemList.get(k).getCalories();
                                totalProtein0600 = totalProtein0600 + FetchData.foodItemList.get(k).getProtein();
                                totalCarbs0600 = totalCarbs0600 + FetchData.foodItemList.get(k).getCarbs();
                                totalFat0600 = totalFat0600 + FetchData.foodItemList.get(k).getFat();
                            }
                        }
                        displayNumbers();
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
                        for (int i = 0; i < checkedItems0600.length; i++) {
                            checkedItems0600[i] = false;
                            itemsSelected0600.clear();
                            binding.homeItemsSelected0600.setText("");
                        }
                        totalCal0600=0;
                        totalProtein0600=0;
                        totalCarbs0600=0;
                        totalFat0600=0;
                        displayNumbers();
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        binding.homeAddFoodButton0900.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < FetchData.foodItemList.size(); i++) {
                    selectableFoods[i] = FetchData.foodItemList.get(i).getName();
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItems0900, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelected0900.add(position);
                        } else {
                            for (int j = 0; j < itemsSelected0900.size() ; j++) {
                                for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                                    if (FetchData.foodItemList.get(k).getName().equals(selectableFoods[itemsSelected0900.get(j)])) {
                                        totalCal = totalCal - FetchData.foodItemList.get(k).getCalories();
                                        totalProtein = totalProtein - FetchData.foodItemList.get(k).getProtein();
                                        totalCarbs = totalCarbs - FetchData.foodItemList.get(k).getCarbs();
                                        totalFat = totalFat - FetchData.foodItemList.get(k).getFat();
                                    }
                                }
                            }
                            itemsSelected0900.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < itemsSelected0900.size(); i++) {
                            item = item + selectableFoods[itemsSelected0900.get(i)];
                            if (i != itemsSelected0900.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        binding.homeItemsSelected0900.setText(item);

                        totalCal0900=0;
                        totalProtein0900=0;
                        totalCarbs0900=0;
                        totalFat0900=0;

                        for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                            if (item.contains(FetchData.foodItemList.get(k).getName())) {
                                totalCal0900 = totalCal0900+ FetchData.foodItemList.get(k).getCalories();
                                totalProtein0900 = totalProtein0900 + FetchData.foodItemList.get(k).getProtein();
                                totalCarbs0900 = totalCarbs0900 + FetchData.foodItemList.get(k).getCarbs();
                                totalFat0900 = totalFat0900 + FetchData.foodItemList.get(k).getFat();
                            }
                        }
                        displayNumbers();
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
                        for (int i = 0; i < checkedItems0900.length; i++) {
                            checkedItems0900[i] = false;
                            itemsSelected0900.clear();
                            binding.homeItemsSelected0900.setText("");
                        }
                        totalCal0900=0;
                        totalProtein0900=0;
                        totalCarbs0900=0;
                        totalFat0900=0;
                        displayNumbers();
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        binding.homeAddFoodButton1100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < FetchData.foodItemList.size(); i++) {
                    selectableFoods[i] = FetchData.foodItemList.get(i).getName();
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItems1100, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelected1100.add(position);
                        } else {
                            for (int j = 0; j < itemsSelected1100.size() ; j++) {
                                for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                                    if (FetchData.foodItemList.get(k).getName().equals(selectableFoods[itemsSelected1100.get(j)])) {
                                        totalCal = totalCal - FetchData.foodItemList.get(k).getCalories();
                                        totalProtein = totalProtein - FetchData.foodItemList.get(k).getProtein();
                                        totalCarbs = totalCarbs - FetchData.foodItemList.get(k).getCarbs();
                                        totalFat = totalFat - FetchData.foodItemList.get(k).getFat();
                                    }
                                }
                            }
                            itemsSelected1100.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < itemsSelected1100.size(); i++) {
                            item = item + selectableFoods[itemsSelected1100.get(i)];
                            if (i != itemsSelected1100.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        binding.homeItemsSelected1100.setText(item);

                        totalCal1100=0;
                        totalProtein1100=0;
                        totalCarbs1100=0;
                        totalFat1100=0;

                        for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                            if (item.contains(FetchData.foodItemList.get(k).getName())) {
                                totalCal1100 = totalCal1100+ FetchData.foodItemList.get(k).getCalories();
                                totalProtein1100 = totalProtein1100 + FetchData.foodItemList.get(k).getProtein();
                                totalCarbs1100 = totalCarbs1100 + FetchData.foodItemList.get(k).getCarbs();
                                totalFat1100 = totalFat1100 + FetchData.foodItemList.get(k).getFat();
                            }
                        }
                        displayNumbers();
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
                        for (int i = 0; i < checkedItems1100.length; i++) {
                            checkedItems1100[i] = false;
                            itemsSelected1100.clear();
                            binding.homeItemsSelected1100.setText("");
                        }
                        totalCal1100=0;
                        totalProtein1100=0;
                        totalCarbs1100=0;
                        totalFat1100=0;
                        displayNumbers();
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        binding.homeAddFoodButton1200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < FetchData.foodItemList.size(); i++) {
                    selectableFoods[i] = FetchData.foodItemList.get(i).getName();
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItems1200, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelected1200.add(position);
                        } else {
                            for (int j = 0; j < itemsSelected1200.size() ; j++) {
                                for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                                    if (FetchData.foodItemList.get(k).getName().equals(selectableFoods[itemsSelected1200.get(j)])) {
                                        totalCal = totalCal - FetchData.foodItemList.get(k).getCalories();
                                        totalProtein = totalProtein - FetchData.foodItemList.get(k).getProtein();
                                        totalCarbs = totalCarbs - FetchData.foodItemList.get(k).getCarbs();
                                        totalFat = totalFat - FetchData.foodItemList.get(k).getFat();
                                    }
                                }
                            }
                            itemsSelected1200.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < itemsSelected1200.size(); i++) {
                            item = item + selectableFoods[itemsSelected1200.get(i)];
                            if (i != itemsSelected1200.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        binding.homeItemsSelected1200.setText(item);

                        totalCal1200=0;
                        totalProtein1200=0;
                        totalCarbs1200=0;
                        totalFat1200=0;

                        for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                            if (item.contains(FetchData.foodItemList.get(k).getName())) {
                                totalCal1200 = totalCal1200+ FetchData.foodItemList.get(k).getCalories();
                                totalProtein1200 = totalProtein1200 + FetchData.foodItemList.get(k).getProtein();
                                totalCarbs1200 = totalCarbs1200 + FetchData.foodItemList.get(k).getCarbs();
                                totalFat1200 = totalFat1200 + FetchData.foodItemList.get(k).getFat();
                            }
                        }
                        displayNumbers();
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
                        for (int i = 0; i < checkedItems1200.length; i++) {
                            checkedItems1200[i] = false;
                            itemsSelected1200.clear();
                            binding.homeItemsSelected1200.setText("");
                        }
                        totalCal1200=0;
                        totalProtein1200=0;
                        totalCarbs1200=0;
                        totalFat1200=0;
                        displayNumbers();
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        binding.homeAddFoodButton1500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < FetchData.foodItemList.size(); i++) {
                    selectableFoods[i] = FetchData.foodItemList.get(i).getName();
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItems1500, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelected1500.add(position);
                        } else {
                            for (int j = 0; j < itemsSelected1500.size() ; j++) {
                                for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                                    if (FetchData.foodItemList.get(k).getName().equals(selectableFoods[itemsSelected1500.get(j)])) {
                                        totalCal = totalCal - FetchData.foodItemList.get(k).getCalories();
                                        totalProtein = totalProtein - FetchData.foodItemList.get(k).getProtein();
                                        totalCarbs = totalCarbs - FetchData.foodItemList.get(k).getCarbs();
                                        totalFat = totalFat - FetchData.foodItemList.get(k).getFat();
                                    }
                                }
                            }
                            itemsSelected1500.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < itemsSelected1500.size(); i++) {
                            item = item + selectableFoods[itemsSelected1500.get(i)];
                            if (i != itemsSelected1500.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        binding.homeItemsSelected1500.setText(item);

                        totalCal1500=0;
                        totalProtein1500=0;
                        totalCarbs1500=0;
                        totalFat1500=0;

                        for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                            if (item.contains(FetchData.foodItemList.get(k).getName())) {
                                totalCal1500 = totalCal1500+ FetchData.foodItemList.get(k).getCalories();
                                totalProtein1500 = totalProtein1500 + FetchData.foodItemList.get(k).getProtein();
                                totalCarbs1500 = totalCarbs1500 + FetchData.foodItemList.get(k).getCarbs();
                                totalFat1500 = totalFat1500 + FetchData.foodItemList.get(k).getFat();
                            }
                        }
                        displayNumbers();
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
                        for (int i = 0; i < checkedItems1500.length; i++) {
                            checkedItems1500[i] = false;
                            itemsSelected1500.clear();
                            binding.homeItemsSelected1500.setText("");
                        }
                        totalCal1500=0;
                        totalProtein1500=0;
                        totalCarbs1500=0;
                        totalFat1500=0;
                        displayNumbers();
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        binding.homeAddFoodButton1800.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < FetchData.foodItemList.size(); i++) {
                    selectableFoods[i] = FetchData.foodItemList.get(i).getName();
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItems1800, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelected1800.add(position);
                        } else {
                            for (int j = 0; j < itemsSelected1800.size() ; j++) {
                                for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                                    if (FetchData.foodItemList.get(k).getName().equals(selectableFoods[itemsSelected1800.get(j)])) {
                                        totalCal = totalCal - FetchData.foodItemList.get(k).getCalories();
                                        totalProtein = totalProtein - FetchData.foodItemList.get(k).getProtein();
                                        totalCarbs = totalCarbs - FetchData.foodItemList.get(k).getCarbs();
                                        totalFat = totalFat - FetchData.foodItemList.get(k).getFat();
                                    }
                                }
                            }
                            itemsSelected1800.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < itemsSelected1800.size(); i++) {
                            item = item + selectableFoods[itemsSelected1800.get(i)];
                            if (i != itemsSelected1800.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        binding.homeItemsSelected1800.setText(item);

                        totalCal1800=0;
                        totalProtein1800=0;
                        totalCarbs1800=0;
                        totalFat1800=0;

                        for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                            if (item.contains(FetchData.foodItemList.get(k).getName())) {
                                totalCal1800 = totalCal1800+ FetchData.foodItemList.get(k).getCalories();
                                totalProtein1800 = totalProtein1800 + FetchData.foodItemList.get(k).getProtein();
                                totalCarbs1800 = totalCarbs1800 + FetchData.foodItemList.get(k).getCarbs();
                                totalFat1800 = totalFat1800 + FetchData.foodItemList.get(k).getFat();
                            }
                        }
                        displayNumbers();
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
                        for (int i = 0; i < checkedItems1800.length; i++) {
                            checkedItems1800[i] = false;
                            itemsSelected1800.clear();
                            binding.homeItemsSelected1800.setText("");
                        }
                        totalCal1800=0;
                        totalProtein1800=0;
                        totalCarbs1800=0;
                        totalFat1800=0;
                        displayNumbers();
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        binding.homeAddFoodButtonMisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < FetchData.foodItemList.size(); i++) {
                    selectableFoods[i] = FetchData.foodItemList.get(i).getName();
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle(R.string.add_food_button_dialog_title);
                mBuilder.setMultiChoiceItems(selectableFoods, checkedItemsMisc, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            itemsSelectedMisc.add(position);
                        } else {
                            for (int j = 0; j < itemsSelectedMisc.size() ; j++) {
                                for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                                    if (FetchData.foodItemList.get(k).getName().equals(selectableFoods[itemsSelectedMisc.get(j)])) {
                                        totalCal = totalCal - FetchData.foodItemList.get(k).getCalories();
                                        totalProtein = totalProtein - FetchData.foodItemList.get(k).getProtein();
                                        totalCarbs = totalCarbs - FetchData.foodItemList.get(k).getCarbs();
                                        totalFat = totalFat - FetchData.foodItemList.get(k).getFat();
                                    }
                                }
                            }
                            itemsSelectedMisc.remove(((Integer.valueOf(position))));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(getString(R.string.ok_labl), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < itemsSelectedMisc.size(); i++) {
                            item = item + selectableFoods[itemsSelectedMisc.get(i)];
                            if (i != itemsSelectedMisc.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        binding.homeItemsSelectedMisc.setText(item);

                        totalCalMisc=0;
                        totalProteinMisc=0;
                        totalCarbsMisc=0;
                        totalFatMisc=0;

                        for (int k = 0; k < FetchData.foodItemList.size(); k++) {
                            if (item.contains(FetchData.foodItemList.get(k).getName())) {
                                totalCalMisc = totalCalMisc+ FetchData.foodItemList.get(k).getCalories();
                                totalProteinMisc = totalProteinMisc + FetchData.foodItemList.get(k).getProtein();
                                totalCarbsMisc = totalCarbsMisc + FetchData.foodItemList.get(k).getCarbs();
                                totalFatMisc = totalFatMisc + FetchData.foodItemList.get(k).getFat();
                            }
                        }
                        displayNumbers();
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
                        for (int i = 0; i < checkedItemsMisc.length; i++) {
                            checkedItemsMisc[i] = false;
                            itemsSelectedMisc.clear();
                            binding.homeItemsSelectedMisc.setText("");
                        }
                        totalCalMisc=0;
                        totalProteinMisc=0;
                        totalCarbsMisc=0;
                        totalFatMisc=0;
                        displayNumbers();
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        return root;
    }

    public void displayNumbers(){
        totalCal=totalCal0600+totalCal0900+totalCal1100+totalCal1200+totalCal1500+totalCal1800+totalCalMisc;
        totalProtein=totalProtein0600+totalProtein0900+totalProtein1100+totalProtein1200+totalProtein1500+totalProtein1800+totalProteinMisc;
        totalCarbs=totalCarbs0600+totalCarbs0900+totalCarbs1100+totalCarbs1200+totalCarbs1500+totalCarbs1800+totalCarbsMisc;
        totalFat=totalFat0600+totalFat0900+totalFat1100+totalFat1200+totalFat1500+totalFat1800+totalFatMisc;
        totalMacros = totalProtein + totalCarbs + totalFat;
        proteinPercent = (totalProtein / totalMacros) * 100;
        carbPercent = (totalCarbs / totalMacros) * 100;
        fatPercent = (totalFat / totalMacros) * 100;

        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}