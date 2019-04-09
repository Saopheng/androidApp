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

public class RiceDetail extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rice_detail);

        TextView name = findViewById(R.id.name);
        TextView feature = findViewById(R.id.feature);
        TextView area = findViewById(R.id.area);
        TextView nature = findViewById(R.id.nature);
        mQueue = Volley.newRequestQueue(this);

        getJson(name, feature, area, nature, savedInstanceState);

    }

    public void getJson(final TextView name, final TextView feature, final TextView area, final TextView nature, Bundle savedInstanceState) {
        String newString;
        String url = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("name");
                url = "http://192.168.56.1/kai/data/RiceDetail.php?id="+newString;
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("name");
            url = "http://192.168.56.1/kai/data/RiceDetail.php?id="+newString;
        }


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject rice = response.getJSONObject(i);
                                String rice_name = rice.getString("rice_ta_name");
                                String rice_feature = rice.getString("feature");
                                String rice_area = rice.getString("area");
                                String rice_nature = rice.getString("nature");

                                name.setText(rice_name);
                                feature.setText(rice_feature);
                                area.setText(rice_area);
                                nature.setText(rice_nature);
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
