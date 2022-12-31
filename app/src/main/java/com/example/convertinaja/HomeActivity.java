package com.example.convertinaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    //GoogleSignInOptions gso;
    //GoogleSignInClient gsc;

    //TextView nama;

    BottomNavigationView bottNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();

        bottNav = findViewById(R.id.bottNav);

        bottNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.history:
                        selectedFragment = new HistoryFragment();
                        break;
                    case R.id.profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
                return true;
            }
        });

        //nama = findViewById(R.id.nama);

        /*gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acc = GoogleSignIn.getLastSignedInAccount(this);
        if (acc!=null){
            String namaAcc= acc.getDisplayName();
            //String emailAcc = acc.getEmail();
            nama.setText(namaAcc);
            //email.setText(emailAcc);
        }*/
    }
}