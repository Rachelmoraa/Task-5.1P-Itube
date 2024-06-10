package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private EditText urlEditText;
    private Button playButton;
    private Button addToFavoritesButton;
    private Button showFavoritesButton;
    private LinearLayout favoritesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        urlEditText = findViewById(R.id.urlEditText);
        playButton = findViewById(R.id.playButton);
        addToFavoritesButton = findViewById(R.id.addToFavoritesButton);
        showFavoritesButton = findViewById(R.id.showFavoritesButton);
        favoritesLayout = findViewById(R.id.favoritesLayout);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoUrl = urlEditText.getText().toString();
                Intent intent = new Intent(HomeActivity.this, YouTubePlayerActivity.class);
                intent.putExtra("VIDEO_URL", videoUrl);
                startActivity(intent);
            }
        });

        addToFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoUrl = urlEditText.getText().toString();
                if (!videoUrl.isEmpty()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("Favorites", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Set<String> favorites = sharedPreferences.getStringSet("favorites", new HashSet<String>());
                    favorites.add(videoUrl);
                    editor.putStringSet("favorites", favorites);
                    editor.apply();
                    Toast.makeText(HomeActivity.this, "Added to favorites", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFavorites();
            }
        });

        displayFavorites();
    }

    private void displayFavorites() {
        favoritesLayout.removeAllViews();
        SharedPreferences sharedPreferences = getSharedPreferences("Favorites", Context.MODE_PRIVATE);
        Set<String> favorites = sharedPreferences.getStringSet("favorites", new HashSet<String>());
        for (String favorite : favorites) {
            TextView textView = new TextView(this);
            textView.setText(favorite);
            favoritesLayout.addView(textView);
        }
    }
}