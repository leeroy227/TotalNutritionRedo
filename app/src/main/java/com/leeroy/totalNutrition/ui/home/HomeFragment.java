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



public class HomeFragment extends Fragment {


    double totalCal=0, totalProtein=0, totalCarbs=0, totalFat=0, totalMacros=0, proteinPercent=0,
    carbPercent=0,fatPercent=0;

    int size = FetchData.foodItemList.size();

    String [] selectableFoods = new String[size];

    boolean[] checkedItems0600= new boolean[selectableFoods.length];
    ArrayList<Integer> itemsSelected0600 = new ArrayList<>();

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
                        for (int i = 0; i < itemsSelected0600.size() ; i++) {
                            for (int j = 0; j < FetchData.foodItemList.size(); j++) {
                                if (FetchData.foodItemList.get(j).getName().equals(selectableFoods[itemsSelected0600.get(i)])) {
                                    totalCal = totalCal + FetchData.foodItemList.get(j).getCalories();
                                    totalProtein = totalProtein + FetchData.foodItemList.get(j).getProtein();
                                    totalCarbs = totalCarbs + FetchData.foodItemList.get(j).getCarbs();
                                    totalFat = totalFat + FetchData.foodItemList.get(j).getFat();
                                    System.out.println("testing testing");
                                }
                            }
                        }
                        totalMacros = totalProtein + totalCarbs + totalFat;
                        proteinPercent = (totalProtein / totalMacros) * 100;
                        carbPercent = (totalCarbs / totalMacros) * 100;
                        fatPercent = (totalFat / totalMacros) * 100;

                        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
                        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
                        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
                        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
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
                        for (int i = 0; i < itemsSelected0900.size() ; i++) {
                            System.out.println("test1");
                            System.out.println(itemsSelected0900.get(i));
                            System.out.println(selectableFoods[itemsSelected0900.get(i)]);
                            for (int j = 0; j < FetchData.foodItemList.size(); j++) {
                                if (FetchData.foodItemList.get(j).getName().equals(selectableFoods[itemsSelected0900.get(i)])) {
                                    totalCal = totalCal + FetchData.foodItemList.get(j).getCalories();
                                    totalProtein = totalProtein + FetchData.foodItemList.get(j).getProtein();
                                    totalCarbs = totalCarbs + FetchData.foodItemList.get(j).getCarbs();
                                    totalFat = totalFat + FetchData.foodItemList.get(j).getFat();
                                    System.out.println("testing testing");
                                }
                            }
                        }
                        totalMacros = totalProtein + totalCarbs + totalFat;
                        proteinPercent = (totalProtein / totalMacros) * 100;
                        carbPercent = (totalCarbs / totalMacros) * 100;
                        fatPercent = (totalFat / totalMacros) * 100;

                        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
                        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
                        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
                        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
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
                        for (int i = 0; i < itemsSelected1100.size() ; i++) {
                            for (int j = 0; j < FetchData.foodItemList.size(); j++) {
                                if (FetchData.foodItemList.get(j).getName().equals(selectableFoods[itemsSelected1100.get(i)])) {
                                    totalCal = totalCal + FetchData.foodItemList.get(j).getCalories();
                                    totalProtein = totalProtein + FetchData.foodItemList.get(j).getProtein();
                                    totalCarbs = totalCarbs + FetchData.foodItemList.get(j).getCarbs();
                                    totalFat = totalFat + FetchData.foodItemList.get(j).getFat();
                                }
                            }
                        }
                        totalMacros = totalProtein + totalCarbs + totalFat;
                        proteinPercent = (totalProtein / totalMacros) * 100;
                        carbPercent = (totalCarbs / totalMacros) * 100;
                        fatPercent = (totalFat / totalMacros) * 100;

                        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
                        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
                        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
                        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
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
                        for (int i = 0; i < itemsSelected1200.size() ; i++) {
                            for (int j = 0; j < FetchData.foodItemList.size(); j++) {
                                if (FetchData.foodItemList.get(j).getName().equals(selectableFoods[itemsSelected1200.get(i)])) {
                                    totalCal = totalCal + FetchData.foodItemList.get(j).getCalories();
                                    totalProtein = totalProtein + FetchData.foodItemList.get(j).getProtein();
                                    totalCarbs = totalCarbs + FetchData.foodItemList.get(j).getCarbs();
                                    totalFat = totalFat + FetchData.foodItemList.get(j).getFat();
                                }
                            }
                        }
                        totalMacros = totalProtein + totalCarbs + totalFat;
                        proteinPercent = (totalProtein / totalMacros) * 100;
                        carbPercent = (totalCarbs / totalMacros) * 100;
                        fatPercent = (totalFat / totalMacros) * 100;

                        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
                        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
                        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
                        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
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
                        for (int i = 0; i < itemsSelected1500.size() ; i++) {
                            for (int j = 0; j < FetchData.foodItemList.size(); j++) {
                                if (FetchData.foodItemList.get(j).getName().equals(selectableFoods[itemsSelected1500.get(i)])) {
                                    totalCal = totalCal + FetchData.foodItemList.get(j).getCalories();
                                    totalProtein = totalProtein + FetchData.foodItemList.get(j).getProtein();
                                    totalCarbs = totalCarbs + FetchData.foodItemList.get(j).getCarbs();
                                    totalFat = totalFat + FetchData.foodItemList.get(j).getFat();
                                    System.out.println("testing testing");
                                }
                            }
                        }
                        totalMacros = totalProtein + totalCarbs + totalFat;
                        proteinPercent = (totalProtein / totalMacros) * 100;
                        carbPercent = (totalCarbs / totalMacros) * 100;
                        fatPercent = (totalFat / totalMacros) * 100;

                        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
                        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
                        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
                        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
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
                        for (int i = 0; i < itemsSelected1800.size() ; i++) {
                            for (int j = 0; j < FetchData.foodItemList.size(); j++) {
                                if (FetchData.foodItemList.get(j).getName().equals(selectableFoods[itemsSelected1800.get(i)])) {
                                    totalCal = totalCal + FetchData.foodItemList.get(j).getCalories();
                                    totalProtein = totalProtein + FetchData.foodItemList.get(j).getProtein();
                                    totalCarbs = totalCarbs + FetchData.foodItemList.get(j).getCarbs();
                                    totalFat = totalFat + FetchData.foodItemList.get(j).getFat();
                                    System.out.println("testing testing");
                                }
                            }
                        }
                        totalMacros = totalProtein + totalCarbs + totalFat;
                        proteinPercent = (totalProtein / totalMacros) * 100;
                        carbPercent = (totalCarbs / totalMacros) * 100;
                        fatPercent = (totalFat / totalMacros) * 100;

                        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
                        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
                        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
                        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
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
                        for (int i = 0; i < itemsSelectedMisc.size() ; i++) {
                            for (int j = 0; j < FetchData.foodItemList.size(); j++) {
                                if (FetchData.foodItemList.get(j).getName().equals(selectableFoods[itemsSelectedMisc.get(i)])) {
                                    totalCal = totalCal + FetchData.foodItemList.get(j).getCalories();
                                    totalProtein = totalProtein + FetchData.foodItemList.get(j).getProtein();
                                    totalCarbs = totalCarbs + FetchData.foodItemList.get(j).getCarbs();
                                    totalFat = totalFat + FetchData.foodItemList.get(j).getFat();
                                    System.out.println("testing testing");
                                }
                            }
                        }
                        totalMacros = totalProtein + totalCarbs + totalFat;
                        proteinPercent = (totalProtein / totalMacros) * 100;
                        carbPercent = (totalCarbs / totalMacros) * 100;
                        fatPercent = (totalFat / totalMacros) * 100;

                        binding.homeCaloriesTv.setText("" + Math.round(totalCal) + " Cal");
                        binding.homeProteinTv.setText("" + Math.round(proteinPercent) + "% P");
                        binding.homeCarbTv.setText("" + Math.round(carbPercent) + "% C");
                        binding.homeFatTv.setText("" + Math.round(fatPercent) + "% F");
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
                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });




        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}