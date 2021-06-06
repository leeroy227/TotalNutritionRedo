package com.leeroy.myapplication;

import android.os.AsyncTask;

import com.leeroy.myapplication.ui.foodItems.FoodItemsFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchData extends AsyncTask<Void,Void,Void> {
    public static List<FoodItem> foodItemList= new ArrayList<>();
    String singleParsed = "";
    String data = "";
    String dataParsed="";



    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://script.google.com/macros/s/AKfycbyvxIsY3Krb4MDhw0Po3LXT3Wm2K-xooz8ih8SrX5Zh8Qxznfo/exec");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;

            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();


            JSONObject Jo = new JSONObject(data);
            JSONArray JA = Jo.getJSONArray("data");
            for(int i = 0; i<JA.length();i++){
                FoodItem item = new FoodItem("","",0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0);
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name: " +JO.get("name")+ "\n"+
                        "Serving size: "+JO.get("Serving size")+ "\n"+
                        "Calories: "+JO.get("Calories")+ "\n"+
                        "Total Fat (g): "+JO.get("Total Fat (g)")+ "\n"+
                        "Saturated fat (g) <20: "+JO.get("Saturated fat (g) <20")+ "\n"+
                        "Trans fat (g): "+JO.get("Trans fat (g)")+ "\n"+
                        "Polyunsaturated fat (g): "+JO.get("Polyunsaturated fat (g)")+ "\n"+
                        "Monounsaturated fat (g): "+JO.get("Monounsaturated fat (g)")+ "\n"+
                        "Cholesterol (mg): "+JO.get("Cholesterol (mg)")+ "\n"+
                        "Sodium (mg) <2300: "+JO.get("Sodium (mg) <2300")+ "\n"+
                        "Total Carbohydrate (g): "+JO.get("Total Carbohydrate (g)")+ "\n"+
                        "Dietary Fiber (g): "+JO.get("Dietary Fiber (g)")+ "\n"+
                        "Total Sugars (g): "+JO.get("Total Sugars (g)")+ "\n"+
                        "Incl. Added Sugars (g): "+JO.get("Incl. Added Sugars (g)")+ "\n"+
                        "Protein (g): "+JO.get("Protein (g)")+ "\n"+
                        "Vitamin D (µg) 20: "+JO.get("Vitamin D (µg) 20")+ "\n"+
                        "Calcium (mg) 1300: "+JO.get("Calcium (mg) 1300")+ "\n"+
                        "Iron (mg) 18: "+JO.get("Iron (mg) 18")+ "\n"+
                        "Potassium (mg) 4700: "+JO.get("Potassium (mg) 4700")+ "\n"+
                        "Vitamin A (µg) 900: "+JO.get("Vitamin A (µg) 900")+ "\n"+
                        "Vitamin C (mg) 90: "+JO.get("Vitamin C (mg) 90")+ "\n"+
                        "Vitamin E (mg) 15: "+JO.get("Vitamin E (mg) 15")+ "\n"+
                        "Vitamin K (µg) 120: "+JO.get("Vitamin K (µg) 120")+ "\n"+
                        "Thiamin (mg) 1.2: "+JO.get("Thiamin (mg) 1.2")+ "\n"+
                        "Riboflavin (mg) 1.3: "+JO.get("Riboflavin (mg) 1.3")+ "\n"+
                        "Niacin (mg) 16: "+JO.get("Niacin (mg) 16")+ "\n"+
                        "Vitamin B6 (mg) 1.7: "+JO.get("Vitamin B6 (mg) 1.7")+ "\n"+
                        "Folate (DFE) (µg) 400: "+JO.get("Folate (DFE) (µg) 400")+ "\n"+
                        "Vitamin B12 (µg) 2.4: "+JO.get("Vitamin B12 (µg) 2.4")+ "\n"+
                        "Biotin (µg) 30: "+JO.get("Biotin (µg) 30")+ "\n"+
                        "Pantothenic acid (mg) 5: "+JO.get("Pantothenic acid (mg) 5")+ "\n"+
                        "Phosphorus (mg) 1250: "+JO.get("Phosphorus (mg) 1250")+ "\n"+
                        "Iodine (mg) 150: "+JO.get("Iodine (mg) 150")+ "\n"+
                        "Magnesium (mg) 420: "+JO.get("Magnesium (mg) 420")+ "\n"+
                        "Zinc (mg) 11: "+JO.get("Zinc (mg) 11")+ "\n"+
                        "Selenium (mg) 55: "+JO.get("Selenium (mg) 55")+ "\n"+
                        "Copper (mg) .9: "+JO.get("Copper (mg) .9")+ "\n"+
                        "Manganese (mg) 2.3: "+JO.get("Manganese (mg) 2.3")+ "\n"+
                        "Chromium (µg) 35: "+JO.get("Chromium (µg) 35")+ "\n"+
                        "Molybdenum (µg) 45: "+JO.get("Molybdenum (µg) 45")+ "\n"+
                        "Chloride (mg) 2300: "+JO.get("Chloride (mg) 2300")+ "\n"+
                        "Choline (mg) 550: "+JO.get("Choline (mg) 550")+ "\n"+
                        "Vitamin D3 (mg): "+JO.get("Vitamin D3 (mg)")+ "\n"+
                        "Vitamin K2 (mg): "+JO.get("Vitamin K2 (mg)")+ "\n"+
                        "Lycopene (mg): "+JO.get("Lycopene (mg)")+ "\n"+
                        "Lutein (mg): "+JO.get("Lutein (mg)")+ "\n"+
                        "Zeaxanthin (mg): "+JO.get("Zeaxanthin (mg)")+ "\n"+
                        "Omega-3 (g): "+JO.get("Omega-3 (g)")+ "\n"+
                        "Omega-6 (g): "+JO.get("Omega-6 (g)")+ "\n"+
                        "MCTs (g): "+JO.get("MCTs (g)")+ "\n"+
                        "Bacillus Coagulans (mn): "+JO.get("Bacillus Coagulans (mn)")+ "\n"+
                        "Epigallocatechin Gallate: "+JO.get("Epigallocatechin Gallate")+ "\n";


                item.setName((String) JO.get("name"));
                item.setServingSize((String) JO.get("Serving size"));
                item.setCalories(JO.getDouble("Calories"));
                item.setFat((JO.getDouble("Total Fat (g)")));
                item.setSaturatedFat(JO.getDouble("Saturated fat (g) <20"));
                item.setTransFat(JO.getDouble("Trans fat (g)"));
                item.setPolyunsaturatedFat(JO.getDouble("Polyunsaturated fat (g)"));
                item.setMonounsaturatedFat(JO.getDouble("Monounsaturated fat (g)"));
                item.setCholesterol(JO.getDouble("Cholesterol (mg)"));
                item.setSodium(JO.getDouble("Sodium (mg) <2300"));
                item.setCarbs(JO.getDouble("Total Carbohydrate (g)"));
                item.setFiber(JO.getDouble("Dietary Fiber (g)"));
                item.setSugars(JO.getDouble("Total Sugars (g)"));
                item.setAddedSugars(JO.getDouble("Incl. Added Sugars (g)"));
                item.setProtein(JO.getDouble("Protein (g)"));
                item.setVitaminD(JO.getDouble("Vitamin D (µg) 20"));
                item.setCalcium(JO.getDouble("Calcium (mg) 1300"));
                item.setIron(JO.getDouble("Iron (mg) 18"));
                item.setPotassium(JO.getDouble("Potassium (mg) 4700"));
                item.setVitaminA(JO.getDouble("Vitamin A (µg) 900"));
                item.setVitaminC(JO.getDouble("Vitamin C (mg) 90"));
                item.setVitaminE(JO.getDouble("Vitamin E (mg) 15"));
                item.setVitaminK(JO.getDouble("Vitamin K (µg) 120"));
                item.setThiamin(JO.getDouble("Thiamin (mg) 1.2"));
                item.setRiboflavin(JO.getDouble("Riboflavin (mg) 1.3"));
                item.setNiacin(JO.getDouble("Niacin (mg) 16"));
                item.setVitaminB6(JO.getDouble("Vitamin B6 (mg) 1.7"));
                item.setFolate(JO.getDouble("Folate (DFE) (µg) 400"));
                item.setVitaminB12(JO.getDouble("Vitamin B12 (µg) 2.4"));
                item.setBiotin(JO.getDouble("Biotin (µg) 30"));
                item.setPantothenicAcid(JO.getDouble("Pantothenic acid (mg) 5"));
                item.setPhosphorus(JO.getDouble("Phosphorus (mg) 1250"));
                item.setIodine(JO.getDouble("Iodine (mg) 150"));
                item.setMagnesium(JO.getDouble("Magnesium (mg) 420"));
                item.setZinc(JO.getDouble("Zinc (mg) 11"));
                item.setSelenium(JO.getDouble("Selenium (mg) 55"));
                item.setCopper(JO.getDouble("Copper (mg) .9"));
                item.setManganese(JO.getDouble("Manganese (mg) 2.3"));
                item.setChromium(JO.getDouble("Chromium (µg) 35"));
                item.setMolybdenum(JO.getDouble("Molybdenum (µg) 45"));
                item.setChloride(JO.getDouble("Chloride (mg) 2300"));
                item.setCholine(JO.getDouble("Choline (mg) 550"));
                item.setVitaminD3(JO.getDouble("Vitamin D3 (mg)"));
                item.setVitaminK(JO.getDouble("Vitamin K2 (mg)"));
                item.setLycopene(JO.getDouble("Lycopene (mg)"));
                item.setLutein(JO.getDouble("Lutein (mg)"));
                item.setZeaxanthin(JO.getDouble("Zeaxanthin (mg)"));
                item.setOmega3(JO.getDouble("Omega-3 (g)"));
                item.setOmega6(JO.getDouble("Omega-6 (g)"));
                item.setMcts(JO.getDouble("MCTs (g)"));
                item.setBacillusCoagulans(JO.getDouble("Bacillus Coagulans (mn)"));
                item.setEpigallocatechinGallate(JO.getDouble("Epigallocatechin Gallate"));

                foodItemList.add(item);
                dataParsed=dataParsed+singleParsed+"\n";
            }
            System.out.println(JA.length());
            System.out.println(foodItemList.size());
            for(int i = 0; i<foodItemList.size();i++){
                System.out.println(foodItemList.get(i).getCarbs());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        FoodItemsFragment.text=dataParsed;



    }
}
