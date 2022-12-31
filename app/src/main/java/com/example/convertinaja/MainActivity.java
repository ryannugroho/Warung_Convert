package com.example.convertinaja;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

   Button login;
   EditText edtNama;
   SharedPreferences sharedPref;
   static String KEY_USER = "nama_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btnLogin);
        edtNama = findViewById(R.id.edtNama);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String namaUser = sharedPref.getString(MainActivity.KEY_USER, null);
        if (namaUser != null){
            startActivity(new Intent(this, HomeActivity.class));
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masuk();
            }
        });
    }

    /*void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Gagal memasuki Aplikasi"+e, Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    public void masuk(){
        String namaUser = edtNama.getText().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY_USER, namaUser);
        editor.commit();

        startActivity(new Intent(this, HomeActivity.class));
    }

}