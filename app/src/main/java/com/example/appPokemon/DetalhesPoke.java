package com.example.appPokemon;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetalhesPoke extends AppCompatActivity {

    private TextView nameTextView, levelTextView, type1TextView, type2TextView;
    private ImageView pokemonImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_poke);

        nameTextView = findViewById(R.id.nameTextView);
        levelTextView = findViewById(R.id.levelTextView);
        type1TextView = findViewById(R.id.type1TextView);
        type2TextView = findViewById(R.id.type2TextView);
        pokemonImageView = findViewById(R.id.pokemonImageView);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        if (pokemon != null) {
            nameTextView.setText(pokemon.getName());
            levelTextView.setText("Level: " + pokemon.getLevel());
            type1TextView.setText("Tipo 1: " + pokemon.getType1());
            type2TextView.setText("Tipo 2: " + pokemon.getType2());

            Glide.with(this)
                    .load(pokemon.getImageUrl())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.error))
                    .into(pokemonImageView);
        }
    }
}
