package com.example.bibliothequeapp;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LivreAdapter extends RecyclerView.Adapter<LivreAdapter.LivreViewHolder> {

    private List<Livre> listeLivres;
    private MainActivity mainActivity;
    private OnItemLongClickListener longClickListener;

    public interface OnItemLongClickListener {
        void onItemLongClick(Livre livre, int position);
    }

    public LivreAdapter(List<Livre> listeLivres, MainActivity mainActivity) {
        this.listeLivres = listeLivres;
        this.mainActivity = mainActivity;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.longClickListener = listener;
    }

    @NonNull
    @Override
    public LivreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_livre, parent, false);
        return new LivreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LivreViewHolder holder, int position) {
        Livre livre = listeLivres.get(position);

        holder.tvTitreLivre.setText(livre.getTitre());
        holder.tvAuteurLivre.setText("Auteur : " + livre.getAuteur());
        holder.tvIsbnLivre.setText("ISBN : " + livre.getIsbn());

        if (livre.isDisponible()) {
            holder.tvDisponibilite.setText("Disponible");
            holder.tvDisponibilite.setBackgroundColor(Color.parseColor("#2E7D32"));
        } else {
            holder.tvDisponibilite.setText("Indisponible");
            holder.tvDisponibilite.setBackgroundColor(Color.parseColor("#C62828"));
        }

        // Clic simple : ouvrir DetailActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(mainActivity, DetailActivity.class);
            intent.putExtra("livre", livre);
            mainActivity.startActivity(intent);
        });

        // Clic long : modifier/supprimer
        holder.itemView.setOnLongClickListener(v -> {
            if (longClickListener != null) {
                longClickListener.onItemLongClick(livre, position);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return listeLivres.size();
    }

    public static class LivreViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitreLivre, tvAuteurLivre, tvIsbnLivre, tvDisponibilite;

        public LivreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitreLivre = itemView.findViewById(R.id.tvTitreLivre);
            tvAuteurLivre = itemView.findViewById(R.id.tvAuteurLivre);
            tvIsbnLivre = itemView.findViewById(R.id.tvIsbnLivre);
            tvDisponibilite = itemView.findViewById(R.id.tvDisponibilite);
        }
    }
}