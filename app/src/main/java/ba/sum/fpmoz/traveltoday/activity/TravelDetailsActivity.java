package ba.sum.fpmoz.traveltoday.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import ba.sum.fpmoz.traveltoday.R;

public class TravelDetailsActivity extends AppCompatActivity {

    ConstraintLayout clBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_details);

        clBack = findViewById(R.id.clBack);

        clBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BottomBarActivity.class);
            startActivity(intent);
        });
    }
}
