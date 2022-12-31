package com.example.convertinaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BuktiActivity extends AppCompatActivity {

    Button kirim, selesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukti);

        kirim = findViewById(R.id.buktiPembayaran);
        selesai = findViewById(R.id.selesai);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentWhatsapp();
            }
        });

        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selesai();
            }
        });
    }

    private void selesai(){
        startActivity(new Intent(this, HomeActivity.class));
    }

    public void intentWhatsapp(){
        try {
            String trimToNumner = "+6282136496996";
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner ) );
            startActivity ( intent );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}