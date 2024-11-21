package com.example.videogames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.time.LocalDate;

public class AddGameFragment extends Fragment {

    private VideoGamesViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_game, container, false);

        EditText etName = view.findViewById(R.id.et_name);
        EditText etGenre = view.findViewById(R.id.et_genre);
        EditText etDate = view.findViewById(R.id.et_date);
        RatingBar rbRating = view.findViewById(R.id.rb_rating);
        Button btnAdd = view.findViewById(R.id.btn_add);

        viewModel = new ViewModelProvider(requireActivity()).get(VideoGamesViewModel.class);

        btnAdd.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String genre = etGenre.getText().toString().trim();
            String dateText = etDate.getText().toString().trim();
            float rating = rbRating.getRating();

            if (name.isEmpty() || genre.isEmpty() || dateText.isEmpty()) {
                Toast.makeText(getContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            LocalDate date;
            try {
                date = LocalDate.parse(dateText);
            } catch (Exception e) {
                Toast.makeText(getContext(), "Formato de fecha inválido. Usa yyyy-MM-dd", Toast.LENGTH_SHORT).show();
                return;
            }

            VideoGames newGame = new VideoGames(name, genre, date, rating);
            viewModel.insertar(newGame);
            Toast.makeText(getContext(), "Juego añadido con éxito", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(v).popBackStack();
        });


        return view;
    }
}
