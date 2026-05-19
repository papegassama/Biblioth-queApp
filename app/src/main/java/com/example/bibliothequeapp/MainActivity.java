package com.example.bibliothequeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associe le layout XML à l'activité
        setContentView(R.layout.activity_main);

        // Récupération du bouton
        Button btnVoirLivres = findViewById(R.id.btnVoirLivres);

        // Action lors du clic
        btnVoirLivres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "Accès à la liste des livres",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}