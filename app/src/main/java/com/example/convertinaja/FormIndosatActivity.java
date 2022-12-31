package com.example.convertinaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormIndosatActivity extends AppCompatActivity {

    EditText noPengirim, jumlah, noTujuan, eWallet;
    ConvertInterface convertInterface;
    Button post;
    SharedPreferences sharedPref;
    TextView rateTelkom, check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_indosat);

        noPengirim = findViewById(R.id.noPengirim2);
        jumlah = findViewById(R.id.jumlah2);
        noTujuan = findViewById(R.id.noTujuan2);
        eWallet = findViewById(R.id.eWallet2);

        post = findViewById(R.id.post2);

        rateTelkom = findViewById(R.id.rateTelkom2);
        check = findViewById(R.id.checkRateTelkomsel2);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        convertInterface = APIclient.getClient().create(ConvertInterface.class);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDataIndosat();
            }
        });

        rateTelkom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungIndosat();
            }
        });

    }

    public void postDataIndosat(){
        String noKirim = noPengirim.getText().toString();
        String jml = jumlah.getText().toString();
        String noTuju = noTujuan.getText().toString();
        String eWall = eWallet.getText().toString();
        String nama = sharedPref.getString(MainActivity.KEY_USER, "");
        Call<Convert> postConvert = convertInterface.postConvert(nama, noKirim, jml, noTuju, eWall);

        postConvert.enqueue(new Callback<Convert>() {
            @Override
            public void onResponse(Call<Convert> call, Response<Convert> response) {
                Log.d("post_convert: ", response.toString());
                startActivity(new Intent(getApplicationContext(), BuktiActivity.class));
                finish();
            }

            @Override
            public void onFailure(Call<Convert> call, Throwable t) {
                Log.e("error_convert: ", t.getMessage());
                Toast.makeText(getApplicationContext(),"Error access to "+call.request().url()+" "+t.getMessage(), Toast.LENGTH_LONG);
            }
        });

    }

    public void hitungIndosat(){
        float jum = Float.parseFloat(String.valueOf(jumlah.getText()));
        double hasil = 0.90 * jum;

        check.setText("0.90 x "+ jum+ " = "+ hasil);
    }
}