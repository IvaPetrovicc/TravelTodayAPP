package ba.sum.fpmoz.traveltoday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import ba.sum.fpmoz.traveltoday.R;

public class FirstActivity extends AppCompatActivity {

    Button buttonStart;
    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    private FirebaseAuth auth;

    @Override
    protected void onStart() {
        super.onStart();
        updateUI(auth.getCurrentUser());
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null && currentUser.getUid().equals("2VeAhZmXZrdJxDsd2W4cpsAo8xa2")) {
            startActivity(new Intent(this, AdminBottomBarActivity.class));
            finish();
        } else if (currentUser != null) {
            startActivity(new Intent(this, BottomBarActivity.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        auth = FirebaseAuth.getInstance();

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