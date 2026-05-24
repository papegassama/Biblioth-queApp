package com.example.bibliothequeapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView tvTitreDetail, tvAuteurDetail, tvIsbnDetail, tvDisponibiliteDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvTitreDetail = findViewById(R.id.tvTitreDetail);
        tvAuteurDetail = findViewById(R.id.tvAuteurDetail);
        tvIsbnDetail = findViewById(R.id.tvIsbnDetail);
        tvDisponibiliteDetail = findViewById(R.id.tvDisponibiliteDetail);

        Livre livre = (Livre) getIntent().getSerializableExtra("livre");

        if (livre != null) {
            tvTitreDetail.setText(livre.getTitre());
            tvAuteurDetail.setText("Auteur : " + livre.getAuteur());
            tvIsbnDetail.setText("ISBN : " + livre.getIsbn());

            if (livre.isDisponible()) {
                tvDisponibiliteDetail.setText("Disponible");
                tvDisponibiliteDetail.setBackgroundColor(getColor(android.R.color.holo_green_dark));
            } else {
                tvDisponibiliteDetail.setText("Indisponible");
                tvDisponibiliteDetail.setBackgroundColor(getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}