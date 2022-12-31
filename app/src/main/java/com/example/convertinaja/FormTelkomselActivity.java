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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class
FormTelkomselActivity extends AppCompatActivity {

    EditText noPengirim, jumlah, noTujuan, eWallet;
    ConvertInterface convertInterface;
    Button post;
    SharedPreferences sharedPref;
    TextView rateTelkom, check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_telkomsel);

        noPengirim = findViewById(R.id.noPengirim);
        jumlah = findViewById(R.id.jumlah);
        noTujuan = findViewById(R.id.noTujuan);
        eWallet = findViewById(R.id.eWallet);

        post = findViewById(R.id.post);

        rateTelkom = findViewById(R.id.rateTelkom);
        check = findViewById(R.id.checkRateTelkomsel);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        convertInterface = APIclient.getClient().create(ConvertInterface.class);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });

        rateTelkom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung();
            }
        });
    }

    public void postData(){
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

    public void hitung(){
        float jum = Float.parseFloat(String.valueOf(jumlah.getText()));
        double hasil = 0.80 * jum;

        check.setText("0.80 x "+ jum+ " = "+ hasil);
    }

}