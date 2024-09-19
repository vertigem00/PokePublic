package com.example.appPokemon;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appPokemon.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Pokemon> pokemonList;
    private PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pokemonList = new ArrayList<>();
        adapter = new PokemonAdapter(pokemonList, this::showPokemonDetails);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        binding.fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPokemon.class);
            startActivityForResult(intent, 1);
        });
    }

    private void showPokemonDetails(Pokemon pokemon) {
        Intent intent = new Intent(MainActivity.this, DetalhesPoke.class);
        intent.putExtra("pokemon", pokemon);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Pokemon newPokemon = (Pokemon) data.getSerializableExtra("pokemon");
            if (newPokemon != null) {
                pokemonList.add(newPokemon);
                adapter.notifyItemInserted(pokemonList.size() - 1);
            }
        }
    }
}
