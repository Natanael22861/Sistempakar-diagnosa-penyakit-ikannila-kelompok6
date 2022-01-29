package com.example.pakarnila;

import static com.android.volley.VolleyLog.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.example.pakarnila.API.Server;
import com.example.pakarnila.App.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PakarMysql extends AppCompatActivity {

    TextView gejala;
    ImageButton iya,tidak;

    String Y,T,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakar_mysql);

        gejala = findViewById(R.id.pGejala);

        iya = findViewById(R.id.pJawabY);
        tidak = findViewById(R.id.pJawabT);

        Intent data = getIntent();
        id = data.getStringExtra("id");

        ViewData(id);

        iya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                char hasily = Y.charAt(0);

                String y = ""+hasily;

                if (y.equals("P")){
                    Intent intent = new Intent(PakarMysql.this, SolusiMysql.class);
                    intent.putExtra("id",Y);
                    startActivity(intent);
                    finish();
                }
                else if(y.equals("G")){
                    Intent intent = new Intent(PakarMysql.this, PakarMysql.class);
                    intent.putExtra("id",Y);
                    startActivity(intent);
                    finish();
                }

            }
        });

        tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                char hasilt = T.charAt(0);

                String t = ""+hasilt;

                if (t.equals("P")){
                    Intent intent = new Intent(PakarMysql.this, SolusiMysql.class);
                    intent.putExtra("id",T);
                    startActivity(intent);
                    finish();
                }
                else if(t.equals("G")){
                    Intent intent = new Intent(PakarMysql.this, PakarMysql.class);
                    intent.putExtra("id",T);
                    startActivity(intent);
                    finish();
                }
                else if(t.equals("0")){
                    Toast.makeText(PakarMysql.this, "Tidak SAkit kakak", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PakarMysql.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    private void ViewData(String id) {

        StringRequest eventoReq = new StringRequest(Request.Method.POST, Server.AmbilData,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        try{
                            JSONArray j= new JSONArray(response);

                            // Parsea json
                            for (int i = 0; i < j.length(); i++) {
                                try {
                                    JSONObject obj = j.getJSONObject(i);

                                    gejala.setText(obj.getString("nama_gejala"));

                                    Y = obj.getString("jawaban_iya");
                                    T = obj.getString("jawaban_tidak");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id);
                return params;
            }
        };

        // Añade la peticion a la cola
        AppController.getInstance().addToRequestQueue(eventoReq);
    }
}