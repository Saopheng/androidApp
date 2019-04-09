package com.example.administrator.power;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DiseaseDetail extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_detail);

        TextView name = findViewById(R.id.disease_name);
        TextView symptom = findViewById(R.id.symptom);
        TextView protect = findViewById(R.id.protect);
        TextView warning = findViewById(R.id.warning);
        mQueue = Volley.newRequestQueue(this);

        getJson(name, symptom, protect, warning, savedInstanceState);

    }

    public void getJson(final TextView name, final TextView symptom, final TextView protect, final TextView warning, Bundle savedInstanceState) {
        String newString;
        String url = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("name");
                url = "http://--------/kai/data/DiseaseDetail.php?id="+newString;
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("name");
            url = "http://--------/kai/data/DiseaseDetail.php?id="+newString;
        }


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject rice = response.getJSONObject(i);
                                String di_name = rice.getString("disease_name");
                                String di_symptom = rice.getString("symptom");
                                String di_protect = rice.getString("protect");
                                String di_warning = rice.getString("warning");

                                name.setText(di_name);
                                symptom.setText(di_symptom);
                                protect.setText(di_protect);
                                warning.setText(di_warning);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

}
