package com.leeroy.totalNutrition.ui.nutritionFacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leeroy.totalNutrition.databinding.FragmentNutritionBinding;

public class NutritionFactsFragment extends Fragment {


    public static double totalCalories0600;
    private FragmentNutritionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNutritionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        double totalCalories = totalCalories0600,totalFat=0,totalSatFat = 0,totalTransFat = 0,totalPolyFat = 0,totalMonoFat = 0,totalCholesterol = 0,totalSodium = 0,
        totalCarbs=0,totalFiber=0,totalSugars=0,totalAddedSugars=0,totalProtein=0,totalVitD=0,totalCalcium=0,totalIron=0,totalPotassium=0,
        totalVitA=0,totalVitC=0,totalVitE=0,totalVitK=0,totalThiamin=0,totalRiboflavin=0,totalNiacin=0,totalVitB6=0,totalFolate=0,totalVitB12=0,
        totalBiotin=0,totalPantothenicAcid=0,totalPhosphorus=0,totalIodine=0,totalMagnesium=0,totalZinc=0,totalSelenium=0,totalCopper=0,totalManganese=0,
        totalChromium=0,totalMolybdenum=0,totalChloride=0,totalCholine=0,totalVitD3=0,totalVitK2=0,totalLycopene=0,totalLutein=0,totalZeaxantin=0,
        totalOmega3=0,totalOmega6=0,totalMCTs=0,totalBacillus=0,totalEpigallo=0;


        binding.nutritionFactsCalories.setText("Calories: "+totalCalories);
        binding.nutritionFactsFat.setText("Fat: "+totalFat+"g");
        binding.nutritionFactsSaturatedFat.setText("Saturated Fat: "+totalSatFat+"g");
        binding.nutritionFactsTransFat.setText("Trans Fat: "+totalTransFat+"g");
        binding.nutritionFactsPolyFat.setText("Poly Fat: "+totalPolyFat+"g");
        binding.nutritionFactsMonoFat.setText("Mono Fat: "+totalMonoFat+"g");
        binding.nutritionFactsCholesterol.setText("Cholesterol: "+totalCholesterol+"mg");
        binding.nutritionFactsSodium.setText("Sodium: "+totalSodium+"mg");
        binding.nutritionFactsCarbs.setText("Carbs: "+totalCarbs+"g");
        binding.nutritionFactsFiber.setText("Fiber: "+totalFiber+"g");
        binding.nutritionFactsSugars.setText("Sugars: "+totalSugars+"g");
        binding.nutritionFactsAddedSugars.setText("Added Sugars: "+totalAddedSugars+"g");
        binding.nutritionFactsProtein.setText("Protein: "+totalProtein+"g");
        binding.nutritionFactsVitD.setText("Vitamin D: "+totalVitD+"µg");
        binding.nutritionFactsCalcium.setText("Calcium: "+totalCalcium+"mg");
        binding.nutritionFactsIron.setText("Iron: "+totalIron+"mg");
        binding.nutritionFactsPotassium.setText("Potassium: "+totalPotassium+"mg");
        binding.nutritionFactsVitA.setText("Vitamin A: "+totalVitA+"µg");
        binding.nutritionFactsVitC.setText("Vitamin C: "+totalVitC+"mg");
        binding.nutritionFactsVitE.setText("Vitamin E: "+totalVitE+"mg");
        binding.nutritionFactsVitK.setText("Vitamin K: "+totalVitK+"µg");
        binding.nutritionFactsThiamin.setText("Thiamin: "+totalThiamin+"mg");
        binding.nutritionFactsRiboflavin.setText("Riboflavin: "+totalRiboflavin+"mg");
        binding.nutritionFactsNiacin.setText("Niacin: "+totalNiacin+"mg");
        binding.nutritionFactsVitB6.setText("Vitamin B6: "+totalVitB6+"mg");
        binding.nutritionFactsFolate.setText("Folate: "+totalFolate+"µg");
        binding.nutritionFactsVitB12.setText("Vitamin B12: "+totalVitB12+"µg");
        binding.nutritionFactsBiotin.setText("Biotin: "+totalBiotin+"µg");
        binding.nutritionFactsPantothenicAcid.setText("Pantothenic Acid: "+totalPantothenicAcid+"mg");
        binding.nutritionFactsPhosphorus.setText("Phosphorus: "+totalPhosphorus+"mg");
        binding.nutritionFactsIodine.setText("Iodine: "+totalIodine+"mg");
        binding.nutritionFactsMagnesium.setText("Magnesium: "+totalMagnesium+"mg");
        binding.nutritionFactsZinc.setText("Zinc: "+totalZinc+"mg");
        binding.nutritionFactsSelenium.setText("Selenium: "+totalSelenium+"mg");
        binding.nutritionFactsCopper.setText("Copper: "+totalCopper+"mg");
        binding.nutritionFactsManganese.setText("Manganese: "+totalManganese+"mg");
        binding.nutritionFactsChromium.setText("Chromium: "+totalChromium+"µg");
        binding.nutritionFactsMolybdenum.setText("Molybdenum: "+totalMolybdenum+"µg");
        binding.nutritionFactsChloride.setText("Chloride: "+totalChloride+"mg");
        binding.nutritionFactsCholine.setText("Choline: "+totalCholine+"mg");
        binding.nutritionFactsVitD3.setText("Vitamin D3: "+totalVitD3+"mg");
        binding.nutritionFactsVitK2.setText("Vitamin K2: "+totalVitK2+"mg");
        binding.nutritionFactsLycopene.setText("Lycopene: "+totalLycopene+"mg");
        binding.nutritionFactsLutein.setText("Lutein: "+totalLutein+"mg");
        binding.nutritionFactsZeaxanthin.setText("Zeaxanthin: "+totalZeaxantin+"mg");
        binding.nutritionFactsOmega3.setText("Omega-3: "+totalOmega3+"mg");
        binding.nutritionFactsOmega6.setText("Omega-6: "+totalOmega6+"mg");
        binding.nutritionFactsMcts.setText("MCTs: "+totalMCTs+"g");
        binding.nutritionFactsBacillus.setText("Bacillus Coagulans: "+totalBacillus+"mn");
        binding.nutritionFactsEpigalloc.setText("Epigallocatechin Gallate: "+totalEpigallo);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}