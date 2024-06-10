package com.example.itube;

package com.example.itube;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class YouTubePlayerActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        youTubePlayerView = findViewById(R.id.youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

        String videoUrl = getIntent().getStringExtra("VIDEO_URL");
        String videoId = extractVideoIdFromUrl(videoUrl);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                if (videoId != null) {
                    youTubePlayer.loadVideo(videoId, 0);
                } else {
                    Toast.makeText(YouTubePlayerActivity.this, "Invalid Video URL", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String extractVideoIdFromUrl(String url) {
        String videoId = null;
        if (url != null && url.trim().length() > 0) {
            String regex = "v=([^&]+)";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                videoId = matcher.group(1);
            }
        }
        return videoId;
    }
}
