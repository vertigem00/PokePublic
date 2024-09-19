package com.example.appPokemon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private ArrayList<Pokemon> pokemonList;
    private OnPokemonClickListener listener;

    public interface OnPokemonClickListener {
        void onPokemonClick(Pokemon pokemon);
    }

    public PokemonAdapter(ArrayList<Pokemon> pokemonList, OnPokemonClickListener listener) {
        this.pokemonList = pokemonList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);

        holder.nameTextView.setText(pokemon.getName());
        holder.levelTextView.setText("Level: " + pokemon.getLevel());
        holder.typeTextView.setText("Type: " + pokemon.getType1());

        Glide.with(holder.itemView.getContext())
                .load(pokemon.getImageUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.error))
                .into(holder.pokemonImageView);

        holder.itemView.setOnClickListener(v -> listener.onPokemonClick(pokemon));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView levelTextView;
        TextView typeTextView;
        ImageView pokemonImageView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.pokemon_name);
            levelTextView = itemView.findViewById(R.id.pokemon_level);
            typeTextView = itemView.findViewById(R.id.pokemon_type);
            pokemonImageView = itemView.findViewById(R.id.pokemon_image);
        }
    }
}
