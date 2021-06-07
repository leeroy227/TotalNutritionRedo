package com.leeroy.totalNutrition.ui.nutritionFacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leeroy.totalNutrition.databinding.FragmentNutritionBinding;

public class NutritionFactsFragment extends Fragment {


    private FragmentNutritionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNutritionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        double totalCalories = 0,totalFat=0,totalSatFat = 0,totalTransFat = 0,totalPolyFat = 0,totalMonoFat = 0,totalCholesterol = 0,totalSodium = 0,
        totalCarbs=0,totalFiber=0,totalSugars=0,totalAddedSugars=0,totalProtein=0,totalVitD=0,totalCalcium=0,totalIron=0,totalPotassium=0,
        totalVitA=0,totalVitC=0,totalVitE=0,totalVitK=0,totalThiamin=0,totalRiboflavin=0,totalNiacin=0,totalVitB6=0,totalFolate=0,totalVitB12=0,
        totalBiotin=0,totalPantothenicAcid=0,totalPhosphorus=0,totalIodine=0,totalMagnesium=0,totalZinc=0,totalSelenium=0,totalCopper=0,totalManganese=0,
        totalChromium=0,totalMolybdenum=0,totalChloride=0,totalCholine=0,totalVitD3=0,totalVitK2=0,totalLycopene=0,totalLutein=0,totalZeaxantin=0,
        totalOmega3=0,totalOmega6=0,totalMCTs=0,totalBacillus=0,totalEpigallo=0;
        binding.nutritionFactsCalories.setText("Calories: "+totalCalories);
        binding.nutritionFactsFat.setText("Total Fat: "+totalFat+"g");
        binding.nutritionFactsSaturatedFat.setText("Total Saturated Fat: "+totalSatFat+"g");
        binding.nutritionFactsTransFat.setText("Total Trans Fat: "+totalTransFat+"g");
        binding.nutritionFactsPolyFat.setText("Total Poly Fat: "+totalPolyFat+"g");
        binding.nutritionFactsMonoFat.setText("Total Mono Fat: "+totalMonoFat+"g");
        binding.nutritionFactsCholesterol.setText("Total Cholesterol: "+totalCholesterol+"mg");
        binding.nutritionFactsSodium.setText("Total Sodium: "+totalSodium+"mg");
        binding.nutritionFactsCarbs.setText("Total Carbs: "+totalCarbs+"g");
        binding.nutritionFactsFiber.setText("Total Fiber: "+totalFiber+"g");
        binding.nutritionFactsSugars.setText("Total Sugars: "+totalSugars+"g");
        binding.nutritionFactsAddedSugars.setText("Total Added Sugars: "+totalAddedSugars+"g");
        binding.nutritionFactsProtein.setText("Total Protein: "+totalProtein+"g");
        binding.nutritionFactsVitD.setText("Total Vitamin D: "+totalVitD+"µg");
        binding.nutritionFactsCalcium.setText("Total Calcium: "+totalCalcium+"mg");
        binding.nutritionFactsIron.setText("Total Iron: "+totalIron+"mg");
        binding.nutritionFactsPotassium.setText("Total Potassium: "+totalPotassium+"mg");
        binding.nutritionFactsVitA.setText("Total Vitamin A: "+totalVitA+"µg");
        binding.nutritionFactsVitC.setText("Total Vitamin C: "+totalVitC+"mg");
        binding.nutritionFactsVitE.setText("Total Vitamin E: "+totalVitE+"mg");
        binding.nutritionFactsVitK.setText("Total Vitamin K: "+totalVitK+"µg");
        binding.nutritionFactsThiamin.setText("Total Thiamin: "+totalThiamin+"mg");
        binding.nutritionFactsRiboflavin.setText("Total Riboflavin: "+totalRiboflavin+"mg");
        binding.nutritionFactsNiacin.setText("Total Niacin: "+totalNiacin+"mg");
        binding.nutritionFactsVitB6.setText("Total Vitamin B6: "+totalVitB6+"mg");
        binding.nutritionFactsFolate.setText("Total Folate: "+totalFolate+"µg");
        binding.nutritionFactsVitB12.setText("Total Vitamin B12: "+totalVitB12+"µg");
        binding.nutritionFactsBiotin.setText("Total Biotin: "+totalBiotin+"µg");
        binding.nutritionFactsPantothenicAcid.setText("Total Pantothenic Acid: "+totalPantothenicAcid+"mg");
        binding.nutritionFactsPhosphorus.setText("Total Phosphorus: "+totalPhosphorus+"mg");
        binding.nutritionFactsIodine.setText("Total Iodine: "+totalIodine+"mg");
        binding.nutritionFactsMagnesium.setText("Total Magnesium: "+totalMagnesium+"mg");
        binding.nutritionFactsZinc.setText("Total Zinc: "+totalZinc+"mg");
        binding.nutritionFactsSelenium.setText("Total Selenium: "+totalSelenium+"mg");
        binding.nutritionFactsCopper.setText("Total Copper: "+totalCopper+"mg");
        binding.nutritionFactsManganese.setText("Total Manganese: "+totalManganese+"mg");
        binding.nutritionFactsChromium.setText("Total Chromium: "+totalChromium+"µg");
        binding.nutritionFactsMolybdenum.setText("Total Molybdenum: "+totalMolybdenum+"µg");
        binding.nutritionFactsChloride.setText("Total Chloride: "+totalChloride+"mg");
        binding.nutritionFactsCholine.setText("Total Choline: "+totalCholine+"mg");
        binding.nutritionFactsVitD3.setText("Total Vitamin D3: "+totalVitD3+"mg");
        binding.nutritionFactsVitK2.setText("Total Vitamin K2: "+totalVitK2+"mg");
        binding.nutritionFactsLycopene.setText("Total Lycopene: "+totalLycopene+"mg");
        binding.nutritionFactsLutein.setText("Total Lutein: "+totalLutein+"mg");
        binding.nutritionFactsZeaxanthin.setText("Total Zeaxanthin: "+totalZeaxantin+"mg");
        binding.nutritionFactsOmega3.setText("Total Omega-3: "+totalOmega3+"mg");
        binding.nutritionFactsOmega6.setText("Total Omega-6: "+totalOmega6+"mg");
        binding.nutritionFactsMcts.setText("Total MCTs: "+totalMCTs+"g");
        binding.nutritionFactsBacillus.setText("Total Bacillus Coagulans: "+totalBacillus+"mn");
        binding.nutritionFactsEpigalloc.setText("Total Epigallocatechin Gallate: "+totalEpigallo);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}