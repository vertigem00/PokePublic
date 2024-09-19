package com.example.appPokemon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddPokemon extends AppCompatActivity {

    private EditText nameEditText, imageUrlEditText, levelEditText;
    private CheckBox type1CheckBox, type2CheckBox, type3CheckBox, type4CheckBox, type5CheckBox, type6CheckBox, type7CheckBox, type8CheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pokemon);

        nameEditText = findViewById(R.id.nameEditText);
        imageUrlEditText = findViewById(R.id.imageUrlEditText);
        levelEditText = findViewById(R.id.levelEditText);


        type1CheckBox = findViewById(R.id.type1CheckBox);
        type2CheckBox = findViewById(R.id.type2CheckBox);
        type3CheckBox = findViewById(R.id.type3CheckBox);
        type4CheckBox = findViewById(R.id.type4CheckBox);
        type5CheckBox = findViewById(R.id.type5CheckBox);
        type6CheckBox = findViewById(R.id.type6CheckBox);
        type7CheckBox = findViewById(R.id.type7CheckBox);
        type8CheckBox = findViewById(R.id.type8CheckBox);

        Button captureButton = findViewById(R.id.captureButton);
        captureButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String imageUrl = imageUrlEditText.getText().toString().trim();
            String levelStr = levelEditText.getText().toString().trim();

            if (name.isEmpty() || imageUrl.isEmpty() || levelStr.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            int level;
            try {
                level = Integer.parseInt(levelStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "O nível deve ser um número válido", Toast.LENGTH_SHORT).show();
                return;
            }

            ArrayList<String> types = new ArrayList<>();
            if (type1CheckBox.isChecked()) types.add("Fogo");
            if (type2CheckBox.isChecked()) types.add("Água");
            if (type3CheckBox.isChecked()) types.add("Elétrico");
            if (type4CheckBox.isChecked()) types.add("Grama");
            if (type5CheckBox.isChecked()) types.add("Lutador");
            if (type6CheckBox.isChecked()) types.add("Veneno");
            if (type7CheckBox.isChecked()) types.add("Terra");
            if (type8CheckBox.isChecked()) types.add("Psíquico");

            if (types.size() > 2) {
                Toast.makeText(this, "Escolha no máximo 2 tipos", Toast.LENGTH_SHORT).show();
                return;
            }

            String type1 = types.size() > 0 ? types.get(0) : "";
            String type2 = types.size() > 1 ? types.get(1) : "";

            Pokemon newPokemon = new Pokemon(name, imageUrl, level, type1, type2);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("pokemon", newPokemon);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
