package com.example.videogames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VideoGamesFragment extends Fragment {

    private VideoGamesViewModel viewModel;
    private VideoGamesAdapter adapter;
    private VideoGames games;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_games, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(VideoGamesViewModel.class);

        adapter = new VideoGamesAdapter(viewModel.obtenerJuegos().getValue());
        recyclerView.setAdapter(adapter);

        // Observa los cambios en la lista de videojuegos y actualiza el adaptador
        viewModel.obtenerJuegos().observe(getViewLifecycleOwner(), new Observer<List<VideoGames>>() {
            @Override
            public void onChanged(List<VideoGames> games) {
                adapter.actualizarLista(games);
            }
        });

        view.findViewById(R.id.fab_add_game).setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_videoGamesFragment_to_addGameFragment);
        });

        return view;
    }
}

