package com.leeroy.totalNutrition;

import android.os.AsyncTask;

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

    String data = "";

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
    }
}
