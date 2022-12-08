package net.wdfeer.androidgame1;

import android.app.Activity;
import android.os.Bundle;
import net.wdfeer.androidgame1.databinding.MainActivityBinding;

public class MainActivity extends Activity {
    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(new GameView(this));
    }
}