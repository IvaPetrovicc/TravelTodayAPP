package ba.sum.fpmoz.traveltoday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ba.sum.fpmoz.traveltoday.R;

public class FirstActivity extends AppCompatActivity {

    Button buttonStart;
    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press back to exit the application", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}