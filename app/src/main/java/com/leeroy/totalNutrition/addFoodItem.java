package com.leeroy.totalNutrition;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class addFoodItem extends AppCompatActivity {
    final ProgressDialog loading = ProgressDialog.show(this,"Adding Item","Please wait");
    final String name = editTextItemName.getText().toString().trim();


    final StringRequest stringRequest = new StringRequest(Request.Method.POST, "Add Your Web App URL",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    loading.dismiss();
                    Toast.makeText(addFoodItem.this, response, Toast.LENGTH_LONG).show();


                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
    ) {
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> parmas = new HashMap<>();

            //here we pass params
            parmas.put("action", "addItem");
            parmas.put("itemName", name);


            return parmas;
        }
    };

    int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

    RetryPolicy retryPolicy = new DefaultRetryPolicy (socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy()

    RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


}




    @Override
    public void onClick(View v) {

        if(v==buttonAddItem){
            addItemToSheet();

            //Define what to do when button is clicked
        }
    }
}
}
